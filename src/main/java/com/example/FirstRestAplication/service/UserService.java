package com.example.FirstRestAplication.service;

import com.example.FirstRestAplication.dto.UserRequest;
import com.example.FirstRestAplication.dto.UserResponse;
import com.example.FirstRestAplication.entity.UserEntity;
import com.example.FirstRestAplication.exception.UserNotFoundException;
import com.example.FirstRestAplication.mapper.UserMapper;
import com.example.FirstRestAplication.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest req){
        UserEntity entity = userMapper.mapToEntity(req, null);
        userRepository.save(entity);
        return userMapper.mapToResponse(entity);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::mapToResponse)
                .toList();
    }

    public UserResponse getUserById(Long id){
        UserEntity entity = userRepository.findById(id);
        if(entity == null) throw new UserNotFoundException("id: " + id);
        return userMapper.mapToResponse(entity);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public void changingUserStatus(Long id, Boolean status) {
        UserEntity entity = userRepository.findById(id);

        if (entity == null) {
            throw new UserNotFoundException("id: " + id);
        }
        userRepository.updateStatus(id, status);
    }
}