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
			   System.out.println("1. 새 도서 추가");
			   System.out.println("2. 도서 전체 조회");
			   System.out.println("3. 도서 검색 조회");
			   System.out.println("4. 도서 삭제");
			   System.out.println("5. 도서 명 오름차순 정렬");
			   System.out.println("9. 종료");
			   System.out.print("메뉴 번호 선택 :");
			   		int cho=sc.nextInt();
			   			switch(cho) {
			   				  case  1 : insertBook(); break;
						      case  2 : selectList(); break;
						      case  3 : searchBook(); break;
						      case  4 : deleteBook(); break;
						      case  5 : ascBook(); break;
						      case  9 : System.out.println("프로그램을 종료합니다."); return;
						      default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			      
			      			      
			            }
			   
		   }
		
	}
	
	public void insertBook() {
		
			sc.nextLine();
			System.out.print("1. 도서명 :");
			    String title=sc.nextLine();
			    
			System.out.print("2. 저자명 :");
				String author=sc.nextLine();
				
				String category1="";
				int category=0;
				boolean flag=false;
				     do{
			        System.out.print("장르 입력 (1.인문 / 2.자연과학 / 3.의료 / 4.기타) :");
			        	  category=sc.nextInt();
				  	      category1="";
				  	      
				  	      	switch (category) {
					  			case 1 : category1="인문"; flag=false; break;
					  			case 2 : category1="자연과학"; flag=false; break;
					  		    case 3 : category1="의료"; flag=false; break;
					  			case 4 : category1="기타"; flag=false; break;
					  			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); flag=true;
				             }
				}while(flag);
				
		   System.out.print("가격 입력:");
			 int price=sc.nextInt();
		
			  
		Book b=new Book(title,author,category1,price);
		
		bc.insertBook(b);
		
	}
	
	public void selectList() {
		ArrayList<Book> bookList=bc.selectList();
		
		   if(bookList==null) {
			   System.out.println("존재하는 도서가 없습니다.");
		   }else {
			   for(Book b : bookList) {
				   System.out.println(b.toString()); //비어있지 않는 경우
			   }
		   }

	}
	
	public void searchBook() {
		sc.nextLine();
		
		System.out.print("검색할 도서명 :");
			String title=sc.nextLine();
			
			ArrayList<Book> searchList=bc.searchBook(title);//임의의 리스트에 대입	
		
				if(searchList==null) {
					System.out.println("검색 결과가 없습니다.");
				}else {
					for( Book b : searchList) {
						System.out.println(b.toString());  //searchList에 값이 있으면 출력
					}
				}
		
	}
	
	public void deleteBook() {
		sc.nextLine();
		
		System.out.print("삭제할 도서명 :");
		   String title=sc.nextLine();
		   
		System.out.print("삭제할 저자명 :");
		   String author=sc.nextLine();
		
		Book bookRemove=bc.deleteBook(title, author);
		
		if(bookRemove!=null) {
			System.out.println("성공적으로 삭제되었습니다.");
		}else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
		
	}
	
	public void ascBook() {
		
		int success=bc.ascBook();
		  if(success==1) {
			  System.out.println("정렬에 성공하였습니다.");
		  }else {
			  System.out.println("정렬에 실패하였습니다.");
		  }
		
		
	}
	
	
}
