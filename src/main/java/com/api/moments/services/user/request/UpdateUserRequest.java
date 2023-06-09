package com.api.moments.services.user.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UpdateUserRequest {
  private String username;
  private String email;
  private String password;
  private String role;
  private List<UUID> followers;
  private List<UUID> following;
  private List<UUID> moments;
}
