package tw.com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	* propagation:A方法和B方法都有事務，當A調用B時，會將A中的事務傳播給B方法(B依賴於調用者A的事務)，B方法對於事務的處理方式就是事務的傳播行為
	* PROPAGATION_REQUIRED(默認值):必須使用調用者的事務
	* PROPAGATION_REQUIRES_NEW:將調用者的事務掛起，不使用調用者的事務，使用新的事務進行處理(當作個別操作 進行結帳第一本書會扣款扣庫存成功，第二本會失敗)
	* PROPAGATION_REQUIRED：如果不存在外層事務，就主動創建事務；否則使用外層事務
	* PROPAGATION_SUPPORTS：如果不存在外層事務，就不開啟事務；否則使用外層事務
	* PROPAGATION_MANDATORY：如果不存在外層事務，就拋出異常；否則使用外層事務
	* PROPAGATION_REQUIRES_NEW：總是主動開啟事務；如果存在外層事務，就將外層事務掛起
	* PROPAGATION_NOT_SUPPORTED：總是不開啟事務；如果存在外層事務，就將外層事務掛起
	* PROPAGATION_NEVER：總是不開啟事務；如果存在外層事務，則拋出異常
	* PROPAGATION_NESTED：如果不存在外層事務，就主動創建事務；否則創建嵌套的子事務
	* isolation:
	* 
	* timeout:
	* 
	* readOnly:
	* 
	* rollbackFor|rollbackForClassName|noRollbackFor|noRollbackForClassName
	*/
	
	@Transactional(propagation = Propagation.REQUIRED)// 為了讓扣庫存、扣餘額視為同一個事務，所以在這個方法上加上註解
	@Override
	public void buyBook(String bid, String uid) {
		Integer price = iBookDAO.queryPrice(bid);
		iBookDAO.updateStock(bid);
		iBookDAO.updateBalance(uid, price);
	}
}
