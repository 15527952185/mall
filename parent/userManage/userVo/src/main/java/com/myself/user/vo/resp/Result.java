package com.myself.user.vo.resp;

import org.springframework.http.HttpStatus;

import com.myself.user.constant.ResultInfoEnum;
import com.myself.user.constant.ResultInfoEnum.ResultInfo;

import lombok.Data;

@Data
public class Result {
	private String resultCode = "";
	private String message;
	private Integer httpCode = HttpStatus.OK.value();
	public Result(ResultInfo resultInfo) {
		if(null == resultInfo){
			this.message = ResultInfoEnum.HtttpCode.getHttpMessage(httpCode);
		}else{
			this.resultCode = resultInfo.getCode();
			this.httpCode = resultInfo.getHttpCode();
			this.message = ResultInfoEnum.HtttpCode.getHttpMessage(httpCode);
		}

	}
	
}
