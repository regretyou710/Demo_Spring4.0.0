package tw.com.ioc.life;

public class Person {

	private Integer id;

	private String sex;

	private String name;

	public Person() {
		super();
		System.out.println("step1. 創建對象");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("step2. 依賴注入");
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "step4. 使用對象";
	}

	public void init() {
		System.out.println("step3. 初始化");
	}

	public void destroy() {
		System.out.println("step5. 銷毀");
	}

}
