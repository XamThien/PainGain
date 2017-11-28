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


import model.NhanVien;


public class NhanVienDAO {
	 @SuppressWarnings("unchecked")
	public  List<NhanVien> getAllNhanVien(){
		 List<NhanVien> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public NhanVien getNhanVienByName(String name) {
		 NhanVien cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien where TEN_NV="+name;
		        Query que = session.createQuery(hql);
		        cl = (NhanVien) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public NhanVien getNhanVienByID(int id) {
		 NhanVien cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien where MA_NV="+id;
		        Query que = session.createQuery(hql);
		        cl = (NhanVien) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 
	 public void insertNhanVien(NhanVien sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteNhanVien(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from NhanVien where MA_NV ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateNhanVien(int id,NhanVien sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        NhanVien spp = (NhanVien)session.load(NhanVien.class, id);
	        spp.setTenNv(sp.getTenNv());
	        spp.setGioiTinh(sp.getGioiTinh());
	        spp.setDiaChi(sp.getDiaChi());
	        spp.setNgayVaoLam(sp.getNgayVaoLam());
	        
	       
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) {
		 NhanVien nc = new NhanVien(2,"Mạnhh",1,"thanh xuân","2017-11-28");
		 new NhanVienDAO().updateNhanVien(2, nc);
	}
	
}
