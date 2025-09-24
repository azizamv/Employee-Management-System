## Employee Management System

This is a Java application designed for Employee Management to manage employee data efficiently.

### 📋 Features

The application provides a simple CRUD (Create, Read, Update, Delete) interface for managing employee records:

1. Insert Employee Data
- Input includes: Employee Code, Name, Gender, Position, and Salary.
- Employee Code Format: MM-XXXX (2 random letters + 4 random digits, unique).
- Name: Minimum 3 alphabetic characters.
- Gender: Male or Female
- Position Options: Manager, Supervisor, or Admin (case-sensitive).
- Base Salary: Manager -> Rp 8,000,000, Supervisor -> Rp 6,000,000, Admin -> Rp 4,000,000
- Bonus Rule: When 3 new employees share the same position, earlier employees in that role receive a salary bonus:
  - Manager: +10%
  - Supervisor: +7.5%
  - Admin: +5%

2. View Employee Data
- Displays all employee records sorted by name (ascending).

4. Update Employee Data
- Lists current employees (sorted by name).
- Allows updating specific fields of a selected employee.
- Enter 0 to keep the old value unchanged.

5. Delete Employee Data
- Lists current employees (sorted by name).
- Allows deleting a selected employee by index.
