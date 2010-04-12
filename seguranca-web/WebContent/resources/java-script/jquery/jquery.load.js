function showLoad(){
	
	var maskHeight = j(document).height();
	var maskWidth = j(window).width();

	j('#mask').css({'width':maskWidth,'height':maskHeight});

	j('#mask').fadeIn(0);	
		
	var winH = j(window).height();
	var winW = j(window).width();
          
	j('#dialog').css('top',  winH/2-j('#dialog').height()/2);
	j('#dialog').css('left', winW/2-j('#dialog').width()/2);

	j('#dialog').fadeIn(0);
}

function hideLoad(){
	j('#mask').css({'width':0,'height':0});
	j('.window').hide();
}