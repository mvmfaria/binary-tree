import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class App{

    public static Counter<Student> searchByRegistration(Integer registration, BinaryTreeRecursive<Student> tree){
        Student aux = new Student(registration, null, 0);
        return tree.searchNode(aux);        
    }

    public static Counter<Student> searchByName(String name, BinaryTreeRecursive<Student> tree){
        Student aux = new Student(0, name, 0);
        return tree.searchNode(aux);        
    }

    public static void deleteByName(String name, BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        
        try{
            Student aux = searchByName(name, treeN).getNode().getValue();

            treeN.deleteItem(aux);
            treeR.deleteItem(aux);
            System.out.println("Deletou namoral");

        }catch(Exception e){
            System.out.println("Deu ruim");
        }
    }

    public static void deleteByRegistration(Integer registration, BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        
        try{
            Student aux = searchByRegistration(registration, treeR).getNode().getValue();

            treeN.deleteItem(aux);
            treeR.deleteItem(aux);
            System.out.println("Deletou namoral");

        }catch(Exception e){
            System.out.println("Deu ruim");
        }
    }

    public static void insertOnTree(Student student, BinaryTreeRecursive<Student> treeR, BinaryTreeRecursive<Student> treeN){
        treeN.insertNode(student);
        treeR.insertNode(student);
    }
    public static void main(String[] args) {

        //Pre created file.
        String file = "./geradorarquivos/entradaBalanceada10.txt";

        StudentNameComparator nameComparator = new StudentNameComparator();
        StudentRegistrationComparator resgistrationComparator = new StudentRegistrationComparator();

        BinaryTreeRecursive<Student> tree = new BinaryTreeRecursive<>(resgistrationComparator);
        BinaryTreeRecursive<Student> treeName = new BinaryTreeRecursive<>(nameComparator);
        
        //Filling a tree basead on a file.
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {

            String line = buffer.readLine();
            line = buffer.readLine(); //Reading again to ignore first line.
            
            while (line != null) {
                String[] fields = line.split(";");

                Integer resgistration = Integer.parseInt(fields[0]);
                String name = fields[1];
                Integer grade = Integer.parseInt(fields[2]);

                Student student = new Student(resgistration, name, grade);

                tree.insertNode(student);
                treeName.insertNode(student);

                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        // BinaryTreeRecursive<Integer> tree = new BinaryTreeRecursive<Integer>(Comparator.naturalOrder());

        // tree.insertNode(61);
        // tree.insertNode(61);
        // tree.insertNode(43);
        // tree.insertNode(89);
        // tree.insertNode(16);
        // tree.insertNode(66);
        // tree.insertNode(51);
        // tree.insertNode(79);
        // tree.insertNode(61);
        // tree.insertNode(77);
        // tree.insertNode(11);
        // tree.insertNode(32);
        // tree.insertNode(55);
        // tree.insertNode(80);

        // tree.printIndented(tree.getRootNode(), "", true);
        // tree.printBreadthFirstSearch();
        // System.out.println("\n"+ "menor: " + tree.getMin());
        // System.out.println("maior: " + tree.getMax());

        //Created using ChatGebestafera. 
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Busca por matricula");
        System.out.println("2. Busca por nome");
        System.out.println("3. Excluir por nome");
        System.out.println("4. Excluir por nome");
        System.out.println("5. Incluir aluno");
        System.out.println("6. Estatísticas (por matricula)");
        System.out.println("7. Estatísticas (por nome)");
        System.out.println("8. Sair");
        System.out.print("Digite sua escolha: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
            try{
                Counter<Student> aux= searchByRegistration(2000000007, tree);

                System.out.println("Aluno: " + aux.getNode().getValue().getName());
                System.out.println("Matricula: " + aux.getNode().getValue().getRegistration());
                System.out.println("Nota: " + aux.getNode().getValue().getGrade());
                System.out.println("Quantos nos foram percorridos: " + aux.getCounter());
                tree.printIndented(tree.rootNode, "", true);
                
            }catch(Exception e){
                System.out.println("Aluno não existe!");

            }
                break;
            case 2:
                Student aux2 = treeName.searchNode(new Student("Kelimue Nonabole")).getNode().getValue();
                System.out.println("Aluno: " + aux2.getName());
                System.out.println("Matricula: " + aux2.getRegistration());
                System.out.println("Nota: " + aux2.getGrade());
                System.out.println("Quantos nos foram percorridos: ?");
                
            case 3:
                System.out.println("Você escolheu a opção 3");
                deleteByName("Pajeheur Polix", tree, treeName);
                tree.printIndented(tree.rootNode, "", true);
                System.out.println("\n\n\n\n\n");
                treeName.printIndented(treeName.rootNode, "", true);
                break;
            case 4:
                System.out.println("Você escolheu a opção 4");
                break;
            case 5:
                //Necessário receber os dados e incluir em ambas as árvores.
                break;
            case 6:
                System.out.println("Você escolheu a opção 6");
                break;
            case 7:
                System.out.println("Você escolheu a opção 7");
                break;
            case 8:
                System.out.println("Você escolheu a opção 8");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
            /*Apenas para testar.*/
            // tree.clearScreen();
        } while (choice != 8);
        scanner.close();
    }
}
