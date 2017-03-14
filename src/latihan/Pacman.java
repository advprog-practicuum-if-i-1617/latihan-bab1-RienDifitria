package pac;
import java.util.Scanner;
public class Pacman {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);      
        
        Castle castle = new Castle();
        castle.buildCastle();
        castle.distributeFood();
        castle.PacmanBorn();

        int i = 25;
        String key;
        
        while( !castle.isEmpty() && i>0  ){
            
            castle.print();
            if (i>1){
                System.out.print("Moves left : "+ (i-1) +"\nPress w/a/s/d ... ");
            }
            else if (i==1){
                System.out.println("You Lose!");
                break;
            }
            key = in.nextLine();
            System.out.println("");
            castle.move(key.toLowerCase());
            i--;
            
        }
        
        if(castle.isEmpty()){
            castle.print();
            System.out.println("You Win!");
        }
    }
}