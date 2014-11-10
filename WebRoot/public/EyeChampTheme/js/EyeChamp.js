$( document ).ready(function() {

	$("#newPlayerBtn").click(function(){
		$("#newPlayerForm").toggleClass("hide");
	});
	
	$("#nameInput").blur(function(event, ui){
		window.location.href = path+"/player/add/"+event.currentTarget.value;		
	});
	
});