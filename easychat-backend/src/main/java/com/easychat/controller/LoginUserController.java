package com.easychat.controller;

import cn.dev33.satoken.util.SaResult;
import com.easychat.dto.LoginDTO;
import com.easychat.service.ICaptchaService;
import com.easychat.service.ILoginUserService;
import com.easychat.service.impl.CaptchaServiceImpl;
import com.easychat.vo.CaptchaVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxj
 * @since 2025-03-03
 */
@RestController
@RequestMapping("/account")
public class LoginUserController {

    @Resource
    private ILoginUserService loginUserService;
    @Resource
    private ICaptchaService easyCaptchaService;

    @GetMapping("/checkCode")
    public CaptchaVO getCheckCode(){
        return easyCaptchaService.getCaptcha();
    }

    @PostMapping("/login")
    public SaResult login(@RequestBody @Valid LoginDTO loginDTO){
        return loginUserService.login(loginDTO.getEmail(),loginDTO.getPassword());
    }

    @PostMapping("/register")
    public SaResult resister(@RequestBody @Valid LoginDTO loginDTO){
        return loginUserService.login(loginDTO.getEmail(),loginDTO.getPassword());
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }
}
