package com.brightstar.http.server.validate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@JsonPropertyOrder({"memid","name"})
@JacksonXmlRootElement(localName = "Request")
public class Bean4Validate {

	/**
	 * 字符串trim()后length要大于0
	 */
	@NotBlank(message = "memid不能为空")
	String memid;

	@Length(min = 2, max = 8, message = "姓名长度必须在2-8之间")
	String name;

	@Email(message = "邮箱格式错误")
	private String email;

	/**
	 * 必须是数字且必须有范围
	 */
	@Range(min = 18, max = 70, message = "年龄必须在18到70之间")
	int age;

	/**
	 * 必须是true
	 */
	@AssertTrue(message = "必须是人类")
	boolean person;

	@Past(message = "注册日期有误")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime insertTime;

	@Pattern(regexp = "([A-Z1-9][A-Z1-9])(\\d{1,4})([A-Z]?)", message = "航班号不正确")
	String flightNo;

	/**
	 * 不能再校验List中的String
	 */
	@NotEmpty(message="证件号不能为空")
	@JacksonXmlElementWrapper(localName = "certs")
	private List<String> cert;

	/**
	 * 添加上@Valid后可以校验List中的对象
	 */
	@NotEmpty(message="会员卡号不能为空")
	@Valid
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<MemCard> memnos;
	
	/**
	 * 添加上@Valid后可以校验Map中的对象
	 */
	@NotEmpty(message="家庭住址不能为空")
	@Valid
	private Map<String,Home> homes;

	@JsonUnwrapped
	@Valid
	Telephone tel;
	
	@JsonIgnore
	private String ignore;
	

	
	public Bean4Validate() {
	}






	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isPerson() {
		return person;
	}

	public void setPerson(boolean person) {
		this.person = person;
	}

	public LocalDateTime getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public List<MemCard> getMemnos() {
		return memnos;
	}

	public void setMemnos(List<MemCard> memnos) {
		this.memnos = memnos;
	}

	public List<String> getCert() {
		return cert;
	}

	public void setCert(List<String> cert) {
		this.cert = cert;
	}

	public Map<String, Home> getHomes() {
		return homes;
	}

	public void setHomes(Map<String, Home> homes) {
		this.homes = homes;
	}
	
	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}

	public Telephone getTel() {
		return tel;
	}

	public void setTel(Telephone tel) {
		this.tel = tel;
	}
	
	public static Bean4Validate example() {
		Bean4Validate bean = new Bean4Validate();
		bean.setAge(36);
		bean.setCert(new ArrayList<String>() {{add("ni123456");add("ni654321");}});
		bean.setEmail("key@gmail.com");
		bean.setFlightNo("CA101");
		bean.setInsertTime(LocalDateTime.now());
		bean.setMemid("memid123");
		bean.setName("KeyLee");
		bean.setPerson(true);
		bean.setMemnos(new ArrayList<MemCard>() {{add(new MemCard("mem12345"));add(new MemCard("mem54321"));}});
		bean.setHomes(new HashMap<String,Home>(){{put("home1",new Home("慧忠"));put("home2",new Home("紫玉"));}});
		bean.setTel(new Telephone("13812344321"));
		return bean;
	}
	
	
	public String toJson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addSerializer(LocalDate.class,
				new LocalDateSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_FORMAT)));
		javaTimeModule.addSerializer(LocalTime.class,
				new LocalTimeSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDate.class,
				new LocalDateDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_FORMAT)));
		javaTimeModule.addDeserializer(LocalTime.class,
				new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_TIME_FORMAT)));
		objectMapper.registerModule(javaTimeModule).registerModule(new ParameterNamesModule());
		
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		return objectMapper.writeValueAsString(this);
	}

	public String toXml() throws JsonProcessingException {
		XmlMapper objectMapper = new XmlMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addSerializer(LocalDate.class,
				new LocalDateSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_FORMAT)));
		javaTimeModule.addSerializer(LocalTime.class,
				new LocalTimeSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDate.class,
				new LocalDateDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_DATE_FORMAT)));
		javaTimeModule.addDeserializer(LocalTime.class,
				new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstants.DEFAULT_TIME_FORMAT)));
		objectMapper.registerModule(javaTimeModule).registerModule(new ParameterNamesModule());
 
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		return objectMapper.writeValueAsString(this);
	}

	
	public static void main(String[] args) throws JsonProcessingException {
		
//		System.out.println(example().toJson());
		System.out.println(example().toXml());
	}








}
