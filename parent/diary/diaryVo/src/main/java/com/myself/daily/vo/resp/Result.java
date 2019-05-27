package com.myself.daily.vo.resp;

import com.myself.daily.constant.ResultInfoEnum.CommonErrorCode;

import lombok.Data;

@Data
public class Result {
	private String resultCode;
	private String message;
	private Integer httpCode;
	public Result(CommonErrorCode errorCode) {
		super();
		this.resultCode = errorCode.getResultCode();
		this.message = errorCode.getMessage();
		this.httpCode = errorCode.getHttpStatus().value();
	}
	
}
