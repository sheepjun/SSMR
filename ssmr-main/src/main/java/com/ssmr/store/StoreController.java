package com.ssmr.store;

import com.ssmr.util.ResponseDto;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/bis")
@RestController
public class StoreController {

    @Autowired
    StoreService storeService;

    /*
     * 기능 : 사업자 등록
     * 작성자: 김채연
     * 내용: 사업자 정보 등록하는 함수
     * 비고: 사업자 등록하기 화면에서 다음 버튼 클릭 시 호출
     */
    @PostMapping("/info")
    public ResponseDto regiBis(@RequestBody StoreDto bisDTO){

        // 사업자 Dto 객체 데이터 생성
        StoreDto bisDto = storeService.createBisDto(bisDTO);

        // 사업자 정보 등록 수행
        return storeService.regiBis(bisDto);
    }

    /*
     * 기능 : 점포 등록
     * 작성자: 김채연
     * 내용: 가게 정보 등록하는 함수
     * 비고: 가게 정보 입력하기 화면에 다음 버튼 클릭 시 호출
     */
    @PostMapping("/store")
    public ResponseDto regiStore(@RequestBody StoreDto storeDTO){

        // 점포 Dto 객체 데이터 생성
        StoreDto storeDto = storeService.createStoreDto(storeDTO);

        // 점포 등록 수행
        return storeService.regiStore(storeDto);
    }

    /*
     * 기능 : 사업자 상태 확인
     * 작성자: 김채연
     * 내용: 사업자 상태 확인 체크
     * 비고:
     */
    @GetMapping("/stat")
    public ResponseDto certiBisStore(String BIS_NUM) throws IOException, ParseException {

        // 사업자 상태 파악 함수 수행
        return storeService.CallCertiAPI(BIS_NUM);

    }
}