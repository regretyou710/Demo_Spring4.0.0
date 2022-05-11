package tw.com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.book.service.IBookService;

@Controller
public class BookController {

	@Autowired
	private IBookService iBookService;

	public void buyBook() {
		iBookService.buyBook("1", "1001");
	}
}
