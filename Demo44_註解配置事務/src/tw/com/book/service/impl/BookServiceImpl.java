package tw.com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.dao.IBookDAO;
import tw.com.book.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDAO iBookDAO;

	@Transactional// 為了讓扣庫存、扣餘額視為同一個事務，所以在這個方法上加上註解
	@Override
	public void buyBook(String bid, String uid) {
		Integer price = iBookDAO.queryPrice(bid);
		iBookDAO.updateStock(bid);
		iBookDAO.updateBalance(uid, price);
	}
}
