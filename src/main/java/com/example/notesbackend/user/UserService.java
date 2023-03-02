package com.example.notesbackend.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public Optional<AppUser> getById(Integer id){
        return userRepo.findById(id);
    }

    public Optional<AppUser> getByUsername(String username){ return userRepo.findByUsername(username); }
}
