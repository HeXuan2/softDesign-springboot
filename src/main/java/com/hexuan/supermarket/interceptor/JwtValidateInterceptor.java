package com.hexuan.supermarket.interceptor;

import com.alibaba.fastjson2.JSON;
import com.hexuan.supermarket.common.Code;
import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author hexuan
 * @Date 2023/8/29 0:28
 * @PackageName:com.hexuan.common.utils
 * @ClassName: JwtValidateInterceptor
 * @Description: TODO
 */

@Component
@Slf4j
public class JwtValidateInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 如果是注册或者登录页面的 URL，直接返回 true，跳过验证
        if (request.getRequestURI().equals("/supermarket/user/register")||
                request.getRequestURI().equals("/supermarket/user/login")) {
            return true;
        }
        String token  = request.getHeader("Authorization");

        log.debug(request.getRequestURI() + "需要验证： " + token);
        if(token != null){
            try {
                jwtUtil.parseToken(token);
                log.debug(request.getRequestURI() + "验证通过");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.debug(request.getRequestURI() + "验证失败，禁止访问");
        response.setContentType("application/json;charset=utf-8");
        Result<Object> fail = Result.fail(Code.FAIL_CODE, "jwt无效，请重新登录");
        response.getWriter().write(JSON.toJSONString(fail));
        return false; // 拦截
    }

}
