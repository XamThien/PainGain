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


import model.*;


public class CaLamDAO {
	 @SuppressWarnings("unchecked")
	public  List<CaLam> getAllCaLam(){
		 List<CaLam> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from CaLam";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public CaLam getCaLam(int id) {
		 CaLam cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from CaLam where MA_CA="+id;
		        Query que = session.createQuery(hql);
		        cl = (CaLam) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertCaLam(CaLam sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteCaLam(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from CaLam where MA_CA ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateCaLam(int id,CaLam sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        CaLam spp = (CaLam)session.load(CaLam.class, id);
	        spp.setGioBatDau(sp.getGioBatDau());
	        spp.setGioKetThuc(sp.getGioKetThuc());
	        spp.setLuongGio(sp.getLuongGio());
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 
	 
	 //EmployeeDetails empdetails = (EmployeeDetails)session.load(EmployeeDetails.class, id);
	 
	 //test database
	public static void main(String[] args) throws Exception{
		CaLam cl = new CaLam("8:00:00","12:00:00",12000);
		new CaLamDAO().updateCaLam(1, cl);
		
			
	}
}
