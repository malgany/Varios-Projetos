/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Formatter;

/**
 *
 * @author Tony L
 */
class Arquivo {
    
    public String nome;
    private Formatter output;
    
    public void AbreArquivo(){
        try{
            output = new Formatter("");                    
        }catch(SecurityException securityException){
            System.err.println("Você não tem acesso ao arquivo!");
            System.exit( 1 );
        }catch(FileNotFoundException fileNotFoundException){
            System.err.println();
            System.exit( 1 );
        }
    }

    public void analyzePath(String path) {
        this.nome = path;
        
        File name = new File(path);
        
        
        System.out.printf(
                "%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                 name.getName(), " exists",
            ( name.isFile() ? "is a file" : "is not a file" ),
            ( name.isDirectory() ? "is a directory" : 
               "is not a directory" ),
            ( name.isAbsolute() ? "is absolute path" : 
               "is not absolute path" ), "Last modified: ",
            name.lastModified(), "Length: ", name.length(), 
            "Path: ", name.getPath(), "Absolute path: ",
            name.getAbsolutePath(), "Parent: ", name.getParent());
                
        
    }
    
}
