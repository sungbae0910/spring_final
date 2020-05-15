package mybatis;

import java.util.List;

public class MusicListVo {
	
	int pl_serial;
	
	String mId;
	String music_list;
	
	String[] list_num;
	
	public String[] getList_num() {
		return list_num;
	}
	public void setList_num(String[] list_num) {
		this.list_num = list_num;
	}
	public int getPl_serial() {
		return pl_serial;
	}
	public void setPl_serial(int pl_serial) {
		this.pl_serial = pl_serial;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getMusic_list() {
		return music_list;
	}
	public void setMusic_list(String music_list) {
		this.music_list = music_list;
	}
	
	
	
}
