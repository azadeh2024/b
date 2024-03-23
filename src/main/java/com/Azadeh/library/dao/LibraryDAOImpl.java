package com.Azadeh.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Azadeh.library.entity.Library;
import com.Azadeh.library.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class LibraryDAOImpl implements LibraryDAO {
	
	
	private EntityManager entityManager;
	
	//setup constructor Injection
	
	@Autowired
	public LibraryDAOImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Library> findAll()
	{
		// create a query
		TypedQuery<Library> theQuery = entityManager.createQuery(
				"from Library", Library.class);
				//execute query and get result list
		List<Library> libraries = theQuery.getResultList();

		//return the results
		return libraries;
	}

	@Override
	public Library findById(int theId) {
		
		//get library
		
		//return library
		
		Library theLibrary = entityManager.find(Library.class, theId);
		
		return theLibrary;
	}

	@Override
	@Transactional
	public void save(Library theLibrary) {
		entityManager.persist(theLibrary);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		Library tempLibrary = entityManager.find(Library.class, theId);
		
		// get the courses
		List<Book> books = tempLibrary.getBooks();
		// break association of all courses for the instructor
		for (Book tempBook : books) {
			tempBook.setLibreries(null);
		}
		//delete the instructor
		entityManager.remove(tempLibrary);
		
	}	
	
	

}
