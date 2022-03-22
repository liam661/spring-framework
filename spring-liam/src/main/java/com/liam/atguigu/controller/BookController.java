package com.liam.atguigu.controller;

import com.liam.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author liam661
 * @Date 2022/3/19 21:04
 **/
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
}
