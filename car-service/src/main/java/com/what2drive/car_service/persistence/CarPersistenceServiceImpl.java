package com.what2drive.car_service.persistence;

import com.what2drive.car_service.CarId;
import com.what2drive.service_common.exceptions.tier_managers.PersistenceServiceExceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service @Transactional
public class CarPersistenceServiceImpl implements CarPersistenceService{
    @PersistenceContext private EntityManager entityManager;
    @Autowired private CarPersistenceServiceExceptionManager exceptionManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<CarDO> getDatabaseObjectClass() {
        return CarDO.class;
    }

    @Override
    public CarPersistenceServiceExceptionManager getExceptionManager() {
        return exceptionManager;
    }
}