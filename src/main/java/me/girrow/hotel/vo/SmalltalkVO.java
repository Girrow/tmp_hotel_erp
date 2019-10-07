package me.girrow.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmalltalkVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private int views;
	private String createTime;
	private String modifyTime;
	private String delYn;
	private String selectedType;
	
	@Override
	public String toString() {
		return "SmalltalkVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", views=" + views + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", delYn=" + delYn + ", selectedType=" + selectedType + "]";
	}
}
