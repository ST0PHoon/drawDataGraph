package kr.ac.kopo.ctc.kopo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GuDongDanji {
	
	@Id
	@GeneratedValue
	@Column
	private String gu;
	@Column
	private String dong;
	@Column
	private String danji;

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
	
	
}
