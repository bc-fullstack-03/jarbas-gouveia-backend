package com.api.moments.services.user;

import com.api.moments.persistence.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(CreateUserRequest createUserRequest);

    List<User> getAll();

    boolean existsByUsernameAndEmail(String username, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User getUser(String email);

    User getUserById(UUID id);

    User updateUser(String token, UpdateUserRequest updateUserRequest);

    void addFollow(String token, String followId);

    void removeFollow(String token, String followId);

    boolean hasFollowed(String userId, String userIdToFollow);

}
