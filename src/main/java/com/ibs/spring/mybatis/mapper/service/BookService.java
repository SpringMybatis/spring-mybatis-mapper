package com.ibs.spring.mybatis.mapper.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ibs.spring.mybatis.mapper.model.Book;

/**
 * @author zhongjun Book-Service接口
 * 
 */
public interface BookService {

	/**
	 * book数据插入数据库
	 * 
	 * @param bookList
	 * @throws DataAccessException
	 */
	public void insertBookList(List<Book> bookList) throws Exception;

}
