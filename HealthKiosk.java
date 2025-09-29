import java.util.Scanner;
import java.util.Random;
public class HealthKiosk {
    public static void main (String[]args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your weight in kg:");
        double weight = scanner.nextDouble();
        System.out.println("Enter your height in meters:");
        scanner.nextLine();
        double height = scanner.nextDouble();
        double bmi = weight / (height*height);
        System.out.println("Enter a service code(P,L,T or ,C): ");
        char code = scanner.next().charAt(0);
        switch(code) {
            case 'P','p'-> System.out.println("Go to pharmacy desk"); 
            case 'L','l'-> System.out.println("Go to the lab desk");
            case 'T','t'-> System.out.println("Go to the triage desk");
            case 'C','c'-> System.out.println("Go to the counselling desk");
            default -> System.out.println("Invalid service code");
            }
        
        int metric = 0;
        if (code == 'T' || code == 't') {
            System.out.println("Enter a metric 1-3:");
            metric =scanner.nextInt();
            if (metric == 1) {
            
                System.out.println("");
                System.out.println("Your BMI is " + Math.round(bmi*10)/10.0);
            
            if (bmi< 18.5) {
                System.out.println("Category:Underweight");
            } else if (bmi<25.0){
                System.out.println("Category:Normal");
            }else if (bmi<30.0){
                System.out.println("Category:Overweight");
            }else{
                System.out.println("Category:Obese");
            }

            } else if (metric == 2){
                System.out.println("Enter the required dosage in mg");
                double dosage = scanner.nextDouble();
                if (dosage > 250){
                    System.out.println("The pharmacy only dispenses tablets of 250 mg");
                }
                int tablets = (int) Math.ceil(dosage/250);
                System.out.println("Number of tablets: " + tablets);
            } else if (metric == 3){
                System.out.println("Enter an angle in degrees");
                double angle = scanner.nextDouble();
                double sin = Math.sin(angle);
                double cos = Math.cos(angle);
                System.out.println("Sine of the angle is " + (Math.round(sin*1000)/1000.0) + " radians");
                System.out.println("Cosine of the angle is "+ (Math.round(cos*1000)/1000.0) + " radians");
            }
        
        }    
        
        Random rand = new Random();
        char letter = (char) ('A' + rand.nextInt(26));
        int num1= 2 + (int) (Math.random() * 8);
        int num2= 2 + (int) (Math.random() * 8);
        int num3= 2 + (int) (Math.random() * 8);
        int num4= 2 + (int) (Math.random() * 8);

        String id ="" + letter + num1 + num2 + num3 + num4 ;
        System.out.println("String ID: "+ id);

        if (id.length() == 5){
            if (Character.isLetter(id.charAt(0))) {
                if (Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)) && Character.isDigit(id.charAt(3)) && Character.isDigit(id.charAt(4))) {
                    System.out.println("Valid ID");
        }else {
            System.out.println("Invalid ID");
        }
        } else {
            System.out.println("Invalid ID");
        }
    }
    System.out.println("");

    


        System.out.println("Enter your first name: ");
        scanner.nextLine();
        String first_name= scanner.nextLine();
        char base = first_name.charAt(0);
        char upper= Character.toUpperCase(base);
        char shift = (char) ('A' + (upper - 'A' + 2) % 26);
        String last_two_id  = id.substring(3,5);
        String final_code = "";
        if (metric ==1){
            int last_two_bmi = (int) Math.round(bmi);
            final_code = ""+ shift + last_two_id + last_two_bmi;
        }
        System.out.println("Summary: " + "TRIAGE" + "|" +"ID: " +id + "|" + "Final Code: " + final_code);

        
        scanner.close();
        }
    }