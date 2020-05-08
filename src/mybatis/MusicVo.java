package mybatis;

public class MusicVo {
	int music_serial;
	String music_name;
	String artist_name;
	String lylics;
	int album_serial;
	String genre;
	String enter;
	String company;
	
	
	public int getMusic_serial() {
		return music_serial;
	}
	public void setMusic_serial(int music_serial) {
		this.music_serial = music_serial;
	}
	public String getMusic_name() {
		return music_name;
	}
	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getLylics() {
		return lylics;
	}
	public void setLylics(String lylics) {
		this.lylics = lylics;
	}
	public int getAlbum_serial() {
		return album_serial;
	}
	public void setAlbum_serial(int album_serial) {
		this.album_serial = album_serial;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getEnter() {
		return enter;
	}
	public void setEnter(String enter) {
		this.enter = enter;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
