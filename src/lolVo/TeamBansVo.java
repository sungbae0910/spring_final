package lolVo;

public class TeamBansVo {
  int championld;
  int pickTurn;
  
  public TeamBansVo(int championld,int pickTurn) {
	  this.championld = championld;
	  this.pickTurn = pickTurn;
  }
  
public int getChampionld() {
	return championld;
}
public void setChampionld(int championld) {
	this.championld = championld;
}
public int getPickTurn() {
	return pickTurn;
}
public void setPickTurn(int pickTurn) {
	this.pickTurn = pickTurn;
}
}
