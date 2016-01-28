package com.ibs.spring.mybatis.mapper.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ibs.spring.mybatis.mapper.dao.BookDAO;
import com.ibs.spring.mybatis.mapper.model.Book;

/**
 * @author zhongjun
 * Book-BookDAOImpl持久层实现
 */
@Repository
public class BookDAOImpl implements BookDAO{

	/**
	 * 注入sqlSession
	 */
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 命名空间
	 */
	private static final String BOOK_NAMESPACE = "com.ym.project.booksMapper.";
	
	/**
	 * 日志
	 */
	private Logger log = Logger.getLogger(BookDAOImpl.class);
	
	public void insertBookList(boolean oracleFlag,List<Book> bookList) throws DataAccessException {
		Iterator<Book> it = bookList.iterator();
		String sqlId = oracleFlag?"insertBookListOracle":"insertBookListMysql";
		log.info("BookDAOImpl insertBookList sqlId:"+sqlId);
		while(it.hasNext()){
			this.sqlSession.insert(BOOK_NAMESPACE+sqlId, it.next());
		}
	}

}
