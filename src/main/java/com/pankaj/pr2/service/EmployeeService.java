package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.Employee;
import com.pankaj.pr2.exception.ResourceNotFound;
import com.pankaj.pr2.payload.Employeedto;
import com.pankaj.pr2.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

//public Employeedto addEmployee(Employeedto dto){
//    Employee employee = maptoEntity(dto);
//    Employee emp = employeeRepository.save(employee);
//    Employeedto employeedto = maptodto(emp);
//    return employeedto;
//}

public Employeedto addEmployee(Employeedto dto){
    Employee employee = maptoEntity(dto);
    Employee emp = employeeRepository.save(employee);
    Employeedto employeedto = maptodto(emp);
    return employeedto;
}

    public Employeedto updateEmployee(Long id,Employeedto dto) {
        Employee employee = maptoEntity(dto);
        employee.setId(id);
        Employee emp = employeeRepository.save(employee);
        Employeedto employeedto = maptodto(emp);
        return employeedto;


    }







  private Employeedto maptodto(Employee employee){
//        Employeedto dto=new Employeedto();
//        dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        dto.setEmailid(employee.getEmailid());
//        dto.setMobile(employee.getMobile());

      Employeedto dto = modelMapper.map(employee, Employeedto.class);
      return dto;
  }

  private Employee maptoEntity(Employeedto dto){
//        Employee employee=new Employee();
//        employee.setId(dto.getId());
//        employee.setName(dto.getName());
//        employee.setEmailid(dto.getEmailid());
//        employee.setMobile(dto.getMobile());
      Employee employee = modelMapper.map(dto, Employee.class);
      return employee;




  }

public List<Employeedto>GetEmployee(int pageno, int pagesize, String sortby, String sortdir){
    Sort sort = sortdir.equalsIgnoreCase("asc") ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();
    Pageable page = PageRequest.of(pageno, pagesize, sort);

    Page<Employee> all = employeeRepository.findAll(page);
    List<Employee> emp = all.getContent();


    List<Employeedto> dto  =  emp.stream().map(x -> maptodto(x)).collect(Collectors.toList());
    return dto;
}

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    public Employeedto getemployeebyId(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFound("record not found with id "+empId));

        return maptodto(employee);
    }
}
