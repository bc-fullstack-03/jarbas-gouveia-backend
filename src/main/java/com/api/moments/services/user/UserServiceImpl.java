package com.api.moments.services.user;

import com.api.moments.persistence.entities.User;
import com.api.moments.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  @Override
  public User create(CreateUserRequest createUserRequest) {

    User user = new User(createUserRequest.getUsername(), createUserRequest.getEmail());
    user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

    return this.userRepository.save(user);
  }

  @Override
  public List<User> getAll() {
    return this.userRepository.findAll();
  }

  public boolean existsByUsername(String username) {
    return this.userRepository.existsByUsername(username);
  }

  public boolean existsByEmail(String email) {
    return this.userRepository.existsByEmail(email);
  }

  public boolean existsByUsernameAndEmail(String username, String email) {
    return this.userRepository.existsByEmail(email) || this.userRepository.existsByUsername(
        username);
  }

  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }

  public User getUserById(UUID id) {
    return userRepository.findById(id).orElse(null);
  }

}
