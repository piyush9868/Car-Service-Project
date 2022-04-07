package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.business.bean.CarServiceBean;
import com.project.business.bean.PartsBean;
import com.project.entity.CarServiceEntity;
import com.project.entity.PartsEntity;

@Repository
@Transactional(value = "txManager")
public class CarServiceDaoWrapper {

	@Autowired
	private CarServiceDAO carServiceDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<CarServiceBean> getAllCarServiceDetails() throws Exception{ 
		
		
		List<CarServiceBean> listBean = new ArrayList<CarServiceBean>();
		try {
		List<CarServiceEntity> entity = carServiceDao.getAllCarServiceDetails();
		
		
		
		for(CarServiceEntity e : entity) {
			
			CarServiceBean bean = convertEntityToBean(e);
			listBean.add(bean);
		}
		}
		catch(Exception e){
			throw e;
		}
		
		return listBean;
	}
	
	public CarServiceBean registerCarforService(CarServiceBean bean) {
		
		CarServiceBean bean2 = null;
		try {
			CarServiceEntity e = convertBeanToEntity(bean);
			CarServiceEntity e2 = carServiceDao.save(e);
			bean2 = convertEntityToBean(e2);
			
		}
		catch(Exception e) {
			throw e;
		}
		
		return bean2;
	}
	
	public List<PartsBean> populatePartsDetails(String carType){
		
		List<PartsBean> list = new ArrayList<PartsBean>();
		try {
			Query query = entityManager.createNamedQuery("PARTS.populatePartsDetails");
			query.setParameter(1, carType);
			
			List<PartsEntity> listParts  = query.getResultList();
			
			for(PartsEntity p : listParts) {
				PartsBean b = new PartsBean();
				b.setPartName(p.getPartName());
				b.setPrice(p.getPrice());
				b.setPartId(p.getPartId());
				b.setCarType(p.getCarType());
				list.add(b);
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return list;
	}
	
	public long countUser(String username) {
		
		
		int count = 0;
		Query query = entityManager.createNamedQuery("COUNTUSERS");
		query.setParameter(1, username);
		
		List<CarServiceBean> list = query.getResultList();
		
		for(CarServiceBean b : list) {
			count++;
			
		}
		return count;
		
		
	}
	public int getPartsPrice(int partId, String carType) {
		if(carType.equals("Maruti")) {
			
			return 400;
		}
		else
			return 500;
	}
	
	
	
	// Utility Methods.......
	public static CarServiceBean convertEntityToBean(CarServiceEntity entity) {
		CarServiceBean customerBean = new CarServiceBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}
	public static CarServiceEntity convertBeanToEntity(CarServiceBean bean) {
		CarServiceEntity entity = new CarServiceEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
}
