package com.example.notesbackend.permissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, PermissionId> {

    public List<Permission> getByNote_Id(Integer noteId);

    public List<Permission> getByAppUser_Id(Integer userId);
}
