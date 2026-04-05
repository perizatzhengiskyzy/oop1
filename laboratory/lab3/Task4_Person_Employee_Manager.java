// Task 4: Person, Employee, Manager

import java.util.*;

class Person {
    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name);
    }
}

class Employee extends Person implements Comparable<Employee>, Cloneable {
    private double annualSalary;
    private Date hireDate;
    private String nationalInsuranceNumber;
    
    public Employee(String name, double annualSalary, Date hireDate, String nationalInsuranceNumber) {
        super(name);
        this.annualSalary = annualSalary;
        this.hireDate = hireDate;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
    
    public double getAnnualSalary() { return annualSalary; }
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public String getNationalInsuranceNumber() { return nationalInsuranceNumber; }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + annualSalary + 
               ", hireDate=" + hireDate + ", NI=" + nationalInsuranceNumber + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.annualSalary, annualSalary) == 0 &&
               Objects.equals(hireDate, employee.hireDate) &&
               Objects.equals(nationalInsuranceNumber, employee.nationalInsuranceNumber);
    }
    
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.annualSalary, other.annualSalary);
    }
    
    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.hireDate = (Date) this.hireDate.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Manager extends Employee {
    private Vector<Employee> team;
    private double bonus;
    
    public Manager(String name, double annualSalary, Date hireDate, 
                   String nationalInsuranceNumber, double bonus) {
        super(name, annualSalary, hireDate, nationalInsuranceNumber);
        this.team = new Vector<>();
        this.bonus = bonus;
    }
    
    public void addToTeam(Employee e) {
        team.add(e);
    }
    
    public Vector<Employee> getTeam() { return team; }
    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }
    
    @Override
    public String toString() {
        return "Manager{name='" + name + "', salary=" + getAnnualSalary() + 
               ", bonus=" + bonus + ", teamSize=" + team.size() + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Manager manager = (Manager) obj;
        return Double.compare(manager.bonus, bonus) == 0 &&
               Objects.equals(team, manager.team);
    }
    
    @Override
    public int compareTo(Employee other) {
        if (!(other instanceof Manager)) {
            return super.compareTo(other);
        }
        Manager otherManager = (Manager) other;
        int salaryCompare = Double.compare(this.getAnnualSalary(), other.getAnnualSalary());
        if (salaryCompare != 0) return salaryCompare;
        return Double.compare(this.bonus, otherManager.bonus);
    }
    
    @Override
    public Manager clone() {
        Manager cloned = (Manager) super.clone();
        cloned.team = new Vector<>();
        for (Employee e : this.team) {
            cloned.team.add(e.clone());
        }
        return cloned;
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class HireDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getHireDate().compareTo(e2.getHireDate());
    }
}