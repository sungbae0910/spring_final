package shopController;

import java.util.ArrayList;

import java.util.List;

public class ShopItemVo {
	String mId;
	String item_serial;
	String item_id;
	int item_category;
	String item_optioin;
	String item_name;
	int item_price;
	String item_information;
	String category_name;
	String item_option;
	int option_name;
	String option_name_values;
	String option_value;
	String item_main_photo;
	String item_photo;
	String photo_serial;
	String like_serial;
	
	public String getLike_serial() {
		return like_serial;
	}

	public void setLike_serial(String like_serial) {
		this.like_serial = like_serial;
	}

	public String getmId() {
		return mId;
	}
	
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getItem_serial() {
		return item_serial;
	}

	public void setItem_serial(String item_serial) {
		this.item_serial = item_serial;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getItem_option() {
		return item_option;
	}

	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}

	public int getOption_name() {
		return option_name;
	}

	public void setOption_name(int option_name) {
		this.option_name = option_name;
	}

	public String getOption_name_values() {
		return option_name_values;
	}

	public void setOption_name_values(String option_name_values) {
		this.option_name_values = option_name_values;
	}

	public String getOption_value() {
		return option_value;
	}

	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}

	
	public ShopItemVo() {}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public int getItem_category() {
		return item_category;
	}

	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}

	public String getItem_optioin() {
		return item_optioin;
	}

	public void setItem_optioin(String item_optioin) {
		this.item_optioin = item_optioin;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_information() {
		return item_information;
	}

	public void setItem_information(String item_information) {
		this.item_information = item_information;
	}

	public String getItem_main_photo() {
		return item_main_photo;
	}

	public void setItem_main_photo(String item_main_photo) {
		this.item_main_photo = item_main_photo;
	}

	public String getItem_photo() {
		return item_photo;
	}

	public void setItem_photo(String item_photo) {
		this.item_photo = item_photo;
	}

	public String getPhoto_serial() {
		return photo_serial;
	}

	public void setPhoto_serial(String photo_serial) {
		this.photo_serial = photo_serial;
	}
}