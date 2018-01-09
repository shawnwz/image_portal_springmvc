$(document).ready(function() {
	
	var anniu='<div class="button medium secondary dialog_btn_2">取消</div>'
		+'<div class="button medium primary dialog_btn_1">保存</div>';
		
		$("#gerenziliaodiv").hide();
		
		txtupdateMyCom=$("#updateCom").html();
		txtupdateMyCom+="<div class='comdiv'>"+anniu+"</div>";
		$("#updateCom").remove();
		
		txtupdateMyMima=$("#xiugaimima").html();
		txtupdateMyMima+="<div class='pwddiv'>"+anniu+"</div>";
		$("#xiugaimima").remove();
		
		txtupdateMyInfo=$("#gerenziliaodiv").html();
		txtupdateMyInfo+="<div class='persondiv'>"+anniu+"</div>";
		$("#gerenziliaodiv").remove();
		
		
		
		$("#editPersonalInformation").click(updateMyInfo);
		$("#add_MailingAddress").click(updateMyInfo);
		$("#changePasswordLink").click(updateMyMima);
		$("#editCompanyInformation").click(updateMyCom);//updateCom
		$("#add_BillingAddress").click(updateMyCom);
		$("#add_jobTitle").click(updateMyCom);
	});
	
	
  function personCheckBoxChange(item){
	  
  }
	
function updateMyCom(){
	
	myPanel('公司资料',txtupdateMyCom,'upgongsi', 
			function(){
				
			$("#chkbxgeren").click(function(){
				comSelect("#chkbxgeren");
				if($("#chkbxgeren").attr("select")=="true"){
					$("#comStreetAddress1").val(myStreetAddress1);
					$("#comStreetAddress2").val(myStreetAddress2);
					$("#comStreetAddress3").val(myStreetAddress3);
					$("#comCity").val(myCity);
					//$("#comProvince").val(myProvince);
					$("#comZipCode").val(myZipCode);
					$("#comProvince").find("option[value='"+myProvince+"']")[0].selected=true;
				}/*else{
					$("#comStreetAddress1").val(comStreetAddress1);
					$("#comStreetAddress2").val(comStreetAddress2);
					$("#comStreetAddress3").val(comStreetAddress3);
					$("#comCity").val(comCity);
					//$("#comProvince").val(comProvince);
					$("#comZipCode").val(comZipCode);
					 $("#comProvince").find("option[value='"+comProvince+"']").attr("selected",true);
				}*/
				
			});			

		$(".comdiv .dialog_btn_2").bind("click",function(){
			closeDialog("upgongsi");
		});
		$(".comdiv .dialog_btn_1").bind("click",function(){
			//保存
			//cominfo
			$("#cominfo").val(
					'{'+
					'"comName":'+'"'+$("#comName").val()+'",'
					+'"comPhone":'+'"'+$("#comPhone").val()+'",'
	/* 				+'"comAddress":'+'"'+$("#comAddress").val()+'",'
	 */				+'"comStreetAddress1":'+'"'+$("#comStreetAddress1").val()+'",'//+$("#comStreetAddress2").val()+$("#comStreetAddress3").val()
					+'"comStreetAddress2":'+'"'+$("#comStreetAddress2").val()+'",'
					+'"comStreetAddress3":'+'"'+$("#comStreetAddress3").val()+'",'
	 				+'"comCity":'+'"'+$("#comCity").val()+'",'
					+'"comProvince":'+'"'+$("#comProvince").val()+'",'
					+'"comZipCode":'+'"'+$("#comZipCode").val()+'",'
					+'"comCountry":'+'"'+$("#comCountry").val()+'"}'
			);
				$.post("my/updateComInfo.do", $("#comForm").serialize(), function(data) {
					if (data.state == 1) {
						myAlert("修改成功", function() {
								location.reload(true);
								});
					}else if (data.state == 0) {
						myAlert(data.message);
					}
				});
		});
  }, function(){
	   //$("#upgongsi").remove();
  }); 
}
	
	
function updateMyMima(){
	myPanel("修改密码",txtupdateMyMima,'upmima', function(){
		
			$(".pwddiv .dialog_btn_2").bind("click",function(){
				//closeDialog("upmima");
				closeDialog("upmima");
			});
			$(".pwddiv .dialog_btn_1").bind("click",function(){
				//保存
				if($("#acc_NewPassword").val()==$("#acc_ConfirmNewPassword").val()){
					$.post("my/updatemypwd.do", $("#mimaform").serialize(), function(data) {
						if (data.state == 1) {
							myAlert("修改成功", function() {
									location.reload(true);
									});
						}else{
							myAlert(data.message);
						}
					});
				}else{
					myAlert("两次密码输入不一致");
				}
			});
      }, function(){
      }); 
}
	

function updateMyInfo(){
	 myPanel('个人资料',txtupdateMyInfo,"upgeren", function(){
		 //注册chkbxcom事件
		  
			$("#chkbxcom").click(function(e){
				comSelect("#chkbxcom");
				if($("#chkbxcom").attr("select")=="true"){
					$("#myStreetAddress1").val(comStreetAddress1);
					$("#myStreetAddress2").val(comStreetAddress2);
					$("#myStreetAddress3").val(comStreetAddress3);
					$("#myCity").val(comCity);
					//$("#myProvince").val(comProvince);
					$("#myZipCode").val(comZipCode);
					 $("#myProvince").find("option[value='"+comProvince+"']").attr("selected",true);
				}/*else{
					$("#myStreetAddress1").val(myStreetAddress1);
					$("#myStreetAddress2").val(myStreetAddress2);
					$("#myStreetAddress3").val(myStreetAddress3);
					$("#myCity").val(myCity);
					//$("#myProvince").val(comProvince);
					$("#myZipCode").val(myZipCode);
					 $("#myProvince").find("option[value='"+myProvince+"']").attr("selected",true);
				}*/
				
			});


		 $(".persondiv .dialog_btn_2").bind("click",function(){
				//closeDialog("upmima");
				closeDialog("upgeren");
			});
			$(".persondiv .dialog_btn_1").bind("click",function(){
				//保存
				$("#contactsInfo").val(
						'{"myStreetAddress1":'+'"'+$("#myStreetAddress1").val()+'",'//+$("#myStreetAddress2").val()+$("#myStreetAddress3").val()
						+'"myStreetAddress2":'+'"'+$("#myStreetAddress2").val()+'",'
						+'"myStreetAddress3":'+'"'+$("#myStreetAddress3").val()+'",'
						+'"myCity":'+'"'+$("#myCity").val()+'",'
						+'"myProvince":'+'"'+$("#myProvince").val()+'",'
						+'"myZipCode":'+'"'+$("#myZipCode").val()+'",'
						+'"myCountry":'+'"'+$("#myCountry").val()+'"}'
				);
					$.post("my/updateMyInfo.do", $("#gerenziliao").serialize(), function(data) {
						if (data.state == 1) {
							myAlert("修改成功", function() {
									location.reload(true);
									});
						}else if (data.state == 0) {
							myAlert(data.message);
						}
					});
			});
   }, function(){
	   $("#upgeren").remove();
   }); 
}

function comSelect(dom){
	if($(dom).attr("select")=="true"){
		$(dom).attr("select","false");
		$(dom).removeClass("checked");
	}else{
		$(dom).attr("select","true");
		$(dom).addClass("checked");
	}
}