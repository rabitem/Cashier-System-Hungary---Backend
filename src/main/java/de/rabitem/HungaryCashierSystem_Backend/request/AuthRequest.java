package de.rabitem.HungaryCashierSystem_Backend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotNull(message = "Username can not be null")
    @NotEmpty(message = "Username can not be empty")
    // note: not blank annotation also performs not null and not empty check
    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotNull(message = "Password can not be null")
    @NotEmpty(message = "Password can not be empty")
    @NotBlank(message = "Password can not be blank")
    private String password;
}
