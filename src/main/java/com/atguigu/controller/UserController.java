package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("login")
    public Result login(@RequestBody User user){
    Result result=userService.login(user);
    System.out.println("result= "+result);
    return result;
}
@GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
    Result result=userService.getUserInfo(token);
    return result;

}
@PostMapping("checkUserName")
    public Result checkUsername(@RequestParam String username){
    return userService.checkUsername(username);
}
@PostMapping("regist")
    public Result regist(@RequestBody User user){
    return userService.regist(user);
}
@GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){
    if(StringUtils.isEmpty(token)||jwtHelper.isExpiration(token)){
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }
    return Result.ok(null);
}



}
