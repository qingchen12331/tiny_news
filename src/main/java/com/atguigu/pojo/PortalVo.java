package com.atguigu.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class PortalVo {
    private String KeyWords;
    private Integer type;
    private Integer pageNum=1;
    private Integer pageSize=10;
}
