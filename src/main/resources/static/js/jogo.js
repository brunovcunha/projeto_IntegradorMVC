function acao(jogada) {

    let jogador1PodeAtacar = true;
    let jogador2PodeAtacar = true;

    let jogadaInimigo = Math.floor(Math.random() * 3) + 1;
    let resultadoTexto = document.getElementById("texto");

    let imgJogador1 = document.getElementById("imgJogador1");
    let imgJogador2 = document.getElementById("imgJogador2");

    if (jogada === 1 && jogadaInimigo === 3) {
        resultadoTexto.innerHTML = "Vitória";

        imgJogador1.src = "../static/img/cavaleiro_ataque.png";
        imgJogador2.src = "../static/img/cavaleiro_descansa.png";
    } else if (jogada === 3 && jogadaInimigo === 1) {
        resultadoTexto.innerHTML = "Derrota";

        imgJogador1.src = "../static/img/cavaleiro_descansa.png";
        imgJogador2.src = "../static/img/cavaleiro_ataque.png";

    } else if (jogada === 1 && jogadaInimigo === 2){
        resultadoTexto.innerHTML = "Defendeu";

        imgJogador1.src = "../static/img/cavaleiro_ataque.png";
        imgJogador2.src = "../static/img/cavaleiro_defesa.png";
    }
    else if (jogada === 2 && jogadaInimigo === 1){
        resultadoTexto.innerHTML = "Defendeu";

        imgJogador1.src = "../static/img/cavaleiro_defesa.png";
        imgJogador2.src = "../static/img/cavaleiro_ataque.png";
    }
    else if (jogada === 1 && jogadaInimigo === 1) {
        resultadoTexto.innerHTML = "Empate";

        imgJogador1.src = "../static/img/cavaleiro_ataque.png";
        imgJogador2.src = "../static/img/cavaleiro_ataque.png";

    } else if (jogada === 2 && jogadaInimigo === 2) {
        resultadoTexto.innerHTML = "Nada Aconteceu";

        imgJogador1.src = "../static/img/cavaleiro_defesa.png";
        imgJogador2.src = "../static/img/cavaleiro_defesa.png";
    } else if (jogada === 3 && jogadaInimigo === 3) {
        resultadoTexto.innerHTML = "Nada Aconteceu";

        imgJogador1.src = "../static/img/cavaleiro_descansa.png";
        imgJogador2.src = "../static/img/cavaleiro_descansa.png";
    }
}
