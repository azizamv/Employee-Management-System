package chipichapa;

public class Admin extends Employee {
	double salary = 4000000;
	
	public Admin(String code, String name, String gender, String position) {
		super(code, name, gender, position);
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void displayEmployee() {
		System.out.printf("Code: %s, Name: %s, Gender: %s, Position: %s, Salary: %.2f\n", getCode(), getName(), getGender(), getPosition(), getSalary());
	}

	@Override
	public void addBonus() {
		double bonus = 0.05 * getSalary();
		setSalary(getSalary() + bonus);
	}
	
	
}
