package com.hexuan.supermarket.mapper;

import com.hexuan.supermarket.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserById(String userId);
}
