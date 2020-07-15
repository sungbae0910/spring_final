package blogController;

public class BlogCmtVo {
	int cmtNo; //댓글 번호
	int brdNo; //게시글 번호
	int cmtBasicSet; //공개여부
	int cmtBlame; //신고여부
	String cmtMid = ""; //댓글, 답글 단 회원 아이디
	String cmtDate = ""; //작성일자
	String cmtContent = ""; //작성 내용
	int cmtRepl; //답글 단 댓글의 번호
	int cnt; //댓글 수
	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public int getCmtBasicSet() {
		return cmtBasicSet;
	}
	public void setCmtBasicSet(int cmtBasicSet) {
		this.cmtBasicSet = cmtBasicSet;
	}
	public int getCmtBlame() {
		return cmtBlame;
	}
	public void setCmtBlame(int cmtBlame) {
		this.cmtBlame = cmtBlame;
	}
	public String getCmtMid() {
		return cmtMid;
	}
	public void setCmtMid(String cmtMid) {
		this.cmtMid = cmtMid;
	}
	public String getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(String cmtDate) {
		this.cmtDate = cmtDate;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public int getCmtRepl() {
		return cmtRepl;
	}
	public void setCmtRepl(int cmtRepl) {
		this.cmtRepl = cmtRepl;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
