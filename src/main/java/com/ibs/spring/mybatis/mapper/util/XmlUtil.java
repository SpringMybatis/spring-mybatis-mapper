package com.ibs.spring.mybatis.mapper.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ibs.spring.mybatis.mapper.model.Book;
import com.ibs.spring.mybatis.mapper.model.BookStore;
import com.thoughtworks.xstream.XStream;

@SuppressWarnings("unchecked")
public class XmlUtil {

	/**
	 * 根节点元素
	 */
	private static BookStore bookStore;

	// 启动解析xml
	static {
		Document document = null;
		SAXReader saxReader = null;
		try {
			// 使用SAX方式解析xml
			saxReader = new SAXReader();// 新建dom4j的一个阅读对象
			String path = XmlUtil.class.getResource("/xml/books.xml").getPath();
			// 把xml文件转换成文档对象
			document = saxReader.read(path);
			// 取得根节点
			Element rootNode = (Element) document.getRootElement();
			if (rootNode != null) {
				bookStore = new BookStore();
				// 获取所有的书节点
				List<Element> books = rootNode.elements();
				if (books != null && !books.isEmpty()) {
					List<Book> bookList = new ArrayList<Book>();
					for (int i = 0; i < books.size(); i++) {
						Book book = new Book();
						// 获得每个书节点
						Element bookElement = books.get(i);
						Attribute bookAttribute = bookElement.attribute("category");
						// 封装category
						book.setBookCategory(bookAttribute.getText());
						// title
						Element title = bookElement.element("title");
						Attribute titleLangAttribute = title.attribute("lang");
						book.setBookTitleLang(titleLangAttribute.getText());
						book.setBookTitle(title.getText());
						// year
						Element year = bookElement.element("year");
						book.setBookYear(Integer.valueOf(year.getText()));
						// price
						Element price = bookElement.element("price");
						book.setBookPrice(Double.valueOf(price.getText()));
						// logo
						Element logo = bookElement.element("logo");
						book.setBookLogo(logo.getText());
						// author
						List<Element> authors = bookElement.elements("author");
						String author = "";
						for (Iterator<Element> it = authors.iterator(); it
								.hasNext();) {
							Element authorElement = it.next();
							author = author + authorElement.getText() + ",";
						}
						if (StringUtils.isNotBlank(author)) {
							book.setBookAuthor(author.substring(0,
									author.length() - 1));
						}
						// 添加到bookList
						bookList.add(book);
					}
					// 封装bookStore
					bookStore.setBookList(bookList);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取bookstore对象
	 * 
	 * @return
	 */
	public static BookStore getBookStore() {
		return bookStore;
	}

	/**
	 * 获取书籍list
	 * 
	 * @return
	 */
	public static List<Book> getBookList() {
		if (null != bookStore) {
			return bookStore.getBookList();
		}
		return null;
	}

	/**
	 * 获取logo路径
	 * 
	 * @return
	 */
	public static Set<String> getLogoPath() {
		Set<String> logoSet = null;
		// 获取书籍的集合
		List<Book> bookList = getBookList();
		if (!bookList.isEmpty()) {
			logoSet = new HashSet<String>();
			for (Iterator<Book> it = bookList.iterator(); it.hasNext();) {
				Book book = it.next();
				logoSet.add(book.getBookLogo());
			}
		}
		return logoSet;
	}

	/**
	 * 测试--没有用junit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		BookStore b = getBookStore();
		XStream xstream = new XStream();
		xstream.alias("bookstore", BookStore.class);
		xstream.alias("book", Book.class);
		
		System.out.println(xstream.toXML(b));
		List<Book> list = getBookList();
		System.out.println(xstream.toXML(list));
		
		Set<String> set = getLogoPath();
		System.out.println(set.size());
		for(String s:set){
			System.out.println(s);
		}
	}
}
