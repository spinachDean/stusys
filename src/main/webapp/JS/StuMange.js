$(document).ready(function(){
	$(".father_menu").click(function(){
		$(this).next().slideToggle(500);
		$(this).find("img").attr("height",50);
	});

function addID(){
	var li = $("#left_bar li");
for (var i = li.length - 1; i >= 0; i--) {
	li[i].id(i);
	console.log(i);
}
}
addID();

$("#left_bar li").click(function(e){
		var URL = $(".menuURL");
		var dd= $(this).attr("id");
		console.log(dd);
	})
		



})


	