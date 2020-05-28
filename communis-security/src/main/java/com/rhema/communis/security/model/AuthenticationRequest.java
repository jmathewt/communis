package com.rhema.communis.security.model;

import com.rhema.communis.security.constraints.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class AuthenticationRequest {
    private static final long serialVersionUID = 6624726180748515507L;
    @Email(message = "Username must be a valid email address")
    private String username;
    @ValidPassword
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
