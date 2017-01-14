package com.xiaojun.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.xiaojun.shiro.ShiroUtils;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private Producer producer;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");
		// ����������֤��
		String text = producer.createText();
		// ����ͼƬ��֤��
		BufferedImage image = producer.createImage(text);
		// ���浽shiro Session��
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}
	
	@RequestMapping("login")
	public void login(HttpServletResponse response) throws IOException {
		
	}
}
