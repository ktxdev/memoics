package com.ktxdev.memoics.service.impl;

import com.ktxdev.memoics.model.Note;
import com.ktxdev.memoics.repository.NoteRepository;
import com.ktxdev.memoics.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Collection<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }
}
