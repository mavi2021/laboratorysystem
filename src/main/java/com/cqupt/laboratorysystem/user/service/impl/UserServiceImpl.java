package com.cqupt.laboratorysystem.user.service.impl;

import com.cqupt.laboratorysystem.common.annotation.Log;
import com.cqupt.laboratorysystem.common.condition.SearchCondition;
import com.cqupt.laboratorysystem.common.exception.ServiceException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.user.condition.UserSearchCondition;
import com.cqupt.laboratorysystem.user.mapper.UserMapper;
import com.cqupt.laboratorysystem.user.entity.User;
import com.cqupt.laboratorysystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @create 2023/6/13 22:15
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Log
    public Result<Object> getListByPage(SearchCondition searchCondition) {
        UserSearchCondition baseSearchCondition = null;
        if (searchCondition instanceof UserSearchCondition) {
            baseSearchCondition = (UserSearchCondition) searchCondition;
            // 进行操作
        } else {
            // 处理类型不匹配的情况
            throw new ServiceException("搜索条件转换类型不匹配");
        }
        // 对搜索条件的有效性进行验证
        if (searchCondition.getCurrentPage() < 1 || searchCondition.getPageSize() < 1) {
            return Result.fail("无效的分页参数");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().like(baseSearchCondition.getName()!=null
                //根据用户姓名查询
                ,User::getUsername,baseSearchCondition.getName())
                //根据实验室名查询
                .eq(baseSearchCondition.getLaboratory()!=null
                        ,User::getLaboratory,baseSearchCondition.getLaboratory())
                //根据用户类型查询
                .eq(baseSearchCondition.getType()!=null,User::getType,baseSearchCondition.getType())
                .orderByAsc(User::getUsername);

        IPage<User> page = new Page<>(searchCondition.getCurrentPage(), searchCondition.getPageSize());
        try {
            page = baseMapper.selectPage(page, queryWrapper);
        } catch (Exception e) {
            return Result.error("查询用户列表失败：" + e.getMessage());
        }
        List<User> list = page.getRecords();
        long count = page.getTotal();
        // 更新用户操作日志
        //...
        // 记录成功的操作
        log.info("查询用户列表成功");
        return Result.success(list, count);
    }

    @Override
    @Log
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> add(User user) {
        try {
            // 检查用户是否存在
            User userInfo = getById(user.getId());
            if(userInfo != null){
                return Result.fail("用户已存在");
            }
            // 保存用户
            baseMapper.insert(user);
            // 更新用户操作日志
            //...
            // 记录成功的操作
            log.info("添加用户成功，用户ID为：{}", user.getId());
        } catch (Exception e) {
            log.info("添加用户失败：" + e.getMessage());
            throw new ServiceException("添加用户失败，" + e.getMessage(), e);
        }
        return Result.success("添加用户成功");
    }

    @Override
    @Log
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> deleteById(Long id) {
        try {
            // 检查用户是否存在
            User user = getById(id);
            if(user == null){
                return Result.fail("用户不存在");
            }
            // 删除用户
            baseMapper.deleteById(id);
            // 删除关联数据
            //...
            // 更新用户操作日志
            //...
        } catch (Exception e) {
            throw new ServiceException("删除用户失败，" + e.getMessage(), e);
        }
        return Result.success("删除用户成功");
    }

    @Override
    @Log
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> update(User user) {
        try {
            // 更新用户
            baseMapper.updateById(user);
            // 更新关联数据
            //...
            // 更新用户操作日志
            //...
        } catch (Exception e) {
            // 记录异常信息到日志中，并将异常信息作为异常的原因传递给 ServiceException
            throw new ServiceException("更新用户失败，" + e.getMessage(), e);
        }
        return Result.success("更新用户成功");
    }

    @Override
    @Log
    public Result<Object> queryById(Long id) {
        User user = null;
        try {
            // 检查用户是否存在
            user = getById(id);
            if(user == null){
                return Result.fail("用户不存在");
            }
            // 更新用户操作日志
            //...
        } catch (Exception e) {
            throw new ServiceException("查询用户失败，" + e.getMessage(), e);
        }
        return Result.success(user);
    }

    /**
     * 手动实现乐观锁，如需使用本方法，请关闭MybatisPlus的乐观锁
     * @param user
     * @return
     */
    @Log
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> updateWithOptimisticLock(User user) {
        try {
            // 查询当前用户信息
            User userInfo = baseMapper.selectById(user.getId());
            if(userInfo == null) {
                // 如果用户不存在，则直接返回错误码
                throw new ServiceException("用户不存在，更新失败");
            }
            if(user.getVersion() == null || userInfo.getVersion() == null)
                throw new ServiceException("版本号不能为空");
            // 设置版本号
            user.setVersion(userInfo.getVersion()+1);
            Integer curVersion = baseMapper.selectById(user.getId()).getVersion();
            if(!user.getVersion().equals(curVersion))
                throw new ServiceException("版本号不一致，更新失败");
            // 使用 updateById 方法进行更新
            baseMapper.updateById(user);
            // 更新关联数据
            //...
            // 更新用户操作日志
            //...
        } catch (Exception e) {
            // 记录异常信息到日志中，并将异常信息作为异常的原因传递给 ServiceException
            throw new ServiceException("更新用户失败：" + e.getMessage(), e);
        }
        return Result.success("更新用户成功");
    }

    @Override
    @Log
    @Transactional(rollbackFor = ServiceException.class)
    public Result<Object> register(User user) {
        try {
            // 校验用户名和手机号是否已经被注册过
            checkUsernameAndPhone(user.getUsername(), user.getPhone());
            // 注册用户
            baseMapper.insert(user);
            // 更新用户操作日志
            //...
        } catch (Exception e) {
            throw new ServiceException("注册用户失败，" + e.getMessage(), e);
        }
        return Result.success("注册用户成功");
    }



    /**
     * 校验用户名或手机号是否已经被注册过
     *
     * @param username 用户名
     * @param phone   手机号
     * @throws ServiceException 如果用户名或手机号已经被注册过，则抛出 ServiceException 异常
     */
    private void checkUsernameAndPhone(String username, String phone) throws ServiceException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).or().eq("phone", phone);
        int count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new ServiceException("用户名或手机号已经被注册过");
        }
    }


}
