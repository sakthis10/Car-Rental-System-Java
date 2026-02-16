import java.sql.Connection;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CarRentalSystem system=new CarRentalSystem();
        Connection c = DBConnection.getConnection();
       if(c != null){
    System.out.println("Connected to database successfully");
}
    while(true){
        System.out.println("1 Add car");
        System.out.println("2 View car");
        System.out.println("3 Rent car");
        System.out.println("4 Return car");
        System.out.println("5 exit");
        System.out.println("Enter a choice");
        int choice=sc.nextInt();
        if(choice==1){
            sc.nextLine();
            System.out.println("Enter a car name:");
            String name=sc.nextLine();
             system.addcar(name);

        }else if(choice==2){
            system.viewcar();
        }
        else if (choice==3) {
            sc.nextLine();
            System.out.println("enter a car name to rent");
            String rentcar=sc.nextLine();
           system.rentcar(rentcar);
            
        }
        else if(choice==4){
            sc.nextLine();
            System.out.println("enter a car name to return");
            String returncar=sc.nextLine();
           system.returncar(returncar);
        }
        else if(choice==5){
                 System.out.println("thank you");
                 break;
        }

    }
    }
}