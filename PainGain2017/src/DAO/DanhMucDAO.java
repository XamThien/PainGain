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


import model.DanhMuc;


public class DanhMucDAO {
	 @SuppressWarnings("unchecked")
	public  List<DanhMuc> getAllDanhMuc(){
		 List<DanhMuc> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from DanhMuc";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public DanhMuc getDanhMuc(int id) {
		 DanhMuc cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from DanhMuc where MA_DM="+id;
		        Query que = session.createQuery(hql);
		        cl = (DanhMuc) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertDanhMuc(DanhMuc sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteDanhMuc(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from DanhMuc where MA_DM ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateDanhMuc(int id,DanhMuc sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        DanhMuc spp = (DanhMuc)session.load(DanhMuc.class, id);
	        spp.setTenDm(sp.getTenDm());
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 
	
}
