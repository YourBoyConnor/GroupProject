

import java.util.ArrayList;
import java.util.Queue;

public class Board {
	private String gameState;
	private Queue<Rail> newRails;
	private Player activePlayer;
	private final Position[] positions = new Position[100]; // temp
	private final City[] cities = new City[35];
	private final Rail[] rails = new Rail[100]; // temp
	private ArrayList<Position> possiblePlacements = new ArrayList<Position>(0);
	private ArrayList<Player> playerArray = new ArrayList<Player>(0);

	public Board() {

	}

	public void addPlayer(Player p) {
		playerArray.add(p);
	}

	public Rail getRail(Position start, Position end) {
		for (int i = 0; i < rails.length; i++) {
			Position railStart = rails[i].startPos();
			Position railEnd = rails[i].endPos();
			if (((railStart.x == start.x && railStart.y == start.y) || (railEnd.x == end.x && railEnd.y == end.y))
					|| ((railStart.x == end.x && railStart.y == end.y)
							|| (railEnd.x == start.x && railEnd.y == start.y))) {
				return rails[i];
			}
		}
		return null;
	}

	public Rail[] getRails(Position pos) {
		Rail[] returnRails = new Rail[0];
		for (int i = 0; i < rails.length; i++) {
			Rail rail = rails[i];
			Position railStart = rail.startPos();
			Position railEnd = rail.endPos();
			if ((railStart.getX() == pos.getX() && railStart.getY() == pos.getY())
					|| (railEnd.getX() == pos.getX() && railEnd.getY() == pos.getY())) {
					Rail[] secondRail= new Rail[returnRails.length+1];
					for(int j=0;j<returnRails.length;j++) {
						secondRail[i]=returnRails[i];
					}
					secondRail[rails.length]=rail;
					returnRails=secondRail;
			}
		}
		return returnRails;
	}
	
	public Rail[] computeConnectedRails(Player p) {
		
	}

	int getDistancetoCity(Player p, City c) {
		
	}
	
	City getCity(Position location) {
		
	}
	
	Rail[] computePossiblePlacements() {
		
	}
	
	public void setRailState(Rail r, String state) {
		r.setState(state);
	}

	public ArrayList<Player> getPlayerArray() {
		return playerArray;
	}

	public Rail[] getRails() {
		return rails;
	}

	public City[] getCities() {
		return cities;
	}

	public void setActivePlayer(Player p) {
		activePlayer = p;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setGameState(String state) {
		gameState = state;
	}

	public String getGameState() {
		return gameState;
	}

}
