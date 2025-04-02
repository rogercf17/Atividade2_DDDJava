public class Veiculo {
    String modelo;
    double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    double calcularCustoAluguel(int dias) {
        double total = valorDiaria * dias;
        if (dias > 7) {
            total = aplicarDesconto(total, dias);
        }
        return total;
    }

    double aplicarDesconto(double total, int dias) {
        double desconto = 0.1;
        if (dias > 14) {
            desconto = 0.15;
        }
        return total - (total*desconto);
    }

    double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }
        return diasAtraso * (valorDiaria * 1.2);
    }
}
