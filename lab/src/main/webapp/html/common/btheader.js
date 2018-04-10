$(function(){
		//由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
		;!function() {
			var layer = layui.layer, form = layui.form;
		}();
	
		//第一个可见的input获取焦点
		$("body").find("input:visible").eq(0).focus();
		
	});
	//设置表格列宽可自动拖动设置
	function colResize(){
		$("table").each(
				function(){
					$(this).colResizable();
				}
		);
	}
	//打开layer弹出层
	function lopen(url,title) {
		layer.open({
			type : 2,
			title:title,
			area : [ '50%', '90%' ],
			fixed : false, //不固定
			maxmin : true,
			content : url,
			end:function(){
				$("table").each(
					function(){
						$(this).bootstrapTable('refresh');
					}
				);
			}
		});
	}

	//关闭当前layer层
	function closeLayer(){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);
	}
	
	//设置当前页面为只读
	function setPageReadOnly(){
		$("input").attr("readonly","readonly");
		$("select").attr("disabled","disabled");
		$("input[type='radio']").attr("disabled","disabled");
		$("input[type='checkbox']").attr("disabled","disabled");
	}
	
	//根据参数去后台获取对应key的值 一般上用来 id换name
	function getVByK(tname, bykeyname, bykeyvalue, keyout){
		var result = "";
		var url = basepath+"/common/getVByK.do";
		$.ajax({
			url:url,
			type:'POST',
			data:{
				tname:tname,
				bykeyname:bykeyname,
				bykeyvalue:bykeyvalue,
				keyout:keyout
			},
			async:false,
			success:function(data){
				if(data.issuccess){
					result= data.data;
				} 
			}
		});
		return result;
	}
	