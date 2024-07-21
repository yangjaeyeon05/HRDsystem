package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.EmployeesDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class EmployeesDao extends Dao{

    // 1. 사원 등록
    public boolean eAdd(EmployeesDto employeesDto){
        try{
            String sql = "insert into employees(ename , econtact , position , dno) values(? , ? , ? , (select dno from department where dname = ?))";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,employeesDto.getEname());
            ps.setString(2,employeesDto.getEcontact());
            ps.setString(3,employeesDto.getPosition());
            ps.setString(4,employeesDto.getDname());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // eAdd() end

    // 2. 사원 출력
    public ArrayList<EmployeesDto> ePrint(){
        ArrayList<EmployeesDto> list = new ArrayList<>();
        try{
            String sql = "select * from employees inner join department on employees.dno = department.dno";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                EmployeesDto employeesDto = EmployeesDto.builder()
                        .eno(rs.getInt("eno"))
                        .ename(rs.getString("ename"))
                        .econtact(rs.getString("econtact"))
                        .position(rs.getString("position"))
                        .dname(rs.getString("dname"))
                        .build();
                list.add(employeesDto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }   // ePrint() end

    // 3. 사원 수정 (이름 연락처 직급)
    public boolean eUpdate(EmployeesDto employeesDto){
        try{
            String sql = "update employees set ename = ? , econtact = ? , position = ? where eno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,employeesDto.getEname());
            ps.setString(2,employeesDto.getEcontact());
            ps.setString(3,employeesDto.getPosition());
            ps.setInt(4,employeesDto.getEno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // eUpdate() end

    // 4. 사원 삭제
    public boolean eDelete(EmployeesDto employeesDto){
        try {
            String sql = "delete from employees where eno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,employeesDto.getEno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // eDelete() end

}   // class end
