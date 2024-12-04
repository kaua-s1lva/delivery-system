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
    private String caminho_arquivo = "src\\main\\java\\logs\\JsonLog.json";

    public ArquivoDAO(String fileName) {
        if(fileName == null || fileName.isEmpty()){
            throw new IllegalArgumentException("Caminho passado nulo ou invalido ");
        }
        
        caminho_arquivo = caminho_arquivo.concat(fileName);
    }
    
    public File criarArquivo() throws IOException{
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(caminho_arquivo))){
            writer.write(conteudo);     
        } 
        // lançar uma exceção
    }      
}
