package com.api.moments.services.auth;

import com.api.moments.services.auth.request.AuthRequest;
import com.api.moments.services.auth.response.AuthResponse;
import com.api.moments.services.security.IJwtService;
import com.api.moments.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

  @Autowired
  private UserService userService;

  @Autowired
  private IJwtService jwtService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public AuthResponse authenticate(AuthRequest authRequest) {

    if (authRequest.getEmail() == null || authRequest.getPassword() == null)
      throw new IllegalArgumentException("Email or password is null");

    var user = userService.getUser(authRequest.getEmail());

    if (user == null) {
      throw new RuntimeException("User not found");
    }

    if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }

    var token = jwtService.generateToken(user.getId());

    var response = new AuthResponse();
    response.setUserId(user.getId());
    response.setToken(token);
    return response;
  }
}
