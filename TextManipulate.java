package textmanipulate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class generateC{
    
    FileOutputStream fout=null;
    FileInputStream fin = null;
    
    public generateC()throws FileNotFoundException {
        fout = new FileOutputStream(new File("main.c"));
    }
    
    
    
    public void startIt() throws IOException 
    {
        fout = new FileOutputStream(new File("main.c"));
        fout.write("".getBytes());
        String start = "#include<stdio.h>\n"
                + "int main()\n"
                + "{\n\n\n"
                + "return 0;\n"
                + "}\n";
        
        fout.write(start.getBytes());
    }
    
    public void print(String msg) throws FileNotFoundException, IOException
    {
        int tmp;
        String addit = "";
        fin = new FileInputStream(new File("main.c"));
       
        while(fin.available()!=0)
        {
            tmp = fin.read();
            addit = addit+(char)tmp;
        }
        
       String print = "\tint a;" + "\n"
               + "\tint b;" +"\n";
       char additara[] = new char[addit.length()+print.length()+10];
       int pos = addit.indexOf("return 0;");
       
       for(int i=0; i<pos; i++) additara[i] = addit.charAt(i);
       for(int i=pos,j=0; i<print.length()+pos; i++,j++) additara[i] = print.charAt(j);
       for(int i=print.length()+pos+1,j=pos; j<addit.length(); i++,j++) additara[i] = addit.charAt(j);
           
       String finaladdit = "";
       for(int i=0; i<additara.length; i++) finaladdit = finaladdit + additara[i];

       char finalfinal[] = finaladdit.toCharArray();
       
       fout.close();
       fout = new FileOutputStream(new File("main.c"));
       
       for(int i=0; i<finalfinal.length; i++)
       {
           System.out.print(finalfinal[i]);
           fout.write(finalfinal[i]);
       }
      
    }
    
}

public class TextManipulate {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner input = new Scanner(System.in);
        String cmd;
        generateC c = new generateC();
        
        System.out.println("Enter Your command: ");
        cmd = input.next();
        
        if(cmd.contains("start")){
            c.startIt();
        }
        
        cmd = input.next();
        
        c.print("This is a test.");
        c.print("This is a test.");
        
        
        
    }
    
}
