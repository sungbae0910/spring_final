package newsController;

import java.util.Date;
import java.util.List;

public class CommentVo {
	int cSerial;
	int nSerial;
	String mName;
	Date cDate;
	String cContent;
	int cGroup;
	int cStep;
	int cIndent;
	int cLike;
	int cDiLike;
	int cnt;
	
	public CommentVo() {}

	public int getcSerial() {
		return cSerial;
	}

	public void setcSerial(int cSerial) {
		this.cSerial = cSerial;
	}

	public int getnSerial() {
		return nSerial;
	}

	public void setnSerial(int nSerial) {
		this.nSerial = nSerial;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public int getcGroup() {
		return cGroup;
	}

	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}

	public int getcStep() {
		return cStep;
	}

	public void setcStep(int cStep) {
		this.cStep = cStep;
	}

	public int getcIndent() {
		return cIndent;
	}

	public void setcIndent(int cIndent) {
		this.cIndent = cIndent;
	}

	public int getcLike() {
		return cLike;
	}

	public void setcLike(int cLike) {
		this.cLike = cLike;
	}

	public int getcDiLike() {
		return cDiLike;
	}

	public void setcDiLike(int cDiLike) {
		this.cDiLike = cDiLike;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	
	
	
}
