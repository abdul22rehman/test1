package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.Employee;
import com.pankaj.pr2.payload.Employeedto;
import com.pankaj.pr2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class Employeecontroller {

    private EmployeeService employeeService;

    public Employeecontroller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")

public ResponseEntity<?>createEmployee(@Valid @RequestBody Employeedto dto,BindingResult result ){
      if (result.hasErrors()){
          return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
        Employeedto employeedto = employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeedto,HttpStatus.CREATED);
    }
@PutMapping
    public ResponseEntity<Employeedto>updateEmployee(@RequestParam Long id,@RequestBody Employeedto dto){
        Employeedto employeedto = employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>(employeedto,HttpStatus.OK);
    }
    @GetMapping
//    public  ResponseEntity <List<Employeedto>> GetEmployee( ){
//
//        List<Employeedto> employeesdto= employeeService.GetEmployee();
//        return new ResponseEntity<>(employeesdto,HttpStatus.OK);
//    }

//    public ResponseEntity<List<Employeedto>> getEmployees(){
//        List<Employeedto> employeedtos = employeeService.GetEmployee();
//        return new ResponseEntity<>(employeedtos,HttpStatus.OK);
//    }


//    public ResponseEntity<List<Employeedto>> getEmployees(){
//        List<Employeedto> employeedtos = employeeService.GetEmployee();
//        return new ResponseEntity<>(employeedtos,HttpStatus.OK);
//    }

//    public ResponseEntity<List<Employeedto>> getEmployees(){
//        List<Employeedto> employeedtos = employeeService.GetEmployee();
//        return new ResponseEntity<>(employeedtos,HttpStatus.OK);
//    }


public ResponseEntity<List<Employeedto>>getEmployee(
        @RequestParam(name="pageno",required = false,defaultValue = "0")int pageno,
        @RequestParam(name="pagesize",required = false,defaultValue = "3")int pagesize,
        @RequestParam(name="sortby",required = false,defaultValue = "name")String sortby,
        @RequestParam(name="sortdir",required = false,defaultValue = "asc")String sortdir
                                                   ) {

        // Sanitize the sortBy input
sortby=sortby!=null?sortby.trim():"name";


        List<Employeedto> employeedtos = employeeService.GetEmployee(pageno,pagesize,sortby,sortdir);


        return new ResponseEntity<>(employeedtos,HttpStatus.OK);
    }
@GetMapping("/employeeId/{empId}")
public ResponseEntity<Employeedto>getemployeebyid(@PathVariable Long empId){
    Employeedto employeedto = employeeService.getemployeebyId(empId);
    return new ResponseEntity<>(employeedto,HttpStatus.OK);

}












    @DeleteMapping
    public String DeleteEmployee(@RequestParam Long id){
        employeeService.deleteEmployee(id);
        return "Deleted";

    }












}
