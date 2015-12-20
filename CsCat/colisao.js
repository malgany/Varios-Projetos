var raio_colisao = 12;

var position_obstacles = {
    pos54: { left: 325, top: 225 },
    pos76: { left: 225, top: 325 },
    pos13: { left: 75, top: 75 }
}

var colisionleft;
var colisiontop;
//pos
var pos_left_map, pos_top_map;
var pos_left_player, pos_top_player;


function colisoes() {

    //pega valores atuais para vallidar a colisao
    colisionleft = parseInt(getLeft()*-1)+parseInt(getLeftPlayer()) /*Correcao->*/ + parseInt(25);
    colisiontop = parseInt(getTop()*-1)+parseInt(getTopPlayer()) /*Correcao->*/ + parseInt(25);

    for (var item in position_obstacles) {
        if(
                (colisionleft + parseInt(25)) >= (position_obstacles[item].left - raio_colisao) &&
                (colisiontop + parseInt(25)) >= (position_obstacles[item].top - raio_colisao) &&
                (colisionleft - parseInt(25)) <= (position_obstacles[item].left + raio_colisao) &&
                (colisiontop - parseInt(25)) <= (position_obstacles[item].top + raio_colisao)
        ) {
            // set posicao anterior do mapa
            setLeft(pos_left_map);
            setTop(pos_top_map);

            // set posicao anterior do player
            setLeftPlayer(pos_left_player);
            setTopPlayer(pos_top_player);

            return false;
        }
    }
    pos_left_map = getLeft();
    pos_top_map = getTop();

    pos_left_player = getLeftPlayer();
    pos_top_player = getTopPlayer();

    return true;
}
