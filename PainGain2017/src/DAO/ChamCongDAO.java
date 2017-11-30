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


import model.ChamCong;


public class ChamCongDAO {
	 @SuppressWarnings("unchecked")
	public  List<ChamCong> getAllChamCong(int Ma_NV,String date){
		 List<ChamCong> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChamCong where MA_NV="+Ma_NV +" and Month(NGAY)=Month(:month) and Year(NGAY)=Year(:year) order by MA_CC";
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
	 public ChamCong getChamCong(int id,String date,int ca) {
		 ChamCong cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChamCong where MA_NV="+ id+" and NGAY=:datex and MA_CA="+ca ;
		        Query que = session.createQuery(hql);
		        //que.setParameter("id", id);
		        que.setParameter("datex", date);
		        //que.setParameter("ca", ma_ca);
		        cl = (ChamCong) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertChamCong(ChamCong sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteChamCong(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from ChamCong where MA_CC ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateDanhMuc(int id,ChamCong sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        ChamCong spp = (ChamCong)session.load(ChamCong.class, id);
	        spp.setMaNv(sp.getMaNv());
	        spp.setGioBatDau(sp.getGioBatDau());
	        spp.setGioKetThuc(sp.getGioKetThuc());
	        spp.setNgay(sp.getNgay());
	        spp.setMaCa(sp.getMaCa());
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) {
		ChamCong cc = new ChamCongDAO().getChamCong(1,"2017-11-30",1);
		System.out.println(cc);
	}
	 
	
}
