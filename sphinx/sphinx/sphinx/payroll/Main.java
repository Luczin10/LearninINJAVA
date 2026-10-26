abstract class Employee {
    private final String name;

    Employee(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract String type();

    abstract double pay();
}

class Salaried extends Employee {
    private final double monthly;

    Salaried(String name, double monthly) {
        super(name);
        this.monthly = monthly;
    }

    String type() {
        return "Salaried";
    }

    double pay() {
        return monthly;
    }
}

class Hourly extends Employee {
    private final double rate;
    private final double hours;

    Hourly(String name, double rate, double hours) {
        super(name);
        this.rate = rate;
        this.hours = hours;
    }

    String type() {
        return "Hourly";
    }

    double pay() {
        double regular = Math.min(hours, 160);
        double overtime = Math.max(0, hours - 160);
        return regular * rate + overtime * rate * 1.5;
    }
}

class Commissioned extends Employee {
    private final double base;
    private final double sales;
    private final double percent;

    Commissioned(String name, double base, double sales, double percent) {
        super(name);
        this.base = base;
        this.sales = sales;
        this.percent = percent;
    }

    String type() {
        return "Commissioned";
    }

    double pay() {
        return base + sales * percent / 100;
    }
}

void main() {
    int n = Integer.parseInt(IO.readln().trim());
    List<Employee> staff = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        String[] p = IO.readln().trim().split(" ");
        if (p[0].equals("salaried")) {
            staff.add(new Salaried(p[1], Double.parseDouble(p[2])));
        } else if (p[0].equals("hourly")) {
            staff.add(new Hourly(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3])));
        } else if (p[0].equals("commission")) {
            staff.add(new Commissioned(p[1], Double.parseDouble(p[2]),
                    Double.parseDouble(p[3]), Double.parseDouble(p[4])));
        }
    }

    double total = 0;
    Employee top = null;
    for (Employee e : staff) {
        double pay = e.pay();
        IO.println(String.format(Locale.US, "%s (%s): %.2f", e.getName(), e.type(), pay));
        total += pay;
        if (top == null || pay > top.pay()) {
            top = e;
        }
    }

    IO.println(String.format(Locale.US, "Total payroll: %.2f", total));
    IO.println("Top earner: " + top.getName());
}