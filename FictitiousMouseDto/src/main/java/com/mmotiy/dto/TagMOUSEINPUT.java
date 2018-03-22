package com.mmotiy.dto;
/**
 * @desr 鼠标事件
 * @author mmotiy
 * @url https://msdn.microsoft.com/en-us/library/windows/desktop/ms646273(v=vs.85).aspx
 */
public class TagMOUSEINPUT {
	public int dx;
	public int dy;
	public int mouseData;
	public int dwFlags;
	public int time;
	/**
	 * An additional value associated with the mouse event.
	 * An application calls GetMessageExtraInfo to obtain this extra information.
	 * 最终没用
	 */
	public int dwExtraInfo;
}
