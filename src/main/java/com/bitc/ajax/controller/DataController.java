package com.bitc.ajax.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//공공데이터 가져와서 사용하기
@Controller
public class DataController {
	// 기본적으로 접속할 페이지
	@RequestMapping(value="/data/pharmacyPage", method=RequestMethod.GET)
	public String pharmacyPage() throws Exception{
		return "/data/pharmacyPage";
	}
	
	//ResponseBody를 더 공부해보기
	@ResponseBody
	//key는 String, value는 Integer
	@RequestMapping(value="/data/pharmacyFullData", method=RequestMethod.POST)
	public Object getPharmacyFullData(@RequestParam Map<String, Integer> param) throws Exception{
		
		/*
		-StringBuffer는 자바의 문자열 처리 클래스 중 하나.
		-자바의 문자열 클래스인 String 클래스는 기본 자료형처럼 사용되지만
		메모리 낭비가 많은 자료형이다.
		-String 타입의 변수 2개(a = hello,b = world)가 있을 경우
		c = a + b를 하게 되면 사용자의 눈에는 문자열 변수 c에
		hello와 world가 합쳐져서 하나의 문자열이 되는 것처럼 보이나,
		실제로는 새로운 메모리 영역을 선언하고 
		거기에 helloworld라는 문자열을 생성하여 저장하는 형태임.
		-StringBuffer 클래스는 String 크래스의 메모리 낭비 부분을 해결한 클래스임.
		*/
		StringBuffer result = new StringBuffer();
		
		//rest api의 주소
		String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/";
		//요청할 명령어
		String serviceFunc = "getPharmacyFullDown?";
		//키 명령어
		String keyFunc = "serviceKey=";
		//요청할 페이지
		String pageNo = "&pageNo=";
		//한페이지당 결과수
		String rows = "&numOfRows=";
		
		//실제 사용자 인증키
		String serviceKey = "MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D";
		
		try {
			//위의 rest api 주소 및 명령, 옵션들을 하나의 주소로 합함.
			String urlStr = endPoint + serviceFunc + keyFunc + serviceKey + pageNo + param.get("page") + rows + param.get("row");
			//웹 주소 클래스. 생성자의 매개변수로 받은 문자열을 실제 접속가능한 URL로 변환해줌.
			URL url = new URL(urlStr); //URL로 만들기
			//자바에서 http 프로토콜을 이용하여 지정한 웹사이트에 접속하는 클래스
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			urlConn.setRequestMethod("GET");
			
			//BufferedReader : 메모리상(버퍼)에 있는 것을 읽는다.
			//데이터를 읽기 위한 메모리 버퍼 선언
			//접속한 사이트의 정보를 UTF-8 방식으로 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
			//InputStreamReader : 입력 메모리를 읽어옴
			
			String dataLine;
			
			
			while((dataLine = br.readLine())!=null) {
				result.append(dataLine+"\n"); //기존 문자열의 뒤에 추가로 문자열을 입력함.
			}
			
			urlConn.disconnect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
