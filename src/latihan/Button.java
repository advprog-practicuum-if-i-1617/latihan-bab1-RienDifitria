package pac;
public class Button {
    
    //lokasi awal pacman
    int x = 1;
    int y = 7;
    
    //pacman naik ke atas, koordinat x berkurang
    void W(){
        x--;
    }
    
    //pacman geser ke kiri, koordinat y berkurang
    void A(){
        y--;
    }
    
    //pacman turun ke bawah, koordinat x bertambah
    void S(){
        x++;
    }
    
    //pacman geser ke kanan, koordinat y bertambah
    void D(){
        y++;
    }
    
}
