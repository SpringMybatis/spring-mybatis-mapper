package com.ibs.spring.mybatis.mapper.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.dao.DataAccessException;

import com.ibs.spring.mybatis.mapper.model.Book;

public interface BookMapper {

	
	/**
	 * book数据插入数据库
	 * 
	 * @param oracleFlag 数据库标识
	 * @param bookList   书集合
	 * @throws DataAccessException
	 */
	@Insert("insert into books(bk_id, bk_category, bk_title, bk_titlelang, bk_year, bk_price, bk_author, bk_logo) values (seq_book.nextval,'cs','数学','English','2015','88','zj','/src.jpg')")
	public void insertBook(Book book) throws DataAccessException;
	
}
