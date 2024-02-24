Урок 4. Коллекции
Справочник сотрудников
Справочник сотрудников представлен в виде Java-приложения, состоящего из нескольких классов, позволяющих добавлять сотрудников, искать их по различным атрибутам и выводить информацию о них.

Использование
Добавление нового сотрудника:
EmployeeDirectory directory = new EmployeeDirectory();
directory.addEmployee(1, "+1234567890", "Иванов", 5);
Поиск сотрудников по стажу:
List<EmployeeDirectory.Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
Поиск номера телефона сотрудника по имени:
String phoneNumber = directory.findPhoneNumberByName("Петров");
Поиск сотрудника по табельному номеру:
EmployeeDirectory.Employee employee = directory.findEmployeeByEmployeeId(2);
Вывод в консоли
Сотрудники со стажем 5 лет:
Иванов
Сидоров
Номер телефона Петрова: +9876543210
Сотрудник с табельным номером 2 найден: Петров
