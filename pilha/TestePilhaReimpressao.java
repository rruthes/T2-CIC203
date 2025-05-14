package pilha;
import java.time.Duration;
import java.time.LocalDateTime;
public class TestePilhaReimpressao {
    public static void main(String[] args) throws InterruptedException {
        PilhaReimpressao pilha = new PilhaReimpressao(3);
        System.out.println("--- adicionar documentos ---");
        System.out.println("adicionando doc1.txt (user1): " + pilha.solicitarReimpressao("doc1.txt", "user1")); 
        System.out.println("adicionando doc2.txt (user2): " + pilha.solicitarReimpressao("doc2.txt", "user2")); 
        System.out.println("adicionando doc3.txt (user3): " + pilha.solicitarReimpressao("doc3.txt", "user3")); 
        System.out.println("adicionando doc4.txt (user4) (pilha cheia): " + pilha.solicitarReimpressao("doc4.txt", "user4")); 
        System.out.println("\n--- consultar documento ---");
        System.out.println("consultar doc2.txt: " + pilha.consultarDoc("doc2.txt")); 
        System.out.println("consultar doc99.txt (não existe): " + pilha.consultarDoc("doc99.txt")); 
        System.out.println("\n--- reimprimir ---");
        System.out.println("reimprimindo: " + pilha.reimprimir().getNomeArquivo()); 
        System.out.println("reimprimindo: " + pilha.reimprimir().getNomeArquivo()); 
        System.out.println("reimprimindo: " + pilha.reimprimir().getNomeArquivo());
        System.out.println("tentar reimprimir: " + pilha.reimprimir());
        System.out.println("\n--- tempo de espera ---");
        pilha.solicitarReimpressao("doc5.txt", "user5");
        Thread.sleep(2000); 
        Documento reimpresso = pilha.reimprimir();
        if (reimpresso != null) {
            Duration tempoEspera = Duration.between(reimpresso.getHorario(), LocalDateTime.now());
            System.out.println("tempo de espera para doc5.txt: " + tempoEspera.getSeconds() + " segundos"); 
        }
    }
}