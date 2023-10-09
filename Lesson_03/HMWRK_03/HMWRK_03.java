// 1) Переписать код в соответствии с Single Responsibility Principle:
/* public class Employee {
 *  private String name;
 *  private Date dob;
 *  private int baseSalary;
 *
 *  public Employee(String name, Date dob, int baseSalary) {
 *      this.name = name;
 *      this.dob = dob;
 *      this.baseSalary = baseSalary;
 *  }
 *
 *  public String getEmpInfo() {
 *      return "name - " + name + " , dob - " + dob.toString();
 *  }
 *
 *  public int calculateNetSalary() {
 *      int tax = (int) (baseSalary * 0.25);// calculate in otherway
 *      return baseSalary - tax;
 *  }} 
 */

// ​Подсказка: вынесите метод calculateNetSalary() в отдельный класс

//

// ------------------------------Task1------------------------------//
// Класс, представляющий информацию о сотруднике
public class EmployeeInfo {
    private String name;
    private Date dob;

    public EmployeeInfo(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getEmpInfo() {
        return "name - " + name + " , dob - " + dob.toString();
    }
}

// Класс для вычисления заработной платы сотрудника
public class SalaryCalculator {
    private int baseSalary;

    public SalaryCalculator(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int calculateNetSalary() {
        int tax = (int) (baseSalary * 0.25); // Calculate tax in a different way
        return baseSalary - tax;
    }

}

// 2) Переписать код SpeedCalculation в соответствии с Open-Closed Principle:
/*
 * public class SpeedCalculation {
 * public double calculateAllowedSpeed(Vehicle vehicle) {
 * if (vehicle.getType().equalsIgnoreCase("Car")) {
 * return vehicle.getMaxSpeed() * 0.8;
 * } else if (vehicle.getType().equalsIgnoreCase("Bus")) {
 * return vehicle.getMaxSpeed() * 0.6;
 * }
 * ​
 * return 0.0;
 * }
 * }
 * 
 * public class Vehicle {
 * int maxSpeed;
 * String type;
 * 
 * public Vehicle(int maxSpeed, String type) {
 * this.maxSpeed = maxSpeed;
 * this.type = type;
 * }
 * 
 * public int getMaxSpeed() {
 * return this.maxSpeed;
 * }
 * 
 * public String getType() {
 * return this.type;
 * }
 * }
 */
// Подсказка: создайте два дополнительных класса Car и
// Bus(наследников Vehicle), напишите метод calculateAllowedSpeed().
// Использование этого метода позволит сделать класс SpeedCalculation
// соответствующим OCP

//

// ------------------------------Task2------------------------------//
// Интерфейс для транспортных средств
public interface Vehicle {
    int getMaxSpeed();

    String getType();

    double calculateAllowedSpeed();
}

// Класс, представляющий автомобиль
public class Car implements Vehicle {
    private int maxSpeed;
    private String type;

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.type = "Car";
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.8;
    }
}

// Класс, представляющий автобус
public class Bus implements Vehicle {
    private int maxSpeed;
    private String type;

    public Bus(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.type = "Bus";
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.6;
    }
}

// 3) Переписать код в соответствии с Interface Segregation Principle:
/*
 * public interface Shape {
 * double area();
 * 
 * double volume();
 * }
 * 
 * public class Circle implements Shape {
 * private double radius;
 * 
 * public Circle(double radius) {
 * this.radius = radius;
 * }
 * 
 * @Override
 * public double area() {
 * return 2 * 3.14 * radius;
 * }
 * 
 * @Override
 * public double volume() {
 * throw new UnsupportedOperationException();
 * }
 * }
 * 
 * public class Cube implements Shape {
 * private int edge;
 * 
 * public Cube(int edge) {
 * this.edge = edge;
 * }
 * 
 * @Override
 * public double area() {
 * return 6 * edge * edge;
 * }
 * 
 * @Override
 * public double volume() {
 * return edge * edge * edge;
 * }}
 */
// Подсказка: круг не объемная фигура и этому классу
// не нужен метод volume().

//

// ------------------------------Task3------------------------------//
// Интерфейс для фигур с площадью
public interface AreaShape {
    double area();
}

// Интерфейс для объемных фигур
public interface VolumeShape {
    double volume();
}

// Класс, представляющий круг
public class Circle implements AreaShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }
}

// Класс, представляющий куб
public class Cube implements AreaShape, VolumeShape {
    private int edge;

    public Cube(int edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return 6 * edge * edge;
    }

    @Override
    public double volume() {
        return edge * edge * edge;
    }
}

// Задачи со *(подсказок нет!, это же сложные задания)
// 4) Переписать код в соответствии с Liskov Substitution Principle:
/*
 * public class Rectangle {
 * private int width;
 * private int height;
 * 
 * public void setWidth(int width) {
 * this.width = width;
 * }
 * 
 * public void setHeight(int height) {
 * this.height = height;
 * }
 * 
 * public int area() {
 * return this.width * this.height;
 * }
 * }
 * 
 * public class Square extends Rectangle {
 * 
 * @Override
 * public void setWidth(int width) {
 * super.width = width;
 * super.height = width;
 * }
 * 
 * @Override
 * public void setHeight(int height) {
 * super.width = height;
 * super.height = height;
 * }
 * }​
 */

//

// ------------------------------Task4------------------------------//
// Класс, представляющий прямоугольник
public class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }
}

// Класс, представляющий квадрат
public class Square {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public int area() {
        return this.side * this.side;
    }
}

// 5) Переписать код в соответствии с Dependency Inversion Principle:
/*
 * public class Car {
 * private PetrolEngine engine;
 * 
 * public Car(PetrolEngine engine) {
 * this.engine = engine;
 * }
 * 
 * public void start() {
 * this.engine.start();
 * }
 * }
 * 
 * public class PetrolEngine {
 * public void start() {
 * }}
 */
// Разорвать зависимость классов Car и PetrolEngine.
// У машины же может быть DieselEngine.

// 

// ------------------------------Task5------------------------------//
// Интерфейс для двигателя
public interface Engine {
    void start();
}

// Класс, представляющий бензиновый двигатель
public class PetrolEngine implements Engine {
    @Override
    public void start() {
        // Реализация запуска бензинового двигателя
    }
}

// Класс, представляющий дизельный двигатель
public class DieselEngine implements Engine {
    @Override
    public void start() {
        // Реализация запуска дизельного двигателя
    }
}

// Класс, представляющий автомобиль
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        this.engine.start();
    }
}