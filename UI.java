import java.util.Scanner;

public class UI {

    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printSpootifyLogo(){
        
        System.out.println("\u001B[32m\n"
        + "\n _     _                          _"                 
        + "\n| |   (_)                        | |                "
        + "\n| |__  _ _ __   __ _ _ __ _   _  | |_ _ __ ___  ___ "
        + "\n| '_ \\| | '_ \\ / _` | '__| | | | | __| '__/ _ \\/ _ \\ "
        + "\n| |_) | | | | | (_| | |  | |_| | | |_| | |  __/  __/"
        + "\n|_.__/|_|_| |_|\\__,_|_|   \\__, |  \\__|_|  \\___|\\___|"
        + "\n                           __/ |                    "
        + "\n                          |___/                     ");
        System.out.println("\n by: Marquin e Dudu\n");
    }

    public static void pressEnter(Scanner dataScanner, String text){
        System.out.println("==================================================================================+++---");
        System.out.println(text);
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }

    public static Integer menuSelection(Scanner dataScanner){
        clearTerminal();

        Integer actualCommand;

        System.out.println("==================================================================================+++---");
        System.out.println("Escolha uma das opçôes abaixo");
        System.out.println("==================================================================================+++---");
        System.out.println("1. Busca por matricula\t| 2. Busca por nome ");
        System.out.println("3. Excluir por nome\t| 4. Excluir por nome\t");
        System.out.println("5. Incluir aluno\t| 6. Estatísticas (por matricula)");
        System.out.println("7. Estatísticas (por nome)");
        System.out.println("8. Sair");
        

        actualCommand = dataScanner.nextInt();
        dataScanner.nextLine();
        return actualCommand;
    }

    public static void main(String[] args){
        printSpootifyLogo();
        pressEnter(new Scanner(System.in), "Pressione 'ENTER' para ir ao menu");

        Integer choice = menuSelection(new Scanner(System.in));

        while(choice > 2 || choice < 1){
            clearTerminal();
            pressEnter(new Scanner(System.in), String.format("'%d' não é uma escolha válida!\nPressione 'ENTER' para continuar", choice));
            System.out.printf("'%d' não é uma escolha válida!", choice);
            choice = menuSelection(new Scanner(System.in));
        }
        
    }
}
