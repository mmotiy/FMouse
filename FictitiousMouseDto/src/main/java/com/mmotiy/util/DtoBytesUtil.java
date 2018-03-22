package com.mmotiy.util;

import com.mmotiy.dto.TagINPUT;
import com.mmotiy.dto.TagMOUSEINPUT;

public class DtoBytesUtil {
	static public byte[] toBytes(TagINPUT tagINPUT) {
		byte[]  bytes= new byte[30];
		DtoBytesUtil.copyInt2Bytes(bytes, 0, tagINPUT.type);
		if(tagINPUT.type == FMConstants.INPUT_MOUSE) {
			/*public int dx;
			public int dy;
			public int mouseData;
			public int dwFlags;
			public int time;
			public int dwExtraInfo;*/
			DtoBytesUtil.copyInt2Bytes(bytes, 4, tagINPUT.tagMOUSEINPUT.dx);
			DtoBytesUtil.copyInt2Bytes(bytes, 8, tagINPUT.tagMOUSEINPUT.dy);
			DtoBytesUtil.copyInt2Bytes(bytes, 12, tagINPUT.tagMOUSEINPUT.mouseData);
			DtoBytesUtil.copyInt2Bytes(bytes, 16, tagINPUT.tagMOUSEINPUT.dwFlags);
			DtoBytesUtil.copyInt2Bytes(bytes, 20, tagINPUT.tagMOUSEINPUT.time);
			DtoBytesUtil.copyInt2Bytes(bytes, 20, tagINPUT.tagMOUSEINPUT.dwExtraInfo);
		}else if(tagINPUT.type == FMConstants.INPUT_KEYBOARD) {
			
		}else {
			
		}
		return bytes;
	}

	static public TagINPUT toDto(byte[] bytes) {
		TagINPUT tagINPUT = null;
		int type = DtoBytesUtil.bytes2Int(bytes, 0);
		if(type == FMConstants.INPUT_MOUSE) {
			/*public int dx;
			public int dy;
			public int mouseData;
			public int dwFlags;
			public int time;
			public int dwExtraInfo;*/
			tagINPUT = new TagINPUT();
			tagINPUT.type = type;
			TagMOUSEINPUT tagMOUSEINPUT = new TagMOUSEINPUT();
			tagMOUSEINPUT.dx=DtoBytesUtil.bytes2Int(bytes, 4);
			tagMOUSEINPUT.dy=DtoBytesUtil.bytes2Int(bytes, 8);
			tagMOUSEINPUT.mouseData=DtoBytesUtil.bytes2Int(bytes, 12);
			tagMOUSEINPUT.dwFlags=DtoBytesUtil.bytes2Int(bytes, 16);
			tagMOUSEINPUT.time=DtoBytesUtil.bytes2Int(bytes, 20);
			tagMOUSEINPUT.dwExtraInfo=DtoBytesUtil.bytes2Int(bytes, 20);
			tagINPUT.tagMOUSEINPUT = tagMOUSEINPUT;
		}else if(type == FMConstants.INPUT_KEYBOARD) {
			
		}else {
			
		}
		return tagINPUT;
	}

	static private void copyInt2Bytes(byte[] bytes, int begin, int pint) {
		bytes[begin] =  (byte) ((pint & 0xff000000) >> 24);
		bytes[begin + 1] =  (byte) ((pint & 0x00ff0000) >> 16);
		bytes[begin + 2] =  (byte) ((pint & 0x0000ff00)>> 8);
		bytes[begin + 3] =  (byte) (pint & 0x000000ff);
	}

	static private int bytes2Int(byte[] bytes, int begin) {
		int result = 0;
		result |= (0x000000ff & bytes[begin]) << 24;
		result |= (0x000000ff & bytes[begin + 1]) << 16;
		result |= (0x000000ff & bytes[begin + 2]) << 8;
		result |= (0x000000ff & bytes[begin + 3]);
		return result;
	}
	public static void main(String[] args) {
		byte[] bytes = new byte[4];
		DtoBytesUtil.copyInt2Bytes(bytes, 0, -56);
		System.out.println(DtoBytesUtil.bytes2Int(bytes, 0));
		TagMOUSEINPUT iMouseinput = new TagMOUSEINPUT();
		iMouseinput.dx=1;
		TagINPUT input = new TagINPUT();
		input.type =FMConstants.INPUT_MOUSE;
		input.tagMOUSEINPUT = iMouseinput;
		System.out.println(DtoBytesUtil.toDto(DtoBytesUtil.toBytes(input)).tagMOUSEINPUT.dx);
	}
}
