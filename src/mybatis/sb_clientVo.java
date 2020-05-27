package mybatis;

import java.sql.Date;

public class sb_clientVo {
	String ID;
	String pwd;
	int pl_serial;
	Date membership;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPl_serial() {
		return pl_serial;
	}
	public void setPl_serial(int pl_serial) {
		this.pl_serial = pl_serial;
	}
	public Date getMembership() {
		return membership;
	}
	public void setMembership(Date membership) {
		this.membership = membership;
	}
}
