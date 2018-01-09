var curLightBoxid = 0;
var curLightBoxItems = new Object();
var myCurLightBoxs = new Object();
// my用.
var myCurImageData = null;
var myCurDataImageArray = new Array();
var mylightboxpz = 25;
var mylightboxp = 1;

// var isShowBigImage = false; // 为了兼容
/* 灯箱操作. */

function AddNewLightBox(fidin) {
	var fid = 0;
	if (fidin)
		fid = fidin;
	// function myPanel(title, html, id, open, close)
	var html = '<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
			+ '<input id="lbNameField" type="text" maxlength="40" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " placeholder="请输入新灯箱名称">'
			+ '<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
			+ '<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
	myPanel("创建新灯箱", html, "AddNewLightBox", function() {
		$("#lbNameField").val("");
	}, null);
	$("#lightbox_save").unbind();
	$("#lightbox_cancel").unbind();
	$("#lightbox_save").bind("click", function() {
		// save ajax. and refresh.
		if ($("#lbNameField").val() == "") {
			myAlert("名称不能为空");
			return;
		}
		$.post("my/addlightbox", {
			name : $("#lbNameField").val(),
			key : fid,
			t : Math.random()
		}, function(data) {
			if (data && data.error == 0) {
				// myAlert("添加成功");
				if (data.data && data.data.id)
					curLightBoxid = data.data.id;
				refreshlightbox(true);
				closeDialog("AddNewLightBox");
			} else if (data && data.error == 401) {
				myAlert("需要登录", function() {
					closeDialog("AddNewLightBox");
				});
			} else {
				myAlert("添加失败");
			}

		});
	});

	$("#lightbox_cancel").bind("click", function() {
		// close
		closeDialog("AddNewLightBox");
	});
}

function refreshlightbox(force, callback) {
	if (curLightBoxid == 0 || force)
		$.post("my/getlightboxes", {
			t : Math.random()
		}, function(data) {
			if (data && data.error == 0 && data.data && data.data.length > 0) {
				if (curLightBoxid == 0)
					curLightBoxid = data.data[0].key;
				else {
					if ($.grep(data.data, function(i, n) {
						return n.key == curLightBoxid;
					}).length == 0)
						curLightBoxid = data.data[0].key;
				}
				$(".mylightbox-left .select-widget div").empty();
				$.each(data.data, function(i, n) {
					$(".mylightbox-left .select-widget div").append(
							'<a href="javascript:void(0);" value="' + n.key
									+ '"><p>' + n.value + '</p></a>');
				
				});
				selectwidget($(".mylightbox-left .select-widget"));
				setSelectwidget("nv_light_id", curLightBoxid);
				refreshlightboxitems();
				if (callback)
					callback();
			} else if (data && data.error == 401) {
				//myAlert("需要登录");
				//
			} else {
				myAlert("需要登录");
			}
		});
}

function refreshlightboxitems() {
	curLightBoxid = $(
			".mylightbox-left .select-widget input[name='nv_light_id']").val();
	if(curLightBoxid&&typeof(curLightBoxid)!="undefined")
	$.post(
					"my/getlightboxitems",
					{
						key : curLightBoxid,
						t : Math.random()
					},
					function(data) {
						if (data && data.error == 0 && data.data) {
							$(".picbox-picbox").removeClass("on");
							$(".picbox-picbox .pic-button8").removeClass("on");
							curLightBoxItems = data;
							$(".mylightbox-left-imgbox .jspPane").empty();
							$
									.each(
											data.data,
											function(i, n) {
												var item = n;
												if (data.map
														&& data.map[n.corbisId]) {
													var eles = data.map[n.corbisId];
													var rf =typeof(typeof(eles))!="undefined"&& eles.licenseType
															&& eles.licenseType == 2 ? "RM"
															: "RF";
													var html = '<div class="mylightbox-left-imgbox-box" value="'
															+ n.id
															+ '" boxid="'
															+ n.boxId
															+ '" gpid="'
															+ n.corbisId
															+ '">'
															+ '<div><a href="image/'+n.corbisId+'" target="_blank"><img src="'
															+ eles.imageHost
															+ 'THUMBNAIL/'
															+ eles.path
															+ '" /></a>'
															+ '</div><p><span>'+rf+'</span><i></i></p></div>';
													$(
															".mylightbox-left-imgbox .jspPane")
															.append(html);
												}
												// light;

											});
							$(
									".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box i")
									.unbind();
							$(
									".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box i")
									.click(
											function() {
												delLightBoxItem($(this)
														.parent().parent());
											});
							$('.mylightbox-left-imgbox').jScrollPane({
								animateScroll : true
							});
							// light right ;

							setDivLightOn();

						} else if (data && data.error == 401) {
							myAlert("需要登录");
						} else {
							myAlert("需要登录");
						}
					});
}

// /灯箱点亮或取消.
function LightBox(item) {
	var listitem = item.closest(".picbox-picbox");
	var gpid = listitem.attr("gpid");

	if (item.hasClass("on")) {
		// 移出灯箱的ajax
		var items = $(".mylightbox-left-imgbox .jspPane").find(
				".mylightbox-left-imgbox-box[gpid='" + gpid + "']");

		items.each(function() {
			var itemId = $(this).attr("value");
			delLightBoxItem($(this));
		});

		item.removeClass("on");
		item.closest(".picbox-picbox").removeClass("on");
		item.attr("title","添加到灯箱");
	} else {
		// 加入灯箱的ajax
		// callback:$(this).addClass("on");
		var afterall = function(data) {
			// light on .
			setDivLightOn();
		};
		var save = function() {
			addLightBoxItem(gpid, afterall);
		};
		if (!curLightBoxid || curLightBoxid <= 0) {
			selectLightBox(save);
		} else {
			save();
		}
		item.attr("title","从灯箱移除");
	}
}

