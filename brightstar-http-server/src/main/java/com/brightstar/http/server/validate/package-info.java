/**
 * 
 * 1. springboot controller的请求报文的自动的校验
 * 
 * 简述JSR303/JSR-349，hibernate validation，spring validation之间的关系：
 * JSR303是一项标准,JSR-349是其的升级版本，添加了一些新特性。
 * 他们规定一些校验规范即校验注解，如@Null，@NotNull，@Pattern，他们位于javax.validation.constraints包下，只提供规范不提供实现。
 * 而hibernate validation是对这个规范的实践，他提供了相应的实现，并增加了一些其他校验注解，如@Email，@Length，@Range等等，他们位于org.hibernate.validator.constraints包下。
 * 而万能的spring为了给开发者提供便捷，对hibernate validation进行了二次封装，显示校验validated bean时，你可以使用spring validation或者hibernate validation，而spring validation另一个特性，便是其在springmvc模块中添加了自动校验，并将校验信息封装进了特定的类中。这无疑便捷了我们的web开发。
 * 
 * @NotNull           任何对象的value不能为null
 * @NotEmpty       集合对象的元素不为0，即集合不为空，也可以用于字符串不为null
 * @NotBlank        只能用于字符串不为null，并且字符串trim()以后length要大于0
 * 
 * 2. Bean4Validate转换成json、xml字符串。
 * Bean里的所有set、get方法一定要注意！！！！！！！最好不要写get方法，会影响序列化结果
 * 
 * 日期的转换:
 * objectMapper.registerModule(javaTimeModule).registerModule(new ParameterNamesModule());
 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss"):加了这个注解，Controller底层是可以直接应用这个注解的，但是自定义的ObjectMapper还得经过一些处理才能使用该注解
 * 
 * 序列化时候忽略为空的属性
 * 1. objectMapper.setSerializationInclusion(Include.NON_EMPTY);
 * 或者
 * 2.@JsonInclude注解
 * @JsonInclude(Include.NON_DEFAULT) 属性为默认值不序列化
 * @JsonInclude(Include.NON_EMPTY) 属性为 空（“”） 或者为 NULL 都不序列化
 * @JsonInclude(Include.NON_NULL) 属性为NULL 不序列化
 * 
 * 序列化的时候忽略某些属性
 * 1. @JsonIgnore
 * 2. @JsonIgnoreProperties
 * 
 * 指定某个字段(类型是POJO)序列化成扁平化，而不是嵌套对象，在反序列化时再包装成对象
 * @JsonUnwrapped
 * 
 * 序列化的字符串是format好的
 * objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
 * 
 * 
 * 序列化为xml字符串时拆除List元素的包装
 * @JacksonXmlElementWrapper
 * 
 *
 */
package com.brightstar.http.server.validate;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
