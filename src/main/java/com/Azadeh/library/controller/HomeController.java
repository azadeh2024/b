package com.Azadeh.library.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Azadeh.library.entity.Library;
import com.example.crud.entity.Employee;
import com.Azadeh.library.dao.LibraryDAO;

@Controller
public class HomeController {

	private LibraryDAO libraryDAO;
	
	public HomeController(LibraryDAO theLibraryDAO) 
	{
		
		libraryDAO = theLibraryDAO;
	}
	//create a mapping for "/hello"
	@GetMapping("/hello")
	public String sayHello(Model theModel)
	{
		
		theModel.addAttribute("theDate", new java.util.Date());
		return "hello";
	}
	@GetMapping("/list")
	public String listLibraries(Model theModel) 
	{
		
		// get the Library from db
		List<Library> theLibraries = libraryDAO.findAll();
		// add to the spring model
		
		theModel.addAttribute("libraries",theLibraries);
		return "libraries/list-libraries";
    	}

	 @GetMapping("/libraries/{libraryId}/books")
	    public String getBooksOfLibrary(@PathVariable("libraryId") int libraryId, Model model) 
	 {
		 
	        Library library = libraryDAO.findById(libraryId);
	        model.addAttribute("library", library);
	        model.addAttribute("books", library.getBooks());
	        return "libraries/books-list"; 
	  }
	
	 @GetMapping("/libraries/add")
	    public String showAddLibraryForm(Model model) {
	        // Create a new Library object and add it to the model
	        Library library = new Library();
	        model.addAttribute("library", library);
	        return "libraries/addLibraryForm";
	    }
	 
	 // Save the new library
	    @PostMapping("/libraries/save")
	    public String saveLibrary(@ModelAttribute("library") Library library) {
	        // Call the service method to save the library
	    	libraryDAO.save(library);
	        // Redirect to the library list page or any other page as needed
	        return "redirect:/list"; // Assuming you have a mapping for listing libraries
	    }
	    
	    @GetMapping("/libraries/delete/{libraryId}")
		public String deleteLibrary(@PathVariable("libraryId") int libraryId) {
		    // Call the service method to delete the library by its ID
		    libraryDAO.deleteById(libraryId);
		    // Redirect to the library list page or any other page as needed
		    return "redirect:/list"; // Assuming you have a mapping for listing libraries
		}
}
