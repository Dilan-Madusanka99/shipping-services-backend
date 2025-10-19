package com.bit.backend.dtos;

public record SignUpDto(String firstName, String lastName, String sid, String login, char[] password, String role, Long loginId) {
}
