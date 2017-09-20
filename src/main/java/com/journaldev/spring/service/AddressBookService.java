package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Address;

public interface AddressBookService {
	public void add(Address addr);
	public void update(Address addr);
	public Address getById(int id);
	public List<Address> getAddressList();
	public void delete(int id);
	
}
