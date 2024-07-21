package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.DepartmentDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class DepartmentDao extends Dao{
    // 1. 부서등록
    public boolean dAdd(DepartmentDto departmentDto){
        try{
            String sql = "insert into department (dname , dcontact) values ( ? , ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,departmentDto.getDname());
            ps.setString(2,departmentDto.getDcontact());
            int count = ps.executeUpdate();
            if(count ==1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // dAdd() end

    // 2. 부서 전체 출력
    public ArrayList<DepartmentDto> dPrint(){
        ArrayList<DepartmentDto> list = new ArrayList<>();
        try{
            String sql = "select * from department";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DepartmentDto departmentDto = DepartmentDto.builder()
                        .dno(rs.getInt("dno"))
                        .dname(rs.getString("dname"))
                        .dcontact(rs.getString("dcontact"))
                        .build();
                list.add(departmentDto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }   // dPrint() end

    // 3. 부서 수정(이름 , 대표전화)
    public boolean dUpdate(DepartmentDto departmentDto){
        try{
            String sql = "update department set dname = ? , dcontact = ? where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,departmentDto.getDname());
            ps.setString(2,departmentDto.getDcontact());
            ps.setInt(3,departmentDto.getDno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // dUpdate() end

    // 4. 부서 삭제
    public boolean dDelete(DepartmentDto departmentDto){
        try{
            String sql = "delete from department where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,departmentDto.getDno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }   // dDelete() end

}   // class end
