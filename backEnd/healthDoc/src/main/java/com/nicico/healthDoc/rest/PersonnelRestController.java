package com.nicico.healthDoc.rest;
import com.nicico.healthDoc.dao.PersonnelRepository;
import com.nicico.healthDoc.entity.Personnel;
import com.nicico.healthDoc.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/personnel")
public class PersonnelRestController {
    final private PersonnelRepository personnelRepository;
    @GetMapping("/{personnelNo}")
    public ResponseEntity<BaseResponse<Personnel>> getByPersonnelNo(@PathVariable Long personnelNo){
        BaseResponse<Personnel> response = new BaseResponse<>();
        try {
            Optional<Personnel> optional = personnelRepository.findByPersonnelNo(personnelNo);
            Personnel personnel = optional.orElseThrow(NullPointerException::new);
            response.setData(personnel).setMessage("عملیات با موفقیت انجام شد").setStatus(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NullPointerException e) {
            e.printStackTrace();
            response.setMessage("با شماره پرسنلی وارد شده، پرسنلی در سیستم وجود ندارد").setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            response.setMessage("ارتباط با پایگاه داده برقرار نشد").setStatus(500);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @PostMapping("/")
    public ResponseEntity<BaseResponse<Integer>> create(@RequestBody Personnel personnel){
        BaseResponse<Integer> response = new BaseResponse<>();
        try {
            personnelRepository.saveAndFlush(personnel);
            response.setStatus(200).setMessage("عملیات با موفقیت انجام شد.").setData(1);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus(400).setMessage("برقراری ارتباط با دیتا بیس مقدور نمیباشد.").setData(0);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
