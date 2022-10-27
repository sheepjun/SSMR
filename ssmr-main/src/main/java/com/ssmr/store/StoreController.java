package com.ssmr.store;

import com.ssmr.util.ResponseDto;
import com.ssmr.util.ResponseUtil;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    /*
     * 기능 : 사업자 등록
     * 작성자: 김채연
     * 내용: 사업자 정보 등록하는 함수
     * 비고:
     */
//    @PostMapping("/bis/store")
//    public ResponseDto regiBis(@RequestBody StoreDto storeDTO){
//
//        //사업자/점포 Dto 객체 데이터 생성
//        StoreDto storeDto = storeService.createBisDto(storeDTO);
//
//        return ResponseUtil.SUCCESS( storeService.regiBis(storeDto) ,null);
//    }

    /*
     * 기능 : 사업자 상태 확인
     * 작성자: 김채연
     * 내용: 사업자 상태 확인 체크
     * 비고:
     */
    @GetMapping("/bis/store")
    public ResponseDto certiBisStore(String BIS_NUM) throws IOException, ParseException {

        return ResponseUtil.SUCCESS( storeService.CallCertiAPI(BIS_NUM), null );
    }
}