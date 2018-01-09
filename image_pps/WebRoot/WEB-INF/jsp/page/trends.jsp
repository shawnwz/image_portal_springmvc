<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader.jsp" /> 
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
		    <script type="text/javascript">
		var FT  = FT || {};
		FT.vars = FT.vars || {};
		FT.vars.BASE_URL    = '';
		FT.vars.FRONT_PATH  = FT.vars.BASE_URL + 'js/';
		FT.vars.JQUERY_PATH = FT.vars.FRONT_PATH + 'jquery-1.8.2.min.js';
		FT.vars.SHORT_ID    = '_collection_detail';
		FT.vars.CURR_UID    = "0";
		FT.vars.CURR_USER   = "";
		require([FT.vars.BASE_URL + 'js/front.js']);
	</script>
<!-- 内容区开始 -->
    <div class="trends-box">
    	<p class="trends-title">潮流趋势报告</p>
		<p class="trends-center"><span>最新的 ── 未来的 ── 摄影图像</span> 是一系列的创意研究报告。这些报告追踪最新的文化及社会趋势，展示相关的新摄影图库，并且研究这些潮流趋势对不同行业、教育、健康、生活方式的影响。</p>
        
        <div id="trends-img" class="trends-img">
       	  <a href="#" onmouseover="trendpic(0)" onmouseout="cleartrend()">
            	<img src="images/linshi/lifestyle_tile_CH-284x211.png" />
          <p>新生活方式趋势</p>
            </a>
        	<a href="#" onmouseover="trendpic(1)" onmouseout="cleartrend()">
            	<img src="images/linshi/CHS-284x211.jpg" />
                <p>把握每一天(Carpe Diem)</p>
            </a>
        	<a href="#" onmouseover="trendpic(2)" onmouseout="cleartrend()">
            	<img src="images/linshi/image-inc-CHS-tile-Copy-284x211.jpg" />
                <p>图片公司(Image, Inc)</p>
            </a>
        	<a href="#" onmouseover="trendpic(3)" onmouseout="cleartrend()">
            	<img src="images/linshi/under-21s-cover-en.jpg" />
            <p>21岁以下(Under 21)</p>
            </a>
        	<a href="#" onmouseover="trendpic(4)" onmouseout="cleartrend()">
            	<img src="images/linshi/gender-112-284x211.jpg" />
                <p>新性别常模(New Gender Norms)</p>
            </a>
        	<a href="#" onmouseover="trendpic(5)" onmouseout="cleartrend()">
            	<img src="images/linshi/energy-1-284x211.jpg" />
                <p>能源(Energy)</p>
            </a>
        	<a href="#" onmouseover="trendpic(6)" onmouseout="cleartrend()">
            	<img src="images/linshi/realtime-118-284x211.jpg" />
                <p>此时此刻(Real Time)</p>
            </a>
        	<a href="#" onmouseover="trendpic(7)" onmouseout="cleartrend()">
            	<img src="images/linshi/smarthappens-1-42-284x211.jpg" />
                <p>生出智慧(Smart Happens)</p>
            </a>
            
        </div>
        
        <p class="trends-bottom">
        	<span>阅读详情 潮流趋势报告</span><br /><br />我们知道寻找合适的图像并不容易。完美的图像必须独一无二、紧贴时代步伐，并且配合您的故事。作为您的创意伙伴，Corbis® Images 让您时刻知道最新的 ──及未来的── 图像潮流趋势。<br />潮流趋势报告 是一系列的创意研究报告。这些报告追踪最新的文化及社会趋势，展示相关的新摄影图库，并且研究这些潮流趋势对不同行业、教育、健康、生活方式的影响。<br /><br />创意研究报告是跨文化研究，预测未来几年影响全球视觉内容发展的趋势。<br /><br />我们对销售量最高的创意及编辑类图像，以及最新的人口和心理变量统计数据，进行深入分析。我们的专家通过研究，希望更理解这些图像的潜在价值和意义，让顾客对图像可以产生情感上的连系。这样做可以确保 Corbis 摄影图像能够时时刻刻都是最有用的、最配合时代需要的。
        </p>
    </div>
  
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  