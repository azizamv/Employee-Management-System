package chipichapa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Employee> EmployeeList = new ArrayList<>();
	
	// MENU
	public void menu() {
		System.out.println("MENU");
		System.out.println("1. Insert Employee");
		System.out.println("2. View Employee");
		System.out.println("3. Update Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Exit");
		System.out.print("Choose: ");
	}
	
	// GET BONUS
	public void getBonus(String position, int count) {
		int added = 0;
		for (int i = 0; i < EmployeeList.size(); i++) {
			if (added == count) {
				break;
			}
			if (EmployeeList.get(i).getPosition().equals(position)) {
				EmployeeList.get(i).addBonus();
				added += 1;
			}
		}
	}
	// buat itung jumlah karyawannya, biar bisa kasih bonus
	int ManagerCount = 0, SupervisorCount = 0, AdminCount = 0;
	
	// INSERT EMPLOYEE
	public void insertEmployee() {
		String code, name, gender, position;
		// karena di soal gajinya udh ditentuin, assume gajinya udh tepat segitu,
		// kecuali kalo dikasih bonus. Jadi utk salary aku taruh di class position
		// masing masing.
		
		// Input data
		do {
			System.out.print("Employee Code: ");
			code = scan.nextLine();
		} while (!isCodeUnique(code));
		
		do {
			System.out.print("Employee Name [>= 3]: ");
			name = scan.nextLine();
		} while (name.length() < 3);
		
		do {
			System.out.print("Employee Gender [Laki-laki | Perempuan]: ");
			gender = scan.nextLine();
		} while (!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
		
		do {
			System.out.print("Employee Position [Manager | Supervisor | Admin]: ");
			position = scan.nextLine();
		} while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin"));
	
		
		// ini kalo misalkan salary nya ga aku initialize di class positionnya,
		// jadi aku masukin salary ke parameternya. Tapi karena aku ga masukkin,
		// jadi ini ga usah. Karena udh di-initialize di class masing-masing
//		if (position.equals("Manager")) salary = 8000000;
//		else if (position.equals("Supervisor")) salary = 6000000;
//		else salary = 4000000;
		
		// Add data into ArrayList
		if (position.equals("Manager")) {
			if (ManagerCount % 3 == 0) {
				getBonus(position, ManagerCount);
			}
			EmployeeList.add(new Manager(code, name, gender, position));
			ManagerCount += 1;
		}
		else if (position.equals("Supervisor")) {
			if (SupervisorCount % 3 == 0) {
				getBonus(position, SupervisorCount);
			}
			EmployeeList.add(new Supervisor(code, name, gender, position));
			SupervisorCount += 1;
		}
		else {
			if (AdminCount % 3 == 0) {
				getBonus(position, AdminCount);
			}
			EmployeeList.add(new Admin(code, name, gender, position));
			AdminCount += 1;
		}
		System.out.printf("Berhasil menambahkan karyawan dengan kode %s\n", code);
		System.out.println("ENTER to return");
		System.out.println();
	}
	
	// VIEW EMPLOYEE
	public void viewEmployee() {
		for (int i = 0; i < EmployeeList.size(); i++) {
			System.out.printf("%d. ", i+1);
			EmployeeList.get(i).displayEmployee();
		}
	}
	// UPDATE EMPLOYEE
	public void updateEmployee() {
		viewEmployee();
		
		int idx;
		double salary;
		
		System.out.print("Choose employee: ");
		idx = scan.nextInt();
		scan.nextLine();
		
		idx -= 1;
		
		String code, name, gender, position;
		
		// UPDATE CODE
		do {
			System.out.print("Employee Code: ");
			code = scan.nextLine();
			
			if (code.equals("0")) {
				code = EmployeeList.get(idx).getCode();
				break;
			}
			EmployeeList.get(idx).setCode(code);
			
		} while (!isCodeUnique(code));
		
		// UPDATE NAME
		do {
			System.out.print("Employee Name [>= 3]: ");
			name = scan.nextLine();
			
			if (name.equals("0")) {
				name = EmployeeList.get(idx).getName();
				break;
			}
			EmployeeList.get(idx).setName(name);
			
		} while (name.length() < 3);
		
		// UPDATE GENDER
		do {
			System.out.print("Employee Gender [Laki-laki | Perempuan]: ");
			gender = scan.nextLine();
			
			if (gender.equals("0")) {
				gender = EmployeeList.get(idx).getGender();
				break;
			}
			EmployeeList.get(idx).setGender(gender);
			
		} while ((!gender.equals("Laki-laki") && !gender.equals("Perempuan")));
		
		// UPDATE POSITION
		do {
			System.out.print("Employee Position [Manager | Supervisor | Admin]: ");
			position = scan.nextLine();
			
			if (position.equals("0")) {
				position = EmployeeList.get(idx).getPosition();
				break;
			}
			
		} while (!position.equals("Manager") && !position.equals("Supervisor") && !position.equals("Admin"));
		
		System.out.print("Employee Salary: ");
		salary = scan.nextDouble();
		
		if (salary != 0) {
			if (EmployeeList.get(idx) instanceof Manager) {
				((Manager)EmployeeList.get(idx)).setSalary(salary);
				// kan salary ini parameter yg beda di tiap class nya, jd harus typecasting
			}
			else if (EmployeeList.get(idx) instanceof Supervisor) {
				((Supervisor)EmployeeList.get(idx)).setSalary(salary);
			}
			else {
				((Admin)EmployeeList.get(idx)).setSalary(salary);
			}
		}
		
		// IF POSITION IS UPDATED, UPDATE ALL
		// assume kalau jabatannya diganti, gaji nya ga berubah ATAU ngikutin gaji yg di-update
		if (!position.equals(EmployeeList.get(idx).getPosition())) {
			EmployeeList.remove(idx);
			
			if (position.equals("Manager")) {
				EmployeeList.add(new Manager(code, name, gender, position));
				((Manager)EmployeeList.get(EmployeeList.size()-1)).setSalary(salary);
			}
			else if (position.equals("Supervisor")) {
				EmployeeList.add(new Supervisor(code, name, gender, position));
				((Supervisor)EmployeeList.get(EmployeeList.size()-1)).setSalary(salary);
			}
			else {
				EmployeeList.add(new Admin(code, name, gender, position));
				((Admin)EmployeeList.get(EmployeeList.size()-1)).setSalary(salary);
			}
		}
		
		System.out.printf("Berhasil mengupdate karyawan dengan kode %s\n", EmployeeList.get(idx).code);
		System.out.println("ENTER to return");
		System.out.println();
	}
	
	// DELETE EMPLOYEE
	public void deleteEmployee() {
		viewEmployee();
		int idx;
		
		do {
			idx = scan.nextInt();
			scan.nextLine();
		} while (idx < 1 && idx > EmployeeList.size());
		
		idx -= 1;
		String deletedCode;
		deletedCode = EmployeeList.get(idx).getCode();
		
		EmployeeList.remove(idx);
		System.out.printf("Karyawan dengan kode %s berhasil dihapus\n", deletedCode);
		System.out.println("ENTER to return");
		System.out.println();
	}

	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		
		int input;
		do {
			menu();
			input = scan.nextInt();
			scan.nextLine();
			
			switch (input) {
			case 1:
				insertEmployee();
				break;
			case 2:
				if (EmployeeList.isEmpty()) {
					System.out.println("No data");
					System.out.println();
					break;
				}
				viewEmployee();
				System.out.println();
				break;
			case 3:
				if (EmployeeList.isEmpty()) {
					System.out.println("No data");
					System.out.println();
					break;
				}
				updateEmployee();
				
				break;
			case 4:
				if (EmployeeList.isEmpty()) {
					System.out.println("No data");
					System.out.println();
					break;
				}
				deleteEmployee();
				break;
			default:
				break;
			}
			
		} while (input != 5);
	}
	
	private boolean isCodeUnique(String code) {
		for (int i = 0; i < EmployeeList.size(); i++) {
			if (code.equals(EmployeeList.get(i).getCode())) {
				return false;
			}
		}
		return true;
	}
}
