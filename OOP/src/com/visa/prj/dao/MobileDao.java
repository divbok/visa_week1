package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public interface MobileDao {
	void addMobile(Mobile m);
	Mobile getMobile(int id); // by default public abstract
}
