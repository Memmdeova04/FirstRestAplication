package com.example.FirstRestAplication.service;

import com.example.FirstRestAplication.dto.UserRequest;
import com.example.FirstRestAplication.dto.UserResponse;
import com.example.FirstRestAplication.entity.UserEntity;
import com.example.FirstRestAplication.exception.UserNotFoundException;
import com.example.FirstRestAplication.mapper.UserMapper;
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
    private static  Map<Long, UserEntity> users = new HashMap<>();
    private static Long generatedUserId=0L;
    private final UserMapper userMapper;
    //post emeliyyati
    public UserResponse createUser(UserRequest req){
        Long id = ++generatedUserId;
        UserEntity entity=userMapper.mapToEntity(req,id);
        users.put(id,entity);
        return userMapper.mapToResponse(entity);
    }
    //get
    public List<UserResponse> getAllUsers() {
        return users.values()
                .stream()
                .map(userMapper::mapToResponse)
                .toList();
    }
    //getuserbyid
    public UserResponse getUserById(Long id){
        //TODO

//        if(entity==null){
//            throw new UserNotFoundException("id: " + id + " olan user yoxdur!");
//        }

        return userMapper.mapToResponse(
                Optional.ofNullable(users.get(id))
                        .orElseThrow(()->new UserNotFoundException("id: " + id)));
    }
    public void deleteUserById(Long id){
        if(!users.containsKey(id)){
            throw new UserNotFoundException("id: " + id + "olan user yoxdur!");
        }
        users.remove(id);
    }
    public void changingUserStatus(Long id, Boolean status){
        UserEntity entity=users.get(id);
        if(entity==null){
            throw new UserNotFoundException("id: " + id + " olan user yoxdur!");
        }
        entity.setActivityStatus(status);
        users.put(id,entity);
    }
    @PostConstruct
    public void init() {
        users= Stream.of(
                new UserEntity(++generatedUserId,"Lamiye","Memmedova",21,"lamiyeemail1@gmail.com","12348935795","7WK1CAB", true),
                new UserEntity(++generatedUserId,"Sema","Memmedova",23,"semaemail2@gmail.com","123474857","1XO2Z34", true),
                new UserEntity(++generatedUserId,"Ayan","Memmedova",26,"ayanemail3@gmail.com","78345871234","1XY2K34", true)
        ).collect(Collectors.toMap(
                UserEntity::getId,
                Function.identity(),
                (newVal,oldVal)->oldVal));
    }
}