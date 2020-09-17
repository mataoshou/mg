
				
				
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