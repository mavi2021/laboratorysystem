package com.cqupt.laboratorysystem.common.base;

import com.cqupt.laboratorysystem.common.condition.SearchCondition;
import com.cqupt.laboratorysystem.common.dto.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @create 2023/6/19 21:10
 */
public interface BaseController1<T>{
    Result<Object> getListByPage(@Valid SearchCondition searchCondition);
    Result<Object> add(@Valid @RequestBody T t);
    Result<Object> delete(@PathVariable("id") @Valid Long id);
    Result<Object> update(@Valid @RequestBody T t);
    Result<Object> query(@PathVariable("id") @Valid Long id);
}
