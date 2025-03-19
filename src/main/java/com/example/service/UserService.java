package com.example.service;

import com.example.adapter.entity.PosTblUserEntity;
import com.example.adapter.repository.PosTblUserRepository;
import com.example.dto.model.response.ApiResponse;
import com.example.dto.request.UserRequest;
import com.example.util.exception.DuplicateDataException;
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
                .createdBy("POS_USER")
                .build();
    }

    public ApiResponse<List<PosTblUserEntity>> getAllUser() {
        try {
            List<PosTblUserEntity> allUser =  posTblUserRepository.listAll();
            return new ApiResponse<>(Response.Status.OK.getStatusCode(), Response.Status.OK.getReasonPhrase(), allUser);
        }catch (Exception e){
            Log.error("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Internal server error");
        }
    }
}
