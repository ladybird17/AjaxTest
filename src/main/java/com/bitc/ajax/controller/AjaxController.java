package com.bitc.ajax.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.ajax.dto.CalDto;

/*
<AJAX 통신>
-예전의 통신 방법 : 동기방식, 클라이언트가 서버로 데이터를 보내면 서버가 신호를 받아서 응답을 주는 형태
-클라이언트가 서버로 신호를 보낸 후 응답을 받을 때 까지 어떠한 작업도 하지 않고 대기중으로 기다리고 있음
- 비동기 통신 : 클라이언트가 서버로 데이터를 보낸 후, 자신을 다른 필요한 작업을 계속 진행하고 서버에서 응답이 왔을 경우 이벤트(EventListener 또는 callback함수)가 동작하여 응답에 대한 작업을 처리하는 방식
- AJAX 통신 사용시 화면의 깜빡임(화면 리플레쉬) 없이 서버의 데이터를 불러올 수 있음.
 */
@Controller
public class AjaxController {
	
	@RequestMapping(value="/sync", method=RequestMethod.GET)
	public ModelAndView sync() throws Exception{
		ModelAndView mv = new ModelAndView("/ajax/sync");
		
		return mv;
	}
	
	@RequestMapping(value="/sync/cal", method=RequestMethod.GET)
	public ModelAndView cal(CalDto cal) throws Exception{
		ModelAndView mv = new ModelAndView("/ajax/cal");
		
		cal.setResult(cal.getNum1()+cal.getNum2());
		
		mv.addObject("cal", cal);
		
		return mv;
	}
	
	// /ajax/ajaxTest.html 페이지와 연결
	@RequestMapping(value="/async/ajaxTest", method=RequestMethod.GET)
	public String ajaxTestPage() throws Exception{
		return "/ajax/ajaxTest";
	}
	
	/*
	 restful방식 사용
	 @ResponseBody 어노테이션을 사용하면 return할 때 View를 반환하지 않고, 데이터 자체를 반환함
	 */
	@RequestMapping(value="/async/ajaxTest", method=RequestMethod.POST)
	@ResponseBody
	public Object ajaxTest(CalDto cal) throws Exception{
		/*
		HashMap은 키와 값이 1:1로 매칭되어 있는 데이터 타입
		하나의 변수명으로 여러개의 데이터를 저장할 수 있는 데이터 타입
		javascript의 object 타입과 유사함.
		 */
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num1", cal.getNum1());
		map.put("num2", cal.getNum2());
		map.put("result", cal.getNum1()+cal.getNum2());
		
		return map;
	}
	
}
