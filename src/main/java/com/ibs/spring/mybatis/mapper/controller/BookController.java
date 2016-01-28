package com.ibs.spring.mybatis.mapper.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibs.spring.mybatis.mapper.model.Book;
import com.ibs.spring.mybatis.mapper.service.BookService;
import com.ibs.spring.mybatis.mapper.util.XmlUtil;

/**
 * @author zhongjun
 * Book-Controller控制层
 * 
 */
@Scope(value = "prototype")
@Controller
@RequestMapping(value = "/book")
public class BookController {

	/**
	 * 注入service
	 */
	@Autowired
	private BookService bookService;
	
	// 图片计数器
	private static int count = 0;
	
	/**
	 * 日志
	 */
	private Logger log = Logger.getLogger(BookController.class);

	/**
	 * 书籍插入数据库
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "insertBookList.do")
	public void insertBookList(HttpServletRequest request,HttpServletResponse response) {
		try {
			// 获取书籍list
			List<Book> bookList = XmlUtil.getBookList();
			log.info("BookController insertBookList bookList:"+bookList);
			if(null!=bookList &&!bookList.isEmpty()){
				bookService.insertBookList(bookList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BookController insertBookList Exception:" + e);
		}
	}

	/**
	 * 下载网络图片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "downLoadJpeg.do")
	public void downLoadJpeg(HttpServletRequest request,HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 图片的保存路径
			String imagePath = request.getServletContext().getRealPath("/image");
			log.info("BookController downLoadJpeg imagePath:"+imagePath);
			// 获取图片logo路径
			Set<String> set = XmlUtil.getLogoPath();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String logo = it.next();
				log.info("BookController downLoadJpeg logo:"+logo);
				// 抓取图片
				getImage(imagePath,logo);
			}
			out.write("/image/"+(count-1)+".jpg");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BookController downLoadJpeg Exception:" + e);
		}
	}
	
	/**
	 * 抓取网上图片
	 * 
	 * @param imagePath   图片保存路径
	 * @param imageUrl    图片网上路径
	 * @throws Exception
	 */
	public void getImage(String imagePath,String imageUrl) throws Exception{
		InputStream myin = null;
		BufferedOutputStream myos = null;
		try {
			// 创建url
			URL myurl = new URL(imageUrl);
			// 建立链接
			URLConnection myconn = myurl.openConnection();
			// 设置过滤防盗链接
			myconn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 获取输入流
			myin = myconn.getInputStream();
			// 输出流--输出本地文件
			myos = new BufferedOutputStream(new FileOutputStream(imagePath+"/"+count+".jpg"));
			byte[] buff = new byte[1024];
			int num = 0;
			while ((num = myin.read(buff)) != -1) {
				myos.write(buff, 0, num);
				myos.flush();
			}
			count++;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BookController getImage Exception:"+e);
		} finally{
			// 关闭流
			if(myin!=null){
				myin.close();
			}
			if(myos!=null){
				myos.close();
			}
		}
	}
	
}
