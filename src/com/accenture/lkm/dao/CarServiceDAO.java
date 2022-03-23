package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.CarServiceEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = CarServiceEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface CarServiceDAO {
	
	
	CarServiceEntity save(CarServiceEntity entity);
	
	@Query(name="CAR.getAllServiceDetails")
	List<CarServiceEntity> getAllCarServiceDetails();
	
	
}
