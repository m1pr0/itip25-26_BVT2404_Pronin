public class Programmer extends Employee {
    private String programmingLanguage;
    private int yearsOfExperience;
    private String currentProject;

    // Конструктор по умолчанию
    public Programmer() {
        super(); // Вызов конструктора по умолчанию родителя
        this.programmingLanguage = "Unknown";
        this.yearsOfExperience = 0;
    }

    public Programmer(String name, int id, double salary, String programmingLanguage, int yearsOfExperience) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println(getName() + " пишет код на " + programmingLanguage);
    }

    public void debugCode() {
        System.out.println("Отлаживает код на " + programmingLanguage);
    }
}