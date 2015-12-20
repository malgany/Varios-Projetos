var obstacles = [13, 54, 76];
$( document ).ready(function(){
    var parede = "";
    for(var i=0;i<144;i++){
        if(obstacles.indexOf(i) >= 0)
            $("#submapa").append("<div class='parede'>"+i+"</div>");
        else
            $("#submapa").append("<div class='quadrado'>"+i+"</div>");
    }
    posicionaPlayer("center");
});
