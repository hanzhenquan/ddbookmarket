package com.ddbookmarket.dao;

import java.util.List;

import com.ddbookmarket.model.Bookaddtype;

public interface BookaddDao {

	boolean save(Bookaddtype bookaddtype);

	List<Bookaddtype> findBook(int dangqianpage, String name, int sid);

	int total(String name, int sid);

	int delid(int id);

	Bookaddtype find(int id);

	boolean update(Bookaddtype bookaddtype);

}
