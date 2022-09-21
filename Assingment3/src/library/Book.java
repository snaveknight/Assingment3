package library;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book{
	Integer book_id;
	String goodreads_book_id;
	String best_book_id;
	String work_id;
	String books_count;
	String isbn;
	String isbn13;
	String authors;
	String original_publication_year;
	String original_title;
	String title;
	String language_code;
	String average_rating;
	String ratings_count;
	String work_ratings_count;
	String work_text_reviews_count;
	String ratings_1;
	String ratings_2;
	String ratings_3;
	String ratings_4;
	String ratings_5;
	String image_url;
	String small_image_url;
	public Book(int book_id, String goodreads_book_id, String best_book_id, String work_id, String books_count,
			String isbn, String isbn13, String authors, String original_publication_year, String original_title,
			String title, String language_code, String average_rating, String ratings_count, String work_ratings_count,
			String work_text_reviews_count, String ratings_1, String ratings_2, String ratings_3, String ratings_4,
			String ratings_5, String image_url, String small_image_url) {
		super();
		this.book_id = book_id;
		this.goodreads_book_id = goodreads_book_id;
		this.best_book_id = best_book_id;
		this.work_id = work_id;
		this.books_count = books_count;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.authors = authors;
		this.original_publication_year = original_publication_year;
		this.original_title = original_title;
		this.title = title;
		this.language_code = language_code;
		this.average_rating = average_rating;
		this.ratings_count = ratings_count;
		this.work_ratings_count = work_ratings_count;
		this.work_text_reviews_count = work_text_reviews_count;
		this.ratings_1 = ratings_1;
		this.ratings_2 = ratings_2;
		this.ratings_3 = ratings_3;
		this.ratings_4 = ratings_4;
		this.ratings_5 = ratings_5;
		this.image_url = image_url;
		this.small_image_url = small_image_url;
	}


	
	public Integer getBook_id() {
		return book_id;
	}



	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}



	public String getGoodreads_book_id() {
		return goodreads_book_id;
	}



	public void setGoodreads_book_id(String goodreads_book_id) {
		this.goodreads_book_id = goodreads_book_id;
	}



	public String getBest_book_id() {
		return best_book_id;
	}



	public void setBest_book_id(String best_book_id) {
		this.best_book_id = best_book_id;
	}



	public String getWork_id() {
		return work_id;
	}



	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}



	public String getBooks_count() {
		return books_count;
	}



	public void setBooks_count(String books_count) {
		this.books_count = books_count;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getIsbn13() {
		return isbn13;
	}



	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}



	public String getAuthors() {
		return authors;
	}



	public void setAuthors(String authors) {
		this.authors = authors;
	}



	public String getOriginal_publication_year() {
		return original_publication_year;
	}



	public void setOriginal_publication_year(String original_publication_year) {
		this.original_publication_year = original_publication_year;
	}



	public String getOriginal_title() {
		return original_title;
	}



	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLanguage_code() {
		return language_code;
	}



	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}



	public String getAverage_rating() {
		return average_rating;
	}



	public void setAverage_rating(String average_rating) {
		this.average_rating = average_rating;
	}



	public String getRatings_count() {
		return ratings_count;
	}



	public void setRatings_count(String ratings_count) {
		this.ratings_count = ratings_count;
	}



	public String getWork_ratings_count() {
		return work_ratings_count;
	}



	public void setWork_ratings_count(String work_ratings_count) {
		this.work_ratings_count = work_ratings_count;
	}



	public String getWork_text_reviews_count() {
		return work_text_reviews_count;
	}



	public void setWork_text_reviews_count(String work_text_reviews_count) {
		this.work_text_reviews_count = work_text_reviews_count;
	}



	public String getRatings_1() {
		return ratings_1;
	}



	public void setRatings_1(String ratings_1) {
		this.ratings_1 = ratings_1;
	}



	public String getRatings_2() {
		return ratings_2;
	}



	public void setRatings_2(String ratings_2) {
		this.ratings_2 = ratings_2;
	}



	public String getRatings_3() {
		return ratings_3;
	}



	public void setRatings_3(String ratings_3) {
		this.ratings_3 = ratings_3;
	}



	public String getRatings_4() {
		return ratings_4;
	}



	public void setRatings_4(String ratings_4) {
		this.ratings_4 = ratings_4;
	}



	public String getRatings_5() {
		return ratings_5;
	}



	public void setRatings_5(String ratings_5) {
		this.ratings_5 = ratings_5;
	}



	public String getImage_url() {
		return image_url;
	}



	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



	public String getSmall_image_url() {
		return small_image_url;
	}



	public void setSmall_image_url(String small_image_url) {
		this.small_image_url = small_image_url;
	}



	public Book(String next) {
		// TODO Auto-generated constructor stub
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}



	public Book(int i, Object object) {
		// TODO Auto-generated constructor stub
	}



	public static List<Book> bookList() throws FileNotFoundException {
		ArrayList<Book> BookList = new ArrayList<>();
		Scanner sc = new Scanner(new File("Assingment3/src/library/books.csv"));
		int counter = 0;
		while(sc.hasNext()){	
			Book book = new Book();	
						if(counter > 1) {
							//found this regex online
							String[] split = sc.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
							book.setBook_id(Integer.parseInt(split[0]));
							book.setGoodreads_book_id(split[1]);
							book.setBest_book_id(split[2]);
							book.setWork_id(split[3]);
							book.setBooks_count(split[4]);
							book.setIsbn(split[5]);
							book.setIsbn13(split[6]);
							book.setAuthors(split[7]);
							book.setOriginal_publication_year(split[8]);
							book.setOriginal_title(split[9]);
							book.setTitle(split[10]);
							book.setLanguage_code(split[11]);
							book.setAverage_rating(split[12]);
							book.setRatings_count(split[13]);
							book.setWork_ratings_count(split[14]);
							book.setWork_text_reviews_count(split[15]);
							book.setRatings_1(split[16]);
							book.setRatings_2(split[17]);
							book.setRatings_3(split[18]);
							book.setRatings_4(split[19]);
							book.setRatings_5(split[20]);
							book.setImage_url(split[21]);
							book.setSmall_image_url(split[22]);
						BookList.add(book);
						counter++;
						}							
			
		}
		sc.close();

		return BookList;
	}
	
