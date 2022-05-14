package tw.com.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.book.service.IBookService;
import tw.com.book.service.ICashierService;

@Controller
public class BookController {

	@Autowired
	private IBookService iBookService;

	@Autowired
	private ICashierService iCashierService;

	public void buyBook() {
		iBookService.buyBook("1", "1001");
	}

	public void checkOut() {
		List<String> bids = new ArrayList<>();
		bids.add("1");
		bids.add("2");
		iCashierService.checkOut("1001", bids);
	}
}
