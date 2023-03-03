package com.example.notesbackend.permissions;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissionService {
    private final PermissionRepo permissionRepo;

    public List<Permission> getByUserId(Integer id){
        return permissionRepo.getByAppUser_Id(id);
    }

    public List<Permission> getByNoteId(Integer id){
        return permissionRepo.getByNote_Id(id);
    }

    public PermissionResponse addNewPermission(PermissionRequest request, Integer noteId){
        if(request.getPermissionType() == PermissionType.AUTHOR)
            return PermissionResponse.builder()
                    .isSuccessful(false)
                    .errorMessage("Can't set AUTHOR permission")
                    .build();
        Permission newPermission = Permission.builder()
                .accessPermission(request.permissionType)
                .userId(request.userId)
                .noteId(noteId)
                .build();
        permissionRepo.save(newPermission);
        return PermissionResponse.builder()
                .isSuccessful(true)
                .build();
    }
}