function delLightBoxItem(item) {
	var id = item.attr("value");
	$.post("my/dellightboximages", {
		key : id
	}, function(data) {
		if (data && data.error == 0) {

			$(".picbox-picbox[gpid='" + item.attr("gpid") + "']").removeClass(
					"on");
			$(".picbox-picbox[gpid='" + item.attr("gpid") + "'] .pic-button8")
					.removeClass("on");

			item.remove();
			$('.mylightbox-left-imgbox').jScrollPane({
				animateScroll : true
			});

		} else if (data && data.error == 401) {
			myAlert("需要登录");
		} else {
			myAlert("需要登录");
		}
	});
}
function addLightBoxItemdetailpage(corbisId)
{
	var gpid = corbisId;
		var save = function() {
			addLightBoxItem(gpid, function(){
				$(".content_right ul #two").addClass("on");
				$(".content_right ul #two a").removeAttr("onclick");
			});
		};
		curLightBoxid=0;
		selectLightBox(save);
}
function addLightBoxItem(corbisId, callback) {
	// var id=id?id:$(this).parent().parent().attr("value");
	$.post("my/addlightboximages", {
		key : curLightBoxid,
		corbisId : corbisId
	}, function(data) {
		if (data && data.error == 0) {
			var n = data.data;
			var eles = data.map;
			var rf = typeof(eles)!="undefined"&&eles.licenseType
			&& eles.licenseType == 2 ? "RM"
			: "RF";
			var html = '<div class="mylightbox-left-imgbox-box" value="' + n.id
					+ '" boxid="' + n.boxId + '" gpid="' + n.corbisId + '" >'
					//+ '<div><a href="javascript:void(0);"><img src="'
					+ '<div><a href="image/'+n.corbisId+'" target="_blank"><img src="'
					+ eles.imageHost + 'THUMBNAIL/' + eles.path + '" /></a>'
					+ '</div><p><span>'+rf+'</span><i></i></p></div>';
			$(".mylightbox-left-imgbox .jspPane").append(html);
			if(curLightBoxItems&&curLightBoxItems.data)
				{
			curLightBoxItems.data.push(data.data);
			curLightBoxItems.map[corbisId] = data.map;
				}
			$(
					".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box[value='"
							+ n.id + "'] i").unbind();
			$(
					".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box[value='"
							+ n.id + "'] i").click(function() {
				delLightBoxItem($(this).parent().parent());
			});

			$('.mylightbox-left-imgbox').jScrollPane({
				animateScroll : true
			});
			if (callback)
				callback();
		} else if (data && data.error == 401) {
			myAlert("需要登录");
		} else {
			myAlert("需要登录");
		}
	});
}

function selectLightBox(callback) {
	tag_change('piclist', 'piclisttag', '1', '2');
	refreshlightbox(
			true,
			function() {
				$.post("my/getlightboxes",
								function(data2) {
									var option = '<select name="moveLightBoxtarget" id="moveLightBoxtarget" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " >';
									
									option += '</select><br>';
									var html = '<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
											+ option
											+ '<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
											+ '<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
									myPanel("请选择灯箱", html, "selectLightBox",
											function() {
												$("#moveLightBoxtarget")
														.val("");
											}, null);
									
									$.each(data2.data, function(i, n) {
										if(i==data2.data.length-1)
											$("#moveLightBoxtarget").append( '<option value="' + n.key
											+ '" selected="selected">' + n.value + '</option>');
										else
											$("#moveLightBoxtarget").append( '<option value="' + n.key
												+ '">' + n.value + '</option>');
									});
									
									
									$("#lightbox_save").unbind();
									$("#lightbox_cancel").unbind();
									$("#lightbox_save").bind(
											"click",
											function() {
												curLightBoxid = $(
														"#moveLightBoxtarget")
														.val();
												setSelectwidget("nv_light_id",
														curLightBoxid);
												closeDialog("selectLightBox");
												if (callback)
													callback();
											});
									$("#lightbox_cancel").bind("click",
											function() {
												closeDialog("selectLightBox");
											});
								});
			});
}

/* 灯箱操作.end */

/* my lightbox start */

