package chipichapa;

public abstract class Employee implements Displayable, Bonus {
	String code, name, gender, position;
	
	public Employee(String code, String name, String gender, String position) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.position = position;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}
	
	public String getPosition() {
		return position;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
