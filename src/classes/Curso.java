package classes;

import java.util.Scanner;
/**
 *
 * @author Bruno
 */
public class Curso {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    
    public Curso(){
        codigo = 0;
        nome = "";
        cargaHoraria = 0;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public void cadastrarCurso(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o código do Curso");
        this.codigo = input.nextInt();
        System.out.println("Informe nome do curso");
        this.nome = input.next();
        System.out.println("Informe a Carga Horária do curso");
        this.cargaHoraria = input.nextInt();
    }
    
    public String criarString(){
        String texto = codigo + ";" + nome + ";" + cargaHoraria + "\r\n";
        return texto;
    }
    
    public String pathCurso(){
        return "Arquivos\\curso.txt";
    }
    
    public void imprimirCurso(){
        System.out.println("Código: " + codigo);
        System.out.println("Curso: " + nome);
        System.out.println("Carga Horária " + cargaHoraria);
    }
    
    public void inserir(String linha){
        
    }
    
}
