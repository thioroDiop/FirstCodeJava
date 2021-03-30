class Stone{
    private boolean firstPlayer;
    public Stone(boolean firstPlayer) {
        this.firstPlayer= firstPlayer;
    }
    public boolean isFirstPlayer() {
        return firstPlayer;
    }
    public void setFirstPlayer(boolean firstPlayer) {
        this.firstPlayer= firstPlayer;
    }
    public String toString() {
        return firstPlayer ? "O":"X";
    }
}

public class DebugArray2DObjects {
    public static Stone[] initializedArray(Stone s, int nb){
        Stone[] res= new Stone[nb];// tableau de référence vers des objects
        for(int i=0; i != res.length; ++i){
            res[i]= new Stone(s.isFirstPlayer());//initialisation du res[i]

        }
        return res;
    }

    public static Stone[][] initializedArray2D(Stone[] arr, int nb){
        Stone[][] res= new Stone[nb][arr.length];
        for(int i=0; i != res.length; ++i){
            for (int j = 0; j != arr.length ; j++) {
                res[i][j]= new Stone(arr[j].isFirstPlayer());

            }
            //res[i]= arr;
        }
        return res;
    }


    public static void display(Stone[][] board){
        for(Stone[] row : board){
            for(Stone c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Stone[][] screen= initializedArray2D(initializedArray(new Stone(false), 20), 20);
        for(int i= 0; i != Math.min(screen.length, screen[0].length); ++i){
            screen[i][i].setFirstPlayer(true);
            screen[screen.length-i-1][i].setFirstPlayer(true);
        }
        display(screen);
    }
}