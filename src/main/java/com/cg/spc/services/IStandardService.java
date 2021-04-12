package com.cg.spc.services;

import com.cg.spc.entities.Standard;

public interface IStandardService {
	public Standard addDetails(Standard standard);
	public Standard getDetailsById(int id);
	public Standard updateDetails(Standard standard);
	public Standard deleteDetailsById(int id);
}