//	public static List<Book> bookList() throws FileNotFoundException {
//		LinkedList<Book> BookList = new LinkedList<>();
//		Scanner sc = new Scanner(new File("src/library/books.csv"));
//		while(sc.hasNext()){	
//			Book book = new Book();	
//			String[] split = sc.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
//				book.setBook_id(split[0]);
//				book.setGoodreads_book_id(split[1]);
//				book.setBest_book_id(split[2]);
//				book.setWork_id(split[3]);
//				book.setBooks_count(split[4]);
//				book.setIsbn(split[5]);
//				book.setIsbn13(split[6]);
//				book.setAuthors(split[7]);
//				book.setOriginal_publication_year(split[8]);
//				book.setOriginal_title(split[9]);
//				book.setTitle(split[10]);
//				book.setLanguage_code(split[11]);
//				book.setAverage_rating(split[12]);
//				book.setRatings_count(split[13]);
//				book.setWork_ratings_count(split[14]);
//				book.setWork_text_reviews_count(split[15]);
//				book.setRatings_1(split[16]);
//				book.setRatings_2(split[17]);
//				book.setRatings_3(split[18]);
//				book.setRatings_4(split[19]);
//				book.setRatings_5(split[20]);
//				book.setImage_url(split[21]);
//				book.setSmall_image_url(split[22]);
//			BookList.add(book);
//		}
//		sc.close();
//
//		return BookList;
//	}
	

	public static ArrayList<Book> showTopTen() throws FileNotFoundException {
		ArrayList<Book> topTenList = new ArrayList<Book>();
		for(int i =1; i < 11; i++) {
			topTenList.add(bookList().get(i));
		}
		return topTenList;
	}
	
	
	public static Book bookSearch(String book_id, String isbn) throws FileNotFoundException {
		List<Book> tempList = bookList();
		for(Book sampleBook: tempList) {
			if(book_id.equals(sampleBook.getBook_id())) {
				return sampleBook;
			}else if (isbn.equals(sampleBook.getIsbn())) {
				return sampleBook;
			}
		}
		
		return null;	
	}

	
	public static Comparator<Book> AuthorComparatorAsc = new Comparator<Book>() {
		
		public int compare(Book b1, Book b2) {
			Integer BookAuthorOne = b1.getBook_id();
			Integer BookAuthorTwo = b2.getBook_id();
			return BookAuthorOne.compareTo(BookAuthorTwo);
		}
		
	};
	
	//I believe this is a binary search?
	public static Comparator<Book> AuthorComparatorDesc = new Comparator<Book>() {
		
		public int compare(Book b1, Book b2) {
			Integer BookAuthorOne = b1.getBook_id();
			Integer BookAuthorTwo = b2.getBook_id();
			return BookAuthorTwo.compareTo(BookAuthorOne);
		}
		
	};

	
	public static ArrayList<Book> authorDescending() throws FileNotFoundException{
		 Collections.sort(bookList(), Book.AuthorComparatorDesc);
		 ArrayList<Book> tempList = showTopTen();
		 System.out.println(tempList);
		return tempList;
	}
	
	//think about sorting whole list then pick top ten 
	public static ArrayList<Book> authorAscending() throws FileNotFoundException{	
			 Collections.sort(bookList(), Book.AuthorComparatorAsc);
			 ArrayList<Book> tempList = showTopTen();
		return tempList;
	}
	
//	  public int runBinarySearchIteratively(  
//			  ArrayList<Book> sortedArray, int key, int low, int high) {
//			  	int index = Integer.MAX_VALUE;         
//			  	while (low <= high) {         
//				  int mid = low  + ((high - low) / 2);     
//				  if (sortedArray[mid] < key) {					  
//					  low = mid + 1;     
//				  }
//				  else if (sortedArray[mid] > key) {				  
//			              high = mid - 1;         
//			 	   }
//				  else if (sortedArray[mid] == key) {
//			              index = mid;       
//			              break;        
//				  }    
//			 	}    
//			 			 return index; }
	
	public static void main(String[] args) throws FileNotFoundException {

		//showTopTen();
		ArrayList<Book> authorAsc = new ArrayList<Book>();
				authorAsc = authorAscending();
		System.out.println(authorAsc + "  line 523");


	}



	
	
	
	
	
	
	
	
	
}
