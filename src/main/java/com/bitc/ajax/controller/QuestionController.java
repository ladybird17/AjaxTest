package com.bitc.ajax.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {
	
	@RequestMapping(value="/quiz/question2", method=RequestMethod.GET)
	public String quiz2() throws Exception {
		return "/quiz/question2";
	}

	@ResponseBody
	@RequestMapping(value="/quiz/emailList", method=RequestMethod.POST)
	public Object getEmailList() throws Exception {
		String[] emailList = {"@nate.com", "@naver.com", "@daum.net", "@gmail.com"};
		return emailList;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz/phoneList", method=RequestMethod.POST)
	public Object getPhoneList() throws Exception {
		String[] phoneList = {"010", "011", "017"};
		return phoneList;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz/telList", method=RequestMethod.POST)
	public Object getTelList() throws Exception {
		String[] telList = {"02", "031", "032", "033", "041", "042", "043", "044", "051", "052", "053", "061", "062", "063", "064"};
		return telList;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz/areaList1", method=RequestMethod.POST)
	public Object getArea1() throws Exception {
		String[] areaList = {"서울", "부산", "제주"};
		return areaList;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz/areaList2", method=RequestMethod.POST)
	public Object getArea2(@RequestParam Map<String, String> param) throws Exception {
		String areaName = param.get("areaName");
		String [] areaList = null;
		switch (areaName) {
		case "서울":
			areaList = new String[3];
			areaList[0] = "강북구";
			areaList[1] = "강남구";
			areaList[2] = "강서구";
			break;
			
		case "부산":
			areaList = new String[3];
			areaList[0] = "동래구";
			areaList[1] = "해운대구";
			areaList[2] = "부산진구";
			break;
			
		case "제주":
			areaList = new String[2];
			areaList[0] = "제주시";
			areaList[1] = "서귀포시";
			break;
		}

		return areaList;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz/areaList3", method=RequestMethod.POST)
	public Object getArea3(@RequestParam Map<String, String> param) throws Exception {
		String [][] area1 = {
				{"개포동", "논현동", "대치동"},
				{"미아동", "번동", "수유동"},
				{"가양동", "개화동", "공항동"}
		};
		String [][] area2 = {
			{"낙민동", "명륜동", "명장동"},
			{"반송동", "반여동", "석대동"},
			{"가야동", "개금동", "당감동"}
		};
		String [][] area3 = {
				{"건입동", "구좌동", "내도동"},
				{"강정동", "남원동", "대정동"}
		};
		
		String [] result = null;
		
		switch (param.get("areaName")) {
		case "강북구":
			result = area1[0];
		break;
		
		case "강서구":
			result = area1[1];
  		break;
		      
		case "강남구":
			result = area1[2];
  		break;
		      
		case "동래구":
			result = area2[0];
  		break;
		      
		case "해운대구":
			result = area2[1];
  		break;
		      
		case "부산진구":
			result = area2[2];
  		break;
		      
		case "제주시":
			result = area3[0];
  		break;
		      
		case "서귀포시":
			result = area3[1];
  		break;
		}
		
		return result;
	}
}
