package com.cqupt.laboratorysystem.user.service.impl;

import com.cqupt.laboratorysystem.common.exception.ServiceException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.common.constants.UserConstants;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import com.cqupt.laboratorysystem.user.mapper.UserMapper;
import com.cqupt.laboratorysystem.user.entity.User;
import com.cqupt.laboratorysystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @create 2023/6/13 22:15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Result<Object> getUserList(UserSearchCondition searchCondition) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().like(searchCondition.getName()!=null
                //根据用户姓名查询
                ,User::getUsername,searchCondition.getName())
                //根据实验室名查询
                .eq(searchCondition.getLaboratory()!=null
                        ,User::getLaboratory,searchCondition.getLaboratory())
                //只查询未删除的数据
                .eq(User::getDeleted, searchCondition.getDeleted()!=null?searchCondition.getDeleted():UserConstants.NOT_DELETED)
//                .eq(User::getDeleted, 1)

                //根据用户类型查询
                .eq(searchCondition.getType()!=null,User::getType,searchCondition.getType());

        IPage<User> page = new Page<>(searchCondition.getCurrentPage(), searchCondition.getPageSize());
        page = baseMapper.selectPage(page, queryWrapper);
        List<User> list = page.getRecords();
        long count = page.getTotal();
        return Result.success(list, count);
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> addUser(User user) {
        try {
            save(user);
        } catch (Exception e) {
            throw new ServiceException("添加用户失败：" + e.getMessage(), e);
        }
        return Result.success("添加用户成功");
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> deleteUserById(Integer id) {
        try {
            this.removeById(id);
        } catch (Exception e) {
            throw new ServiceException("删除用户失败：" + e.getMessage(), e);
        }
        return Result.success("删除用户成功");
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> updateUser(User user) {
        try {
            this.updateById(user);
        } catch (Exception e) {
            throw new ServiceException("更新用户失败：" + e.getMessage(), e);
        }
        return Result.success("更新用户成功");
    }


}
