package com.nitesh.job.controller;

import com.nitesh.job.model.dto.JobDto;
import com.nitesh.job.service.JobService;
import com.nitesh.job.util.EntityDtoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;
 private static final Logger logger = LoggerFactory.getLogger(JobController.class);
    @GetMapping("all")
    public Flux<JobDto> all(){
        logger.info("All jobs are available for JobService :");
        Stream.of(jobService.allJobs()).forEach(System.out::println);
     return jobService.allJobs();
    }
    @GetMapping("search")
    public Flux<JobDto> search(@RequestParam Set<String> skills){
        return jobService.jobsBySkillsIn(skills);
    }
    @PostMapping("save")
    public Mono<JobDto> save(@RequestBody Mono<JobDto> jobDto){
        return jobService.save(jobDto);
    }

    @PostMapping("save/all")
    public Flux<JobDto> saveAll(@RequestBody Flux<JobDto> jobDto){
        return jobService.saveAll(jobDto);
    }


}
