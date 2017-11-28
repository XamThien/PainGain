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


import model.ChiTietPhieuNhap;


public class ChiTietPhieuNhapDAO {
	 @SuppressWarnings("unchecked")
	public  List<ChiTietPhieuNhap> getAllChiTietPhieuNhap(){
		 List<ChiTietPhieuNhap> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietPhieuNhap";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public ChiTietPhieuNhap getChiTietPhieuNhap(int id) {
		 ChiTietPhieuNhap cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietPhieuNhap where MA_CT_PN="+id;
		        Query que = session.createQuery(hql);
		        cl = (ChiTietPhieuNhap) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertChiTietPhieuNhap(ChiTietPhieuNhap sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteChiTietPhieuNhap(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from ChiTietHoaDon where MA_CT_PN ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateChiTietPhieuNhap(int id,ChiTietPhieuNhap sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        ChiTietPhieuNhap spp = (ChiTietPhieuNhap)session.load(ChiTietPhieuNhap.class, id);
	        spp.setMaPn(sp.getMaPn());
	        spp.setMaSp(sp.getMaSp());
	        spp.setDonGia(sp.getDonGia());
	        spp.setSoLuong(sp.getSoLuong());
	        spp.setMaNcc(sp.getMaNcc());
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 
	
}
