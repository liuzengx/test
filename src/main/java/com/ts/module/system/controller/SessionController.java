package com.ts.module.system.controller;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ts.module.system.dao.SSessionDao;
import com.ts.module.system.model.SSession;
import com.ts.module.system.service.SSessionService;
import com.ts.module.utils.ModUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SessionController {
	@Autowired
	private SSessionService sSessionService;
    
    @RequestMapping("showSessionList.do")
    public String list(Model model) {
    	List<HashMap<String,Object>> sessions =  sSessionService.querySessionByUserName(null);
        model.addAttribute("sessions", sessions);
        model.addAttribute("sessionCount", sessions.size());
        return "system/sessions/list";
    }

    //@RequestMapping("/{sessionId}/forceLogout")
    /*public String forceLogout(
            @PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
        try {
            Session session = sessionDAO.readSession(sessionId);
            if(session != null) {
                //session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);
            }
        } catch (Exception e) {ignore}
        redirectAttributes.addFlashAttribute("msg", "强制退出成功！");
        return "redirect:/sessions";
    }
   */
	
	@RequestMapping(value = "system/sessions/getList.do")
    @ResponseBody
    public HashMap<String, Object> queryList (HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String,Object> map=new HashMap<String,Object>();
		
        int page = Integer.parseInt(request.getParameter("offset"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        
		int total = sSessionService.queryListCount();
		
		 map.put("page", page);
		 map.put("pageSize", pageSize);
		 List<HashMap<String,Object>> list =  sSessionService.querySessionByUserName(map);
         
		result.put("rows", list);
		result.put("total", total);

        return result;
    }

}
