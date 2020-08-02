/**
 * 更新iframe高度
 */
function IFrameResize(){
    $('#urlIframe', window.parent.document).css('height',this.document.body.scrollHeight);//弹出当前页面的高度
};
/**
 * 获取当前时间
 */
function getCurrentTime() {
    var t = new Date(); //获取当前时间
    var year = t.getFullYear(); //获取当前时间年份
    var year2 = year%100; // 去年份的后倆位
    var month = t.getMonth()+1; //获取当前时间月份
    var day = t.getDate(); //获取当前时间日
    //下3行分别获得当前时间的时 分 秒
    var hour = t.getHours();
    var minute = t.getMinutes();
    var second = t.getSeconds();
    var currentTime = ((year2 < 10) ? "0" : "") + year2 + ((month < 10) ? "0" : "") + month + ((day < 10) ? "0" : "") + day +
        ((hour < 10) ? "0" : "") + hour + ((minute < 10) ? "0" : "") + minute + ((second < 10) ? "0" : "") + second;
    return currentTime;
}
/**
 * 获取当前时间
 */
function getNowTime() {
    var t = new Date(); //获取当前时间
    var year = t.getFullYear(); //获取当前时间年份
    var month = t.getMonth()+1; //获取当前时间月份
    var day = t.getDate(); //获取当前时间日
    //下3行分别获得当前时间的时 分 秒
    var hour = t.getHours();
    var minute = t.getMinutes();
    var second = t.getSeconds();
    var currentTime = year + ((month < 10) ? "-0" : "-") + month + ((day < 10) ? "-0" : "-") + day +
        ((hour < 10) ? " 0" : " ") + hour + ((minute < 10) ? ":0" : ":") + minute + ((second < 10) ? ":0" : ":") + second;
    return currentTime;
}
function getCurrentDate() {
    var t = new Date(); //获取当前时间
    var year = t.getFullYear(); //获取当前时间年份
    var month = t.getMonth()+1; //获取当前时间月份
    var day = t.getDate(); //获取当前时间日
    //下3行分别获得当前时间的时 分 秒
    var hour = t.getHours();
    var minute = t.getMinutes();
    var second = t.getSeconds();
    var currentData = year + ((month < 10) ? "0" : "") + month + ((day < 10) ? "0" : "") + day;
    return currentData;
}
/*
 * 手机号正则表达式
 */
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}
/*
 * 邮箱正则表达式
 */
function isEmailNo(email) {
    var pattern = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    return pattern.test(email);
}

/**
 * 账号正则表达式，账号必须大于6位
 */
function isAccountNo(account){
    var pattern = /^[a-zA-Z0-9]{6,30}$/;
    return pattern.test(account);
}
/**
 *  数字正则表达式
 */
function isNum(num) {
    var pattern = /^[0-9]+.?[0-9]*$/;
    return pattern.test(num);
}
/*
 * QQ正则表达式
 */
// function isQqNo(qq) {
//     var pattern = /[1-9][0-9]{4,14}/;
//     return pattern.test(qq);
// }
function isAccount(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).next().html("（该字段不能为空）");
        $(obj).next().show();
        IFrameResize();
        return false;
    }else {
        if (isAccountNo($(obj).val()) == false) {
            $(obj).parent().addClass("has-error");
            $(obj).next().html("（长度至少为6位）");
            $(obj).next().show();
            IFrameResize();
            return false;
        } else {
            $(obj).parent().removeClass("has-error");
            $(obj).next().hide();
            IFrameResize();
            return true;
        }
    }
}
function isVCodeNull(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        return false;
    } else {
        $(obj).parent().removeClass("has-error");
        return true;
    }
}
function isNull(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).prev().find("small").html("（该字段不能为空）");
        $(obj).prev().find("small").show();
        IFrameResize();
        return false;
    } else {
        $(obj).parent().removeClass("has-error");
        $(obj).prev().find("small").hide();
        IFrameResize();
        return true;
    }
}

