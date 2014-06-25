package com.reagan.support.repository;

import java.io.InputStream;

import com.reagan.support.pojo.GridFSFileInfo;

public interface IGridfsDao {

	public String save(InputStream in, GridFSFileInfo gridFSFileInfo);
	
	public void delete(String id);
}
