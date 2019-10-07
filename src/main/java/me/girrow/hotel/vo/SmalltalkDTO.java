package me.girrow.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SmalltalkDTO {
	private String no;
	private String title;
	private String selectedType;
	private String content;
	private String writer;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSelectedType() {
		return selectedType;
	}
	public void setSelectedType(String selectedType) {
		this.selectedType = selectedType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "SmalltalkDTO [title=" + title + ", selectedType=" + selectedType + ", content=" + content + ", writer=" + writer + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
}
