/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * hoa don nhap hang session
 * @author Mạnh Nguyễn!
 */
public class DonHang extends PhieuNhap {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ChiTietPhieuNhap> items = new ArrayList<ChiTietPhieuNhap>();

    public DonHang( String ngayLap) {
        super( ngayLap);
        
    }

    public List<ChiTietPhieuNhap> getItems() {
        return items;
    }

    public int isDuplicate(ChiTietPhieuNhap ctd) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getMaSp()==ctd.getMaSp()) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(ChiTietPhieuNhap item) {
        int index = isDuplicate(item);
        if (index != -1) {
        	ChiTietPhieuNhap tmp = items.get(index);
            items.get(index).setSoLuong(tmp.getSoLuong() + item.getSoLuong());
        } else {
            items.add(item);
        }
    }

    public void remove(ChiTietPhieuNhap item) {
        if (!this.items.isEmpty()) {
            items.remove(item);
        }
    }

    public ChiTietPhieuNhap getItem(int mahh) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getMaSp()==mahh) {
                return items.get(i);
            }
        }
        return null;
    }

    public void update(ChiTietPhieuNhap item) {
        int index = isDuplicate(item);
        if (index != -1) {
            items.get(index).setSoLuong(item.getSoLuong());
            items.get(index).setDonGia(item.getDonGia());
        }
    }
}
