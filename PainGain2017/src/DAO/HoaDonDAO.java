package DAO;


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


import model.HoaDon;


public class HoaDonDAO {
	 @SuppressWarnings("unchecked")
	public  List<HoaDon> getAllHoaDon(){
		 List<HoaDon> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from HoaDon order by MA_HD DESC";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 @SuppressWarnings("unchecked")
		public  List<HoaDon> getOnDayHoaDon(String date){
			 List<HoaDon> list=null;
		        try
		        {
		        	Configuration configuration =  new Configuration().configure();
		        	SessionFactory sessionFactory = configuration.buildSessionFactory();
		        	Session session = sessionFactory.openSession();
		        	
		        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			        Transaction transaction = session.beginTransaction();
			        String hql ="from HoaDon where Day(NGAY_LAP)=Day(:day) and Month(NGAY_LAP)=Month(:month) and Year(NGAY_LAP)=Year(:year) ";
			        Query que = session.createQuery(hql);
			        
			        que.setParameter("day", date);
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
	 public HoaDon getLastHoaDon() {
		 HoaDon cl = null;
		 List<HoaDon> list=null;
	       try
	       {
	    	   Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from HoaDon order by MA_HD DESC";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        cl = list.get(0);
		        transaction.commit();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public HoaDon getHoaDon(int id) {
		 HoaDon cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from HoaDon where MA_HD="+id;
		        Query que = session.createQuery(hql);
		        cl = (HoaDon) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertHoaDon(HoaDon sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteHoaDon(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from HoaDon where MA_HD ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateHoaDon(int id,HoaDon sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        HoaDon spp = (HoaDon)session.load(HoaDon.class, id);
	        spp.setNgayLap(sp.getNgayLap());
	        spp.setMaKh(sp.getMaKh());
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 
	public static void main(String[] args) {
		 List<HoaDon>lst1=null;
		    try
		    {
		    	lst1= new HoaDonDAO().getOnDayHoaDon("2018-1-3");
		    }
		    catch (Exception e1)
		    {}
		    
		    int SHD = 0;
		    if(lst1!=null)
		    {
		    	SHD = lst1.size();
		    }
		    System.out.println(SHD);
	}
}
