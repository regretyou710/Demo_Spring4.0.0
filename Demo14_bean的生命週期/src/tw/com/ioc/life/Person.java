package tw.com.ioc.life;

public class Person {

	private Integer id;

	private String sex;

	private String name;

	public Person() {
		super();
		System.out.println("step1. �Ыع�H");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("step2. �̿�`�J");
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
		return "step4. �ϥι�H";
	}

	public void init() {
		System.out.println("step3. ��l��");
	}

	public void destroy() {
		System.out.println("step5. �P��");
	}

}
