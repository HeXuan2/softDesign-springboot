package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hexuan.supermarket.common.utils.JwtUtil;
import com.hexuan.supermarket.entity.User;
import com.hexuan.supermarket.mapper.BusinessMapper;
import com.hexuan.supermarket.mapper.CustomerMapper;
import com.hexuan.supermarket.mapper.UserMapper;
import com.hexuan.supermarket.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public Map<String, Object> login(User user) {
        //根据用户名和密码查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserId,user.getUserId());
        User loginUser = this.baseMapper.selectOne(wrapper);
        //结果不为空，并且密码和传入的密码匹配，生成一个token
        if(loginUser!=null && passwordEncoder.matches(user.getPassword(),loginUser.getPassword())){
            //生成的token太长：原因是userImg也在转化成了token字符串,导致前端获取token失效，请求不到后端,所以这里设置为空
            loginUser.setPassword(null);
            //创建jwt
            String token = jwtUtil.createToken(loginUser);

            //返回数据
            Map<String,Object> data=new HashMap<>();
            data.put("token",token);

            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 根据token获取用户信息，redis
        User loginUser = null;
        try {
            loginUser = jwtUtil.parseToken(token, User.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(loginUser != null){
            Map<String, Object> data = new HashMap<>();
            //查询当前用户信息
            User user=getUserById(loginUser.getUserId());
            data.put("user",user);
            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
    }

    @Override
    public int removeUserById(String userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        if (user.getRole()==1){
            customerMapper.saveCustomerByUser(user);
        } else if (user.getRole()==2) {
            businessMapper.saveBusinessByUser(user);

        }
        return userMapper.insert(user);
    }
}
