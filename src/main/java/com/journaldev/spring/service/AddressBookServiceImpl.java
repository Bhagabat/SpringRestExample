package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.AddressBookDAO;
import com.journaldev.spring.model.Address;
@Service
public class AddressBookServiceImpl implements AddressBookService{
	AddressBookDAO addressBookDao;
	public void setAddressBookDao(AddressBookDAO addressBookDao){
		this.addressBookDao = addressBookDao;
	}
	@Override
	@Transactional
	public void add(Address addr) {
		addressBookDao.add(addr);
		
	}

	@Override
	@Transactional
	public void update(Address addr) {
		addressBookDao.update(addr);
	}

	@Override
	@Transactional
	public Address getById(int id) {
		return addressBookDao.getById(id);
	}

	@Override
	@Transactional
	public List<Address> getAddressList() {
		return addressBookDao.getAddressList();
	}

	@Override
	@Transactional
	public void delete(int id) {
		addressBookDao.delete(id);
		
	}
	

}
