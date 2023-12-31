package com.ktxdev.memoics.service;

import com.ktxdev.memoics.model.Note;

import java.util.Collection;

public interface NoteService {
    Collection<Note> getAllNotes();

    Note save(Note note);

    void deleteNote(Long noteId);

    Note getNoteById(Long noteId);

    Note update(Long noteId, Note note);
}
