package com.myself.user.vo.req;

import javax.validation.constraints.NotNull;

import com.myself.user.constant.CodeConstant;
import com.myself.user.vo.resp.HttpResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseRequest extends HttpResponse{
	@NotNull(message=CodeConstant.ERRORCODE1)
	private String userId;
}
