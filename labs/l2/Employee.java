public abstract class Employee {
    private String name;
    private int id;
    private double salary;
    private static int employeeCount = 0;

    // Конструктор по умолчанию
    public Employee() {
        this.name = "Unknown";
        this.id = 0;
        this.salary = 0.0;
        employeeCount++;
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        employeeCount++;
    }

    public abstract void work();

    public void displayInfo() {
        System.out.println(name + " (ID: " + id + "), Зарплата: " + salary);
    }

    // Геттеры
    public String getName() { return name; }
    public int getId() { return id; }
    public double getSalary() { return salary; }
    public static int getEmployeeCount() { return employeeCount; }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}