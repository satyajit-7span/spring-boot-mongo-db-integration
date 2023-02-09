package com.example.mapper;

import com.example.dto.request.StudentRequestDto;
import com.example.dto.response.StudentResponseDto;
import com.example.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDto toStudentResponseDto(Student student);

    //StudentResponseDto toStudentRequestDto(Student student);

    Student toStudentEntity(StudentRequestDto studentRequestDto);

    List<StudentResponseDto> toStudentDtoList(List<Student> studentList);
}
