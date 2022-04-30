package com.yu.payservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RefreshScope //动态拉取nacos-server上的数据变化
public class PayController {

    @RequestMapping("/query")
    public String query() {
        System.out.println("请求到了query方法");
        return "已经请求到了payService的query方法";
    }

    @Value("${person.name}")
    private String name;

    @RequestMapping("/nacosConfig")
    public String nacosConfig() {
        System.out.println("配置信息："+this.name);
        return this.name;
    }
}
