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
		System.out.println("Nhấn 1 để chọn chức năng lấy ds sp");
		System.out.println("Nhấn 5 để xóa sp");
		
		System.out.print("Chọn chức năng : ");
		Scanner sc = new Scanner(System.in);
		int ck = sc.nextInt() ;
		switch(ck)
		{
		case 1 :
			List<CaLam> listt = new ArrayList<CaLam>();
					listt = new  CaLamDAO().getAllCaLam();
			for (CaLam sp1 : listt)
			{
				System.out.println(sp1.getGioBatDau());
				System.out.println(sp1.getGioKetThuc());
			}
			break;
		
		case 5 :
			new CaLamDAO().deleteCaLam(1);
			System.out.println("Thành công");
			break;
		default : 
			break;
		}
		
			
	}
}
