package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TinhLuongDAO {
	public int Counthour(String date1,String date2)
	{
		long diffMinutes=0;
		
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(date1);
            d2 = format.parse(date2);
         // Get msec from each, and subtract.
	        long diff = d2.getTime() - d1.getTime();
	        //long diffSeconds = diff / 1000;
	        diffMinutes = diff / (60 * 1000);
	        //long diffHours = diff / (60 * 60 * 1000);
	        //System.out.println("S? giây : " + diffSeconds + " seconds.");
	        //System.out.println("S? phút: " + diffMinutes + " minutes.");
	        //System.out.println("S? gi?: " + diffHours + " hours.");
        } catch (ParseException e) {
        }
        return (int) diffMinutes;
	}
	public static void main(String[] args) {
		System.out.println(new TinhLuongDAO().Counthour("09:33:58","10:34:59"));
	}
}
