package com.cqupt.laboratorysystem.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.user.dao.UserMapper;
import com.cqupt.laboratorysystem.user.entity.User;
import com.cqupt.laboratorysystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @create 2023/6/13 22:15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
