var leftArr = {}; // 左侧条件集合
var leftfiltercount=0;

function InitLeftCheckBox(data)
{
	InitLeftCheckBoxprivate(data);
	GetFormResult($("#leftform"));
	if(GetFormResultAdv)
		GetFormResultAdv($("#advform"));
	//search adv . 
	if(RefreshimagecollectionCount)
		RefreshimagecollectionCount();
}

function InitLeftCheckBoxprivate(data)
{
	initformto0();
	//还源left. and adv; 
	revertAllSearchInput(data);
}

//初始化所有表单
function initformto0()
{
	$("#leftform input[type='checkbox']").iCheck("uncheck",null);
	$("#leftform input[type='radio']").iCheck("uncheck",null);
	$("#leftform input[type='text']").val("");
	$("#leftform textarea").val("");
	$("#leftform select").val("-1");
	$("#hiddencolor").iCheck("uncheck",null);
	checkbutton('leftcolor','i',-1,'on');
	//$("#advform input[type='checkbox']").iCheck("uncheck",null);
	$("#advform input[type='radio']").iCheck("uncheck",null);
	$("#advform input[type='text']").val("");
	$("#advform textarea").val("");
	$("#advform select").val("-1");
	//// 左侧条件集合 
	$(".checkany").iCheck("check",Icheckclick);
	RefreshimagecollectionCountinit0();
	setSelectwidget("create_time",-1);
	setSelectwidget("immediateAvailablility",-1);
	
}
//原还表单.left and adv . 
function revertAllSearchInput(data)
{
	if(data)
		$.each(data,function(i,n){
			if(n&&n.length>0)
			{
				if(i=="create_time")
				{
					setSelectwidget(i,n);
					return;
				}
				if(i=="immediateAvailablility")
				{
					setSelectwidget(i,n);
					return;
				}
				var type="";
				var name=i;
				if(i=="cid") 
					name="imagecollection";
				if(i=="days")
				{
					$(".h-searchbox-datebg input[name='update-time']").eq(0).iCheck("check",null);
				}
				if(i=="beginDate"||i=="endDate")
				{
					$(".h-searchbox-datebg input[name='update-time']").eq(1).iCheck("check",null);
				}
				
				var types=$("input[name='"+name+"']");
				if(types.length>0)
					type=types.attr("type").toLowerCase();
				if(type=="checkbox"||type=="radio")
				{
					var a=n.split(",");
					if(i=="cid")
					{
						if(a.length>0&&$("#advform input[name='imagecollection']:checked").length==$("#advform input[name='imagecollection']").length)
						{
							$("#advform input[name='imagecollection']").iCheck("uncheck",null);
						}
					}
						
					
					$.each(a,function(j){
								$("input[name='"+name+"'][value='"+a[j]+"']").iCheck("check",Icheckclick);
					});
				}
				else
				{
					$("input[name='"+name+"']").val(n);
				}
			}
		});
}

function clearSearch(){
	if(getUrlArgs)
	{
		var args=getUrlArgs();
		if(args["q"]&&args["q"]!='undefined')
			location.hash = "#q="+args["q"];
		else
			location.hash = "";
	}else
	{
		location.hash = "";
	}
	leftArr = {};
	if(advArr){
		advArr = {};
	}
		
	
	InitLeftCheckBoxprivate();
	setPageDefault();
	search();
}

function afterFilterChange()
{
	GetFormResult($("#leftform"));
	genSearchSID();
	p = 1;
	search();
}

function GetFormResult(item)
{
	leftfiltercount=0;
	var formresult=new Object();
	$.each(item.serializeArray(),function(i,n){
		if(n.value!=null && n.value!='' && n.value!=-1 && n.value!=-2&& n.value!=-3
				&&n.name&&n.name.indexOf("nv_")<0)//nv--not value
		{
			if(formresult[n.name])
			{
				formresult[n.name]=formresult[n.name]+","+n.value;
			}else
			{
				formresult[n.name]=n.value;
				leftfiltercount++;
			}
				
		}
	});
	leftArr = {};
	var ret=formresult;
	$.each(ret,function(i,n){
		leftArr[i] = n;
	});
	
	var totalcount=leftfiltercount;
	if(advfiltercount)
		totalcount+=advfiltercount;
	$(".piclist-listtop span").html(totalcount);
	
	return formresult;
}

