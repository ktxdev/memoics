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

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public Note update(Long noteId, Note note) {
        Note persistedNote = getNoteById(noteId);
        persistedNote.setTitle(note.getTitle());
        persistedNote.setContent(note.getContent());
        return noteRepository.save(persistedNote);
    }

    @Override
    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note with id: " + noteId + " not found"));
    }
}
