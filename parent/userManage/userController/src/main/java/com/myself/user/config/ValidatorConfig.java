package com.myself.user.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ValidatorConfig {
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
		/* 设置validator模式为快速失败返回 */
		postProcessor.setValidator(validator());
		return postProcessor;
	}

	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure()
				.addProperty("hibernate.validator.fail_fast", "true")// true--发现校验不过，立即返回，不在进行后续校验；false--全部校验完毕再返回
				.buildValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		return validator;
	}
}
