package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Code;
import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.User;
import com.hexuan.supermarket.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Api(tags={"用户接口列表"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(Code.FAIL_CODE,"用户名或密码错误");
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
        Map<String,Object> data = userService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(Code.FAIL_CODE,"登录信息无效，请重新登录");
    }

    @ApiOperation("退出登录")
    @PostMapping("/loginOut")
    public Result<?> logout(@RequestHeader("token") String token){
        userService.logout(token);
        return Result.success();
    }

    @ApiOperation("通过用户Id查询用户")
    @GetMapping("/getUserById")
    public Result<User> getUserById(@RequestParam("userId") String userId) {
        User user= userService.getUserById(userId);
        if (user==null){
            Result.success(user,"查询用户失败，没有该用户的Id");
        }
        return Result.success(user,"查询用户成功");
    }

    @ApiOperation("新增用户")
    @PostMapping("/register")
    public Result<User> saveUser(@RequestBody User user){
        // 先检查数据库中是否已存在相同的主键值
        if (userService.getUserById(user.getUserId())!=null) {
            // 如果存在重复主键，可以抛出自定义异常或返回错误码给前端
            return Result.fail(Code.FAIL_CODE,"该用户已存在");
        }
        //对用户的密码做加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return Result.success(user,"用户注册成功");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser")
    public Result<User> removeUserById(@RequestParam("userId") String userId) {
        userService.removeUserById(userId);
        return Result.success("删除用户成功");
    }
}
