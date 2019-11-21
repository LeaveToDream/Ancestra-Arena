package org.klv.john.database;

interface DAO<T> { 
	  boolean create(T obj);
	  boolean delete(T obj);
	  boolean update(T obj);
	  
	  T load(int id);
}