package com.bit.backend.services.impl;

import com.bit.backend.dtos.*;
import com.bit.backend.entities.PrivilegeGroup;
import com.bit.backend.entities.PrivilegeGroupUser;
import com.bit.backend.entities.User;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.UserMapper;
import com.bit.backend.repositories.PrivilegeGroupRepository;
import com.bit.backend.repositories.PrivilegeGroupUserRepository;
import com.bit.backend.repositories.UserRepository;
import com.bit.backend.services.UserServiceI;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PrivilegeGroupRepository privilegeGroupRepository;
    private final PrivilegeGroupUserRepository privilegeGroupUserRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, PrivilegeGroupRepository privilegeGroupRepository, PrivilegeGroupUserRepository privilegeGroupUserRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.privilegeGroupRepository = privilegeGroupRepository;
        this.privilegeGroupUserRepository = privilegeGroupUserRepository;
    }

    @Override
    public UserDto login(CredentialsDto credentialsDto) {
        logger.debug("Entering in login Method...");
        User user = userRepository.findByLogin(credentialsDto.login()).orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto register(SignUpDto signUpDto) {
        Optional<User> oUser = userRepository.findByLogin(signUpDto.login()); // sidDto.getSidNo() -> findBySidNo(sidDto.getSidNo())

        if (oUser.isPresent()) {
            throw new AppException("User Already Exists", HttpStatus.BAD_REQUEST);
        }

        Optional<User> optionalUser = userRepository.findBySid(signUpDto.sid());

        if (optionalUser.isPresent()) {
            throw new AppException("Seafarer ID Already Registered", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
        user.setRole("SEAFARER"); /* only seafarers can register through the system*/
        User savedUser = userRepository.save(user);

        setDefaultAuthGroup(user.getId());

        return userMapper.toUserDto(savedUser);
    }

    private void setDefaultAuthGroup(Long userId) {
        Optional<PrivilegeGroup> optionalPrivilegeGroup = privilegeGroupRepository.getDefaultSeafarerGroup();
        if (optionalPrivilegeGroup.isEmpty()) {
//            throw new AppException("Default Privilege Group Not Exists", HttpStatus.BAD_REQUEST);
            return;
        }

        PrivilegeGroup privilegeGroup = optionalPrivilegeGroup.get();

        PrivilegeGroupUser privilegeGroupUser = new PrivilegeGroupUser();
        privilegeGroupUser.setAuthGroupId(privilegeGroup.getId().intValue());
        privilegeGroupUser.setUserId(userId.intValue());
        privilegeGroupUserRepository.save(privilegeGroupUser);
    }

    @Override
    public List<Integer> getAuthIds(long userId) {
        Optional<List<Integer>> optionalAuthIdLists = userRepository.findAuthIdsByUserId(userId);
        List<Integer> authIdLists = optionalAuthIdLists.get();

        return authIdLists;
    }

    @Override
    public SystemPrivilegeListDto getSystemPrivileges() {
        List<Tuple> tupleAvailableSystemPrivilegeLists = userRepository.getAvailableSystemPrivileges();
        List<Tuple> tupleAssignedSystemPrivilegeLists = userRepository.getAssignedSystemPrivileges();
        SystemPrivilegeListDto systemPrivilegeListDto = new SystemPrivilegeListDto();

        List<SystemPrivilegeDto> availableSystemPrivilegeLists = tupleAvailableSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        List<SystemPrivilegeDto> assignSystemPrivilegeLists = tupleAssignedSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        systemPrivilegeListDto.setSourcePrivileges(availableSystemPrivilegeLists);
        systemPrivilegeListDto.setTargetPrivileges(assignSystemPrivilegeLists);

        return systemPrivilegeListDto;
    }

    @Override
    public List<Integer> setSystemPrivileges(SystemPrivilegeListDto systemPrivilegeListDto) {

        return null;
    }

    @Override
    public boolean updatePassword(LoginDto loginDto, String password) {
        return this.updateUserPassword(loginDto, password);
    }

    public boolean updateUserPassword(LoginDto loginDto, String password) {
        User user = userRepository.findByLogin(
                loginDto.getUserName()).orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
        try {

            if (passwordEncoder.matches(CharBuffer.wrap(password.toCharArray()), user.getPassword())) {
                return false; // password not updated
            }

            user.setPassword(passwordEncoder.encode(CharBuffer.wrap(password.toCharArray())));
            userRepository.save(user);
            return true; // password updated
        } catch(Exception e) {
            throw new AppException("Error occurred! Please try again", HttpStatus.BAD_REQUEST);
        }
    }
}
