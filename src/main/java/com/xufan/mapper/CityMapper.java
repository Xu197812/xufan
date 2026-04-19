package com.xufan.mapper;

import com.xufan.domain.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xufan
 * @since 2023-06-14
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {


    @Select("select * from city limit 496, 400")
    List<Map<String, Object>> getMap();

}
