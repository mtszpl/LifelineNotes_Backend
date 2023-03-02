package com.example.notesbackend.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

    public Note getById(Integer id);
}