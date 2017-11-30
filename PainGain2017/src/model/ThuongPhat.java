package model;
// Generated Nov 27, 2017 10:35:36 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ThuongPhat generated by hbm2java
 */
@Entity
@Table(name = "thuong_phat", catalog = "PainAndGain_2017")
public class ThuongPhat implements java.io.Serializable {

	private Integer maTp;
	private int giaTri;
	private String ngay;

	private int laThuong;
	private int laPhat;
	private String liDo;
	private Integer maNv;

	public ThuongPhat() {
	}

	
	

	public ThuongPhat(int giaTri,String ngay, int laThuong, int laPhat, String liDo, Integer maNv) {
		this.giaTri = giaTri;
		this.ngay= ngay;
		this.laThuong = laThuong;
		this.laPhat = laPhat;
		this.liDo = liDo;
		this.maNv = maNv;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MA_TP", unique = true, nullable = false)
	public Integer getMaTp() {
		return this.maTp;
	}

	public void setMaTp(Integer maTp) {
		this.maTp = maTp;
	}

	@Column(name = "GIA_TRI", nullable = false)
	public int getGiaTri() {
		return this.giaTri;
	}

	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
	
	@Column(name = "NGAY", nullable = false, length = 10)
	public String getNgay() {
		return this.ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	@Column(name = "LA_THUONG", nullable = false)
	public int getLaThuong() {
		return this.laThuong;
	}

	public void setLaThuong(int laThuong) {
		this.laThuong = laThuong;
	}

	@Column(name = "LA_PHAT", nullable = false)
	public int getLaPhat() {
		return this.laPhat;
	}

	public void setLaPhat(int laPhat) {
		this.laPhat = laPhat;
	}

	@Column(name = "LI_DO", length = 65535)
	public String getLiDo() {
		return this.liDo;
	}

	public void setLiDo(String liDo) {
		this.liDo = liDo;
	}

	@Column(name = "MA_NV")
	public Integer getMaNv() {
		return this.maNv;
	}

	public void setMaNv(Integer maNv) {
		this.maNv = maNv;
	}

}
