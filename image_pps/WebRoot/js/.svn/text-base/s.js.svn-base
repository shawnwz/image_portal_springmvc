
var isPageChange=0;var startTime=0;function getTime(){return(new Date()).valueOf();}
function start(){startTime=getTime();$("#timer").html("");}
function stop(name){var ti=getTime()-startTime;var na=name?name:"";var str=na+":"+ti;if($("#timer").html()!="")
str="|"+str;$("#timer").append(str);$("#pageSize").html(n);}
var n=50;var p=1;var tp=0;var searchSID;var reqParas={};var smid;var currentData;var pageSizeArray=[25,50,100,200];var showType=1;var sortType=0;var isShowBigImage=true;var isShowInputHelper=true;var isPullStyle=1;var PullStylePages=5;var PullStylePagesIndex=0;var PullStyleCanLoadMore=true;var cla;var groupId;var spl;var vcdId;$(document).ready(function(){if(documentReadyAdv){documentReadyAdv();}
leftDocumentReady();setPageDefault();search();InitScorllEvent();window.onhashchange=doHistory;});$(window).keydown(function(event){var keyCode=event.keyCode;if(keyCode==13){if($("#q").is(":focus")){resetPara();search();}else if($("#p").is(":focus")){go2Page($("#p"));}else if($("#p2").is(":focus")){go2Page($("#p2"));}}else if(keyCode==37||keyCode==39){if(!$("#q").is(":focus")&&!$("#p").is(":focus")&&!$("#p2").is(":focus")){PullStylePagesIndex=PullStylePages;if(keyCode==37){}else{}}}});function doHistory(){if(isPageChange==0)
{setPageDefault();trueSearch();}
else
{isPageChange=0;}}
function resetPara(){genSearchSID();smid="";p=1;hideClearword();groupId=0;spl="";vcdId=0;}
function setPageDefault(){genSearchSID();var allVars=getUrlArgs();if(InitLeftCheckBox){InitLeftCheckBox(allVars);}
try{$("#q").val(decodeURIComponent(allVars['q']||''));}catch(e){$("#q").val($.cookie('q')||'');}
smid=allVars['smid']||'';if($("#q").val()!=''&&smid!='0'){smid='';}
cla=allVars['cla']||'';groupId=allVars['groupId']||0;spl=allVars['spl']||'';vcdId=allVars['vcdId']||0;p=allVars['p']||p;$("#p").val(p);$("#p2").val(p);n=$.cookie('pageSize')||n;for(i=0;i<pageSizeArray.length;i++){if(pageSizeArray[i]==n){checkbutton('menuadd','a',''+i);}}
showType=$.cookie('showType')||showType;checkbutton('menup','a',''+showType);if(setPageType)
setPageType(showType);initShowPreview();initPullStyle();initSortType();initInputHelper();}
function setHash(){reqParas={};reqParas['key']=$("#q").val();reqParas['n']=n;reqParas['ssid']=searchSID;var hashStr="#";var q=$.trim($("#q").val());if(q&&q.trim().length>0){hashStr+="q="+encodeURIComponent(q)+"&";if(smid!='0'){smid='';}}else if(smid&&smid!=''&&smid!='0'){hashStr+="smid="+smid+"&";}
if(smid&&smid=='0'){hashStr+="smid="+smid+"&";}
if(cla&&cla!=''){hashStr+="cla="+cla+"&";}
if(groupId){hashStr+="groupId="+groupId+"&";}
if(spl&&spl!=''){hashStr+="spl="+spl+"&";}
if(vcdId){hashStr+="vcdId="+vcdId+"&";}
try{if(leftArr){$.each(leftArr,function(i,n){hashStr+=i+"="+n+"&";});}}catch(e){}
try{if(advArr){$.each(advArr,function(i,n){hashStr+=i+"="+n+"&";if(i=='in'){reqParas['corbisIds']=n;}else if(i=='photographer'){reqParas['photographerName']=n;}else if(i=='location'){reqParas['locationName']=n;}else if(i=='dateCreated'){reqParas['photoDate']=n;}
else if(i=='provider'){reqParas['providerName']=n;}});}}catch(e){}
hashStr+="p="+p;location.hash=hashStr;var num=0;for(var each in reqParas){num++;}
if(hashStr.indexOf('&')<0&&num<=3){reqParas['index']=1;}
if(sortType&&sortType>0){reqParas['sortType']=sortType;}
if(smid&&smid!=''){reqParas['sortType']=4;}}
function search(){isPageChange=1;trueSearch();}
function trueSearch()
{$(".fullbackbox").hide();$(".divforselect").hide();PullStylePagesIndex++;start();setHash();$.cookie('q',$("#q").val());var url=location.pathname+".do";var paras=location.hash;if(paras){paras="?"+paras.substring(1);}
PullStyleCanLoadMore=false;startLoading();$.ajax({type:"POST",url:url+paras,data:reqParas,dataType:"json",success:function(data){$(".divforerror").hide();endLoading();if(data.success){currentData=data;setPageNum();if(data.total>0){showImageList();if(data.claList&&data.claList.length>0){showClearTips();showClearword();}else{hideClearword();}}else{onSearchErrorEvent("result is empty!");}
if(data.sand!=undefined&&data.sand>0)
{showkeynote();}
if(CanEmptyListScrollTop()==0){$('body,html').animate({scrollTop:0},300);}}else{onSearchErrorEvent("search failed; data error");}
setTimeout(function(){PullStyleCanLoadMore=true;},1000);if(hiddensearchadv)
hiddensearchadv();},failed:function(){endLoading();onSearchErrorEvent("search failed;system exception");setTimeout(function(){PullStyleCanLoadMore=true;},1000);}});}
function onSearchErrorEvent(msg)
{$(".groupDetailsContainer").hide();$("#picbox_center").empty();$("#picbox_center").append($(".divforerror").clone());$("#picbox_center .divforerror .msg").html(msg);$("#picbox_center .divforerror").show();$(document).scrollTop();}
function setPageNum(){if(currentData){tp=currentData.totalPages;p=currentData.currentPage;$(".tp_class").html(tp);$(".p_class").val(p);var totalformated=parseFloat(currentData.total).toLocaleString();if(currentData.total>=1000000)
totalformated="1,000,000+";$("#searchNum").html(''+totalformated);$("#searchResultKey").html(''+$("#q").val());}}
function prevPage(){isPageChange=1;if(p>1){p--;search();}}
function nextPage(){isPageChange=1;if(p<tp){p++;search();}}
function go2Page(item){var toPage=item.val();if(toPage<1)
toPage=1;if(toPage>tp)
toPage=tp;p=toPage;search();}
function setPageSize(pageSize){if(isPullStyle==0)
return false;n=pageSize;$.cookie('pageSize',pageSize);var boxid="addstyle";boxhidden(boxid);$("#"+boxid).parent().css("z-index","20");search();return true;}
function setPageType(showTypeValue){if(showTypeValue||showTypeValue==0){showType=showTypeValue;$.cookie('showType',showTypeValue);boxhidden('addstyle')
checkbutton('menup','a',showTypeValue);if(showTypeValue==0)
changeclassname('picbox_center','picbox-notext');else if(showTypeValue==1)
changeclassname('picbox_center','picbox-center');else if(showTypeValue==2)
changeclassname('picbox_center','picbox-list');return true;}
return false;}
function showImageList(){setShow();}
var CurDataArray=new Array();function setShow(){stop("ajax");var data=currentData.data;$("#simimage").empty();if(currentData.simUrl){$("#simimage").append('<a href="image/'+currentData.simId+'" target="_blank"><img src="'+currentData.simUrl+'" style="max-width: 50px;max-height: 40px;"/></a>');}
if(CanEmptyListEmpty()==0)
{$("#picbox_center").empty();CurDataArray=new Array();}
var str="";for(i=0;i<data.length;i++){var eles=data[i];CurDataArray["image"+eles.id]=eles;var rf=eles.licenseType&&eles.licenseType==2?"RM":"RF";str+='<div class="picbox-picbox" id="divimage'
+eles.id
+'" gpid="'+eles.corbisId+'" imageid="'+eles.id+'">'
+'<div id="bigdivimage'
+eles.id
+'" class="bigimagediv"><div class="bigdivimagediv">'
+'</div>'
+'<div id="addsearchimage'
+eles.id
+'" class="bigimageaddsearch"><a class="mlt_link" href="javascript:void(0);" onclick="FindSameImage(\''+eles.corbisId+'\');">更多相似图片</a></div></div>'
+'<div class="picbox-picbox-inner" >'+'<a href="image/'
+eles.corbisId+'" target="_blank" class="imagelink170"><img  id="minimage'
+eles.id+'" onerror="this.src=\'images/default.png\'" src="'+eles.imageHost+'THUMBNAIL/'+eles.path
+'" /></a>'+'</div>';str+='<p><b>'+rf+'</b>';if(spl==''&&eles.corbisId.substring(0,3)=='SPL'){str+='<span style="float: right;background-image: url(../images/iconTotal.png);background-repeat: no-repeat;">&nbsp; &nbsp; &nbsp;'+eles.splashNum+'</span>'}
else{if(eles.isInCd)
str+='<i class="pic-button4"></i>';if(eles.isInImageSet)
str+='<i class="pic-button7"></i>';str+='<i class="pic-button8" onclick="LightBox($(this));" title="添加到灯箱"></i>';str+='<i class="pic-button5 on" onclick="FindSameImage(\''+eles.corbisId+'\');" title="更多相似图片"></i>';if(eles.priType==0){str+='<i class="pic-button6 on" onclick="DownloadImage(\''+eles.corbisId+'\');" title="下载"></i>';}else if(eles.priType==3){str+='<i class="pic-button1 on" onclick="DownloadImageSepc(\''+eles.corbisId+'\');" title="旗帜"></i>';}}
str+='<br />'+eles.scn+'<br />'+eles.collectionName+'<br />';str+=eles.corbisId+'';if(eles.pricing&&eles.pricing!='')
str+='<span style="float: right;">['+eles.pricing+']</span><br/>';str+='<br/>';str+='</p>';str+='<div class="picbox-pictext"><div>';if(eles.title&&eles.title.length>0)
str+=eles.title+'<br>';if(eles.caption&&eles.caption.length>0)
str+=eles.caption+'<br>';str+='<b>图片库: </b>'+eles.collectionName+'<br><br>';if(eles.photoDate&&eles.photoDate.length>0)
str+='<b>拍摄日期: </b>'+eles.photoDate+'<br><br>';if(eles.location&&eles.location.length>0)
str+='<b>地点: </b>'+eles.location+'<br><br>';str+='<b>肖像权同意书: </b>'+eles.modelRelease+'<br><b>';str+='产权同意书: </b>'+eles.propertyRelease+'<br><br>';if(eles.restrictionList.length>0)
{str+='<font style="background:url(\'images/warn_ico.png\') no-repeat 0 center;padding-left: 20px;">Restrictions</font><br>';$.each(eles.restrictionList,function(i,n){str+='•    '+n+'';});}
str+='</div></div>';str+='</div>';if((i+1)%25==0)
{$("#picbox_center").append(str);str="";}}
$("#picbox_center").append(str);str="";stop("apend");$("#picbox_center .picbox-picbox ").unbind();$("#picbox_center .picbox-picbox ").mouseleave(function(){hidebigimg("image"+$(this).attr("imageid"));});$("#picbox_center .picbox-picbox .bigimagediv").unbind();$("#picbox_center .picbox-picbox .bigimagediv").mouseenter(function(){showbigimg("image"+$(this).closest(".picbox-picbox").attr("imageid"));});$("#picbox_center .picbox-picbox .imagelink170 img").unbind();$("#picbox_center .picbox-picbox .imagelink170 img").mouseenter(function(){showbigimg("image"+$(this).closest(".picbox-picbox").attr("imageid"));});stop("event");if(typeof setDivLightOn!='undefined'||!setDivLightOn)
setDivLightOn();stop("total");if(currentData&&currentData.groupId)
{tag_change('piclist','piclisttag','1','2');$(".forleftfilter").hide();refreshlightbox();$(".groupDetailsContainer .setstitle").html(currentData.groupName);$(".groupDetailsContainer .setsid").html(currentData.groupId);$(".groupDetailsContainer .setsCount").html(currentData.total);$(".groupDetailsContainer .setsdate").html(currentData.createTime);$(".groupDetailsContainer .setslocation").html(currentData.location);$(".groupDetailsContainer input").attr("groupid",currentData.groupId);if(currentData.photographer)
{$(".groupDetailsContainer .setsphotographor").html(currentData.photographer);$(".groupDetailsContainer .setsphotographorinfos").show();}
else
{$(".groupDetailsContainer .setsphotographorinfos").hide();}
$(".groupDetailsContainer").show();}else
{$(".groupDetailsContainer").hide();$(".forleftfilter").show();tag_change('piclist','piclisttag','0','2');}}
function CanEmptyListScrollTop()
{if(isPullStyle==1)
return 0;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==1)
return 0;return 1;}
function CanEmptyListEmpty()
{if(isPullStyle==1)
return 0;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==1)
return 0;return 1;}function CanEmptyListPaging()
{if(isPullStyle==1)
return 0;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==0)
return 0;return 1;}
function CanEmptyListNeedLoadMore()
{if(isPullStyle==1)
return 1;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==0)
return 1;return 0;}
function CanEmptyList2del()
{if(isPullStyle==1)
return 0;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==0)
return-1;if(isPullStyle==0&&(PullStylePagesIndex)%PullStylePages==1)
return 0;}
function FindSameImage(imageid){window.open("search#smid="+imageid+"&p=1","_blank");}
function genSearchSID(){searchSID=(new Date()).valueOf();PullStylePagesIndex=PullStylePages;}
function getUrlArgs(){var args={};var query=location.hash.substring(1);var pairs=query.split("&");for(var i=0;i<pairs.length;i++){var pos=pairs[i].indexOf('=');if(pos==-1)
continue;var argname=pairs[i].substring(0,pos);var value=pairs[i].substring(pos+1);args[argname]=value;}
return args;}
function showClearword(){if(!currentData||!currentData.claList)
return;$(".searchimformationboxlistdiv").empty();if(currentData.claList[0]){$(".searchimformationboxlistdiv").append('<label><b>'+currentData.claList[0].name
+'</b></label><br/>');}
$(".searchimformationboxlistdiv").append('<div class="icheckbox_minimal-aero"><input name="checkany" value="" type="checkbox"/><ins class="iCheck-helper" ></ins></div><label>任何</label><br/>');var selectedCla=cla||"";for(i=0;i<currentData.claList.length;i++){$(".searchimformationboxlistdiv").append('<div class="icheckbox_minimal-aero"><input name="" value="'+currentData.claList[i].id
+'" type="checkbox"/><ins class="iCheck-helper" ></ins></div><label>'
+currentData.claList[i].items+'</label><br/>');}
var searchimformationboxlistmarginbuttom=-20*(currentData.claList.length-1)-180;$("#searchimformationboxlist").css("margin-bottom",searchimformationboxlistmarginbuttom);$('#searchimformationboxlist input').iCheck({checkboxClass:'icheckbox_minimal-aero',radioClass:'iradio_minimal-aero',increaseArea:'20%',fathertag:'#searchimformationboxlist'},function(item){},function(item){if(item[0].name=="checkany"){if(item[0].checked)
$(".searchimformationboxlistdiv input").not(item).iCheck("uncheck",null);}else{$(".searchimformationboxlistdiv input[name='checkany']").iCheck("uncheck",null);if($(".searchimformationboxlistdiv input:checked").not($(".searchimformationboxlistdiv input[name='checkany']")).length==$(".searchimformationboxlistdiv input").not($(".searchimformationboxlistdiv input[name='checkany']")).length){$(".searchimformationboxlistdiv input[name='checkany']").iCheck("check",null);$(".searchimformationboxlistdiv input").not($(".searchimformationboxlistdiv input[name='checkany']")).iCheck("uncheck",null);}}});{var values=selectedCla.split(",");$.each(values,function(i,n){$(".searchimformationboxlistdiv input[value='"
+n+"']").iCheck("check",null);});$("#clearLink").show();}}
function hideClearword(){cla="";$("#clearLink").hide();}
function submitclearword(){var ids='';$('.searchimformationboxlistdiv input:checked').each(function(i,n){ids+=n.value+',';});if(ids.length>0){ids=ids.substring(0,ids.length-1);}
cla=ids;boxhidden('searchimformationboxlist');genSearchSID();search();}
function showClearTips(){var sf=$.cookie('sf');if(!sf){boxshowkeepfornote('searchimformationbox');}}
function hiddenClearTips(){$.cookie('sf',"1");boxhidden('searchimformationbox');}
function showkeynote(){var sf=$.cookie('kn');if(!sf){boxshowkeepfornote('searchimformationboxkeynote');}}
function hiddenkeynote(){$.cookie('nk',"1");boxhidden('searchimformationboxkeynote');}
function showinputhelper(){var sf=$.cookie('ih');if(!sf||sf==1){boxshow('searchimformationboxinputhelper');}}
function hiddeninputhelper(){boxhidden('searchimformationboxinputhelper');}
function initInputHelper(){var sf=$.cookie('ih');if(!sf){$.cookie('ih',1);sf=1;}
$(".menushow-yulan input[name='caninputhelper']").iCheck("uncheck",null);$(".menushow-yulan input[name='caninputhelper']").iCheck("check",null);if(sf==1)
$(".menushow-yulan input[name='caninputhelper']").iCheck("check",null);else
$(".menushow-yulan input[name='caninputhelper']").iCheck("uncheck",null);isShowInputHelper=($(".menushow-yulan input[name='caninputhelper']:checked").length==1);}
function setInputHelper(v){if(v!=undefined)
{if(v==1)
{$.cookie('ih',1);$(".menushow-yulan input[name='caninputhelper']").iChceck("check");}else
{$.cookie('ih',0);$(".menushow-yulan input[name='caninputhelper']").iChceck("uncheck");}}
else
{$.cookie('ih',$(".menushow-yulan input[name='caninputhelper']:checked").length);isShowInputHelper=($(".menushow-yulan input[name='caninputhelper']:checked").length==1);var boxid="addstyle";boxhidden(boxid);$("#"+boxid).parent().css("z-index","20");}}
function initShowPreview(){var sf=$.cookie('sp');if(!sf){$.cookie('sp',1);sf=1;}
$(".menushow-yulan input[name='canpreview']").iCheck("uncheck",null);$(".menushow-yulan input[name='canpreview']").iCheck("check",null);if(sf==1)
$(".menushow-yulan input[name='canpreview']").iCheck("check",null);else
$(".menushow-yulan input[name='canpreview']").iCheck("uncheck",null);isShowBigImage=($(".menushow-yulan input[name='canpreview']:checked").length==1);}
function setShowPreview(){$.cookie('sp',$(".menushow-yulan input[name='canpreview']:checked").length);isShowBigImage=($(".menushow-yulan input[name='canpreview']:checked").length==1);var boxid="addstyle";boxhidden(boxid);$("#"+boxid).parent().css("z-index","20");}
function initSortType(){var sf=$.cookie('st');if(!sf){$.cookie('st',0);sf=0;}
setSelectwidget("sortType",sf);sortType=sf;}
function setSortType(){sortType=$("input[name='sortType']").val();$.cookie('st',sortType);PullStylePagesIndex=PullStylePages;genSearchSID();search();var boxid="addstyle";boxhidden(boxid);$("#"+boxid).parent().css("z-index","20");}
function initPullStyle(){var sf=$.cookie('ps');if(!sf){$.cookie('ps',1);sf=1;}
checkbutton('menulayor','a',sf);isPullStyle=sf;if(isPullStyle==0)
n=50;else
{n=$.cookie('pageSize')||n;for(i=0;i<pageSizeArray.length;i++){if(pageSizeArray[i]==n){checkbutton('menuadd','a',''+i);}}}}
function setPullStyle(v){var isChange=false;$.cookie('ps',v);isPullStyle=v;var boxid="addstyle";boxhidden(boxid);$("#"+boxid).parent().css("z-index","20");PullStylePagesIndex=0;if(isPullStyle==0)
n=50;else
{n=$.cookie('pageSize')||n;for(i=0;i<pageSizeArray.length;i++){if(pageSizeArray[i]==n){checkbutton('menuadd','a',''+i);}}}
search();}
function InitScorllEvent(){var scrolltop=$(document).scrollTop();var windowsheight=$(window).height();$(window).scroll(function(){scrolltop=$(document).scrollTop();windowsheight=$(window).height();var offset=$("#picbox_center .picbox-picbox").last().offset();var top=0;if(offset)
top=offset.top+$("#picbox_center .picbox-picbox").height();else
top=5000;if((windowsheight+scrolltop>=top)){AutoloadMore();}});}
function AutoloadMore(){if(isPullStyle!=0)
return;if(CanEmptyListNeedLoadMore()!=0)
return;if(PullStyleCanLoadMore){PullStyleCanLoadMore=false;nextPage();}}
function DownloadImage(elesid)
{location.href="dl/getImg.do?type=0&corbisId="+elesid;}
function DownloadImageSepc(elesid)
{location.href="dl/getImg.do?type=3&corbisId="+elesid;}