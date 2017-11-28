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


import model.NhaccSanpham;


public class NhaccSanphamDAO {
	 @SuppressWarnings("unchecked")
	public  List<NhaccSanpham> getAllNhaccSanpham(){
		 List<NhaccSanpham> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhaccSanpham";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public NhaccSanpham getNhaccSanpham(int id) {
		 NhaccSanpham cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhaccSanpham where MA_NHACC_SANPHAM="+id;
		        Query que = session.createQuery(hql);
		        cl = (NhaccSanpham) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertNhaccSanpham(NhaccSanpham sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteNhaccSanpham(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from NhaccSanpham where MA_NHACC_SANPHAM ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateNhaCc(int id,NhaccSanpham sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        NhaccSanpham spp = (NhaccSanpham)session.load(NhaccSanpham.class, id);
	        spp.setMaNcc(sp.getMaNcc());
	        spp.setMaSp(sp.getMaSp());
	       
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 
	
}
