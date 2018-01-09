/*************************************
* 类似js的alert函数
* msg    显示的消息
*************************************/
function myAlert(msg) {
    dialogAlert({
        bSuccess: true,
        message: msg,
        open: function () {
        }
    });
}


function myAlert(msg,fun) {
    dialogAlert({
        bSuccess: true,
        message: msg,
        close:fun
    });
}

/*************************************
* 通用二次确认提示框
* msg    显示的消息
* ok     是一个函数委托,就是点击确认执行的方法
* cancel 是一个函数委托,可以为一个空函数,是点击关闭按钮执行的方法
* title  弹出框标题,可以为空,默认为'确认'
*************************************/
function myConfirm(msg, ok, cancel, title) {
    var options = { 'title': title, 'message': msg, 'Ok': ok, 'Cancel': cancel };
    dialogConfirm(options);
}
/*************************************
* 通用弹出面板
* title  标题,不能为空
* html   要展示的内容,支持HTML
* id     弹窗id,用于显示唯一和关闭
*************************************/
function myPanel(title, html, id, open, close) {
    var options = { 'title': title, 'html': html, 'id': id, 'open': open, 'close': close };
    dialogPannel(options);
}

function myAjaxPanel(title, url, id, ok, close) {
    var options = { 'title': title, 'url': url, 'id': id, 'open': open, 'close': close };
    dialogAjaxPannel(options);
}

/*************************************
* 关闭弹出面板
* id     需要关闭的弹窗id
*************************************/
function closeDialog(id) {
    //alert('www')
    $('#ww-commons-dialog-' + id).dialog('close');
    //$('#ww-commons-dialog-' + id).remove();
}

