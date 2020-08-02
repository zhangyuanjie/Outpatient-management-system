$(function() {
	$('.nav-tabs a').click(function(e) {
		e.preventDefault()
		$(this).tab('show')
	});
	
	$("#userBtn").click(function() {
		var typeVal = $('input:radio[name="inlineRadioOptions"]:checked').val();
		if (typeVal == null) {
			alert("请选择身份");
			return false;
		}
	});

    $("input[type='radio']").on("click",function () {
        if($("input[id='inlineRadio2']:checked").val()=="医生"){
            var path = "/hos/doctor/login";
            $("#loginForm").attr("action", path);
            $("#userAccount").attr("name", "doctorAccount");
            $("#userPwd").attr("name", "doctorPwd");
        }else if($("input[id='inlineRadio1']:checked").val()=="普通用户"){
            var path = "/hos/user/login";
            $("#loginForm").attr("action", path);
            $("#userAccount").attr("name", "userAccount");
            $("#userPwd").attr("name", "userPwd");
        }
    })
});