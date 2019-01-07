function judge(){
    var supId =  $("input[name='supId']");
    var supName = $("input[name='supName']");
    var supDescription = $("textarea[name='supDescription']");
    var supContact = $("input[name='supContact']");
    var supPhone = $("input[name='supPhone']");
    var supFax = $("input[name='supFax']");
    var supAddress = $("input[name='supAddress']");
    if(supId.val()==''||supName==''||supDescription==''||supContact==''||supPhone==''||supFax==''||supAddress==''){
        alert("表单信息不能为空");
        return false;
    }else{
        return true;
    }
}