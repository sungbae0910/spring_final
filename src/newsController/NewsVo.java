package newsController;

import java.util.Date;
import java.util.List;

public class NewsVo {

	int nSerial;
	String nContent;
	String nTitle;
	String nCompany;
	Date nDate;
	String nRepoter;
	String nCategory;
	int nLike;
	int nHit;
	List<NewsPhotoVo> photos;
	
	public NewsVo() {}

	
	public int getnSerial() {
		return nSerial;
	}

	public void setnSerial(int nSerial) {
		this.nSerial = nSerial;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnCompany() {
		return nCompany;
	}

	public void setnCompany(String nCompany) {
		this.nCompany = nCompany;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getnRepoter() {
		return nRepoter;
	}

	public void setnRepoter(String nRepoter) {
		this.nRepoter = nRepoter;
	}

	public String getnCategory() {
		return nCategory;
	}

	public void setnCategory(String nCategory) {
		this.nCategory = nCategory;
	}

	public int getnLike() {
		return nLike;
	}

	public void setnLike(int nLike) {
		this.nLike = nLike;
	}

	public int getnHit() {
		return nHit;
	}

	public void setnHit(int nHit) {
		this.nHit = nHit;
	}

	public List<NewsPhotoVo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<NewsPhotoVo> photos) {
		this.photos = photos;
	}
	
	
}
