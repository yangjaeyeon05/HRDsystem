console.log('employees.js');

function eAdd(){
    console.log('eAdd()');
    // 1. 입력값 가져오기
    let ename = document.querySelector("#ename").value;
    let econtact = document.querySelector("#econtact").value;
    let position = document.querySelector("#position").value;
    let dname = document.querySelector("#dname").value;

    // 2. 객체 만들기
    let info = {
        ename : ename , econtact : econtact , position : position , dname : dname
    }

    // 3. ajax
    $.ajax({
        method : 'post' , 
        url : "/hrdsystem/employees/eadd" , 
        data : info , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert("사원등록성공");
                ePrint();
            }else{
                alert("사원등록실패");
            }
        }   // success end
    });  // ajax end
}   // eAdd() end

ePrint();
function ePrint(){
    console.log('ePrint()');
    $.ajax({
        method : 'get' , 
        url : "/hrdsystem/employees/eprint" , 
        success : (result) => {
            console.log(result);
            // 어디에
            let eBox = document.querySelector("#eBox");
            // 무엇을
            let html = ``;
            result.forEach(employeesDto => {
                html += `
                        <tr> 
                        <td> ${employeesDto.eno} </td> 
                        <td> ${employeesDto.ename} </td> 
                        <td> ${employeesDto.econtact} </td>
                        <td> ${employeesDto.position} </td>
                        <td> ${employeesDto.dname} </td>
                        <td> <button type="button" onclick="eUpdate(${employeesDto.eno})"> 수정 </button> </td>
                        <td> <button type="button" onclick="eDelete(${employeesDto.eno})"> 삭제 </button> </td>
                        </tr>
                `;
            });
            // 출력
            eBox.innerHTML = html;
        }   // success end
    });  // ajax end
}   // ePrint() end

function eUpdate(eno){
    console.log('eUpdate()');
    // 1. 입력값 가져오기
    let ename = prompt('새로운 사원명 입력해주세요.');
    let econtact = prompt('새로운 연락처를 입력해주세요.');
    let position = prompt('새로운 직급을 입력해주세요.');

    // 2. 객체 만들기
    let info = {
        ename : ename , econtact : econtact , position : position , eno : eno
    }
    // 3. ajax
    $.ajax({
        method : 'put' , 
        url : "/hrdsystem/employees/eupdate" , 
        data : info , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert('수정성공');
                ePrint();
            }else{
                alert('수정실패');
            }
        }   // success end
    }); // ajax end
}   // eUpdate() end

function eDelete(eno){
    console.log('eDelete()');
    // 3. ajax
    $.ajax({
        method : 'delete' , 
        url : "/hrdsystem/employees/edelete" , 
        data : { "eno" : eno } , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert('삭제성공');
                ePrint();
            }else{
                alert('삭제실패');
            }
        }   // success end
    }); // ajax end
}   // eUpdate() end

