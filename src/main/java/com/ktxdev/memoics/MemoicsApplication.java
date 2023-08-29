package com.ktxdev.memoics;

import com.ktxdev.memoics.model.Note;
import com.ktxdev.memoics.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MemoicsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemoicsApplication.class, args);
    }
}
