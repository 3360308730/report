package com.easychat.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easychat.domain.LoginUser;
import com.easychat.mapper.LoginUserMapper;
import com.easychat.service.ILoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxj
 * @since 2025-03-03
 */
@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements ILoginUserService {

    @Override
    public LoginUser findUserByUsername(String email){
        QueryWrapper<LoginUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", email);
        return getOne(queryWrapper);
    }

    @Override
    public SaResult login(String email, String password){
        LoginUser loginUser = findUserByUsername(email);
        if(loginUser == null){
            return SaResult.error("用户名不存在");
        }
        if(password.equals(loginUser.getPassword()))
            return SaResult.ok("登录成功");
        else
            return SaResult.error("密码错误");
    }
}
