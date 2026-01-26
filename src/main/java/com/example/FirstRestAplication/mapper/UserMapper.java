package com.example.FirstRestAplication.mapper;
import com.example.FirstRestAplication.dto.UserRequest;
import com.example.FirstRestAplication.dto.UserResponse;
import com.example.FirstRestAplication.entity.UserEntity;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {
    public UserEntity mapToEntity(UserRequest req, Long id) {
        return UserEntity.builder()
                .id(id)
                .name(req.getName())
                .surname(req.getSurname())
                .age(req.getAge())
                .email(req.getEmail())
                .password(req.getPassword())
                .finCode(req.getFinCode())
                .activityStatus(true)
                .build();
    }
    public UserResponse mapToResponse(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .email(entity.getEmail())
                .activityStatus(entity.getActivityStatus())
                .build();
    }
}