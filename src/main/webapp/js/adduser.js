
    $(function(){
        $(".errorTips").hide();


            $("input[name='userId']").blur(function(){
                var userId = $("input[name='userId']");
                if(userId.val()==""){
                    $(".errorTips:first").show();
                }
                if(userId.val()!=''){
                    $(".errorTips:first").hide();
                }
            })
            $("input[name='username']").blur(function(){
                var username = $("input[name='username']");
                if(username.val()==""){
                    $(".errorTips").eq(1).show();
                }
                if(username.val()!=''){
                    $(".errorTips").eq(1).hide();
                }
            })
            $("input[name='password']").blur(function(){
                var password = $("input[name='password']");
                if(password.val()==""){
                    $(".errorTips").eq(2).show();
                }
                if([password].val()!=''){
                    $(".errorTips").eq(2).hide();
                }
            })
            $("input[name='checkpwd']").blur(function(){
                var checkpwd = $("input[name='checkpwd']");
                if(checkpwd.val()==""){
                    $(".errorTips").eq(3).show();
                }
                if(checkpwd.val()!=''){
                    $(".errorTips").eq(3).hide();
                }
                var password = $("input[name='password']").val();
                if(password!=checkpwd.val()){
                    $(".errorTips").eq(3).show();
                }
            })
            $("input[name='age']").blur(function(){
                var age = $("input[name='age']");
                if(age.val()==""){
                    $(".errorTips").eq(4).show();
                }
                if(age.val()!=''){
                    $(".errorTips").eq(4).hide();
                }
            })
            $("input[name='userPhone']").blur(function(){
                var userPhone = $("input[name='userPhone']");
                if(userPhone.val()==""){
                    $(".errorTips").eq(5).show();
                }
                if(userPhone.val()!=''){
                    $(".errorTips").eq(5).hide();
                }
            })
            $("textarea[name='userAddress']").blur(function(){
                var userAddress = $("textarea[name='userAddress']");
                console.info(userAddress.val());
                if(userAddress.val()==''){
                    $(".errorTips").eq(6).show();
                }
                if(userAddress.val()!=''){
                    $(".errorTips").eq(6).hide();
                }
            })

    })