
import java.util.*;
/* A class is open to expansion but close to modification */

class ShapeCalculator {
    public int calculateArea (String shape) {
        if (shape.type == 'Rectangle') {
            return  (shape.width * shape.height);
        } else if (shape.type == 'Circle') {
            return (3.14*2*shape.radius);
        }
    }
}

/* Adding new shape would mean modifying the already witten code. Instead use an interface which overrides the area calculator method */

public interface Shape {
    int calculateArea();
}

class Rectangle implements Shape {

    private int height, width;

    Rectangle (int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public int calculateArea () {
        return (this.height*this.width);
    }
}