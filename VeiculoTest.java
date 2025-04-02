import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    @Test
    void testCalcularCustoAluguel() {
        Veiculo carro = new Veiculo("Sedan", 100);
        assertEquals(500, carro.calcularCustoAluguel(5)); // Sem desconto
        assertEquals(900, carro.calcularCustoAluguel(10)); // Com 10% de desconto
        assertEquals(1275, carro.calcularCustoAluguel(15)); // Com 15% de desconto
    }

    @Test
    void testCalcularCustoAluguelDiasInvalidos() {
        Veiculo carro = new Veiculo("Sedan", 100);
        assertThrows(IllegalArgumentException.class, () -> carro.calcularCustoAluguel(0));
    }

    @Test
    void testCalcularCustoAluguelDiariaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Veiculo("SUV", -50));
    }

    @Test
    void testCalcularMulta() {
        Veiculo carro = new Veiculo("Sedan", 100);
        assertEquals(0, carro.calcularMulta(0)); // Sem atraso
        assertEquals(360, carro.calcularMulta(3)); // 3 dias de multa com 20% sobre a diária
    }

    public static void main(String[] args) {
        VeiculoTest test = new VeiculoTest();

        try {
            test.testCalcularCustoAluguel();
            System.out.println("testCalcularCustoAluguel passou");
        } catch (AssertionError e) {
            System.out.println("testCalcularCustoAluguel falhou: " + e.getMessage());
        }

        try {
            test.testCalcularCustoAluguelDiasInvalidos();
            System.out.println("testCalcularCustoAluguelDiasInvalidos passou");
        } catch (AssertionError e) {
            System.out.println("testCalcularCustoAluguelDiasInvalidos falhou: " + e.getMessage());
        }

        try {
            test.testCalcularCustoAluguelDiariaNegativa();
            System.out.println("testCalcularCustoAluguelDiariaNegativa passou");
        } catch (AssertionError e) {
            System.out.println("testCalcularCustoAluguelDiariaNegativa falhou: " + e.getMessage());
        }

        try {
            test.testCalcularMulta();
            System.out.println("testCalcularMulta passou");
        } catch (AssertionError e) {
            System.out.println("testCalcularMulta falhou: " + e.getMessage());
        }
    }
}
