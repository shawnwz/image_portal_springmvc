
var curLightBoxid=0;
var curLightBoxItems=new Object();

//my用.
var myCurImageData=null;
var myCurDataImageArray = new Array();
var mylightboxpz=25;
var mylightboxp=1;

//var isShowBigImage = false; // 为了兼容
/*灯箱操作. */

function AddNewLightBox(fidin)
{
	var fid=0;
	if(fidin)
		fid=fidin;
	//function myPanel(title, html, id, open, close)
	var html='<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
		+'<input id="lbNameField" type="text" maxlength="40" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " placeholder="请输入新灯箱名称">'
		+'<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
		+'<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
	myPanel("创建新灯箱",html,"AddNewLightBox",function(){
		$("#lbNameField").val("");
	},null);
	$("#lightbox_save").unbind();
	$("#lightbox_cancel").unbind();
	$("#lightbox_save").bind("click",function(){
		//save ajax. and refresh. 
		if($("#lbNameField").val()=="")
		{
			myAlert("名称不能为空");
			return ;
		}
		$.post("my/addlightbox",{name:$("#lbNameField").val(),key:fid,t:Math.random()},function(data){
			if(data&&data.error==0){
				//myAlert("添加成功");
				if(data.data&&data.data.id)
					curLightBoxid=data.data.id;
				refreshlightbox(true);
				closeDialog("AddNewLightBox");
			}else if(data&&data.error==401)
			{
				myAlert("需要登录",function(){
					closeDialog("AddNewLightBox");
				});
			}
			else 
			{
				myAlert("添加失败");
			}
			
		});
	});
	
	$("#lightbox_cancel").bind("click",function(){
		//close
		closeDialog("AddNewLightBox");
	});
}


function refreshlightbox(force,callback)
{
	if(curLightBoxid==0||force)
	$.post("my/getlightboxes",{t:Math.random()},function(data){
		if(data&&data.error==0&&data.data&&data.data.length>0)
		{
			if(curLightBoxid==0)
				curLightBoxid=data.data[0].key;
			else
			{
				if($.grep(data.data, function(i,n){return n.key==curLightBoxid;}).length==0)
					curLightBoxid=data.data[0].key;
			}
			$(".mylightbox-left .select-widget div").empty();
			$.each(data.data,function(i,n){
				$(".mylightbox-left .select-widget div").append('<a href="javascript:void(0);" value="'+n.key+'"><p>'+n.value+'</p></a>');
			});
			selectwidget($(".mylightbox-left .select-widget"));
			setSelectwidget("nv_light_id",curLightBoxid);
			refreshlightboxitems();
			if(callback)
				callback();
		}else if(data&&data.error==401)
		{
			myAlert("需要登录");
			//
		}
		else 
		{
			myAlert("操作失败");
		}
	});
}

function refreshlightboxitems()
{
	curLightBoxid=$(".mylightbox-left .select-widget input[name='nv_light_id']").val();
	$.post("my/getlightboxitems",{key:curLightBoxid,t:Math.random()},
			function(data){
		if(data&&data.error==0&&data.data)
		{
			$(".picbox-picbox").removeClass("on");
			$(".picbox-picbox .pic-button8").removeClass("on");
			curLightBoxItems=data;
			$(".mylightbox-left-imgbox .jspPane").empty();
			$.each(data.data,function(i,n){
				var item=n;
				if(data.map&&data.map[n.corbisId])
				{
				var eles=data.map[n.corbisId];
				var rf = eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";
				var html='<div class="mylightbox-left-imgbox-box" value="'+n.id+'" boxid="'+n.boxId+'" gpid="'+n.corbisId+'">'+
                	'<div><a href="javascript:void(0);"><img src="'+eles.imageHost + 'THUMBNAIL/' + eles.path+'" /></a>'+
                    '</div><p><span>RF</span><i></i></p></div>';
					$(".mylightbox-left-imgbox .jspPane").append(html);
				}
				//light;
				
				
			});
			$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box i").unbind();
			$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box i").click(function(){
				delLightBoxItem($(this).parent().parent());
			});
			$('.mylightbox-left-imgbox').jScrollPane(
			{
				animateScroll: true
			});
			//light right ;
			
			setDivLightOn();
			
		}
		else if(data&&data.error==401)
		{
			myAlert("需要登录");
		}
		else 
		{
			myAlert("操作失败");
		}
	});
}

