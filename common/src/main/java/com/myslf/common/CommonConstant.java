package com.myslf.common;
//// 
 
	public interface CommonEnum {
		public String getCode();
		public String getString();
	}
	public enum TradeEnum implements CommonEnum{
		SUSSESS("1","�ɹ�"),FAIL("2","ʧ��");
<<<<<<< HEAD
		SUSSESS("1","�ɹ�"),FAIL("2","ʧ��");
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
		SAVE("1","����ɹ�"),
		DELETE("2","ɾ��"),
		CREATE("3","������"),
		APLLY("4","����"),
		CHECK("5","���"),
		RECHECK("6","����"),
		CHECKPASS("7","���ͨ��"),
		RECHECKPASS("8","����ͨ��"),
		CHECKFAIL("9","���ʧ��"),
		RECHECKFAIL("10","����ʧ��"),
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
