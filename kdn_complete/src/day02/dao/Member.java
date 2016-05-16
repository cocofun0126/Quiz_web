package day02.dao;

public class Member {
	private String memid, mempwd, memname;

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMempwd() {
		return mempwd;
	}

	public void setMempwd(String mempwd) {
		this.mempwd = mempwd;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memid=");
		builder.append(memid);
		builder.append(", mempwd=");
		builder.append(mempwd);
		builder.append(", memname=");
		builder.append(memname);
		builder.append("]");
		return builder.toString();
	}
	
	
}
