public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УЧЕТА СОТРУДНИКОВ ===\n");

        // Создание сотрудников
        Administrator admin = new Administrator("Анна Иванова", 101, 50000, "HR", 5);
        Programmer programmer = new Programmer("Петр Сидоров", 102, 80000, "Java", 3);
        Manager manager = new Manager("Мария Петрова", 103, 60000, 3, "Разработка");

        // Массив для демонстрации полиморфизма
        Employee[] employees = {admin, programmer, manager};

        // Информация о всех сотрудниках
        System.out.println("СОТРУДНИКИ:");
        for (Employee emp : employees) {
            emp.displayInfo();
        }

        // Демонстрация работы
        System.out.println("\nРАБОТА СОТРУДНИКОВ:");
        for (Employee emp : employees) {
            emp.work();
        }

        // Специфические методы
        System.out.println("\nСПЕЦИАЛЬНЫЕ ВОЗМОЖНОСТИ:");
        admin.manageTeam();
        programmer.debugCode();
        manager.planProjects();

        // Статистика
        System.out.println("\nСТАТИСТИКА:");
        System.out.println("Всего сотрудников: " + Employee.getEmployeeCount());

        // Демонстрация наследования и полиморфизма
        System.out.println("\nПОЛИМОРФИЗМ:");
        Employee employeeRef = admin;
        employeeRef.work(); // Вызовется метод Administrator
    }
}