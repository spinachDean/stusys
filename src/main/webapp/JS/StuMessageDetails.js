function edit(){
	$(".edit").click(function(){
		var title = $(this).parents("th.edit_th").text().slice(0,4);  //get edit modal title
		$("#modal_content h1").text(title+"-修改");
		$("#edit_modal").show();
	})
	$("#modal_content img").mouseover(function(){
		$(this).attr("src","../images/shutUp_dark.png");
	})
	$("#modal_content img").mouseout(function(){
		$(this).attr("src","../images/shutUp_light.png");
	})
	$("#modal_content img").click(function(){
		if(confirm("是否退出此窗口"+"\n"+ "退出后将删除已输入内容")){
			$("#edit_modal").hide();
			$("#modal_content textarea").val("");
		}
	})
}

edit();


//页码
function page(ID){
	var itemNum = $(ID).children().length;   //总内容条数
	var itemPer = 10;
	var pageNum=Math.ceil(itemNum/itemPer);	//计算总页码数
	var liHeight = parseInt($(ID).children().css("height"));
	var ulHeight = liHeight*itemPer+itemPer;
	$(ID).css("height",ulHeight+"px");
	//创建与页码等数量的ul
	// console.log(itemNum,pageNum);
	// for(var i=1;i<=pageNum;i++){
	// 	var ul=$("<ul></ul>");
	// 	for(var j=0;j<itemPer;j++){
	// 		ul.append($("#competeUl li").eq(j));
	// 	}
	// 	$("#messageContent").append(ul);
	// }
	//创建页码元素
	for(var i=1;i<=pageNum;i++){
		var li=$("<li></li>");
		li.html(i);
		li.css("width","30px");
		$("#page ul li").eq(i).after(li);
	}
}
page(competeUl);