package com.bitc.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitc.ajax.dto.AreaDto;

@Controller
public class UIController {
	@RequestMapping(value="/ui/selectBox", method=RequestMethod.GET)
	public String selectBox() throws Exception{
		return "/ui/selectBox";
	}
	

	 @RequestMapping(value="/ui/selectBox1", method=RequestMethod.POST)
	 //ResponseBody 주소 직접 던짐
	 @ResponseBody
	 public Object box1Selected(AreaDto area) throws Exception{
		 List<AreaDto> listArea = new ArrayList<AreaDto>();
		 
		 if(area.getAreaName().equals("서울")) {
			 AreaDto se1 = new AreaDto();
			 AreaDto se2 = new AreaDto();
			 AreaDto se3 = new AreaDto();
			 AreaDto se4 = new AreaDto();
			 se1.setAreaName("강북구");
			 se2.setAreaName("강서구");
			 se3.setAreaName("강남구");
			 se4.setAreaName("강동구");
			 
			 listArea.add(se1);
			 listArea.add(se2);
			 listArea.add(se3);
			 listArea.add(se4);
		 }
		 else if(area.getAreaName().contentEquals("대전")) {
			 AreaDto ad1 = new AreaDto();
			 AreaDto ad2 = new AreaDto();
			 AreaDto ad3 = new AreaDto();
			 AreaDto ad4 = new AreaDto();
			 ad1.setAreaName("동구");
			 ad2.setAreaName("서구");
			 ad3.setAreaName("중구");
			 ad4.setAreaName("유성구");
			 
			 listArea.add(ad1);
			 listArea.add(ad2);
			 listArea.add(ad3);
			 listArea.add(ad4);
		 }
		 else if(area.getAreaName().contentEquals("대구")) {
			 AreaDto se1 = new AreaDto();
			 AreaDto se2 = new AreaDto();
			 AreaDto se3 = new AreaDto();
			 AreaDto se4 = new AreaDto();
			 se1.setAreaName("북구");
			 se1.setAreaName("서구");
			 se1.setAreaName("남구");
			 se1.setAreaName("동구");
			 
			 listArea.add(se1);
			 listArea.add(se2);
			 listArea.add(se3);
			 listArea.add(se4);
		 }
		 else if(area.getAreaName().equals("부산")) {
			 AreaDto se1 = new AreaDto();
			 AreaDto se2 = new AreaDto();
			 AreaDto se3 = new AreaDto();
			 AreaDto se4 = new AreaDto();
			 se1.setAreaName("진구");
			 se1.setAreaName("해운대구");
			 se1.setAreaName("수영구");
			 se1.setAreaName("동래구");
			 
			 listArea.add(se1);
			 listArea.add(se2);
			 listArea.add(se3);
			 listArea.add(se4);
		 }
		 return listArea;
	 }
	 
	 @RequestMapping(value="/ui/join", method=RequestMethod.GET)
	 public String joinPage() throws Exception {
		 return "/ui/join";
	 }

}
