package lolVo;

public class GameIdVo {
	
	long gameId;
	String role;
	int season;
	String platformId;
	int champion;
	int queue;
	String lane;
	long timestamp;
	
	public GameIdVo(long gameId, String role, int season, String platformId, int champion, int queue, String lane,long timestamp) {
		this.gameId = gameId;
		this.role = role;
		this.season = season;
		this.platformId = platformId;
		this.champion = champion;
		this.queue = queue;
		this.lane = lane;
		this.timestamp = timestamp;
	}
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public int getChampion() {
		return champion;
	}
	public void setChampion(int champion) {
		this.champion = champion;
	}
	public int getQueue() {
		return queue;
	}
	public void setQueue(int queue) {
		this.queue = queue;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
