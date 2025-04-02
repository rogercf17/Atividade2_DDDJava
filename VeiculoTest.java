package Atividade2_DDDJava;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class VeiculoTeste {
    private Veiculo veiculoNormal;
    private Veiculo veiculoDiariaNegativa;
    private Veiculo veiculoDiariaZero;

    @Before
    public void inicializar() {
        veiculoNormal = new Veiculo("Gol", 100.0);
        veiculoDiariaNegativa = new Veiculo("Modelo Inválido", -50.0);
        veiculoDiariaZero = new Veiculo("Modelo Grátis", 0.0);
    }
    @Test
    public void testCalcularCustoAluguelSemDesconto() {
        assertEquals(300.0, veiculoNormal.calcularCustoAluguel(3), 0.01);
        assertEquals(700.0, veiculoNormal.calcularCustoAluguel(7), 0.01);
    }
    @Test
    public void testCalcularCustoAluguelComDescontoMenor() {
        assertEquals(900.0, veiculoNormal.calcularCustoAluguel(10), 0.01);
    }
    @Test
    public void testCalcularCustoAluguelComDescontoMaior() {
        assertEquals(1275.0, veiculoNormal.calcularCustoAluguel(15), 0.01);
    }
    @Test
    public void testCalcularMulta() {
        assertEquals(0.0, veiculoNormal.calcularMulta(0), 0.01);
        assertEquals(240.0, veiculoNormal.calcularMulta(2), 0.01);
        assertEquals(600.0, veiculoNormal.calcularMulta(5), 0.01);
    }
    @Test
    public void testCenarioExtremoZeroDias() {
        assertEquals(0.0, veiculoNormal.calcularCustoAluguel(0), 0.01);
    }
    @Test
    public void testCenarioExtremoDiasNegativos() {
        assertEquals(-500.0, veiculoNormal.calcularCustoAluguel(-5), 0.01);
    }
    @Test
    public void testCenarioExtremoMultaDiasNegativos() {
        assertEquals(0.0, veiculoNormal.calcularMulta(-3), 0.01);
    }
    @Test
    public void testCenarioExtremoDiariaNegativa() {
        assertEquals(-150.0, veiculoDiariaNegativa.calcularCustoAluguel(3), 0.01);
        assertEquals(-120.0, veiculoDiariaNegativa.calcularMulta(2), 0.01);
    }
    @Test
    public void testCenarioExtremoDiariaZero() {
        assertEquals(0.0, veiculoDiariaZero.calcularCustoAluguel(5), 0.01);
        assertEquals(0.0, veiculoDiariaZero.calcularMulta(2), 0.01);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("Atividade2_DDDJava.VeiculoTeste");

        System.out.println("\n=== DEMONSTRAÇÃO DE RESULTADOS ===");
        Veiculo carro = new Veiculo("Gol", 100.0);
        System.out.println("Veículo: " + carro.modelo);
        System.out.println("Valor da diária: R$ " + carro.valorDiaria);
        System.out.println("Custo para 3 dias: R$ " + carro.calcularCustoAluguel(3));
        System.out.println("Custo para 10 dias (com desconto de 10%): R$ " + carro.calcularCustoAluguel(10));
        System.out.println("Custo para 15 dias (com desconto de 15%): R$ " + carro.calcularCustoAluguel(15));
        System.out.println("Multa por 2 dias de atraso: R$ " + carro.calcularMulta(2));
    }
}