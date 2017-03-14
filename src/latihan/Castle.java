package pac;
public class Castle {

    boolean[][] castle = new boolean[10][10];
    boolean[][] food = new boolean[10][10];
    boolean[][] pacmanPos = new boolean[10][10];
    
    Button pacman = new Button();

    void turnFoodTrue(int x, int y) {
        food[x][y] = true;
    }
    
    void turnFoodFalse(int x, int y) {
        food[x][y] = false;
    }
    
    void turnPacTrue(int x, int y) {
        pacmanPos[x][y] = true;
    }
    
    void turnPacFalse(int x, int y) {
        pacmanPos[x][y] = false;
    }
    
    void PacmanBorn(){
        turnPacTrue(pacman.x, pacman.y);
    }
     
    //jika makanan dan pac nya ada di x,y yg sama maka makanan ilang, pac disitu
    boolean isEat(){
        if(food[pacman.x][pacman.y] && pacmanPos[pacman.x][pacman.y] ){
            turnFoodFalse(pacman.x, pacman.y);
            return true;
        }
        return false;
    }
    
    void turnCastleTrue(int x, int y) {
        castle[x][y] = true;
    }
    
    void buildCastle() {
        //batas castle nya
        for (int i = 0; i < 10; i++) {
            turnCastleTrue(0, i);
            turnCastleTrue(9, i);
            turnCastleTrue(i, 0);
            turnCastleTrue(i, 9);
        }
        // # yg ada didalem castle
        turnCastleTrue(2, 1);
        turnCastleTrue(2, 5);
        turnCastleTrue(2, 6);
        turnCastleTrue(2, 7);
        turnCastleTrue(2, 8);
        turnCastleTrue(4, 1);
        turnCastleTrue(4, 5);
        turnCastleTrue(5, 5);
        turnCastleTrue(5, 6);
        turnCastleTrue(5, 7);
        turnCastleTrue(5, 8);
        turnCastleTrue(6, 7);
        turnCastleTrue(7, 3);
        turnCastleTrue(7, 4);
        turnCastleTrue(8, 4);
        turnCastleTrue(8, 5);
    }
    
    //makanannya ada 2
    void distributeFood(){
        turnFoodTrue(1, 6);//dikoordinat 1,6
        turnFoodTrue(2, 2);//dikoordinat 2,2
        turnFoodTrue(3, 1);
        turnFoodTrue(4, 8);
        turnFoodTrue(5, 1);
        turnFoodTrue(6, 3);
    }
    
    //pengulangan didalem castle
    boolean isEmpty(){
        int num = 0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(food[i][j]){
                    num++;
                }
            }            
        }
        return num==0;
    }
    
    void print(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(castle[i][j]){
                    System.out.print("#");
                }else if(food[i][j]){
                    System.out.print("o");
                }else if(pacmanPos[i][j]){
                    System.out.print("☻");
                }
                else{
                    System.out.print(" ");
                }
            } System.out.println("");
        }
    }
    
    void move(String key){
        switch(key){
                case "w" : 
                    if( !castle[pacman.x-1][pacman.y] ){
                        turnPacFalse(pacman.x, pacman.y); //pac ilang
                        pacman.W(); //lalu pindah koordinat, dg x--
                        turnPacTrue(pacman.x, pacman.y); //pac pindah disini
                    } break;
                case "a" : 
                    if( !castle[pacman.x][pacman.y-1] ){
                        turnPacFalse(pacman.x, pacman.y);
                        pacman.A();
                        turnPacTrue(pacman.x, pacman.y);
                    } break;
                case "s" : 
                    if( !castle[pacman.x+1][pacman.y] ){
                        turnPacFalse(pacman.x, pacman.y);
                        pacman.S();
                        turnPacTrue(pacman.x, pacman.y);
                    } break;
                case "d" : 
                    if( !castle[pacman.x][pacman.y+1] ){
                        turnPacFalse(pacman.x, pacman.y);
                        pacman.D();
                        turnPacTrue(pacman.x, pacman.y);
                    } break;
            }
        isEat();//karena methode isEat dipanggil, maka food pd x,y ilang
    }
}
