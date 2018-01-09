(function ( $ ) {
jQuery(document).ready(function() {

function youzikujsm() {
	var datastr = [], datamd5 = [], dataname = ["SiYuan-ExtraLight","Source-Han-Light", "SiYuanBold"/*, "Source-Han-Normal"*/], dataguid = ["e70df9c6602e4a59842dcee80c82fb12","f09d62e292864f66ac2b69eb3289877a","537f214fb334481986934bad0f81780c"/*,"04d0e2e7ce064c15bce8fdb531e0f45a"*/];
	for (var i = 0; i < dataname.length; i++) {
		var elem = dataname[i];
		var resultStr = $("." + elem).text(); resultStr = Trim(resultStr);
		resultStr = SelectWord(resultStr); datastr.push(resultStr);
		var md5 = $.md5(dataguid[i] + elem + resultStr); datamd5.push(md5);
	}
	var strdatamd5 = datamd5.join(","), strdataguid = dataguid.join(",");
	$.getJSON("http://www.youziku.com/webfont/JSArrayPOST?jsoncallback=?", { "arraymd5": strdatamd5, "arrayguid": strdataguid, "type": "5" }, function (json) {
		
		
		var arraydo=new Array();
		var arraydone=new Array();
		var strdo = json.strdo;
		var strdone = json.strdone;
		

		arraydo = strdo.split("*");
		arraydone = strdone.split("*");
		
		

		if(arraydo.forEach){

			arraydo.forEach(function (elem) {
				if (elem != null && elem != "") {
					var item = parseInt(elem);
					$.post("http://www.youziku.com/webfont/PostCorsCreateFont", { "name": dataname[item], "gid": dataguid[item], "type": "5", "text": datastr[item] }, function (json) {
						if (json == "0") { //alert("参数不对");
						} else if (json == "2") {//alert("超过每日生成字体数的上限");
						} else if (json == "3") { //alert("当前正在生成请稍后");
						} else {//alert("正在生成");
						}
					});
				}
			})
		}
		if(arraydo.forEach){
			arraydone.forEach(function (elem) {
				if (elem != null && elem != "") {
					var item = parseInt(elem);
					loadExtentFile("http://www.youziku.com/webfont/CSSJs?id=" + datamd5[item] + "&name=" + dataname[item] + "&guid=" + dataguid[item] + "&type=5");
				}
			})
		}
	});
}

(function youziku() {
	// 获取浏览器版本
	function getBrowserInfo()
	{
		var agent = navigator.userAgent.toLowerCase() ;

		var regStr_ie = /msie [\d.]+;/gi ;
		var regStr_ff = /firefox\/[\d.]+/gi
		var regStr_chrome = /chrome\/[\d.]+/gi ;
		var regStr_saf = /safari\/[\d.]+/gi ;

		//IE
		if(agent.indexOf("msie") > 0)
		{
			return agent.match(regStr_ie) ;
		}

		//firefox
		if(agent.indexOf("firefox") > 0)
		{
			return agent.match(regStr_ff) ;
		}

		//Chrome
		if(agent.indexOf("chrome") > 0)
		{
			return agent.match(regStr_chrome) ;
		}

		//Safari
		if(agent.indexOf("safari") > 0 && agent.indexOf("chrome") < 0)
		{
			return agent.match(regStr_saf) ;
		}
	}


	var browser = getBrowserInfo() ;
	//console.log(browser);
	var regChrome = /chrome\/[\d]+/gi;
	if(browser == true){
		var isChrome = browser[0].match(regChrome);
		if (isChrome) {
			//chrome 版本号
			var chromeVersion = isChrome[0].substring(7);
			if(chromeVersion == 28 || chromeVersion == 29 || chromeVersion == 30 || chromeVersion == 31 || chromeVersion == 32){

			}else{
				youzikujsm();
			}
		}
	}
})()




//
//
//	function youziku46870() {
//        var resultStr = $(".SiYuan-ExtraLight").text();
//        var md5 = "";
//        resultStr = Trim(resultStr);
//        resultStr = SelectWord(resultStr);
//        md5 = $.md5("e70df9c6602e4a59842dcee80c82fb12"+"SiYuan-ExtraLight" + resultStr);
//        $.getJSON("http://www.youziku.com/webfont/CSSPOST?jsoncallback=?", { "id": md5, "guid": "e70df9c6602e4a59842dcee80c82fb12", "type": "5" }, function (json) {
//            if (json.result == 0) {/*alert("需要生成");*/
//                $.post("http://www.youziku.com/webfont/PostCorsCreateFont", { "name": "SiYuan-ExtraLight", "gid": "e70df9c6602e4a59842dcee80c82fb12", "type": "5", "text": resultStr }, function (json) {
//                if (json == "0") { /*alert("参数不对");*/
//                } else if (json == "2") {/*alert("超过每日生成字体数的上限");*/
//                } else if (json == "3") { /*alert("当前正在生成请稍后");*/
//                } else {/*alert("正在生成");*/
//                }
//            });
//            }
//            else {/*alert("下载css文件");*/
//                loadExtentFile("http://www.youziku.com/webfont/css?id=" + md5 + "&guid=" + "e70df9c6602e4a59842dcee80c82fb12" + "&type=5");
//            }
//        });
//    }
//    (function youziku() {
//    if (window.location.href.toString().substring(0, 7) == "file://") {
//           // alert("你当前是通过双击打开html文件，进行本地测试的，这样看不到字体效果，一定要通过本地建立的虚拟网站或发布到外网进行测试。详见有字库的使用说明。");
//        }else{
//        youziku46870();
//        }
//    })()
//
//
//
//function youziku46865() {
//        var resultStr = $(".Source-Han-Light").text();
//        var md5 = "";
//        resultStr = Trim(resultStr);
//        resultStr = SelectWord(resultStr);
//        md5 = $.md5("f09d62e292864f66ac2b69eb3289877a"+"Source-Han-Light" + resultStr);
//        $.getJSON("http://www.youziku.com/webfont/CSSPOST?jsoncallback=?", { "id": md5, "guid": "f09d62e292864f66ac2b69eb3289877a", "type": "5" }, function (json) {
//            if (json.result == 0) {
//					alert("需要生成");
//                $.post("http://www.youziku.com/webfont/PostCorsCreateFont", { "name": "Source-Han-Light", "gid": "f09d62e292864f66ac2b69eb3289877a", "type": "5", "text": resultStr }, function (json) {
//                if (json == "0") { 
//					alert("参数不对");
//                } else if (json == "2") {
//					alert("超过每日生成字体数的上限");
//                } else if (json == "3") { 
//					alert("当前正在生成请稍后");
//                } else {
//					alert("正在生成");
//                }
//            });
//            }
//            else {/*alert("下载css文件");*/
//                loadExtentFile("http://www.youziku.com/webfont/css?id=" + md5 + "&guid=" + "f09d62e292864f66ac2b69eb3289877a" + "&type=5");
//            }
//        });
//    }
//    (function youziku() {
//    if (window.location.href.toString().substring(0, 7) == "file://") {
//            alert("你当前是通过双击打开html文件，进行本地测试的，这样看不到字体效果，一定要通过本地建立的虚拟网站或发布到外网进行测试。详见有字库的使用说明。");
//        }else{
//        youziku46865();
//        }
//    })()
//	
//	
//	
//	
//	
//	function youziku46863() {
//        var resultStr = $(".Source-Han-Normal").text();
//        var md5 = "";
//        resultStr = Trim(resultStr);
//        resultStr = SelectWord(resultStr);
//        md5 = $.md5("537f214fb334481986934bad0f81780c"+"Source-Han-Normal" + resultStr);
//        $.getJSON("http://www.youziku.com/webfont/CSSPOST?jsoncallback=?", { "id": md5, "guid": "537f214fb334481986934bad0f81780c", "type": "5" }, function (json) {
//            if (json.result == 0) {/*alert("需要生成");*/
//                $.post("http://www.youziku.com/webfont/PostCorsCreateFont", { "name": "Source-Han-Normal", "gid": "537f214fb334481986934bad0f81780c", "type": "5", "text": resultStr }, function (json) {
//                if (json == "0") { /*alert("参数不对");*/
//                } else if (json == "2") {/*alert("超过每日生成字体数的上限");*/
//                } else if (json == "3") { /*alert("当前正在生成请稍后");*/
//                } else {/*alert("正在生成");*/
//                }
//            });
//            }
//            else {/*alert("下载css文件");*/
//                loadExtentFile("http://www.youziku.com/webfont/css?id=" + md5 + "&guid=" + "537f214fb334481986934bad0f81780c" + "&type=5");
//            }
//        });
//    }
//    (function youziku() {
//    if (window.location.href.toString().substring(0, 7) == "file://") {
//            //alert("你当前是通过双击打开html文件，进行本地测试的，这样看不到字体效果，一定要通过本地建立的虚拟网站或发布到外网进行测试。详见有字库的使用说明。");
//        }else{
//        youziku46863();
//        }
//    })()
//	
//	
//	
//	
//	
//	
//	
//
//	function youziku46828() {
//        var resultStr = $(".SiYuanBold").text();
//        var md5 = "";
//        resultStr = Trim(resultStr);
//        resultStr = SelectWord(resultStr);
//        md5 = $.md5("6ebaeb3472254b81a503d4d9e277f13f"+"SiYuanBold" + resultStr);
//        $.getJSON("http://www.youziku.com/webfont/CSSPOST?jsoncallback=?", { "id": md5, "guid": "6ebaeb3472254b81a503d4d9e277f13f", "type": "5" }, function (json) {
//            if (json.result == 0) {/*alert("需要生成");*/
//                $.post("http://www.youziku.com/webfont/PostCorsCreateFont", { "name": "SiYuanBold", "gid": "6ebaeb3472254b81a503d4d9e277f13f", "type": "5", "text": resultStr }, function (json) {
//                if (json == "0") { /*alert("参数不对");*/
//                } else if (json == "2") {/*alert("超过每日生成字体数的上限");*/
//                } else if (json == "3") { /*alert("当前正在生成请稍后");*/
//                } else {/*alert("正在生成");*/
//                }
//            });
//            }
//            else {/*alert("下载css文件");*/
//                loadExtentFile("http://www.youziku.com/webfont/css?id=" + md5 + "&guid=" + "6ebaeb3472254b81a503d4d9e277f13f" + "&type=5");
//				
//				
// 
//            }
//        });
//    }
//    (function youziku() {
//    if (window.location.href.toString().substring(0, 7) == "file://") {
//           // alert("你当前是通过双击打开html文件，进行本地测试的，这样看不到字体效果，一定要通过本地建立的虚拟网站或发布到外网进行测试。详见有字库的使用说明。");
//        }else{
//        youziku46828();
//        }
//    })()
//
//





		
});
}( jQuery ));