function myrefreshlightbox(force) {
	if (curLightBoxid == 0 || force)
		$.post(
						"my/getlightboxeslist",
						{
							t : Math.random()
						},
						function(data) {
							if (data && data.error == 0 && data.data
									&& data.data.length > 0) {
								if (curLightBoxid == 0)
									curLightBoxid = data.data[0].id;
								else {
									if ($.grep(data.data, function(n) {
										return n.id == curLightBoxid;
									}).length == 0)
										curLightBoxid = data.data[0].id;
								}
								$(".MyLightboxes-left").empty();
								myCurLightBoxs=new Object();
								
								for ( var i = 0; i < data.data.length; i++) {
									var n = data.data[i];
									var sons = privateGetSonItems(data.data,
											n.id);
									myCurLightBoxs[n.id]=n;
									var html = '<div href="javascript:void(0);" onclick="mylightboxactive($(this));" value="'
											+ n.id
											+ '" level="'
											+ n.level
											+ '" fbox="'
											+ n.parentId
											+ '" class="boxitem " style="'
											+ (n.parentId > 0 ? "display:none;"
													: "")
											+ ' padding-left:'
											+ (n.level * 10)
											+ 'px">'
											+ '<div class="boxitemcontent">'
											+ '<div onclick="javascript:mylightboxToggleTree($(this).parent().parent());" class="Arrow" style="'
											+ ((sons.length > 0) ? ""
													: "display:none;")
											+ '"><img src="images/iconCaretCollapsed.gif"  style="'
											+ ((sons.length > 0) ? ""
													: "display:none;")
											+ '"/></div>'
											+ '<span>'
											+ privateGetLevelStr(n.level, ">")
											+ n.name
											+ '</span><br />'
											+ n.imageNum
											+ '个项目&nbsp;&nbsp;'
											+ sons.length
											+ '个灯箱<br />'
											+ '修改&nbsp;&nbsp;'
											+ getDateStr(n.updateTime)
											+ // 2014/01/01
											'<img src="images/iconDelete.gif" onclick="deleteLightBox(\''
											+ n.id
											+ '\',\''
											+ n.name
											+ '\')" />' + '</div></div>';
									$(".MyLightboxes-left").append(html);
								}
								;
								// 展示界面.
								if (curLightBoxid == 0)
									mylightboxactive($(
											".MyLightboxes-left .boxitem")
											.eq(0));
								else {
									mylightboxactive($(".MyLightboxes-left .boxitem[value='"
											+ curLightBoxid + "']"));
									mylightboxToggleTreeshow($(".MyLightboxes-left .boxitem[value='"
											+ curLightBoxid + "']"));
								}
							} else if (data && data.error == 401) {
								myAlert("需要登录");
								//
							} else {
								myAlert("需要登录");
							}
						});
}
function privateGetSonItems(list, id) {
	var ret = new Array();
	for ( var i = 0; i < list.length; i++)
		if (list[i].parentId == id)
			ret.push(list[i]);
	return ret;
}
function privateGetLevelStr(level, str) {
	var s = "";
	var str = str ? str : ">";
	for ( var i = 0; i < level; i++) {
		s += str;
	}
	return s;
}

function deleteLightBox(id, name) {
	// myConfirm(msg, ok, cancel, title)
	myConfirm("您确定要删除此灯箱[" + name + "]?", function() {
		// del
		$.post("my/dellightbox", {
			key : id,
			t : Math.random()
		}, function(data) {
			if (data && data.error == 0) {
				// myAlert("添加成功");
				var item = $(".boxitem[value='" + id + "']");
				var fitem = item.prevAll(".boxitem[value='" + item.attr("fbox")
						+ "']");
				if (fitem.length > 0)
					curLightBoxid = fitem.attr("value");
				else
					curLightBoxid = 0;
				myrefreshlightbox(true);

			} else if (data && data.error == 401) {
				myAlert("需要登录", function() {
					closeDialog("addNewLightBox");
				});
				//
			} else {
				myAlert("添加失败");
			}

		});

	}, function() {
	}, "删除灯箱");
}

function myAddNewLightBox(fidin) {
	var fid = 0;
	if (fidin)
		fid = fidin;
	// function myPanel(title, html, id, open, close)
	var html = '<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
			+ '<input id="lbNameField" type="text" maxlength="40" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " placeholder="请输入新灯箱名称">'
			+ '<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
			+ '<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
	myPanel("创建新灯箱", html, "addNewLightBox", function() {
		$("#lbNameField").val("");
	}, null);
	$("#lightbox_save").unbind();
	$("#lightbox_cancel").unbind();
	$("#lightbox_save").bind("click", function() {
		// save ajax. and refresh.
		if ($("#lbNameField").val() == "") {
			myAlert("名称不能为空");
			return;
		}
		$.post("my/addlightbox", {
			name : $("#lbNameField").val(),
			key : fid,
			t : Math.random()
		}, function(data) {
			if (data && data.error == 0) {
				// myAlert("添加成功");
				if (data.data && data.data.id)
					curLightBoxid = data.data.id;
				myrefreshlightbox(true);
				closeDialog("addNewLightBox");
			} else if (data && data.error == 401) {
				myAlert("需要登录", function() {
					closeDialog("addNewLightBox");
				});
				//
			} else {
				myAlert("添加失败");
			}

		});
	});

	$("#lightbox_cancel").bind("click", function() {
		// close
		closeDialog("addNewLightBox");
	});
}

