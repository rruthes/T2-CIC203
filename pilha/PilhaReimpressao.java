package pilha;
import java.time.LocalDateTime;
import java.time.Duration;
public class PilhaReimpressao {
    private No topo;
    private int capacidade;
    private int tamanho;
    public PilhaReimpressao(int capacidade) {
        this.capacidade = capacidade;
        this.tamanho = 0;
    }
    public boolean solicitarReimpressao(String nomeArquivo, String usuario) {
        if (tamanho >= capacidade) return false;
        Documento doc = new Documento(nomeArquivo, usuario);
        No novo = new No(doc);
        novo.setProximo(topo);
        topo = novo;
        tamanho++;
        return true;
    }
    public Documento reimprimir() {
        if (topo == null) return null;
        Documento doc = topo.getDocumento();
        topo = topo.getProximo();
        tamanho--;
        return doc;
    }
    public String consultarDoc(String nomeArquivo) {
        No atual = topo;
        int posicao = 0;
        while (atual != null) {
            if (atual.getDocumento().getNomeArquivo().equals(nomeArquivo)) {
                return "posição: " + posicao + ", horário: " + atual.getDocumento().getHorario();
            }
            atual = atual.getProximo();
            posicao++;
        }
        return "documento não encontrado";
    }
    public boolean pilhaVazia() {
        return topo == null;
    }
    public boolean pilhaCheia() {
        return tamanho == capacidade;
    }
    private class No {
        private Documento documento;
        private No proximo;
        public No(Documento documento) {
            this.documento = documento;
        }
        public Documento getDocumento() {
            return documento;
        }
        public No getProximo() {
            return proximo;
        }
        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
    public static void main(String[] args) {
        PilhaReimpressao pilha = new PilhaReimpressao(3);
        pilha.solicitarReimpressao("doc1.txt", "user1");
        pilha.solicitarReimpressao("doc2.txt", "user2");
        System.out.println(pilha.consultarDoc("doc1.txt"));
        Documento reimpresso = pilha.reimprimir();
        if (reimpresso != null) {
            LocalDateTime horarioReimpressao = LocalDateTime.now();
            Duration tempo = Duration.between(reimpresso.getHorario(), horarioReimpressao);
            System.out.println("tempo de espera: " + tempo.getSeconds() + " segundos");
        }
    }
}