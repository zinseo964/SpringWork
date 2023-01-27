$(function(){
    // TODO
    // 1. press Delete btn
    $("#btnDel").click(function(){
        let answer = confirm("Are you sure you want to delete?")
        if(answer){
            $("form[name='frmDelete']").submit();
        }
    });
});