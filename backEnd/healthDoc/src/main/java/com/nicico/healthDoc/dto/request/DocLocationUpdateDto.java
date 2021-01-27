package com.nicico.healthDoc.dto.request;

import com.nicico.healthDoc.entity.Location;
import com.nicico.healthDoc.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocLocationUpdateDto {
    private User receiver;
    private Location location;
}
