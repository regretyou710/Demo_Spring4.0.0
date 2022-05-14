package tw.com.book.service;

import java.util.List;

public interface ICashierService {

	/**
	 * 結帳
	 * @param uid
	 * @param bids
	 */
	void checkOut(String uid, List<String> bids);
}
