package tw.com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.dao.IBookDAO;
import tw.com.book.exception.MyException;
import tw.com.book.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDAO iBookDAO;

	@Override
	public void buyBook(String bid, String uid) {
		Integer price = iBookDAO.queryPrice(bid);
		iBookDAO.updateStock(bid);
		iBookDAO.updateBalance(uid, price);
	}
}
