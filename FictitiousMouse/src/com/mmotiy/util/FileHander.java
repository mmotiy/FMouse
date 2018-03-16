package com.mmotiy.util;

import java.io.File;

public class FileHander {

	public static File find(File parentPath, String fileName) {
		if(!parentPath.exists()) {
			return null;
		}
		if(parentPath.isFile()) {//is file
			if(parentPath.getName().equals(fileName)) {
				return parentPath;
			}
		}else {//is dir                                                                                                                                                                                                                     
			for(File f:parentPath.listFiles()) {
				if(f.isFile()) {
					if(f.getName().equals(fileName)) {
						return f;
					}
				}else if(f.isDirectory()) {
					File find = FileHander.find(f, fileName);
					if(find!=null) {
						return find;
					}
				}
			}	
		}
		return null;
	}

	public static File find(String parentPath, String fileName) {
		return FileHander.find(new File(parentPath), fileName);
	}
}
