package studentplatform.student_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentplatform.student_platform.dto.AuthRequest;
import studentplatform.student_platform.securityconfig.JwtUtil;

@RestController
@RequestMapping("/auth")   // better practice
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getName(),
                                request.getPass()
                        )
                );

        if (authentication.isAuthenticated()) {

            
            return jwtUtil.generateToken(authentication.getName());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
