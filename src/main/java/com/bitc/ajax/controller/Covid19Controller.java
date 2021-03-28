package com.bitc.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Covid19Controller {
	@RequestMapping(value="/data/covid19sidoList")
	public String covid19ListPage() throws Exception{
		return "/data/covid19sidoList";
	}
}
