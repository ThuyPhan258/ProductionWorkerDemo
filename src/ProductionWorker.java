import java.text.DecimalFormat;
import java.sql.Date;
import java.text.DateFormat;

public class ProductionWorker extends Employee
{
    //constant for the day and night shift
    public static final int DAY_SHIFT = 1;
    public static final int NIGHT_SHIFT = 2;
    private int shift;
    private double payRate;

    public ProductionWorker(String n, String num, Date date, int sh, double rate) throws InvalidPayRate, InvalidShift, InvalidEmployeeNumber{
        // throws exception if the hourly rate is below zero
        if(payRate < 0){
            throw new InvalidPayRate();
        }
        //throw exception if the shift is not 1 or 2
        if(shift < 1|| shift >2){
            throw new InvalidShift();
        }
        else{
            this.setName(n);
            this.setEmployeeNumber(num);
            this.setHireDate(date);
            this.setShift(sh);
            this.setpayRate(rate);
        }
    }
    
    public ProductionWorker(){
    }

    public void setShift(int s) throws InvalidShift{
        if(s < 1 || s > 2){
            throw new InvalidShift();
        }
        else{
            this.shift = s;
        }
    }

    public void setpayRate(double r) throws InvalidPayRate{
        if(payRate < 0){
            throw new InvalidPayRate();
        }
        else{
            this.payRate = r;
        }
    }
    
    public int getShift()
    {
        return shift;
    }
    public double getPayRate()
    {
        return payRate;
    }
    public String toString()
    {
        DecimalFormat dollar = new DecimalFormat("#, ##0.00");
        String str = super.toString();
        str += "\nShift: ";
        if(shift == DAY_SHIFT)
            str += "Day";
        else if(shift == NIGHT_SHIFT)
            str += "Night";
        else
            str += "Invalid Shift Number";
        str += ("\nHourly Pay Rate: $" +dollar.format(payRate));
        return str;
    }

}
