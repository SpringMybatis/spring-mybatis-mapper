<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>books</title>
<script type="text/javascript">
    function insert(){
    	//1.创建对象
        var oAjax = null;
        if(window.XMLHttpRequest){
            oAjax = new XMLHttpRequest();
        }else{
            oAjax = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2.连接服务器  
        oAjax.open('GET', "book/insertBookList.do", true);   //open(方法, url, 是否异步)
        //3.发送请求  
        oAjax.send();
        //4.接收返回
        oAjax.onreadystatechange = function(){  //OnReadyStateChange事件
            if(oAjax.readyState == 4){  //4为完成
                if(oAjax.status == 200){    //200为成功
                    alert('书籍插入成功');
                }else{
                    alert('书籍插入失败');
                }
            }
        };
    }
    
    function downLoad(){
    	//1.创建对象
        var oAjax = null;
        if(window.XMLHttpRequest){
            oAjax = new XMLHttpRequest();
        }else{
            oAjax = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2.连接服务器  
        oAjax.open('GET', "book/downLoadJpeg.do", true);   //open(方法, url, 是否异步)
        //3.发送请求  
        oAjax.send();
        //4.接收返回
        oAjax.onreadystatechange = function(){  //OnReadyStateChange事件
            if(oAjax.readyState == 4){  //4为完成
                if(oAjax.status == 200){    //200为成功
                    var src = oAjax.responseText;
                    //创建img对象
                	var img=new Image();
                	//开始下载图像
                	img.src="/books"+src;
                	//你打算把动态加载的图片放在那里的div容器
                	var imgContainer=document.getElementById("img");
                	//将创建好的图像对象添加到div中
                	imgContainer.appendChild(img);
                }else{
                    alert('请求图片下载失败');
                }
            }
        };
    }
</script>
</head>
<body>
	<h1>books</h1>
	<form action="">
		<input type="button" id="test1" value="插入数据库" onclick="insert()" />
		<input type="button" id="test2" value="下载图片" onclick="downLoad()"/>
	</form>
	<div id="img"></div>
</body>
</html>