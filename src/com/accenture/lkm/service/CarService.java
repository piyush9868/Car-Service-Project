package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.CarServiceBean;

public interface CarService {
	
	CarServiceBean registerCarforService(CarServiceBean bean);
	Map<Integer,String> populatePartsDetails(String carType);
	List<CarServiceBean> getAllCarServiceDetails() throws Exception;
	long countUser(String username);
	public int getPartsPrice(int partId, String carType);
}