package com.Azadeh.library.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {

			//annotate the class as an entity and map it to db
			//define the fields
			//annotate the fields with db column names
			//set up mapping
			//create constructors
			//generate getter/setter methods
			//generate toString() method
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "author")
	private String author;

	@Column(name = "publication_year")
	private int publicationYear;
	

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST , CascadeType.MERGE ,
							CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "book_library",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn (name = "library_id")
			)
	private List<Library> libreries;

public Book() {
	
}

public Book(String bookTitle, String author, int publicationYear, List<Library> libreries) {
	super();
	this.bookTitle = bookTitle;
	this.author = author;
	this.publicationYear = publicationYear;
	this.libreries = libreries;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBookTitle() {
	return bookTitle;
}

public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getPublicationYear() {
	return publicationYear;
}

public void setPublicationYear(int publicationYear) {
	this.publicationYear = publicationYear;
}

public List<Library> getLibreries() {
	return libreries;
}

public void setLibreries(List<Library> libreries) {
	this.libreries = libreries;
}

@Override
public String toString() {
	return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", publicationYear=" + publicationYear
			+ ", libreries=" + libreries + "]";
}


	
}
