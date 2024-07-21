package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 1. 메인페이지
    @GetMapping("/")
    public String index(){
        return "/index.html";
    }
    // 2. 부서관리페이지
    @GetMapping("/hrdsystem/department")
    public String department(){
        return "/hrdsystem/department.html";
    }
    // 3. 사원관리페이지
    @GetMapping("/hrdsystem/employees")
    public String employees(){
        return "/hrdsystem/employees.html";
    }

}
