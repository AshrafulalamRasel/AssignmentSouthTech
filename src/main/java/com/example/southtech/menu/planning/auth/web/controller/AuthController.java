package com.example.southtech.menu.planning.auth.web.controller;



import com.example.southtech.menu.planning.auth.constants.LoginConstant;
import com.example.southtech.menu.planning.auth.services.SignUpAndSignInService;
import com.example.southtech.menu.planning.auth.web.dto.request.LoginForm;
import com.example.southtech.menu.planning.auth.web.dto.request.SignUpForm;
import com.example.southtech.menu.planning.common.constants.AccessApiConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping(AccessApiConstant.PUBLIC)
public class AuthController {

    private final SignUpAndSignInService signUpAndSignInService;

    @PostMapping(LoginConstant.LOGIN)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        return ResponseEntity.ok(signUpAndSignInService.signIn(loginRequest));
    }

    @PostMapping(LoginConstant.SIGNUP)
    public ResponseEntity<String> registerUser(@RequestBody SignUpForm signUpRequest) {
        return signUpAndSignInService.signUp(signUpRequest);
    }

}
