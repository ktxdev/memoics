package com.ktxdev.memoics.repository;

import com.ktxdev.memoics.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
