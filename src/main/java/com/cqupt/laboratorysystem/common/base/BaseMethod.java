package com.cqupt.laboratorysystem.common.base;

import com.cqupt.laboratorysystem.common.condition.SearchCondition;
import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.user.entity.User;

/**
 * @create 2023/6/18 0:39
 */
public interface BaseMethod<T> {
    public Result<Object> getListByPage(SearchCondition searchCondition);

    public Result<Object> add(T t);

    public Result<Object> deleteById(Long id);

    public Result<Object> update(T t);

    public Result<Object> updateWithOptimisticLock(T t);

    public Result<Object> queryById(Long id);

}
