package web.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmployeesDto {
    private int eno;
    private String ename;
    private String econtact;
    private String position;
    private int dno;
    private String dname;
}
