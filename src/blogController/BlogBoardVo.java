package blogController;

import java.util.ArrayList;
import java.util.List;

public class BlogBoardVo {
	int bNo; //블로그 번호
	int brdNo; //게시물 번호
	String cName = ""; //카테고리 이름
	String cnt = ""; //카데고리 게시물 수
	String mId = ""; //회원 아이디
	String brdHeader = ""; //게시물 헤더사진
	String oriBrdHeader = ""; //게시물 원본 헤더사진
	String subject = ""; //게시물 제목
	String content = ""; //게시물 내용
	String brdDate = ""; //게시물 작성일자
	int hit; //게시물 조회 수
	int brdLike; //게시물 공감 수
	List<BlogVo> blogInfo = new ArrayList<BlogVo>(); //블로그 이름, 유저사진
	String tContent = ""; //게시글 태그
	int basicSet; //게시글 공개여부
	List<String> likeMid = new ArrayList<String>(); //해당 게시글에 공감버튼을 누른 회원목록
	
	public BlogBoardVo() {}
	
	public int getBrdNo() {return brdNo;}
	public void setBrdNo(int brdNo) {this.brdNo = brdNo;}
	public int getbNo() {return bNo;}
	public void setbNo(int bNo) {this.bNo = bNo;}
	public String getcName() {return cName;}
	public void setcName(String cName) {this.cName = cName;}
	public String getCnt() {return cnt;}
	public void setCnt(String cnt) {this.cnt = cnt;}
	public String getmId() {return mId;}
	public void setmId(String mId) {this.mId = mId;}
	public String getBrdHeader() {return brdHeader;}
	public void setBrdHeader(String brdHeader) {this.brdHeader = brdHeader;}
	public String getOriBrdHeader() {return oriBrdHeader;}
	public void setOriBrdHeader(String oriBrdHeader) {this.oriBrdHeader = oriBrdHeader;}
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getBrdDate() {return brdDate;}
	public void setBrdDate(String brdDate) {this.brdDate = brdDate;}
	public int getHit() {return hit;}
	public void setHit(int hit) {this.hit = hit;}
	public int getBrdLike() {return brdLike;}
	public void setBrdLike(int brdLike) {this.brdLike = brdLike;}
	public List<BlogVo> getBlogInfo() {return blogInfo;}
	public void setBlogInfo(List<BlogVo> blogInfo) {this.blogInfo = blogInfo;}
	public String gettContent() {return tContent;}
	public void settContent(String tContent) {this.tContent = tContent;}
	public int getBasicSet() {return basicSet;}
	public void setBasicSet(int basicSet) {this.basicSet = basicSet;}
	public List<String> getLikeMid() {return likeMid;}
	public void setLikeMid(List<String> likeMid) {this.likeMid = likeMid;}
	
}
