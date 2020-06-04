package lolVo;

public class LeagueVo {
	
	String leagueId;
	String queueType;
	int wins;
	int losses;
	String rank;
	String tier;
	int leaguePoints;
	
	public LeagueVo (String leagueId, String queueType,int wins, int losses, String rank, String tier,int leaguePoints) {
		this.leagueId = leagueId;
		this.queueType = queueType;
		this.wins = wins;
		this.losses = losses;
		this.rank = rank;
		this.tier = tier;
		this.leaguePoints = leaguePoints;
	}
	
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	
	
}
