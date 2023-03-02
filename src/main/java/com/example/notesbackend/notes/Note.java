package com.example.notesbackend.notes;

import com.example.notesbackend.permissions.Permission;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Table(name = "notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "authorid", nullable = false)
    private Integer authorId;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String title;

    @OneToMany(mappedBy = "note")
    private List<Permission> usersWithAccess;

}
