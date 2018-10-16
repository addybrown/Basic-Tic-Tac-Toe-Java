/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.util.ArrayList;
//import java.util.List;
import java.util.Random;

/**
 *
 * @author adams
 */
public class Computer 
{
       
    public int Computer_Input(String x[][])
    {
       int iInput;
       
       ArrayList<Integer> storage = new ArrayList<>();
       

       int iCounter;
       iCounter=0;
       
       for (int i=0; i<5;i++)
       {
           for (int j=0;j<11;j++)
           {
               
               if (x[j][i].matches(" "))
               {
                   
                   //System.out.println(x[j][i].matches(" "));
                   //System.out.print(i);
                   if(i==0)
                   {
                       
                       if (j==1)
                       {   
                        
                           storage.add(1);
                       }
                       if (j==5)
                       {
                           
                           storage.add(2);
                       }
                       if (j==9)
                       {
                           
                           storage.add(3);
                       }
                       
                   }
                   if(i==2)
                   {
                       if (j==1)
                       {
                           
                           storage.add(4);
                       }
                       if (j==5)
                       {
                           
                           storage.add(5);
                       }
                       if (j==9)
                       {
                           
                           storage.add(6);
                       }
                   }
                   if(i==4)
                   {
                       if (j==1)
                       {
                           
                           storage.add(7);
                       }
                       if (j==5)
                       {
                           
                           storage.add(8);
                       }
                       if (j==9)
                       {
                           
                           storage.add(9);
                       }
                       
                   }
                   
                   iCounter=iCounter+1;
               }
           }
           
       }

    int[] iStorage;
    
    iStorage=new int[storage.size()];
    
    int iCount=0;  
    for (Integer storage1 : storage) 
        {   
         iStorage[iCount]=storage1;
         iCount=iCount+1; 
        }
     iInput = iStorage[new Random().nextInt(iStorage.length)];
     
     
     return iInput;
      
    }   
    
   // @SuppressWarnings("empty-statement")
    public boolean Winner_Check(String x[][])
    {
        boolean bWinner = false;
        
        int iRow[];
        iRow = new int[]{1,5,9};
        
        int iCol[];
        iCol=new int[]{0,2,4};
        
        int iCount,iFlag;
        
        
        iCount=0;
        iFlag=0;
       
        //Vertical Check
        do 
        {
          if (
                  ( x[iRow[iCount]][0].matches("O") && x[iRow[iCount]][2].matches("O") && x[iRow[iCount]][4].matches("O") )
                  
                  |
                  
                  ( x[iRow[iCount]][0].matches("X") && x[iRow[iCount]][2].matches("X") && x[iRow[iCount]][4].matches("X") )
                                    
             )
          {
        
              bWinner=true;
          }
          
          iCount=iCount+1;
            
        }while (iCount<3);
        
        iCount=0;
        //Horizontal Check
        do 
        {
          if (
                  ( x[1][iCol[iCount]].matches("O") && x[5][iCol[iCount]].matches("O") && x[9][iCol[iCount]].matches("O") )
                  
                  |
                  
                  ( x[1][iCol[iCount]].matches("X") && x[5][iCol[iCount]].matches("X") && x[9][iCol[iCount]].matches("X") )
                                    
             )
          {
            
              bWinner=true;
          }
          
          iCount=iCount+1;
            
        }while (iCount<3);
        
        //Diagonal Check 1
        
        if (
                  ( x[1][0].matches("O") && x[5][2].matches("O") && x[9][4].matches("O") )
                  
                  |
                  
                  ( x[1][0].matches("X") && x[5][2].matches("X") && x[9][4].matches("X") )
                                    
             )
          {
            
              bWinner=true;
          }
        
        //Diagonal Check 2
        if (
                  ( x[9][0].matches("O") && x[5][2].matches("O") && x[1][4].matches("O") )
                  
                  |
                  
                  ( x[9][0].matches("X") && x[5][2].matches("X") && x[1][4].matches("X") )
                                    
             )
          {
            
              bWinner=true;
          }
        
           
        return bWinner;
    }
    
    
}

