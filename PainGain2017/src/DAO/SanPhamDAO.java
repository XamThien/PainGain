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


import model.SanPham;
import model.NhaCc;


public class SanPhamDAO {
	 @SuppressWarnings("unchecked")
	public  List<SanPham> getAllSanPham(){
		 List<SanPham> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from SanPham";
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
	public  List<SanPham> getLikeString(String str) throws Exception{
		 List<SanPham> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from SanPham where TEN_SP like '%" + str+" %'";
		        Query que = session.createQuery(hql);
		        
		        list = que.list();
		        transaction.commit();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public SanPham getSanPham(Integer id) {
		 SanPham cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from SanPham where MA_SP="+id;
		        Query que = session.createQuery(hql);
		        
		        cl = (SanPham) que.uniqueResult();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertSanPham(SanPham sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        //session.close();
	    }
	 public void deleteSanPham(int id){
			Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        String hql = "delete from SanPham where MA_SP ="+id;
	        Query que = session.createQuery(hql);
	        que.executeUpdate();
	        transaction.commit();
	        //session.close();
	    }
	 public void updateSanPham(int id,SanPham sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        SanPham spp = (SanPham)session.load(SanPham.class, id);
	        spp.setTenSp(sp.getTenSp());
	        spp.setSoLuong(sp.getSoLuong());
	        spp.setDonGiaBan(sp.getDonGiaBan());
	        spp.setDonGiaMua(sp.getDonGiaMua());
	        spp.setMaLoai(sp.getMaLoai());
	        
	        
	        
	        
	        session.update(spp);
	        transaction.commit();
	        //session.close();
	    }
	 public static void main(String[] args) throws Exception {
//		SanPham sp = new SanPhamDAO().getSanPham(2);
//		if(sp!=null)
//		{
//			System.out.println(sp.getDonGiaBan());
//		}
//		else {
//			System.out.println("======================================================");
//		}
//		 
//		 SanPham hh = new SanPhamDAO().getSanPham(6);
//		 //System.out.println(hh.getDonGiaBan());
//		 int xxx = new NhaccSanphamDAO().getNhaccByIdSanpham(hh.getMaSp()).getMaNcc();
//		 System.out.println(xxx);
		 
	}
	
}
