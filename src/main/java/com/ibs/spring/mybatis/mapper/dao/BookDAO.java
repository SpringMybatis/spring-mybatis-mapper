package com.ibs.spring.mybatis.mapper.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ibs.spring.mybatis.mapper.model.Book;

/**
 * @author zhongjun Book-DAO接口
 */
public interface BookDAO {

	/**
	 * book数据插入数据库
	 * 
	 * @param oracleFlag 数据库标识
	 * @param bookList   书集合
	 * @throws DataAccessException
	 */
	public void insertBookList(boolean oracleFlag,List<Book> bookList) throws DataAccessException;

}
