package pilha;

public class Pilha {
    private No topo;
        // Lembrem-se, temos o construtor padrão, herdado de Object
        public void push (char info){
            No novo = new No(info);
                if (!pilhaVazia()){
                    novo.setProximo(topo);
                }
                topo=novo;
        }

        public char pop(){
            if(pilhaVazia())
                throw new RuntimeException("Pilha vazia, falha no pop");
            char info = topo.getInfo();
            topo = topo.getProximo();
            return info;
        }

        public char peek(){
            //Consulta o elemento do topo, sem desempilhar
            if(pilhaVazia())
                throw new RuntimeException("Pilha vazia, falha no peek");
            return topo.getInfo();
        }

        public void invertePilha(){
            //Inverte a pilha
            Pilha p = new Pilha();
            while(p.pilhaVazia()) {
                p.push(this.pop());
            }
            this.topo = p.topo;
        }

        public boolean pilhaVazia(){
            return topo==null;
        }
    }
    class No{
        private char info;
        private No proximo;
        
        public No(char info) {
            this.info = info;
        }

        public char getInfo() {
            return info;
        }

        public void setInfo(char info) {
            this.info = info;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }

        @Override
        public String toString() {
            return "No [" + info + "]";
        } 
    
}