console.log('department.js');

function dAdd(){
    console.log('eAdd()');
    // 1. 입력값 가져오기
    let dname = document.querySelector("#dname").value;
    let dcontact = document.querySelector("#dcontact").value;

    // 2. 객체 만들기
    let info = {
        dname : dname , dcontact : dcontact
    }

    // 3. ajax
    $.ajax({
        method : 'post' , 
        url : "/hrdsystem/department/dadd" , 
        data : info , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert("부서등록성공");
                dPrint();
            }else{
                alert("부서등록실패");
            }
        }   // success end
    });  // ajax end
}   // dAdd() end

dPrint();
function dPrint(){
    console.log('dPrint()');
    $.ajax({
        method : 'get' , 
        url : "/hrdsystem/department/dprint" , 
        success : (result) => {
            console.log(result);
            // 어디에
            let dBox = document.querySelector("#dBox");
            // 무엇을
            let html = ``;
            result.forEach(departmentDto => {
                html += `
                        <tr> 
                        <td> ${departmentDto.dno} </td> 
                        <td> ${departmentDto.dname} </td> 
                        <td> ${departmentDto.dcontact} </td>
                        <td> <button type="button" onclick="dUpdate(${departmentDto.dno})"> 수정 </button> </td>
                        <td> <button type="button" onclick="dDelete(${departmentDto.dno})"> 삭제 </button> </td>
                        </tr>
                `;
            });
            // 출력
            dBox.innerHTML = html;
        }   // success end
    });  // ajax end
}   // dPrint() end

function dUpdate(dno){
    console.log('dUpdate()');
    // 1. 입력값 가져오기
    let dname = prompt('새로운 부서명을 입력해주세요.');
    let dcontact = prompt('새로운 대표전화를 입력해주세요.');
    // 2. 객체 만들기
    let info = {
        dname : dname , dcontact : dcontact , dno : dno
    }
    // 3. ajax
    $.ajax({
        method : 'put' , 
        url : "/hrdsystem/department/dupdate" , 
        data : info , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert('수정성공');
                dPrint();
            }else{
                alert('수정실패');
            }
        }   // success end
    }); // ajax end
}   // dUpdate() end

function dDelete(dno){
    console.log('dDelete()');
    // 3. ajax
    $.ajax({
        method : 'delete' , 
        url : "/hrdsystem/department/ddelete" , 
        data : { "dno" : dno } , 
        success : (result) => {
            console.log(result);
            if(result==true){
                alert('삭제성공');
                dPrint();
            }else{
                alert('삭제실패');
            }
        }   // success end
    }); // ajax end
}   // dUpdate() end

