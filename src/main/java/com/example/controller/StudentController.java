package com.example.controller;

import com.example.dto.request.StudentRequestDto;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.StudentResponseList;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public StudentResponseList findAll() {
        log.info("findAll() method called from controller layer...!!");

        StudentResponseList responseList = new StudentResponseList();
        responseList.setStudents(studentService.findAll());

        return responseList;
    }

    @GetMapping("/{email}")
    public ResponseEntity<BaseResponse> findByEmail(@PathVariable String email) {
        log.info("findByEmail() method called from controller layer...!!");
        BaseResponse baseResponse = studentService.findByEmail(email);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        log.info("save() method called from controller layer...!!");
        BaseResponse baseResponse = studentService.insert(studentRequestDto);

        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<BaseResponse> deleteByEmail(@PathVariable String email) {
        log.info("deleteByEmail() method called from controller layer...!!");
        BaseResponse baseResponse = studentService.deleteByEmail(email);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable String id, @Valid @RequestBody StudentRequestDto RequestDTO) {
        log.info("update() method called from controller layer...!!");

        BaseResponse baseResponse = studentService.update(id, RequestDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
