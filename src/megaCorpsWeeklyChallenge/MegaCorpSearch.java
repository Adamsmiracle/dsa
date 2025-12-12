package megaCorpsWeeklyChallenge;

public class MegaCorpSearch {

    /**
     * Linear Search for Interns
     */
    private static boolean linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }


    /**
     * Binary Search for Managers
     */
    private static boolean binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return false;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }



    /**
     * Recursion to search through all departments and sub-departments
     */
    public static boolean searchEmployee(Department dept, int targetId) {

//        Linearly search through the interns list
        if (dept.interns.length > 0) {
            if (linearSearch(dept.interns, targetId)) {
                System.out.println("FOUND! Employee #" + targetId +
                        " is an INTERN in " + dept.name);
                return true;
            }
        }

//        Search through the managers list using binary search.
        if (dept.managers.length > 0) {
            if (binarySearch(dept.managers, targetId)) {
                System.out.println("\nFOUND! Employee #" + targetId +
                        " is a MANAGER in " + dept.name);
                return true;
            }
        }

        // Recursively search all sub-departments
        for (Department subDept : dept.subDepartments) {
            if (searchEmployee(subDept, targetId)) {
                return true;
            }
        }
        return false;
    }







    /**
     * Main method to test the search functionality
     */
    public static void main(String[] args) {
        Department headOffice = new Department(
                "Head Office",
                new int[]{402, 514, 307},
                new int[]{100, 200, 300, 400, 500}
        );

        Department marketing = new Department(
                "Marketing",
                new int[]{55, 12},
                new int[]{601, 602, 603}
        );

        // Tech Department with sub-departments
        Department tech = new Department(
                "Tech",
                new int[]{690, 588},
                new int[]{700, 750, 800}
        );

        Department techSupport = new Department(
                "Tech Support",
                new int[]{33},
                new int[]{801, 802, 803, 804, 805}
        );

        Department aiResearch = new Department(
                "AI Research",
                new int[]{44, 66},
                new int[]{900, 950, 1000}
        );

        tech.addSubDepartment(techSupport);
        tech.addSubDepartment(aiResearch);

        // Sales Department
        Department sales = new Department(
                "Sales",
                new int[]{77},
                new int[]{101, 102, 103, 104, 105, 106, 107}
        );

        Department enterpriseSales = new Department(
                "Enterprise Sales",
                new int[]{22},
                new int[]{200, 201, 202}
        );

        sales.addSubDepartment(enterpriseSales);

        // Add all departments to head office
        headOffice.addSubDepartment(marketing);
        headOffice.addSubDepartment(tech);
        headOffice.addSubDepartment(sales);


        int employeeId = 805;
        boolean found = searchEmployee(headOffice, employeeId);

        System.out.println("\n" + "=".repeat(60));
        if (found) {
            System.out.println("SUCCESS! Employee " +employeeId + " exists in MegaCorp!");
        } else {
            System.out.println("Employee " + employeeId+ " not found in MegaCorp.");
        }
        System.out.println("=".repeat(60));

        // Test with another ID that doesn't exist
        System.out.println("\n\nSearching for Employee ID: #999 (should not exist)");
        System.out.println("=".repeat(60));
        boolean found2 = searchEmployee(headOffice, 999);
        System.out.println("\n" + "=".repeat(60));
        if (found2) {
            System.out.println(" SUCCESS! Employee #999 exists in MegaCorp!");
        } else {
            System.out.println(" Employee #999 not found in MegaCorp.");
        }
        System.out.println("=".repeat(60));
    }
}
