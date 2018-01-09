/**
 * @author 高顺德
 * */
function Submit(){
	var startTime=0;
	var endTime=0;
	var rgexpText;
	this.getTime=function(){
			return (new Date()).valueOf(); 
		};
	this.setStartTime=function(){
		startTime=this.getTime();
		return this;
	};
	this.getSubmitTime=function(){
		var ti = parseFloat(this.getTime())- parseFloat(startTime);
		alert("this.getTime()"+this.getTime()+"\r\n"+"startTime"+startTime);
		return ti;
	};
	this.check=function(value,rgexpText){
		this.rgexpText=rgexpText;
		if(rgexpText.exec(value)!=null)
			return true;
		return false;
	};
	this.fn=this.prototype;
};

//声明
var submitObj=new Submit();