function removeDialog(id) {
    $('#ww-commons-dialog-' + id).dialog("destroy");
    //$('#ww-commons-dialog-' + id).remove();
}
function dialogAlert(options) {
    if (!($('#ww-commons-dialog-alert', $(document.body)).length > 0)) {
        $(document.body).append('<div id="ww-commons-dialog-alert" style="display:none;" title="提示"><div class="dialog_cont_450"><div class="dialog_t"><p class="d_t_bar_ccenter" id="my-ww-dilog-alert-msg"></p></div><div class="dialog_op"><input id="my-ww-dilog-alert-confirm" type="button" class="dialog_btn_1" value="确认"></div></div></div>');
    }
    $('#ww-commons-dialog-alert').dialog({
        bgiframe: true,
        resizable: false,
        autoOpen: false,
        width:'auto',
        modal: true,
        draggable:false
    });
    if (options.message != undefined) {
        $('#my-ww-dilog-alert-msg').html(options.message);
    }
	if (options.open && typeof options.open == 'function') {
        $('#ww-commons-dialog-alert').one('dialogopen', options.open);
    }
    if (options.close && typeof options.close == 'function') {
        $('#ww-commons-dialog-alert').one('dialogclose', options.close);
    }
    $('#ww-commons-dialog-alert').dialog('open');	

	if (!$.support.leadingWhitespace){
	    //$('.ui-dialog').width(450);
	    //var _name = 'ww-commons-dialog-alert';
	    //var _obj = $('div[aria-describedby="' + _name + '"]');
	    var _obj = $('#ww-commons-dialog-alert').parent();
	    _obj.width(450);
		var screenWidth = $(window).width();
		var screenHeight = $(window).height(); 
		var scrolltop = $(document).scrollTop();
		var left = (screenWidth - _obj.width()) / 2;
		var top = (screenHeight - _obj.height()) / 2 + scrolltop;
		_obj.css('left', left + 'px');
		_obj.css('top', top + 'px');
	}
    $('#my-ww-dilog-alert-confirm').one('click' ,function () {
        if (options.Cancel && typeof options.Cancel == 'function') {
            options.Cancel();
        }
        closeDialog('alert');
        
    });
};
function dialogConfirm(options) {
    var title = options.title != undefined && options.title != '' ? options.title : '确认';
    if (!($('#ww-commons-dialog-confirm', $(document.body)).length > 0)) {
        $(document.body).append('<div id="ww-commons-dialog-confirm" style="display:none" title="' + title + '"><div class="dialog_cont_450"><div class="dialog_t"><p class="d_t_bar_ccenter" id="my-ww-dilog-confirm-msg"></p></div><div class="dialog_op"><input id="my-ww-dilog-confirm-cancel" type="button" class="dialog_btn_2" value="取消"><input id="my-ww-dilog-confirm-confirm" type="button" class="dialog_btn_1" value="确认"></div></div></div>');
    }
    $('#ww-commons-dialog-confirm').dialog({
        resizable: false,
        autoOpen: false,
        width:'auto',
        modal: true
    });
    if (options.message != undefined) {
        $('#my-ww-dilog-confirm-msg').html(options.message);
    }
	if (options.open && typeof options.open == 'function') {
        $('#ww-commons-dialog-confirm').one('dialogopen', options.open);
    }
    if (options.close && typeof options.close == 'function') {
        $('#ww-commons-dialog-confirm').one('dialogclose', options.close);
    }
    $('#ww-commons-dialog-confirm').dialog('open');
	if (!$.support.leadingWhitespace){
	    //$('.ui-dialog').width(450);
	    var _obj = $('#ww-commons-dialog-confirm').parent();
	    _obj.width(450);
		var screenWidth = $(window).width();
		var screenHeight = $(window).height(); 
		var scrolltop = $(document).scrollTop();
		var left = (screenWidth - _obj.width()) / 2;
		var top = (screenHeight - _obj.height()) / 2 + scrolltop;
		_obj.css('left', left + 'px');
		_obj.css('top', top + 'px');
	}
    $('#my-ww-dilog-confirm-confirm').one('click' ,function () {
        if (options.Ok && typeof options.Ok == 'function') {
            options.Ok();
        }
        closeDialog('confirm');
    });
    $('#my-ww-dilog-confirm-cancel').one('click' ,function () {
        if (options.Cancel && typeof options.Cancel == 'function') {
            options.Cancel();
        }
        closeDialog('confirm');
    });
};
function dialogPannel(options) {
    if(options.id == undefined || options.id ==''){
        myAlert('必须定义弹窗的id参数！');
        return;
    }
    if (!($('#ww-commons-dialog-'+options.id, $(document.body)).length > 0)) {
        var _content = '<div id="ww-commons-dialog-' + options.id + '" style="display:none;" title="' + options.title + '"><div id="ww-commons-dialog-panle-html-' + options.id + '"></div></div>';
        $(document.body).append(_content);
    }
    $('#ww-commons-dialog-'+options.id).dialog({
        bgiframe: true,
        resizable: false,
        autoOpen: false,
        width:'auto',
        modal: true
    });
    if (typeof options.html === 'object') {
        $('#ww-commons-dialog-panle-html-' + options.id).append(options.html.show());
    } else {
        $('#ww-commons-dialog-panle-html-' + options.id).html(options.html);
    }
    if (options.open && typeof options.open == 'function') {
        $('#ww-commons-dialog-' + options.id).one('dialogopen', options.open);
    }
    if (options.close && typeof options.close == 'function') {
        $('#ww-commons-dialog-' + options.id).one('dialogclose', options.close);
    }
    $('#ww-commons-dialog-' + options.id).dialog('open');
	if (!$.support.leadingWhitespace){
	    //解决IE6-IE7不支持width:auto
	    var _width = $('#ww-commons-dialog-panle-html-' + options.id).width() > 755 ? 755 : $('#ww-commons-dialog-panle-html-' + options.id).width();
	    var _width2 = $('#ww-commons-dialog-panle-html-' + options.id + '>div:first').width();
	    var width;
	    if (_width2 != undefined) {
	        width = _width2;
	    } else {
	        width = _width;
	    }
	    var _obj = $('#ww-commons-dialog-' + options.id).parent();
	    _obj.width(width + 40);
		$('#ww-commons-dialog-panle-html-' + options.id).height($('#ww-commons-dialog-panle-html-' + options.id).height() + 1);
		var screenWidth = $(window).width();
		var screenHeight = $(window).height(); 
		var scrolltop = $(document).scrollTop();
		var left = (screenWidth - _obj.width()) / 2;
		var top = (screenHeight - _obj.height()) / 2 + scrolltop;
		_obj.css('left', left + 'px');
		_obj.css('top', top + 'px');
	}
}
function dialogAjaxPannel(options) {
    if (options.url == undefined || options.url == '') {
        myAlert('必须定义弹窗的获取内容的URL参数！');
        return;
    }
    if (options.id == undefined || options.id == '') {
        myAlert('必须定义弹窗的id参数！');
        return;
    }
    options.html = '';
    $.ajax({
        url: options.url+'?&r='+Math.floor(Math.random()*1000+1),
        cache: false,
        async: false,
        dataType:'html',
        success: function (ret) {
            options.html = ret;
        }
    });
    dialogPannel(options);
}
function startLoading() {
    if (!($('#ww-waiting-loading', $(document.body)).length > 0)) {
         $(document.body).append('<div id="ww-waiting-loading"><div class="drop_cont_ceng"></div><div class="load"></div><div class="load_txt">数据加载中，请稍等.......</div></div>');
    } else {
        $('#ww-waiting-loading').show();
    }
    $('#ww-waiting-loading div').css("position","fixed");
    
    
    var load = $('.load');
	var load_txt = $('.load_txt');
	
	
	var screenWidth = $(window).width();
	var screenHeight = $(window).height(); 
	//var scrolltop = $(document).scrollTop();
	var left = (screenWidth - load.width()) / 2;
	var top = (screenHeight - load.height()) / 2;
	load.css('top', top + 'px');
	load.css('left', left + 'px');
	load_txt.css('top', top + 'px');
	load_txt.css('left', (screenWidth - load_txt.width()) / 2 + 'px');
	Global_JsAcitve=false;
}
function endLoading() {
	//return ;
    $('#ww-waiting-loading').hide();
    Global_JsAcitve=true;
}

var Global_JsAcitve=true;

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