function myMoveLightBox() {
	// function myPanel(title, html, id, open, close)
	$
			.post(
					"my/getlightboxes",
					function(data2) {
						var option = '<select name="moveLightBoxtarget" id="moveLightBoxtarget" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " >';
						$.each(data2.data, function(i, n) {
							option += '<option value="' + n.key + '">'
									+ n.value + '</option>';
						});
						option += '</select><br>';
						var html = '<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
								+ option
								+ '<div id="lightbox_cancel" class="button medium secondary dialog_btn_2">取消</div>'
								+ '<div id="lightbox_save" class="button medium primary dialog_btn_1">保存</div></div>';
						myPanel("移动灯箱", html, "myMoveLightBox", function() {
							$("#moveLightBoxtarget").val("");
						}, null);
						$("#lightbox_save").unbind();
						$("#lightbox_cancel").unbind();
						$("#lightbox_save").bind("click", function() {
							// save ajax. and refresh.

							$.post("my/setlightboxfather", {
								key : curLightBoxid,
								fid : $("#moveLightBoxtarget").val(),
								t : Math.random()
							}, function(data) {
								if (data && data.error == 0) {
									// myAlert("添加成功");
									if (data.data && data.data.id)
										curLightBoxid = data.data.id;
									myrefreshlightbox(true);
									closeDialog("myMoveLightBox");
								} else if (data && data.error == 401) {
									myAlert("需要登录", function() {
										closeDialog("myMoveLightBox");
									});
									//
								} else {
									myAlert("移动失败");
								}

							});
						});

						$("#lightbox_cancel").bind("click", function() {
							// close
							closeDialog("myMoveLightBox");
						});

					});
}

function mylightboxToggleTree(item) {
	// iconCaretCollapsed.gif
	// iconCaretExpanded.gif
	var listitem = item;
	if (item.find(".Arrow img").attr("src") == "images/iconCaretCollapsed.gif") {
		// 展开s
		listitem.nextAll(".boxitem[fbox='" + item.attr("value") + "']").show();
		item.find(".Arrow img").attr("src", "images/iconCaretExpanded.gif");
	} else {
		// 合上.
		mylightboxToggleTreehide(listitem);
		item.find(".Arrow img").attr("src", "images/iconCaretCollapsed.gif");
	}
}

function mylightboxToggleTreeshow(item) {
	item.prevAll(".boxitem[value='" + item.attr("fbox") + "']").find(
			".Arrow img").attr("src", "images/iconCaretCollapsed.gif");
	mylightboxToggleTree(item.prevAll(".boxitem[value='" + item.attr("fbox")
			+ "']"));

	//
	if (item.prevAll(".boxitem[value='" + item.attr("fbox") + "']").length > 0)
		mylightboxToggleTreeshow(item.prevAll(".boxitem[value='"
				+ item.attr("fbox") + "']"));
}
function mylightboxToggleTreehide(item) {
	item.nextAll(".boxitem[fbox='" + item.attr("value") + "']").each(
			function() {
				mylightboxToggleTreehide($(this));
			});
	item.nextAll(".boxitem[fbox='" + item.attr("value") + "']").hide();
	item.find(".Arrow img").attr("src", "images/iconCaretCollapsed.gif");
}
function mylightboxactive(item) {
	var name=item.find("span").eq(0).html();
	$("#boxName").html(name);
	$(".MyLightboxes-left .boxitem").removeClass("on");
	item.addClass("on");
	if (item.attr("value")) {
		curLightBoxid = item.attr("value") ? item.attr("value") : 0;
		// get data .
		$.post("my/getlightboxitems", {
			key : curLightBoxid
		}, function(data) {
			
			if (data && data.error == 0) {
				myCurImageData = data;
				mylightboxp = 1;
				mylightBoxSetShow();
			} else {
				myAlert("需要登录",  setTimeout(function(){
					location.href="login";
				},3000));
			}



			
		});
	}

	/*
	 * myAlert("test",function(){ myAlert("22"); });
	 */

}

