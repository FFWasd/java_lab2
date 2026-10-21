import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Name{
    private String second_name;
    private String first_name;
    private String surname;
    @Override 
    public String toString(){
        if (second_name.length() > 0 && first_name.length() >0 && surname.length() >0){
            return second_name + " " + first_name + " " + surname;
        }
        else if(second_name.length() > 0 && first_name.length() > 0 && surname.length() == 0){
            return second_name + " " + first_name;
        }
        else if(second_name.length() > 0 && first_name.length() ==0 && surname.length() == 0){
            return second_name;
        }
        return "";
    }
    
    Name(String second_name, String first_name, String surname){
        this.second_name = second_name;
        this.first_name = first_name;
        this.surname = surname;            
    }


    Name(String second_name, String first_name){
        this.second_name = second_name;
        this.first_name = first_name;   
        this.surname=""; 
    }

    Name(String second_name){
        this.second_name = second_name;
        this.first_name = "";
        this.surname = "";
    }

}

class Human{
    private String name;
    private int height;
    @Override 
    public String toString(){
        return name + ", рост: " + height;
    }
    Human(String name, int height){
        this.name = name;
        this.height = height;
    }
}

class Department{
    private String name;
    private Employee boss;
    Department(String name){
        this.name = name;
    }
    Employee get_boss(){
        return boss;
    }
    void set_boss(Employee boss){
        this.boss = boss;
    }
    String get_name(){
        return name;
    }
    @Override 
    public String toString(){
        if(boss != null){
            return "Отдел " + name + " начальник: " + boss.get_name();
        }
        return "Отдел " + name + " без начальника";
    }
}

class Employee{
    private String name;
    private Department dep_name;
    Employee(String name, Department dep_name){
        this.name = name;
        this.dep_name = dep_name;
    }
    String get_name(){
        return name;
    } 
    @Override
    public String toString(){
        if (dep_name.get_boss() == null){
            return name + " работает в отделе " + dep_name.get_name() + ", без начальника";
        }
        if (this == dep_name.get_boss()){
            return name + " начальник отдела " + dep_name.get_name();
        }
        else{
            return name + " работает в отделе " + dep_name.get_name() + ", начальник которого " + dep_name.get_boss().get_name();
        }
    }
}

class Department2{
    private String name;
    private Employee2 boss;
    private ArrayList<Employee2> employees = new ArrayList<>();
    Department2(String name){
        this.name = name;
    }
    Employee2 get_boss(){
        return boss;
    }
    void set_boss(Employee2 boss){
        this.boss = boss;
    }
    void add_employee(Employee2 name){
        this.employees.add(name);
    }
    String get_name(){
        return name;
    }
    void print_all(){
        System.out.print("Все сотрудники отдела " + name + ": ");
        for (Employee2 e : employees) {
            System.out.print(e.get_name() + " ");
        }
    }
    @Override 
    public String toString(){
        if(boss != null){
            return "Отдел " + name + " начальник: " + boss.get_name();
        }
        return "Отдел " + name + " без начальника";
    }
}

class Employee2{
    private String name;
    private Department2 dep_name;
    Employee2(String name, Department2 dep_name){
        this.name = name;
        this.dep_name = dep_name;
        dep_name.add_employee(this);
    }
    String get_name(){
        return name;
    } 
    @Override
    public String toString(){
        if (dep_name.get_boss() == null){
            return name + " работает в отделе " + dep_name.get_name() + ", без начальника";
        }
        if (this == dep_name.get_boss()){
            return name + " начальник отдела " + dep_name.get_name();
        }
        else{
            return name + " работает в отделе " + dep_name.get_name() + ", начальник которого " + dep_name.get_boss().get_name();
        }
    }
    void print_all(){
        dep_name.print_all();
    }
}

class Name2{
    private String second_name;
    private String first_name;
    private String surname;
    @Override 
    public String toString(){
        if (second_name.length() > 0 && first_name.length() >0 && surname.length() >0){
            return first_name + " " + surname + " " + second_name;
        }
        else if(second_name.length() > 0 && first_name.length() > 0 && surname.length() == 0){
            return first_name + " " + second_name;
        }
        else if(second_name.length() == 0 && first_name.length() >0 && surname.length() == 0){
            return first_name;
        }
        return "";
    }
    
    Name2(String first_name, String second_name, String surname){
        this.second_name = second_name;
        this.first_name = first_name;
        this.surname = surname;            
    }


    Name2(String first_name, String second_name){
        this.second_name = second_name;
        this.first_name = first_name;   
        this.surname=""; 
    }