var leftDocumentReady=function(){
  $('.h-searchbox input').iCheck({
    checkboxClass: 'icheckbox_minimal-aero',
    radioClass: 'iradio_minimal-aero',
    increaseArea: '20%' ,
    fathertag:'.h-searchbox'// optional
  },function(item){
	  //check，uncheck操作结束后回调. 
	  //此外暂无逻辑
  },function(item){
	//click事件触发.
  	Icheckclick(item,1);
  });
  
  //piclist0
  $('#piclist0 input').iCheck({
	    checkboxClass: 'icheckbox_minimal-aero',
	    radioClass: 'iradio_minimal-aero',
	    increaseArea: '20%' ,
	    fathertag:'#piclist0'// optional
	  },function(item){
		  //check，uncheck操作结束后回调. 
		  //此外暂无逻辑
	  },function(item){
		//click事件触发.
	  	Icheckclick(item,1);
	  });
  
    $('.menu-show-addstyle input').iCheck({
	    checkboxClass: 'icheckbox_minimal-aero',
	    radioClass: 'iradio_minimal-aero',
	    increaseArea: '20%',
	    fathertag:'.menu-show-addstyle' // optional
	  },function(item){
		  //check，uncheck操作结束后回调. 
		  //此外暂无逻辑
	  },function(item){
		//click事件触发.
	  	Icheckclick(item,1);
	  });
//灯箱逻辑
			$('#mylightbox').jScrollPane(
			{
				animateScroll: true
			});
			boxhidden('piclist1')

};

