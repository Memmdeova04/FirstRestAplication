package com.example.FirstRestAplication.repository;

import com.example.FirstRestAplication.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(UserEntity user) {
        String sql = "INSERT INTO users (name, surname, age, email, password, fin_code, activity_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getAge(),
                user.getEmail(), user.getPassword(), user.getFinCode(), user.getActivityStatus());
    }
    public UserEntity findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.execute((Connection conn) -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return UserEntity.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .activityStatus(rs.getBoolean("activity_status"))
                        .build();
            }
            return null;
        });
    }

    public List<UserEntity> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                UserEntity.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .activityStatus(rs.getBoolean("activity_status"))
                        .build()
        );
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public void updateStatus(Long id, Boolean status) {
        String sql = "UPDATE users SET activity_status = ? WHERE id = ?";
        jdbcTemplate.update(sql, status, id);
    }
}