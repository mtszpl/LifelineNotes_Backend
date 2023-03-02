package com.example.notesbackend.user;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public String hi(){
        return "Hi, my name is:";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AppUser>> getById(@PathVariable("id") Integer id){
        System.out.println(id);
        return ResponseEntity.ok(userService.getById(id));
    }
}
