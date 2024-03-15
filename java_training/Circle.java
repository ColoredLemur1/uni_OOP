public class Circle {
    private double radius;

    public Circle(double r){
        this.radius = r;
    }

    public double getRadius(){
        return radius;
    }

    public double Area(){
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double Perimeter(){
        return Math.PI * getRadius() * 2;
    }


    
}