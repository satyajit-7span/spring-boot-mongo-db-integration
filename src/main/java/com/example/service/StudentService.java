package com.example.service;

import com.example.dto.request.StudentRequestDto;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {

    List<StudentResponseDto> findAll();

    BaseResponse insert(StudentRequestDto studentRequestDto);
}
