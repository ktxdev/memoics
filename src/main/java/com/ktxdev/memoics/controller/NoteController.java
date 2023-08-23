package com.ktxdev.memoics.controller;

import com.ktxdev.memoics.model.Note;
import com.ktxdev.memoics.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("notes")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String notesListPage(Model model) {
        Collection<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("new")
    public String newNotePage(Model model) {
        model.addAttribute("note", new Note());
        return "newNote";
    }

    @PostMapping("new")
    public String saveNewNote(@Valid Note note, Errors errors) {
        if (errors.hasErrors()) {
            return "newNote";
        }

        noteService.save(note);
        return "redirect:/notes";
    }
}
