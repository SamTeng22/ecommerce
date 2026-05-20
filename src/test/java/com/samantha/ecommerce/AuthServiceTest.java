package com.samantha.ecommerce;

import com.samantha.ecommerce.config.JwtUtil;
import com.samantha.ecommerce.dto.LoginRequest;
import com.samantha.ecommerce.dto.RegisterRequest;
import com.samantha.ecommerce.dto.AuthResponse;
import com.samantha.ecommerce.model.User;
import com.samantha.ecommerce.repository.UserRepository;
import com.samantha.ecommerce.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthService authService;

    @Test
    void register_createsUserAndReturnsToken() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Samantha");
        request.setEmail("samantha@email.com");
        request.setPassword("password123");

        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("hashedpassword");
        when(jwtUtil.generateToken(anyString())).thenReturn("mock-jwt-token");
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArgument(0));

        AuthResponse response = authService.register(request);

        assertEquals("mock-jwt-token", response.getToken());
        assertEquals("samantha@email.com", response.getEmail());
        assertEquals("CUSTOMER", response.getRole());
    }

    @Test
    void register_throwsWhenEmailAlreadyExists() {
        RegisterRequest request = new RegisterRequest();
        request.setEmail("samantha@email.com");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(new User()));

        assertThrows(RuntimeException.class, () -> authService.register(request));
    }

    @Test
    void login_throwsOnInvalidPassword() {
        LoginRequest request = new LoginRequest();
        request.setEmail("samantha@email.com");
        request.setPassword("wrongpassword");

        User user = new User();
        user.setEmail("samantha@email.com");
        user.setPassword("hashedpassword");

        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", "hashedpassword")).thenReturn(false);

        assertThrows(BadCredentialsException.class, () -> authService.login(request));
    }
}