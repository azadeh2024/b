package com.Azadeh.library.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Azadeh.library.dao.LibraryDAO;
import com.Azadeh.library.entity.Library;

@RestController
@RequestMapping("/apii")
public class LibraryRestController {

	private LibraryDAO libraryDAO;
	
	public LibraryRestController(LibraryDAO theLibraryDAO) {
		
		libraryDAO = theLibraryDAO;
	}
	
	@GetMapping("/librariess")
	public List<Library> findAll(){
		return libraryDAO.findAll();
	}
	
	@GetMapping("/libraries")
	public Library findById(){
		return libraryDAO.findById(1);
	}
}
