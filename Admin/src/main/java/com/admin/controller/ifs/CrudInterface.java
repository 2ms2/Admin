package com.admin.controller.ifs;

import com.admin.model.network.Header;

public interface CrudInterface<Req, Res> {
	// 인터페이스를 만들어 CRUD 메소드는 반드시 재정의 하게끔 한다.
	Header<Res> create(Header<Req> request);
	Header<Res> read(Long id);
	Header<Res> update(Header<Req> request);
	Header delete(Long id);
	
}
	