///灯箱点亮或取消.
function LightBox(item)
{
	var listitem=item.closest(".picbox-picbox");
	var gpid=listitem.attr("gpid");
	
	if(item.hasClass("on"))
	{
		//移出灯箱的ajax
		var items= $(".mylightbox-left-imgbox .jspPane").find(".mylightbox-left-imgbox-box[gpid='"+gpid+"']");
		
		items.each(function(){
			var itemId=$(this).attr("value");
			delLightBoxItem($(this));
		});
		
		item.removeClass("on");
		item.closest(".picbox-picbox").removeClass("on");
	}else
	{
		//加入灯箱的ajax
		//callback:$(this).addClass("on");
		var afterall=function(data){
			//light on .
			setDivLightOn();
		};
		var save=function(){
			addLightBoxItem(gpid,afterall);
		};
		if(!curLightBoxid||curLightBoxid<=0)
		{
			selectLightBox(save);
		}else
		{
			save();
		}
	}
}





function delLightBoxItem(item)
{
	var id=item.attr("value");
	$.post("my/dellightboximages",{key:id},function(data){
		if(data&&data.error==0)
		{
			
			$(".picbox-picbox[gpid='"+item.attr("gpid")+"']").removeClass("on");
			$(".picbox-picbox[gpid='"+item.attr("gpid")+"'] .pic-button8").removeClass("on");
			
			item.remove();
			$('.mylightbox-left-imgbox').jScrollPane(
					{
								animateScroll: true
				    });
			
		}
		else if(data&&data.error==401)
		{
			myAlert("需要登录");
		}
		else 
		{
			myAlert("操作失败");
		}
	});
}

function addLightBoxItem(corbisId,callback)
{
//	var id=id?id:$(this).parent().parent().attr("value");
	$.post("my/addlightboximages",{key:curLightBoxid,corbisId:corbisId},function(data){
		if(data&&data.error==0)
		{
			var n=data.data;
			var eles=data.map;
			var html='<div class="mylightbox-left-imgbox-box" value="'+n.id+'" boxid="'+n.boxId+'" gpid="'+n.corbisId+'" >'+
        	'<div><a href="javascript:void(0);"><img src="'+eles.imageHost + 'THUMBNAIL/' + eles.path+'" /></a>'+
            '</div><p><span>RF</span><i></i></p></div>';
			$(".mylightbox-left-imgbox .jspPane").append(html);
			curLightBoxItems.data.push(data.data);
			curLightBoxItems.map[corbisId]=data.map;
			
			$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box[value='"+n.id+"'] i").unbind();
			$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box[value='"+n.id+"'] i").click(function(){
				delLightBoxItem($(this).parent().parent());
			});
			
			$('.mylightbox-left-imgbox').jScrollPane({animateScroll: true});
			if(callback)
				callback();
		}
		else if(data&&data.error==401)
		{
			myAlert("需要登录");
		}
		else 
		{
			myAlert("操作失败");
		}
	});
}

function selectLightBox(callback)
{
	tag_change('piclist','piclisttag','1','2');
	refreshlightbox(true,function(){
		$.post("my/getlightboxes",function(data2){
			var option='<select name="moveLightBoxtarget" id="moveLightBoxtarget" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " >';
			$.each(data2.data,function(i,n){
				option+='<option value="'+n.key+'">'+n.value+'</option>';
			});
			option+='</select><br>';
		var html='<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
			+option
			+'<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
			+'<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
		myPanel("请选择灯箱",html,"selectLightBox",function(){
			$("#moveLightBoxtarget").val("");
		},null);
		$("#lightbox_save").unbind();
		$("#lightbox_cancel").unbind();
		$("#lightbox_save").bind("click",function(){
			curLightBoxid=$("#moveLightBoxtarget").val();
			setSelectwidget("nv_light_id",curLightBoxid);
			closeDialog("selectLightBox");
			if(callback)
				callback();
		});
		$("#lightbox_cancel").bind("click",function(){
			closeDialog("selectLightBox");
		});
		});
	});
}




/*灯箱操作.end */


/*my lightbox start*/

