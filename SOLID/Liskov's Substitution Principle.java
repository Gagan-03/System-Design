

// A subclass and substitute all the object intances of a parent class

public class Vehicle {
    public void start_engine () {
        // logic goes here
    }
}

public class Car extends Vehicle {

    public void start_engine () {
        System.out.println("Car engine is starting");
    }
}

public class Bicycle extends Vehicle {
    public void start_engine () {
        //this doesn't make any sense for bicycle.
    }
}

// Therefore instead of having function like start_engine ehich might be irrelevant to other subclasses, the subclasses must be able to implement all the methods of the parent class.

public class Vehicle {
    public void start () {
        // logic goes here
    }
}

public class Car extends Vehicle {

    public void start () {
        System.out.println("Car is starting");
    }
}

public class Bicycle extends Vehicle {
    public void start () {
        System.out.println("Bicycle is starting");
    }
}
