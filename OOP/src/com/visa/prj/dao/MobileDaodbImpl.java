package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public class MobileDaodbImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println("added into databse!!!");
	}

	@Override
	public Mobile getMobile(int id) {
		return null;
	}

}
