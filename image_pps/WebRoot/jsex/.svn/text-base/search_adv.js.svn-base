var advArr = {}; // 高级搜索条件集合
var needimagecollection=false;
var advfiltercount=0;
function afteradvanceSearch()
{
	
	//dateCreated
	//days
	//beginDate
	//endDate
	//location
	//photographer
	//provider
	//immediateAvailablility
	//imageNumbers
	///imagecollection  cid;
	var path=window.location.pathname;
	if(path.indexOf("search")>=0)
	{
		GetFormResultAdv($("#advform"));
		genSearchSID();
		p = 1;
		if(hiddensearchadv)
			hiddensearchadv();
		if(groupId)
			groupId="";
		if(spl)
			spl="";
		if(smid)
			smid="";
		search();
	}else
	{
		if(goToSearchPage)
		goToSearchPage();
	}
}

function GetFormResultAdv(item)
{
	advfiltercount=0;
	var formresult=new Object();
	$.each(item.serializeArray(),function(i,n){
		if(n.value!=null && n.value!='' && n.value!=-1&&n.name&&n.name.indexOf("nv_")<0)
		{
			if(needimagecollection||n.name!="imagecollection")
			{
				if(n.name=='update-time')
					return;
				if(n.name=="days"&&!$(".h-searchbox-datebg input[name='update-time']").eq(0)[0].checked)
				{
					return;
				}
				if(n.name=="beginDate"&&!$(".h-searchbox-datebg input[name='update-time']").eq(1)[0].checked)
				{
					return;
				}
				if(n.name=="endDate"&&!$(".h-searchbox-datebg input[name='update-time']").eq(1)[0].checked)
				{
					return;
				}
				////////////////////////////////////////////////////////////////////////////////
				if(formresult[n.name])
				{
					formresult[n.name]=formresult[n.name]+","+n.value;
				}else
				{
					formresult[n.name]=n.value;
					advfiltercount++;
				}
			}
		}
	});
	
	ret=formresult;
	advArr = {};
	$.each(ret,function(i,n){
		//alert("name:"+i+"value:"+n);
		if(i=='imagecollection'){
			advArr['cid'] = n;
		}
		else{
			advArr[i] = n;
		}
		
	});
	
	var totalcount=advfiltercount;
	if(typeof(leftfiltercount)!="undefined"&&leftfiltercount)
		totalcount+=leftfiltercount;
	$(".piclist-listtop span").html(totalcount);
	return formresult;
}

var documentReadyAdv=function(){
    
    //RefreshimagecollectionCount();
    
	$(".selectAllLink").click(function(){
		$(".selectAllLink").parent().prev().children("div").find("input[name='imagecollection']").iCheck("check",null);
		RefreshimagecollectionCount();
	});
	
	$(".deselectAllLink").click(function(){
		$(".selectAllLink").parent().prev().children("div").find("input[name='imagecollection']").iCheck("uncheck",null);
		RefreshimagecollectionCount();
	});
	
	//滚动
//	$('.imagecollselect .scroll-pane').jScrollPane(
//			{
//				showArrows: true,
//				animateScroll: true
//			}
//	);
	
	//手风琴
	$(".imagecollselect").accordion({ header: ".h-searchbox-sfqtitle" ,beforeActivate: function( event, ui ) {
		ui.newPanel.after($(".selectLinksWrap"));
	},activate:function(event, ui){
		ui.newPanel.find('.scroll-pane').jScrollPane(
				{
					showArrows: true,
					animateScroll: true
				}
		);
	}});
	//for input helper . 
	$("#q").keyup(function(event) {
		var keyCode = event.keyCode;
		if(keyCode == 13)
		{
			boxhidden("searchimformationboxinputhelper");
		}
		else
		{
			loadInputHelper();
		}
	});
	$(".selectAllLink").parent().prev().children("div").find("input[name='imagecollection']").iCheck("uncheck",null);
	$(".selectAllLink").parent().prev().children("div").find("input[name='imagecollection']").iCheck("check",null);
	RefreshimagecollectionCount();
};

var privateinputq=""; 
function loadInputHelper()
{
	var v=$("#q").val();
	if(privateinputq!=v)
		privateinputq=v;
	else
		return;
	var sf = $.cookie('ih');
	if (!sf) {
		$.cookie('ih', 1);
		sf = 1;
	}
	if(sf!=1)
		return;
	var v=privateinputq;
	//load and show;
	$.post("hotKey.do",{"num":12,"hk":v},function(data){
		//http://alpha.app.gaopinimages.com/hotKey.do?hk=%E4%BA%BA&num=20
		$("#searchimformationboxinputhelper #inputkeywordslist").empty();
		var html="";
		$.each(data.data,function(i,n){
			html+='<li onclick="$(\'#q\').val(\''+n.keyword+'\');boxhidden(\'searchimformationboxinputhelper\');$(\'#q\').focus();" style="cursor: pointer;"><span>'+n.keyword+'</span></li>';
		});
		$("#searchimformationboxinputhelper #inputkeywordslist").append(html);
		boxshowkeepfornote("searchimformationboxinputhelper");
		$("#searchimformationboxinputhelper").css("height",20+$("#inputkeywordslist").height());
	});
}


function RefreshimagecollectionCount()
{
	needimagecollection=false;
//	if($("input[name='imagecollection']:checked").length==0)
//	{
//		$("input[name='imagecollection']").iCheck("check",null);
//	}
	
	$(".h-searchbox-sfqtitle").each(function(i){
		var count1= $(".h-searchbox-sfqtitle").eq(i).next(".h-searchbox-sfqcontentparent").find("input:checked").length;
		var count2= $(".h-searchbox-sfqtitle").eq(i).next(".h-searchbox-sfqcontentparent").find("input").length;
		$(".h-searchbox-sfqtitle").eq(i).find("font").eq(0).html(count1);
		$(".h-searchbox-sfqtitle").eq(i).find("font").eq(1).html(count2);
		if(count1!=count2)
			needimagecollection=true;
	});	
}
function RefreshimagecollectionCountinit0()
{
	needimagecollection=false;
	$("input[name='imagecollection']").iCheck("check",null);
	
	$(".h-searchbox-sfqtitle").each(function(i){
		var count1= $(".h-searchbox-sfqtitle").eq(i).next(".h-searchbox-sfqcontentparent").find("input:checked").length;
		var count2= $(".h-searchbox-sfqtitle").eq(i).next(".h-searchbox-sfqcontentparent").find("input").length;
		$(".h-searchbox-sfqtitle").eq(i).find("font").eq(0).html(count1);
		$(".h-searchbox-sfqtitle").eq(i).find("font").eq(1).html(count2);
		if(count1!=count2)
			needimagecollection=true;
	});	
}

