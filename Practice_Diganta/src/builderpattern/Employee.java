package builderpattern;

public class Employee {
    private String name;
    private int age;
    private float salary;
    private String street;
    private String landMark;
    private String address;

    private Employee() {
    }

    public Employee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
        this.street = builder.street;
        this.landMark = builder.landMark;
        this.address = builder.address;
    }

    public static class EmployeeBuilder {
        private String name;
        private int age;
        private float salary;
        private String street;
        private String landMark;
        private String address;

        public EmployeeBuilder name(String name){
            this.name=name;
            return this;
        }
        public EmployeeBuilder age(int age){
            this.age=age;
            return this;
        }
        public EmployeeBuilder salary(float salary){
            this.salary=salary;
            return this;
        }
        public EmployeeBuilder street(String street){
            this.street=street;
            return this;
        }
        public EmployeeBuilder landMark(String landMark){
            this.landMark=landMark;
            return this;
        }
        public EmployeeBuilder address(String address){
            this.address=address;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }

    public static void main(String[] args) {
        Employee employee = new EmployeeBuilder().name("a").age(34).salary(4500f).street("x").landMark("y").address("z").build();
        System.out.println(employee);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public String getStreet() {
        return street;
    }

    public String getLandMark() {
        return landMark;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", street='" + street + '\'' +
                ", landMark='" + landMark + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
