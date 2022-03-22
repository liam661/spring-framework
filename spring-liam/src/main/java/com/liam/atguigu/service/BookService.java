package com.liam.atguigu.service;

import com.liam.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:06
 **/
@Service
public class BookService {
	@Qualifier("bookDao")
	@Autowired
	private BookDao bookDao;

	public void print(){
		System.out.println(bookDao);
	}
}
