package com.example.notesbackend.permissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, PermissionId> {

    public Permission getByNote_Id(Integer noteId);

    public Permission getByUser_Id(Integer userId);
}
