public class Manager extends Employee {
    private int projectsCount;
    private String responsibilityArea;
    private String managementStyle;

    public Manager(String name, int id, double salary, int projectsCount, String responsibilityArea) {
        super(name, id, salary);
        this.projectsCount = projectsCount;
        this.responsibilityArea = responsibilityArea;
    }

    @Override
    public void work() {
        System.out.println(getName() + " управляет " + projectsCount + " проектами");
    }

    public void planProjects() {
        System.out.println("Планирует проекты в области " + responsibilityArea);
    }
}