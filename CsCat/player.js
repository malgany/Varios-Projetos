var mov = "submapa";
var direcao_player;
var direcao_anterior_player;
var direita = esquerda = cima = baixo = 0;

function posicionaPlayer(tipo) {

    var width = $("#mapa").width();
    var height = $("#mapa").height();

    if(tipo == "center" || tipo == "top") {
            $("#player").css("top", ((width/2)-($("#player").width()/2)) );
    }

    if(tipo == "center" || tipo == "left") {
            $("#player").css("left", ((height/2)-($("#player").height()/2)) );
    }
}

function movimento() {

        if (teclado.pressionada(SETA_ESQUERDA)) {
            if(esquerda)
                $("#player").css("left", (getLeftPlayer()-velocidade)+"px");
            else
                $("#submapa").css("left", (parseFloat(getLeft())+velocidade)+"px");
        }
        if (teclado.pressionada(SETA_CIMA)) {
            if(cima)
                $("#player").css("top", (getTopPlayer()-velocidade)+"px");
            else
                $("#submapa").css("top", (parseFloat(getTop())+velocidade)+"px");
        }
        if (teclado.pressionada(SETA_DIREITA)) {
            if(direita)
                $("#player").css("left", (parseFloat(getLeftPlayer())+velocidade)+"px");
            else
                $("#submapa").css("left", (getLeft()-velocidade)+"px");
        }
        if (teclado.pressionada(SETA_BAIXO)) {
            if(baixo)
                $("#player").css("top", (parseFloat(getTopPlayer())+velocidade)+"px");
            else
                $("#submapa").css("top", (getTop()-velocidade)+"px");
        }
        // Valida colisoes
        if(!colisoes()) {
            return;
        }
        mantemNosLimites();
}

function mantemNosLimites(){

    var difLeft = $("#submapa").css("left").replace("px","")

    if(getLeft() < -300 && direita == 0) {
        setLeft(-300);
        destravaPlayer("direita");
        return
    }

    if(getLeft() > 0 && esquerda == 0) {
        setLeft(0);
        destravaPlayer("esquerda");
        return
    }

    if(getTop() > 0 && cima == 0) {
        setTop(0);
        destravaPlayer("cima");
        return
    }

    if(getTop() < -300 && baixo == 0) {
        setTop(-300);
        destravaPlayer("baixo");
        return
    }

    if(direita == 1 || esquerda == 1 || cima == 1 || baixo == 1) {
        var width = $("#mapa").width();
        var height = $("#mapa").height();
        var width_player = $("#player").width()
        var height_player = $("#player").height()

        if(direcao_player == "direita" || direcao_anterior_player == "direita") {
            // Não deixa passar do limite
            if(getLeftPlayer() > (width-width_player)) {
                setLeftPlayer(width-width_player);
            }
            //
            if(getLeftPlayer() < ((width-width_player)/2)) {
                setLeftPlayer((width-width_player)/2);
                travaPlayer("direita");
            }
        }
        if(direcao_player == "esquerda" || direcao_anterior_player == "esquerda") {
            // Não deixa passar do limite
            if(getLeftPlayer() < 0) {
                setLeftPlayer(0);
            }
            //
            if(getLeftPlayer() > ((width-width_player)/2)) {
                setLeftPlayer((width-width_player)/2);
                travaPlayer("esquerda");
            }
        }
        if(direcao_player == "cima" || direcao_anterior_player == "cima") {
            // Não deixa passar do limite
            if(getTopPlayer() < 0) {
                setTopPlayer(0);
            }
            //
            if(getTopPlayer() > ((height-height_player)/2)) {
                setTopPlayer((height-height_player)/2);
                travaPlayer("cima");
            }
        }
        if(direcao_player == "baixo" || direcao_anterior_player == "baixo") {
            // Não deixa passar do limite
            if(getTopPlayer() > (height-height_player)) {
                setTopPlayer(width-width_player);
            }
            if(getTopPlayer() < ((height-height_player)/2)) {
                setTopPlayer((height-height_player)/2);
                travaPlayer("baixo");
            }
        }
    }
}

function destravaPlayer(direcao) {
    // Guarda as ultimas direções que o player destravou
    // mas apenas se já não estiver salvo
    if(direcao != this.direcao_anterior_player && direcao != this.direcao_player) {
        this.direcao_anterior_player = this.direcao_player;
        this.direcao_player = direcao;
    }
    switch (direcao) {
        case "direita":
            direita = 1;
            esquerda = 1;
            break;
        case "esquerda":
            direita = 1;
            esquerda = 1;
            break;
        case "cima":
            baixo = 1;
            cima = 1;
            break;
        case "baixo":
            baixo = 1;
            cima = 1;
            break;
    }
}

function travaPlayer(direcao) {
    // seta para undefined, só pra resetar
    if(direcao_player == direcao)
        direcao_player = undefined;
    if(direcao_anterior_player == direcao)
        direcao_anterior_player = undefined;

    // undefined não pode ficar na variavel direcao_player,
    // por ser a principal. ps: apenas se as duas forem undefined
    if(direcao_anterior_player != undefined && direcao_player == undefined){
        direcao_player = direcao_anterior_player;
        direcao_anterior_player = undefined;
    }

    switch (direcao) {
        case "direita":
            direita = 0;
            esquerda = 0;
            break;
        case "esquerda":
            direita = 0;
            esquerda = 0;
            break;
        case "cima":
            baixo = 0;
            cima = 0;
            break;
        case "baixo":
            baixo = 0;
            cima = 0;
            break;
    }
}

//submapa Left e Top
function getLeft() {
    return $("#submapa").css("left").replace("px","");
}

function setLeft(left) {
    $("#submapa").css("left", left+"px");
}

function getTop() {
    return $("#submapa").css("top").replace("px","");
}

function setTop(top) {
    return $("#submapa").css("top", top+"px");
}

//player Left e Top
function getLeftPlayer() {
    return $("#player").css("left").replace("px","");
}

function setLeftPlayer(left) {
    $("#player").css("left", left+"px");
}

function getTopPlayer() {
    return $("#player").css("top").replace("px","");
}

function setTopPlayer(top) {
    $("#player").css("top", top+"px");
}
