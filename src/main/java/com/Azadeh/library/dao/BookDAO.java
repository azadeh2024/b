package com.Azadeh.library.dao;

import java.util.List;

import com.Azadeh.library.entity.Book;
import com.Azadeh.library.entity.Library;

public interface BookDAO {
	
	List<Book> findAll();
	
	Book findById(int theId);
	
	void save (Book theBook);
	
	void deleteById(int theId);
}
