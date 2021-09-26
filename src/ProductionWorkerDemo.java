import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.DateFormat;
import java.util.InputMismatchException;

public class ProductionWorkerDemo {
    public static void main(String[] args) throws InvalidPayRate, InvalidShift, InvalidEmployeeNumber{
        //call to make an employee
        MakeEmployee();
    }
    
    public static void MakeEmployee() throws InvalidPayRate, InvalidShift, InvalidEmployeeNumber{
    //create a default date
        Date date = new Date(01/01/01);
        Scanner s = new Scanner(System.in);
        //create production worker object
        ProductionWorker worker = new ProductionWorker();
        
        try{
        //get employee shift
        System.out.println("Enter your shift (1 for day shift, 2 for night shift): ");
        worker.setShift(s.nextInt());
        //get employee payrate
        System.out.println("Enter your payrate: ");
        worker.setpayRate(s.nextDouble());

        //Get employee's name
        System.out.println("Enter your name: ");
        worker.setName(s.next());

        //get employee number
        System.out.println("Enter your employee number(XXX-L): ");
        s.nextLine();
        worker.setEmployeeNumber(s.next());

        s.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        //get employee hire date
        System.out.println("Enter date of hire for the employee(mm/dd/yyyy): ");
        String hireDateString = s.next();
        worker.setHireDate(dateFormat.parse(hireDateString));
        System.out.print("\nProduction Worker created!");
     //catch in the case user types in random characters   
    } catch (InputMismatchException ime){
        System.out.print("Input mismatch! Please enter an integer only.");
    } catch (Exception e){
        System.out.print(e);
    }
    
    }
    
}
