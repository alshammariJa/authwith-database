package com.example.final_auth.Controller;

import com.example.final_auth.model.MyUser;
import com.example.final_auth.service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class MyUserController {
    private final MyUserService myUserService;

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(("Logged in successfully"));
    }
    @GetMapping("/all-users")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(myUserService.getAllUsers());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(myUserService.getUser(id));
    }
    @GetMapping("/my-user")
    public ResponseEntity getMyUser(@AuthenticationPrincipal MyUser auth){
        return ResponseEntity.status(200).body(myUserService.getUser(auth.getId()));
    }

    public ResponseEntity register(@Valid @RequestBody MyUser newUser){
        myUserService.addUser(newUser);
        return ResponseEntity.status(201).body(("User Created"));
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody @Valid MyUser newUser, @AuthenticationPrincipal MyUser auth){
        myUserService.updateUser(newUser , auth.getId());
        return ResponseEntity.status(200).body(("User Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        myUserService.deleteUser(id);
        return ResponseEntity.status(200).body(("User Deleted"));
    }
}
