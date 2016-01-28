package com.ibs.spring.mybatis.mapper.model;

import java.io.Serializable;

/**
 * @author zhongjun
 * 书籍的实体类  model
 *
 */
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 书籍ID
	 */
	private int bookId;

	/**
	 * 书籍总类
	 */
	private String bookCategory;

	/**
	 * 书名
	 */
	private String bookTitle;

	/**
	 * 语言类型
	 */
	private String bookTitleLang;

	/**
	 * 书籍年份
	 */
	private int bookYear;

	/**
	 * 书价格
	 */
	private double bookPrice;

	/**
	 * 作者
	 */
	private String bookAuthor;

	/**
	 * logo
	 */
	private String bookLogo;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookTitleLang() {
		return bookTitleLang;
	}

	public void setBookTitleLang(String bookTitleLang) {
		this.bookTitleLang = bookTitleLang;
	}

	public int getBookYear() {
		return bookYear;
	}

	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookLogo() {
		return bookLogo;
	}

	public void setBookLogo(String bookLogo) {
		this.bookLogo = bookLogo;
	}

}
