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


import model.ChiTietHoaDon;


public class ChiTietHoaDonDAO {
	 @SuppressWarnings("unchecked")
	public  List<ChiTietHoaDon> getAllChiTietHoaDon(int MaHD){
		 List<ChiTietHoaDon> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietHoaDon where MA_HD=:ma ";
		        Query que = session.createQuery(hql);
		        que.setParameter("ma", MaHD);
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public ChiTietHoaDon getChiTietHoaDon(int id) {
		 ChiTietHoaDon cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietHoaDon where MA_CT_HD="+id;
		        Query que = session.createQuery(hql);
		        cl = (ChiTietHoaDon) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertChiTietHoaDon(ChiTietHoaDon sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteChiTietHoaDon(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from ChiTietHoaDon where MA_CT_HD ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateChiTietHoaDon(int id,ChiTietHoaDon sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        ChiTietHoaDon spp = (ChiTietHoaDon)session.load(ChiTietHoaDon.class, id);
	        spp.setMaHd(sp.getMaHd());
	        spp.setMaSp(sp.getMaSp());
	        spp.setSoLuong(sp.getSoLuong());
	        spp.setGiamGia(sp.getGiamGia());
	        spp.setLaPhanTram(sp.getLaPhanTram());
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) {
		List<ChiTietHoaDon> lst = new ChiTietHoaDonDAO().getAllChiTietHoaDon(3);
		for (ChiTietHoaDon ct : lst)
		{
			System.out.println(ct.getSoLuong());
		}
	}
	
}
