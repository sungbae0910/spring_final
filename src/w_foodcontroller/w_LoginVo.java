package w_foodcontroller;

public class w_LoginVo {
	String w_mid;
	String w_pwd;	


	public String getW_mid() {
		return w_mid;
	}

	public void setW_mid(String w_mid) {
		this.w_mid = w_mid;
	}

	public String getW_pwd() {
		return w_pwd;
	}

	public void setW_pwd(String w_pwd) {
		this.w_pwd = w_pwd;
	}
    
	@Override
	public String toString() {
		return "w_LoginVO [w_mid=" + w_mid + ", w_pwd=" + w_pwd + "]";
  }
}