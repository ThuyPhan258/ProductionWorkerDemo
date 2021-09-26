public class InvalidEmployeeNumber extends Exception{
    public InvalidEmployeeNumber(){
        System.out.print("The employee number you have entered is not valid! It should has format XXX-L");
    }
}