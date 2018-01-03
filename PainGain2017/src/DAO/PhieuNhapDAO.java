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


import model.PhieuNhap;


public class PhieuNhapDAO {
	 @SuppressWarnings("unchecked")
	public  List<PhieuNhap> getAllPhieuNhap(){
		 List<PhieuNhap> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from PhieuNhap order by MA_PN DESC";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 //order by MaNV DESC Limit 1
	 public PhieuNhap getPhieuNhap(int id) {
		 PhieuNhap cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from PhieuNhap where MA_PN="+id;
		        Query que = session.createQuery(hql);
		        cl = (PhieuNhap) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public PhieuNhap getLastPhieuNhap() {
		 PhieuNhap cl = null;
		 List<PhieuNhap> list=null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from PhieuNhap order by MA_PN DESC" ;
		        Query que = session.createQuery(hql);
		        list = que.list();
		        cl = (PhieuNhap) list.get(0);
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertPhieuNhap(PhieuNhap sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deletePhieuNhap(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from PhieuNhap where MA_PN ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateNhanVien(int id,PhieuNhap sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        PhieuNhap spp = (PhieuNhap)session.load(PhieuNhap.class, id);
	        spp.setNgayLap(sp.getNgayLap());
	        
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) {
		PhieuNhap pn = new PhieuNhapDAO().getLastPhieuNhap();
		System.out.println(pn.getMaPn());
	}
	
}
