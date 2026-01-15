public class Administrator extends Employee {
    private String department;
    private int subordinatesCount;
    private String workSchedule;

    public Administrator(String name, int id, double salary, String department, int subordinatesCount) {
        super(name, id, salary);
        this.department = department;
        this.subordinatesCount = subordinatesCount;
    }

    @Override
    public void work() {
        System.out.println(getName() + " управляет отделом " + department);
    }

    public void manageTeam() {
        System.out.println("Управляет командой из " + subordinatesCount + " человек");
    }
}