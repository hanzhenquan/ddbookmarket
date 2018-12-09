package com.ddbookmarket.biz;

import java.util.List;

import com.ddbookmarket.model.Bigtype;

public interface BigtypeBiz {
     //保存name，让实现类实现保存
	boolean save(String name);


	List<Bigtype> findAllBigType();

}
