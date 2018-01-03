package model;
import java.util.ArrayList;
public class HoaDonSession extends HoaDon{
    /**
	 *  Session hoa don ban hang
	 */
	private static final long serialVersionUID = 1L;
	private  ArrayList<ChiTietHoaDon> items;
    private int saletotal;
    public HoaDonSession(String ngay, int maKH) {
        super(ngay, maKH);
        items = new ArrayList<>();
        this.saletotal =0;
    }
    public void setSaleTotal(int sale){
        this.saletotal = sale;
    }
    public ArrayList<ChiTietHoaDon> getItems(){
        return items;
    }
    public void updateSale(){
        for(ChiTietHoaDon item:items){
            if(item.getGiamGia()==0){
                item.setGiamGia(this.saletotal);
            }
        }
    }
    public void addItem(ChiTietHoaDon item){
        int index = isDuplicate(item);
        if(item.getGiamGia()==0){
            item.setGiamGia(this.saletotal);
        }
        if(index !=-1){
        	ChiTietHoaDon tmp = items.get(index);
            items.get(index).setSoLuong(tmp.getSoLuong() + item.getSoLuong());
        }else{
            items.add(item);
        }
    }
    public int isDuplicate(ChiTietHoaDon sp){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getMaSp()==sp.getMaSp()){
				return i;
			}
		}
	return -1;
    }
    public int isDuplicateMa(int x){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getMaSp()==x){
				return i;
			}
		}
	return -1;
    }
    public void remove(ChiTietHoaDon item){
        if(this.items !=null){
            items.remove(item);
        }
    }
    public void update(ChiTietHoaDon item){
        int index = isDuplicate(item);
        if(item.getGiamGia()==0 ){
            item.setGiamGia(this.saletotal);
        }
        if(index != -1){
            items.get(index).setSoLuong(item.getSoLuong());
            //items.get(index).setDonGia(item.getDonGia());
            items.get(index).setGiamGia(item.getGiamGia());
        }
    }
    public ChiTietHoaDon getItem(int mahh){
        for(int i=0; i<items.size();i++){
			if(items.get(i).getMaSp()==mahh){
				return items.get(i);
			}
		}
        return null;
    }
}