package com.healthcare.identitymanagement.controller;

import com.healthcare.identitymanagement.domain.Role;
import com.healthcare.identitymanagement.service.UserService;
import com.healthcare.identitymanagement.service.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/identity/users")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        var user = userService.findById(id);
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findByRole(@RequestParam("role") Role role){
        var user = userService.findByRole(role);
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> finAll(){
        var user = userService.findAll();
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.save(userRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        userService.deleteAll();
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
