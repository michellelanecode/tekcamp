import java.util.Scanner;

public class Sides  {
    String side = "no side";

    public void getSide() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Would you like a side? y or n");
       String answer = sc.nextLine();

       if(answer.equals("y")){
           System.out.println("What kind of side would you like?");
           this.side = sc.nextLine();
           this.returnSide();
       } else {
           this.returnSide();
       }
    }
    public String returnSide(){
        return this.side;
    }
}