/**
 * 验证数字
 */
function checkNum(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).prev().find("small").html("(请输入数字)");
        $(obj).prev().find("small").show();
        IFrameResize();
        return false;
    }else {
        if (isNum($(obj).val()) == false) {
            $(obj).parent().addClass("has-error");
            $(obj).prev().find("small").html("(数据格式不是数字格式)");
            $(obj).prev().find("small").show();
            IFrameResize();
            return false;
        } else {
            $(obj).parent().removeClass("has-error");
            $(obj).prev().find("small").hide();
            IFrameResize();
            return true;
        }
    }
}

/*
 * 验证手机号
 */
function checkPhone(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).prev().find("small").html("(请输入电话号码)");
        $(obj).prev().find("small").show();
        IFrameResize();
        return false;
    } else {
        if (isPhoneNo($(obj).val()) == false) {
            $(obj).parent().addClass("has-error");
            $(obj).prev().find("small").html("(手机号码格式不正确)");
            $(obj).prev().find("small").show();
            IFrameResize();
            return false;
        } else {
            $(obj).parent().removeClass("has-error");
            $(obj).prev().find("small").hide();
            IFrameResize();
            return true;
        }
    }
}
/**
 * 用于检测表单中的input是否为空
 * @param obj
 * @returns {boolean}
 */
function isNullForm(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).next().html("（该字段不能为空）");
        $(obj).next().show();
        IFrameResize();
        return false;
    } else {
        $(obj).parent().removeClass("has-error");
        $(obj).next().hide();
        IFrameResize();
        return true;
    }
}
/*
 * 用于验证表单里的手机号
 */
function checkPhoneForm(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).next().html("(请输入电话号码)");
        $(obj).next().show();
        IFrameResize();
        return false;
    } else {
        if (isPhoneNo($(obj).val()) == false) {
            $(obj).parent().addClass("has-error");
            $(obj).next().html("(手机号码格式不正确)");
            $(obj).next().show();
            IFrameResize();
            return false;
        } else {
            $(obj).parent().removeClass("has-error");
            $(obj).next().hide();
            IFrameResize();
            return true;
        }
    }
}
/*
 * 验证邮箱
 */
function checkEmailForm(obj) {
    if ($.trim($(obj).val()).length == 0) {
        $(obj).parent().addClass("has-error");
        $(obj).next().html("(请输入邮箱)");
        $(obj).next().show();
        IFrameResize();
        return false;
    } else {
        if (isEmailNo($(obj).val()) == false) {
            $(obj).parent().addClass("has-error");
            $(obj).next().html("(邮箱格式不正确)");
            $(obj).next().show();
            IFrameResize();
            return false;
        } else {
            $(obj).parent().removeClass("has-error");
            $(obj).next().hide();
            IFrameResize();
            return true;
        }
    }
}
/*
 * 验证密码
 */
function checkOldPwd(){
    if($.trim($("#oldPwd").val()).length == 0) {
        $("#oldPwdError").html("（请输入密码）");
        $("#oldPwdDiv").addClass("has-error");
        $("#oldPwdError").show();
        IFrameResize();
        return false;
    }else{
        $("#oldPwdDiv").removeClass("has-error");
        $("#oldPwdError").hide();
        IFrameResize();
        return true;
    }
}

function checkNewPwd(){
    if($.trim($("#newPwd").val()).length == 0) {
        $("#newPwdError").html("（请输入新的密码）");
        $("#newPwdDiv").addClass("has-error");
        $("#newPwdError").show();
        IFrameResize();
        return false;
    }else{
        $("#newPwdDiv").removeClass("has-error");
        $("#newPwdError").hide();
        IFrameResize();
        return true;
    }
}

