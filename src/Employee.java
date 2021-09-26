import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Employee
{
    String name;
    String employeeNumber;
    Date hireDate;

    //Constructor Employee
    public Employee(String n, String e, Date h)
    {
        this.name = n;
        this.employeeNumber = e;
        this.hireDate = h;
    }
    //no-arg constructor
    public Employee() {
    }
    
    public void setName(String n)
    {   
        this.name = n;
    }
    public void setEmployeeNumber(String e) throws InvalidEmployeeNumber{
        Pattern pattern = Pattern.compile("\\d\\d\\d\\-\\D");
        Matcher matcher = pattern.matcher(e);
        
        if(matcher.matches()){
            this.employeeNumber = e;
        }
        else{
            throw new InvalidEmployeeNumber();
        }
    }
    public void setHireDate(Date h)
    {   
        this.hireDate = h;
    }
    public String getName()
    {
        return name;
    }
    public String getEmployeeNumber()
    {
        return employeeNumber;
    }
    public Date getHireDate()
    {
        return hireDate;
    }
    //method check EmployeeNumber
    private boolean isValidEmpNum(String e)
    {
        boolean status = true;
        
        if(e.length() !=5)       /*Employee number in the format "XXX-L",X is a digit within 0-9, L is a letter in the range A-M*/
            status = false;
        else
        {
            if((!Character.isDigit(e.charAt(0)))||
            (!Character.isDigit(e.charAt(1)))||
            (!Character.isDigit(e.charAt(2)))||
            (e.charAt(3) != '-')||
            (!Character.isLetter(e.charAt(4)))||
            //check index 4 betweem A-M
            (!(e.charAt(4) >= 'A' && e.charAt(4) <= 'M')))
            {
                status = false;
            }
        }
        return status;
    }
    public String toString()
    {
        String str = "Name: " + name + "\nEmployee Number: ";
        if(employeeNumber == "")
        {
            str += "Invalid Employee Number";
        }
        else
        {
            str += employeeNumber;
        }
        str += ("\nHire Date: " + hireDate);
        return str;
    }

}



