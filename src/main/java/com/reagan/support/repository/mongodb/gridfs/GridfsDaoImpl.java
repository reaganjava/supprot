package com.reagan.support.repository.mongodb.gridfs;


import java.io.IOException;
import java.io.InputStream;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.reagan.support.pojo.GridFSFileInfo;
import com.reagan.support.repository.IGridfsDao;

public class GridfsDaoImpl implements IGridfsDao {
	
	/**
	 * MongoDB模板类
	 */
    private MongoTemplate fsTemplate;
    
    private GridFS gridFS;
	
	public void setFsTemplate(MongoTemplate fsTemplate) {
		this.fsTemplate = fsTemplate;
		gridFS = new GridFS(fsTemplate.getDb());
	}

	public String save(InputStream in, GridFSFileInfo gridFSFileInfo) {
		String pk = null;
		DBObject query  = new BasicDBObject("_id", gridFSFileInfo.getId());
		GridFSDBFile gridFSDBFile = gridFS.findOne(query); 
		if(gridFSDBFile == null) {
			GridFSInputFile gridFSInputFile = gridFS.createFile(in);  
			gridFSInputFile.setFilename(gridFSFileInfo.getFilename());
			gridFSInputFile.setContentType(gridFSFileInfo.getContentType());
			gridFSInputFile.setChunkSize(gridFSFileInfo.getLenght());
			gridFSInputFile.save();
			pk = gridFSInputFile.getId().toString();
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pk;
	}

	public void delete(String id) {
		ObjectId objid= new ObjectId(id);
		DBObject query  = new BasicDBObject("_id", objid);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		gridFS.remove(gridFSDBFile);
	}
	
}
