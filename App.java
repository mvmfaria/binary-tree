import java.io.IOException;

import library.BinaryTreeAVL;
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
        BinaryTreeAVL<Student> treeRegistrationAVL = new BinaryTreeAVL<>(resgistrationComparator);
        BinaryTreeAVL<Student> treeNameAVL = new BinaryTreeAVL<>(nameComparator);
        

        ui.printLogo();
        ui.pressEnter("Pressione 'ENTER' para ir ao menu");

        while(isRunning){

            
            switch(ui.menuSelection()){

                // Funções árvores binárias
                case 1: //Busca por matricula
                    ui.searchByRegistration(treeRegistration);
                    break;
                case 2: //Busca por nome
                    ui.searchByName(treeName);
                    break;
                case 3://Excluir por matricula
                    ui.deleteByRegistration(treeRegistration, treeName,  treeRegistrationAVL, treeNameAVL);
                    break;
                case 4://Excluir por nome
                    ui.deleteByName(treeRegistration, treeName,  treeRegistrationAVL, treeNameAVL);
                    break;
                // Funções árvores AVL
                case 5: //Busca por matricula
                    ui.searchByRegistration(treeRegistrationAVL);
                    break;
                case 6: //Busca por nome
                    ui.searchByName(treeNameAVL);
                    break;
                case 7://Incluir aluno
                    ui.insertOnTree(treeRegistration, treeName, treeRegistrationAVL, treeNameAVL);
                    break;
                case 8://Imprimindo árvore
                    ui.clearTerminal();
                    treeRegistration.printIndented(treeRegistration.getRootNode(), "", true);
                    ui.pressEnter("Árvore organizada por Matricula\nAperte 'ENTER' para continuar!");
                    ui.clearTerminal();
                    treeName.printIndented(treeName.getRootNode(), "", true);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    ui.clearTerminal();
                    treeRegistration.printIndented(treeRegistrationAVL.getRootNode(), "", true);
                    ui.pressEnter("Árvore AVL organizada por Matricula\nAperte 'ENTER' para continuar!");
                    ui.clearTerminal();
                    treeName.printIndented(treeNameAVL.getRootNode(), "", true);
                    ui.pressEnter("Árvore AVL organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 9:
                    ui.clearTerminal();
                    System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
                    System.out.println("Estatisticas - Árvore Organizada por Mátricula");
                    System.out.println("==================================================================================+++---");
                
                    ui.displayStatistics(treeRegistration);
                    ui.pressEnter("Árvore organizada por Matricula\nAperte 'ENTER' para continuar!");
                    ui.displayStatistics(treeRegistrationAVL);
                    ui.pressEnter("Árvore AVL organizada por Matricula\nAperte 'ENTER' para continuar!");
                    break;

                
                case 10:
                    ui.clearTerminal();
                    System.out.println("\033[1m" +"\033[33m" + "==================================================================================+++---");
                    System.out.println("Estatisticas - Árvore Organizada por Nome");
                    System.out.println("==================================================================================+++---");

                    ui.displayStatistics(treeName);
                    ui.pressEnter("Árvore organizada por Nome\nAperte 'ENTER' para continuar!");
                    ui.displayStatistics(treeNameAVL);
                    ui.pressEnter("Árvore AVL organizada por Nome\nAperte 'ENTER' para continuar!");
                    break;
                case 11:
                    ui.readFile(treeRegistration, treeName, treeRegistrationAVL, treeNameAVL);
                    break;
                case 12://Sair e salvar arquivo
                    ui.generateOutputFile(treeRegistration);
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
                
    }

}
