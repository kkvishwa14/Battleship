package com.kk.battleship.models;

import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.enums.HitResult;
import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.factory.CellFactory;
import com.kk.battleship.utils.CellUtils;

public class BattleArea {

	private ICell[][] cells;

	private Dimension dimension;

	private int totalActiveAreas;
	private int minimumAttacksNeeded; // total of each activeArea's strength

	public ICell[][] getCells() {
		return cells;
	}

	public void setCells(ICell[][] cells) {
		this.cells = cells;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getTotalActiveAreas() {
		return totalActiveAreas;
	}

	public int getMinimumAttacksNeeded() {
		return minimumAttacksNeeded;
	}

	public BattleArea(int rows, String columns) throws InitializationException {
		Dimension d = CellUtils.getDimension(rows, columns);
		this.dimension = d;
		cells = new ICell[d.getLength()][d.getBreadth()];
		initializeCells();
		totalActiveAreas = 0;
	}

	public void evaluateResult(HitResult hitResult) {
		if (HitResult.MISS != hitResult) {
			if (HitResult.DESTROYED == hitResult) {
				totalActiveAreas--;
			}
			minimumAttacksNeeded--;
		}
	}

	public void initializeCells() {
		for (int i = 0; i < dimension.getBreadth(); i++) {
			for (int j = 0; j < dimension.getLength(); j++) {
				cells[i][j] = CellFactory.getCellInstance(CellStatus.INACTIVE);
			}
		}
	}

	public void placeShip(Ship ship, String locationStart) {
		int rowStart = CellUtils.getRowNo(locationStart);
		int columnStart = CellUtils.getColumnNo(locationStart);
		int rowEnd = rowStart + ship.getDimension().getBreadth();
		int columnEnd = columnStart + ship.getDimension().getLength();

		for (int row = rowStart; row < rowEnd; row++) {
			for (int col = columnStart; col < columnEnd; col++) {

				ICell cell = CellFactory.getCellInstance(CellStatus.ACTIVE);
				cell.setShip(ship);
				cells[row][col] = cell;
			}

		}
		this.totalActiveAreas += ship.getActiveCellsRemaining();
		this.minimumAttacksNeeded += ship.getActiveCellsRemaining()
				* ship.getType().getStrength();
	}

	public boolean isCompletelyDestroyed() {
		return this.totalActiveAreas == 0;
	}

	public void printCells() {
		for (int i = 0; i < dimension.getBreadth(); i++) {
			for (int j = 0; j < dimension.getLength(); j++) {
				ICell cell = cells[i][j];
				if (cell instanceof BoardedCell) {
					System.out.print("|"
							+ ((BoardedCell) cell).getShip().getType() + "|");
				} else {
					System.out.print("| |");
				}
			}
			System.out.println();
		}
	}
}
