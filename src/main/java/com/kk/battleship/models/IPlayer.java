package com.kk.battleship.models;
import java.util.List;

import com.kk.battleship.enums.HitResult;


public interface IPlayer {

 public HitResult hit(IPlayer player);
 
 public String getName();
 
 public boolean won();
 
 public boolean lost();
 
 public HitResult getHitResult(String hitCellLocation);
 
 public void initializeMissileTargets(List<String> targets);
 
 public boolean placeShips();

 public boolean hasMissilesLeft();
 
 public BattleArea getBattleArea();
}
