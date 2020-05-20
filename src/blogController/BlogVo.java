package blogController;

import java.util.ArrayList;
import java.util.List;

public class BlogVo {
	int bNo; //블로그 번호
	String mId; //회원 아이디
	String bTitle; //블로그 이름
	String bSkin; //블로그 스킨
	String mPhoto; //회원 프로필 사진
	String oriMphoto; //회원 프로필 원본사진
	String hPhoto; //블로그 헤더사진
	String oriHphoto; //블로그 헤더 원본사진
	String cName; //카테고리 이름
	int cnt; //카테고리에 해당하는 게시물 갯수
	
	public BlogVo() {}
	
	public int getbNo() {return bNo;}
	public void setbNo(int bNo) {this.bNo = bNo;}
	public String getmId() {return mId;}
	public void setmId(String mId) {this.mId = mId;}
	public String getbTitle() {return bTitle;}
	public void setbTitle(String bTitle) {this.bTitle = bTitle;}
	public String getbSkin() {return bSkin;}
	public void setbSkin(String bSkin) {this.bSkin = bSkin;}
	public String getmPhoto() {return mPhoto;}
	public void setmPhoto(String mPhoto) {this.mPhoto = mPhoto;}
	public String getOriMphoto() {return oriMphoto;}
	public void setOriMphoto(String oriMphoto) {this.oriMphoto = oriMphoto;}
	public String gethPhoto() {return hPhoto;}
	public void sethPhoto(String hPhoto) {this.hPhoto = hPhoto;}
	public String getOriHphoto() {return oriHphoto;}
	public void setOriHphoto(String oriHphoto) {this.oriHphoto = oriHphoto;}
	public String getcName() {return cName;}
	public void setcName(String cName) {this.cName = cName;}
	public int getCnt() {return cnt;}
	public void setCnt(int cnt) {this.cnt = cnt;}
	
}
