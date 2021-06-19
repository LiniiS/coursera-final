package com.asantos.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * A classe words é responsável por ler os arquivos e gerar as listas
 * de acordo com os níveis de dificuldade
 */
public class Words {
   private List<String> listaEasy;
   private List<String> listaMedium;
   private List<String> listaHard;

    {
        try {
            listaEasy = Files.readAllLines(Paths.get("palavras-easy.txt"));
            listaMedium = Files.readAllLines(Paths.get("palavras-medium.txt"));
            listaHard = Files.readAllLines(Paths.get("palavras-hard.txt"));
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o arquivo: " + e);
        }
    }

    public List<String> getListaEasy() {
        return listaEasy;
    }

    public List<String> getListaMedium() {
        return listaMedium;
    }

    public List<String> getListaHard() {
        return listaHard;
    }

    @Override
    public String toString() {
        return "Words{" +
                "listaEasy=" + listaEasy +
                ", listaMedium=" + listaMedium +
                ", listaHard=" + listaHard +
                '}';
    }
}
