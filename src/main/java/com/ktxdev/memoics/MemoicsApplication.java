package com.ktxdev.memoics;

import com.ktxdev.memoics.model.Note;
import com.ktxdev.memoics.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MemoicsApplication implements CommandLineRunner {

    @Autowired
    private NoteRepository noteRepository;

    public static void main(String[] args) {
        SpringApplication.run(MemoicsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Note note1 = Note.builder()
                .title("Lorem Ipsum Note")
                .content("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type " +
                        "specimen book")
                .build();

        Note note2 = Note.builder()
                .title("Sample Note")
                .content("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots" +
                        " in a piece of classical Latin literature from 45 BC, making it over 2000 years " +
                        "old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia," +
                        " looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical literature, " +
                        "discovered the undoubtable source.")
                .build();

        Note note3 = Note.builder()
                .title("Another Note")
                .content("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots" +
                        " in a piece of classical Latin literature from 45 BC, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical literature, " +
                        "discovered the undoubtable source.")
                .build();

        Note note4 = Note.builder()
                .title("Another Note Again")
                .content("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots" +
                        " in a piece of classical Latin literature from 45 BC, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical")
                .build();

        noteRepository.saveAll(Arrays.asList(note1, note2, note3, note4));
    }
}
