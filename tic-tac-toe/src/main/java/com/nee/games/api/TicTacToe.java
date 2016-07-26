package com.nee.games.api;

public interface TicTacToe {

  public boolean makeMove();
  public boolean hasWon();
  public boolean isDraw();
  public void initialize();
  public void printStatus();
  public void updatePlayer();
}
