/*
 * cur当前页。
 * total总也
 * callback=function(gotoPagenum){
 * 
 * 
 * }
 * 
 * 使用方法
 * $("div.fenye").pageing(1,35,function(p){
 * 	$(".contxxx").remove();//empty();
 *  $.post(xx,{p:p},function(data){
 *    data to html append to $(".contxxx");
 *  
 *  });
 * 
 * });
 * 
 * 
 * 
 * 
 * */

(function($) {
$.fn.pageing=function(cur,total,callback)
{
	var that=$(this);
	//0,... 1:show 2 notshow 3 show and active.
	var canshow=function(i,p,t){
		p=parseInt(p);
		t=parseInt(t);
		i=parseInt(i);
		
		if(i==p) return 3;
		if(i==1) return 1;
		if(i==t) return 1;
		if(i==p-1) return 1;
		if(i==p+1) return 1;
		if(p==1&&i<=3) return 1;
		if(p==t&&i>=t-2) return 1;
		return 2;
	}
	var goPage=function(p){
		if(p<1) return;
		if(p>total) return;
		
		that.empty();
		var html="";
		
		html+='<a class="changePage goto" page="'+(parseInt(p)-1)+'" href="javascript:;">上一页</a>';
		for(var i = 1;i<=total;i++)
		{
			var v=canshow(i,p,total);
			if(v==1)
				html+='<a class="goto" page='+i+'  href="javascript:;">'+i+'</a>';
			else if(v==3)
				html+='<a class="goto active" page='+i+'  href="javascript:;">'+i+'</a>';
		}
		html+='<a class="changePage goto" page="'+(parseInt(p)+1)+'" href="javascript:;">下一页</a>';
		//add dot dot dot . 
		var hhtml=$(html);
		var index=1;
		hhtml.each(function(){
			if($(this).hasClass("changePage")) return;
			var ip=$(this).attr("page")
			ip=parseInt(ip);
			if(ip&&ip>1&&ip<=total)
			{
				if(index<ip-1)
					$(this).attr("needdot",1);
				index=ip;
			}
		});
		that.append(hhtml);
		that.find("a.goto[needdot=1]").before('<a class="" href="javascript:;">...</a>');
		//dot end . 
		
		that.find("a.goto").unbind("click");
		that.find("a.goto").click(function(){
			p=$(this).attr("page");
			goPage(p);
			if(callback&&typeof callback=="function")
			{
				if(p<1) return;
				if(p>total) return;
				callback(p);
			}
		});
	};
	goPage(cur);

};

$.fn.mpageing=function(cur,total,callback)
{
	var that=$(this);

	var goPage=function(p){
		if(p<1) return;
		if(p>total) return;
		
		that.empty();
		var html="";
		html+=' <a href="javascript:void(0)" class="btnPrev icon-font icon-1-arrowLeft prev goto" page="'+(parseInt(p)-1)+'"></a>';
		html+='                <input class="targetNum" name="pageNo_sm" type="text" value="'+p+'">';
		html+=' <a href="javascript:void(0)" class="btnNext next goto"  page="'+(parseInt(p)+1)+'">';
		html+='   			   <span class="fanye_left">/ '+total+' </span>';
		html+='				   <span class="fanye_right SiYuan-ExtraLight">下一页</span>';
		html+='	</a>';
    
		var hhtml=$(html);
		that.append(hhtml);
		
		
		that.find("a.goto").unbind();
		that.find("a.goto").click(function(){
			p=$(this).attr("page");
			goPage(p);

			if(callback&&typeof callback=="function")
			{
				if(p<1) return;
				if(p>total) return;
				callback(p);
			}
		});
		that.find("input[name=pageNo_sm]").unbind();
		that.find("input[name=pageNo_sm]").keyup(function(){
			if(event&&event.keyCode==13)
				{
					p=that.find("input[name=pageNo_sm]").val();
					goPage(p);

					if(callback&&typeof callback=="function")
					{
						if(p<1) return;
						if(p>total) return;
						callback(p);
					}
			    }
		});
	};
	goPage(cur);
};

})(window.jQuery || window.Zepto);