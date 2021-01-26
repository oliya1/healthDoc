package com.nicico.healthDoc.rest;

import com.nicico.healthDoc.dao.DocLocationHistoryRepository;
import com.nicico.healthDoc.dto.request.DocLocationUpdateDto;
import com.nicico.healthDoc.entity.DocLocationHistory;
import com.nicico.healthDoc.mapper.DocLocationHistoryMapper;
import com.nicico.healthDoc.response.BaseResponse;
import lombok.Data;
import org.springframework.aop.AopInvocationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/doc-history")
public class DocLocationHistoryRestController {
    final private DocLocationHistoryRepository docLocationHistoryRepository;
    final private DocLocationHistoryMapper docLocationMapper;

    @GetMapping("/{barcode}")
    public ResponseEntity<BaseResponse<List<DocLocationHistory>>> getByBarcode(@PathVariable String barcode){
        BaseResponse<List<DocLocationHistory>> response;
        try {
            List<DocLocationHistory> docs = docLocationHistoryRepository.findByBarcode(barcode);
            response = new BaseResponse<List<DocLocationHistory>>().setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(docs);
        }
        catch(Exception e){
            response = new BaseResponse<List<DocLocationHistory>>().setStatus(500).setMessage("ارتباط با پایگاه داده برقرار نشد.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/max-level/{barcode}")
    public ResponseEntity<BaseResponse<Integer>> getMaxLevel(@PathVariable String barcode){
        BaseResponse<Integer> response = new BaseResponse<>();
        try {
//            int maxLevel = docLocationHistoryRepository.getMaxLevel(barcode);
            Optional<Integer> integer = docLocationHistoryRepository.getMaxLevel(barcode);
            Integer maxLevel = integer.orElse(0);
            response.setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(maxLevel);
        } catch(AopInvocationException e){
            response.setStatus(201).setMessage("بارکد وارد شده در پایگاه داده وجود ندارد.");
        } catch(Exception e){
            response.setStatus(500).setMessage("ارتباط با پایگاه داده برقرار نشد.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<BaseResponse<Integer>> create(@RequestBody DocLocationHistory docLocationHistory){
        BaseResponse<Integer> response = new BaseResponse<>();
        try {
            docLocationHistoryRepository.saveAndFlush(docLocationHistory);
            response.setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(1);
        } catch(Exception e){
            response.setStatus(500).setMessage("ارتباط با پایگاه داده برقرار نشد.").setData(0);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Integer>> update(
            @RequestBody DocLocationUpdateDto docLocationUpdateDto,
            @PathVariable Long id
                                                        ){
        BaseResponse<Integer> response = new BaseResponse<>();
        try {
            Optional<DocLocationHistory> byId = docLocationHistoryRepository.findById(id);
            DocLocationHistory docLocationHistory = byId.orElseThrow(Exception::new);
            docLocationMapper.updateDocLocationFromDto(docLocationUpdateDto, docLocationHistory);
            docLocationHistoryRepository.saveAndFlush(docLocationHistory);
            response.setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(1);
        } catch(Exception e){
            response.setStatus(500).setMessage("ارتباط با پایگاه داده برقرار نشد.").setData(0);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
