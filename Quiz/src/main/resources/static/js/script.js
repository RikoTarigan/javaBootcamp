$(document).ready(function()
{
	$('#btnSubmit').click(function(){
		$.ajax({
			url:'/listenajax',
			type:'GET',
			data:{
				"answer" : $('#radio').val()
			}
		});
	});
});