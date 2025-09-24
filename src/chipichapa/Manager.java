package chipichapa;

public class Manager extends Employee {
	double salary = 8000000;

	public Manager(String code, String name, String gender, String position) {
		super(code, name, gender, position);
	}

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
		double bonus = 0.1 * getSalary();
		setSalary(getSalary() + bonus);
	}
}
