package tw.com.ioc.scope;

public class Student {

	private String sid;

	private String sname;

	public Student() {
		super();
		System.out.println("��H��Ҥ�");
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
