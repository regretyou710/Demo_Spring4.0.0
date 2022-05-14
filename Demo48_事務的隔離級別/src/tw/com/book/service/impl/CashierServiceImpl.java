package tw.com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.service.IBookService;
import tw.com.book.service.ICashierService;

@Transactional
@Service
public class CashierServiceImpl implements ICashierService {

	@Autowired
	private IBookService iBookService;

	@Override
	public void checkOut(String uid, List<String> bids) {
		// 結帳時透過買一本書的方法實現買多本書
		for (String bid : bids) {
			iBookService.buyBook(bid, uid);
		}
	}

}
