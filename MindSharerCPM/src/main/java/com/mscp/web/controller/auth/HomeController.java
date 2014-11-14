package com.mscp.web.controller.auth;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mscp.web.model.ResponseModel;
import com.mscp.web.model.TimeLineUser;
import com.mscp.web.model.User;
import com.mscp.web.service.TimeLineService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/timeline")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TimeLineService service;
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody ResponseModel<List<TimeLineUser>> getTimeLine(HttpSession session){
		User myinfo = (User) session.getAttribute("myInfo");
		
		if(myinfo == null){
			//TODO Exception 처리
			logger.error("getTimeLine User is null");
		}
		
		List<TimeLineUser> result = service.selectAllWithUser(myinfo.getUid());
		
		ResponseModel<List<TimeLineUser>> resp = new ResponseModel<List<TimeLineUser>>();
		resp.setStatus(0);
		resp.setResult(result);
		
		return resp;
	}
	
}
