package de.rabitem.HungaryCashierSystem_Backend.controller;

import de.rabitem.HungaryCashierSystem_Backend.request.AuthRequest;
import de.rabitem.HungaryCashierSystem_Backend.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(final JwtUtil jwtUtil, final AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/validateToken")
    public ResponseEntity<Boolean> isAuthenticated() {
        return ResponseEntity.ok(true);
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials! Please try again.");
        }
        return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getUserName()));
    }
}

