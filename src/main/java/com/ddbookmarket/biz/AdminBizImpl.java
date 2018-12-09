package com.ddbookmarket.biz;

import com.ddbookmarket.dao.AdminDao;
import com.ddbookmarket.dao.impl.AdminDaoimpl;
import com.ddbookmarket.model.Admin;

public class AdminBizImpl implements AdminBiz {

	@Override
	public boolean findByAdmin(Admin admin) {
		AdminDao adminDao=new AdminDaoimpl();
		return adminDao.findAdmin(admin);
	}

}
