//添加自定义验证方法到jquery 验证插件中   addMethod：name, method, message

jQuery.validator.addMethod("isMobile", function(value, element) {  
    var length = value.length;  
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(16[0-9]{9})|(19[0-9]{9})|(15[0-9]{9})$/;  
    return this.optional(element) || (length == 11 && mobile.test(value));  
}, "请正确填写您的手机号码");  

jQuery.validator.addMethod("idcardno", function(value, element) {
    return this.optional(element) || isIdCardNo(value);
}, "请正确输入身份证号码");

jQuery.validator.addMethod("alnum", function(value, element) {
    return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
}, "只能包括英文字母和数字");

jQuery.validator.addMethod("zipcode", function(value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写邮政编码");

jQuery.validator.addMethod("chcharacter", function(value, element) {
    var tel = /^[u4e00-u9fa5]+$/;
    return this.optional(element) || (tel.test(value));
}, "请输入汉字");

jQuery.validator.addMethod("laterTo", function (value, element, param) {
    return $(param).val().split("-").join("") < $(element).val().split("-").join("");
}, "结束时间不能小于开始时间^_^");

jQuery.validator.addMethod("decimal", function (value, element) {
    return this.optional(element) || /^([1-9]\d{0,8}|0)(\.\d{1,6})?$/.test(value);
}, "小数点前最多9位，小数点后最多6位^_^");