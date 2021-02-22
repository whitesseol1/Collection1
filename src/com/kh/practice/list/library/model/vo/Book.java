package com.kh.practice.list.library.model.vo;

import java.util.Objects;

public class Book implements Comparable<Book>{

	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Book) {
			Book b=(Book)o;
			     if(    title.equals(b.getTitle()) &&
					   author.equals(b.getAuthor()) 
	                  &&category.equals(b.getCategory()) 
	                  &&price==b.getPrice()  ) {
			        
	                	  return true;
			     }
        }
		
		
		return false;
	}
	
	@Override
	public int compareTo(Book b) {
		return title.compareTo(b.title);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title,author,category,price);
	}
}
