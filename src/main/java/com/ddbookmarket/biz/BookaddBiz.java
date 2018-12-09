package com.ddbookmarket.biz;

import java.util.List;

import com.ddbookmarket.model.Bookaddtype;

public interface BookaddBiz {

	boolean save(Bookaddtype bookaddtype);

	List<Bookaddtype> findbook(int dangqianpage, String name, int sid);

	int zongrow(String name, int sid);

	int delbook(int id);

	Bookaddtype findbookid(int id);

	boolean update(Bookaddtype bookaddtype);

}
