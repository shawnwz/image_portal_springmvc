function myAlert(e){dialogAlert({bSuccess:!0,message:e,open:function(){}})}function myAlert(e,t){dialogAlert({bSuccess:!0,message:e,close:t})}function myConfirm(e,t,n,r){var i={title:r,message:e,Ok:t,Cancel:n};dialogConfirm(i)}function myPanel(e,t,n,r,i){var s={title:e,html:t,id:n,open:r,close:i};dialogPannel(s)}function myAjaxPanel(e,t,n,r,i){var s={title:e,url:t,id:n,open:open,close:i};dialogAjaxPannel(s)}function closeDialog(e){$("#ww-commons-dialog-"+e).dialog("close")}function removeDialog(e){$("#ww-commons-dialog-"+e).dialog("destroy")}function dialogAlert(e){$("#ww-commons-dialog-alert",$(document.body)).length>0||$(document.body).append('<div id="ww-commons-dialog-alert" style="display:none;" title="提示"><div class="dialog_cont_450"><div class="dialog_t"><p class="d_t_bar_ccenter" id="my-ww-dilog-alert-msg"></p></div><div class="dialog_op"><input id="my-ww-dilog-alert-confirm" type="button" class="dialog_btn_1" value="确认"></div></div></div>'),$("#ww-commons-dialog-alert").dialog({bgiframe:!0,resizable:!1,autoOpen:!1,width:"auto",modal:!0,draggable:!1}),e.message!=undefined&&$("#my-ww-dilog-alert-msg").html(e.message),e.open&&typeof e.open=="function"&&$("#ww-commons-dialog-alert").one("dialogopen",e.open),e.close&&typeof e.close=="function"&&$("#ww-commons-dialog-alert").one("dialogclose",e.close),$("#ww-commons-dialog-alert").dialog("open");if(!$.support.leadingWhitespace){var t=$("#ww-commons-dialog-alert").parent();t.width(450);var n=$(window).width(),r=$(window).height(),i=$(document).scrollTop(),s=(n-t.width())/2,o=(r-t.height())/2+i;t.css("left",s+"px"),t.css("top",o+"px")}$("#my-ww-dilog-alert-confirm").one("click",function(){e.Cancel&&typeof e.Cancel=="function"&&e.Cancel(),closeDialog("alert")})}function dialogConfirm(e){var t=e.title!=undefined&&e.title!=""?e.title:"确认";$("#ww-commons-dialog-confirm",$(document.body)).length>0||$(document.body).append('<div id="ww-commons-dialog-confirm" style="display:none" title="'+t+'"><div class="dialog_cont_450"><div class="dialog_t"><p class="d_t_bar_ccenter" id="my-ww-dilog-confirm-msg"></p></div><div class="dialog_op"><input id="my-ww-dilog-confirm-cancel" type="button" class="dialog_btn_2" value="取消"><input id="my-ww-dilog-confirm-confirm" type="button" class="dialog_btn_1" value="确认"></div></div></div>'),$("#ww-commons-dialog-confirm").dialog({resizable:!1,autoOpen:!1,width:"auto",modal:!0}),e.message!=undefined&&$("#my-ww-dilog-confirm-msg").html(e.message),e.open&&typeof e.open=="function"&&$("#ww-commons-dialog-confirm").one("dialogopen",e.open),e.close&&typeof e.close=="function"&&$("#ww-commons-dialog-confirm").one("dialogclose",e.close),$("#ww-commons-dialog-confirm").dialog("open");if(!$.support.leadingWhitespace){var n=$("#ww-commons-dialog-confirm").parent();n.width(450);var r=$(window).width(),i=$(window).height(),s=$(document).scrollTop(),o=(r-n.width())/2,u=(i-n.height())/2+s;n.css("left",o+"px"),n.css("top",u+"px")}$("#my-ww-dilog-confirm-confirm").one("click",function(){e.Ok&&typeof e.Ok=="function"&&e.Ok(),closeDialog("confirm")}),$("#my-ww-dilog-confirm-cancel").one("click",function(){e.Cancel&&typeof e.Cancel=="function"&&e.Cancel(),closeDialog("confirm")})}function dialogPannel(e){if(e.id==undefined||e.id==""){myAlert("必须定义弹窗的id参数！");return}if(!($("#ww-commons-dialog-"+e.id,$(document.body)).length>0)){var t='<div id="ww-commons-dialog-'+e.id+'" style="display:none;" title="'+e.title+'"><div id="ww-commons-dialog-panle-html-'+e.id+'"></div></div>';$(document.body).append(t)}$("#ww-commons-dialog-"+e.id).dialog({bgiframe:!0,resizable:!1,autoOpen:!1,width:"auto",modal:!0}),typeof e.html=="object"?$("#ww-commons-dialog-panle-html-"+e.id).append(e.html.show()):$("#ww-commons-dialog-panle-html-"+e.id).html(e.html),e.open&&typeof e.open=="function"&&$("#ww-commons-dialog-"+e.id).one("dialogopen",e.open),e.close&&typeof e.close=="function"&&$("#ww-commons-dialog-"+e.id).one("dialogclose",e.close),$("#ww-commons-dialog-"+e.id).dialog("open");if(!$.support.leadingWhitespace){var n=$("#ww-commons-dialog-panle-html-"+e.id).width()>755?755:$("#ww-commons-dialog-panle-html-"+e.id).width(),r=$("#ww-commons-dialog-panle-html-"+e.id+">div:first").width(),i;r!=undefined?i=r:i=n;var s=$("#ww-commons-dialog-"+e.id).parent();s.width(i+40),$("#ww-commons-dialog-panle-html-"+e.id).height($("#ww-commons-dialog-panle-html-"+e.id).height()+1);var o=$(window).width(),u=$(window).height(),a=$(document).scrollTop(),f=(o-s.width())/2,l=(u-s.height())/2+a;s.css("left",f+"px"),s.css("top",l+"px")}}function dialogAjaxPannel(e){if(e.url==undefined||e.url==""){myAlert("必须定义弹窗的获取内容的URL参数！");return}if(e.id==undefined||e.id==""){myAlert("必须定义弹窗的id参数！");return}e.html="",$.ajax({url:e.url+"?&r="+Math.floor(Math.random()*1e3+1),cache:!1,async:!1,dataType:"html",success:function(t){e.html=t}}),dialogPannel(e)}function startLoading(){$("#ww-waiting-loading",$(document.body)).length>0?$("#ww-waiting-loading").show():$(document.body).append('<div id="ww-waiting-loading"><div class="drop_cont_ceng"></div><div class="load"></div><div class="load_txt">数据加载中，请稍等.......</div></div>'),$("#ww-waiting-loading div").css("position","fixed");var e=$(".load"),t=$(".load_txt"),n=$(window).width(),r=$(window).height(),i=(n-e.width())/2,s=(r-e.height())/2;e.css("top",s+"px"),e.css("left",i+"px"),t.css("top",s+"px"),t.css("left",(n-t.width())/2+"px"),Global_JsAcitve=!1}function endLoading(){$("#ww-waiting-loading").hide(),Global_JsAcitve=!0}var Global_JsAcitve=!0

jQuery(function($){   
    $.datepicker.regional['zh-CN'] = {   
       clearText: '清除',   
       clearStatus: '清除已选日期',   
       closeText: '关闭',   
       closeStatus: '不改变当前选择',   
       prevText: '<上月',   
       prevStatus: '显示上月',   
       prevBigText: '<<',   
       prevBigStatus: '显示上一年',   
       nextText: '下月>',   
       nextStatus: '显示下月',   
       nextBigText: '>>',   
       nextBigStatus: '显示下一年',   
       currentText: '今天',   
       currentStatus: '显示本月',   
       monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],   
       monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二'],   
       monthStatus: '选择月份',   
       yearStatus: '选择年份',   
       weekHeader: '周',   
       weekStatus: '年内周次',   
       dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],   
       dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],   
       dayNamesMin: ['日','一','二','三','四','五','六'],   
       dayStatus: '设置 DD 为一周起始',   
       dateStatus: '选择 m月 d日, DD',   
       dateFormat: 'yy-mm-dd',   
       firstDay: 1,   
       initStatus: '请选择日期',   
       isRTL: false,
       showMonthAfterYear: true};   
       $.datepicker.setDefaults($.datepicker.regional['zh-CN']);   
   });  