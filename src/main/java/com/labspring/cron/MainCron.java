package com.labspring.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainCron {
    @Scheduled(fixedRateString = "${config.fixedRateString}")
    public void scheduleFixedDelayTask(){
        log.info("Task: " + System.currentTimeMillis());
    }
}