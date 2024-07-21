package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.DepartmentDao;
import web.model.dto.DepartmentDto;

import java.util.ArrayList;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    // 1. 부서등록
    public boolean dAdd(DepartmentDto departmentDto){
        return departmentDao.dAdd(departmentDto);
    }   // dAdd() end

    // 2. 부서 전체 출력
    public ArrayList<DepartmentDto> dPrint(){
        return departmentDao.dPrint();
    }   // dPrint() end

    // 3. 부서 수정(이름 , 대표전화)
    public boolean dUpdate(DepartmentDto departmentDto){
        return departmentDao.dUpdate(departmentDto);
    }   // dUpdate() end

    // 4. 부서 삭제
    public boolean dDelete(DepartmentDto departmentDto){
        return departmentDao.dDelete(departmentDto);
    }   // dDelete() end

}   // class end
