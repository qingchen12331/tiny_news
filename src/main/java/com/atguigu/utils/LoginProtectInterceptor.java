package com.atguigu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginProtectInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse respose,Object handler)throws Exception{
        String token =request.getHeader("token");
        if(StringUtils.isEmpty(token)||jwtHelper.isExpiration(token)){
            Result result=Result.build(null,ResultCodeEnum.NOTLOGIN);
            ObjectMapper objectMapper=new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            respose.getWriter().print(json);
            return false;
        }else{
            return true;
        }
    }


}
