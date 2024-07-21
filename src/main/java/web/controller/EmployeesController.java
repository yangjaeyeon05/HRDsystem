package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.EmployeesDto;
import web.service.EmployeesService;

import java.util.ArrayList;

@RestController
@RequestMapping("/hrdsystem/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;

    // 1. 사원 등록
    @PostMapping("/eadd")
    public boolean eAdd(EmployeesDto employeesDto){
        return employeesService.eAdd(employeesDto);
    }   // eAdd() end

    // 2. 사원 출력
    @GetMapping("/eprint")
    public ArrayList<EmployeesDto> ePrint(){
        return employeesService.ePrint();
    }   // ePrint() end

    // 3. 사원 수정 (이름 연락처 직급)
    @PutMapping("/eupdate")
    public boolean eUpdate(EmployeesDto employeesDto){
        return employeesService.eUpdate(employeesDto);
    }   // eUpdate() end

    // 4. 사원 삭제
    @DeleteMapping("/edelete")
    public boolean eDelete(EmployeesDto employeesDto){
        return employeesService.eDelete(employeesDto);
    }   // eDelete() end

}   // class end
