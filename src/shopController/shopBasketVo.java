package shopController;

import java.util.Date;

public class shopBasketVo {
	String basket_serial;
	String mId;
	String item_id;
	String item_category;
	String item_option;
	int order_num;
	Date basket_date;
	
	public shopBasketVo() {}

	public String getBasket_serial() {
		return basket_serial;
	}

	public void setBasket_serial(String basket_serial) {
		this.basket_serial = basket_serial;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_option() {
		return item_option;
	}

	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public Date getBasket_date() {
		return basket_date;
	}

	public void setBasket_date(Date basket_date) {
		this.basket_date = basket_date;
	}
}
