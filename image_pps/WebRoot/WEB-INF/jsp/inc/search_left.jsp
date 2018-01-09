<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.gaopin.utils.StrUtils"%>
<%@page import="com.gaopin.entity.User"%>
           
<form id="leftform" >
        <div class="piclist" id="pic_left">
        	<div id="piclist0" class="forleftfilter">
                <p class="piclist-listtop"><a href="javascript:void(0);" onclick="clearSearch();"><img src="images/renews.png" /></a>清除所有筛选项(<span>0</span>)</p>
                <!-- 第一部分 -->
                <p class="piclist-bigtitle" onclick="chickshow('picline0','pictitle0')"><a id="pictitle0"><img src="images/left-title-acc.gif" /></a>类别</p>         
                <div class="piclist-littleline" id="picline0">
                	<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="checkbox_any"  class="checkany" value="-1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="checkbox_creativity" value="-2" onchange="alert('创意类')"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">创意类</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="660" name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">版权管理图片（RM）</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="662" name="cate_id" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">免版税图片（RF）</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="checkbox_edition"  value="-3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">编辑类（RM）</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="661" name="cate_id" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">纪实</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="683"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">时事</label></div><!-- ,665 -->
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="664"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">体育</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="682"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">娱乐</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="666"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">历史</label></div>
					<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="680"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">艺术作品</label></div>
            		<div class="littleline-se"><div class="icheckbox_minimal-aero"><input type="checkbox" value="669"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">Outline</label></div>
	<!-- 							<div class="littleline-se"  style="display:none;"><div class="icheckbox_minimal-aero"><input type="checkbox" value="690"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">娱乐在线</label></div>
					<div class="littleline-se" style="display:none;"><div class="icheckbox_minimal-aero"><input type="checkbox" value="9"  name="cate_id"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">档案</label></div> -->		
                </div>
 				<div class="piclist-bigtitle" style="display: none;"><span><div class="icheckbox_minimal-aero"><input type="checkbox" name="is_cd" value="1" /><ins class="iCheck-helper" ></ins></div></span><label class="icheck_label">仅限虚拟CD (RF)</label></div>
                <p class="piclist-bigtitle" onclick="chickshow('picline1','pictitle1')"><a id="pictitle1"><img src="images/left-title-acc.gif" /></a>类别</p>
                <div class="piclist-littleline" id="picline1">
                	<p class="piclist-smalltitle">人数</p>
                	<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">无人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">1人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">2人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="4"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">3人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="5"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">4人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num"  value="6"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">5人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="person_num" value="7"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">人群:6人+</label></div>
                    <p class="piclist-smalltitle">性别</p>
                	<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="sex" value="-1"  class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="sex" value="1" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">仅男性</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="sex" value="2" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">仅女性</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="sex" value="3" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">男性和女性</label></div>
					<p class="piclist-smalltitle">年龄</p>
                	<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="-1"  class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="0" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">所有儿童:0-12岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="1" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">婴儿:0-23个月</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="2" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">孩童:2-9岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="3" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">少年:10-12岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="4" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">青少年:13-17岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="5" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">青年:18-29岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="6" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">中年:30-39岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="7" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">中老年:40-59岁</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="age" value="8" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">老年:60岁+</label></div>
					<p class="piclist-smalltitle">种族</p>
                	<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="-1"  class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="5" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">亚洲人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="1" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">白人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="2" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">多种族</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="3" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">黑人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="4" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">拉美人</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="race" value="6" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">中东人</label></div>
					
					</div>
				
			    <p class="piclist-bigtitle" onclick="chickshow('picline2','pictitle2')"><a id="pictitle2"><img src="images/left-title-acc.gif" /></a>图像特点</p>
                <div class="piclist-littleline" id="picline2">
                    <p class="piclist-smalltitle">类型</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="type" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="type" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">插画</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="type" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">摄影</label></div>
					
					<p class="piclist-smalltitle">颜色</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"   name="color" value="-1" class="checkany" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何颜色</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="color" value="9" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">彩色</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="color" value="10" /><ins class="iCheck-helper" ></ins></div><label class="icheck_label">黑白</label></div>
					<input type="hidden" name="color" value="-1" id="hiddencolor" style="display:none;"/>
                    <p id="leftcolor">
                    	或指定特定的颜色：<br />
                        <i class="left-color-red" onclick="selectLeftColor(1,$(this))"></i>
                        <i class="left-color-orange" onclick="selectLeftColor(2,$(this))"></i>
                        <i class="left-color-yellow" onclick="selectLeftColor(3,$(this))"></i>
                        <i class="left-color-green" onclick="selectLeftColor(4,$(this))"></i>
                        <i class="left-color-cyan" onclick="selectLeftColor(5,$(this))"></i>
                        <i class="left-color-blue" onclick="selectLeftColor(6,$(this))"></i>
                        <i class="left-color-violet" onclick="selectLeftColor(7,$(this))"></i>
                        <i class="left-color-pink" onclick="selectLeftColor(8,$(this))"></i>
                    </p>
                    <p class="piclist-smalltitle">方向</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="direction" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="direction" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">方片</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="direction" value="3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">横片</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="direction" value="4"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">全景</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="direction" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">竖片</label></div>
					
					<p class="piclist-smalltitle">肖像权</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="portrait" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="portrait" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">有模特肖像权</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="portrait" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">有产权使用授权</label></div>
                </div>
                
                
                <p class="piclist-bigtitle" onclick="chickshow('picline3','pictitle3')"><a id="pictitle3"><img src="images/left-title-acc.gif" /></a>构图</p>
                <div class="piclist-littleline" id="picline3">
                   	<p class="piclist-smalltitle">风格</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="style" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="style" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">户外</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="style" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">剪影</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="style" value="3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">镜头模糊</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="style" value="4"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">室内</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="style" value="5"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">影棚拍摄</label></div>
					
					
					<p class="piclist-smalltitle">布局</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="layout" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">白色背景</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">部分取景</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">单色背景</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="4"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">抠图效果</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="5"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">留白</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="6"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">全身</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="layout" value="7"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">头和肩</label></div>
					
					
					<p class="piclist-smalltitle">拍摄视角</p>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox"  name="angle" value="-1" class="checkany"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">任何</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="1"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">背面拍摄</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="2"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">不看镜头</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="3"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">俯拍</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="4"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">航拍</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="5"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">看镜头</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="6"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">特写</label></div>
					<div><div class="icheckbox_minimal-aero"><input type="checkbox" name="angle" value="7"/><ins class="iCheck-helper" ></ins></div><label class="icheck_label">仰拍</label></div>
					
					
				</div>
				
				<p class="piclist-bigtitle" onclick="chickshow('picline4','pictitle4')"><a id="pictitle4"><img src="images/left-title-acc.gif" /></a>上传日期</p>

				<div class="piclist-littleline" id="picline4">
                    <div class="select-widget" callback="afterFilterChange();">
                    	<input type="hidden" name="create_time" value=""/>
                        <input value="任何" readonly="readonly" class="checkany" name="nv_showname"/>
                        <img src="images/pic_menu_more.png"/>
                      	<div>
                            <a href="javascript:void(0);" value="-1"><p>任何</p></a>
                            <a href="javascript:void(0);" value="1:D"><p>过去1天</p></a>
                            <a href="javascript:void(0);" value="1:W"><p>过去1周</p></a>
                            <a href="javascript:void(0);" value="1:M"><p>过去1月</p></a>
                            <a href="javascript:void(0);" value="1:Y"><p>过去1年</p></a>
                            <a href="javascript:void(0);" value="2:Y"><p>过去2年</p></a>
                            <a href="javascript:void(0);" value="3:Y"><p>过去3年</p></a>
                        </div>
                    </div>                  
                </div>
				
				
                
			</div>
        	
        

        	<div id="piclist1" class="mylightbox-left forleftlightbox" style="display:block;">
                <p class="mylightbox-left-title">灯箱<img src="images/mylingbox_titleimg.png" /></p>
                <p></p>
                    <div class="select-widget" callback="refreshlightboxitems();">
                    	<input value="-1" type="hidden" name="nv_light_id"/>
                        <input value="灯箱0" readonly="readonly" name="nv_light_name"/>
                        <img src="images/mylingbox_select.png" />
                      	<div style="position: absolute;top: 31px;">
                          	<a href="javascript:void(0);" value="1"><p>灯箱0</p></a>
                      </div>
                    </div>
                <p></p>
                <p><a href="javascript:void(0);" onclick="AddNewLightBox();">创建灯箱</a></p>
                <div id="mylightbox" class="mylightbox-left-imgbox">
                	
                </div>
               
                <p><a href="javascript:void(0);" class="mylightbox-left-button" onclick="DownloadAllinBox();">快速下载</a></p>
			</div>


            <div class="piclist-tag">
                <a href="javascript:tag_change('piclist','piclisttag','0','2');" class="on forleftfilter" id="piclisttag0"><img src="images/pic_menu_big.png" /><br />优<br />化</a>
                <a href="javascript:tag_change('piclist','piclisttag','1','2');" class ="forleftlightbox" onclick="refreshlightbox();" id="piclisttag1"><img src="images/pic_menu_help.png" /><br />灯<br />箱</a>
            </div>
        </div>
</form>

    
    
       