package com.example.notesbackend.notes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepo noteRepo;

    public Note findById(Integer id) {
        return noteRepo.findById(id).orElseThrow();
    }
}
