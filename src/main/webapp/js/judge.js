$(function(){
    $(".errorTips").hide();
    var supId =  $("input[name='supId']");
    var supName = $("input[name='supName']");
    var supDescription = $("textarea[name='supDescription']");
    var supContact = $("input[name='supContact']");
    var supPhone = $("input[name='supPhone']");
    var supFax = $("input[name='supFax']");
    var supAddress = $("input[name='supAddress']");
    $("input[name='supId']").blur(function(){
        if(supId.val()==''){
            $(".errorTips").eq(0).show();
        }
    });
    $("input[name='supId']").focus(function(){
        $(".errorTips").eq(0).hide();
    });

    $("input[name='supName']").blur(function(){
        if(supName.val()==''){
            $(".errorTips").eq(1).show();
        }
    });
    $("input[name='supName']").focus(function(){
        $(".errorTips").eq(1).hide();
    });

    $("textarea[name='supDescription']").blur(function(){
        if(supDescription.val()==''){
            $(".errorTips").eq(2).show();
        }
    });
    $("textarea[name='supDescription']").focus(function(){
        $(".errorTips").eq(2).hide();
    });

    $("input[name='supContact']").blur(function(){
        if(supContact.val()==''){
            $(".errorTips").eq(3).show();
        }
    });
    $("input[name='supContact']").focus(function(){
        $(".errorTips").eq(3).hide();
    });

    $("input[name='supPhone']").blur(function(){
        if(supPhone.val()==''){
            $(".errorTips").eq(4).show();
        }
    });
    $("input[name='supPhone']").focus(function(){
        $(".errorTips").eq(4).hide();
    });

    $("input[name='supFax']").blur(function(){
        if(supFax.val()==''){
            $(".errorTips").eq(5).show();
        }
    });
    $("input[name='supFax']").focus(function(){
        $(".errorTips").eq(5).hide();
    });

    $("input[name='supAddress']").blur(function(){
        if(supAddress.val()==''){
            $(".errorTips").eq(6).show();
        }
    });
    $("input[supAddress='supFax']").focus(function(){
        $(".errorTips").eq(6).hide();
    });
})
