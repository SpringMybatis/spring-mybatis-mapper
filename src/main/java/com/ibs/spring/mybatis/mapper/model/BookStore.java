package com.ibs.spring.mybatis.mapper.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhongjun
 * 书籍的实体类集合封装
 *
 */
public class BookStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 书 集合
	 * 
	 */
	private List<Book> bookList;

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
