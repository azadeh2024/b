package com.Azadeh.library.dao;

import java.util.List;

import com.Azadeh.library.entity.Library;

public interface LibraryDAO {
		
	List<Library> findAll();
	
	Library findById(int theId);
	
	void save (Library theLibrary);
	
	void deleteById(int theId);
}
