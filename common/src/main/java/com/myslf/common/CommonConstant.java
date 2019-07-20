package com.myslf.common;
////
public class CommonConstant {
	public interface CommonEnum {
		public String getCode();
		public String getString();
	}
	public enum TradeEnum implements CommonEnum{
		SUSSESS("1","¥Ê¥¢"),FAIL("2"," ß∞‹");
		private String code;
		private String str;
		TradeEnum(String code,String str){
			
		}
		@Override
		public String getCode() {
			return this.code;
		}

		@Override
		public String getString() {
			// TODO Auto-generated method stub
			return this.str;
		}
	}
	public enum DataStatusEnum implements CommonEnum{
		SAVE("1","±£¥Ê≥…π¶"),
		DELETE("2","…æ≥˝"),
		CREATE("3","¥¥Ω®÷–"),
		APLLY("4","…Í«Î"),
		CHECK("5","…Û∫À"),
		RECHECK("6","∏¥∫À"),
		CHECKPASS("7","…Û∫ÀÕ®π˝"),
		RECHECKPASS("8","∏¥∫ÀÕ®π˝"),
		CHECKFAIL("9","…Û∫À ß∞‹"),
		RECHECKFAIL("10","∏¥∫À ß∞‹"),
		;
		private String code;
		private String str;
		DataStatusEnum(String code,String str){
			
		}
		@Override
		public String getCode() {
			return this.code;
		}

		@Override
		public String getString() {
			// TODO Auto-generated method stub
			return this.str;
		}
	}

}
