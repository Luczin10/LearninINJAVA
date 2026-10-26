interface Animal {
    String name();

    String sound();
}

class Dog implements Animal {
    public String name() {
        return "dog";
    }

    public String sound() {
        return "Woof";
    }
}

class Cat implements Animal {
    public String name() {
        return "cat";
    }

    public String sound() {
        return "Meow";
    }
}

class Cow implements Animal {
    public String name() {
        return "cow";
    }

    public String sound() {
        return "Moo";
    }
}

class Duck implements Animal {
    public String name() {
        return "duck";
    }

    public String sound() {
        return "Quack";
    }
}

void main() {
    int n = Integer.parseInt(IO.readln().trim());
    String[] types = IO.readln().trim().split(" ");
    Animal[] animals = new Animal[n];

    for (int i = 0; i < n; i++) {
        String type = types[i];
        switch (type) {
            case "dog" -> animals[i] = new Dog();
            case "cat" -> animals[i] = new Cat();
            case "cow" -> animals[i] = new Cow();
            case "duck" -> animals[i] = new Duck();
        }
    }

    for (Animal animal : animals) {
        IO.println("The " + animal.name() + " says " + animal.sound() + "!");
    }
}