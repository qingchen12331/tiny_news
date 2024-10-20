package com.atguigu.controller;

import com.atguigu.pojo.Headline;
import com.atguigu.service.HeadlineService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private HeadlineService headlineService;
    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token){
        int userId=jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        Result result=headlineService.publish(headline);
        return result;

    }
    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid( @RequestParam Integer hid){
        Result result=headlineService.findHeadlineByHid(hid);
        return result;
    }
    @PostMapping("update")
    public Result update(@RequestBody Headline headline){
       Result result=headlineService.updateHeadline(headline);
       return result;
    }
    @PostMapping("removeByHid")
    public Result removeByHid(@RequestParam Integer hid){
        headlineService.removeById(hid);
        return Result.ok(null);
    }

}