function mylightBoxSetShow(p) {
	myCurDataImageArray = new Array();
	var data = myCurImageData.data;
	var total = Math.ceil(data.length / mylightboxpz);
	var map = myCurImageData.map;
	// paging .
	mylightboxp = p ? p : mylightboxp;
	if (mylightboxp > Math.ceil(data.length / mylightboxpz))
		mylightboxp = Math.ceil(data.length / mylightboxpz);
	if (mylightboxp < 1)
		mylightboxp = 1;

	$("#picbox_center").empty();
	for (i = (mylightboxp - 1) * mylightboxpz; i < data.length
			&& i < (mylightboxp) * mylightboxpz; i++) {
		var n = data[i];
		var eles = map[n.corbisId];
		if (!eles)
			continue;
		myCurDataImageArray["image" + eles.id] = eles;
		var rf =typeof(eles)!="undefined"&& eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";

		var memo = n.memo.replace(/\'+/g, "&prime;");
		memo = memo.replace(/\"+/g, "&Prime;");
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
				+ '<div class="picbox-picbox-inner" style="width: 146px;height: 129px;max-width: 146px;">'
				+ '<a href="image/'
				+ eles.corbisId
				+ '" target="_blank" class="imagelink170"><img  id="minimage'
				+ eles.id
				+ '" src="'
				+ eles.imageHost
				+ 'THUMBNAIL/'
				+ eles.path
				+ '" style="max-width: 146px;max-height: 129px;"/></a>'
				+ '</div>'
				+ '<div style="position: absolute;right: 6px;top: 0px;"><span class="ui-icon ui-icon-circle-close" title="关闭" style="cursor:Pointer" onclick="delImg(\''
				+ eles.corbisId
				+ '\',this)"></span>'// 关闭按钮
				+ '<span class="ui-icon ui-icon-document-b" title="修改备注" style="cursor:Pointer;margin-top: 2px;" onclick="updateInfo(\''
				+ n.id + '\',this,\'' + memo + '\',\'' + eles.imageHost
				+ 'THUMBNAIL/' + eles.path + '\')"></span></div>';// 备注按钮
		str += '<p style="top:auto;position: relative;" onclick="selectImg(this)"><b>' + rf + '</b>';
		// //小图标~~~
		// //str += '<i class="pic-button2"></i>'; // 计算价格
		// //str += '<i class="pic-button3"></i>'; // 购物车
		// if (eles.isInCd)
		// str += '<i class="pic-button4"></i>'; // CD
		// if (eles.isInImageSet)
		// str += '<i class="pic-button7"></i>'; // 图集
		// str += '<i class="pic-button8"></i>'; // 灯箱
		// str += '<i class="pic-button5 on"></i>'; // ~~
		// //以下二个是二选一的。
			if(eles.priType==0){
			 str += '<i class="pic-button6 on" style="margin-right: 23px;"></i>'; // 下载
			 }else if(eles.priType==3){
			 str += '<i class="pic-button1 on" style="margin-right: 23px;"></i>'; // 旗帜
			 }
		// 小图标结束~

		str += '<br />' + eles.scn + '<br />' + eles.collectionName + '<br />'; // 图库
		str += eles.corbisId + '<br/>';
		// if(eles.title&&eles.title.length>0)
		// str += eles.title+'<br />';
		// 加了标题布局大变，暂按psd .
		////////////str += '</p>';
		// 增加备注修改
			if(n.memo!=null&&n.memo!=""){
			/////str += '<div>';
			str += '<span style="top:auto;position:relative;display:block;width:150px;overflow-y: auto;overflow-x: hidden;	height: 50px;overflow: hidden; /*自动隐藏文字*/   text-overflow: ellipsis;/*文字隐藏后添加省略号*/">备注：'
					+ n.memo + '</span></p>'
			}else{
				str += '<span style="top:auto;position:relative;display:block;width:150px;overflow-y: auto;overflow-x: hidden;	height: 50px;">				</span></p>'
			}
			str+='<input type="hidden" imgid="'+n.id+'"/>';
		/////str += '</div>';
		// append textbox .
		str += '<div class="picbox-pictext"><div>';
		if (eles.title && eles.title.length > 0)
			str += eles.title + '<br>';
		if (eles.caption && eles.caption.length > 0)
			str += eles.caption + '<br>';
		str += '<b>图片库: </b>' + eles.collectionName + '<br><br>';
		if (eles.photoDate && eles.photoDate.length > 0)
			str += '<b>拍摄日期: </b>' + eles.photoDate + '<br><br>';
		if (eles.location && eles.location.length > 0)
			str += '<b>地点: </b>' + eles.location + '<br><br>';
		str += '<b>肖像权同意书: </b>' + eles.modelRelease + '<br><b>';
		str += '产权同意书: </b>' + eles.propertyRelease + '<br><br>';
		if (eles.restrictionList.length > 0) {
			str += '<font style="background:url(\'images/warn_ico.png\') no-repeat 0 center;padding-left: 20px;">Restrictions</font><br>';
			$.each(eles.restrictionList, function(i, n) {
				str += '•    ' + n + '';
			});
		}
		str += '</div></div>';
		// append textbox end .
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
				+ ' .pic-button1").click(function(){DownloadImageSepc("'
				+ eles.corbisId + '");});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button6").click(function(){DownloadImage("'
				+ eles.corbisId + '");});');
		eval('$("#divimage' + eles.id
				+ ' .pic-button8").click(function(){LightBox(' + eles.id
				+ ');});');
	}

	var pagging = '<div class="picbox-page"><div class="menu-pagebox"><a href="javascript:void(0);" class="page-arrow-left" onclick="mylightBoxSetShow('
			+ (mylightboxp - 1)
			+ ')"></a><span>'
			+ total
			+ '页之&nbsp;<input type="text" value="'
			+ mylightboxp
			+ '"></span><a href="javascript:void(0);" class="page-arrow-right" onclick="mylightBoxSetShow('
			+ (mylightboxp + 1) + ')"></a></div></div>';
	$("#picbox_center").append(pagging);

	$(".page-arrow-left").attr("onclick","mylightBoxSetShow("+(mylightboxp - 1)+")");
	$(".page-arrow-right").attr("onclick","mylightBoxSetShow("+(mylightboxp + 1)+")");
	$("#yezhi").html(total+"页之&nbsp;<input type=\"text\" value=\""+mylightboxp+"\">");
	$('body,html').animate({
		scrollTop : 0
	}, 800);
}

function mySelectRootBox() {
	curLightBoxid = 0;
	$(".MyLightboxes-left .boxitem").removeClass("on");
}

function setDivLightOn() {
	// src
	$(".mylightbox-left-imgbox .jspPane .mylightbox-left-imgbox-box").each(
			function() {
				$(".picbox-picbox[gpid='" + $(this).attr("gpid") + "']")
						.addClass("on");
				$(
						".picbox-picbox[gpid='" + $(this).attr("gpid")
								+ "'] .pic-button8").addClass("on");
				$(
						".picbox-picbox[gpid='" + $(this).attr("gpid")
								+ "'] .pic-button8").attr("title","从灯箱移除");
			});

}

/*my lightbox end*/
//aothor:Peter
function delImg(id, a) {
	$.ajax({
		url : "my/delelightboximg",
		type : "post",
		data : "box=" + curLightBoxid + "&id=" + id,
		success : function(data) {
			//$(a).closest(".picbox-picbox").hide();
			location.reload(true);
		}
	});
}

function updateInfo(id, a, msg, img) {
	var anniu = '<div id="cancleInfo" class="button medium secondary dialog_btn_2">取消</div>'
			+ '<div id="saveInfo" class="button medium primary dialog_btn_1">保存</div>';
	msg = (msg == 'undefined' ? "" : msg);
	myPanel(
			'图片备注',
			'<div style="min-width:320px"><img src="'
					+ img
					+ '" style="margin: 20px 15px;height: 95px;"/><textarea id="noteText" style="float: right;margin: 20px 15px;width: 154px;" rows="5">'
					+ msg + '</textarea>' + anniu + "</div>","updateInfo"+id,
			function() {
				//注册chkbxcom事件
				$(".dialog_btn_2").css("clear","both");
				$(".dialog_btn_2").bind("click", function() {
					closeDialog("updateInfo" + id);
				});
				$(".dialog_btn_1").bind("click", function() {
					//保存

					$.ajax({
						url : "my/updateImgMemo",
						type : "post",
						data : "id=" + id + "&memo=" + $("#noteText").val(),
						success : function(data) {
							myAlert("修改成功", function() {
								location.reload(true);
							});
						}
					});
				});
			});
}

function sendEmail() {
	var urlChar=$("base").attr("href").split("/");
	var anniu = '<div id="cancelSend" class="button medium secondary dialog_btn_2">取消</div>'
			+ '<div id="sendEmail" class="button medium primary dialog_btn_1">保存</div>';
	var url = "";
	$.ajax({
		url : "my/getcode",
		type : "post",
		data : "boxid=" + curLightBoxid,
		async : false,
		success : function(data) {
			
			url = urlChar[0]+"//"+urlChar[2]+"/anounymous/lightbox?code="
					+ data.code;
		}
	});

	var sendContent = $(".sendEmail").html();
	myPanel('发送邮件', sendContent + anniu, "sendEmailDiv", function() {
		$(".sendEmail").html("");
		$("#cancelSend").bind("click", function() {
			closeDialog("sendEmailDiv");
		});
		$(".url").html(url);
		$("#sendEmail").bind(
				"click",
				function() {
					//发送邮件
					$.ajax({
						url : "my/sendEmail",
						type : "post",
						data : "title=" + $(".ui-dialog .titleemail").val()
								+ "&url=" + $(".ui-dialog .url").html()
								+ "&msg=" + $(".ui-dialog #msg").val()
								+ "&accepter="
								+ $(".ui-dialog #accepter").val()
								+"&localPpath="+urlChar[0]+"//"+urlChar[2]+"/",
						success : function(data) {
							myAlert("发送成功", function() {
								location.reload(true);
							});
						}
					});
				});
	});
	$(".sendEmail").html(sendContent);
}



var content1;
//Peter shiftImg
function shiftImg(){
	var anniu = '<div id="shiftImgCancel" class="button medium secondary dialog_btn_2">取消</div>'
	+ '<div id="shiftImgSave" class="button medium primary dialog_btn_1">保存</div>';
	content1=$(".zhuanyi").html();
myPanel('转移灯箱', content1 + anniu, "shiftlightbox", function() {
		$(".zhuanyi").html("");
		$("#shiftImgCancel").bind("click", function() {
			$(".secondary.showselect").html("");
			closeDialog("shiftlightbox");
		});
		$("#shiftImgSave").bind(
				"click",
				function() {
					startLoading();
					var userid="";
					$(".showselect option").each(function(i,e){
						userid+=$(e).val()+";";
					});
					$.ajax({
						url : "my/shiftlightbox",
						type : "post",
						data : "boxid=" + curLightBoxid
								+ "&userid=" +userid,
						success : function(data) {
									if(data.code==-1){
										myAlert("发送失败");
									}else if(data.code==1){
										myAlert("转移成功");
									}else if(data.code==0){
										myAlert("转移失败");	
									}
						},
						complete :function(){
							endLoading();
						}
					});
				});
	},function(){
		$(".showselect").html("");
		$(".zhuanyi").html(content1);
	});	
	
}
var index=0;
function checkAddUser(){
	var user=$(".ui-dialog .addUser").val();
	$.ajax({
		url : "my/checkuser",
		type : "post",
		data : "user=" + user,
		success : function(data) {
			if(data.code==1){
				SetCookie("name"+index,user);
				SetCookie("index",index);
				if($(".selectUser option[value=\""+user+"\"]").length ==0){
					setSelectViewOption(user);
				}
			}else if(data.code==-1){
				myAlert("验证失败，请重新验证");
			}else if(data.code==0){
				myAlert("该用户不存在");
			}
		}
	});
}



$(document).ready(function(){
	var length=cookie("index");
	for(var i=0;i<length;i++){
		var name=cookie("name"+i);
		setSelectViewOption(cookie(name));
	}
});



function selectOption(e){
	$("div .hint").hide();
	if($(e).attr("state")==0){
		setShowViewOption($(e).val());
		$(e).attr("state","1");
	}
}


function delOption(e){
	$(e).remove();
	$(".selectUser option[value=\""+$(e).val()+"\"]").attr("state","0");
}

function toRight(){
	var value=$(".selectUser option[state1='selected']").val();
	if(typeof(value)!="undefined"&&
			$(".showselect option[value=\""+value+"\"]").length ==0){
		$("div .hint").hide();
		//$(".showselect").append("<option value=\""+value+"\" ondblclick=\"javascript:delOption(this)\">"+value+"</option>");
		setShowViewOption(value);
	}
}

function toLeft(){
	$(".showselect option[state1='selected']").each(function(i,e){
		delOption(e);
	});
	$(".showselect option[selected='selected']").each(function(i,e){
		delOption(e);
	});
}

function setShowViewOption(str){
	$(".showselect").append("<option value=\""+str+"\" onclick=\"setClick(this)\" ondblclick=\"javascript:delOption(this)\">"+str+"</option>");
}

function setSelectViewOption(str){
	$(".selectUser").append("<option value=\""+str+"\" state=\"0\" onclick=\"setClick(this)\" ondblclick=\"javascript:selectOption(this);\">"+str+"</option>");
}


function setClick(e){
	if($(e).attr("state1")!="selected"){
		$(e).attr("state1","selected");
		$(e).attr("selected","selected");
	}else{
		$(e).attr("state1","no");
		$(e).removeAttr("selected","selected");
	}
	
}



function updateBoxNmae(e){
	var currentBoxName=$("#boxName").html();
	$("#boxName").html("<input type='text' id='txt_boxName' value='"+currentBoxName+"'/>");
	$("#btn_boxName").attr("href","javascript:saveBoxName()");
	$("#btn_boxName").html("保存");
}

function saveBoxName(){
	var newName=$("#txt_boxName").val();
	$.ajax({
		url : "my/updateboxname",
		type : "post",
		data : "boxname=" + newName+"&boxid="+curLightBoxid,
		success : function(data) {
			if(data.code==1){
				$("#boxName").html(newName);
				$(".boxitem.on span").html(newName);
				$("#btn_boxName").attr("href","javascript:updateBoxNmae(this)");
				$("#btn_boxName").html("修改");
			}else if(data.code==-1){
				myAlert("提交失败");
			}else if(data.code==0){
				myAlert("修改失败");
			}
		}
	});
}


function setBoxInfo(){
	var boxInfo=myCurLightBoxs[curLightBoxid];
	$("#customer").val(boxInfo.customer);
	$("#memo").html(boxInfo.memo);
	$("#updateTime").html(getUserDate(boxInfo.updateTime));
	$("#createTime").html(getUserDate(boxInfo.createTime));
	$("#customer").removeAttr("readonly");
	$("#memo").removeAttr("readonly");
	$("#customer").attr("style","background: #fff;color:#000;");
	$("#memo").attr("style","background: #fff;color:#000;");
	$(".MyLightboxes-center span").show();
}

function cancelInfo(){
	$("#customer").attr("readonly","readonly");
	$("#memo").attr("readonly","readonly");
	$("#customer").attr("style","background: none;	border: none;	color: #FFF;");
	$("#memo").attr("style","margin: 0px;	vertical-align: top;	width: 380px;");
	$(".MyLightboxes-center .buttonSpan").hide();
}

function saveInfo(){
	startLoading()
	var customer=$("#customer").val();
	var memo=$("#memo").val();
	$.ajax({
		url : "my/saveboxinfo",
		type : "post",
		data : "customer=" + customer+"&boxid="+curLightBoxid+"&memo="+memo,
		success : function(data) {
			if(data.code==1){
				$("#customer").val(customer);
				$("#memo").val(memo);
				cancelInfo();
			}else if(data.code==-1){
				myAlert("提交失败");
			}else if(data.code==0){
				myAlert("修改失败");
			}
		},
		complete :function(){
			endLoading();
		}
	});
}


function selectPageCode(num){
	$("#Pageitems25").addClass("items25");
	$("#Pageitems50").addClass("items50");
	$("#Pageitems100").addClass("items100");
	$("#Pageitems200").addClass("items200");
	
	$("#Pageitems25").removeClass("items25Selected");
	$("#Pageitems50").removeClass("items50Selected");
	$("#Pageitems100").removeClass("items100Selected");
	$("#Pageitems200").removeClass("items200Selected");
	$("#Pageitems"+num).removeClass("items"+num);
	$("#Pageitems"+num).addClass("items"+num+"Selected");
	 mylightboxpz = num;
	 mylightboxp = 1;
	 mylightBoxSetShow(0);
}


function selectImg(e){
	
	var className=$(e).closest("div")[0].className.split(" ");
	var powderhose=false;
	for(var index=0; index<className.length; index++) {
			if(className[index]=="on"){
				powderhose=true;
				break;
			}
	}
	if(powderhose){
		$(e).closest("div").removeClass("on");
	}else{
		$(e).closest("div").addClass("on");
	}
	
}

function myCopyOrMove(){
	
	//myCurLightBoxs

		 {
						var option = '<select name="moveLightBoxtarget" id="moveLightBoxtarget" style="width:220px; color: rgb(51, 51, 51);margin: 15px; " >';
						$.each(myCurLightBoxs, function(i, n) {
							option += '<option value="' + n.id + '">'
									+ n.name + '</option>';
						});
						option += '</select><br>';
						var html = '<div class="ctip-content" style="width: 300px;height: 110px;"><div id="validationSummary" style="display: none"></div>'
								+ option
								+ '<div class="checkedImage del" onclick="checkedUpdate(this)" isChecked="true"></div>从当前灯箱移除?</div><div id="move_cancel" class="button medium secondary dialog_btn_2">取消</div>'
								+ '<div id="move_save" class="button medium primary dialog_btn_1">保存</div>';

						myPanel("请选择灯箱", html, "selectMoveLightBox",
											function(){
												$("#move_cancel").bind("click", function() {
													closeDialog("selectMoveLightBox");
												});
												$("#move_save").bind(
														"click",
														function() {
															startLoading();
															
															var imgids="";
																$(".on").each(function(i,e){//imgid
																	imgids+=$(e).find("input[type='hidden']").attr("imgid")+",";
																})															

															var isDel=0;
															if(eval($(".checkedImage.del").attr("isChecked"))){
																isDel=1;
															}else{
																isDel=0;
															}
															
																											
															$.ajax({
																url : "my/moveImg",
																type : "post",
																data : "boxid=" + $("#moveLightBoxtarget").val()
																		+ "&imgids=" +(imgids=='undefined'?'':imgids)	
																		+"&isDel="+isDel,
																success : function(data) {
																			
																			if(data.code==-1){
																				myAlert("操作失败");
																			}else if(data.code==1){
																				myAlert("操作成功");
																				myrefreshlightbox(true);
																			}else if(data.code==0){
																				myAlert("操作失败");	
																			}
																},
																complete :function(){
																	endLoading();
																	closeDialog("selectMoveLightBox");
																}
															});
														});	
											
											}, 
							null);			
					}
		 }


function checkedUpdate(e){
	var isChecked=eval($(e).attr("isChecked"));
	$(e).attr("isChecked",!isChecked);
	if(eval($(e).attr("isChecked"))){
		$(e).removeClass("uncheckedImage").addClass("checkedImage");
	}else{
		$(e).removeClass("checkedImage").addClass("uncheckedImage");
	}
	
}







//////cookie


//获得coolie 的值

 

function cookie(name) {

	var cookieArray = document.cookie.split("; "); //得到分割的cookie名值对    
	var cookie = new Object();
	for ( var i = 0; i < cookieArray.length; i++) {
		var arr = cookieArray[i].split("="); //将名和值分开    
		if (arr[0] == name)
			return unescape(arr[1]); //如果是指定的cookie，则返回它的值    
	}
	return "";
}

function delCookie(name)//删除cookie
{
	document.cookie = name + "=;expires=" + (new Date(0)).toGMTString();
}

function getCookie(objName) {//获取指定名称的cookie的值
	var arrStr = document.cookie.split("; ");
	for ( var i = 0; i < arrStr.length; i++) {
		var temp = arrStr[i].split("=");
		if (temp[0] == objName)
			return unescape(temp[1]);
	}

}

function addCookie(objName, objValue, objHours) { //添加cookie
	var str = objName + "=" + escape(objValue);
	if (objHours > 0) { //为时不设定过期时间，浏览器关闭时cookie自动消失
		var date = new Date();
		var ms = objHours * 3600 * 1000;
		date.setTime(date.getTime() + ms);
		str += "; expires=" + date.toGMTString();
	}
	document.cookie = str;
}

function SetCookie(name, value)//两个参数，一个是cookie的名子，一个是值
{
	var Days = 30; //此 cookie 将被保存 30 天
	var exp = new Date(); //new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();

}

function getCookie(name)//取cookies函数        
{
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));

	if (arr != null)
		return unescape(arr[2]);
	return null;
}

