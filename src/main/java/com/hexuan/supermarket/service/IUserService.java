package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface IUserService extends IService<User> {
    public User getUserById(String userId);

    public int saveUser(User user);

    Map<String, Object> login(User user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);

    int removeUserById(String userId);
}
