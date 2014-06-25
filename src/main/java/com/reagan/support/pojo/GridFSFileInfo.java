package com.reagan.support.pojo;

public class GridFSFileInfo {
	
	private String id;
	
	private String filename;
	
	private String contentType;
	
	private Long lenght;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getLenght() {
		return lenght;
	}

	public void setLenght(Long lenght) {
		this.lenght = lenght;
	}
	
}
