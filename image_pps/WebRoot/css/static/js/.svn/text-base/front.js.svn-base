/**
 * @package     Corbis Frontend Massive Header.
 * @since       Mar 12, 2013 #
 * @author      Fractal Technology Ltd.
 */
var loadAdvanceSearchWapper;
define(function () {

    var handleAdvanceSearch, bindKeywordAutoComplete, headerCategoriesShowHandle, headerCategoriesHideHandle;
	
    /**
     * Language Selection
     */

    $(".language").hover(
		function(){ $(".language_div").show();},
		function(){ $(".language_div").hide();}
	);
	$(".account").hover(
		function(){ $(".account_div1").show();},
		function(){ $(".account_div1").hide();}
	);
	$(".language_div").hover(
		function(){ $(".language_div").show();},
		function(){ $(".language_div").hide();}
	);
	$(".account_div1").hover(
		function(){ $(".account_div1").show();},
		function(){ $(".account_div1").hide();}
	);

    $(".language_div li").click(function(){
        $(this).find("a").addClass("on").end().siblings().find("a").removeClass("on");
        $(".language b").html($(this).find("a").html());
        $(".language_div").hide();
    });

    $(".kx").click(function(){
        var self = $(this),
            nextDiv = self.next("div");
        if (nextDiv.css("display") == "block") {
            self.find("i").html("▼");
            nextDiv.hide();
        } else {
            self.find("i").html("▲");
            nextDiv.show();
        }
    });

    /**
     * Search Area
     */
	
	requirejs(
		[
			FT.vars.FRONT_PATH + 'cookies.min.js', 
			FT.vars.FRONT_PATH + 'use_typeahead.js'
		], 
		function(Cookies, Typeahead) {
			FT.AutoComplete = {
				Cookies 	: Cookies,
				Typeahead 	: Typeahead
			};
			bindKeywordAutoComplete();
		}
	);

	headerCategoriesShowHandle = function() { 
		var jEleCategories, jEleCategoriesTop;
		
		jEleCategories 		= $('.header-categories:checked[reid]');
		jEleCategoriesTop 	= $('.header-categories.first');

		if (jEleCategories.size() == 0) {
			$('.header-categories:first').attr('checked', true);
		} else {
			jEleCategoriesTop.size() > 0 && jEleCategoriesTop.each(function(index, element) {
				var thatEle = $(element);
				thatEle.attr('checked', $('.header-categories:checked[reid='+thatEle.val()+']').size() > 0 ? true : false );
			});
		}
	};
	
	headerCategoriesHideHandle = function() { 
		var jEleCategories, jEleTopCategories;
		
		jEleCategories = $('.header-categories:checked[reid]');
		
		if (jEleCategories.size() == 1) 
		{
			$('.header-categories-checked-name').html(jEleCategories.next('label').text() + $('.header-categories[value='+jEleCategories.attr('reid')+']').next('label').text());
		} 
		else if (jEleCategories.size() > 1) 
		{
			jEleTopCategories = $('.header-categories.first:checked');
			
			if (jEleTopCategories.size() == 1 && $('.header-categories:checked[reid='+jEleTopCategories.val()+']').size() == $('.header-categories[reid='+jEleTopCategories.val()+']').size()) {
				$('.header-categories-checked-name').html(jEleTopCategories.next('label').text());
			} else {
				$('.header-categories-checked-name').html(jEleCategories.size() + '个类别');
			}
		} 
		else 
		{
			$('.header-categories-checked-name').html('所有类别');
		}
	};
	
    $(".leibie,.index_leibie").hover( function(){
			$(".lb_tc").show();
			headerCategoriesShowHandle();
		}, function(){
			$(".lb_tc").hide();
			headerCategoriesHideHandle();
		} 
	);
	
	$('.header-categories').click(function(e) {
        var jThis, sValue, bIsFirst, bIsChecked, iReid;
		jThis 		= $(this);
		sValue 		= jThis.val();
		bIsFirst 	= jThis.hasClass('first') ? true : false;
		bIsChecked	= jThis.attr('checked') ? true : false;
		
		if (sValue == 'all') {
			$('.header-categories:not(:first)').attr('checked', false);
		} else if (bIsFirst === true) {
			$('.header-categories:first').attr('checked', false);
			$('.header-categories[reid='+sValue+']').attr('checked', bIsChecked);
		} else {
			iReid = parseInt(jThis.attr('reid'));
			$('.header-categories:first').attr('checked', false);
			$('.header-categories[value='+iReid+']').attr('checked', $('.header-categories:checked[reid='+iReid+']').size() > 0 ? true : false);
		}
    });
	
	var elemAdvanceWrapper 	= $('#header_advance_search_wrapper');
	loadAdvanceSearchWapper = function()
	{
		elemAdvanceWrapper.html('loading...');
		$.post(
			FT.vars.BASE_URL + 'search/get_advance_search',
			function(raw) {
				handleAdvanceSearch(raw, elemAdvanceWrapper);
			}
		);
	};
	loadAdvanceSearchWapper();
	
    $(".gj_ss").click(function(){

        var elemAdvance 		= $('#header_advance_search');

        if (elemAdvance.length === 0) 
		{
            /*$.ajax({
                type: 'post',
                url: FT.vars.BASE_URL + 'search/get_advance_search',
				beforeSend: function(xhr) {
					elemAdvanceWrapper.html('loading...');
				},
                success: function (raw) {
                    handleAdvanceSearch(raw, elemAdvanceWrapper);
                }
            });*/
			
        }
		
		/*$(this).parent().hover(function(e) {
            elemAdvanceWrapper.hide();
        });*/
		
        elemAdvanceWrapper.toggle();
    });

    // $(".index_gj_ss").click(function(){

    //     var elemAdvance = $('#header_advance_search');
    //     var elemAdvanceWrapper = $('#header_advance_search_wrapper');

    //     if (elemAdvance.length === 0) {
    //         $.ajax({
    //             type: 'get',
    //             url: FT.vars.BASE_URL + 'search/get_advance_search',
				// beforeSend: function(xhr) {
				// 	elemAdvanceWrapper.html('loading...');
				// },
    //             success: function (raw) {
    //                 handleAdvanceSearch(raw, elemAdvanceWrapper);
    //             }
    //         });
    //     }

    //     elemAdvanceWrapper.toggle();
    // });
	
	if (FT.vars.SHORT_ID != '_search') {
		$('#search-form').submit(function(e) {
			_submit($(this));
			return false;
		});
		
		$('#button-search').click(function(e) {
			_submit($('#search-form'));
			return false;
		});
	}
	
	$('input[name=k]').attr('x-webkit-speech', 'x-webkit-speech');
	
	_submit = function(form)
	{
		var word = '', innerParams = [];

		if (form[0].k.value == '请输入您想要搜索的关键字') form[0].k.value = '';
		
		var nForm = _makeForm(form[0]);

		return false;
	};
	
	_makeForm = function(oForm) {
		var nForm = document.createElement('form'),
			aCategories = $(oForm).find(':checkbox[name=categories]:checked'),
			categories = [],
			params = [];
		
		if (oForm.k.value != '' && oForm.k.value != '请输入您想要搜索的关键字') params.push('k=' + encodeURIComponent(oForm.k.value));
		
		params.push('p=1');
		
		if (aCategories.size() > 0) {
			aCategories.each(function(index, element) {
				categories.push($(element).val());
            });
			
			categories.length > 0 && params.push('cate=' + categories.join('_'));
		}

		nForm.action = oForm.action.replace(/\?$/, '') + '#' + params.join('&');
		nForm.method = 'POST';

		location.href = nForm.action;
		
		return nForm;
	};
	
	parseUrl = function(so) 
	{
		var args = [],
        	query = window.location.hash.substring(1),
			pairs = query.split("&"),
			getArgName = typeof(so) == 'string' ? so : false;
		
		for (var i = 0; i < pairs.length; i++) { 
			var pos = pairs[i].indexOf('=');
			if (pos == -1) continue;
			var argname = pairs[i].substring(0, pos);
			var value = pairs[i].substring(pos + 1);
			value = decodeURIComponent(value);
			
			if (getArgName !== false)
			{
				if (argname == getArgName)
				{
					return value;
				}
			}
			else
			{
				args.push({name: argname, value: value});
			}
		}
		
		return args;
	};
	
    handleAdvanceSearch = function (raw, elemAdvanceWrapper) {
		var args = parseUrl();
		var keyword = '';
        elemAdvanceWrapper.html(raw);
		
		$('.advance-collections-item').each(function(index, element) {
          	$(this).attr('checked', true); 
		   	var cm = $('.select-collections-sum-' 	+ 	$(this).attr('c'));
			cm.text($('.checkbox-collection-item-' 	+ 	$(this).attr('c')).size());
			
			$(this).click(function(e) {
				cm.text( $(this).attr('checked') ? (cm.text() * 1 + 1) : (cm.text() * 1 - 1));
			});
        });

		for (var i in args) {
			switch (args[i].name) {
				case 'c':
					var cs = args[i].value.split(/\_/g), ch, cm;
					$('.select-collections-sum').text(0);
					$('.advance-collections-item').each(function(index, element) {
						ch = $.inArray($(this).val(), cs) > -1 ? true : false;
						cm = $('.select-collections-sum-' + $(this).attr('c'));
						ch && cm.text(cm.text()*1+1);
                        $(this).attr('checked', ch);
                    });
					break;
				case 'i':
					var im = args[i].value.split(/\_/g);
					$('.advance-image-id').val(im.join(',')).show();
					$('.advance-image-id-style').hide();
					break;
				case 'nk':
					$('.advance-no-keyword').val(args[i].value);
					break;
				case 'k':
					keyword = args[i].value;
					break;
				case 'date_limit':
					var limits = $('.advance-time-limit-range');
					var tm = args[i].value.split(/\-/g);
					limits.each(function(index, element) {
                        $(this).val(tm[index]);
                    });
					$('.advance-time-limit[value=range]').attr('checked', true);
					break;
				case 'date_near_day':
					$('.advance-time-limit[value=day]').attr('checked', true);
					$.isNumeric(args[i].value) && $('.advance-time-limit-day').val(args[i].value);
					break;
				case 'photographer':
					$('.advance-photographer').val(args[i].value);
					break;
				case 'pd':
					$('.advance-datephotographed').val(args[i].value);
					break;
				case 'loc':
					$('.advance-location').val(args[i].value);
					break;
				case 'credit':
					$('.advance-credit').val(args[i].value);
					break;
				case 'immediate':
					$('.advance-immediate').val(args[i].value);
					var jSelectedImmediate = $('.advance-immediate-select[v='+args[i].value+']');
					$('.advance-immediate-input').val(jSelectedImmediate.text());
					$('.advance-immediate').val(jSelectedImmediate.attr('v'));
					break;
			}
		}
		
        require([
            FT.vars.BASE_URL + 'statics/front/js/jquery-ui-1.9.1.custom/js/jquery-ui-1.9.1.custom.min.js'
        ], function (c, s) {
            $("#datepicker").datepicker({ dateFormat: 'yymmdd' });
            $("#datepicker1").datepicker({ dateFormat: 'yymmdd' });
        });
		
		$('.advance-time-limit').click(function(e) {
			$('.advance-time-limit-' + $(this).val() == 'day' ? 'range' : 'day').val('');	
        });
		
		$('.advance-time-limit-item').focus(function(e) {
            $(this).parent().siblings('.advance-time-limit').attr('checked', true);
        });
		
		$('.advance-image-id').focus(function(e) {
			var value 		= $(this).val();
			var defaulttext = $(this).attr('defaulttext');
            (value == defaulttext) && $(this).val('');
        }).blur(function(e) {
            ($(this).val() == '') && $(this).val($(this).attr('defaulttext'));
        });
		
		$('.advance-immediate-input').click(function(e) {
            $(this).siblings('ul').fadeIn();
        }).parent().hover(function(){
			$(this).find('ul:first').fadeOut();
		});
		
		$('.advance-immediate-select').click(function(e) {
            $(this).parent().fadeOut();
			$('.advance-immediate-input').val($(this).text());
			$('.advance-immediate').val($(this).attr('v'));
        });
		
		$('.select-collections-sum').css('color', '#FFFFFF');
		
        $(".qx_btn").click(function(){
            $(".gj_tc").hide();
        });
		
		$('.ss_btn').click(function(e) {
			var params = ['p=1'];
			var c = [];
			var i = [];
			var nk = '';
			
			keyword = parseUrl('k');
			
			/*$('.gj_nr:not(:hidden)').find('.advance-collections-item:checked').each(function(index, element) {
                var v = $(this).val();
				c.push(v);
            });*/
			$('.advance-collections-item:checked').each(function(index, element) {
                var v = $(this).val();
				c.push(v);
            });
			c.sort();
			/*c.length > 0 && $('.gj_nr:not(:hidden)').find('.advance-collections-item').size() > c.length && params.push('c=' + c.join('_'));*/
			c.length > 0 && params.push('c=' + c.join('_'));

			var image_id = $('.advance-image-id').val() != '' && $('.advance-image-id').val() != $('.advance-image-id').attr('defaulttext') ? $('.advance-image-id').val().split(/[\,|\ |\n]/) : [];
			for (var it in image_id) {
				//!isNaN(image_id[it]) && parseInt(image_id[it]) > 0 && 
				i.push(image_id[it]);
			}
			//i.sort();
			i.length > 0 && params.push('i=' + i.join('_'));
			
			if ($('.advance-time-limit:checked').val()) {
				var limit_type = $('.advance-time-limit:checked').val();
				var limits = $('.advance-time-limit-' + limit_type);
				
				switch (limit_type) {
					case 'day':
						$.isNumeric(limits.val()) && params.push('date_near_day=' + parseInt(limits.val()));
						break;
					case 'range':
						var data_limit = [];
						limits.each(function(index, element) {
                            $(this).val() && data_limit.push($(this).val());
                        });
						data_limit.length > 0 && params.push('date_limit=' + data_limit.join('-'));
						break;
				}
			}
			
			$('.advance-photographer').val() && params.push('photographer=' + encodeURIComponent($('.advance-photographer').val()));
			$('.advance-datephotographed').val() && params.push('pd=' + encodeURIComponent($('.advance-datephotographed').val()));
			$('.advance-location').val() && params.push('loc=' + encodeURIComponent($('.advance-location').val()));
			$('.advance-credit').val() && params.push('credit=' + encodeURIComponent($('.advance-credit').val()));
			$('.advance-immediate').val() && params.push('immediate=' + encodeURIComponent($('.advance-immediate').val()));
			
			nk = $('.advance-no-keyword').val();
			nk != '' && params.push('nk=' + encodeURIComponent(nk));
			
			keyword && params.push('k='+ keyword);

			//if (params.length > 0) {
			location.href = FT.vars.BASE_URL + 'search#' + params.join('&');
			
			FT.vars.SHORT_ID == '_search' && setTimeout(function(){
				location.reload();
			}, 100);
			//}
        });
		
        $(".gj_tt_right").click(function(){
            $(this).next(".gj_nr").slideDown().siblings(".gj_nr").slideUp();
        });
		
		$('.select-all-collection:not(.hasBind)').addClass('hasBind').click(function(e) {
			var c = $(this).attr('c');
			var checkbox = $('.checkbox-collection-item-' + c);
			var cm = $('.select-collections-sum-' + c);
			checkbox.attr('checked', true);
			cm.text(checkbox.size());
        });
		
		$('.deselect-all-collection:not(.hasBind)').addClass('hasBind').click(function(e) {
			var c = $(this).attr('c');
			var checkbox = $('.checkbox-collection-item-' + c);
			var cm = $('.select-collections-sum-' + c);
			checkbox.attr('checked', false);
			cm.text(0);
        });
    };

    bindKeywordAutoComplete = function() {
		
		if (typeof(FT.AutoComplete.Cookies) == 'undefined' || 
			typeof(FT.AutoComplete.Typeahead) == 'undefined') {
			return false;
		}
		
		var element = $('#search-form').find('input[name=k]'),
			cookies = FT.AutoComplete.Cookies,
			typeahead = FT.AutoComplete.Typeahead;

		if (cookies.get('cb_list_option_search_auto') == 1) {
			if ($('.twitter-typeahead').size() == 0) {
				typeahead.initTypeaheadTo({
					elem			: element[0],
					input_callback 	: function(jElem, info) {
						var menu = $('.tt-dropdown-menu');
	
						if (menu.find('.tt-close').size()<=0) {
							var li = document.createElement('li');
							$(li).addClass('tt-close')
							.css({'background':'#CCC', 'height':'20px', 'cursor' : 'pointer', 'color':'#06F'})
							.text('关闭搜索自动提示')
							.click(function(e) {
								cookies.set('cb_list_option_search_auto', 0);
								FT.bindKeywordAutoComplete();
								$('.option_search_auto').size() > 0 && $('.option_search_auto').attr('checked', false);
							})
							.appendTo('.tt-dropdown-menu');
						}
					},
					select_callback : function(suggestionData) {
						FT.vars.callback_to_search = true;
						FT.vars.callback_to_search_sec = false;
					}
				});
				
				$('.tt-query').on('keyup', function(e){
					if (e.keyCode == 13) {
						$('#search-form').submit();
					}
				});
				
				$('.twitter-typeahead').css({
					'width' : '390px',
					'display' : 'block',
					'z-index' : 100000
				})
				.find('.tt-dropdown-menu')
				.css({
					'font-size' : '12px',
					'margin-top' : 	element.height()
				})
				.parent()
				.find('.tt-hint')
				.css({
					'line-height' : '30px',
					'height' : '30px',
					'padding' : '0 10px',
					'border' : 'none 0',
					'color' : '#000000'
				});
			}
		} else {
			var coner = $('.twitter-typeahead').parent();
			$('.twitter-typeahead').remove();
			$(coner).prepend(element);
		}
	};
	
	FT.bindKeywordAutoComplete = bindKeywordAutoComplete;
	headerCategoriesHideHandle();
	FT.dialogInit = function(callback) {
		if (typeof(FT.Dialog) == 'undefined') 
		{
			requirejs(
				[
					FT.vars.FRONT_PATH + 'dialog.js', 
					FT.vars.FRONT_PATH + 'utils.js'
				], 
				function(dialog, utils) {
					utils.loadCSS(FT.vars.FRONT_PATH + '../skin/dialog.css');
					setTimeout(function(){
						FT.dialogInit(callback);
					}, 0);
				}
			);
			return;
		}
		callback();
	};
	
    return {
        inited: true
    };
});

var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?64280156fc0498249e99f73be375ff0c";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();