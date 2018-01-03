package DAO;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;


import model.ThuongPhat;


public class ThuongPhatDAO {
	 @SuppressWarnings("unchecked")
	public  List<ThuongPhat> getAllThuongPhat(int ma,String date){
		 List<ThuongPhat> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ThuongPhat where MA_NV=:ma and Month(NGAY)=Month(:month) and Year(NGAY)=Year(:year) order by MA_TP DESC";
		        Query que = session.createQuery(hql);
		        que.setParameter("ma", ma);
		        que.setParameter("month", date);
		        que.setParameter("year", date);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public  List<ThuongPhat> getFullThuongPhat(String date){
		 List<ThuongPhat> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ThuongPhat where Month(NGAY)=Month(:month) and Year(NGAY)=Year(:year) order by MA_TP DESC";
		        Query que = session.createQuery(hql);
		        
		        que.setParameter("month", date);
		        que.setParameter("year", date);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public ThuongPhat getThuongPhat(int id) {
		 ThuongPhat cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ThuongPhat where MA_TP="+id;
		        Query que = session.createQuery(hql);
		        cl = (ThuongPhat) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertThuongPhat(ThuongPhat sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteThuongPhat(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from ThuongPhat where MA_TP ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateThuongPhat(int id,ThuongPhat sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        ThuongPhat spp = (ThuongPhat)session.load(ThuongPhat.class, id);
	        spp.setGiaTri(sp.getGiaTri());
	        spp.setNgay(sp.getNgay());
	        spp.setLaThuong(sp.getLaThuong());
	        spp.setLaPhat(sp.getLaPhat());
	        spp.setLiDo(sp.getLiDo());
	        spp.setMaNv(sp.getMaNv());
	        
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) {
//		    String myTime = "10:30:54";
//		    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//		    Date date = null;
//		    try {
//		        date = sdf.parse(myTime);
//		        String formattedTime = sdf.format(date);
//		        System.out.println(formattedTime);
//		    } catch (ParseException e) {
//		        e.printStackTrace();
//		    }
		 
//		 	String dateStart = "09:33:58";
//	        String dateStop = "10:34:59";
//	        // Custom date format
//	        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//	        Date d1 = null;
//	        Date d2 = null;
//	        try {
//	            d1 = format.parse(dateStart);
//	            d2 = format.parse(dateStop);
//	         // Get msec from each, and subtract.
//		        long diff = d2.getTime() - d1.getTime();
//		        //long diffSeconds = diff / 1000;
//		        long diffMinutes = diff / (60 * 1000);
//		        //long diffHours = diff / (60 * 60 * 1000);
//		        //System.out.println("Số giây : " + diffSeconds + " seconds.");
//		        System.out.println("Số phút: " + diffMinutes + " minutes.");
//		        //System.out.println("Số giờ: " + diffHours + " hours.");
//	        } catch (ParseException e) {
//	        }
	        
		 List<ThuongPhat> lst = new ThuongPhatDAO().getFullThuongPhat("2017/12/31");
		 for (ThuongPhat tp :lst)
		 {
			 System.out.println(tp.getMaNv());
		 }
		    
	}
	
}
