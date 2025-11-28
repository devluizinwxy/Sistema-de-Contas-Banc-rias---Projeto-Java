
public class ContaService {
    public Conta criarConta(Integer numero, String nome, Double saldo, Double limite) {
        validarNumero(numero);
        validarNome(nome);
        validarSaldo(saldo);
        validarLimite(limite);
        return new Conta(numero, nome, saldo, limite);
    }
public void validarNumero(Integer numero){
    if (numero == null)throw new IllegalArgumentException("O numero não pode ser nulo!!");

}
    public void validarNome(String nome) {
        if (nome == null || nome.trim().isBlank())throw new NomeInvalido("O nome não pode ser vazio nem nulo!!");
        if (!nome.trim().matches("^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$")) throw new NomeInvalido("O nome não é vàlido!!");

    }

    public void validarSaldo(Double saldo) {
        if(saldo == null) throw new SaldoInvalido("O saldo não pode ser nulo");
        if (saldo <= 0) throw new SaldoInvalido("O saldo n pode ser menor igual a zero!!");
    }

    public void validarLimite(Double limite) {

        if (limite == null) throw new LimiteInvalido("Limite não pode ser nulo");
        if (limite <= 0) throw new LimiteInvalido("O limite não pode ser menor igual a zero!!");

    }

    public void depositar(Conta conta, Double valor) {
        if (valor == null) throw new depositoInvalido("O valor não pode ser nulo");
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.printf("Deposito de %.2f concluido!\n", valor);
    }

    public void sacar(Conta conta, Double valor) {
        if (valor == null) throw new depositoInvalido("O valor não pode ser nulo");
        if (valor > conta.getSaldo())
            throw new SaldoInvalido("O valor sacado não pode ser maior que o saldo!! Valor disponivel: " + String.format("%.2f", valor));
        if (valor > conta.getLimiteDeSaque())
            throw new LimiteInvalido("O valor de saque não pode ser maior que o limite de saque!! Limite de saque: " + String.format("%.2f", conta.getLimiteDeSaque()));
        conta.setSaldo(conta.getSaldo() - valor);
        System.out.printf("Saque de %.2f concluido!!\n", valor);
        System.out.println("Novo valor: "+ conta.getSaldo());


    }


}
