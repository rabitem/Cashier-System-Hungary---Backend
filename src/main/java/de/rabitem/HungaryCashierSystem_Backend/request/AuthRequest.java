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
    @NotBlank(message = "Username can not be blank")
    @NotEmpty(message = "Username can not be empty")
    private String userName;

    @NotNull(message = "Password can not be null")
    @NotBlank(message = "Password can not be blank")
    @NotEmpty(message = "Password can not be empty")
    private String password;
}
