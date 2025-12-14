package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =0;
        String answer = sc.nextLine();
        String[]tic = answer.split("");
        String [][] newArr= new String[3][3];
        int k= 0;
        System.out.println("---------");
        for (int i = 0; i <3 ; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3 ; j++) {
                if(tic[t].equals("_")){
                    tic[t] = " ";
                    System.out.print(" "+" ");
                }
                else {
                    System.out.print(tic[t]+" ");
                }
                newArr[i][j]=tic[t];
                t++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
        String answer2 = sc.nextLine();
        boolean isValid = validAnswer(answer2, newArr,"X");
        while (!isValid){
            answer2 = sc.nextLine();
            isValid = validAnswer(answer2, newArr,"X");
        }

    }
    public static void printArray(String[][]a){
        System.out.println("---------");
        for (int i = 0; i <3 ; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3 ; j++) {
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
                    original[a-1][b-1] = x;
                    printArray(original);
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
}
