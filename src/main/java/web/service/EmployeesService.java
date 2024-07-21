package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.EmployeesDao;
import web.model.dto.EmployeesDto;

import java.util.ArrayList;

@Service
public class EmployeesService {
    @Autowired
    EmployeesDao employeesDao;

    // 1. 사원 등록
    public boolean eAdd(EmployeesDto employeesDto){
        return employeesDao.eAdd(employeesDto);
    }   // eAdd() end

    // 2. 사원 출력
    public ArrayList<EmployeesDto> ePrint(){
        return employeesDao.ePrint();
    }   // ePrint() end

    // 3. 사원 수정 (이름 연락처 직급)
    public boolean eUpdate(EmployeesDto employeesDto){
        return employeesDao.eUpdate(employeesDto);
    }   // eUpdate() end

    // 4. 사원 삭제
    public boolean eDelete(EmployeesDto employeesDto){
        return employeesDao.eDelete(employeesDto);
    }   // eDelete() end

}   // class end
