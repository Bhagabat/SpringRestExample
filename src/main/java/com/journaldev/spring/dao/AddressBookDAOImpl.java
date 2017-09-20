package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.journaldev.spring.model.Address;

public class AddressBookDAOImpl implements AddressBookDAO{

	private static final Logger logger = LoggerFactory.getLogger(AddressBookDAOImpl.class);
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Address addr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(addr);
		logger.info("new address saved......");
	}

	@Override
	public void update(Address addr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(addr);
	}

	@Override
	public Address getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(id));
		return address;
	}

	@Override
	public List<Address> getAddressList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Address> addressList = session.createQuery("from Address").list();
		return addressList;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(id));
		if(address !=null){
			session.delete(address);
		}
	}

}
