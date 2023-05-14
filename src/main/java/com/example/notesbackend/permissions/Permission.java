package com.example.notesbackend.permissions;

import com.example.notesbackend.notes.Note;
import com.example.notesbackend.user.AppUser;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "note_permissions")
@IdClass(PermissionId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @Getter
    private Integer noteId;

    @Id
    @Getter
    private Integer userId;

    @ManyToOne
    @Getter
    @MapsId("noteId")
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private PermissionType accessPermission;
}
