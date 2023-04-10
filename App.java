import java.io.IOException;

import library.BinaryTreeRecursive;
import library.Student;
import library.StudentNameComparator;
import library.StudentRegistrationComparator;
import library.UI;

public class App {

    /*
     * Nesse arquivo apenas instanciamos e realizamos as chamadas dos metodos da classe UI
     * assim como a instancialização das nossas duas árvores
     */
    public static void main(String[] args) throws IOException{

        UI ui = new UI();
        Boolean isRunning = true;
        
        //Criando árvores
        StudentNameComparator nameComparator = new StudentNameComparator();
        StudentRegistrationComparator resgistrationComparator = new StudentRegistrationComparator();

        BinaryTreeRecursive<Student> treeRegistration = new BinaryTreeRecursive<>(resgistrationComparator);
        BinaryTreeRecursive<Student> treeName = new BinaryTreeRecursive<>(nameComparator);

        ui.printLogo();
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
                    treeRegistration.printIndented(treeRegistration.getRootNode(), "", true);
                    ui.pressEnter("Árvore organizada por Matricula\nAperte 'ENTER' para continuar!");
                    ui.clearTerminal();
                    treeName.printIndented(treeName.getRootNode(), "", true);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 7:
                    ui.clearTerminal();
                    System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
                    System.out.println("Estatisticas - Árvore Organizada por Mátricula");
                    System.out.println("==================================================================================+++---");
                
                    ui.displayStatisticsByRegistration(treeRegistration);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 8:
                    ui.clearTerminal();
                    System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
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
