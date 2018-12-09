package com.ddbookmarket.biz.impl;

import java.util.List;

import com.ddbookmarket.biz.BigtypeBiz;
import com.ddbookmarket.dao.BigtypeDao;
import com.ddbookmarket.dao.impl.BigtypeDaoJdbc;
import com.ddbookmarket.model.Bigtype;

public class BigtypeBizImpl implements BigtypeBiz {
	@Override
	  public boolean save(String name) {
		//让小弟执行接口要实现的操作
		  BigtypeDao bigtypedao=new BigtypeDaoJdbc();
			return bigtypedao.save(name);
		}

	@Override
	public List<Bigtype> findAllBigType() {
		BigtypeDao bigtypedao=new BigtypeDaoJdbc();
		return bigtypedao.fandAll();
	}
	
	

}
