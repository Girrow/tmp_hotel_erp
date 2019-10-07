package me.girrow.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventVO {
	private int no;
	private String name;
	private String writer;
	private String content;
	private String imgSrc;
	private String startDate;
	private String endDate;
	
	@Override
	public String toString() {
		return "EventVO [no=" + no + ", name=" + name + ", writer=" + writer + ", content=" + content + ", imgSrc=" + imgSrc + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
