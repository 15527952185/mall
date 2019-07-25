package com.myslf.common;
//// 
 
	public interface CommonEnum {
		public String getCode();
		public String getString();
	}
	public enum TradeEnum implements CommonEnum{
		SUSSESS("1","成功"),FAIL("2","失败");
<<<<<<< HEAD
		SUSSESS("1","成功"),FAIL("2","失败");
=======
>>>>>>> c45066f28ba1aff32aa70da56f170957be1fbd0e
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
		SAVE("1","保存成功"),
		DELETE("2","删除"),
		CREATE("3","创建中"),
		APLLY("4","申请"),
		CHECK("5","审核"),
		RECHECK("6","复核"),
		CHECKPASS("7","审核通过"),
		RECHECKPASS("8","复核通过"),
		CHECKFAIL("9","审核失败"),
		RECHECKFAIL("10","复核失败"),
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
