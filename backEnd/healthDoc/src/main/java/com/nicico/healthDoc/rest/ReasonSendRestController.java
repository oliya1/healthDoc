package com.nicico.healthDoc.rest;

import com.nicico.healthDoc.dao.ReasonSendRepository;
import com.nicico.healthDoc.entity.ReasonSend;
import com.nicico.healthDoc.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reason-send")
public class ReasonSendRestController {
    final private ReasonSendRepository reasonSendRepository;
    @GetMapping("/")
    public ResponseEntity<BaseResponse<List<ReasonSend>> > getAll(){
        BaseResponse<List<ReasonSend>> response = new BaseResponse<>();
        try {
            List<ReasonSend> reasonSends = reasonSendRepository.findAll();
            response.setData(reasonSends).setStatus(200).setMessage("عملیات با موفقیت انجام پذیرفت");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            response.setMessage("ارتباط با دیتا بیس برقرار نشد.").setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @PostMapping("/")
    public ResponseEntity<BaseResponse<Integer>> create(@RequestBody ReasonSend reasonSend){
        BaseResponse<Integer> response = new BaseResponse<>();
        try {
            reasonSendRepository.saveAndFlush(reasonSend);
            response.setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(1);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus(400).setMessage("برقراری ارتباط با دیتا بیس مقدور نمیباشد.").setData(0);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
