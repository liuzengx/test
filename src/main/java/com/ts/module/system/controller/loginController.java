package com.ts.module.system.controller;

import com.ts.module.system.service.ShiroService;
import com.exception.BaseException;
import com.ts.module.system.model.User;
import com.ts.module.utils.ModUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/10/10.
 */
@Controller
//@RequestMapping("/ITOA")
public class loginController{
    @Autowired
    private ShiroService shiroService;
    private Logger logger = Logger.getLogger(loginController.class);
    @RequestMapping(value = "/login")
    public String Login(HttpServletRequest request, Model model){
    	String path = request.getSession().getClass().getResource("/").getPath();
    	System.out.println("path： "+path);
        return "login";
    }
    @RequestMapping(value = "/index.do")
    public String Index(HttpServletRequest request, Model model){
    	Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Session session = subject.getSession();
        
        int userId = user.getUserId();
        String account = user.getAccount();
        String userName = user.getUserName();
        String sessionId= (String) session.getId();
        String hostIp = session.getHost();
        String startTime = ModUtil.dateToString(session.getStartTimestamp());
        String lastTime = ModUtil.dateToString(session.getLastAccessTime());
        
        System.out.println("用户："+SecurityUtils.getSubject().getPrincipal());
    	System.out.println("sessionId="+sessionId);
        System.out.println("HOST: "+hostIp);
        System.out.println("timeout: "+SecurityUtils.getSubject().getSession().getTimeout());
        System.out.println("start: "+startTime);
        System.out.println("最后一次登录时间： "+lastTime);
        
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("userName", userName);
        model.addAttribute("hm", hm);
        
        return "index";
    }
    /**
     * 验证登录
     * @param username
     * @param password
     * @param session
     * @return url
     */
   /* @RequestMapping(value = "/login")
    public String LoginSubmit(HttpServletRequest request,String username, String password, HttpSession session, Model model){
    	String mav=null;
        //主体,当前状态为没有认证的状态“未认证”
        Subject subject = SecurityUtils.getSubject();
        Session session2 = subject.getSession();
        User user1 = (User)subject.getPrincipal();
        // 登录后存放进shiro token
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        User user;
        //登录方法（认证是否通过）
        //使用subject调用securityManager,安全管理器调用Realm
        try {
            //利用异常操作
            //需要开始调用到Realm中
            subject.login(token);
            user = (User)subject.getPrincipal();
            SecurityUtils.getSubject().isPermitted("/readData");
            //session.setAttribute("user",subject);
          //获取session 
            //HttpSession session = request.getSession(); 
            // 获取session中所有的键值 
            Enumeration<String> attrs = session.getAttributeNames(); 
            // 遍历attrs中的
            while(attrs.hasMoreElements()){ 
            	// 获取session键值 
            	String name = attrs.nextElement().toString(); 
            	// 根据键值取session中的值 
            	Object vakue = session.getAttribute(name); 
            	// 打印结果
            	System.out.println("------" + name + ":" + vakue +"--------\n");
            	}
            
         
            System.out.println("sessionId="+SecurityUtils.getSubject().getSession().getId());
            System.out.println("用户名："+SecurityUtils.getSubject().getPrincipal());
            System.out.println("HOST: "+SecurityUtils.getSubject().getSession().getHost());
            System.out.println("timeout: "+SecurityUtils.getSubject().getSession().getTimeout());
            System.out.println("start: "+SecurityUtils.getSubject().getSession().getStartTimestamp());
            System.out.println("最后一次登录时间： "+SecurityUtils.getSubject().getSession().getLastAccessTime());
            
            mav="index";
        } catch (UnknownAccountException e) {
            model.addAttribute("message", "账号密码不正确");
            mav="login";
        }
        return mav;
    }*/
    @RequestMapping("homePade")
    public String home(HttpSession session){

        return "home";
    }
    @RequiresPermissions( "/readName" )
    @RequestMapping("/readName")
    public String readName(HttpSession session){

        return "name";
    }

    @RequestMapping("/readData")
    public String readData(){

        return "data";
    }


    @RequestMapping("nopermission")
    public String noPermission(){
        return "error";
    }
    @RequestMapping(value = "logout", method = RequestMethod.GET)  
   public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {  
    	 User user =(User)SecurityUtils.getSubject().getPrincipal();  
       // 如果已经登录，则跳转到管理首页  
       if(user != null){  
    	   SecurityUtils.getSubject().logout();  
       }  
       return "redirect:/login";  
   }  
    
    @ResponseBody
    @RequestMapping(value = "loguo")
    public String Loout(HttpServletRequest request,HttpServletResponse response){
    	Subject subject = SecurityUtils.getSubject();
        Session session2 = subject.getSession();
        User user1 = (User)subject.getPrincipal();
		System.out.println("ajax请求...");
		
		String str="sesioon撒旦阿斯顿";
		/*response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");*/
		String name="liu";
		 if(! "admin".equals(name)){
	            throw new BaseException("用户名错误");
	            //throw new ExpiredSessionException(msg);
	        }
		
    	return str;
    }
    
    
}
