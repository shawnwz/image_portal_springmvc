(function(a){a(function(){if(window.SubscriptionData!=undefined){CI.UI.Dialogs.Dialog(a("#subscription-status"),a("#subscription-dialog"),{dialogClass:""});a("#subscription-cancel").bind("click",function(b){b.preventDefault();a("#subscription-dialog").dialog("close");});a("#subscription-select").bind("click",function(b){a.post("/ChangePicPlan",{companyId:a("select","#subscription-choose-account").val(),rememberContext:!a(":checkbox","#subscription-persist").isChecked()},function(){window.location.reload();});});if(SubscriptionData.showChooser){a("#subscription-cancel").css({display:"none"});a("#subscription-status a").trigger("click");}}});})(window.jQuery);