function myrefreshlightbox(force)
{
	if(curLightBoxid==0||force)
	$.post("my/getlightboxeslist",{t:Math.random()},function(data){
		if(data&&data.error==0&&data.data&&data.data.length>0)
		{
			if(curLightBoxid==0)
				curLightBoxid=data.data[0].id;
			else
			{
				if($.grep(data.data, function(n){return n.id==curLightBoxid;}).length==0)
					curLightBoxid=data.data[0].id;
			}
			$(".MyLightboxes-left").empty();
			//$.each(data.data,function(i,n)
				for(var i=0;i<data.data.length;i++)	
				{
					var n=data.data[i];
					var sons=privateGetSonItems(data.data,n.id);

					var html='<div href="javascript:void(0);" onclick="mylightboxactive($(this));" value="'+n.id+'" level="'+n.level+'" fbox="'+n.parentId+'" class="boxitem " style="'+(n.parentId>0?"display:none;":"")+' padding-left:'+(n.level*10)+'px">'+
					'<div class="boxitemcontent">'+
					'<div onclick="javascript:mylightboxToggleTree($(this).parent().parent());" class="Arrow" style="'+((sons.length>0)?"":"display:none;")+'"><img src="images/iconCaretCollapsed.gif"  style="'+((sons.length>0)?"":"display:none;")+'"/></div>'
					+'<span>'+privateGetLevelStr(n.level,">")+n.name+'</span><br />'+
					n.imageNum+'个项目&nbsp;&nbsp;'+sons.length+'个灯箱<br />'+
	                    '修改&nbsp;&nbsp;'+getDateStr(n.updateTime) +//2014/01/01
	                    '<img src="images/iconDelete.gif" onclick="deleteLightBox(\''+n.id+'\',\''+n.name+'\')" />'+
	                    '</div></div>';
	                $(".MyLightboxes-left").append(html);
				};
			//展示界面.
			if(curLightBoxid==0)
				mylightboxactive($(".MyLightboxes-left .boxitem").eq(0));
			else
			{
				mylightboxactive($(".MyLightboxes-left .boxitem[value='"+curLightBoxid+"']"));
				mylightboxToggleTreeshow($(".MyLightboxes-left .boxitem[value='"+curLightBoxid+"']"));
			}
		}else if(data&&data.error==401)
		{
			myAlert("需要登录");
			//
		}
		else 
		{
			myAlert("操作失败");
		}
	});
}
function privateGetSonItems(list,id)
{
	var ret=new Array();
	for(var i=0;i<list.length;i++)
		if(list[i].parentId==id)
			ret.push(list[i]);
	return ret;
}
function privateGetLevelStr(level,str)
{
	var s="";
	var str=str?str:">";
	for(var i=0;i<level;i++)
	{
		s+=str;
	}
	return s;
}

function deleteLightBox(id,name)
{
	//myConfirm(msg, ok, cancel, title) 
	myConfirm("您确定要删除此灯箱["+name+"]?",
			function(){
		//del
		$.post("my/dellightbox",{key:id,t:Math.random()},function(data){
			if(data&&data.error==0){
				//myAlert("添加成功");
				var item=$(".boxitem[value='"+id+"']");
				var fitem=item.prevAll(".boxitem[value='"+item.attr("fbox")+"']");
				if(fitem.length>0)
					curLightBoxid=fitem.attr("value");
				else
					curLightBoxid=0;
				myrefreshlightbox(true);
				
			}else if(data&&data.error==401)
			{
				myAlert("需要登录",function(){
					closeDialog("addNewLightBox");
				});
				//
			}
			else 
			{
				myAlert("添加失败");
			}
			
		});
		
	},function(){},
			"删除灯箱");
}

function myAddNewLightBox(fidin)
{
	var fid=0;
	if(fidin)
		fid=fidin;
	//function myPanel(title, html, id, open, close)
	var html='<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
		+'<input id="lbNameField" type="text" maxlength="40" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " placeholder="请输入新灯箱名称">'
		+'<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
		+'<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
	myPanel("创建新灯箱",html,"addNewLightBox",function(){
		$("#lbNameField").val("");
	},null);
	$("#lightbox_save").unbind();
	$("#lightbox_cancel").unbind();
	$("#lightbox_save").bind("click",function(){
		//save ajax. and refresh. 
		if($("#lbNameField").val()=="")
		{
			myAlert("名称不能为空");
			return ;
		}
		$.post("my/addlightbox",{name:$("#lbNameField").val(),key:fid,t:Math.random()},function(data){
			if(data&&data.error==0){
				//myAlert("添加成功");
				if(data.data&&data.data.id)
					curLightBoxid=data.data.id;
				myrefreshlightbox(true);
				closeDialog("addNewLightBox");
			}else if(data&&data.error==401)
			{
				myAlert("需要登录",function(){
					closeDialog("addNewLightBox");
				});
				//
			}
			else 
			{
				myAlert("添加失败");
			}
			
		});
	});
	
	$("#lightbox_cancel").bind("click",function(){
		//close
		closeDialog("addNewLightBox");
	});
}

