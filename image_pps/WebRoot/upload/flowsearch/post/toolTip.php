<?php


$imgId=$_POST['imgId'];
$lightBoxId=$_POST['lightBoxId'];
// 根据 图片id 和当前灯箱id 判断此图片是否被添加到灯箱 
// 如果是 imgLightBoxedClass="lightBoxed"
// 如果否 imgLightBoxedClass="";
// 此处先写假数据 

echo '{"status":1, "errorMsg":"error msg", "imgId":"'.$imgId.'"}';
?>

