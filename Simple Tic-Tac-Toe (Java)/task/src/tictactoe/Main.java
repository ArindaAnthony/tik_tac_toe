package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][] tic = new String[3][3];
        printArray(tic);
        String temp = "O";
        while (true){
            String answer2 = sc.nextLine();

            boolean isValid = validAnswer(answer2, tic,"X");
            if (!isValid){
                continue;
            }if (temp.equals("O")){
                temp = "X";
            }else {
                temp="O";
            }
            String[][]n =newArray(answer2,tic,temp);
            printArray(n);
            if (wins(n)){
                break;
            }
            if (isDraw(n)){
                System.out.println("Draw");
                break;
            }
            if (!isEmpty(n)){
                break;
            }

        }
    }
    public static void printArray(String[][]a){
        System.out.println("---------");
        for (int i = 0; i <3 ; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3 ; j++) {
                if (a[i][j]==null){
                    a[i][j] = " ";
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean validAnswer(String ans, String[][]original, String x){
        String[]tac = ans.split(" ");
        boolean isValid = false;
        int a=0;
        int b=0;
        try{
            a = Integer.parseInt(tac[0]);
            b = Integer.parseInt(tac[1]);
            if(a<=3&&b<=3){
                if (original[a-1][b-1].equals(" ")){
                    //original[a-1][b-1] = x;
                    //printArray(original);
                    isValid = true;
                }else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }catch (Exception e){
            System.out.println("You should enter numbers!");
        }
        return isValid;
    }
    public static boolean wins(String[][] tic){
        String [] tac = new String[9];
        int t=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tac[t]=tic[i][j];
                t++;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            if (!tac[i].equals(" ") &&
                    tac[i].equals(tac[i + 1]) &&
                    tac[i].equals(tac[i + 2])) {
                System.out.println(tac[i] + " wins");
                return true;
            }
        }

        // columns
        for (int i = 0; i < 3; i++) {
            if (!tac[i].equals(" ") &&
                    tac[i].equals(tac[i + 3]) &&
                    tac[i].equals(tac[i + 6])) {
                System.out.println(tac[i] + " wins");
                return true;
            }
        }

        // diagonals
        if (!tac[0].equals(" ") &&
                tac[0].equals(tac[4]) &&
                tac[0].equals(tac[8])) {
            System.out.println(tac[0] + " wins");
            return true;
        }

        if (!tac[2].equals(" ") &&
                tac[2].equals(tac[4]) &&
                tac[2].equals(tac[6])) {
            System.out.println(tac[2] + " wins");
            return true;
        }

        return false;
    }
    public static String[][] newArray(String ans, String[][]original, String x){
        String[]tac = ans.split(" ");
        boolean isValid = false;
        int a=Integer.parseInt(tac[0]);
        int b=Integer.parseInt(tac[1]);

        if (original[a-1][b-1].equals(" ")){
            original[a-1][b-1] = x;
        }
        return original;
    }
    public static boolean isEmpty(String[][]original){
        boolean containsNull = false;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (original[i][j].equals(" ")){
                    containsNull = true;
                }
            }

        }return containsNull;
    }
    public static boolean isDraw(String[][]n){
        String temp = "a";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n[i][j].equals(" ")){
                    temp = " ";
                    return false;
                }
            }

        }
        return true;
    }
}
