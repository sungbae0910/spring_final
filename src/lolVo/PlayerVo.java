package lolVo;

public class PlayerVo {
	int profileIcon;
	String accountld;
	String matchHistoryUri;
	String currentAccountId;
	String currentPlatformId;
	String summonerName;
	String summonerId;
	String platformId;

	public PlayerVo(int profileIcon,String accountld,String matchHistoryUri,String currentAccountId,String currentPlatformId,String summonerName,String summonerId,String platformId){
		this.profileIcon = profileIcon;
		this.accountld = accountld;
		this.matchHistoryUri = matchHistoryUri;
		this.currentAccountId = currentAccountId;
		this.currentPlatformId = currentPlatformId;
		this.summonerName = summonerName;
		this.summonerId = summonerId;
		this.platformId = platformId;
	}
	
	public PlayerVo(String name, int icon) {
		this.summonerName = name;
		this.profileIcon = icon;
	}
	
	
	public int getProfileIcon() {
		return profileIcon;
	}

	public void setProfileIcon(int profileIcon) {
		this.profileIcon = profileIcon;
	}

	public String getAccountld() {
		return accountld;
	}

	public void setAccountld(String accountld) {
		this.accountld = accountld;
	}

	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	public void setMatchHistoryUri(String matchHistoryUri) {
		this.matchHistoryUri = matchHistoryUri;
	}

	public String getCurrentAccountId() {
		return currentAccountId;
	}

	public void setCurrentAccountId(String currentAccountId) {
		this.currentAccountId = currentAccountId;
	}

	public String getCurrentPlatformId() {
		return currentPlatformId;
	}

	public void setCurrentPlatformId(String currentPlatformId) {
		this.currentPlatformId = currentPlatformId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

}
