package com.evive.controller;

import com.evive.Service.PrimeNumberService;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

@Slf4j
@Component
public class ScheduledTasks implements SchedulingConfigurer {

    private PrimeNumberService primeNumberService;
    @Autowired
    public ScheduledTasks(PrimeNumberService primeNumberService) {
    this.primeNumberService = primeNumberService;
    }
    private Date cronToDate(String s){

      final CronSequenceGenerator generator = new CronSequenceGenerator( s);
      final Date nextExecutionDate = generator.next(new Date());
      return nextExecutionDate;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

      // fetching all the cronExpression with prime Number
    primeNumberService.getTasks ().stream ().forEach (  t->
    taskRegistrar.addTriggerTask (
        () ->  t.getPrimeNumber (),
        (TriggerContext triggerContext) -> cronToDate ( t.getCronExpression () )
    ) );


    }
}