import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda consulta = new ConsultaMoeda();
        int opcao = 0;

        String menu = """
                *****************************************************
                Seja bem-vindo/a ao Conversor de Moedas!
                
                1) Dólar (USD) => Real Brasileiro (BRL)
                2) Real Brasileiro (BRL) => Dólar (USD)
                3) Dólar (USD) => Peso Argentino (ARS)
                4) Peso Argentino (ARS) => Dólar (USD)
                5) Dólar (USD) => Euro (EUR)
                6) Euro (EUR) => Dólar (USD)
                7) Sair
                
                Escolha uma opção válida:
                *****************************************************
                """;

        while (opcao != 7) {
            System.out.println(menu);
            
            if (leitura.hasNextInt()) {
                opcao = leitura.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                leitura.next(); 
                continue;
            }

            if (opcao == 7) {
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.println("Digite o valor que deseja converter:");
            double valor = leitura.nextDouble();

            try {
                // Descobre quem é a moeda de origem e quem é a de destino
                String moedaOrigem = (opcao % 2 != 0) ? "USD" : determinarMoeda(opcao);
                String moedaDestino = (opcao % 2 != 0) ? determinarMoeda(opcao) : "USD";

                // Chama a nossa classe que usa o seu link
                TaxasDeCambio taxas = consulta.buscaTaxas(moedaOrigem);
                
                // Pega a taxa específica da moeda de destino
                double taxaDeCambio = taxas.conversion_rates().get(moedaDestino);
                double valorConvertido = valor * taxaDeCambio;

                System.out.printf("\n>>> %.2f [%s] = %.2f [%s]\n\n", 
                                   valor, moedaOrigem, valorConvertido, moedaDestino);

            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao buscar a cotação: " + e.getMessage());
            }
        }
        
        System.out.println("Programa finalizado!");
        leitura.close();
    }

    private static String determinarMoeda(int opcao) {
        return switch (opcao) {
            case 1, 2 -> "BRL";
            case 3, 4 -> "ARS";
            case 5, 6 -> "EUR";
            default -> "";
        };
    }
}