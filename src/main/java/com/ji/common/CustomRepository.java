package com.ji.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ji.domain.Option;

public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{
	
	public Option<T> getOption(ID id);

}
