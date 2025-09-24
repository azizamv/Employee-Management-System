package chipichapa;

public class Supervisor extends Employee {
	public Supervisor(String code, String name, String gender, String position) {
		super(code, name, gender, position);
		// TODO Auto-generated constructor stub
	}

	double salary = 6000000;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void displayEmployee() {
		System.out.printf("Code: %s, Name: %s, Gender: %s, Position: %s, Salary: %.1f\n", getCode(), getName(), getGender(), getPosition(), getSalary());
	}

	@Override
	public void addBonus() {
		double bonus = 0.075 * getSalary();
		setSalary(getSalary() + bonus);
	}
	
	
}
