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
	* 	PROPAGATION_REQUIRED(默認值):必須使用調用者的事務
	* 	PROPAGATION_REQUIRES_NEW:將調用者的事務掛起，不使用調用者的事務，使用新的事務進行處理(當作個別操作 進行結帳第一本書會扣款扣庫存成功，第二本會失敗)
	* 	PROPAGATION_REQUIRED：如果不存在外層事務，就主動創建事務；否則使用外層事務
	* 	PROPAGATION_SUPPORTS：如果不存在外層事務，就不開啟事務；否則使用外層事務
	* 	PROPAGATION_MANDATORY：如果不存在外層事務，就拋出異常；否則使用外層事務
	* 	PROPAGATION_REQUIRES_NEW：總是主動開啟事務；如果存在外層事務，就將外層事務掛起
	* 	PROPAGATION_NOT_SUPPORTED：總是不開啟事務；如果存在外層事務，就將外層事務掛起
	* 	PROPAGATION_NEVER：總是不開啟事務；如果存在外層事務，則拋出異常
	* 	PROPAGATION_NESTED：如果不存在外層事務，就主動創建事務；否則創建嵌套的子事務
	* 
	* isolation:在併發的情況下，操作數據的一種規定，如果沒有使用隔離層級這個屬性會"默認"和資料庫相同的隔離等級
	* 	讀未提交(髒讀):可以讀到自己以外的用戶對資料庫發出和自己相同請求下，未提交的數據，但如果讀到的資料其他用戶最後捨棄不用會變成讀到無用的數據(只針對表中的儲存格)
	* 	讀已提交(不可重複讀):一個事務只能看見已經提交事務所做的改變。因為同一事務的其他實例在該實例處理其間可能會有新的commit，所以同一select可能返回不同結果。
	* 				           自己在讀表中數據的時候，有其他人正在進行操作(commit)，每次讀出來的不一樣(只針對表中的儲存格)
	* 	可重複讀(幻讀):自己在讀表中"已經存在的"數據時，不讓其他人進行操作(commit)，但是其他用戶是新增數據，就會造成自己再次讀表的時候前後不一致(表中的一列)
	* 	串行化:自己在操作這條數據的過程中，其他請求不能對他進行操作，造成性能低消耗大
	* 
	* timeout:在事務強制回滾前最多可執行(等待)的時間
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
