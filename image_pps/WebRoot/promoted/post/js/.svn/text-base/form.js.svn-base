(function ( $ ) {
jQuery(document).ready(function() {




/*$('.checkfPassword').pwstrength({
	 ui: {
		container: ".pwdContainer",
		showVerdictsInsideProgressBar: true,
		viewports: {
		progress: ".pwstrength_viewport_progress"
		}	
	 }
});*/


$(".postForm").validate({
	//onfocusout: false,
	rules: {
		formName: "required",
		formPassword:{
			required: true,
			minlength: 5
		},
		formPassword2:{
			required: true,
			minlength: 5
		},
		formEmail: {
			required: true,
			email: true
		},
		formTel:{
			number:true
		}
	},
	ignore:".ignore",
	messages: {
		formName: "请输入用户名",
		formPassword:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formPassword2:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formEmail:  {
			required: "请输入邮箱",
			email: "邮箱格式有误，请重新输入。"
		},
		formTel: "请输入数字",
	},
	
	validClass: "has-success",
	errorClass: "has-error"
				
}); 
 

$(".postForm2").validate({
	//onfocusout: false,
	rules: {
		formName: "required",
		formPassword:{
			required: true,
			minlength: 5
		},
		formPassword2:{
			required: true,
			minlength: 5
		},
		formEmail: {
			required: true,
			email: true
		},
		formTel:{
			number:true
		}
	},
	ignore:".ignore",
	messages: {
		formName: "请输入用户名",
		formPassword:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formPassword2:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formEmail:  {
			required: "请输入邮箱",
			email: "邮箱格式有误，请重新输入。"
		},
		formTel: "请输入数字",
	},
	
	validClass: "has-success",
	errorClass: "has-error"
				
}); 


$('.btnSubmit').click(function (event) {
	event.preventDefault();
	var $form=$(this).closest('.postForm');
	if($form.valid())
	{
		$.post('post/form.php', {}, function( data ) {
			$.each(data.errorMsg, function() {
				$form.find('#'+this.formId).parent().removeClass('has-success').addClass('has-error');
				$form.find('#'+this.formId).parent().find('label.has-error').show().html(this.formMsg);
			})
		},'json');	
	}
})

$('.btnSubmit2').click(function (event) {
	event.preventDefault();
	var $form=$(this).closest('.postForm2');
	if($form.valid())
	{
		$.post('post/form.php', {}, function( data ) {
			$.each(data.errorMsg, function() {
				$form.find('#'+this.formId).parent().removeClass('has-success').addClass('has-error');
				$form.find('#'+this.formId).parent().find('label.has-error').show().html(this.formMsg);
			})
		},'json');	
	}
})





$(".formContributor").validate({
	//onfocusout: false,
	rules: {
		formName: "required",
 
		formEmail: {
			required: true,
			email: true
		},
		formTel:{
			required: true,
			number:true
		},
		formWeb: "required"
	},
	ignore:".ignore",
	messages: {
		formName: "请输入用户名",
		formPassword:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formPassword2:  {
			required: "请输入密码",
			minlength: "密码最少6位数"
		},
		formEmail:  {
			required: "请输入邮箱",
			email: "邮箱格式有误，请重新输入。"
		},
		formTel: "请输入电话",
		formWeb: "请输入网址"
	},
	
	validClass: "has-success",
	errorClass: "has-error"
				
}); 

function validatePromote()
{
	$('.formPromote .questionItem').removeClass('plsFill');
	$('.errorMsg').hide();
	
	

	$('.formPromote .questionItem').each(function(){
	
		if($(this).find('input:text').length > 0 && $(this).is(":visible"))
		{
			if($.trim( $(this).find('.form-control').val())=="")
			{
				$(this).addClass('plsFill');
				$('.errorMsg').show();
			}
		}
		
		if($(this).find('select').length > 0 && $(this).find('select').val() == 'plsSelect')
		{
			$(this).addClass('plsFill');
			$('.errorMsg').show();
		}
		
		
		if($(this).find('input:checkbox').length > 0 && $(this).find('.checked').length ==0  )
		{
			$(this).addClass('plsFill');
			$('.errorMsg').show();
		}
		
		
		
	})
}


$('.formPromote .btnNext').click(function(event){
	
	
	event.preventDefault();
	validatePromote();
	
	if($('.formPromote .plsFill').length > 0)
	{
		//错误 回到顶端
		location.href ='#formApply';
	}else
	{
		// 正确 页面跳转
		location.href ='promoted_step2.html#formApply';
	}
	
	
	
	
	
})

$('.formPromote select').each(function(){
	if($(this).val() == 'showRemark')
	{
		$(this).closest('.questionBox').find('.remark.questionItem').show();
	}else
	{
		$(this).closest('.questionBox').find('.remark.questionItem').hide();
	}
})
$('.formPromote select').change(function(){
	
	if($(this).val() == 'showRemark')
	{
		$(this).closest('.questionBox').find('.remark.questionItem').show();
	}else
	{
		$(this).closest('.questionBox').find('.remark.questionItem').hide();
	}
	
})





});
}( jQuery ));