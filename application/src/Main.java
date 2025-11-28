import java.security.Provider;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaService service = new ContaService();
        Conta conta = null;
        Integer numero = 0;
        String nome = "";
        Double saldo = 0.0;
        Double limite = 0.0;
        System.out.println("Enter account data");
        while (true){
            try {
                numero = LeituraUtil.lerInt(sc,"Numero: ");
                sc.nextLine();
                service.validarNumero(numero);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while (true){
            try {
            nome = LeituraUtil.lerString(sc,"Nome: ");
            service.validarNome(nome);

            break;}
            catch (NomeInvalido e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try{
                saldo = LeituraUtil.LerDouble(sc,"Saldo incial: ");
                sc.nextLine();
                service.validarSaldo(saldo);
                break;
            } catch (SaldoInvalido e) {
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try{
                limite = LeituraUtil.LerDouble(sc,"Limite pra saque: ");
                service.validarLimite(limite);
                break;
            }catch (LimiteInvalido e){
                System.out.println(e.getMessage());
            }
        }


        conta = service.criarConta(numero,nome,saldo,limite);


        while (true){
            try{
                Double valor = LeituraUtil.LerDouble(sc,"Informe o valor de deseja sacar: ");
                service.sacar(conta,valor);
               break;
            } catch (SaldoInvalido e) {
                System.out.println(e.getMessage());
            }catch (LimiteInvalido e){
                System.out.println(e.getMessage());
            }catch (depositoInvalido e){
                System.out.println(e.getMessage());
            }
        }

    }

}
