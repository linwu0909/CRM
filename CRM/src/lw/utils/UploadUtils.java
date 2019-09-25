package lw.utils;

import java.util.UUID;

/**解决目录下文件名重复的问题
 * @author 林
 *
 */
public class UploadUtils {
	public static String getUuidFileName(String fileName){
		int idx=fileName.lastIndexOf(".");
		String extions=fileName.substring(idx);
		return UUID.randomUUID().toString().replace("-", "")+extions;
	}
	/*
	 * 目录分离的方法
	 */
	public static String getPath(String uuidFileName){
		int code1=uuidFileName.hashCode();
		int d1=code1&0xf;//作为一级目录
		int code2=code1>>>4;
		int d2=code2&0xf;//作为二级目录
		return "/"+d1+"/"+d2;
	}
	public static void main(String[] args){
		System.out.println(getUuidFileName("aa.txt"));
	}
}
