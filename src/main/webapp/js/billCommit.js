$(function(){
    $(".errorTips").hide();
    var billId = $("input[name='billId']");
    var dealPrice = $("input[name='dealPrice']");
    var dealUnit = $("input[name='dealUnit']");
    var productAmount = $("input[name='productAmount']");
    var productName = $("input[name='productName']");
    var productDescription = $("textarea[name='productDescription']");
    $("input[name='billId']").blur(function(){
        if(billId.val()==''){
            $(".errorTips").eq(0).show();
        }
    });
    $("input[name='billId']").focus(function(){
        $(".errorTips").eq(0).hide();
    });

    $("input[name='dealPrice']").blur(function(){
        if(dealPrice.val()==''){
            $(".errorTips").eq(1).show();
        }
    });
    $("input[name='dealPrice']").focus(function(){
        $(".errorTips").eq(1).hide();
    });

    $("input[name='dealUnit']").blur(function(){
        if(dealUnit.val()==''){
            $(".errorTips").eq(2).show();
        }
    });
    $("input[name='dealUnit']").focus(function(){
        $(".errorTips").eq(2).hide();
    });

    $("input[name='productAmount']").blur(function(){
        if(productAmount.val()==''){
            $(".errorTips").eq(3).show();
        }
    });
    $("input[name='productAmount']").focus(function(){
        $(".errorTips").eq(3).hide();
    });

    $("input[name='productName']").blur(function(){
        if(productName.val()==''){
            $(".errorTips").eq(4).show();
        }
    });
    $("input[name='productName']").focus(function(){
        $(".errorTips").eq(4).hide();
    });

    $("textarea[name='productDescription']").blur(function(){
        if(productDescription.val()==''){
            $(".errorTips").eq(5).show();
        }
    });
    $("textarea[name='productDescription']").focus(function(){
        $(".errorTips").eq(5).hide();
    });
})
function commitBill(){
    var billId = $("input[name='billId']");
    var dealPrice = $("input[name='dealPrice']");
    var dealUnit = $("input[name='dealUnit']");
    var productAmount = $("input[name='productAmount']");
    var productName = $("input[name='productName']");
    var productDescription = $("textarea[name='productDescription']");
    if (billId.val()==''||dealPrice.val()==''||dealUnit.val()==''||productAmount.val()==''||productName.val()==''||productDescription.val()=='') {
        return false;
    } else{
        return true;
    }
}