
$.get("../HTML/index.html",function(data){
	data=data.slice(data.indexOf('<body>'),data.indexOf('</body>'));
	$("#frameWork").html(data);
})

