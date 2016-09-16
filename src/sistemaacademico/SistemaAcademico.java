package sistemaacademico;

import classes.Aluno;
import classes.ArquivoManager;
import classes.Curso;
import classes.Matricula;
import classes.Menus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class SistemaAcademico {

    public static void main(String[] args) throws IOException {
        // VERSION ARRAYLIST
        
        Scanner input = new Scanner(System.in);
        ArquivoManager arq = new ArquivoManager();        
        ArrayList<Curso> listaCurso = new ArrayList<>();
        ArrayList<Aluno> listaAluno = new ArrayList<>();
        ArrayList<Matricula> listaMatricula = new ArrayList<>();
        Aluno aluno;
        Curso curso;
        String texto;
        
        Menus.menuGeral();
        int op = input.nextInt();
        while(op != 0){
            switch(op){
                case 1:
                    curso = new Curso();
                    curso.cadastrarCurso();
                    listaCurso.add(curso);
                    texto = curso.criarString();
                    arq.writeArquivo(texto, curso.pathCurso());
                    break;
                case 2:
                    aluno = new Aluno();
                    aluno.cadastrarAluno();
                    listaAluno.add(aluno);
                    texto = aluno.criarString();
                    arq.writeArquivo(texto, aluno.pathAluno());
                    break;
                case 3:
                    Matricula matricula = new Matricula();
                    aluno = new Aluno();
                    curso = new Curso();
                    System.out.println("Informe o cpf do aluno");
                    String cpf = input.next();
                    System.out.println("Informe o Id do Curso:");
                    int id = input.nextInt();
                    for(int i=0; i < listaAluno.size(); i++){
                        if(listaAluno.get(i).getCpf().equals(cpf))
                            aluno = listaAluno.get(i);
                    }
                    for(int i=0; i < listaCurso.size(); i++){
                        if(listaCurso.get(i).getCodigo() == id)
                            curso = listaCurso.get(i);
                    }
                    matricula.matricular(aluno, curso);
                    listaMatricula.add(matricula);
                    texto = matricula.criarString();
                    arq.writeArquivo(texto, matricula.pathMatricula());
                    break;
                case 4:
                    for(Matricula m:listaMatricula){
                        m.imprimirMatricula();
                    }
                    break;
                case 5:
                    for(Curso c:listaCurso){
                        c.imprimirCurso();
                    }
                    break;
                case 6:
                    for(Aluno a:listaAluno){
                        a.imprimirAluno();
                    }
                    break;
                case 20:
                    arq.readArquivo("Arquivos\\curso.txt");
                    break;
                case 21:
                    arq.readArquivo("Arquivos\\aluno.txt");
                    break;
                case 22:
                    arq.readArquivo("Arquivos\\matricula.txt");
                    break;                   
                case 30:
                    arq.preencherCurso(listaCurso,"Arquivos\\curso.txt");
                    break;
                case 31:
                    arq.preencherAluno(listaAluno,"Arquivos\\aluno.txt");
                    break;
                case 32:
                    arq.preencherMatricula(listaMatricula,"Arquivos\\matricula.txt",listaAluno,listaCurso);
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
            Menus.menuGeral();
            op = input.nextInt();
        }
        
        
        
        
        
        
        // VERSION VETOR
        /*
        String pathCurso = "C:\\Users\\Bruno\\Downloads\\6º Periodo\\LPS I\\SistemaAcademico\\Arquivos\\curso.txt";
        String pathMatricula = "C:\\Users\\Bruno\\Downloads\\6º Periodo\\LPS I\\SistemaAcademico\\Arquivos\\matricula.txt";
        String pathAluno = "C:\\Users\\Bruno\\Downloads\\6º Periodo\\LPS I\\SistemaAcademico\\Arquivos\\aluno.txt";
        ArquivoManager arq = new ArquivoManager();
        String texto;
        
        Curso[] curso = new Curso[3];
        for(int i=0;i<3;i++){
            curso[i] = new Curso();
        }
        for(int i=0;i<3;i++){
            curso[i].cadastrarCurso();
        }
        Aluno[] aluno = new Aluno[2];
        for(int i=0;i<2;i++){
            aluno[i] = new Aluno();
        }
        for(int i=0;i<2;i++){
            aluno[i].cadastrarAluno();
        }
        
        Matricula[] matricula = new Matricula[2];
        for(int i=0;i<2;i++){
            matricula[i] = new Matricula();
        }
        
        for(int i=0;i<3;i++){
            texto = curso[i].criarString();
            arq.writeArquivo(texto, pathCurso);
        }
        for(int i=0;i<2;i++){
            texto = aluno[i].criarString();
            arq.writeArquivo(texto, pathAluno);
        }
        
        Curso c = new Curso();
        Aluno a = new Aluno();

        int quant = 0;
        Menus.menuMatricula();
        int op = input.nextInt();
        while(op != 0){
            if(quant <2){
            System.out.println("Informe o cpf do aluno");
            String cpf = input.next();
            System.out.println("Informe o Id do Curso:");
            int id = input.nextInt();
            for(int j=0;j<3;j++){
                if(curso[j].getCodigo() == id){
                    c = curso[j];
               }
            }
            for(int k=0;k<2;k++){
                if(aluno[k].getCpf().equals(cpf)){
                    a = aluno[k];
               }
            }
            matricula[quant].matricular(a,c);
            texto = matricula[quant].criarString();
            arq.writeArquivo(texto, pathMatricula);
            quant++;
            Menus.menuMatricula();
            op = input.nextInt();
            }
        }
        
        for(int i=0;i<quant;i++){
            matricula[i].imprimirMatricula();
        }*/
    }

}
