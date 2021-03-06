function cargarEstructura(url, func){
	$.ajax({
		url : '/estructura',
		type : 'get',
		success : function(estructura) {
			$("#page-top").html(estructura);
			$.ajax({
				async:true,
				url : url,
				type : 'get',
				success : (function(html){
					$("#page-content").html(html);
					func();
				}),
				error : (function(html){
					$("#page-content").html(html);
				})
			});
		},
		error : function(response) {
			console.log(response);
		}
	})
}