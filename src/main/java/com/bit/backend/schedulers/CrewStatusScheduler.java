package com.bit.backend.schedulers;

import com.bit.backend.repositories.OnboardCrewRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class CrewStatusScheduler {
private final OnboardCrewRegistrationRepository repository;

    public CrewStatusScheduler(OnboardCrewRegistrationRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        deactivateExpiredCrew();
    }


    // second minute hour day month weekday → 00:00:00 every day
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Colombo")
    public void deactivateExpiredCrew() {
        Date today = truncateToMidnight(new Date());
        int updated = repository.markExpiredAsInactive(today);
    }

    private Date truncateToMidnight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}