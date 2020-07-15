package lolVo;

public class SummonerVo {

	String accountId;
	int profileIconId;
	long revisionDate;
	String name;
	String id;
	String puuid;
	long summonerLevel;
	
	public SummonerVo(String aId, int iconId, long rDate, String name, String id, String puuid, long Level) {
		
		this.accountId = aId;
		this.profileIconId = iconId;
		this.revisionDate = rDate;
		this.name = name;
		this.id = id;
		this.puuid = puuid;
		this.summonerLevel = Level;
		
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public long getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
}

	
