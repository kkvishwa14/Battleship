package com.kk.battleship.beans;
import java.util.List;
import java.util.Map;

import com.kk.battleship.enums.HitResult;
import com.kk.battleship.enums.PlayerStatus;
import com.kk.battleship.utils.CellUtils;


public class NormalPlayer implements IPlayer{
	private String name;
	private BattleArea battleArea;
	private PlayerStatus playerStatus;
	
	private Map<Ship, String> shipPlacements;
	private List<String> targets;
	
	public BattleArea getBattleArea() {
		return battleArea;
	}

	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}

	public PlayerStatus getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(PlayerStatus playerStatus) {
		this.playerStatus = playerStatus;
	}

	public Map<Ship, String> getShipPlacements() {
		return shipPlacements;
	}

	public void setShipPlacements(Map<Ship, String> shipPlacements) {
		this.shipPlacements = shipPlacements;
	}

	public List<String> getTargets() {
		return targets;
	}

	public void setTargets(List<String> targets) {
		this.targets = targets;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NormalPlayer(String name, BattleArea battleArea, Map<Ship, String> placementMap) {
		this.name = name;
		this.battleArea = battleArea;
		this.shipPlacements = placementMap;
		this.playerStatus = PlayerStatus.UNDECIDED_YET;
	}
	
	public void placeShips(){
		shipPlacements.forEach((ship,placement)->this.battleArea.placeShip(ship, placement));
	}
	
	public void initializeMissileTargets(List<String> targets) {
		this.targets = targets;
	}

	@Override
	public HitResult hit(IPlayer player) {
		if(!this.targets.isEmpty()) {
			String target = targets.remove(0);
			System.out.println("Hitting at "+target);
			return player.getHitResult(target);
		} else {
			System.out.println("I have no missiles left");
			return HitResult.MISS;
		}
		
	}

	
	@Override
	public boolean won() {
		return this.playerStatus == PlayerStatus.WON;
	}

	@Override
	public boolean lost() {
		return this.playerStatus == PlayerStatus.LOST;
	}

	@Override
	public HitResult getHitResult(String hitCellLocation) {
		int row = CellUtils.getRowNo(hitCellLocation);
		int col = CellUtils.getColumnNo(hitCellLocation);
		
		ICell cell = this.battleArea.getCells()[row][col];
		HitResult hitResult = cell.getHitResult();
		this.battleArea.evaluateResult(hitResult);
		if(this.battleArea.getMinimumAttacksNeeded()==0){
			this.playerStatus = PlayerStatus.LOST;
		}
		return hitResult;

	}

	@Override
	public boolean hasMissilesLeft() {
		return targets.size()>0;
	}

	@Override
	public String getName() {
		
		return name;
	}
}
