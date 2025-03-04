package com.easychat.service.impl;

import com.easychat.service.ICaptchaService;
import com.easychat.service.ILoginUserService;
import com.easychat.vo.CaptchaVO;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CaptchaServiceImpl implements ICaptchaService {
    public CaptchaVO getCaptcha() {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(100, 43);
        String code = captcha.text();
        String checkCodeKey = UUID.randomUUID().toString();
        String checkCode = captcha.toBase64();
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCheckCode(checkCode);
        captchaVO.setCheckCodeKey(checkCodeKey);
        return captchaVO;
    }
}
