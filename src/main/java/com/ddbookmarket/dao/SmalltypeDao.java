package com.ddbookmarket.dao;

import java.util.List;

import com.ddbookmarket.model.Smalltype;

public interface SmalltypeDao {

	boolean save(Smalltype smalltype);

	List<Smalltype> findAllbid(int bid);

	int finAllByBid(int sid);

}
