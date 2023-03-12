package com.nitesh.job.service;

import com.nitesh.job.model.dto.JobDto;
import com.nitesh.job.model.entity.Job;
import com.nitesh.job.repository.JobRepository;
import com.nitesh.job.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;

import java.util.Set;
import java.util.stream.Stream;

@Service
public class JobService {
    @Autowired
  private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Flux<JobDto> allJobs(){
        return this.jobRepository.findAll().map(EntityDtoUtil::toDto);
    }
    public Flux<JobDto> jobsBySkillsIn(Set<String> skills){

        return this.jobRepository.findBySkillsIn(skills).map(EntityDtoUtil::toDto );
    }

    public Mono<JobDto> save(Mono<JobDto> mono){
        return mono.map(EntityDtoUtil::toEntity)
                .flatMap(this.jobRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Flux<JobDto> saveAll(Flux<JobDto> jobDto) {
      /*  Flux<Job> jobs = jobDto.map(EntityDtoUtil::toEntity);
        Flux<Job> savedJobs = jobRepository.saveAll(jobs);
        return savedJobs.map(EntityDtoUtil::toDto);
*/
        return jobDto
                .map(EntityDtoUtil::toEntity)
                //.flatMap(jobRepository::saveAll)
                //Reference to 'saveAll' is ambiguous, both 'saveAll(Iterable<S>)' and 'saveAll(Publisher<S>)' match
                .flatMap(jobEntities -> jobRepository.saveAll((Iterable<Job>) jobEntities))
                .map(EntityDtoUtil::toDto);
    }
}
