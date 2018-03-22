package com.mmotiy.util;

public interface FMConstants {
	/**
	 * 鼠标事件
	 */
	int INPUT_MOUSE = 0x0000 ;
	/**
	 * 键盘事件
	 */
	int INPUT_KEYBOARD = 0x0001;
	/**
	 * 硬件事件
	 */
	int INPUT_HARDWARE = 0x0002;
	
	
	/**
	 * the follow param is mouseData
	 */
	/**
	 * Set if the first X button is pressed or released.
	 */
	int XBUTTON1 = 0x0001;
	/**
	 * Set if the second X button is pressed or released
	 */
	int XBUTTON2 = 0x0002;
	
	/**
	 * the follow param is dwFlags 
	 */
	
	
	/**
	 * The dx and dy members contain normalized absolute coordinates. 
	 * If the flag is not set, dxand dy contain relative data 
	 * (the change in position since the last reported position). 
	 * This flag can be set, or not set, regardless of what kind of
	 * mouse or other pointing device, if any, is connected to the system.
	 * For further information about relative mouse motion, see the following Remarks section.
	 */
	int MOUSEEVENTF_ABSOLUTE = 0x8000;
	/**
	 * The wheel was moved horizontally, if the mouse has a wheel. The amount of movement is specified in mouseData.
     * Windows XP/2000:  This value is not supported.
	 */
	int MOUSEEVENTF_HWHEEL = 0x01000;
	/**
	 * Movement occurred.
	 */
	int MOUSEEVENTF_MOVE = 0x0001;
	/**
	 * The WM_MOUSEMOVE messages will not be coalesced. The default behavior is to coalesce WM_MOUSEMOVE messages.
	 * Windows XP/2000:  This value is not supported.
	 */
	int MOUSEEVENTF_MOVE_NOCOALESCE = 0x2000;
	/**
	 * The left button was pressed.
	 */
	int MOUSEEVENTF_LEFTDOWN = 0x0002;
	/**
	 * The left button was released.
	 */
	int MOUSEEVENTF_LEFTUP = 0x0004;
	/**
	 * The right button was pressed.
	 */
	int MOUSEEVENTF_RIGHTDOWN = 0x0008;
	/**
	 * The right button was released.
	 */
	int MOUSEEVENTF_RIGHTUP = 0x0010;
	/**
	 * The middle button was pressed.
	 */
	int MOUSEEVENTF_MIDDLEDOWN = 0x0020;
	/**
	 * The middle button was released.

	 */
	int MOUSEEVENTF_MIDDLEUP = 0x0040;
	/**
	 * Maps coordinates to the entire desktop. Must be used with MOUSEEVENTF_ABSOLUTE.
	 */
	int MOUSEEVENTF_VIRTUALDESK = 0x4000;
	/**
	 * The wheel was moved, if the mouse has a wheel. The amount of movement is specified in mouseData.
	 */
	int MOUSEEVENTF_WHEEL = 0x0800;
	/**
	 * An X button was pressed.
	 */
	int MOUSEEVENTF_XDOWN = 0x0080;
	/**
	 * An X button was released.
	 */
	int MOUSEEVENTF_XUP = 0x0100;
	
	
}