function delCookie(name)//删除cookie
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function getUserDate(date){
	var dt= new Date(date);
	 var year=dt.getFullYear();//获取年
	 return Todate(dt)+"/"+year;
}

	function Todate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008
		num = num + "";
		var date = "";
		var month = new Array();
		month["Jan"] = 1;
		month["Feb"] = 2;
		month["Mar"] = 3;
		month["Apr"] = 4;
		month["May"] = 5;
		month["Jun"] = 6;

		month["Jul"] = 7;
		month["Aug"] = 8;
		month["Sep"] = 9;
		month["Oct"] = 10;
		month["Nov"] = 11;
		month["Dec"] = 12;

		/* var week = new Array();

		week["Mon"] = "一";
		week["Tue"] = "二";
		week["Wed"] = "三";
		week["Thu"] = "四";
		week["Fri"] = "五";
		week["Sat"] = "六";
		week["Sun"] = "日"; */

		str = num.split(" ");

		//date = str[5] + "-";

		date = /* date + */ month[str[1]] + "/" + str[2];

		return date;

	}


function AddGroupToLightbox(item)
{
	var gid=item.attr("groupid");
	$.post("my/addlightboximagesfromimagegroup",{key:curLightBoxid,groupid:gid},
			function(data){
		if(data&&data.error==0)
		{
			refreshlightboxitems();
		}
		else if(data&&data.error==401)
		{
			myAlert("需要登录");
		}
		else 
		{
			myAlert("需要登录");
		}
	});
}
function DownloadAllinBox()
{
	$.post("my/addlightboximagesdownload",{key:curLightBoxid},
			function(data){
		if(data&&data.error==0)
		{
			location.href="/"+data.url;
		}
		else if(data&&data.error==401)
		{
			myAlert("需要登录");
		}
		else 
		{
			myAlert("需要登录");
		}
	});
}

