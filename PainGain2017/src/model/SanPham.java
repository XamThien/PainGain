package model;
// Generated Nov 27, 2017 10:35:36 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SanPham generated by hbm2java
 */
@Entity
@Table(name = "san_pham", catalog = "PainAndGain_2017")
public class SanPham implements java.io.Serializable {

	private Integer maSp;
	private String tenSp;
	private int soLuong;
	private int donGiaBan;
	private Integer donGiaMua;
	private Integer maLoai;

	public SanPham() {
	}

	public SanPham(String tenSp, int soLuong, int donGiaBan) {
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGiaBan = donGiaBan;
	}

	public SanPham(String tenSp, int soLuong, int donGiaBan, Integer donGiaMua, Integer maLoai) {
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGiaBan = donGiaBan;
		this.donGiaMua = donGiaMua;
		this.maLoai = maLoai;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MA_SP", unique = true, nullable = false)
	public Integer getMaSp() {
		return this.maSp;
	}

	public void setMaSp(Integer maSp) {
		this.maSp = maSp;
	}

	@Column(name = "TEN_SP", nullable = false, length = 300)
	public String getTenSp() {
		return this.tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	@Column(name = "SO_LUONG", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "DON_GIA_BAN", nullable = false)
	public int getDonGiaBan() {
		return this.donGiaBan;
	}

	public void setDonGiaBan(int donGiaBan) {
		this.donGiaBan = donGiaBan;
	}

	@Column(name = "DON_GIA_MUA")
	public Integer getDonGiaMua() {
		return this.donGiaMua;
	}

	public void setDonGiaMua(Integer donGiaMua) {
		this.donGiaMua = donGiaMua;
	}

	@Column(name = "MA_LOAI")
	public Integer getMaLoai() {
		return this.maLoai;
	}

	public void setMaLoai(Integer maLoai) {
		this.maLoai = maLoai;
	}

}
