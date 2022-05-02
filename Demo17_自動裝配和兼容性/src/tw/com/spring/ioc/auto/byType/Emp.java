package tw.com.spring.ioc.auto.byType;

public class Emp {

	private Integer eid;

	private String ename;

	// private Dept dept;

	// private Car car;

	private IDept dept;

	private SuperCar car;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

//	public Dept getDept() {
//		return dept;
//	}

//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}

//	public Car getCar() {
//		return car;
//	}

//	public void setCar(Car car) {
//		this.car = car;
//	}

	public IDept getDept() {
		return dept;
	}

	public void setDept(IDept dept) {
		this.dept = dept;
	}

	public SuperCar getCar() {
		return car;
	}

	public void setCar(SuperCar car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", dept=" + dept + ", car=" + car + "]";
	}
}
