package com.Azadeh.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Azadeh.library.entity.Book;
import com.Azadeh.library.entity.Library;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class BookDAOImpl  implements BookDAO  {
	
	
	private EntityManager entityManager;
	
	//setup constructor Injection
	
	@Autowired
	public BookDAOImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Book> findAll() {
		// create a query
		TypedQuery<Book> theQuery = entityManager.createQuery(
			"from Book", Book.class);
		
		//execute query and get result list
		List<Book> Books = theQuery.getResultList();

		//return the results
		return Books;
		
	}
	

	@Override
	public Book findById(int theId) {
		
		
		Book theBook = entityManager.find(Book.class, theId);
		
		return theBook;
	}
	
	@Transactional
	@Override
	public void save(Book theBook) {
		entityManager.persist(theBook);
		
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		

		Book tempBook = entityManager.find(Book.class, theId);
		
		List<Library> libraries = tempBook.getLibreries();
		// get the courses
		// break association of all courses for the instructor
		for (Library tempLibrary : libraries) {
			tempLibrary.setBooks(null);
		}
		//delete the instructor
		entityManager.remove(tempBook);
	}

	
		
	}
	
	
