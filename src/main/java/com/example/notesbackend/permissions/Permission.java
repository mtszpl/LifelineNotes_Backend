package com.example.notesbackend.permissions;

import com.example.notesbackend.notes.Note;
import com.example.notesbackend.user.AppUser;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "note_permissions")
@IdClass(PermissionId.class)
@AllArgsConstructor
public class Permission {

    @Id
    private Integer noteId;

    @Id
    private Integer userId;

    @ManyToOne
    @MapsId("noteId")
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Getter
    @Setter
    private String permission;
}
