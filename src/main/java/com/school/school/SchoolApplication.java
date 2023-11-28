package com.school.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }


//    @Scheduled(fixedDelay = 10000)
    public void schedule1() throws IOException, InterruptedException {

        System.out.println("schedler start: " + LocalDateTime.now());

        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\anush\\OneDrive\\Desktop\\file\\unprocessed");

        //List of all files and directories
        File filesList[] = directoryPath.listFiles();

//        for (File file : filesList) {

        for (int i=0; i<filesList.length; i++) {
            File file= filesList[i];

            Thread.sleep(2000);

            Optional<Path> pathOptional = Optional.of(
                    Files.move(
                            Path.of(file.getAbsolutePath()),
                            Path.of("C:\\Users\\anush\\OneDrive\\Desktop\\file\\completed\\" + file.getName())
                    ));

            if(pathOptional.isPresent()){
                System.out.println("file moved: " + file.getName());
            }else{
                System.out.println("error on move: " + file.getName());
            }
        }

    }

}
