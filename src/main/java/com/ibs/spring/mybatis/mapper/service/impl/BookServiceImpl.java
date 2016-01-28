package com.ibs.spring.mybatis.mapper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibs.spring.mybatis.mapper.dao.BookDAO;
import com.ibs.spring.mybatis.mapper.mapper.BookMapper;
import com.ibs.spring.mybatis.mapper.model.Book;
import com.ibs.spring.mybatis.mapper.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	/**
	 * 注入dao
	 */
	@Autowired
	private BookDAO bookDAO;
	
	@Resource
	private BookMapper bookMapper;
	
	/**
	 * 数据库标识
	 */
	private boolean oracleFlag;
	
	/**
	 * 日志
	 */
	private Logger log = Logger.getLogger(BookServiceImpl.class);
	
	public boolean isOracleFlag() {
		return oracleFlag;
	}

	@Value("#{propertiesReader['DATABASE.SELETOR.ORACLE.TEST']}")
	public void setOracleFlag(boolean oracleFlag) {
		this.oracleFlag = oracleFlag;
	}

	public void insertBookList(List<Book> bookList) throws Exception {
		bookMapper.insertBook(null);
		log.info("BookServiceImpl insertBookList start...");
		this.bookDAO.insertBookList(oracleFlag,bookList);
		log.info("BookServiceImpl insertBookList end...");
	}

}
