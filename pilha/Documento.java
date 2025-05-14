package pilha;

import java.time.LocalDateTime;

class Documento {
    private String nomeArquivo;
    private String usuario;
    private LocalDateTime horario;
    public Documento(String nomeArquivo, String usuario) {
        this.nomeArquivo = nomeArquivo;
        this.usuario = usuario;
        this.horario = LocalDateTime.now();
    }
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    public String getUsuario() {
        return usuario;
    }
    public LocalDateTime getHorario() {
        return horario;
    }
}

