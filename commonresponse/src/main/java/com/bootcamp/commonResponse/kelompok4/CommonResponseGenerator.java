package com.bootcamp.commonResponse.kelompok4;

import java.util.UUID;

public class CommonResponseGenerator {
	public <T> CommonResponse<T> generateCommonResponse(Class<T> clz) {
		CommonResponse<T> resp = new CommonResponse<T>();
		resp.setRequestId(generateRequestId());
		return resp;
	}

	public <T> CommonResponse<T> generateCommonResponse(String responseCode, String responseDesc, Class<T> clz) {
		CommonResponse<T> resp = generateCommonResponse(clz);
		CommonStatus stat = new CommonStatus(responseCode, responseDesc);
		resp.setResponseStatus(stat);
		return resp;
	}

	public <T> CommonResponse<T> generateCommonResponse(T t) {
		CommonResponse<T> resp = new CommonResponse<T>();
		resp.setRequestId(generateRequestId());
		resp.setData(t);
		return resp;
	}


	public String generateRequestId() {
		return UUID.randomUUID().toString();
	}
}
