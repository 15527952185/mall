package com.myself.daily.vo.resp;

import org.springframework.http.ResponseEntity;

import com.myself.daily.constant.ResultInfoEnum.CommonErrorCode;
public class BaseResponse extends ResponseEntity<HttpResponse>{
	public BaseResponse(HttpResponse httpResponse, CommonErrorCode errorCode) {
		super(httpResponse, errorCode.getHttpStatus());
		httpResponse.setResult(new Result(errorCode));
	}
	public BaseResponse(CommonErrorCode errorCode) {
		this(new HttpResponse(),errorCode);
	}
}