function checkNewPwdAgain(){
    if($.trim($("#newPwdAgain").val()).length == 0) {
        $("#newPwdAgainError").html("（请再一次输入新的密码）");
        $("#newPwdAgainDiv").addClass("has-error");
        $("#newPwdAgainError").show();
        IFrameResize();
        return false;
    }else{
        if ($.trim($("#newPwd").val()).length != 0){
            if($("#newPwd").val()!=$("#newPwdAgain").val()){
                $("#newPwdAgainDiv").addClass("has-error");
                $("#newPwdAgainError").html("（俩次输入密码不一致）");
                $("#newPwdAgainError").show();
                IFrameResize();
                return false;
            }else{
                $("#newPwdAgainDiv").removeClass("has-error");
                $("#newPwdAgainError").hide();
                IFrameResize();
                return true;
            }
        }
        $("#newPwdAgainDiv").removeClass("has-error");
        $("#newPwdAgainError").hide();
        IFrameResize();
        return true;
    }
}

// function checkPassword() {
//     if ($.trim($('#password').val()).length == 0) {
//         $('#passwordError').html('密码没有输入');
//         $('#password').focus();
//         return false;
//     } else {
//         $('#passwordError').html('');
//         var rePass = $.trim($('#rePassword').val());
//         var pass = $.trim($('#password').val());
//         if (rePass.length != 0) {
//             if (rePass != pass) {
//                 $('#rePasswordError').html('两次密码不一致');
//                 return false;
//             } else {
//                 $('#rePasswordError').html('');
//                 return true;
//             }
//         }
//     }
// }
// /*
//  * 重复密码
//  */
// function checkrePassword() {
//     var rePass = $.trim($('#rePassword').val());
//     if (rePass.length == 0) {
//         $('#rePasswordError').html('密码没有输入');
//         $('#rePassword').focus();
//         return false;
//     } else {
//         $('#rePasswordError').html('');
//         var pass = $.trim($('#password').val());
//         if (pass.length == 0) {
//             $('#rePassword').val('');
//             $('#passwordError').html('密码没有输入');
//             $('#password').focus();
//             return false;
//         } else if (rePass != pass) {
//             $('#rePasswordError').html('两次密码不一致');
//             return false;
//         } else {
//             $('#rePasswordError').html('');
//             return true;
//         }
//     }
// }
// /*
//  * 验证联系人
//  */
// function checkName() {
//     if ($.trim($('#name').val()).length == 0) {
//         $('#nameError').html('联系人没有输入');
//         $('#name').focus();
//         return false;
//     } else {
//         $('#nameError').html('');
//         return true;
//     }
// }
// /*
//  * 验证邮箱
//  */
// function checkEmail() {
//     if ($.trim($('#email').val()).length == 0) {
//         $('#emailError').html('邮箱没有输入');
//         $('#email').focus();
//         return false;
//     } else {
//         $('#emailError').html('');
//         if (isEmailNo($('#email').val()) == false) {
//             $('#emailError').html('邮箱格式不正确');
//             $('#email').focus();
//             return false;
//         } else {
//             $('#emailError').html('');
//             return true;
//         }
//     }
// }
/*
 * 验证QQ
 */
// function checkQQ() {
//     if ($.trim($('#qq').val()).length == 0) {
//         $('#qqError').html('QQ没有输入');
//         $('#qq').focus();
//         return false;
//     } else {
//         $('#qqError').html('');
//         if (isQqNo($('#qq').val()) == false) {
//             $('#qqError').html('QQ格式不正确');
//             $('#qq').focus();
//             return false;
//         } else {
//             $('#qqError').html('');
//             return true;
//         }
//     }
// }
/*
 * 注册表单提交时验证
 */
// function checkRegister() {
//     if (checkPhone() == false) {
//         return false;
//     }
//     if (checkPassword() == false) {
//         return false;
//     }
//     if (checkrePassword() == false) {
//         return false;
//     }
//     if (checkName() == false) {
//         return false;
//     }
//     if (checkEmail() == false) {
//         return false;
//     }
//     if (checkQQ() == false) {
//         return false;
//     }
// }
