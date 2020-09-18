
				
				
var MG_API={};

MG_API.request=function(serviceUri,req,success)
{
	jQuery.ajax({
		url: serviceUri, 			
		method: "POST", 
		processData: false,	
		data: JSON.stringify(req), 
		dataType: 'json',
		contentType: 'application/json',
		success: function(ans){
			if(ans.code !=100)
			{
				alert(ans.msg);			
			}
			success(ans.data);
		}
	});
}

MG_API.getUrlParam = function (name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	
	if (r != null) return unescape(r[2]);
	return null; //返回参数值
}