package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.DepartmentDto;
import web.service.DepartmentService;

import java.util.ArrayList;

@RestController
@RequestMapping("/hrdsystem/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    // 1. 부서등록
    @PostMapping("/dadd")
    public boolean dAdd(DepartmentDto departmentDto){
        return departmentService.dAdd(departmentDto);
    }   // dAdd() end

    // 2. 부서 전체 출력
    @GetMapping("/dprint")
    public ArrayList<DepartmentDto> dPrint(){
        return departmentService.dPrint();
    }   // dPrint() end

    // 3. 부서 수정(이름 , 대표전화)
    @PutMapping("/dupdate")
    public boolean dUpdate(DepartmentDto departmentDto){
        return departmentService.dUpdate(departmentDto);
    }   // dUpdate() end

    // 4. 부서 삭제
    @DeleteMapping("/ddelete")
    public boolean dDelete(DepartmentDto departmentDto){
        return departmentService.dDelete(departmentDto);
    }   // dDelete() end

}   // class end
