package com.ddbookmarket.dao;

import java.util.List;

import com.ddbookmarket.model.Bigtype;

public interface BigtypeDao {

	boolean save(String name);

	List<Bigtype> fandAll();

}