    Name2(String first_name){
        this.second_name = "";
        this.first_name = first_name;
        this.surname = "";
    }

}

class Pistol{
    private int bullets;
    Pistol(){
        this.bullets = 5;
    }
    Pistol(int bullets){
        this.bullets = bullets;
    }
    void shoot(){
        if (bullets>0){
            System.out.println("Бах!");
            bullets--;
        }
        else{
            System.out.println("Клац!");
        }
    }
}

class Validation{
    String consoleEncoding = System.getProperty("console.encoding", "UTF-8");
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    int check_int(){
        int z;
        while (true){
            if (scanner.hasNextInt()){
                z = scanner.nextInt();
                break;
            }
            else{
                System.out.print("Введено не число, повторите попытку --> ");
                scanner.next();
            }
        }
        scanner.nextLine();
        return z;
    }
    String have_dig(){
        String s;
        while (true){
            s = scanner.nextLine();
            if (s.matches("^[a-zA-Zа-яА-ЯёЁ-]*$")){
                break;
            }
            else{
                System.out.print("В строке есть недопустимые символы, повторите попытку --> ");
            }
        }
        return s;
    }
}

class Test{
    String consoleEncoding = System.getProperty("console.encoding", "UTF-8");
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    Validation val = new Validation();
    void menu(){
        int z = 1;
        while (z!= 0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("Выберите задание: \n1. Имена \n2. Человек \n3. Сотрудники и отделы \n4. Сотрудники и отделы \n5. Создаём имена\n6. Пистолет стреляет \n0. Выход \n--> ");
            z = val.check_int();
            int l = 1;
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch (z) {
                case 1: {
                    System.out.print("Введите имя: ");
                    String first_name = val.have_dig();
                    System.out.print("Введите фамилию: ");
                    String second_name = val.have_dig();
                    System.out.print("Введите отчество: ");
                    String surname = val.have_dig();
                    Name obj1;
                    if (!first_name.isEmpty() && !second_name.isEmpty() && !surname.isEmpty()){
                        obj1 = new Name(second_name, first_name, surname);
                    } else if (!first_name.isEmpty() && !second_name.isEmpty() && surname.isEmpty()){
                        obj1 = new Name(second_name, first_name);
                    } else if (!first_name.isEmpty() && second_name.isEmpty() && !surname.isEmpty()){
                        obj1 = new Name(first_name, surname);
                    } else if (!first_name.isEmpty() && second_name.isEmpty() && surname.isEmpty()){
                        obj1 = new Name(first_name);
                    } else if (first_name.isEmpty() && !second_name.isEmpty() && !surname.isEmpty()){
                        obj1 = new Name(second_name, surname);
                    } else if (first_name.isEmpty() && !second_name.isEmpty() && surname.isEmpty()){
                        obj1 = new Name(second_name);
                    } else if (first_name.isEmpty() && second_name.isEmpty() && !surname.isEmpty()){
                        obj1 = new Name(surname);
                    }else{
                        System.out.println("Данных недостаточно");
                        obj1 = new Name("");
                    }

                    System.out.println(obj1);
                    scanner.nextLine();
                    break;
                }
                case 2:
                    System.out.print("Введите имя: ");
                    String name = val.have_dig();
                    System.out.print("Введите рост: ");
                    int height = val.check_int();
                    Human obj2 = new Human(name, height);
                    System.out.println(obj2);
                    scanner.nextLine();
                    break;
                case 3: {
                    ArrayList<Employee> employees = new ArrayList<>();
                    ArrayList<Department> departments = new ArrayList<>();
                    while(l!=0){
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        Employee e;
                        System.out.print("Выберите действие: \n1. Добавить отдел \n2. Добавить сотрудника \n3. Назначить начальника \n4. Вывести всех сотрудников \n5. Вывести все отделы \n0. Выход \n--> ");
                        int a = val.check_int();
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        switch (a) {
                            case 1:
                                boolean isexist = false;
                                System.out.print("Введите название отдела: ");
                                String name_dep = scanner.nextLine();
                                for (Department d : departments) {
                                    if (d.get_name().equals(name_dep)){
                                        isexist = true;
                                        break;
                                    }
                                }
                                if (!isexist){
                                    Department dep = new Department(name_dep);
                                    departments.add(dep);  
                                    System.out.println("Добавлен отдел: [" + dep.get_name() + "]");

                                } else{
                                    System.out.println("Такое отдел уже есть!");
                                }
                                scanner.nextLine();
                                break;
                            case 2:
                                isexist = false;
                                Department dep1 = new Department("");
                                System.out.print("Введите имя сотрудника: ");
                                String emp_name = val.have_dig();
                                System.out.print("Введите название отдела: ");
                                String dep_name = scanner.nextLine();
                                for (Department d : departments) {
                                    if (d.get_name().equals(dep_name)){
                                        dep1 = d;
                                        isexist = true;
                                        break;
                                    }
                                }
                                if (isexist){
                                    Employee emp = new Employee(emp_name, dep1);
                                    employees.add(emp);
                                    System.out.println("Сотрудник " + emp_name + " добавлен в отдел: " + dep_name);
                                }
                                else{
                                    System.out.println("Такого отдела нет!");
                                }
                                scanner.nextLine();
                                break;
                            case 3:
                                Department dep2 = new Department("");
                                isexist = false;
                                System.out.print("Введите название отдела: ");
                                dep_name = scanner.nextLine();
                                for (Department d : departments) {
                                    if (d.get_name().equals(dep_name)){
                                        dep2 = d;
                                        isexist = true;
                                        System.out.print("Введите имя сотрудника которого назначить начальником: ");
                                        Department dd = new Department("");
                                        Employee new_boss = new Employee("", dd);
                                        emp_name = val.have_dig();
                                        boolean isexist2 = false;
                                        for (Employee emp : employees) {
                                            if (emp.get_name().equals(emp_name)){
                                                new_boss = emp;
                                                isexist2 = true;
                                                break;
                                            }
                                        }
                                        if (isexist2){
                                            dep2.set_boss(new_boss);
                                            System.out.println(emp_name + " начальник отдела " + dep_name);
                                        }
                                        else{
                                            System.out.println("Такого сотрудника нет!");
                                        }
                                    }
                                }
                                if (!isexist){
                                    System.out.println("Такого отдела нет!");
                                }
                                scanner.nextLine();
                                break;
                            case 4:
                                if (employees.size()!=0){
                                    for (Employee emp : employees) {
                                        System.out.println(emp);
                                    }

                                }
                                else{
                                    System.out.println("Сотрудников нет");
                                }
                                scanner.nextLine();
                                break;
                            case 5:
                                if (departments.size()!=0){
                                    for (Department d : departments) {
                                        System.out.println(d);
                                    }
                                }
                                else{
                                    System.out.println("Отделов нет");
                                }
                                scanner.nextLine();
                                break;
                            case 0:
                                l=0;
                                break;
                            default:
                                System.out.println("Такого действия нет!");
                                break;
                        }
                    }
                    break;
                }
                case 4: {
                    ArrayList<Employee2> employees = new ArrayList<>();
                    ArrayList<Department2> departments = new ArrayList<>();
                    while(l!=0){
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        Employee2 e;
                        System.out.print("Выберите действие: \n1. Добавить отдел \n2. Добавить сотрудника \n3. Назначить начальника \n4. Вывести всех сотрудников \n5. Вывести все отделы \n6. Вывести всех сотрудников отдела \n0. Выход \n--> ");
                        int a = val.check_int();
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        switch (a) {
                            case 1:
                                boolean isexist = false;
                                System.out.print("Введите название отдела: ");
                                String name_dep = scanner.nextLine();
                                for (Department2 d : departments) {
                                    if (d.get_name().equals(name_dep)){
                                        isexist = true;
                                        break;
                                    }
                                }
                                if (!isexist){
                                    Department2 dep = new Department2(name_dep);
                                    departments.add(dep);  
                                    System.out.println("Добавлен отдел: [" + dep.get_name() + "]");

                                } else{
                                    System.out.println("Такое отдел уже есть!");
                                }
                                scanner.nextLine();
                                break;
                            case 2:
                                isexist = false;
                                Department2 dep1 = new Department2("");
                                System.out.print("Введите имя сотрудника: ");
                                String emp_name = val.have_dig();
                                System.out.print("Введите название отдела: ");
                                String dep_name = scanner.nextLine();
                                for (Department2 d : departments) {
                                    if (d.get_name().equals(dep_name)){
                                        dep1 = d;
                                        isexist = true;
                                        break;
                                    }
                                }
                                if (isexist){
                                    Employee2 emp = new Employee2(emp_name, dep1);
                                    employees.add(emp);
                                    System.out.println("Сотрудник " + emp_name + " добавлен в отдел: " + dep_name);
                                }
                                else{
                                    System.out.println("Такого отдела нет!");
                                }
                                scanner.nextLine();
                                break;
                            case 3:
                                Department2 dep2 = new Department2("");
                                isexist = false;
                                System.out.print("Введите название отдела: ");
                                dep_name = scanner.nextLine();
                                for (Department2 d : departments) {
                                    if (d.get_name().equals(dep_name)){
                                        dep2 = d;
                                        isexist = true;
                                        System.out.print("Введите имя сотрудника которого назначить начальником: ");
                                        Department2 dd = new Department2("");
                                        Employee2 new_boss = new Employee2("", dd);
                                        emp_name = val.have_dig();
                                        boolean isexist2 = false;
                                        for (Employee2 emp : employees) {
                                            if (emp.get_name().equals(emp_name)){
                                                new_boss = emp;
                                                isexist2 = true;
                                                break;
                                            }
                                        }
                                        if (isexist2){
                                            dep2.set_boss(new_boss);
                                            System.out.println(emp_name + " начальник отдела " + dep_name);
                                        }
                                        else{
                                            System.out.println("Такого сотрудника нет!");
                                        }
                                    }
                                }
                                if (!isexist){
                                    System.out.println("Такого отдела нет!");
                                }
                                scanner.nextLine();
                                break;
                            case 4:
                                if (employees.size()!=0){
                                    for (Employee2 emp : employees) {
                                        System.out.println(emp);
                                    }

                                }
                                else{
                                    System.out.println("Сотрудников нет");
                                }
                                scanner.nextLine();
                                break;
                            case 5:
                                if (departments.size()!=0){
                                    for (Department2 d : departments) {
                                        System.out.println(d);
                                    }
                                }
                                else{
                                    System.out.println("Отделов нет");
                                }
                                scanner.nextLine();
                                break;
                            case 6:
                                System.out.print("Введите имя сотрудника: ");
                                String f_name = val.have_dig();
                                Department2 dep3 = new Department2("");
                                Employee2 f_emp = new Employee2("", dep3);
                                isexist = false;
                                for (Employee2 emp : employees) {
                                    if (emp.get_name().equals(f_name)){
                                        isexist = true;
                                        f_emp = emp;
                                        break;
                                    }
                                }
                                if (!isexist){
                                    System.out.println("Такого сотрудника нет!");
                                }
                                else{
                                    f_emp.print_all();
                                }
                                scanner.nextLine();
                                break;
                            case 0:
                                l=0;
                                break;
                            default:
                                System.out.println("Такого действия нет!");
                                break;
                        }
                    }
                }
                case 5: {
                    System.out.print("Введите имя (Обязательно!): ");
                    String first_name = val.have_dig();
                    System.out.print("Введите фамилию: ");
                    String second_name = val.have_dig();
                    System.out.print("Введите отчество: ");
                    String surname = val.have_dig();
                    Name2 obj1;
                    if (!first_name.isEmpty() && !second_name.isEmpty() && !surname.isEmpty()){
                        obj1 = new Name2(first_name, second_name, surname);
                    } else if (!first_name.isEmpty() && !second_name.isEmpty() && surname.isEmpty()){
                        obj1 = new Name2(first_name, second_name);
                    } else if (!first_name.isEmpty() && second_name.isEmpty() && surname.isEmpty()){
                        obj1 = new Name2(first_name);
                    }else{
                        System.out.println("Такие данные ввести нельзя! \nДоступные комбинации: \nЛичное имя \nЛичное имя и фамилия \nЛичное имя, фамилия, отчество");
                        obj1 = new Name2("");
                    }

                    System.out.println(obj1);
                    scanner.nextLine();
                    break;  
                }
                case 6:
                    int bul = -5;
                    System.out.print("Введите количество патронов (для пропуска введите -1): ");
                    while (bul <-1){
                        bul = val.check_int();
                        if (bul<-1){
                            System.out.print("Введите положительное число: ");
                        }
                    }
                    System.out.print("Введите количество выстрелов: ");
                    int count = 0;
                    while (count <= 0){
                        count = val.check_int();
                        if (count<= 0){
                            System.out.print("Введите положительное число: ");
                        }
                    }
                    Pistol pist;
                    if (bul == -1){
                        pist = new Pistol();
                    } else{
                        pist = new Pistol(bul);
                    }
                    for (int i = 0; i<count; i++){
                        pist.shoot();
                    }
                    scanner.nextLine();
                    break;
                default:
                    break;
            }
        }

    }
}

public class SecondLab{
    public static void main(String[] args){
        Test test = new Test();
        test.menu();
    }
}
