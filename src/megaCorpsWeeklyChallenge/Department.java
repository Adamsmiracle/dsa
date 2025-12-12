package megaCorpsWeeklyChallenge;

import java.util.ArrayList;
import java.util.List;

class Department {
    String name;
    int[] interns;
    int[] managers;
    List<Department> subDepartments;

    public Department(String name, int[] interns, int[] managers) {
        this.name = name;
        this.interns = interns;
        this.managers = managers;
        this.subDepartments = new ArrayList<>();
    }

    public void addSubDepartment(Department dept) {
        this.subDepartments.add(dept);
    }
}

