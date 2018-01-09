/**
 * @package     Corbis Frontend Dialog.
 * @since       Mar 14, 2013 #
 * @author      Fractal Technology Ltd.
 */
define(
    [ 
        FT.vars.FRONT_PATH + 'utils.js',
        FT.vars.BASE_URL + 'js/typeahead.0.8.1.js'
    ], 
    function (utils, Typeahead) {

        

        var TFT = {
            wildcard: '%keyword',
            wait: 20,
            limit: 10,
            maxConcurrentRequests: 2,
            dftTemplate: '<span>{{value}}</span>',
            initTypeaheadCommon: function () {
                var self = this;
                if ($.fn.typeahead.hasOwnProperty('configureTransport')) {
                    $.fn.typeahead.configureTransport({
                        wildcard: self.wildcard,
                        wait: self.wait,
                        maxConcurrentRequests: self.maxConcurrentRequests
                    });   
                }
            },

            createHiddenInputs: function (jElem, sTemplate) {
                var elemForm, sHTML, tmpArr, aInputNames;

                elemForm  = jElem.parents('form');

                tmpArr      = [];
                aInputNames = [];
                sHTML       = '';

                if (sTemplate.search(/\<(.*)\>/) !== 0) {
                    return tmpArr;
                }

                tmpArr = sTemplate.match(/([^\s]*)\=/g);

                for (var i = 0, len = tmpArr.length; i < len; i += 1) {
                    var sInputName = jElem.attr('name') + '_' + tmpArr[i].substr(0, tmpArr[i].length - 1);
                    aInputNames.push(sInputName);
                    if (elemForm.find('input[name="' + sInputName + '"]').length === 0) {
                        sHTML += '<input type="hidden" name="' + sInputName + '" value="0" />';
                    }
                }
                sHTML !== '' && elemForm.append(sHTML);

                return aInputNames;
            },

            initTypeaheadTo: function (OneInput) {
                
                var jElem, inputName, inputRemote, suggestTemplate, TypeaheadConfig,
                    self = this;
				
				utils.loadCSS(FT.vars.BASE_URL + 'statics/css/typeahead.css');
				
                if (OneInput && OneInput.elem) {
                    jElem = $(OneInput.elem);
                    this.wildcard   = jElem.attr('transport_wildcard') || this.wildcard;
                    this.wait       = jElem.attr('transport_wait') || this.wait;
                    this.limit      = jElem.attr('transport_limit') || this.limit;
                    this.maxConcurrentRequests = jElem.attr('transport_max') || this.maxConcurrentRequests;
                    inputName       = jElem.attr('name') || null;
                    inputRemote     = jElem.attr('remote') || null;
                    suggestTemplate = jElem.attr('template') || this.dftTemplate;

                    // create hidden inputs.
					if (jElem.attr('createhid') != '0') {
                    	this.aHidden    = this.createHiddenInputs(jElem, suggestTemplate);
					}
                }

                if (jElem && inputName && inputRemote) {

                    TypeaheadConfig = {
                        name: inputName,
                        limit: self.limit,
                        template: decodeURIComponent(suggestTemplate),
                        remote: inputRemote,
                        engine: Hogan,
    					select_callback : OneInput.select_callback || function(){} // select 事件触发的回调
                    };

                    if (typeof OneInput.input_callback === 'function') {
                        TypeaheadConfig.input_callback = OneInput.input_callback;
                    } else if (jElem.attr('save_all_values') === 'on') {
                        TypeaheadConfig.input_callback = function (jElem, info) {
                            self.handleHiddenValues(jElem, info);
                        };
                    }

                    this.initTypeaheadCommon();
                    jElem.typeahead(TypeaheadConfig);
                }
            },

            handleHiddenValues: function (jElem, info) {
                var elemFormId, sHTML, elemAttrs, aHidden, Attr, HiddenVal, i, len, sHiddenName;

                elemFormId  = jElem.parents('form').get(0).id;
                aHidden     = this.aHidden;
                len         = aHidden.length;
                HiddenVal   = {};
                sInputName  = jElem.attr('name');

                // init HiddenVal, return if no hidden inputs.
                if (len > 0) {
                    for (i = 0; i < len; i += 1) {
                        HiddenVal[aHidden[i]] = 0;
                    }
                } else {
                    return;
                }

                if (info && info.value === info.query) {
                    var elemAttrs = info.elem.children().get(0).attributes;

                    for (Attr in elemAttrs) {
                        if (elemAttrs.hasOwnProperty(Attr)) {
                            var attrName = elemAttrs[Attr].name;
                            var attrVal  = elemAttrs[Attr].value == 'null' ? '' : elemAttrs[Attr].value;
                            if (attrName !== undefined) {
                                attrName = sInputName + '_' + attrName;
                                HiddenVal[attrName] = attrVal;
                            }
                        }
                    }
                }

                for (sHiddenName in HiddenVal) {
                    var querySelecter = '#' + elemFormId + ' input[name="' + sHiddenName + '"]';
                    $(querySelecter).val(HiddenVal[sHiddenName]);
                }
            }
        };
        return TFT;
});