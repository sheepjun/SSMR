package com.ssmr.store;

import okhttp3.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StoreService {

//    @Autowired
//    StoreRepository StoreRepository;
    public static String CallCertiAPI(String BIS_NUM) throws IOException, ParseException {
        String resultValue ="";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"b_no\": [\n\""+BIS_NUM+"\"\n  ]\n}");
        Request request = new Request.Builder()
                .url("https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=MwY4Y%2Fu09G%2Bz0baokdQ3nkExMiDEnS0YJ9uxGI5AGxYZhD%2FPP%2Bv%2BK5nuPkB4YfOzEL9oLhlnzYOia289hHbG7Q%3D%3D")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        //Response형 -> String형
        String userString = response.body().string();

        JSONParser jsonParser = new JSONParser();
        //To Object
        JSONObject jsonObj = (JSONObject)jsonParser.parse(userString);
        JSONArray jsonArr = (JSONArray)jsonObj.get("data");
        System.out.println("jsonObj"+jsonObj);

        String status_code = (String)jsonObj.get("status_code");
        System.out.println("status_code: "+status_code);

        if (status_code.equals("OK")) {
            JSONObject jsonObj2 = (JSONObject)jsonArr.get(0);
            String b_stt_cd = (String)jsonObj2.get("b_stt_cd");
            System.out.println("b_stt_cd: "+b_stt_cd);
            if (!(b_stt_cd == null)) {
                resultValue = "SUCCESS";
            } else {
                resultValue = "FAIL";
            }
        } else {
            resultValue = "FAIL";
        }

        return resultValue;
    }

    public StoreDto createBisDto(StoreDto storeDTO) {

        StoreDto storeDto = new StoreDto();
        storeDto.setBIS_DIV(storeDTO.getBIS_DIV());
        storeDto.setBIS_NAME(storeDTO.getBIS_NAME());
        storeDto.setBIS_TYPE_L(storeDTO.getBIS_TYPE_L());
        storeDto.setBIS_TYPE_M(storeDTO.getBIS_TYPE_M());
        storeDto.setBIS_NAME(storeDTO.getBIS_NAME());
        storeDto.setBIS_NUM(storeDTO.getBIS_NUM());
        storeDto.setADDRESS(storeDTO.getADDRESS());
        storeDto.setSTORE_PHONENUM(storeDTO.getSTORE_PHONENUM());
        storeDto.setOPEN_DATE(storeDTO.getOPEN_DATE());
        storeDto.setOPEN_TIME(storeDTO.getOPEN_TIME());

        return storeDto;
    }
    public String regiBis(StoreDto storeDto) {

        //StoreRepository.regiBis(storeDto);

        return "사업자등록성공";

    }
}
