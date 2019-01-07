(function($){
    $(window).load(function(){

        $("a[rel='load-content']").click(function(e){
            e.preventDefault();
            var url=$(this).attr("href");
            $.get(url,function(data){
                $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                //scroll-to appended content
                $(".content").mCustomScrollbar("scrollTo","h2:last");
            });
        });

        $(".content").delegate("a[href='top']","click",function(e){
            e.preventDefault();
            $(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
        });

    });
})(jQuery);
//防止控表单提交
function func(){
    var id = $("input[name='id']").val();
    var username = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    var checkpwd = $("input[name='checkpwd']").val();
    var age = $("input[name='age']").val();
    var userPhone = $("input[name='userPhone']").val();
    var userAddress = $("textarea[name='userAddress']").val();
    if(id==''||username==''||password==''||checkpwd==''||age==''||userPhone==''||userAddress==''){
        alert("信息不能为空");
        return false;
    }else{
        return true;
    }
}