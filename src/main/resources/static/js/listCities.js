/**
 * 
 */
$(document).ready(function(){
//	alert("hello");
	
	$("#Id_Depto").on("change", function () {
		var dpto = $(this).val();
		$.get("http://localhost:8080/usuario/listCity/"+dpto, function(data){
			$("#Id_Ciudad").html(data);
		});
	});
});
	