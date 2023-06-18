package com.cqupt.laboratorysystem.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.laboratorysystem.common.condition.SearchCondition;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @create 2023/6/18 0:28
 */
@Slf4j
 @SuppressWarnings("unchecked")
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity>  extends ServiceImpl<M, T> implements BaseMethod<T> {

    protected Class<T> currentMapperClass() {
        ResolvableType resolvableType = this.getResolvableType();
        return (Class<T>) this.getResolvableType().as(BaseServiceImpl.class).getGeneric(0).getType();
    }

    protected Class<T> currentModelClass() {
        ResolvableType resolvableType = this.getResolvableType();
        return (Class<T>) this.getResolvableType().as(BaseServiceImpl.class).getGeneric(1).getType();
    }

//    public BaseServiceImpl() {
//        super(); // 调用父类的构造方法，传递 Mapper 对象
//    }

    @Override
    public Result<Object> getListByPage(SearchCondition searchCondition) {
        return null;
    }

    @Override
    public Result<Object> add(T t) {
        String pojoName = t.getClass().getSimpleName();
        try {
            // 检查类是否存在
            T tInfo = getById(t.getId());
            if(tInfo != null){
                return Result.fail(pojoName+"已存在");
            }
            // 保存类
            baseMapper.insert(t);
            // 更新类操作日志
            //...
            // 记录成功的操作
            log.info("添加{}成功，{}ID为：{}", pojoName, pojoName, t.getId());
        } catch (Exception e) {
            log.info("添加{}失败：" + e.getMessage(), pojoName);
            throw new ServiceException("添加" + pojoName + "失败，" + e.getMessage(), e);
        }
        return Result.success("添加"+pojoName+"成功");
    }

    @Override
    public Result<Object> deleteById(Long id) {
        return null;
    }

    @Override
    public Result<Object> update(T t) {
        return null;
    }

    @Override
    public Result<Object> updateWithOptimisticLock(T t) {
        return null;
    }

    @Override
    public Result<Object> queryById(Long id) {
        return null;
    }

}
