package com.mmotiy.dto;
/**
 * 事件数据传输对象 与window中的 tagINPUT 结构体对应
 * @author mmotiy
 *
 */
public class TagINPUT {
	//事件类型
	public int type;
	
	public TagMOUSEINPUT tagMOUSEINPUT;
	
	public TagINPUT(TagMOUSEINPUT tagMOUSEINPUT) {
		this.tagMOUSEINPUT = tagMOUSEINPUT;
	}
	
	public TagINPUT() {}
}
