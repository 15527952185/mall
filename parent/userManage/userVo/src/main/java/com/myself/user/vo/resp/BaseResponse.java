package com.myself.user.vo.resp;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.myself.user.constant.ResultInfoEnum;
import com.myself.user.constant.ResultInfoEnum.ResultInfo;

public class BaseResponse extends ResponseEntity<HttpResponse> implements Serializable {

	private static final long serialVersionUID = 1L;

	private BaseResponse(HttpResponse httpResponse) {
		super(httpResponse, getHttpStatus(httpResponse.getResult().getHttpCode()));
	}

	private static HttpStatus getHttpStatus(int httpCode) {
		HttpStatus[] httpStatuss = HttpStatus.values();
		for (HttpStatus httpStatus : httpStatuss) {
			if (httpStatus.value() == httpCode) {
				return httpStatus;
			}
		}
		return null;
	}

	public static BaseResponse getBaseResponse(HttpResponse httpResponse) {
		if(null == httpResponse){
			httpResponse = new HttpResponse();
		}
		if(null == httpResponse.getResult()){
			httpResponse.setResult(new Result(null));
		}
		return new BaseResponse(httpResponse);
	}

	public static BaseResponse getBaseResponse(HttpResponse httpResponse, ResultInfo resultInfo) {
		httpResponse.setResult(new Result(resultInfo));
		return new BaseResponse(httpResponse);
	}
	public static BaseResponse getBaseResponse(HttpResponse httpResponse, String code) {
		httpResponse.setResult(new Result(ResultInfoEnum.getResultInfoByCode(code) ));
		return new BaseResponse(httpResponse);
	}
	public static BaseResponse getBaseResponse(String code) {
		HttpResponse httpResponse = new HttpResponse();
		httpResponse.setResult(new Result(ResultInfoEnum.getResultInfoByCode(code) ));
		return new BaseResponse(httpResponse);
	}
}
