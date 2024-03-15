import java.util.Scanner;


class CircleDemo{
    public static void main(String[] args){
        double Perimeter;
        double Area;
        Scanner rObject = new Scanner(System.in);
        System.out.println("Enter radius of Circle: ");

        double r = rObject.nextDouble();
         
        Circle cir = new Circle(r);
        Perimeter = cir.Perimeter();
        Area = cir.Area();

        System.out.printf("Radius: %f\n", cir.getRadius());
        System.out.printf("Perimeter: %f\n", Perimeter);
        System.out.printf("Area: %f\n", Area);





    }
}