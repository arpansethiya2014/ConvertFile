package com.arpan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {
	
	@RequestMapping("/")
	public String viewHomePage()
	{
		System.out.println("In Home....!");
		return "index";
	}
	
	@RequestMapping("/csvPage")
	public String openCSVPage()
	{
		System.out.println("open CSV page....!");
		return "upload-csv";
	}
	
	@RequestMapping("/wav2mp4Page")
	public String openWAVPage()
	{
		System.out.println("open WAV page....!");
		return "upload-wav-mp4";
	}
	
}
