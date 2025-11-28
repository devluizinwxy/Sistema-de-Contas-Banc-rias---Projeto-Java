public class Conta {

    private Integer numero;
    private String nome;
    private Double saldo;
    private Double limiteDeSaque;

    // ========= VALIDADORES PRIVADOS ========= //

    private void validarNumero(Integer numero) {
        if (numero == null) {
            throw new IllegalArgumentException("O número não pode ser nulo.");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

        if (!nome.trim().matches("^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$")) {
            throw new IllegalArgumentException("O nome informado é inválido.");
        }
    }

    private void validarSaldo(Double saldo) {
        if (saldo == null) {
            throw new IllegalArgumentException("O saldo não pode ser nulo.");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo.");
        }
    }

    private void validarLimite(Double limite) {
        if (limite == null) {
            throw new IllegalArgumentException("O limite não pode ser nulo.");
        }
        if (limite <= 0) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }
    }

    // ========= CONSTRUTOR ========= //

    public Conta(Integer numero, String nome, Double saldo, Double limiteDeSaque) {

        validarNumero(numero);
        validarNome(nome);
        validarSaldo(saldo);
        validarLimite(limiteDeSaque);

        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteDeSaque = limiteDeSaque;
    }

    // ========= GETTERS ========= //

    public Integer getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteDeSaque() {
        return limiteDeSaque;
    }

    // ========= SETTERS (Protegidos com validação) ========= //

    public void setNumero(Integer numero) {
        validarNumero(numero);
        this.numero = numero;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setSaldo(Double saldo) {
        validarSaldo(saldo);
        this.saldo = saldo;
    }

    public void setLimiteDeSaque(Double limiteDeSaque) {
        validarLimite(limiteDeSaque);
        this.limiteDeSaque = limiteDeSaque;
    }
}
