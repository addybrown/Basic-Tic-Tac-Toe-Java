/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;


/**
 *
 * @author adams
 */
public class Board 
{

    
    
    //This Method Displays the Board on the Screen From the Input Array
    public void display_print(String x[][])
    {
        for (int i=0;  i<5; i++)
        {
            for (int j=0; j<11; j++)
            {
                System.out.print(x[j][i]);
                if (j==10)
                {
                    System.out.println("");
                }
            }
            
        }
        
    }
    
    
    //This Function Takes Text File board.txt and outputs a 2-D String Array 
    public String[][] display_create() throws FileNotFoundException
            
    {
        String token1;
        token1 = "";
        Scanner inFile1;
        inFile1 = new Scanner(new File("C:\\Users\\adams\\OneDrive\\Documents"
                + "\\NetBeansProjects\\TicTacTow\\src\\tictactoe\\"
                + "board.txt")).useDelimiter("\n");
        List<String> temps = new ArrayList<>();
        while (inFile1.hasNext()) 
        {
         /// find next line
         token1 = inFile1.next();
         temps.add(token1);
        }
        inFile1.close();
        
        String[] tempsArray = temps.toArray(new String[0]);
        String[][] Value;
        Value=new String[11][5];
        for (int i=0; i<5;i++) 
        {
             for (int j=0; j<11;j++)
             {
                 Value[j][i]=String.valueOf(tempsArray[i].charAt(j));
             }
        }
       
       
        return Value;
        
    }
        
    
    public boolean available_position(String[][] x,int iRow,int iCol)
    {
        boolean isAval;
        isAval=false;
        
        if (x[iCol][iRow].matches(" "))
        {
           isAval=true; 
        }
 
        return isAval;
    }
    
 
   
}
