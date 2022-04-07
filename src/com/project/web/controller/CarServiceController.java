package com.project.web.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.business.bean.CarServiceBean;
import com.project.service.CarService;
import com.project.service.CarServiceImpl;

@Controller
public class CarServiceController {

	@Autowired
	private CarService customerService;
	
	
	@RequestMapping(value = "/register.html" , method = RequestMethod.GET)
	public ModelAndView loadCarTypePage() {
		ModelAndView m = new ModelAndView();
		m.setViewName("cartype");
		return m;
		
	}
	
	
//	@ModelAttribute("partDetails")
	@RequestMapping(value = "/submitCarType.html" , method = RequestMethod.GET)
	public ModelAndView loadServiceRegistrationPage(@RequestParam("Cartype") String carType) {
		
		ModelAndView m = new ModelAndView();
		m.addObject("cartype",carType);
		CarServiceBean bean = new CarServiceBean();
		bean.setCarType(carType);
		m.addObject("servicebean",bean);
		m.addObject("carType",carType);
		
		
		Map<Integer,String> map = customerService.populatePartsDetails(carType);
		
		m.addObject("partDetails",map);	
		m.setViewName("serviceform");
		
		return m;
	}
	
	
	
	@RequestMapping(value = "submitform.html" , method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(@Valid @ModelAttribute("servicebean")CarServiceBean carServiceBean , BindingResult result)
	{
		ModelAndView mnv = new ModelAndView();
		
		if(result.hasErrors())
		{
			mnv.setViewName("serviceform");
			return mnv;
		}
		else {
		int price = customerService.getPartsPrice(carServiceBean.getPartId(), carServiceBean.getCarType());
		carServiceBean.setTotalRepairCost(price);
		mnv.addObject("price",price);
		customerService.registerCarforService(carServiceBean);
		mnv.setViewName("success");
		mnv.addObject("serviceId",carServiceBean.getServiceId());
		return mnv;
		}
		
	}
	
	@RequestMapping(value = "/display.html" , method = RequestMethod.GET)
	public String processReport(ModelMap map) throws Exception {
		
		List<CarServiceBean> list = customerService.getAllCarServiceDetails();
		map.addAttribute("beansList",list);
		return "report";
	}
	
	
	

	
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
