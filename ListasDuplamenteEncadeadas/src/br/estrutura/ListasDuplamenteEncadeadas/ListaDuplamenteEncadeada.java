package br.estrutura.ListasDuplamenteEncadeadas;


/**
 * @author Erick Wendel
 *
 */

//classe responsavel pelos metodos da lista
public class ListaDuplamenteEncadeada {
	// atributos para referencia
	private Celula primeira;

	private Celula ultima;
	// total de elementos da lista
	private int totalDeElementos;

	// Adiciona no fim da Lista.
	public void adiciona(Object elemento) {
		// caso nao existir nenhum elemento
		// adiciona no inicio
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			// cria uma nova celula na lista
			// e adiciona o elemento
			Celula nova = new Celula(elemento);
			// a referencia da proxima posicao recebe o novo elemento
			this.ultima.setProxima(nova);
			// a referencia do elemento anterior recebe a ultima
			nova.setAnterior(this.ultima);
			// como terá somente um elemento na lista,
			// ele será a primeira e a ultima da lista
			this.ultima = nova;
			// incrementa o total de elementos
			this.totalDeElementos++;
		}
	}

	// lista dupla
	public void adiciona(int posicao, Object elemento) {
		
		// verifica se a posicao será a de inicio
		if (posicao == 0) { // Adicionará no inicio
			this.adicionaNoComeco(elemento);
			
			// se a posicao for o mesmo tamanho dos elementos
			// adicionara no fim
		} else if (posicao == this.totalDeElementos) { // No fim.
			this.adiciona(elemento);

		} else {
			
			// referencia anterior recebe a celula que estiver na
			// penultima posicao
			Celula anterior = this.pegaCelula(posicao - 1);
			
			// celula proxima recebe a ultima posicao
			Celula proxima = anterior.getProxima();
			
			// a nova celula recebera a que estiver na frente da anterior
			// a adiciona a proxima referencia do novo elemento
			Celula nova = new Celula(anterior.getProxima(), elemento);
			
			// anterior a nova recebe a referencia
			nova.setAnterior(anterior);
			
			// a proxima da anterior, receberá a nova posicao
			anterior.setProxima(nova);
			
			//anterior que estiver a frente do elemento, recebera
			//o novo elemento.
			proxima.setAnterior(nova);
			
			//incrementa o total de elementos
			this.totalDeElementos++;
		}
	}

	//metodo responsavel por adicionar no inicio da lista
	public void adicionaNoComeco(Object elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			//caso existir mais de um elemento na lista
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}

	//usado para validacoes, caso nao exista aquela posicao
	//no total de elementos, ele retorna false
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	//usado em nossos metodos, para verificar a partir da posicao
	private Celula pegaCelula(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}
		//retorna a celula naquela posicao
		return atual;
	}

	// Pega elemento por posição.
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	// remove do inicio da lista
	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		//a primeira posicao recebe quem estiver a frente
		this.primeira = this.primeira.getProxima();
		//diminui o total de elementos -1
		this.totalDeElementos--;
		//se o total de elementos = a ultima sera nula.
		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	// remove pelo fim da lista
	public void removeDoFim() {
		//joga o erro caso nao tenha elementos
		if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		//se existir somente um remove do inicio
		if (this.totalDeElementos == 1) {
			this.removeDoComeco();
		} else {
			//a penultima receve a anterior a ultima
			Celula penultima = this.ultima.getAnterior();
			//a penultima se torna a ultima
			penultima.setProxima(null);
			//a ultima se torna a penultima referencia
			this.ultima = penultima;
			//decrementa os elementos
			this.totalDeElementos--;
		}
	}

	// remove pela posicao
	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		if (posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			//celula anterior recebe a penultima celula
			Celula anterior = this.pegaCelula(posicao - 1);
			//celula atual, recebe a que vir depois da anterior
			Celula atual = anterior.getProxima();
			//proxima celula recebe a que vir depois da atual
			Celula proxima = atual.getProxima();

			//a que vir depois da anterior recebe a proxima
			anterior.setProxima(proxima);
			//anterior recebe a ultima
			proxima.setAnterior(anterior);

			this.totalDeElementos--;
		}
	}

	// verifica se existe aquele elemento
	public int contem(Object elemento) {
		Celula atual = this.primeira;
		int posicao = 0;
		while (atual != null) {
			//caso aquele elemento existir retorna a posicao
			if (atual.getElemento().equals(elemento)) {
				return posicao;
			}
			atual = atual.getProxima();
			posicao++;
		}
		//caso nao tenha nenhum, retorna -1 
		return -1;
	}

	// verifica o tamanho total de elementos
	public int tamanho() {
		return this.totalDeElementos;
	}

	// metodo sobreescrito para retornar uma lista
	public String toString() {

		// Verificando se a Lista está vazia
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;

		// Percorrendo até o penúltimo elemento.
		for (int i = 0; i < this.totalDeElementos - 1; i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProxima();
		}

		// último elemento
		builder.append(atual.getElemento());
		builder.append("]");
		//retorna nossos elementos em formato de array
		//[elemento]
		return builder.toString();
	}
}
