package com.example.dto.request;

import com.example.util.enums.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Role role;
}
