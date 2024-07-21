package web.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DepartmentDto {
    private int dno;
    private String dname;
    private String dcontact;
}
