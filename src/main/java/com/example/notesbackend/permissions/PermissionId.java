package com.example.notesbackend.permissions;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class PermissionId implements Serializable {

    @Id
    @Column(name = "note_id")
    private Integer noteId;

    @Id
    @Column(name = "user_id")
    private Integer userId;
}
