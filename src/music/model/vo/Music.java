package music.model.vo;

public class Music {

	private String musicTitle;
	private String musicSinger;
	private String musicRelease;
	private String musicTime;
	private String musicAgency;
	
	// 생성자
	public Music() {}
	
	

	public Music(String musicTitle) {
		super();
		this.musicTitle = musicTitle;
	}



	// 매개변수있는 생성자
	public Music(String musicTitle, String musicSinger, String musicRelease, String musicTime, String musicAgency) {
		super();
		this.musicTitle = musicTitle;
		this.musicSinger = musicSinger;
		this.musicRelease = musicRelease;
		this.musicTime = musicTime;
		this.musicAgency = musicAgency;
	}
	// 곡명, 가수명, 기획사명이 있는 생성자
	public Music(String musicTitle, String musicSinger, String musicAgency) {
		super();
		this.musicTitle = musicTitle;
		this.musicSinger = musicSinger;
		this.musicAgency = musicAgency;
	}
	

	// getter / setter 메소드
	public String getMusicTitle() {
		return musicTitle;
	}


	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicSinger() {
		return musicSinger;
	}

	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}

	public String getMusicRelease() {
		return musicRelease;
	}

	public void setMusicRelease(String musicRelease) {
		this.musicRelease = musicRelease;
	}

	public String getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	}

	public String getMusicAgency() {
		return musicAgency;
	}

	public void setMusicAgency(String musicAgency) {
		this.musicAgency = musicAgency;
	}

	// toString()
	@Override
	public String toString() {
		return "Music [musicTitle=" + musicTitle + ", musicSinger=" + musicSinger + ", musicRelease=" + musicRelease
				+ ", musicTime=" + musicTime + ", musicAgency=" + musicAgency + "]";
	}
	
	

}
