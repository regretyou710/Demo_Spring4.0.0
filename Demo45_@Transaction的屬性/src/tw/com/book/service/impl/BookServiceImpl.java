package tw.com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.dao.IBookDAO;
import tw.com.book.service.IBookService;

//@Transactional
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDAO iBookDAO;

	/**
	* @Transactional:對方法中所有的操作作為一個事務進行管理
	* 在方法上使用，只對方法有效果
	* 在類上使用，對類中所有的方法都有效果
	* 
	* @Transactional中可以設置的屬性:
	* propagation:
	* 
	* isolation:
	* 
	* timeout:
	* 
	* readOnly:
	* 
	* rollbackFor|rollbackForClassName|noRollbackFor|noRollbackForClassName
	*/
	
	@Transactional// 為了讓扣庫存、扣餘額視為同一個事務，所以在這個方法上加上註解
	@Override
	public void buyBook(String bid, String uid) {
		Integer price = iBookDAO.queryPrice(bid);
		iBookDAO.updateStock(bid);
		iBookDAO.updateBalance(uid, price);
	}
}
