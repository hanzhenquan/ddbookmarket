package com.ddbookmarket.biz;

import java.util.List;

import com.ddbookmarket.model.Smalltype;

public interface SmallTypeBiz {

	boolean save(Smalltype smalltype);

	List<Smalltype> fanAllbid(int bid);

	int findbidByid(int sid);


}
