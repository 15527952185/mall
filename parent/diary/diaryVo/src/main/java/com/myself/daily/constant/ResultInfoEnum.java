package com.myself.daily.constant;

import org.springframework.http.HttpStatus;

public class ResultInfoEnum {
	public interface ResultInfo {
		public String getResultCode();

		public String getMessage();

		public HttpStatus getHttpStatus();
	}

	public enum CommonErrorCode implements ResultInfo {
		SERVERERROR("1", "服务器异常", HttpStatus.INTERNAL_SERVER_ERROR), SAVESUSSESS("2", "保存成功",
				HttpStatus.OK), PARAMERROR("4", "参数错误",
						HttpStatus.PAYMENT_REQUIRED), Forbidden("5", "没有权限访问", HttpStatus.FORBIDDEN);
		private String errorCode;
		private String message;
		private HttpStatus httpStatus;

		private CommonErrorCode(String errorCode, String message, HttpStatus httpStatus) {
			this.errorCode = errorCode;
			this.message = message;
			this.httpStatus = httpStatus;
		}

		@Override
		public String getResultCode() {
			return errorCode;
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public HttpStatus getHttpStatus() {
			return httpStatus;
		}

	}

}
