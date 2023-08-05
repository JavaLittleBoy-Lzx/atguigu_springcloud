package com.lzx.springcloud.controller;

import com.lzx.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/4 18:29:22
 * @Version 1.0
 **/
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}
