import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    public TaxasDeCambio buscaTaxas(String moedaBase) {
        // AQUI ESTÁ O SEU LINK! 
        // O final dele é preenchido dinamicamente pela 'moedaBase' que o usuário escolher.
        String seuLink = "https://v6.exchangerate-api.com/v6/2235ffb713ee099eb91f28a0/latest/" + moedaBase;
        
        URI endereco = URI.create(seuLink);
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            
            // O Gson faz a mágica de transformar o texto JSON no nosso Record
            return new Gson().fromJson(response.body(), TaxasDeCambio.class);
            
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível conectar à API de câmbio: " + e.getMessage());
        }
    }
}