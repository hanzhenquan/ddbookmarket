package com.ddbookmarket.biz.impl;

import java.util.List;

import com.ddbookmarket.biz.SmallTypeBiz;
import com.ddbookmarket.dao.SmalltypeDao;
import com.ddbookmarket.dao.impl.SmalltypeDaojdbcImpl;
import com.ddbookmarket.model.Smalltype;

public class SmallTypeBizimpl implements SmallTypeBiz {

	@Override
	public boolean save(Smalltype smalltype) {
		SmalltypeDao  smalltypeDao=new SmalltypeDaojdbcImpl();
		return smalltypeDao.save(smalltype);
	}

	@Override
	public List<Smalltype> fanAllbid(int bid) {
		SmalltypeDao  smalltypeDao=new SmalltypeDaojdbcImpl();
		return smalltypeDao.findAllbid(bid);
	}

	@Override
	public int findbidByid(int sid) {
		SmalltypeDao  smalltypeDao=new SmalltypeDaojdbcImpl();
		return smalltypeDao.finAllByBid(sid);
	}

}
