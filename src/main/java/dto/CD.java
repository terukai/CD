package dto;

public class CD {
	
	private int id;
	private String title;
	private String composter;
	private String singer;
	private int release;
	private int length;
	
	public CD(int id, String title, String composter, String singer, int release, int length) {
		super();
		this.id = id;
		this.title = title;
		this.composter = composter;
		this.singer = singer;
		this.release = release;
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposter() {
		return composter;
	}

	public void setComposter(String composter) {
		this.composter = composter;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
}
