package com.ji.common;

public interface NameFindableRepository<T> {

	T findByName(String name);

}
