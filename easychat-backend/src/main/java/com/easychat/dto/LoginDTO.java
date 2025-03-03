package com.easychat.dto;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "用户名不能为空")
    private int username;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
