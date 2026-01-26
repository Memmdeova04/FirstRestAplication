package com.example.FirstRestAplication.controller;

import com.example.FirstRestAplication.dto.API_RESPONSE;
import com.example.FirstRestAplication.dto.UserResponse;
import com.example.FirstRestAplication.dto.UserRequest;
import com.example.FirstRestAplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.FirstRestAplication.util.Constant.DELETED_MESSAGE;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/")
    public ResponseEntity<API_RESPONSE<UserResponse>> createUser(
            @Valid @RequestBody UserRequest req) {
        UserResponse resp = userService.createUser(req);
        return ResponseEntity.ok(API_RESPONSE.success(resp));
    }
    @GetMapping("/allUsers")
    public ResponseEntity<API_RESPONSE<List<UserResponse>>> getAllUsers() {
        List<UserResponse> resp = userService.getAllUsers();
        return ResponseEntity.ok(API_RESPONSE.success(resp));
    }
    @GetMapping("/{id}")
    public ResponseEntity<API_RESPONSE<UserResponse>> getUserById(
            @PathVariable Long id){
        UserResponse resp=userService.getUserById(id);
        return ResponseEntity.ok(API_RESPONSE.success(resp));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<API_RESPONSE<String>> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok(API_RESPONSE.success(DELETED_MESSAGE));
    }
    @PatchMapping("/{id}/userStatus")
    public ResponseEntity<API_RESPONSE<Boolean>> changingUserStatus(@PathVariable Long id
            , @RequestParam Boolean status){
        userService.changingUserStatus(id,status);
        return ResponseEntity.ok(API_RESPONSE.success(status));

    }
}