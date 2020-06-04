package lolVo;

import java.util.List;

public class ParticipantVo {
  int participantId;
  int championId;
  List<RuneVo> runes;
  ParticipantStatsVo stats;
  int teamId;
  ParticipantTimelineVo timeline;
  int spell1Id; 
  int spell2Id;
  String highestAchievedSeasonTier;
  List<MasteryVo> masteries;
  List<Integer> playerten;
  
  public ParticipantVo(int cId, int spell1, int spell2, ParticipantStatsVo stats) {
	this.championId = cId;
	this.spell1Id = spell1;
	this.spell2Id = spell2;
	this.stats = stats;
  }
 public ParticipantVo(List<Integer> list) {
	 this.playerten = list;
 }
  
  


public List<Integer> getPlayerten() {
	return playerten;
}
public void setPlayerten(List<Integer> playerten) {
	this.playerten = playerten;
}
public int getParticipantId() {
	return participantId;
}
public void setParticipantId(int participantId) {
	this.participantId = participantId;
}
public int getChampionId() {
	return championId;
}
public void setChampionId(int championId) {
	this.championId = championId;
}
public List<RuneVo> getRunes() {
	return runes;
}
public void setRunes(List<RuneVo> runes) {
	this.runes = runes;
}
public ParticipantStatsVo getStats() {
	return stats;
}
public void setStats(ParticipantStatsVo stats) {
	this.stats = stats;
}
public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
public ParticipantTimelineVo getTimeline() {
	return timeline;
}
public void setTimeline(ParticipantTimelineVo timeline) {
	this.timeline = timeline;
}
public int getSpell1Id() {
	return spell1Id;
}
public void setSpell1Id(int spell1Id) {
	this.spell1Id = spell1Id;
}
public int getSpell2Id() {
	return spell2Id;
}
public void setSpell2Id(int spell2Id) {
	this.spell2Id = spell2Id;
}
public String getHighestAchievedSeasonTier() {
	return highestAchievedSeasonTier;
}
public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
	this.highestAchievedSeasonTier = highestAchievedSeasonTier;
}
public List<MasteryVo> getMasteries() {
	return masteries;
}
public void setMasteries(List<MasteryVo> masteries) {
	this.masteries = masteries;
}
  
  
  
}

