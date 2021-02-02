/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import nicico.model.BaseResponse;
import nicico.model.ReasonSend;
import nicico.utility.Common;

/**
 *
 * @author jafari-h
 */
public class ReasonSendService {
    ObjectMapper mapper = new ObjectMapper();
    public List<ReasonSend> reasons() throws IOException{
        String data = Common.getJSON("reason-send/", 3000);        
        BaseResponse<List<ReasonSend>> fromJson = mapper.readValue(data, new TypeReference<BaseResponse<List<ReasonSend>>>(){});
        List<ReasonSend> reasons = fromJson.getData();
        return reasons;
    }
    
    public BaseResponse<Integer> create(ReasonSend reasonSend) throws IOException{
        String jsonString = mapper.writeValueAsString(reasonSend);
        String excutePost = Common.excutePost("reason-send/", jsonString, "POST");
        System.out.println(excutePost);
        BaseResponse<Integer> response = mapper.readValue(excutePost, new TypeReference<BaseResponse<Integer>>(){});
        System.out.println(response.getMessage());
        return response;
    }
}
