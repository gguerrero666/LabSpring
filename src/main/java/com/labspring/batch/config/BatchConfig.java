package com.labspring.batch.config;

import com.labspring.batch.processor.MyCustomProcessor;
import com.labspring.batch.reader.MyCustomReader;
import com.labspring.batch.task.Task1;
import com.labspring.batch.task.Task2;
import com.labspring.batch.task.Task3;
import com.labspring.batch.writer.MyCustomWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job createJob() {
//        return jobBuilderFactory.get("FirstJobExample")
//                .incrementer(new RunIdIncrementer())
//                .flow(createStep())
//                .next(step1())
//                .next(step2())
//                .next(step3())
//                .end()
//                .build();

        return jobBuilderFactory.get("SecondJobExample")
                .incrementer(new RunIdIncrementer())
                .start(createStep())
                .next(step1())
                .next(step2())
                .next(step3())
                .build();
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("MyStep")
                .<String, String>chunk(1)
                .reader(new MyCustomReader())
                .processor(new MyCustomProcessor())
                .writer(new MyCustomWriter())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("Step 1").tasklet(new Task1()).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("Step 2").tasklet(new Task2()).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("Step 3").tasklet(new Task3()).build();
    }

}
