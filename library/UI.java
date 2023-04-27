package library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner scanner;

    public UI(){
        scanner = new Scanner(System.in);
    }

    /*
     * Nesses cinco métodos abaixo enviamos as árvores e recolhemos as entradas do terminal para chamarmos 
     * os respectivos métodos presentes na classe BinaryTreeRecursive
     */

    public void searchByRegistration(BinaryTreeRecursive<Student> tree){
        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira o número de mátricula");
        System.out.println("==================================================================================+++---");
        
        try{

            Student aux = new Student(scanner.nextInt(), null, 0);
            scanner.nextLine();

            clearTerminal();
            if(tree.searchNode(aux) != null){
                
                Counter<Student> auxCounter = tree.searchNode(aux);
                System.out.println("==================================================================================+++---");
                System.out.println("DADOS DO ALUNO ------------+");
                System.out.println("Nome: " + auxCounter.getNode().getValue().getName());
                System.out.println("Matricula: " + auxCounter.getNode().getValue().getRegistration());
                System.out.println("Nota: " + auxCounter.getNode().getValue().getGrade());
                System.out.println("Quantos nos foram percorridos: " + auxCounter.getCounter());
                System.out.println("==================================================================================+++---");
            }else{
                System.out.println("\033[41m                                                                                        ");
                System.out.println("\033[41m                               ALUNO NÃO ENCONTRADO                                     ");
                System.out.println("                                                                                        \033[0;0m\n");
            }
            pressEnter("Aperte 'ENTER' para voltar ao menu");

            
        }catch(Exception e){
            System.out.println("\033[41m                                                                                        ");
            System.out.println("\033[41m                          Digite um número inteiro                                      ");
            System.out.println("                                                                                        \033[0;0m\n");
            pressEnter("Aperte 'ENTER' para voltar ao menu");
            scanner.nextLine();
        }
        

    }

    public void searchByName(BinaryTreeRecursive<Student> tree){

        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira o nome do aluno");
        System.out.println("==================================================================================+++---");
        
        Student aux = new Student(0, scanner.nextLine(), 0);
        
        clearTerminal();
        if(tree.searchNode(aux) != null){
            
            Counter<Student> auxCounter = tree.searchNode(aux);
            System.out.println("==================================================================================+++---");
            System.out.println("DADOS DO ALUNO ------------+");
            System.out.println("Nome: " + auxCounter.getNode().getValue().getName());
            System.out.println("Matricula: " + auxCounter.getNode().getValue().getRegistration());
            System.out.println("Nota: " + auxCounter.getNode().getValue().getGrade());
            System.out.println("Quantos nos foram percorridos: " + auxCounter.getCounter());
            System.out.println("==================================================================================+++---");
        }else{
            System.out.println("\033[41m                                                                                        ");
            System.out.println("\033[41m                               ALUNO NÃO ENCONTRADO                                     ");
            System.out.println("                                                                                        \033[0;0m\n");
        }
        pressEnter("Aperte 'ENTER' para voltar ao menu");
        
    }

    public void deleteByName(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        
        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira o nome do aluno");
        System.out.println("==================================================================================+++---");
        String name = scanner.nextLine();
        
        clearTerminal();
        try{
            Student aux = new Student(0, name, 0);
            Student auxStudent = treeN.searchNode(aux).getNode().getValue();
            treeN.deleteItem(auxStudent);
            treeR.deleteItem(auxStudent);
            System.out.println("\033[42m                                                                                        ");
            System.out.println("                              O aluno foi excluído com sucesso!                                 ");
            System.out.println("                                                                                        \033[0;0m\n");
            
        }catch(Exception e){
            System.out.println("\033[41m                                                                                        ");
            System.out.println("\033[41m                     Aluno não existe ou não foi cadastrado!                            ");
            System.out.println("                                                                                        \033[0;0m\n");
        }

        pressEnter("Pressione 'ENTER' para ir ao menu");
    }

    public void deleteByRegistration(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira a mátricula do aluno");
        System.out.println("==================================================================================+++---");
        try{
            Integer registration = scanner.nextInt();
            scanner.nextLine();
            
            clearTerminal();
            try{
                Student auxR = new Student(registration, null, 0);
                
                Student auxStudent = treeR.searchNode(auxR).getNode().getValue();
                
                System.out.println(auxStudent);
                Student auxN = new Student(0, auxStudent.toString(), 0);
                
                treeN.deleteItem(auxN);
                treeR.deleteItem(auxR);
                System.out.println("\033[42m                                                                                        ");
                System.out.println("                              O aluno foi excluído com sucesso!                                 ");
                System.out.println("                                                                                        \033[0;0m\n");
            
            }catch(Exception e){
                System.out.println("\033[41m                                                                                        ");
                System.out.println("\033[41m                     Aluno não existe ou não foi cadastrado!                            ");
                System.out.println("                                                                                        \033[0;0m\n");
            }

        }catch(Exception e){
            System.out.println("\033[41m                                                                                        ");
            System.out.println("\033[41m                          Digite um número inteiro                                      ");
            System.out.println("                                                                                        \033[0;0m\n");
        }
        pressEnter("Pressione 'ENTER' para ir ao menu");
    }

    public void insertOnTree(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira os dados do aluno");
        System.out.println("==================================================================================+++---");
        System.out.println("Matricula -------++");
        Integer registration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nome -------++");
        String name = scanner.nextLine();

        System.out.println("Nota -------++");
        Integer grade = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(registration, name, grade);
        
        clearTerminal();
        treeN.insertNode(student);
        treeR.insertNode(student);

        System.out.println("\033[42m                                                                                        ");
        System.out.println("\033[42m                               ALUNO ADICIONADO                                         ");
        System.out.println("                                                                                        \033[0;0m\n");
            

        pressEnter("Pressione 'ENTER' para ao menu");
    }
    
    /*Para gerar o arquivo de saída (comcolumns_str todos os registros de alunos) foram necessárias algumas funções do Java para manipulação de arquivo.
     * Primeiro instanciamos um objeto da classe File passando o caminho onde será criado posteriormente para o constructor da classe.
     * Em seguida, verificamos se o arquivo já existe, caso não exista ele faz a criação utilizando o método createNewFile(). Em seguida criamos
     * um escritor (writer) para escrever as informações dos alunos (que foram salvas na lista "students" pelo método createListInOrder()) usando
     * o método write() dentro do loop que percorre até o último elemento da lista. Por fim, fechamos o escritor.
     * 
    */
    public void generateOutputFile(BinaryTreeRecursive<Student> treeR) throws IOException {
        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira o nome do arquivo que deseja salvar. Apenas o nome sem extensão!");
        System.out.println("==================================================================================+++---");
        String path = scanner.nextLine();

        File archivFile = new File(path + ".txt");

        if(!archivFile.exists()) {
            archivFile.createNewFile();
        }

        FileWriter writer = new FileWriter(archivFile, true);
        List<Student> students = new ArrayList<Student>();
        treeR.createListInOrder(treeR.getRootNode(), students);

        System.out.println("==================================================================================+++---");
        System.out.println("Aguarde um instante, seu arquivo está sendo salvo");
        System.out.println("==================================================================================+++---");
        for (int i = 0; i < students.size(); i++) {
            writer.write(students.get(i).getRegistration() + ";" + students.get(i).getName() + ";" + students.get(i).getGrade()+"\n");
        }

        writer.close();

        clearTerminal();
        System.out.println("==================================================================================+++---");
        System.out.println("Seu arquivo foi salvo com sucesso!");
        System.out.println("==================================================================================+++---");
    
    }

    /* Para lermos o arquivo que contém os registros dos alunos utilizamos as classes (do Java) BufferReader e FileReader. Basicamente,
    o buffer serve para armazenar temporariamente os dados lidos do arquivo em um bloco de memória intermediário antes que eles 
    sejam processados. De forma geral, fizemos um while para pecorrer o arquivo até encontrar uma linha vazia. Para cada linha, separamos
    as informações dos alunos usando o split() que recebe o caracter ";" que está divindo a linha e retorna uma lista contém as informações
    separadas em cada índice. Para cada indíce da lista, atribuimos a sua respectiva variável para depois fazermos a instancia da classe
    "Student". Por fim adicionamos o objeto a ambas árvores (de nome e matrícula) e lemos outra linha.
    */
    public void readFile(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){

        clearTerminal();
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Insira o nome do arquivo. Apenas o nome sem extensão!");
        System.out.println("==================================================================================+++---");
        String path = scanner.nextLine();

        try (BufferedReader buffer = new BufferedReader(new FileReader(path+".txt"))) {

            String line = buffer.readLine();
            line = buffer.readLine();
            
            System.out.println("==================================================================================+++---");
            System.out.println("Aguarde enquanto seu arquivo é carregado...");
            System.out.println("==================================================================================+++---");
                    

            while (line != null) {
                String[] fields = line.split(";");

                Integer resgistration = Integer.parseInt(fields[0]);
                String name = fields[1];
                Integer grade = Integer.parseInt(fields[2]);

                Student student = new Student(resgistration, name, grade);

                treeR.insertNode(student);
                treeN.insertNode(student);

                line = buffer.readLine();

            }
            System.out.println("==================================================================================+++---");
            System.out.println("Arquivo lido com sucesso!");
            System.out.println("==================================================================================+++---");
        } catch (IOException e) {
            System.out.println("==================================================================================+++---");
            System.out.println("\033[31mErro na leitura do Arquivo: " + e.getMessage());
            System.out.println("\033[1m" +"\033[33m" +"==================================================================================+++---");
        }

        pressEnter("Aperte 'ENTER' para voltar ao menu");
    }
    
    /*Para este método, não tem segredo. Recebemos a árvore como parâmetro e a partir dai basta pegarmos os valores dos atributos
     * utilizando os getters da classe e printar as informações solicitadas na descrição do trabalho.
    */
    public void displayStatisticsByRegistration(BinaryTreeRecursive<Student> treeR) {
        System.out.println("A arvore possui: " + treeR.getNodesNum() + " elementos.");
        System.out.println("Altura da arvore: " + treeR.getHeight(treeR.rootNode));
        System.out.println("O aluno de menor matricula é o: " + treeR.getMin().getName() + ", de matricula: " + treeR.getMin().getRegistration());
        System.out.println("O aluno de maior matricula é o: " + treeR.getMax().getName() + ", de matricula: " + treeR.getMax().getRegistration());
    }

    /*Mesmo funcionamento do método acima, o que muda aqui é que recebemos uma "árvore de nomes" ao invés de uma de matricula.*/
    public void displayStatisticsByName(BinaryTreeRecursive<Student> treeN) {
        System.out.println("A arvore possui: " + treeN.getNodesNum() + " elementos.");
        System.out.println("Altura da arvore: " + treeN.getHeight(treeN.rootNode));
        System.out.println("O primeiro aluno na ordem alfabética é: " + treeN.getMin().getName() + ", de matricula: " + treeN.getMin().getRegistration());
        System.out.println("O último aluno na ordem alfabética é: " + treeN.getMax().getName() + ", de matricula: " + treeN.getMax().getRegistration());
    }

    public void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printLogo(){
        
        System.out.println("\033[1m" +"\033[33m"
        + "\n _     _                          _"                 
        + "\n| |   (_)                        | |                "
        + "\n| |__  _ _ __   __ _ _ __ _   _  | |_ _ __ ___  ___ "
        + "\n| '_ \\| | '_ \\ / _` | '__| | | | | __| '__/ _ \\/ _ \\ "
        + "\n| |_) | | | | | (_| | |  | |_| | | |_| | |  __/  __/"
        + "\n|_.__/|_|_| |_|\\__,_|_|   \\__, |  \\__|_|  \\___|\\___|"
        + "\n                           __/ |                    "
        + "\n                          |___/                     ");
        System.out.println("\n\033[0;0mby: Marcos Faria e Eduardo Próspero\n");
    }

    public void pressEnter(String text){
        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println(text);
        System.out.println("==================================================================================+++--- \033[0;0m");
        this.scanner.nextLine();
    }

    public Integer menuSelection(){
        clearTerminal();

        Integer actualCommand;

        System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
        System.out.println("Escolha uma das opçôes abaixo");
        System.out.println("==================================================================================+++---");
        System.out.println("\033[0;0m1. Busca por matricula\t\t| 2. Busca por nome ");
        System.out.println("3. Excluir por matricula\t| 4. Excluir por nome\t");
        System.out.println("5. Incluir aluno\t\t| 6. Imprimir árvore");
        System.out.println("7. Estatísticas (por matricula)\t| 8. Estatísticas (por nome)");
        System.out.println("9. Preencher árvore com arquivo\t| 10. Sair");

        

        actualCommand = scanner.nextInt();
        scanner.nextLine();
        return actualCommand;
    }

}
