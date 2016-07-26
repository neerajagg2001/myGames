package com.nee.games.api;

import java.util.Scanner;

public class ArrayTicTacToe implements TicTacToe {

  enum Players {
    X,O;
  }

  enum GameStatus {
    XWins,OWins,Draw,InProgress;
  }
  
  public ArrayTicTacToe(){
    initialize();
  }
  public static int numRows = 3;
  public static int numCols = 3;
  
  private String[][] gameState = new String[numRows][numCols];
  public static Scanner in = new Scanner(System.in);
  
  private int noOfInputs;
  public Players currentPlayer = Players.X;
  public int curRow,curCol;
  
  public boolean makeMove() {
    boolean isValid = false;
    do{
      System.out.println("Player "+currentPlayer+" .Please enter a position no. to make a move");
      int position = in.nextInt();
      curCol = (position-1)%3;
      curRow = ((position+2)/3)-1;
      if(position<=9 && position>0 && (gameState[curRow][curCol]!="X" && gameState[curRow][curCol]!="O")){
        gameState[curRow][curCol] = currentPlayer.toString();
        isValid=true;
        ++noOfInputs;
      }
      else{
        System.out.println("This is a invalid move!!!");
      }
    }while(isValid==false);
    return false;
  }

  public boolean hasWon() {
    if(gameState[curRow][0]==gameState[curRow][1] && gameState[curRow][1]==gameState[curRow][2]){
      System.out.println("*******Player "+currentPlayer+" has won the game*********");
      return true;
    }
    if(gameState[0][curCol]==gameState[1][curCol] && gameState[1][curCol]==gameState[2][curCol]){
      System.out.println("*******Player "+currentPlayer+" has won the game*********");
      return true;
    }
    if(curCol==curRow && gameState[0][0]==gameState[1][1] && gameState[1][1]==gameState[2][2]){
      System.out.println("*******Player "+currentPlayer+" has won the game*********");
      return true;
    }
    if((curCol+curRow)==2 && gameState[2][0]==gameState[1][1] && gameState[1][1]==gameState[0][2]){
      System.out.println("*******Player "+currentPlayer+" has won the game*********");
      return true;
    }
    return false;
  }

  public boolean isDraw() {
    if(noOfInputs==9){
      System.out.println("*******Game is a draw*********");
      return true;
    }
    return false;
  }

  public void initialize() {
    noOfInputs=0;
    currentPlayer = Players.X;
    int k =1;
   for(int i=0;i<numRows;++i){
     for(int j=0;j<numCols;++j){
       gameState[i][j]= String.valueOf(k);
       ++k;
     }
   }
  }

  public void printStatus() {
    for (int i = 0; i < numRows; i++) {
      System.out.print("|");
      for (int j = 0; j < numCols; j++) {
        System.out.print(gameState[i][j]);
        System.out.print("|");
      }
      if(i<numRows-1){
        System.out.println("");
        System.out.print("--------");
      }
      System.out.println("");
    }
    
  }

  public void updatePlayer() {
    if(currentPlayer==Players.X){
      currentPlayer=Players.O;
    }
    else{
      currentPlayer=Players.X;
    }
    
  }
}
