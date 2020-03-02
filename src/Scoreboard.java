import java.util.ArrayList;

public class Scoreboard {
	private Player players[];
	private int[] coordinates;;

	Scoreboard() {
		players = new Player[6];
		coordinates = new int[players.length * 2];
	}

	public void addScores(int[] scores) {
		for (int i = 0; i < players.length; i++) {
			coordinates[i * 2] = players[i].getScore();
		}
		for (int z = 0; z < players.length; z++) {
			players[z].addScore(scores[z]);
		}
		int i = 0;
		for (int j = 1; j < 12; j = j + 2) {
			coordinates[j] = players[i].getScore();
			i++;
		}
	}

	public int[] trainCoordinates() {
		return coordinates;
	}

	public ArrayList<String> gameOver() {
		//not accounted for players with same score
		ArrayList<String> winnerOrder = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i < players.length; i++) {
			scores.add(players[i].getScore());
		}
		int highest = 0;
		for (int a = 0; a < scores.size(); a++) {
			int highestIndex = 0;
			if (scores.get(a) > highest) {
				highest = scores.get(a);
				highestIndex = a;
			}
			if (a == scores.size() - 1) {
				for (int z = 0; z < players.length; z++) {
					if (highest == players[z].getScore()) {
						winnerOrder.add(players[z].getName());
						scores.remove(highestIndex);
					}
				}

			}
		}
		return winnerOrder;
	}
}
