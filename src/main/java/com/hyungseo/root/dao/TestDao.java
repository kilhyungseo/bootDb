package com.hyungseo.root.dao;

import com.hyungseo.root.dto.MemberDto;

public interface TestDao {

	public void join(String mid, String mpw, String mname, String memail);
	
	public MemberDto dto(String mid);
}
