package tw.com.spring.jdbctemplate;

public class Emp {

	private Integer eid;

	private String emane;

	private Integer age;

	private String sex;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEmane() {
		return emane;
	}

	public void setEmane(String emane) {
		this.emane = emane;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", emane=" + emane + ", age=" + age + ", sex=" + sex + "]";
	}

}