function Icheckclick(item,gosearch)
{
//alert(item[0].id);
	if(!item||item.length<1)
		return;
	
	if(item[0].name=="checkbox_any")
	{
 		if(item[0].checked)
	     {
	     	$(".piclist-littleline .littleline-se input[name='cate_id']").iCheck("uncheck",null);
	     	$(".piclist-littleline input[name='checkbox_creativity']").iCheck("uncheck",null);
	     	$(".piclist-littleline input[name='checkbox_edition']").iCheck("uncheck",null);
	     }
	}else if(item[0].name=="checkbox_creativity")
	{
 		if($(".piclist-littleline input[name='checkbox_creativity']")[0].checked)
	     {
	     	$(".piclist-littleline .littleline-se input[name='cate_id']").slice(0,2).iCheck("check",null);
	     	$(".piclist-littleline input[name='checkbox_any']").iCheck("uncheck",null);
	     }
 		else
	    {
	        $(".piclist-littleline .littleline-se input[name='cate_id']").slice(0,2).iCheck("uncheck",null);
	    }
 		if($("#picline0 input:checked").length>=$("#picline0 input").length-1||$("#picline0 input:checked").length==0)
 		{
 			$("#picline0 input").eq(0).iCheck("check",Icheckclick);
 		}else
 		{
 			$("#picline0 input").eq(0).iCheck("uncheck",null);
 		}
	}
	else if(item[0].name=="checkbox_edition")
	{
 		if(item[0].checked)
	     {
	     	$(".piclist-littleline input[name='cate_id']").slice(2).iCheck("check",null);
	     	$(".piclist-littleline input[name='checkbox_any']").iCheck("uncheck",null);
	     }
 		else
	    {
	    	 $(".piclist-littleline input[name='cate_id']").slice(2).iCheck("uncheck",null);
	    }
 		if($("#picline0 input:checked").length>=$("#picline0 input").length-1||$("#picline0 input:checked").length==0)
 		{
 			$("#picline0 input").eq(0).iCheck("check",Icheckclick);
 		}else
 		{
 			$("#picline0 input").eq(0).iCheck("uncheck",null);
 		}
	}else if(item[0].name=="cate_id")
	{
		if(item[0].checked)
		{
			$(".piclist-littleline input[name='checkbox_any']").iCheck("uncheck",null);
		}
		else
		{
			if($(".piclist-littleline input[name='cate_id']").index(item)<=1)
			{
				$(".piclist-littleline input[name='checkbox_creativity']").iCheck("uncheck",null);
			}else
			{
				$(".piclist-littleline input[name='checkbox_edition']").iCheck("uncheck",null);
			}
		}
		if($("#picline0 .icheckbox_minimal-aero").slice(2,4).find("input:checked").length==2)
		{
			$("#picline0 .icheckbox_minimal-aero").slice(1,2).find("input").iCheck("check",Icheckclick);
		}
		if($("#picline0 .icheckbox_minimal-aero").slice(5,12).find("input:checked").length==7)
		{
			$("#picline0 .icheckbox_minimal-aero").slice(4,5).find("input").iCheck("check",Icheckclick);
		}
		
		
		if($("#picline0 input:checked").length>=$("#picline0 input").length-1||$("#picline0 input:checked").length==0)
 		{
 			$("#picline0 input").eq(0).iCheck("check",Icheckclick);
 		}
		
	}else if(item[0].name=="person_num")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='person_num']").slice(1).iCheck("uncheck",null);
		}
		else if(item[0].value=="1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='person_num']").slice(2).iCheck("uncheck",null);
			$(".piclist-littleline input[name='person_num']").slice(0,1).iCheck("uncheck",null);
		}
		else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='person_num']").slice(0,1).iCheck("uncheck",null);
			if(item[0].value!="0")
			{
				$(".piclist-littleline input[name='person_num']").slice(1,2).iCheck("uncheck",null);
			}
		}
		
		if($(".piclist-littleline input[name='person_num']:checked").length==9||$(".piclist-littleline input[name='person_num']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='person_num']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	else if(item[0].name=="sex")
	{
		//如果radio逻辑不满足再启用以下代码
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='sex']").slice(1).iCheck("uncheck",null);
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='sex']").slice(0,1).iCheck("uncheck",null);
		}
		
		if($(".piclist-littleline input[name='sex']:checked").length==3||$(".piclist-littleline input[name='sex']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='sex']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	else if(item[0].name=="age")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='age']").slice(1).iCheck("uncheck",null);
		}
		else if(item[0].value=="0")
		{
			if(item[0].checked)
			{
				$(".piclist-littleline input[name='age']").slice(2,4).iCheck("check",null);
				$(".piclist-littleline input[name='age']").eq(0).iCheck("uncheck",null);
			}else
			{
				$(".piclist-littleline input[name='age']").slice(2,4).iCheck("uncheck",null);
			}
		}
		else if(item[0].value!="-1")
		{
			if(item[0].value=="1"&&!item[0].checked)
			{
				$(".piclist-littleline input[name='age']").slice(1,2).iCheck("uncheck",null);
				$(".piclist-littleline input[name='age']").eq(0).iCheck("uncheck",null);
			}
			else if(item[0].value=="2"&&!item[0].checked)
			{
				$(".piclist-littleline input[name='age']").slice(1,2).iCheck("uncheck",null);
			}
			$(".piclist-littleline input[name='age']").eq(0).iCheck("uncheck",Icheckclick);
		}
		if($(".piclist-littleline input[name='age']").slice(2,4).parent().find("input:checked").length==2)
		{
			$(".piclist-littleline input[name='age']").slice(1,2).iCheck("check",null);
		}
		if($(".piclist-littleline input[name='age']:checked").length==9||$(".piclist-littleline input[name='age']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='age']").eq(0).iCheck("check",Icheckclick);
 		}
		
	}else if(item[0].name=="race")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='race']").slice(1).iCheck("uncheck",null);
		}else if(item[0].value=="0"&&item.checked)
		{
			$(".piclist-littleline input[name='race']").slice(2,4).iCheck("check",null);
			$(".piclist-littleline input[name='race']").slice(0,1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='race']").slice(0,1).iCheck("uncheck",null);
		}
		if($(".piclist-littleline input[name='race']:checked").length==6||$(".piclist-littleline input[name='race']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='race']").eq(0).iCheck("check",Icheckclick);
 		}
		
	}else if(item[0].name=="type")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='type']").slice(1).iCheck("uncheck",null);
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='type']").slice(0,1).iCheck("uncheck",null);
		}
		if($(".piclist-littleline input[name='type']:checked").length==2||$(".piclist-littleline input[name='type']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='type']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	
	else if(item[0].name=="direction")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='direction']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='direction']").slice(0,1).iCheck("uncheck",null);
		}
		if($(".piclist-littleline input[name='direction']:checked").length==4||$(".piclist-littleline input[name='direction']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='direction']").eq(0).iCheck("check",Icheckclick);
 		}
	}else if(item[0].name=="portrait")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='portrait']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='portrait']").slice(0,1).iCheck("uncheck",null);
		}
		
		if($(".piclist-littleline input[name='portrait']:checked").length==2||$(".piclist-littleline input[name='portrait']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='portrait']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	else if(item[0].name=="style")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='style']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='style']").slice(0,1).iCheck("uncheck",null);
		}
		
		if($(".piclist-littleline input[name='style']:checked").length==5||$(".piclist-littleline input[name='style']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='style']").eq(0).iCheck("check",Icheckclick);
 		}
		
	}else if(item[0].name=="layout")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='layout']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='layout']").slice(0,1).iCheck("uncheck",null);
		}
		
		if($(".piclist-littleline input[name='layout']:checked").length==7||$(".piclist-littleline input[name='layout']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='layout']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	else if(item[0].name=="angle")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='angle']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='angle']").slice(0,1).iCheck("uncheck",null);
		}
		if($(".piclist-littleline input[name='angle']:checked").length==7||$(".piclist-littleline input[name='angle']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='angle']").eq(0).iCheck("check",Icheckclick);
 		}
	}
	else if(item[0].name=="color")
	{
		if(item[0].value=="-1"&&item[0].checked)
		{
			$(".piclist-littleline input[name='color']").slice(1).iCheck("uncheck",null);
			
		}else if(item[0].value!="-1")
		{
			$(".piclist-littleline input[name='color']").slice(0,1).iCheck("uncheck",null);
		}
		
		$("#hiddencolor").val(-1);
		
		checkbutton('leftcolor','i',-1,'on');
		
		if($(".piclist-littleline input[name='color']:checked").length==2||$(".piclist-littleline input[name='color']:checked").length==0)
 		{
 			$(".piclist-littleline input[name='color']").eq(0).iCheck("check",Icheckclick);
 		}
		
	}else if(item[0].name=="is_cd")
	{
		//do nothing . 
	}
	else if(item[0].name=="update-time")
	{
		if(item[0].checked)
		{
			$(".hsebo-listbox input[name='update-time']").not(item).iCheck("uncheck",null);
		}
		return ;
	}
	else if(item[0].name=="imagecollection")
	{
		if(RefreshimagecollectionCount)
		RefreshimagecollectionCount();
		return ;
	}else if(item[0].name=="canpreview")
	{
		setShowPreview();
		//isShowBigImage
		return;
	}
	else if(item[0].name=="caninputhelper")
	{
		setInputHelper();
		//isShowBigImage
		return;
	}
	else if(item[0].name=="")
	{
		return ;
	}else
	{
		
		return;
	}
	if(gosearch)
		afterFilterChange();
}

function selectLeftColor(value,item)
{
	//从0开始计数。
	var index=$("#leftcolor i").index(item);
	checkbutton('leftcolor','i',index,'on');
	$("#hiddencolor").iCheck("check",null);
	$("#hiddencolor").val(value);
	if(value>0)
	{
		$(".piclist-littleline input[name='color']").not($("#hiddencolor")).iCheck("uncheck",null);
	}else
	{
		$("#hiddencolor").iCheck("uncheck",null);
	}
	afterFilterChange();
}
