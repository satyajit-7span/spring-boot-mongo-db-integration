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
    public BaseResponse findByEmail(String email) {
        log.info("findByEmail() method called from service layer...!!");

        StudentResponseDto responseDTO = studentMapper.toStudentResponseDto(studentRepository.findByEmail(email));

        if(responseDTO == null) {
            response.setMessage(StudentConstants.RECORD_NOT_FOUND);
        } else {
            response.setMessage(null);
            response.setStudent(responseDTO);
        }

        return response;
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

    @Override
    public BaseResponse deleteByEmail(String email) {
        log.info("deleteByEmail() called from service layer...!!");

        Student student = studentRepository.findByEmail(email);

        if(student != null) {
            studentRepository.deleteByEmail(email);
            response.setMessage(StudentConstants.RECORD_DELETED_SUCCESSFULLY);
        } else {
            response.setMessage(StudentConstants.RECORD_NOT_FOUND);
        }

        return response;
    }

    @Override
    public BaseResponse update(String id, StudentRequestDto studentRequestDto) {
        log.info("update() method called from service layer...!!");

        Student student = studentMapper.toStudentEntity(studentRequestDto);
        Student student1 = studentRepository.findById(id).get();

        StudentResponseDto responseDto = new StudentResponseDto();

        if(studentRequestDto.getName() != null) {
            student1.setName(studentRequestDto.getName());
        }

        if(studentRequestDto.getEmail() != null) {
            student1.setEmail(studentRequestDto.getEmail());
        }

        studentRepository.save(student1);
        response.setMessage(StudentConstants.RECORD_UPDATED_SUCCESSFULLY);

        return response;
    }
}
