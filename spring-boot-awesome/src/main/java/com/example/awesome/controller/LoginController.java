package com.example.awesome.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: LoginController
 * @Description: 登录
 * @Author: lkv587
 * @Date: 2020/9/23 14:42
 **/
@RestController
@RequestMapping("/")
public class LoginController {


    /**
     * 获取图片验证码
     * @param response
     * @param session
     */
    @GetMapping("getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session){
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116,36);
        session.setAttribute("code",lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
