package lolVo;

import java.util.List;

public class TeamStatsVo {
  int towerKills;
  int riftHeraldKills;
  boolean firstBlood;
  int inhibitorKills; 
  List<TeamBansVo> bans;
  boolean firstBaron;
  boolean firstDragon;
  int dominionVictoryScore; 
  int dragonKills; 
  int baronKills; 
  boolean firstInhibitor;
  boolean firstTower; 
  int vilemawKills; 
  boolean firstRiftHerald;
  int teamId;
  String win;
  
  public TeamStatsVo(int towerKills,int riftHeraldKills, boolean firstBlood , int inhibitorKills , List<TeamBansVo> bans,boolean firstBaron
 ,boolean firstDragon ,int dominionVictoryScore, int dragonKills,int baronKills, boolean firstInhibitor , boolean firstTower,int vilemawKills,boolean firstRiftHerald,
  int teamId ,String win) {
	 this.towerKills = towerKills;
	 this.riftHeraldKills = riftHeraldKills;
	 this.firstBlood = firstBlood;
	 this.inhibitorKills = inhibitorKills;
	 this.bans = bans;
	 this.firstBaron = firstBaron;
	 this.firstDragon = firstDragon;
	 this.dominionVictoryScore = dominionVictoryScore;
	 this.dragonKills = dragonKills;
	 this.baronKills = baronKills;
	 this.firstInhibitor = firstInhibitor;
	 this.firstTower = firstTower;
	 this.vilemawKills = vilemawKills;
	 this.firstRiftHerald = firstRiftHerald;
	 this.teamId = teamId;
	 this.win = win;
	 }

public int getTowerKills() {
	return towerKills;
}

public void setTowerKills(int towerKills) {
	this.towerKills = towerKills;
}

public int getRiftHeraldKills() {
	return riftHeraldKills;
}

public void setRiftHeraldKills(int riftHeraldKills) {
	this.riftHeraldKills = riftHeraldKills;
}

public boolean isFirstBlood() {
	return firstBlood;
}

public void setFirstBlood(boolean firstBlood) {
	this.firstBlood = firstBlood;
}

public int getInhibitorKills() {
	return inhibitorKills;
}

public void setInhibitorKills(int inhibitorKills) {
	this.inhibitorKills = inhibitorKills;
}

public List<TeamBansVo> getBans() {
	return bans;
}

public void setBans(List<TeamBansVo> bans) {
	this.bans = bans;
}

public boolean isFirstBaron() {
	return firstBaron;
}

public void setFirstBaron(boolean firstBaron) {
	this.firstBaron = firstBaron;
}

public boolean isFirstDragon() {
	return firstDragon;
}

public void setFirstDragon(boolean firstDragon) {
	this.firstDragon = firstDragon;
}

public int getDominionVictoryScore() {
	return dominionVictoryScore;
}

public void setDominionVictoryScore(int dominionVictoryScore) {
	this.dominionVictoryScore = dominionVictoryScore;
}

public int getDragonKills() {
	return dragonKills;
}

public void setDragonKills(int dragonKills) {
	this.dragonKills = dragonKills;
}

public int getBaronKills() {
	return baronKills;
}

public void setBaronKills(int baronKills) {
	this.baronKills = baronKills;
}

public boolean isFirstInhibitor() {
	return firstInhibitor;
}

public void setFirstInhibitor(boolean firstInhibitor) {
	this.firstInhibitor = firstInhibitor;
}

public boolean isFirstTower() {
	return firstTower;
}

public void setFirstTower(boolean firstTower) {
	this.firstTower = firstTower;
}

public int getVilemawKills() {
	return vilemawKills;
}

public void setVilemawKills(int vilemawKills) {
	this.vilemawKills = vilemawKills;
}

public boolean isFirstRiftHerald() {
	return firstRiftHerald;
}

public void setFirstRiftHerald(boolean firstRiftHerald) {
	this.firstRiftHerald = firstRiftHerald;
}

public int getTeamId() {
	return teamId;
}

public void setTeamId(int teamId) {
	this.teamId = teamId;
}

public String getWin() {
	return win;
}

public void setWin(String win) {
	this.win = win;
}
  
  
  
  
}
