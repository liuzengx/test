package com.ts.module.stock.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.json.JSONUtil;
@Controller
public class UeditorController {
	
	@RequestMapping("/showUeditor.do")
	public String list1(HttpServletRequest request, HttpServletResponse response) {

		return "ueditor/list";
	}
	
	@RequestMapping("/mvc_shiro/saveUeditor.do")
	@ResponseBody
	public String saveUeditor(HttpServletRequest request, HttpServletResponse response) {

		return "ueditor/list";
	}
	
	/**
     * ueditor服务端统一接口
     * @param action 动作参数
     * @return obj
     */
    @RequestMapping(value = "ueditor/api")
    public Object api(String action) throws Exception {
        switch (action) {
            case "ueditor.config":
        		InputStream is =new FileInputStream("/js/ueditor/config.json");
                //InputStream is = LzxAdminApplication.class.getResourceAsStream("/ueditor/config.json");
                byte[] bytes;
                try {
                    int available = is.available();
                    bytes = new byte[available];
                    is.read(bytes);
                } catch (IOException e) {
                    throw new Exception("读取ueditor.config文件异常:" +  e.getMessage());
                }
                String s = new String(bytes, StandardCharsets.UTF_8);
                return JSONUtil.parseObj(s);
            case "uploadimage":
            case "uploadscrawl":
            case "catchimage":
            case "uploadvideo":
            case "uploadfile":
                //this.handle();

        }
        return null;
    }

    public void handle() throws Exception {
        HttpServletRequest request = HttpServletContextKit.getHttpServletRequest();
        HttpServletResponse response = HttpServletContextKit.getHttpServletResponse();
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
//        String rootPath0 = request.getSession().getServletContext().getRealPath( "/" );
//        log.debug("jar realPath={}", rootPath0);
        String rootPath = ClassUtil.getClassPath();
        log.debug("ueditor path={}", rootPath);
        out.write(new ActionEnter(request, rootPath).exec());
    }
}
