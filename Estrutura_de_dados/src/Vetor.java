public class Vetor {
	private Aluno[] alunos = new Aluno[100];

    private int totalDealunos = 0;

    public void Adiciona (Aluno aluno){
        this.alunos[this.totalDealunos]= aluno;
        this.totalDealunos++;
    }

    public int getTotalDealunos(){
        return totalDealunos;
    }

    public boolean AdicionaPosicao(int posicao, Aluno aluno){
    	if (!this.posicaoOcupada(posicao)) {
    		throw new IllegalArgumentException("Posição Valida");
    	}
    	for (int i = this.totalDealunos - 1; i >= posicao ; i --) {
    		this.alunos[i + 1] = this.alunos[i];
    	}
    	this.alunos[posicao] = aluno;
    	this.totalDealunos ++;
    	return false;
    }

    public boolean remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
        	throw new IllegalArgumentException("posição inválida");
        }
        	for(int i = posicao; i < this.totalDealunos - 1;  i++) {
        		this.alunos[i] = this.alunos[i + 1];
        	}
        	this.totalDealunos--;
        	return false;
    }

    public  boolean contem(Aluno aluno){
        for(int i=0; i<alunos.length; i++){
            if(aluno==alunos[i]) {
                return true;
            }
        }
        return false;
    }

    public int tamanho (){
        return this.totalDealunos;
    }

    public String toString() {
        if(this.totalDealunos==0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDealunos- 1; i++) {
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        builder.append(this.alunos[this.totalDealunos- 1]);
        builder.append("]");

        return builder.toString();
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDealunos;
    }


    public Aluno pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw  new IllegalArgumentException("Posicão inválida");
        }
        return this.alunos[posicao];
    }
}