function myMoveLightBox()
{
	//function myPanel(title, html, id, open, close)
	$.post("my/getlightboxes",function(data2){
		var option='<select name="moveLightBoxtarget" id="moveLightBoxtarget" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " >';
		$.each(data2.data,function(i,n){
			option+='<option value="'+n.key+'">'+n.value+'</option>';
		});
		option+='</select><br>';
	var html='<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
		+option
		+'<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
		+'<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
	myPanel("创建新灯箱",html,"myMoveLightBox",function(){
		$("#moveLightBoxtarget").val("");
	},null);
	$("#lightbox_save").unbind();
	$("#lightbox_cancel").unbind();
	$("#lightbox_save").bind("click",function(){
		//save ajax. and refresh. 
		
		$.post("my/setlightboxfather",{key:curLightBoxid,fid:$("#moveLightBoxtarget").val(),t:Math.random()},function(data){
			if(data&&data.error==0){
				//myAlert("添加成功");
				if(data.data&&data.data.id)
					curLightBoxid=data.data.id;
				myrefreshlightbox(true);
				closeDialog("myMoveLightBox");
			}else if(data&&data.error==401)
			{
				myAlert("需要登录",function(){
					closeDialog("myMoveLightBox");
				});
				//
			}
			else 
			{
				myAlert("移动失败");
			}
			
		});
	});
	
	$("#lightbox_cancel").bind("click",function(){
		//close
		closeDialog("myMoveLightBox");
	});
	
	
	});
}



function mylightboxToggleTree(item)
{
	//iconCaretCollapsed.gif
	//iconCaretExpanded.gif
	var listitem=item;
	if(item.find(".Arrow img").attr("src")=="images/iconCaretCollapsed.gif")
	{
		//展开s
		listitem.nextAll(".boxitem[fbox='"+item.attr("value")+"']").show();
		item.find(".Arrow img").attr("src","images/iconCaretExpanded.gif");
	}else
	{
		//合上.
		mylightboxToggleTreehide(listitem);
		item.find(".Arrow img").attr("src","images/iconCaretCollapsed.gif");
	}
}

function mylightboxToggleTreeshow(item)
{
	item.prevAll(".boxitem[value='"+item.attr("fbox")+"']").find(".Arrow img").attr("src","images/iconCaretCollapsed.gif");
	mylightboxToggleTree(item.prevAll(".boxitem[value='"+item.attr("fbox")+"']"));
	
	//
	if(item.prevAll(".boxitem[value='"+item.attr("fbox")+"']").length>0)
		mylightboxToggleTreeshow(item.prevAll(".boxitem[value='"+item.attr("fbox")+"']"));
}
function mylightboxToggleTreehide(item)
{
	item.nextAll(".boxitem[fbox='"+item.attr("value")+"']").each(function(){
		mylightboxToggleTreehide($(this));
	});
	item.nextAll(".boxitem[fbox='"+item.attr("value")+"']").hide();
	item.find(".Arrow img").attr("src","images/iconCaretCollapsed.gif");
}
function mylightboxactive(item)
{
	$(".MyLightboxes-left .boxitem").removeClass("on");
	item.addClass("on");
	if(item.attr("value"))
	{
		curLightBoxid=item.attr("value")?item.attr("value"):0;
		//get data . 
		$.post("my/getlightboxitems",{key:curLightBoxid},function(data){
			myCurImageData=data;
			mylightboxp=1;
			mylightBoxSetShow();
		});
	}
	
	/*myAlert("test",function(){
		myAlert("22");
	});*/
	
}

