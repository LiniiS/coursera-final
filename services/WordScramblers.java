package com.asantos.services;

import com.asantos.model.Words;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A classe WordScramblers é responsável por embaralhar as palavras
 * das listas. Possui três modos de embaralhamento que são escolhidos
 * de modo aleatório, assim como as palavras que são retiradas das listas
 * de modo aleatório
 */

public class WordScramblers {
    Words palavra = new Words();

    /**
     * pegarPalavra retorna uma das palavras das três listas disponíveis. A lista e a palavra são
     * escolhidas aleatoriamente.
     * @return
     */
    public String pegarPalavra(){
        String palavraEscolhida = null;
        int n = gerarIndiceAleatorio();
        int gameMode = gerarGameModeAleatorio();
        switch (gameMode){
            case 0:
                String palavraEasy = palavra.getListaEasy().get(n);
                palavraEscolhida = palavraEasy;
                break;
            case 1:
                String palavraMedium = palavra.getListaMedium().get(n);
                palavraEscolhida = palavraMedium;
                break;
            case 2:
                String palavraHard = palavra.getListaHard().get(n);
                palavraEscolhida = palavraHard;
                break;
            default:
                System.out.println("Oops algo deu errado!");
        }
        return palavraEscolhida;
    }

    /**
     * emabralharComReplace apenas troca a letra 'O' por 'Z', é um pseudo-embaralhamento
     * @param palavraParaEmbaralhar
     * @return
     */
    public String embaralharComReplace(String palavraParaEmbaralhar){
        return palavraParaEmbaralhar.replace('O', 'Z');
    }

    /**
     * embaralharComReverse simplesmente inverte a palavra sorteada
     * @param palavraParaEmbaralhar
     * @return
     */
    public String embaralharComReverse(String palavraParaEmbaralhar){
        StringBuilder palavraEmbaralhada= new StringBuilder(palavraParaEmbaralhar).reverse();
        return palavraEmbaralhada.toString();
    }

    /**
     * embaralharComShuffle mistura aleatoriamente os caracteres da palavra sorteada
     * @param palavraParaEmbaralhar
     * @return
     */
    public String embaralharComShuffle(String palavraParaEmbaralhar){

        List<Character> characters = palavraParaEmbaralhar.chars()
                                    .mapToObj(c ->(char)c)
                                    .collect((Collectors
                                    .toList()));
        Collections.shuffle(characters);
        return characters.stream().map(Object::toString).collect(Collectors.joining());
    }

    /**
     * indiceAleatório escolhe aleatoriamente
     * um índice da lista de Palavras
     * 
     */
     private static int gerarIndiceAleatorio(){
        int max = 14;
        int min = 0;
        Random indiceAleatorio  = new Random();
        return indiceAleatorio.nextInt(max-min +1)+ min;
    }

    /**
     * gameModeAleatorio escolhe aleatoriamente qual será
     * o modo de dificuldade a ser definida pela lista
     * @return
     */
    private static int gerarGameModeAleatorio(){
        int max = 2;
        int min = 0;
        Random modoAleatorio  = new Random();
        return modoAleatorio.nextInt(max-min +1)+ min;
    }

    @Override
    public String toString() {
        return palavra.toString();
    }
}

