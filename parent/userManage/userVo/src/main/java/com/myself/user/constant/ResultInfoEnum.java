package com.myself.user.constant;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
public class ResultInfoEnum {
	public enum HtttpCode{
		SERVERERROR(500, "服务器异常"), 
		PARAMERROR(400, "参数错误"), 
		Forbidden(403, "没有权限访问");
		private int httpCode;
		private String message;

		private HtttpCode(int httpCode, String message) {
			this.httpCode = httpCode;
			this.message = message;
		}

		public int getHttpCode() {
			return httpCode;
		}

		public String getMessage() {
			return message;
		}
		public static String getHttpMessage(int httpCode){
			HtttpCode[] htttpCodes = HtttpCode.values();
			for (HtttpCode htttpCode : htttpCodes) {
				if(htttpCode.getHttpCode() == httpCode){
					return htttpCode.getMessage();
				}
			}
			return "";	
		}

	}
	public interface ResultInfo{
		public String getCode();
		public String getLogMessage();
		public int getHttpCode();
	}
	public enum ParmErrorInfo implements ResultInfo{
		ERROR1(CodeConstant.ERRORCODE1,"用户id不能为空",400);
		private String code;
		private String logMessage;
		private int httpCode;
		ParmErrorInfo(String code,String logMessage,int httpCode){
			this.code = code;
			this.httpCode = httpCode;
			this.logMessage = logMessage;
		}
		@Override
		public String getCode() {
			return code;
		}
		@Override
		public String getLogMessage() {
			return logMessage;
		}
		@Override
		public int getHttpCode() {
			return httpCode;
		}
	}
	public enum TradeInfo implements ResultInfo{
		save(CodeConstant.TRADECODE1,"上传图片成功",200);
		private String code;
		private String logMessage;
		private int httpCode;
		TradeInfo(String code,String logMessage,int httpCode){
			this.code = code;
			this.httpCode = httpCode;
			this.logMessage = logMessage;
		}
		@Override
		public String getCode() {
			return code;
		}
		@Override
		public String getLogMessage() {
			return logMessage;
		}
		@Override
		public int getHttpCode() {
			return httpCode;
		}
	}
	private static ConcurrentHashMap<String, ResultInfo> ResultInfoMap = initMap();
	private static ConcurrentHashMap<String, ResultInfo> initMap() {
		ConcurrentHashMap<String, ResultInfo> map = new ConcurrentHashMap<String, ResultInfo>();
		try {
			initMap(ParmErrorInfo.class, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	private static ConcurrentHashMap<String, ResultInfo> initMap(Class clazz,ConcurrentHashMap<String, ResultInfo> map) throws Exception{
		Method method = clazz.getMethod("values");
		ResultInfo inter[] = (ResultInfo[]) method.invoke(null);
		 for (ResultInfo enumMessage : inter) {
		   map.put(enumMessage.getCode(), enumMessage);
		 }
		return ResultInfoMap;
	}
	public static ResultInfo getResultInfoByCode(String code){
		return ResultInfoMap.get(code);
	}
}
