/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery.DAO;

import com.mycompany.delivery.log.XMLLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tetzner
 */
public class ArquivoDAO {
    private String caminhoArquivo;

    public ArquivoDAO(String caminhoArquivo) {
        if(caminhoArquivo == null || caminhoArquivo.isEmpty()){
            throw new IllegalArgumentException("Caminho passado nulo ou invalido ");
        }
        
        this.caminhoArquivo = caminhoArquivo;
    }
    
    public File criarArquivo() throws IOException{
        File file = new File(caminhoArquivo);
        if(!file.exists()){
            file.getParentFile().mkdirs(); // força a criar o diretorio, caso necessario
            file.createNewFile();   
        }
        return file;
    }
    
    public boolean deletarArquivo(){
        File file = new File(caminhoArquivo);
        if(file.exists()){
            return file.delete();
        }
        return false;
    }
    
    public void escreverNoArquivo(String conteudo) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))){
            writer.write(conteudo);     
        } catch (IOException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public boolean arquivoExiste(){
        return new File(caminhoArquivo).exists();
    }
    
    public String getCaminhoArquivo(){
        return caminhoArquivo;
    }
}
