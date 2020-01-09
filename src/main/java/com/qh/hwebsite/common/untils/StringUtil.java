package com.qh.hwebsite.common.untils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	
	/**获取字符串编码
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {      
	       String encode = "GB2312";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "ISO-8859-1";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	   }

	//根据字符串获取数字元素之和
	public static String StringSum(String ss){
		String[] arr=ss.split(",");
		int sum=0;
		for(String s:arr){
			sum+=Integer.parseInt(s);
		}
		return String.valueOf(sum);
	}

	//根据字符串获取数字元素之积
	public static String StringSum2(String ss,String num){
		String[] arr=ss.split(",");
		String[] nums=num.split(",");
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=Integer.parseInt(arr[i])*Integer.parseInt(nums[i]);
		}
		return String.valueOf(sum);
	}

	//获取的字符串如果是以数字结尾,则数字加1产生新的字符串
	public static String getNewString(String s){

		String str="0123456789";
		String result="";
		//判断最后一位是否是数字
		if(str.indexOf(s.substring(s.length()-1))!=-1){
			String regex="[^0-9]";
			String ss= s.replaceAll(regex,"@");
			String sss=ss.replaceAll("(@)\\1+", "$1");
			String [] arr=sss.split("@");
			String temp=arr[arr.length-1];
			String newtemp=String.valueOf(Integer.parseInt(temp)+1);
			result = s.substring(0, s.indexOf(temp))+newtemp;
		}
		return result;
	}


	//自动补成9位数
	public static String getCode() {
		//判断当前字符串是否是9位数,不是的话前面补0
		int random = (int) Math.round(Math.random() * (999 - 500) + 500);
		int ran = (int) Math.round(Math.random() * (400-100)+100);
		String code=random+""+ran;
		return code;
	}

	/**
	 * 去掉members中的str字符串
	 * @param members
	 * @param str
	 * @return
	 */
	public static String subString(String members,String str){
		int length= members.length();
		int index=members.indexOf(str);
		int len=str.length();
		String nmembers=null;
		if(!members.startsWith(str)) {//str不在members的首位
			if (len + index == length) {//说明str在members的最后面
				nmembers = members.substring(0, index - 1);
			} else {//说明是在中间
				nmembers = members.replaceAll("," + str + ",", ",");
			}
		}else{
			nmembers=members.substring(len+1);
		}

		return nmembers;
	}

	//将指定日期字符串转为LocalDate类型
	public static LocalDate stringToLocalDate(String time){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(time, fmt);
		return date;
	}

	/**
	 * 将驼峰字符串转为小写的下划线链接 agentPhone->agent_phone
	 */
	public static String strConvertNew(String old){

//		Character.isUpperCase(c); // 是否是大写
//		Character.isUpperCase(c); // 是否是小写
		char [] arr=old.toCharArray();
//        ch[i]-=32; 字符转为大写
//        arr[i]+=32; 字符转为小写
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<arr.length;i++){

			if(Character.isUpperCase(arr[i])){ //如果字符是大写
				arr[i]+=32;//将字符转为小写
				sb.append("_");
				sb.append(arr[i]);
			}else{
				sb.append(arr[i]);
			}
		}
		String str = sb.toString();

		return str;
	}

}
