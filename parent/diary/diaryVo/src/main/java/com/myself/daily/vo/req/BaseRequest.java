package com.myself.daily.vo.req;

import javax.validation.constraints.NotNull;

import com.myself.daily.vo.resp.HttpResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseRequest extends HttpResponse{
	@NotNull(message="aaaaaa")
	private String userId;
}
