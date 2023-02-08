$(function(){
    // 1. press Delete btn
    $("#btnDel").click(function(){
        let answer = confirm("Are you sure you want to delete?")
        if(answer){
            $("form[name='frmDelete']").submit();
        }
    });

    // 현재 글의 id값
       const id = $("input[name='id']").val().trim();

       loadComment(id);
});

// 글 (write_id) 의 댓글 목록 읽어오기
function loadComment(write_id){
    $.ajax({
        url: conPath + "/comment/list?id=" + write_id,
        type: "GET",
        cache: false,
        success: function(data, status, xhr){
            if(status == "success"){
//                alert(xhr.responseText);  // response 결과 확인용

                // 서버쪽 에러 메세지 있는 경우
                if(data.status !== "OK"){
                    alert(data.status);
                    return;
                }

                buildComment(data);
            }
        },
    });
}

function buildComment(result){

}