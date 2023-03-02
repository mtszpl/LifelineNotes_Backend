package com.example.notesbackend.permissions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepo permissionRepo;

    public Permission getByUserId(Integer id){
        return permissionRepo.getByUser_Id(id);
    }
}
