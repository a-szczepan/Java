import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private int counter = 0;
    private String[] board = {
            "-----------------------------\n",
            "|","      ","|","      ","|","      ","|","      ","|\n",
            "|---------------------------|\n",
            "|","      ","|","      ","|","      ","|","      ","|\n",
            "|---------------------------|\n",
            "|","      ","|","      ","|","      ","|","      ","|\n",
            "|---------------------------|\n",
            "|","      ","|","      ","|","      ","|","      ","|\n",
            "-----------------------------\n",
    };

    void printCounter(){
        System.out.println("S C O R E: " + this.counter);
    }

    void printBoard(){
        for (String s: board) {
            System.out.print(s);
        }
    }

    boolean isWin(){
        for (String s : this.board) {
            if(s.equals(" 2048 ")){
                return true;
            }
        }
        return false;
    }

    void generateBlock(){
        int index = this.getRandomIndex(board);
        this.board[index] = " 2    ";
    }

    void moveDown(){
        for (int i = 2; i<=28; i++){
            connectBlocks(i,10);
            for(int j = 2; j<=28; j++){
                if(excludeSeparator(j) & board[j+10].equals("      ")){
                    board[j+10]=board[j];
                    board[j]= "      ";
                }
            }
        }
    }

    void moveUp(){
        for(int i = 38; i>=12; i--){
            connectBlocks(i,-10);
            for(int j = 38; j>=12; j--){
                if(excludeSeparator(j) & board[j-10].equals("      ")){
                    board[j-10]=board[j];
                    board[j]= "      ";
                }
            }
        }
    }

    void moveRight(){
            for(int i = 2; i<=38; i++){
            connectBlocks(i,-2);
            for(int j = 38; j>=2; j--){
                if(excludeSeparator(j) & board[j+2].equals("      ")){
                    board[j+2]=board[j];
                    board[j]= "      ";
                }
            }
        }
    }

    void moveLeft(){
        for(int i = 38; i>=2; i--){
            connectBlocks(i,-2);
            for(int j = 38; j>=2; j--){
                if(excludeSeparator(j) & board[j-2].equals("      ")){
                    board[j-2]=board[j];
                    board[j]= "      ";
                }
            }
        }
    }

    private int getRandomIndex(String[] b){
        ArrayList<Integer> listOfInt = new ArrayList<>();
        for(int i=0; i< b.length; i++){
            if(b[i].equals("      ")){
                listOfInt.add(i);
            }
        }
        Random random = new Random();
        return listOfInt.get(random.nextInt(listOfInt.size()));
    }

    private boolean excludeSeparator(int positionToCheck){
        return !board[positionToCheck].equals("      ") & !board[positionToCheck].equals("|")
                & !board[positionToCheck].equals("|\n")
                & !board[positionToCheck].equals("|---------------------------|\n");
    }

    private void connectBlocks(int position, int shift){
        if( excludeSeparator(position) & board[position+shift].equals(board[position])){
            int newElement = Integer.parseInt(board[position].trim()) + Integer.parseInt(board[position+shift].trim());
            if(newElement < 16){
                counter+=newElement;
                board[position + shift] = " " + newElement + "    ";
                board[position]= "      ";
            }
            if(8 < newElement & newElement < 128){
                counter+=newElement;
                board[position + shift] = " " + newElement + "   ";
                board[position]= "      ";
            }
            if(64 < newElement & newElement < 1024){
                counter+=newElement;
                board[position + shift] = " " + newElement + "  ";
                board[position]= "      ";
            }
            if(512 < newElement & newElement <= 2048){
                counter+=newElement;
                board[position + shift] = " " + newElement + " ";
                board[position]= "      ";
            }
        }
    }

}

