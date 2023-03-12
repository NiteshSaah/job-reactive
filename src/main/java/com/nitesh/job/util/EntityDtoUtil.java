package com.nitesh.job.util;

import com.nitesh.job.controller.JobController;
import com.nitesh.job.model.dto.JobDto;
import com.nitesh.job.model.entity.Job;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    private static final Logger logger = LoggerFactory.getLogger(EntityDtoUtil.class);
    public static JobDto toDto(Job job){
        JobDto dto = new JobDto();
        BeanUtils.copyProperties(job, dto);
        return dto;
    }

    public static Job toEntity(JobDto jobDto){
        Job job = new Job();
        BeanUtils.copyProperties(jobDto, job);
        logger.info("Created job " + job);
        return job;
    }
}
