package com.nitesh.job;

import com.nitesh.job.model.dto.JobDto;
import com.nitesh.job.model.entity.Job;
import com.nitesh.job.repository.JobRepository;
import com.nitesh.job.service.JobService;
import com.nitesh.job.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootApplication
public class JobReactiveApplication {
 @Autowired

private static JobService jobService;

    public JobReactiveApplication(JobService jobService) {
        this.jobService = jobService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JobReactiveApplication.class, args);
       // Consumer<? super Flux<JobDto>> JobDto;
        System.err.println("Now  Hitting the DB..");
       // Stream.of(jobRepository.findAll().map(EntityDtoUtil::toDto)).forEach(System.out::println);
        Stream.of(jobService.allJobs()).forEach(System.out::println);
        System.err.println(" DB..");
    }

}
