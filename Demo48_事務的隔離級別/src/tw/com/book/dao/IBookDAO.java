package tw.com.book.dao;

public interface IBookDAO {

	/**
	 * 查詢書的價格
	 * 
	 * @param bid
	 */
	Integer queryPrice(String bid);

	/**
	 * 更新庫存
	 * 
	 * @param bid
	 */
	void updateStock(String bid);

	/**
	 * 更新餘額
	 * @param uid
	 * @param price
	 */
	void updateBalance(String uid, Integer price);
}
