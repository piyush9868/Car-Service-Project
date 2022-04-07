package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.business.bean.CarServiceBean;
import com.project.business.bean.PartsBean;
import com.project.dao.CarServiceDaoWrapper;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	CarServiceDaoWrapper carServiceDaoWrapper;

	@Override
	public CarServiceBean registerCarforService(CarServiceBean bean) {
		carServiceDaoWrapper.registerCarforService(bean);
		return null;
	}

	@Override
	public Map<Integer, String> populatePartsDetails(String carType) {
		
		Map<Integer,String> map = new HashMap<Integer, String>();
		List<PartsBean> list = carServiceDaoWrapper.populatePartsDetails(carType);
		map.put(null,"--SELECT--");
		for(PartsBean b : list) {
			Integer partId = b.getPartId();
			String partName = b.getPartName();
			
			map.put(partId, partName);
			
		}
		return map;
	}

	@Override
	public List<CarServiceBean> getAllCarServiceDetails() throws Exception{
		return carServiceDaoWrapper.getAllCarServiceDetails();
		
	}

	@Override
	public int getPartsPrice(int partId, String carType) {
		return carServiceDaoWrapper.getPartsPrice(partId, carType);
	}

	@Override
	public long countUser(String username) {
		return carServiceDaoWrapper.countUser(username);
	}

	
	
}
