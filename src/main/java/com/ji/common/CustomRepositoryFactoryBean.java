package com.ji.common;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class CustomRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
extends JpaRepositoryFactoryBean<T, S, ID> {
	
	
	protected RepositoryFactorySupport  createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);
	}

}