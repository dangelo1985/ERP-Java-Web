package br.com.erp.main;

import org.hibernate.Session;

import br.com.erp.util.HibernateUtil;

public class HibernateUtilTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		session.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
