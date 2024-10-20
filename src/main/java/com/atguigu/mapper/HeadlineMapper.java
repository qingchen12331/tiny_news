package com.atguigu.mapper;

import com.atguigu.pojo.Headline;
import com.atguigu.pojo.PortalVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author 27175
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-10-19 13:56:21
* @Entity com.atguigu.pojo.Headline
*/

public interface HeadlineMapper extends BaseMapper<Headline> {

    //自定义分页查询方法
    IPage<Map> selectPageMap(IPage<Headline> page,
                             @Param("portalVo") PortalVo portalVo);

    Map selectDetailMap(Integer hid);
}




