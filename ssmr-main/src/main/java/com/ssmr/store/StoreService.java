package com.ssmr.store;

import com.ssmr.util.ResponseDto;
import com.ssmr.util.ResponseUtil;
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

    @Autowired
    StoreRepository StoreRepository;
    public static ResponseDto<Object> CallCertiAPI(String BIS_NUM) throws IOException, ParseException {
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
            String tax_type = (String)jsonObj2.get("tax_type");
            System.out.println("b_stt_cd: "+b_stt_cd);
            if (!(b_stt_cd == "")) { //존재하는 사업자 번호인경우 코드 반환
                return ResponseUtil.SUCCESS( "존재하는 사업자 번호입니다.", null );
            } else {
                return ResponseUtil.FAILURE( tax_type, null );
            }
        } else {
            return ResponseUtil.ERROR( "사업자 상태 조회 실패", null );
        }
    }

    public StoreDto createBisDto(StoreDto BisDTO) {

        StoreDto bisDto = new StoreDto();
//        bisDto.setUSER_ID(joinDto.getUSER_ID());
        bisDto.setBIS_DIV(BisDTO.getBIS_DIV());
        bisDto.setBIS_NAME(BisDTO.getBIS_NAME());
        bisDto.setBIS_TYPE_L(BisDTO.getBIS_TYPE_L());
        bisDto.setBIS_TYPE_M(BisDTO.getBIS_TYPE_M());
        bisDto.setBIS_NAME(BisDTO.getBIS_NAME());
        bisDto.setBIS_NUM(BisDTO.getBIS_NUM());
        bisDto.setADDRESS(BisDTO.getADDRESS());
        bisDto.setSTORE_TEL(BisDTO.getSTORE_TEL());

        return bisDto;
    }

    public StoreDto createStoreDto(StoreDto storeDTO) {

        StoreDto storeDto = new StoreDto();
//        storeDto.setUSER_ID(joinDto.getUSER_ID());
        storeDto.setBIS_DIV(storeDTO.getBIS_DIV());
        storeDto.setBIS_NAME(storeDTO.getBIS_NAME());
        storeDto.setBIS_TYPE_L(storeDTO.getBIS_TYPE_L());
        storeDto.setBIS_TYPE_M(storeDTO.getBIS_TYPE_M());
        storeDto.setBIS_NAME(storeDTO.getBIS_NAME());
        storeDto.setBIS_NUM(storeDTO.getBIS_NUM());
        storeDto.setADDRESS(storeDTO.getADDRESS());
        storeDto.setSTORE_TEL(storeDTO.getSTORE_TEL());
//        storeDto.setOPEN_TIME(storeDTO.getOPEN_TIME());

        return storeDto;
    }
    public ResponseDto<Object> regiBis(StoreDto bisDto) {

        if ( StoreRepository.regiBis(bisDto) == 1 ) {
            return ResponseUtil.SUCCESS( "사업자 등록 성공", null );
        } else {
            return ResponseUtil.FAILURE( "사업자 등록 실패", null );
        }

    }

    public ResponseDto<Object> regiStore(StoreDto storeDto) {

        if ( StoreRepository.regiStore(storeDto) == 1 ) {
            return ResponseUtil.SUCCESS( "점포 등록 성공", null );
        } else {
            return ResponseUtil.FAILURE( "점포 등록 실패", null );
        }

    }
}
