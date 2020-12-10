package com.colco.medicalrepresentative.exceptionhandle;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StatusResponse {

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
	
	DRUG_ALREADY_PRESENT(211,"DRUG_ALREADY_PRESENT"),
	DRUG_NOT_PRESENT(212,"DRUG_NOT_PRESENT");
	
	


    private final Integer code;
    private final String reason;

    private static final Map<Integer, StatusResponse> RESPONSE_STATUS_CODE_MAP = Arrays
            .stream(StatusResponse.values())
            .collect(Collectors.toMap(StatusResponse::getCode, Function.identity()));


    StatusResponse(Integer code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public static StatusResponse valueOf(int value) {
        if (RESPONSE_STATUS_CODE_MAP.containsKey(value)) {
            return RESPONSE_STATUS_CODE_MAP.get(value);
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }

    public Integer getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "code=" + code +
                ", reason='" + reason + '\'' +
                '}';
    }
}
