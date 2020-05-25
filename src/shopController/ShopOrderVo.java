package shopController;

import java.util.Date;

public class ShopOrderVo {
	String order_number;
	String mId;
	String item_id;
	String item_category;
	String item_option;
	String mName;
	String phone;
	int order_num;
	String order_price;
	String get_name;
	String get_phone;
	String get_address;
	Date order_date;
	String order_status;
	
	public ShopOrderVo() {}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
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

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getOrder_price() {
		return order_price;
	}

	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}

	public String getGet_name() {
		return get_name;
	}

	public void setGet_name(String get_name) {
		this.get_name = get_name;
	}

	public String getGet_phone() {
		return get_phone;
	}

	public void setGet_phone(String get_phone) {
		this.get_phone = get_phone;
	}

	public String getGet_address() {
		return get_address;
	}

	public void setGet_address(String get_address) {
		this.get_address = get_address;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
}