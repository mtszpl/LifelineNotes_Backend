package com.example.notesbackend.notes;

import com.example.notesbackend.permissions.PermissionService;
import com.example.notesbackend.user.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {
    private final NoteService noteService;
    private final PermissionService permissionService;

    @GetMapping
    public String test(){
        return "EEE";
    }

    @GetMapping("/note={noteId}")
    public ResponseEntity<Note> getByID(@PathVariable("noteId") Integer noteId){
        AppUser loggedUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            permissionService.getByUserId(loggedUser.getId()).stream()
                    .filter(permission -> permission.getNoteId().equals(noteId)).toList()
                    .get(0);
        }
        catch (Exception e){
            return ResponseEntity.status(403).build();
        }
        try {
            Note note = noteService.findById(noteId);
            return ResponseEntity.ok(note);
        }
        catch (Exception e){
            return ResponseEntity.status(404).build();
        }

    }
}
