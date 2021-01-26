package com.nicico.healthDoc.dto.request;

import com.nicico.healthDoc.entity.Location;
import com.nicico.healthDoc.entity.User;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class DocLocationUpdateDto {
    private Date dateTime;
    private User receiver;
    private Location location;
}
