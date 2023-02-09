package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponseDto extends BaseResponse {

    private String name;
    private String email;
}
