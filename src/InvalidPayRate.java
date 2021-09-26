public class InvalidPayRate extends Exception{
    public InvalidPayRate(){
        System.out.print("The payrate you have entered is not valid! You cannot place a negative hourly wage!");
    }
}