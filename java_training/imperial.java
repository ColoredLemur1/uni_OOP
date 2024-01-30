
import java.util.Scanner;
//import Scanner class

class imperial{
    public static void main(String[] args){

        double kilograms;
        double pounds;
        int integerPounds;
        double oz;
        
        //user input
        Scanner sObject = new Scanner(System.in);
        System.out.println("Enter weight in kilograms: ");

        kilograms = sObject.nextDouble();

        pounds = kilograms * 2.205;
        oz = pounds % 1;
        oz = oz * 16;
        integerPounds=(int)pounds;

        System.out.printf("Equivalent imperial weight is: %d lb %.2f",integerPounds,oz);




    }
}