public class Board{
    private char[][] board=new char[3][3];
    private int noOfTurns=0;
    private void initBoard(){
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
    }
    private boolean isBoardFull(){
        return noOfTurns == 9;
    }
    private boolean isPlayerWin(char ch){
        return (board[0][0] == ch && board[0][1] == ch && board[0][2] == ch)
                || (board[1][0] == ch && board[1][1] == ch && board[1][2] == ch)
                || (board[2][0] == ch && board[2][1] == ch && board[2][2] == ch)
                || (board[0][0] == ch && board[1][0] == ch && board[2][0] == ch)
                || (board[0][1] == ch && board[1][1] == ch && board[2][1] == ch)
                || (board[0][2] == ch && board[1][2] == ch && board[2][2] == ch)
                || (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch)
                || (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch);
    }
    private boolean checkAvailabilityOfLocation(int x,int y){
        return board[x][y] == ' ';
    }
    private void displayBoard(){
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print("|"+board[i][j]);
            }
            System.out.println("|");
        }
    }
    private void setLocation(int x,int y,char ch){
        board[x][y]=ch;
    }
    public void startGame(){
        initBoard();
        Player player1=new Player('X');
        Player player2=new Player('O');
        Player currentPlayer=player1;
        boolean isWinner=false;
        while(!isBoardFull()) {
            currentPlayer.desiredLocation();
            int x=currentPlayer.x;
            int y=currentPlayer.y;
            if(checkAvailabilityOfLocation(x,y)) {
                System.out.println(currentPlayer.symbol+"("+x+","+y+")");
                setLocation(x,y,currentPlayer.symbol);
                noOfTurns++;
                displayBoard();
                System.out.println();
                if(isPlayerWin(currentPlayer.symbol)){
                    System.out.println(currentPlayer.symbol+" wins !");
                    isWinner=true;
                    break;
                }
                if(currentPlayer==player1) currentPlayer=player2;
                else currentPlayer=player1;
            }
        }
        if(!isWinner) System.out.println("Tie :(");
    }
}
