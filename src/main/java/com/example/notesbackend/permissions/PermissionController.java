package com.example.notesbackend.permissions;

import com.example.notesbackend.user.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@CrossOrigin
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("/user={id}")
    public List<Permission> getUserPermission(@PathVariable("id") Integer userId) {
        return permissionService.getByUserId(userId);
    }

    @GetMapping("/note={id}")
    public List<Permission> getNoteAccess(@PathVariable("id") Integer noteId) {
        return permissionService.getByNoteId(noteId);
    }

    @GetMapping()
    public List<Permission> getNotes(){
        AppUser loggedUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loggedUser.getPermissions();
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('AUTHOR')")
    public ResponseEntity<PermissionResponse> addPermission(
            @PathVariable("id") Integer noteId,
            @RequestBody PermissionRequest request
    ) {
        AppUser loggedUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Permission> permissions = loggedUser
                .getPermissions()
                .stream()
                .filter(userPermission -> (
                        userPermission.getNoteId().equals(noteId) &&
                                userPermission.getAccessPermission().equals(PermissionType.AUTHOR)))
                .collect(Collectors.toList());
        System.out.println(permissions);
        if(permissions.size() == 0)
            return ResponseEntity.status(403).build();

        return ResponseEntity.ok(permissionService.addNewPermission(request, noteId));
    }

}
