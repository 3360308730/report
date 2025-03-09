package com.easychat.service.impl;

import com.easychat.domain.UserInfo;
import com.easychat.mapper.UserInfoMapper;
import com.easychat.service.IUserInfoService;
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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
