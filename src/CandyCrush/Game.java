package CandyCrush;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        char[][] game={{'a','b','b','a','c'},
                       {'b','g','f','b','a'},
                       {'a','f','b','f','v'},
                       {'g','a','b','a','b'},
                       {'t','c','a','a','c'}};

        Scanner sc=new Scanner(System.in);


        while (true){
            print(game);
            System.out.println("if you want quit game press 'a'");

            System.out.println("enter swap row and col\n enter row");
            int mrow=sc.nextInt();
            System.out.println("enter column");
            int mcol=sc.nextInt();
            System.out.println("enter swap location\n enter row");
            int srow=sc.nextInt();
            System.out.println("enter column");
            int scol=sc.nextInt();
            swap(game,mrow,mcol,srow,scol);
             char ch1=game[mrow][mcol];
            char ch2=game[srow][scol];
          int count1= 0;isNeedSwpa(game,mrow,mcol,0,game[mrow][mcol]);
            for (int i = 0; i <game[0].length ; i++) {
                if (game[mrow][i]=='1')count1++;
            }
            int count2=0; isNeedSwpa(game,srow,scol,0,game[srow][scol]);
            for (int i = 0; i <game[0].length ; i++) {
                if (game[srow][i]=='1')count2++;
            }
            if(count1<3&&count2<3){
                for (int i = 0; i <game[0].length ; i++) {
                    if (game[mrow][i]=='1')game[mrow][i]=ch1;
                }
                for (int i = 0; i <game[0].length ; i++) {
                    if (game[srow][i]=='1')game[srow][i]=ch2;
                }
            }else if (count1<3){
                for (int i = 0; i <game[0].length ; i++) {
                    if (game[mrow][i]=='1')game[mrow][i]=ch1;
                }
            }else {
                for (int i = 0; i <game[0].length ; i++) {
                    if (game[srow][i]=='1')game[srow][i]=ch2;
                }
            }
            if (count1>=3&&count2>=3){
                burst(game,mrow,mcol);
                burst(game,srow,scol);
            }else if(count1>=3){
                burst(game,mrow,mcol);
            }else if(count2>=3){
                burst(game,srow,scol);
            }
            print(game);
            System.out.println("if some in game need to burst\n press 1 or press 2");
            int opt=sc.nextInt();
            while (true) {
                print(game);
                if (opt == 1) {
                    System.out.println("enter row");
                    int row = sc.nextInt();
                    System.out.println("enter col");
                    int col = sc.nextInt();
                    isNeedSwpa(game,row,col,0,game[row][col]);
                    burst(game, row, col);
                }else{
                    break;
                }
            }
        }
    }

    private static void burst(char[][] game, int row, int col) {
        if (row == 0) {
            for (int j = 0; j < game[0].length; j++) {
                if (game[row][j] == '1') {
                    game[row][j] = ' ';
                }
            }
            return;
        }
        while (row >= 1) {
            for (int j = 0; j < game[0].length; j++) {
                if (game[row][j] == '1') {
                    swap(game, row, j, row - 1, j);
                }


            }
            row--;
        }
        for (int j = 0; j < game[0].length; j++) {
            if (game[row][j] == '1') {
                game[row][j] =' ';
            }


        }
    }

    private static void rearrange(char[][] game, char ch, int row, int col) {
        if (row<0||col<0||row>=game.length||col>=game[0].length||game[row][col]!='1'){
            return ;
        }
        game[row][col]=ch;
        rearrange(game,ch, row, col+1);
        rearrange(game, ch,row, col-1);
    }

    private static int isNeedSwpa(char[][] game, int row, int col, int count, char ch) {
        if (row<0||col<0||row>=game.length||col>=game[0].length||game[row][col]!=ch){
            return count;
        }

            game[row][col] = '1';

      count=count+  isNeedSwpa(game, row, col+1, count+1, ch);
        count=count+ isNeedSwpa(game, row, col-1, count+1, ch);
        return count;
    }

    static void dfs(char[][]game){

    }
    static void swap(char[][]game,int mrow,int mcol,int srow,int scol){
        char temp=game[mrow][mcol];
        game[mrow][mcol]=game[srow][scol];
        game[srow][scol]=temp;

    }

    static void print(char[][]game){
        for (int i = 0; i < game.length; i++) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.print("-------------");
        System.out.println();
        for (int i = 0; i <game.length ; i++) {
            for (int j = 0; j <game[0].length ; j++) {
                System.out.print(game[i][j]+" ");
            }

            System.out.print("| "+i);
            System.out.println();
        }
    }
}
