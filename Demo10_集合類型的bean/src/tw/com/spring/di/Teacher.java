package tw.com.spring.di;

import java.util.List;
import java.util.Map;

public class Teacher {

	private Integer tid;

	private String tname;

	// 班級清單
	private List<String> cls;

	// 學生清單
	private List<Student> students;

	// 上級主管清單
	private Map<String, String> bossMap;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<String> getCls() {
		return cls;
	}

	public void setCls(List<String> cls) {
		this.cls = cls;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Map<String, String> getBossMap() {
		return bossMap;
	}

	public void setBossMap(Map<String, String> bossMap) {
		this.bossMap = bossMap;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", cls=" + cls + ", students=" + students + ", bossMap="
				+ bossMap + "]";
	}

}
