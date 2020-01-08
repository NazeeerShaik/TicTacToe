public class Player{
    int x,y;
    char symbol;
    Player(char symbol){
        this.symbol=symbol;
    }
    public  void desiredLocation(){
        x=(int)(Math.random()*3);
        y=(int)(Math.random()*3);
    }
}