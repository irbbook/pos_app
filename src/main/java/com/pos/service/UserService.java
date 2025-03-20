package com.pos.service;

import com.pos.adapter.entity.PosTblUserEntity;
import com.pos.adapter.repository.PosTblUserRepository;
import com.pos.dto.model.response.ApiResponse;
import com.pos.dto.request.UserRequest;
import com.pos.util.constants.UserConstants;
import com.pos.util.exception.DuplicateDataException;
import com.pos.util.exception.NotFoundException;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    PosTblUserRepository posTblUserRepository;

    @Transactional
    public ApiResponse<String> createUser(UserRequest request) {
        try {
            posTblUserRepository.persist(mapperUser(request));
            return new ApiResponse<>(Response.Status.CREATED.getStatusCode(), "User created successfully", null);
        } catch (PersistenceException e) {
            Log.error("Duplicate entry detected: " + e.getMessage());
            throw new DuplicateDataException("User already exists");
        } catch (Exception e) {
            Log.error("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Internal server error");
        }
    }

    private PosTblUserEntity mapperUser(UserRequest request) {
        return PosTblUserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .isActive(Boolean.TRUE)
                .createdBy(UserConstants.ROLE.USER)
                .build();
    }

    public ApiResponse<List<PosTblUserEntity>> getAllUser() {
        try {
            List<PosTblUserEntity> allUser = posTblUserRepository.listAll();
            return new ApiResponse<>(Response.Status.OK.getStatusCode(), Response.Status.OK.getReasonPhrase(), allUser);
        } catch (Exception e) {
            Log.error("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Internal server error");
        }
    }

    public ApiResponse<String> updateUser(String username, UserRequest request) {

        var existUser = posTblUserRepository.findByUsername(username);
        if (existUser == null) {
            throw new NotFoundException("User with username " + username + " not found");
        }
        existUser.setUsername(request.getUsername());
        existUser.setPassword(request.getPassword());
        existUser.setRole(request.getRole());
        existUser.setUpdatedBy("POS_USER");
        posTblUserRepository.persist(existUser);
        return new ApiResponse<>(Response.Status.NO_CONTENT.getStatusCode(), "User updated successful", null);
    }

    @Transactional
    public ApiResponse<String> deleteUser(String username) {
        var existUser = posTblUserRepository.findByUsername(username);
        if (existUser == null) {
            throw new NotFoundException("User with username " + username + " not found");
        }
        posTblUserRepository.delete("username",username);
        return new ApiResponse<>(Response.Status.NO_CONTENT.getStatusCode(), "User deleted successful", null);
    }
}
