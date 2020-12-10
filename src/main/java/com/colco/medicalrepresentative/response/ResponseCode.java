package com.colco.medicalrepresentative.response;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResponseCode {

	SUCCESS(100, "SUCCESS"),

	FAIL(101, "FAIL"),

	UNKNOWN_ERROR_OCCURRED(102, "UNKNOWN_ERROR_OCCURRED"),

	INVALID_REQUEST_PARAMETER(103, "INVALID_REQUEST_PARAMETER"),

	INTERNAL_SERVER_ERROR(105, "INTERNAL_SERVER_ERROR"),

	INVALID_REQUEST(106, "INVALID_REQUEST"),

	BAD_REQUEST(107, "BAD_REQUEST"),
	
	//MR status code

	MR_SUCCESSFULLY_REGISTERED(111,"MR_SUCCESSFULLY_CREATED"),
	
	MR_ALREADY_EXIST(112,"MR_ALREADY_EXISTS"),
	
	MR_DOES_NOT_EXIST(113,"MR_DOES_NOT_EXIST"),
	
    // Drugs status code
	
	MR_DRUGS_DELETED(006,"MR_DRUGS_DELETED");
	
	


    private final Integer code;
	private final String reasonPhrase;

	private static final Map<Integer, ResponseCode> RESPONSE_STATUS_CODE = Arrays
			.stream(ResponseCode.values())
			.collect(Collectors.toMap(ResponseCode::getCode, Function.identity()));

	private ResponseCode(Integer code, String reasonPhrase) {
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	public static ResponseCode valueOf(int value) {
		if (RESPONSE_STATUS_CODE.containsKey(value)) {
			return RESPONSE_STATUS_CODE.get(value);
		}
		throw new IllegalArgumentException("No matching constant for [" + value + "]");
	}
	public Integer getCode() {
		return code;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	@Override
	public String toString() {
		return "ResponseStatusCode{" +
				"code=" + code +
				", reasonPhrase='" + reasonPhrase + '\'' +
				'}';
	}
}
