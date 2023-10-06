import java.util.Scanner;

public class ACMEEmpresa {
    private Scanner entrada;

    public ACMEEmpresa(){
        entrada = new Scanner(System.in);
    }

    public void executa(){
        menuLogin(0);
    }

    private void menuLogin(int opc){
        while(opc != 0){
            opc = entrada.nextInt();
        switch (opc){
            case 0:
                System.out.println("Apertou 0");
            case 1:
                System.out.println("Apertou 1");
            default:
                System.out.println("Entrada inválida.");
            }
    }
}
}
