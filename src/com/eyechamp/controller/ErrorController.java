package com.eyechamp.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;

	@RequestMapping(value = "/error")
	public String showError(HttpServletRequest request,	HttpServletResponse response, Model model) throws Exception {
		// retrieve some useful information from the request
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		model.addAttribute("statusCode", statusCode);

		//TODO Implement the logger

		//Only if server is in debug
		if(isDebug){
			Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
			if(throwable != null){
				model.addAttribute("message", throwable.getCause());

				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				throwable.printStackTrace(pw);
				model.addAttribute("stackTrace", sw.toString());
			}
		}
		return "error/error";

	}
}
