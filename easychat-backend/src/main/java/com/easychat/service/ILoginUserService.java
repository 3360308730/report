package com.easychat.service;

import cn.dev33.satoken.util.SaResult;
import com.easychat.domain.LoginUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxj
 * @since 2025-03-03
 */
public interface ILoginUserService extends IService<LoginUser> {
    LoginUser findUserByUsername(String email);
    SaResult login(String email, String password);
}
