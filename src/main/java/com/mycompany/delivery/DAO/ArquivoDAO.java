/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tetzner
 */
public class ArquivoDAO {
    private String caminho_arquivo;

    public ArquivoDAO(String caminho_arquivo) {
        if(caminho_arquivo == null || caminho_arquivo.isEmpty()){
            throw new IllegalArgumentException("Caminho passado nulo ou invalido ");
        }
        
        this.caminho_arquivo = caminho_arquivo;
    }
    
    public File criarArquivo(String caminhoArquivo) throws IOException{
        File file = new File(caminho_arquivo);
        if(!file.exists()){
            file.getParentFile().mkdirs(); // força a criar o diretorio, caso necessario
            file.createNewFile();   
        }
        return file;
    }
    
    public boolean deletarArquivo(){
        File file = new File(caminho_arquivo);
        if(file.exists()){
            return file.delete();
        }
        return false;
    }
    
    public void escreverNoArquivo(String conteudo) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(caminho_arquivo, true))){
            writer.write(conteudo);     
        } 
        // lançar uma exceção
    }      
}
