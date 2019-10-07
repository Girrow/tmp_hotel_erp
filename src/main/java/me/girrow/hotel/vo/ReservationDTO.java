package me.girrow.hotel.vo;

public class ReservationDTO {
	
	private String dates;
	private String dates2;
	private String numb;
	private String roomType;
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getDates2() {
		return dates2;
	}

	public void setDates2(String dates2) {
		this.dates2 = dates2;
	}

	public String getNumb() {
		return numb;
	}

	public void setNumb(String numb) {
		this.numb = numb;
	}

	@Override
	public String toString() {
		return "ReservationDTO [dates=" + dates + ", dates2=" + dates2 + ", numb=" + numb + "]";
	}

	public ReservationDTO(String dates, String dates2, String numb) {
		super();
		this.dates = dates;
		this.dates2 = dates2;
		this.numb = numb;
	}
	
	
	public ReservationDTO() {
		super();
	}
}
