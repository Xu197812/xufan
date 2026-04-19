package com.xufan.mapper;

import com.xufan.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xufan
 * @since 2023-04-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("SELECT t1.name provice, t2.name city from t_province t1 join t_city t2 on t1.id = t2.parent_id")
    public List<Map<String, Object>> getMap();

    @Select("select * from user")
    public List<User> getAllUser();
}
