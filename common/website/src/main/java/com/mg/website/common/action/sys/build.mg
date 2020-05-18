<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>


	<body>
		<script src="jquery"></script>


		<div class="sys-top-oper" style="background: #00F7DE; height: 100px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;;">选择生成内容</div>
			<span style="width: 200px;display: inline-block;height: 30px;"> 选择操作类型:  </span>
			<select class="sys-type" style="width: 150px;height: 30px;">
				<option value="7">API/FEIGN构建</option>
				<option value="1">api接口</option>
				<option value="2">Feign</option>
				<option value="3">数据库构建</option>
				<option value="5">缓存构建</option>
				<option value="6">DAO构建</option>
			</select>
		</div>

		<div class="sys-center-show" style="background: #00F7DE;height: 380px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;">选择生成参数</div>


			<div class="util-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> repository类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-repository">
				</select>
			</div>


			<div class="pojo-dto-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 输入dto选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-in-dto">
				</select>
			</div>

			<div class="pojo-dto-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 输出dto选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-out-dto">
				</select>
			</div>

			<div class="pojo-bo-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 输入bo类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-in-bo">
				</select>
			</div>
			<div class="pojo-bo-content">
				<span style="width: 200px;display: inline-block;height: 30px;">  输出bo类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-out-bo">
				</select>
			</div>



			<div class="pojo-vo-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 输入vo类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-in-vo">
				</select>
			</div>

			<div class="pojo-vo-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 输出vo类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-out-vo">
				</select>
			</div>


			<div class="pojo-po-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> po类选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-pojo-po">
				</select>
			</div>

			<div class="sys-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 系统名称选择:  </span>
				<select style="width: 350px;height: 30px;" class="sys-name">
				</select>
			</div>

			<div class="method-content">
				<span style="width: 200px;display: inline-block;height: 30px;"> 函数列表:  </span>

				<input  style="width: 350px;height: 30px;" class="class-method" value="get,edit,list,delete"/>

			</div>
		</div>

		<div class="sys-center-oper" style="background:#00F7DE;height: 200px; width: 700px;margin-left: 400px;margin-bottom:5px;padding: 30px;padding-top: 10px;">
			<div style="background: #C0C4CC;width: 690px;height: 30px;; padding-left: 20px;margin-bottom: 10px;padding-top: 4px;">生成对象</div>

			<label>名称：</label>
			<input class = "build-name" style="width: 150px; height: 30px;;" />
			<input type="button" value="新建" onclick="MT.sys_build(0)" />
			<input type="button" value="重新生成" onclick="MT.sys_build(1)" />
			<input type="button" value="删除" onclick="MT.sys_build(2)" />
			<input type="button" value="添加函数" onclick="MT.sys_build(3)" />

		</div>

		<script>
			$(function(){
				MT.init_center(1);
				$(".sys-type").change(function(){
					var val = $(".sys-type").val();
					MT.change_center(val);
				})
			})


			MT={};

			MT.init_center = function(val)
			{
				MT.init_center_show(val);
				MT.init_center_oper(val);
				MT.change_center(val);
			}


			MT.setname = function()
			{
				$(".build-name").val($(".sys-pojo").find("option:selected").text().trim());
			}

			MT.selects = [".sys-repository",".sys-pojo-in-dto",".sys-pojo-out-dto",
			".sys-pojo-in-vo",".sys-pojo-out-vo",".sys-pojo-in-bo",".sys-pojo-out-bo",".sys-pojo-po",".sys-name"];
			MT.urls = ["/sys/list/repository","/sys/list/dto","/sys/list/dto",
			"/sys/list/vo","/sys/list/vo",
			"/sys/list/bo","/sys/list/bo",
			"/sys/list/po","/sys/list/sysName"];
			MT.build_urls = ["/sys/oper/api","/sys/oper/feign","/sys/oper/db","/sys/oper/cache","/sys/oper/bo","/sys/oper/buildAll"]

			MT.init_center_show = function(val)
			{
				for(var j=0;j<MT.selects.length;j++)
				{
					MT.api(MT.urls[j],function(data,carrys){
						var vals = data;
						//alert(selects[carrys]  + ".." +carrys);
						for(var i=0;i<vals.length;i++)
						{
							$(MT.selects[carrys]).append("<option value='" + vals[i].key + "'>"+vals[i].value+"</option>");
						}

					},{},j);
				}
			}


			MT.sys_build = function(createType)
			{
				var val = $(".sys-type").val();

				var req ={};
				req.name = $(".build-name").val();
				req.repositoryName = $(".sys-repository").val();
				req.inDtoName = $(".sys-pojo-in-dto").val();
				req.outDtoName = $(".sys-pojo-out-dto").val();
				req.inVoName = $(".sys-pojo-in-vo").val();
				req.outVoName = $(".sys-pojo-out-vo").val();
				req.inBoName = $(".sys-pojo-in-bo").val();
				req.outBoName = $(".sys-pojo-out-bo").val();
				req.poName = $(".sys-pojo-po").val();
				req.sysName = $(".sys-name").val();
				req.oper = $(".class-method").val();
				req.createType = createType;
				MT.api(MT.build_urls[val/1-1],function(data){

					if(data.code==100)
					{
						alert("生成成功！！")
					}
					else
					{
						alert(data.errorReason)
					}


				},req);
			}

			MT.init_center_oper = function(val)
			{


			}


			MT.change_center = function(val)
			{
				if(val==1)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
				}
				else  if(val==2)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
				}
				else  if(val==3)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
				}
				else  if(val==4)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
				}
				else  if(val==5)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
				}
				else  if(val==6)
				{
					$(".util-content").css("display","block");
					$(".pojo-content").css("display","block");
					$(".sys-content").css("display","block");
					$(".method-content").css("display","block");
					$(".class-method").val("get,insert,list,update,delete");
				}

			}

			MT.build_center_show = function(val)
			{
				//$(".sys-center-show").html("");

			}



			MT.build_center_oper = function(val)
			{
				//$(".sys-center-oper").html("");

			}

			MT.api =function(url,success,data,carrys){
				$.ajax({
		            type: "post",
		            url: url,
		            data : JSON.stringify(data),
		            contentType : "application/json",
		            success: function(result) {
		                success(result,carrys);
		            },error:function(xmlcontent,reason,e)
		            {
		            	alert(reason)
		            }
		        });
			}
		</script>
	</body>


</html>