package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.kh.practice.list.library.model.vo.Book;

public class BookController {

	private List bookList=new ArrayList();
	
	public BookController() {
		bookList.add(new Book("�ڹ��� ����", "���� ��", "��Ÿ", 20000)  );		
		bookList.add(new Book("���� ���� �˰���", "������","��Ÿ", 15000) );
		bookList.add(new Book("��ȭ�� ���", "������", "�ι�", 17500)  );
		bookList.add(new Book("�� ������", "�ڽſ�", "�Ƿ�", 21000)  );
		
	}
	
	public void insertBook(Book bk) {
		bookList.add(bk);
	}
	
	public ArrayList selectList() {
		
		
		return (ArrayList)bookList;
	}
	
	public ArrayList searchBook(String keyword) {
		
		ArrayList searchList=new ArrayList();
		
		for(int i=0;i<bookList.size();i++) {
			 if( ((Book)bookList.get(i)) .getTitle().contains(keyword) ) {
//				 System.out.println(((Book)bookList.get(i)) .getTitle().contains(keyword));
				 searchList.add( (bookList.get(i)) ) ;
			 }
		}
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		Book removeBook=new Book();
		
		for(int i=0;i<bookList.size();i++) {
			if( ((Book)bookList.get(i)).getTitle().equals(title) &&
			    ((Book)bookList.get(i)).getAuthor().equals(author)	) {
					removeBook=((Book)bookList.get(i));
					
					bookList.remove(i);
			}
		}
		
		return removeBook;
	}
	
	public int ascBook() {
		Collections.sort(bookList);
		
		
		return 1;
	}
	
	
	
}
