package com.myself.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myself.user.constant.ResultInfoEnum;
import com.myself.user.vo.req.BaseRequest;
import com.myself.user.vo.resp.BaseResponse;
import com.myself.user.vo.resp.HttpResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/Demo")
@Api(value = "/demo", tags = "测试接口模块")
@Log4j2
public class DemoController {
	@ApiOperation(value = "post测试接口")
	@RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResponse demoPost(@Validated @RequestBody BaseRequest baseRequest) {
		System.out.println("111111" + log);
		return BaseResponse.getBaseResponse(new HttpResponse());

	}

	/**
	 * 本地上传文件接口
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping("/{id}/upload")
	public BaseResponse upload(@RequestParam("file") MultipartFile[] files,@PathVariable("id") String id,
	                       HttpServletRequest request) throws IOException {
	    log.info("图片上传开始.....");
	    for (MultipartFile multipartFile : files) {
			//原始名称
			String originalFilename = multipartFile.getOriginalFilename();
			//上传图片
			if(multipartFile!=null && originalFilename!=null && originalFilename.length()>0){
				//存储图片的物理路径
				String pic_path = "F:\\aaa\\";
				//新的图片名称
				String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				//新图片
				File newFile = new File(pic_path+newFileName);
				//将内存中的数据写入磁盘
				multipartFile.transferTo(newFile);				
			}
		}
		return BaseResponse.getBaseResponse(new HttpResponse(),ResultInfoEnum.TradeInfo.save);
	}
}
