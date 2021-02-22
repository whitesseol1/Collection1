package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	
	private Scanner sc=new Scanner(System.in);
	private BookController bc=new BookController();

	public void mainMenu() {
		   while(true) {
			   System.out.println("== Welcome KH Library ==");
			   System.out.println("1. �� ���� �߰�");
			   System.out.println("2. ���� ��ü ��ȸ");
			   System.out.println("3. ���� �˻� ��ȸ");
			   System.out.println("4. ���� ����");
			   System.out.println("5. ���� �� �������� ����");
			   System.out.println("9. ����");
			   System.out.print("�޴� ��ȣ ���� :");
			   		int cho=sc.nextInt();
			   			switch(cho) {
			   				  case  1 : insertBook(); break;
						      case  2 : selectList(); break;
						      case  3 : searchBook(); break;
						      case  4 : deleteBook(); break;
						      case  5 : ascBook(); break;
						      case  9 : System.out.println("���α׷��� �����մϴ�."); return;
						      default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			      
			      			      
			            }
			   
		   }
		
	}
	
	public void insertBook() {
		
			sc.nextLine();
			System.out.print("1. ������ :");
			    String title=sc.nextLine();
			    
			System.out.print("2. ���ڸ� :");
				String author=sc.nextLine();
				
				String category1="";
				int category=0;
				boolean flag=false;
				     do{
			        System.out.print("�帣 �Է� (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ) :");
			        	  category=sc.nextInt();
				  	      category1="";
				  	      
				  	      	switch (category) {
					  			case 1 : category1="�ι�"; flag=false; break;
					  			case 2 : category1="�ڿ�����"; flag=false; break;
					  		    case 3 : category1="�Ƿ�"; flag=false; break;
					  			case 4 : category1="��Ÿ"; flag=false; break;
					  			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���."); flag=true;
				             }
				}while(flag);
				
		   System.out.print("���� �Է�:");
			 int price=sc.nextInt();
		
			  
		Book b=new Book(title,author,category1,price);
		
		bc.insertBook(b);
		
	}
	
	public void selectList() {
		ArrayList<Book> bookList=bc.selectList();
		
		   if(bookList==null) {
			   System.out.println("�����ϴ� ������ �����ϴ�.");
		   }else {
			   for(Book b : bookList) {
				   System.out.println(b.toString()); //������� �ʴ� ���
			   }
		   }

	}
	
	public void searchBook() {
		sc.nextLine();
		
		System.out.print("�˻��� ������ :");
			String title=sc.nextLine();
			
			ArrayList<Book> searchList=bc.searchBook(title);//������ ����Ʈ�� ����	
		
				if(searchList==null) {
					System.out.println("�˻� ����� �����ϴ�.");
				}else {
					for( Book b : searchList) {
						System.out.println(b.toString());  //searchList�� ���� ������ ���
					}
				}
		
	}
	
	public void deleteBook() {
		sc.nextLine();
		
		System.out.print("������ ������ :");
		   String title=sc.nextLine();
		   
		System.out.print("������ ���ڸ� :");
		   String author=sc.nextLine();
		
		Book bookRemove=bc.deleteBook(title, author);
		
		if(bookRemove!=null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
		
	}
	
	public void ascBook() {
		
		int success=bc.ascBook();
		  if(success==1) {
			  System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		  }else {
			  System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		  }
		
		
	}
	
	
}