function mylightBoxSetShow(p) {
	myCurDataImageArray = new Array();
	var data = myCurImageData.data;
	var total=Math.ceil(data.length/mylightboxpz);
	var map=myCurImageData.map;
	//paging . 
	mylightboxp=p?p:mylightboxp;
	if(mylightboxp>Math.ceil(data.length/mylightboxpz))
		mylightboxp=Math.ceil(data.length/mylightboxpz);
	if(mylightboxp<1) mylightboxp=1;
	
	$("#picbox_center").empty();
	for (i = (mylightboxp-1)*mylightboxpz; i < data.length&&i<(mylightboxp)*mylightboxpz; i++) {
		var n = data[i];
		var eles= map[n.corbisId];
		if(!eles)
			continue;
		myCurDataImageArray["image" + eles.id] = eles;
		var rf = eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";
		var str = '<div class="picbox-picbox" id="divimage'
				+ eles.id
				+ '">'
				+ '<div id="bigdivimage'
				+ eles.id
				+ '" class="bigimagediv"><div class="bigdivimagediv">'
				+ '</div>'
				+ '<div id="addsearchimage'
				+ eles.id
				+ '" class="bigimageaddsearch"><a class="mlt_link" href="javascript:void(0);">更多相似图片</a></div></div>'
				+ '<div class="picbox-picbox-inner" >' + '<a href="image/'
				+ eles.corbisId + '" target="_blank" class="imagelink170"><img  id="minimage'
				+ eles.id + '" src="' + eles.imageHost + 'THUMBNAIL/' + eles.path
				+ '" /></a>' + '</div>';
		str+= '<p><b>' + rf + '</b>';
//		//小图标~~~
//		//str += '<i class="pic-button2"></i>'; // 计算价格
//		//str += '<i class="pic-button3"></i>'; // 购物车
//		if (eles.isInCd)
//			str += '<i class="pic-button4"></i>'; // CD
//		if (eles.isInImageSet)
//			str += '<i class="pic-button7"></i>'; // 图集
//		str += '<i class="pic-button8"></i>'; // 灯箱
//		str += '<i class="pic-button5 on"></i>'; // ~~
//		//以下二个是二选一的。 
//		if(eles.priType==0){
//			str += '<i class="pic-button6 on"></i>'; // 下载
//		}else if(eles.priType==3){
//			str += '<i class="pic-button1 on"></i>'; // 旗帜
//		}
		//小图标结束~
		
		str += '<br />'+eles.scn+'<br />' + eles.collectionName + '<br />'; // 图库
		str += eles.corbisId + '<br/>';
		//if(eles.title&&eles.title.length>0)
		//	str += eles.title+'<br />';
		//加了标题布局大变，暂按psd . 
		str +='</p>';
		
		//append textbox . 
		str += '<div class="picbox-pictext"><div>';
		if(eles.title&&eles.title.length>0)
			str += eles.title+'<br>';
		if(eles.caption&&eles.caption.length>0)
			str += eles.caption+'<br>';
		str += 	'<b>图片库: </b>'+eles.collectionName+'<br><br>';
		if(eles.photoDate&&eles.photoDate.length>0)
			str += 	'<b>拍摄日期: </b>'+eles.photoDate+'<br><br>';
		if(eles.location&&eles.location.length>0)
			str += 	'<b>地点: </b>'+eles.location+'<br><br>';
		str += '<b>肖像权同意书: </b>'+eles.modelRelease+'<br><b>';
		str += '产权同意书: </b>'+eles.propertyRelease+'<br><br>';
		if(eles.restrictionList.length>0)
			{
				str += '<font style="background:url(\'images/warn_ico.png\') no-repeat 0 center;padding-left: 20px;">Restrictions</font><br>';
				$.each(eles.restrictionList,function(i,n){
					str += '•    '+n+'';	
				});
			}
		str += '</div></div>';
		//append textbox end . 
		str += '</div>';
		$("#picbox_center").append(str);
		
		
		eval('$("#divimage' + eles.id
				+ '").mouseleave(function(){hidebigimg("image' + eles.id
				+ '");});');
		eval('$("#bigdivimage' + eles.id
				+ '").mouseenter(function(){showbigimg("image' + eles.id
				+ '");});');
		eval('$("#minimage' + eles.id
				+ '").mouseenter(function(){showbigimg("image' + eles.id
				+ '");});');
		eval('$("#divimage' + eles.id
				+ ' .mlt_link").click(function(){FindSameImage(' + eles.id
				+ ');});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button5").click(function(){FindSameImage(' + eles.id
				+ ');});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button1").click(function(){DownloadImageSepc("' + eles.corbisId
				+ '");});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button6").click(function(){DownloadImage("' + eles.corbisId
				+ '");});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button8").click(function(){LightBox(' + eles.id
				+ ');});');
	}
	

	var pagging='<div class="picbox-page"><div class="menu-pagebox"><a href="javascript:void(0);" class="page-arrow-left" onclick="mylightBoxSetShow('+(mylightboxp-1)+')"></a><span>'+total+'页之&nbsp;<input type="text" value="'+mylightboxp+'"></span><a href="javascript:void(0);" class="page-arrow-right" mylightBoxSetShow('+(mylightboxp+1)+')></a></div></div>';
	$("#picbox_center").append(pagging);
	
}

function mySelectRootBox()
{
	curLightBoxid=0;
	$(".MyLightboxes-left .boxitem").removeClass("on");
}

function setDivLightOn()
{
	//src
	$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box").each(function(){
		$(".picbox-picbox[gpid='"+$(this).attr("gpid")+"']").addClass("on");
		$(".picbox-picbox[gpid='"+$(this).attr("gpid")+"'] .pic-button8").addClass("on");
	});
	
}

/*my lightbox end*/