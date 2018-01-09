var searchUrl="search2";



$(document).ready(function(){
	
	if(typeof documentReadyAdv!="undefined"&&documentReadyAdv)
	{
		documentReadyAdv();
	}
	if(typeof leftDocumentReady!="undefined"&&leftDocumentReady)
	{
	leftDocumentReady();
	}
	
	if(typeof InitLeftCheckBox!="undefined"&&InitLeftCheckBox)
	{
		InitLeftCheckBox();
	}
	$("#q").keydown(function(event){
		var keyCode = event.keyCode;
		if(keyCode==13){
			if(true)
				goToSearchPage();
		}
	});
});

function goToSearchPage(){
	if(typeof GetFormResultAdv!="undefined"&&GetFormResultAdv)
	{
	GetFormResultAdv($("#advform"));
    }
	var paras="";
	if(setPageHash)
	{
		paras=setPageHash();
	}
	location.href=searchUrl+paras;
}

function setPageHash(){
	reqParas = {};
	reqParas['key'] = $("#q").val();
	var hashStr = "#";
	var q = $("#q").val();
	if(q && q.length>0){
		hashStr += "q="+encodeURIComponent(q)+"&";
	}
	try{
		if(leftArr){
			$.each(leftArr,function(i,n){
				hashStr += i+"="+n+"&";
			});
		}
	}catch(e){}
	try{
		if(advArr){
			$.each(advArr,function(i,n){
				hashStr += i+"="+n+"&";
				if(i=='in'){
					reqParas['ins'] = n;
				}
			});
		}
	}catch(e){}
	return hashStr;
}
