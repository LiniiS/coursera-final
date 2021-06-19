package com.asantos.mechanics;

import com.asantos.services.WordScramblers;
import java.util.Scanner;

/**
 * A classe Mechanics apresenta a mecânica do jogo: o Jogador escolhe dentre três tipos o
 * modo do jogo, o modo do jogo definirá qual será o tipo de embaralhamento. A palavra selecionada
 * aleatoriamente conforme de uma das três listas de forma aleatória. A pontuação varia com o modo do jogo
 * caso o jogador não acerte a palavra não terá outra tentativa. O modo de jogo poderá ser alterado
 * a cada jogada.
 */

public class Mechanics {

    private String modalidade;
    private static int pontos;
    private int modoJogo = defnirModoJogo();
    private String palavraEmbaralhada;

    private String tentativaDoJogador = null;
    WordScramblers palavraParaEmbaralhar = new WordScramblers();
    public String palavraSorteada = palavraParaEmbaralhar.pegarPalavra();

    private int defnirModoJogo() {
        do {
            System.out.println("Modo do jogo? 0 - EASY | 1 - MEDIUM | 2 - HARD ");
            Scanner scanner = new Scanner(System.in);
            modoJogo = scanner.nextInt();
            return modoJogo;
        }while(modoJogo > 3 || modoJogo < 0);
    }

    public void comecarJogo() {
        System.out.println("Modo escolhido: " + mostrarModalidadeEscolhida());
        System.out.println("Tente desembaralhar esta palavra: ");
        switch (modoJogo) {
            case 0:
                palavraEmbaralhada = palavraParaEmbaralhar.embaralharComReplace(palavraSorteada);
                System.out.println(palavraEmbaralhada);
                break;
            case 1:
                palavraEmbaralhada = palavraParaEmbaralhar.embaralharComReverse(palavraSorteada);
                System.out.println(palavraEmbaralhada);
                break;
            case 2:
                palavraEmbaralhada = palavraParaEmbaralhar.embaralharComShuffle(palavraSorteada);
                System.out.println(palavraEmbaralhada);
                break;
            default:
                System.out.println("Modo de jogo inválido");
                break;
        }
    }

    public void verificarPalavra() {
        if(modoJogo < 3 && modoJogo >= 0) {
            tentativaDoJogador = pegaTentativaDoJogador();
            if (tentativaDoJogador.equalsIgnoreCase(String.valueOf(palavraSorteada))) {
                System.out.println("\u2728\u2728  Você desembaralhou a palavra! \u2728\u2728");
                System.out.println("Score: " + calcularPontuacao(modoJogo));
            } else {
                System.out.println("\u2718 Ops! a palavra não foi desembaralhada corretamente! \u2718");
                System.out.println("Digitado: " + tentativaDoJogador
                                   + "\nPalavra desembaralhada: " + palavraSorteada);
                System.out.println("Score: " + pontos);
            }
        }else{
            System.out.println("Partida anulada. Score: "+ pontos);
        }
    }

    private String pegaTentativaDoJogador(){
        Scanner leEntrada = new Scanner(System.in);
        tentativaDoJogador = leEntrada.next().toUpperCase();
        return tentativaDoJogador;

    }

    private int calcularPontuacao(int modoJogo){
        switch (modoJogo) {
            case 0: pontos+=20; break;
            case 1: pontos+=50; break;
            case 2: pontos+=60; break;
            default:
                System.out.println("Não foi possível obter os pontos!");
        }
        return pontos;
    }

    private String mostrarModalidadeEscolhida(){
        switch(modoJogo){
            case 0: modalidade = "EASY"; break;
            case 1: modalidade = "MEDIUM"; break;
            case 2: modalidade = "HARD"; break;
            default:
                modalidade = "\u274C";
        }
        return modalidade;
    }

}