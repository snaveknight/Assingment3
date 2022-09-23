package a3;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class BookLibrary {

	public List<Book> bookListAL = new ArrayList<Book>();
	public List<Book> bookListLL = new LinkedList<Book>();
	public List<Book> topTen = new ArrayList<Book>();
	
	public String csvFilePath;
	
	public BookLibrary(String csvFilePath) throws IOException {
		this.csvFilePath = csvFilePath;
		this.createBook();
	}

	public List<Book> getBookListAL() {
		return bookListAL;
	}

	public void setBookListAL(List<Book> bookListAL) {
		this.bookListAL = bookListAL;
	}

	public List<Book> getBookListLL() {
		return bookListLL;
	}

	public void setBookListLL(List<Book> bookListLL) {
		this.bookListLL = bookListLL;
	}

	public String getCsvFilePath() {
		return csvFilePath;
	}

	public void setCsvFilePath(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	public void setTopTen(List<Book> topTen) {
		this.topTen = topTen;
	}
	
	public List<Book> getTopTen() {
		for(int i = 0; i < 10; i++) {
			topTen.add(bookListAL.get(i));
		}
		return topTen;
	}
	
	public Book getSearchIDLL(String searchString){
		Book searchResult = null;
		for (Book book : bookListLL) {
			if (book.getBook_id().equals(searchString)) {
				searchResult = book;
			}
		}
		return searchResult;
	}
	
	public Book getSearchISBNLL(String searchString){
		Book searchResult = null;
		for (Book book : bookListLL) {
			if (book.getIsbn().equals(searchString)) {
				searchResult = book;
			}
		}
		return searchResult;
	}

	public Book getSearchIDAL(String searchString){
		Book searchResult = null;
		return searchResult;	
	}

	public Book getSearchISBNAL(String searchString){
		Book searchResult = null;
		return searchResult;	
	}
	
	public void createBook() throws IOException {

		try (
				Reader reader = Files.newBufferedReader(Paths.get(this.csvFilePath));
			) {

				CsvToBean<Book> books = new CsvToBeanBuilder<Book>(reader)
						.withType(Book.class)
						.withIgnoreLeadingWhiteSpace(true)
						.build();
				
				Iterator<Book> booksIterator = books.iterator();
				
				while (booksIterator.hasNext()) {
					Book currentBook = booksIterator.next();
					Book book = new Book();
					book.setBook_id(currentBook.getBook_id());
					book.setGoodreads_book_id(currentBook.getGoodreads_book_id());
					book.setBest_book_id(currentBook.getBest_book_id());
					book.setWork_id(currentBook.getWork_id());
					book.setBooks_count(currentBook.getBooks_count());
					book.setIsbn(currentBook.getIsbn());
					book.setIsbn13(currentBook.getIsbn13());
					book.setAuthors(currentBook.getAuthors());
					book.setOriginal_publication_year(currentBook.getOriginal_publication_year());
					book.setOriginal_title(currentBook.getOriginal_title());
					book.setTitle(currentBook.getTitle());
					book.setLanguage_code(currentBook.getLanguage_code());
					book.setAverage_rating(currentBook.getAverage_rating());
					book.setRatings_count(currentBook.getRatings_count());
					book.setWork_ratings_count(currentBook.getWork_ratings_count());
					book.setWork_text_reviews_count(currentBook.getWork_text_reviews_count());
					book.setRatings_1(currentBook.getRatings_1());
					book.setRatings_2(currentBook.getRatings_2());
					book.setRatings_3(currentBook.getRatings_3());
					book.setRatings_4(currentBook.getRatings_4());
					book.setRatings_5(currentBook.getRatings_5());
					book.setImage_url(currentBook.getImage_url());
					book.setSmall_image_url(currentBook.getSmall_image_url());
					
					bookListAL.add(book);
					bookListLL.add(book);
				}
			}
	}
}
