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

    public void searchByRegistration(BinaryTreeRecursive<Student> tree){
        clearTerminal();
        System.out.println("==================================================================================+++---");
        System.out.println("Insira o número de mátricula");
        System.out.println("==================================================================================+++---");
        

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
            System.out.println("==================================================================================+++---");
            System.out.println("ALUNO NÃO ENCONTRADO ++++++++++++-");
            System.out.println("==================================================================================+++---");
        }
        pressEnter("Aperte 'ENTER' para voltar ao menu");
    }

    public void searchByName(BinaryTreeRecursive<Student> tree){

        clearTerminal();
        System.out.println("==================================================================================+++---");
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
            System.out.println("==================================================================================+++---");
            System.out.println("ALUNO NÃO ENCONTRADO ++++++++++++-");
            System.out.println("==================================================================================+++---");
        }
        pressEnter("Aperte 'ENTER' para voltar ao menu");
        
    }

    public void deleteByName(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        
        clearTerminal();
        System.out.println("==================================================================================+++---");
        System.out.println("Insira o nome do aluno");
        System.out.println("==================================================================================+++---");
        String name = scanner.nextLine();
        
        clearTerminal();
        System.out.println("==================================================================================+++---");
        try{
            Student aux = new Student(0, name, 0);
            Counter<Student> auxCounter = treeN.searchNode(aux);

            treeN.deleteItem(auxCounter.getNode().getValue());
            treeR.deleteItem(auxCounter.getNode().getValue());
            System.out.println("O aluno " + name + " foi excluído com sucesso!");

        }catch(Exception e){
            System.out.println("Aluno não existe ou não foi cadastrado!");
        }
        System.out.println("==================================================================================+++---");

        pressEnter("Pressione 'ENTER' para ir ao menu");
    }

    public void deleteByRegistration(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        clearTerminal();
        System.out.println("==================================================================================+++---");
        System.out.println("Insira a mátricula do aluno");
        System.out.println("==================================================================================+++---");
        Integer registration = scanner.nextInt();
        scanner.nextLine();
        
        clearTerminal();
        System.out.println("==================================================================================+++---");
        try{
            Student auxR = new Student(registration, null, 0);
            
            Counter<Student> auxCounter = treeR.searchNode(auxR);
            
            System.out.println(auxCounter.getNode().getValue());
            Student auxN = new Student(0, auxCounter.getNode().getValue().toString(), 0);

            treeN.deleteItem(auxN);
            treeR.deleteItem(auxR);
            System.out.println("O aluno de matricula " + registration + " foi excluído com sucesso!");

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Aluno não existe ou não foi cadastrado!");
        }
        System.out.println("==================================================================================+++---");

        pressEnter("Pressione 'ENTER' para ir ao menu");
    }

    public void insertOnTree(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        clearTerminal();
        System.out.println("==================================================================================+++---");
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
        System.out.println("==================================================================================+++---");
        treeN.insertNode(student);
        treeR.insertNode(student);
        System.out.println("Aluno '" + name + "' adicionado com sucesso!");
        System.out.println("==================================================================================+++---");

        pressEnter("Pressione 'ENTER' para ir ao menu");
    }
    
    public void generateOutputFile(BinaryTreeRecursive<Student> treeR) throws IOException {
        clearTerminal();
        System.out.println("==================================================================================+++---");
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

    public void readFile(BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){

        clearTerminal();
        System.out.println("==================================================================================+++---");
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
            System.out.println("Erro na leitura do Arquivo: " + e.getMessage());
            System.out.println("==================================================================================+++---");
        }

        pressEnter("Aperte 'ENTER' para voltar ao menu");
    }
    public void displayStatisticsByRegistration(BinaryTreeRecursive<Student> treeR) {
        System.out.println("A arvore possui: " + treeR.getNodesNum() + " elementos.");
        System.out.println("Altura da arvore: " + treeR.getHeight(treeR.rootNode));
        System.out.println("O aluno de menor matricula é o: " + treeR.getMin().getName() + ", de matricula: " + treeR.getMin().getRegistration());
        System.out.println("O aluno de maior matricula é o: " + treeR.getMax().getName() + ", de matricula: " + treeR.getMax().getRegistration());
    }

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

    public void printSpootifyLogo(){
        
        System.out.println("\033[1m" +"\033[33m"
        + "\n _     _                          _"                 
        + "\n| |   (_)                        | |                "
        + "\n| |__  _ _ __   __ _ _ __ _   _  | |_ _ __ ___  ___ "
        + "\n| '_ \\| | '_ \\ / _` | '__| | | | | __| '__/ _ \\/ _ \\ "
        + "\n| |_) | | | | | (_| | |  | |_| | | |_| | |  __/  __/"
        + "\n|_.__/|_|_| |_|\\__,_|_|   \\__, |  \\__|_|  \\___|\\___|"
        + "\n                           __/ |                    "
        + "\n                          |___/                     ");
        System.out.println("\n \033[0;0m by: Marquin e Dudu\n");
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

    public static void main(String[] args) throws IOException{

        UI ui = new UI();
        Boolean isRunning = true;
        
        //Criando árvores
        StudentNameComparator nameComparator = new StudentNameComparator();
        StudentRegistrationComparator resgistrationComparator = new StudentRegistrationComparator();

        BinaryTreeRecursive<Student> treeRegistration = new BinaryTreeRecursive<>(resgistrationComparator);
        BinaryTreeRecursive<Student> treeName = new BinaryTreeRecursive<>(nameComparator);

        ui.printSpootifyLogo();
        ui.pressEnter("Pressione 'ENTER' para ir ao menu");

        while(isRunning){
            switch(ui.menuSelection()){
                case 1: //Busca por matricula
                    ui.searchByRegistration(treeRegistration);
                    break;
                case 2: //Busca por nome
                    ui.searchByName(treeName);
                    break;
                case 3://Excluir por matricula
                    ui.deleteByRegistration(treeRegistration, treeName);
                    break;
                case 4://Excluir por nome
                    ui.deleteByName(treeRegistration, treeName);
                    break;
                case 5://Incluir aluno
                    ui.insertOnTree(treeRegistration, treeName);
                    break;
                case 6://Imprimindo árvore
                    ui.clearTerminal();
                    treeRegistration.printIndented(treeRegistration.rootNode, "", true);
                    ui.pressEnter("Árvore organizada por Matricula\nAperte 'ENTER' para continuar!");
                    ui.clearTerminal();
                    treeName.printIndented(treeName.rootNode, "", true);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 7:
                    ui.clearTerminal();
                    System.out.println("==================================================================================+++---");
                    System.out.println("Estatisticas - Árvore Organizada por Mátricula");
                    System.out.println("==================================================================================+++---");
                
                    ui.displayStatisticsByRegistration(treeRegistration);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 8:
                    ui.clearTerminal();
                    System.out.println("==================================================================================+++---");
                    System.out.println("Estatisticas - Árvore Organizada por Nome");
                    System.out.println("==================================================================================+++---");

                    ui.displayStatisticsByName(treeName);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 9:
                    ui.readFile(treeRegistration, treeName);
                    break;
                case 10://Sair e salvar arquivo
                    ui.generateOutputFile(treeRegistration);
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
                
    }
}
