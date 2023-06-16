package com.cqupt.laboratorysystem.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import com.cqupt.laboratorysystem.user.entity.User;

/**
 * @create 2023/6/13 22:14
 */
public interface UserService extends IService<User> {
    Result<Object> pageList(UserSearchCondition searchCondition);

    Result<Object> add(User user);

    Result<Object> deleteById(Long id);

    public Result<Object> update(User user);

    Result<Object> updateWithOptimisticLock(User user);

    Result<Object> register(User user);
}
