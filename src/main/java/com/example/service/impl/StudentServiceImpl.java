package com.example.service.impl;

import com.example.constants.StudentConstants;
import com.example.dto.request.StudentRequestDto;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.StudentResponseDto;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    BaseResponse response = new BaseResponse();

    @Override
    public List<StudentResponseDto> findAll() {
        log.info("findAll() method called from service layer...!!");
        return studentMapper.toStudentDtoList(studentRepository.findAll());
    }

    @Override
    public BaseResponse insert(StudentRequestDto studentRequestDto) {
        log.info("save() method called from service layer...!!");

        Student student = studentMapper.toStudentEntity(studentRequestDto);
        System.out.println("Student :: " + student.toString());
        studentRepository.insert(student);

        response.setMessage(StudentConstants.RECORD_SAVED_SUCCESSFULLY);

        return response;
    }
}
