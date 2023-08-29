package com.ktxdev.memoics.controller;

import com.ktxdev.memoics.model.Note;
import com.ktxdev.memoics.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String notesListPage(Model model) {
        Collection<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "notes/index";
    }

    @GetMapping("new")
    public String newNotePage(Model model) {
        model.addAttribute("note", new Note());
        return "notes/new";
    }

    @PostMapping("new")
    public String newNote(@Valid Note note, Errors errors) {
        if (errors.hasErrors()) {
            return "notes/new";
        }

        noteService.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{noteId}")
    public String deleteNote(@PathVariable Long noteId) {
        noteService.deleteNote(noteId);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{noteId}")
    public String editNote(@PathVariable Long noteId, Model model, Principal principal) {
        Note note = noteService.getNoteById(noteId);
        model.addAttribute("note", note);
        return "notes/edit";
    }

    @PostMapping("edit/{noteId}")
    public String updateNote(@PathVariable Long noteId, @Valid Note note, Errors errors) {
        if (errors.hasErrors()) {
            return "notes/edit";
        }

        noteService.update(noteId, note);
        return "redirect:/notes";
    }

    @GetMapping("view/{noteId}")
    public String viewNote(@PathVariable Long noteId, Model model) {
        Note note = noteService.getNoteById(noteId);
        model.addAttribute("note", note);
        return "notes/view";
    }
}
