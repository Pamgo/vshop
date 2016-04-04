package com.vshop.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.vshop.service.ISysService;
import com.vshop.service.impl.SysServiceImpl;

/**
 * �ַ�����������
 * @author alison
 * @version 1.0
 *
 */
public class StringHelper {

	/**
	 * 
	 * ��һ���ַ������� MD5 ����<BR/>
	 * ��������MD5<BR/>
	 * �����ˣ�auger <BR/>
	 * 
	 * @param securityStr
	 * @return String<BR/>
	 * @exception <BR/>
	 * @since 1.0.0
	 */
	public static String MD5(String securityStr) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = securityStr.getBytes();
			// ���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ȡ��ǰ��ʽ��ʱ��(yyyy-MM-dd hh:mm:ss)
	 * ��������getCurrentFormatDate
	 * @author alison
	 * @return String<BR/>
	 * @exception <BR/>
	 * @since 1.0.0
	 */
	public static String getCurrentFormatDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datetime = sdf.format(date);
		return datetime;
	}
	
	/**
	 * ��ȡ��ǰʱ���
	 * ��������getCurrentTimeStamp
	 * @author alison
	 * @return long
	 * @since 1.0.0
	 */
	public static long getCurrentTimeStamp(){
		return System.currentTimeMillis();
	}
	
	/**
	 * ��ʱ���ת����ʱ���ʽΪ"yyyy-MM-dd hh:mm:ss"
	 * @author alison
	 * @param timestamp
	 * @return String <BR/>
	 * @exception <BR/>
	 * @since 1.0.0
	 */
	public static String getDateByTimeStamp(long timestamp){
		if(timestamp != 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = sdf.format(timestamp);
			return date;
		}else{
			return "";
		}
	}
	
	/**
	 * ��ʱ��������û���Ҫת����ʱ���ʽ
	 * @author alison
	 * @param timestamp
	 * @param format
	 * @exception <BR/>
	 * @return String <BR/>
	 * @since 1.0.0
	 */
	public static String getDateByTimeStamp(long timestamp,String format){
		if(timestamp != 0){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String date = sdf.format(new Date(timestamp));
			return date;
		}else{
			return "";
		}
	}
	
	/**
	 * ��ʱ���ַ���ת����ʱ���
	 * ��������getTime
	 * @param user_time
	 * @author alison
	 * @throws ParseException
	 * @return long <BR/>
	 * @since 1.0.0
	 */
	public static long getTime(String user_time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
			try {
				date = sdf.parse(user_time);
				long timestamp = date.getTime();
				return timestamp;
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			return 0L;
	}
	

	/**
	 * �Զ��庯��������EL���ʽ�У�
	 * 
	 * @return
	 */
	public static float GetMoneyByNum(int right,int left) {
		ISysService sysService = new SysServiceImpl();
		return sysService.getMoneyByNum((right-left-1)/2);
	}
}
