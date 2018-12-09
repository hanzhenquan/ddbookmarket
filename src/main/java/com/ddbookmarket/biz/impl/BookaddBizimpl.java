package com.ddbookmarket.biz.impl;

import java.util.List;

import com.ddbookmarket.biz.BookaddBiz;
import com.ddbookmarket.dao.BookaddDao;
import com.ddbookmarket.dao.impl.BookaddDaoimpl;
import com.ddbookmarket.model.Bookaddtype;

public class BookaddBizimpl implements BookaddBiz {

	@Override
	public boolean save(Bookaddtype bookaddtype) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.save(bookaddtype);
	}

	@Override
	public List<Bookaddtype> findbook(int dangqianpage,String name,int sid) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.findBook(dangqianpage,name,sid);
	}

	@Override
	public int zongrow(String name,int sid) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.total(name,sid);
	}

	@Override
	public int delbook(int id) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.delid(id);
	}

	@Override
	public Bookaddtype findbookid(int id) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.find(id);
	}

	@Override
	public boolean update(Bookaddtype bookaddtype) {
		BookaddDao bookaddDao=new BookaddDaoimpl();
		return bookaddDao.update(bookaddtype);
	}


}
