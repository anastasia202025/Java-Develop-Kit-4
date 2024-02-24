
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра класса EmployeeDirectory
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление сотрудников в справочник
        directory.addEmployee(1, "+1234567890", "Иванов", 5);
        directory.addEmployee(2, "+9876543210", "Петров", 3);
        directory.addEmployee(3, "+5555555555", "Сидоров", 5);

        // Поиск сотрудников с опытом 5 лет и вывод их имен
        List<EmployeeDirectory.Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5 лет:");
        for (EmployeeDirectory.Employee employee : employeesWithExperience5) {
            System.out.println(employee.getName());
        }

        // Поиск номера телефона по имени сотрудника
        String phoneNumber = directory.findPhoneNumberByName("Петров");
        System.out.println("Номер телефона Петрова: " + phoneNumber);

        // Поиск сотрудника по табельному номеру и вывод его имени
        EmployeeDirectory.Employee employee = directory.findEmployeeByEmployeeId(2);
        if (employee != null) {
            System.out.println("Сотрудник с табельным номером 2 найден: " + employee.getName());
        } else {
            System.out.println("Сотрудник с табельным номером 2 не найден.");
        }
    }

    /**
     * Класс, представляющий справочник сотрудников.
     */
    public static class EmployeeDirectory {
        private List<Employee> employees = new ArrayList<>();

        /**
         * Класс, представляющий сотрудника.
         */
        public class Employee {
            private int employeeId;
            private String phoneNumber;
            private String name;
            private int experience;

            public Employee(int employeeId, String phoneNumber, String name, int experience) {
                this.employeeId = employeeId;
                this.phoneNumber = phoneNumber;
                this.name = name;
                this.experience = experience;
            }

            public int getEmployeeId() {
                return employeeId;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public String getName() {
                return name;
            }

            public int getExperience() {
                return experience;
            }
        }

        /**
         * Метод для добавления нового сотрудника в справочник.
         *
         * @param employeeId  Табельный номер сотрудника
         * @param phoneNumber Номер телефона сотрудника
         * @param name        Имя сотрудника
         * @param experience  Стаж сотрудника
         */
        public void addEmployee(int employeeId, String phoneNumber, String name, int experience) {
            Employee newEmployee = new Employee(employeeId, phoneNumber, name, experience);
            employees.add(newEmployee);
        }

        /**
         * Метод для поиска сотрудников по стажу.
         *
         * @param targetExperience Стаж для поиска
         * @return Список сотрудников с заданным стажем
         */
        public List<Employee> findEmployeesByExperience(int targetExperience) {
            List<Employee> result = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getExperience() == targetExperience) {
                    result.add(employee);
                }
            }
            return result;
        }

        /**
         * Метод для поиска номера телефона сотрудника по имени.
         *
         * @param targetName Имя сотрудника
         * @return Номер телефона сотрудника или сообщение, если сотрудник не найден
         */
        public String findPhoneNumberByName(String targetName) {
            for (Employee employee : employees) {
                if (employee.getName().equals(targetName)) {
                    return employee.getPhoneNumber();
                }
            }
            return "Сотрудник с именем " + targetName + " не найден.";
        }

        /**
         * Метод для поиска сотрудника по табельному номеру.
         *
         * @param employeeId Табельный номер сотрудника
         * @return Сотрудник с заданным табельным номером или null, если не найден
         */
        public Employee findEmployeeByEmployeeId(int employeeId) {
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    return employee;
                }
            }
            return null; // Если сотрудник не найден
        }
    }

}