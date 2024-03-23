package com.Azadeh.library.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

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
@Table(name="library")

public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "library_name")
	private String libraryName;
	
	@Column(name = "location")
	private String location;


	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST , CascadeType.MERGE ,
							CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "book_library",
			joinColumns = @JoinColumn(name = "library_id"),
			inverseJoinColumns = @JoinColumn (name = "book_id")
			)
	private List<Book> books;
	
	public Library() {
		
	}

	public Library(String libraryName, String location, List<Book> books) {
		super();
		this.libraryName = libraryName;
		this.location = location;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", libraryName=" + libraryName + ", location=" + location + ", books=" + books
				+ "]";
	}

	
	
	
}
