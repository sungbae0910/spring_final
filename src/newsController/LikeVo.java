package newsController;

public class LikeVo {
	int likeNo;
	String mName;
	int nSerial;
	int cSerial;
	int cLike;
	int cDiLike;
	int cnt;
	
	public LikeVo() {}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getcSerial() {
		return cSerial;
	}

	public void setcSerial(int cSerial) {
		this.cSerial = cSerial;
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

	public int getnSerial() {
		return nSerial;
	}

	public void setnSerial(int nSerial) {
		this.nSerial = nSerial;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
