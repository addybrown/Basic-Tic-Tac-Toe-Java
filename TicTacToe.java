/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author adams
 */
public class TicTacToe {
    
    public static int RowMap(int iRowInput)
    {   
        int iRowInputValue = 0;
        
        if (iRowInput==1 | iRowInput==2 | iRowInput==3)
        {
            iRowInputValue= 0;
        }
        if (iRowInput==4 | iRowInput==5 | iRowInput==6)
        {
            iRowInputValue= 2;
        }
        if (iRowInput==7 | iRowInput==8 | iRowInput==9)
        {
            iRowInputValue= 4;
        }
        return iRowInputValue;
    }
    
    public static int ColMap(int iColInput)
    {   
        int iColInputValue;
        iColInputValue = 0;
        
        if (iColInput==1 | iColInput==4 | iColInput==7)
        {
            iColInputValue= 1;
        }
        if (iColInput==2 | iColInput==5 | iColInput==8)
        {
            iColInputValue= 5;
        }
        if (iColInput==3 | iColInput==6 | iColInput==9)
        {
            iColInputValue= 9;
        }
        return iColInputValue;
    }
    
    
    public static String[][] InsertArray(int iInput,String x[][],String sValue)
    {
        String[][] Board;
        Board=new String[11][5];
        int iColumn,iRow;
        
        iColumn=ColMap(iInput);
        iRow=RowMap(iInput);
        
        for (int i=0;i<5;i++)
        {
            for (int j=0;j<11;j++)
            {
                Board[j][i]=x[j][i];
                
            }
        }
        
        
       Board[iColumn][iRow]=sValue;
        
        return Board;
       
    }
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        // TODO code application logic here
        
        //Declare Variables
        boolean bMove,bQuit,bPlayer,bWin;
        Scanner scan = new Scanner(System.in);
        String s;
        String sPlayer = null,sComputer = null;
        int iPlayer,iComputer;
        
        bQuit=false;
        bMove=true;
        
        
        //Introduction to Play, Asks If You Want To Play
        while(bMove) 
        {
            
            System.out.println("Welcome To TicTacToe: Do You Want to Play [Y/N]");
            
            s=scan.next();
            if (s.matches("Y") | s.matches("N"))
            {
                bMove=false;
                bQuit=s.matches("N");
            }
            else
            {
                System.out.println("Invalid Input: Try Again"); 
                bMove=true;
            }
            
            
        }
        
        
        //Exits Program If You Do Not Want To Play
        if (bQuit==true)
        {
            System.out.println("Goodbye"); 
            System.exit(0);
        }
        
        bMove=true;
        
        
        //Ask Player To Select Character X or O 
        do
        {
            
            System.out.println("Do you want to be X? [Y/N]");
            s=scan.next();
            if (s.matches("Y"))
            {
                bMove=false;
                sPlayer="X";
                sComputer="O";
                
            }
            else if (s.matches("N"))
            {
                bMove=false;
                sPlayer="O";
                sComputer="X";
            }
            else
            {
               System.out.println("Invalid Input: Try Again"); 
            }
            
            System.out.println(sPlayer);
            
        }while(bMove);
        
         //Player Fill Character and Computer Character Fill. 
         
       
             //sPlayer="X";
             //sComputer="O";
       
        //Create Board 
        String[][] Board;
        

        //Object Declaration
        Board TicTacToe= new tictactoe.Board();
        Computer cComp= new tictactoe.Computer();
        
        //Creates the Board and fills to a 2-D Array 
        Board=TicTacToe.display_create();
        TicTacToe.display_print(Board);
        System.out.println(ColMap(3));
       
        
        
        boolean bWinPlayer,bWinComputer,bAval;
        
        bWin=true;
        
        int iRow,iCol;
        
        //Prompt Play Within Loop
        do
        {
            //Prompt Player Input Ensures Position is Available, Stuck in Loop Until Correct Position
            do
            {
                System.out.println("Please Input Position:");
                iPlayer=scan.nextInt();
                iRow=RowMap(iPlayer);
                iCol=ColMap(iPlayer);
                //Check If Position Available
                bAval=TicTacToe.available_position(Board, iRow, iCol);
                if (bAval)
                {
                    break;
                }
                else
                {
                    System.out.println("Position Not Available Try Again!!");
                }
            }while(!bAval);
            
            
            //Update Player Array
            Board=InsertArray(iPlayer,Board,sPlayer);
            //System.out.flush();
            
            //Update Board
            TicTacToe.display_print(Board);
            
            //Check if Winner 
            bWinPlayer=cComp.Winner_Check(Board);
            
            //Exits Loop Once Player Wins
            if (bWinPlayer)
            {
                break;
            }
            
         
            //Prompt Computer Input 
            iComputer=cComp.Computer_Input(Board);
           
            Board=InsertArray(iComputer,Board,sComputer);
            System.out.flush();
            
            //Check Winner 
            TicTacToe.display_print(Board);
            bWinComputer=cComp.Winner_Check(Board);
            
            
            //Exits Loop Once Computer Wins
            if (bWinComputer)
            {
                break;
            }
            
        }while(bWin);
        
        if(bWinPlayer)
        {
            System.out.println("Congrats You Won!!!");
        }
        else 
        {
            System.out.println("Oh No You Lost!!");
        }
      
         
    }
    
}
