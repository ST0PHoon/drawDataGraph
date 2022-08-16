package kr.ac.kopo.ctc.kopo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RealEstate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String city;	
	@Column
	private String gu;
	@Column
	private String dong;
	@Column
	private String danji;
	@Column
	private double area;
	@Column
	private Integer contractYear;
	@Column
	private Integer contractMonth;
	@Column
	private Integer contractDay;
	@Column
	private Integer contractPrice;
	@Column
	private Integer floor;
	@Column
	private Integer constYear;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getDanji() {
		return danji;
	}
	public void setDanji(String danji) {
		this.danji = danji;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getContractYear() {
		return contractYear;
	}
	public void setContractYear(int contractYear) {
		this.contractYear = contractYear;
	}
	public int getContractMonth() {
		return contractMonth;
	}
	public void setContractMonth(int contractMonth) {
		this.contractMonth = contractMonth;
	}
	public int getContractDay() {
		return contractDay;
	}
	public void setContractDay(int contractDay) {
		this.contractDay = contractDay;
	}
	public int getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getConstYear() {
		return constYear;
	}
	public void setConstYear(int constYear) {
		this.constYear = constYear;
	}
	
}
