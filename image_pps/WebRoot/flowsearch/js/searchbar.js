/**
 * 
 */

$(document).ready(function() {
	$("#q").keydown(function(event){
		var keyCode = event.keyCode;
		if(keyCode==13){
			appendKeywords();
			location.href=$("#q").next("a").attr("href");
		}
	});
	$("#q").next("a").click(function(){
		appendKeywords();
	 });
	
	function appendKeywords(){
	    var searchUrl = $("#q").next("a").attr("href");
		searchUrl=searchUrl+"&q="+encodeURIComponent($("#q").val());
		$("#q").next("a").attr("href",searchUrl);
	}
});