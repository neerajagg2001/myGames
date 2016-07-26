package com.nee.games.api;

public class TicTacToeRunner {

  public static void main(String[] args) {
    TicTacToe game = new ArrayTicTacToe();
    game.printStatus();
    boolean exitStatus = false;
    do{
      game.makeMove();
      exitStatus = game.hasWon() || game.isDraw();
      game.printStatus();
      game.updatePlayer();
    }while(!exitStatus);
  }
}
