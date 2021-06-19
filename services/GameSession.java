package com.asantos.services;

import com.asantos.mechanics.Mechanics;

import java.util.Scanner;

/**
 * A classe GameSession gerencia o fluxo da partida do jogo, o jogador é livre pra escolher quantas partidas
 * deseja jogar. Os pontos serão acumulados e mostrados a cada acerto/erro.
 */

public class GameSession {
    public static void iniciarSessao(){
        System.out.println(" :: JOGO DAS PALAVRAS EMBARALHADAS ::");
        System.out.println("(\u2622 as palavras escolhidas representam nomes dos eletementos químicos \u2622)");

        System.out.println("Quantas vezes deseja jogar? ");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        int partida = 0;
        do{
            Mechanics jogo = new Mechanics();
            jogo.comecarJogo();
            jogo.verificarPalavra();
            partida++;
        }while(partida!=escolha);
        System.out.println("Fim de jogo!");
    }
}
