
package br.estrutura.ListasDuplamenteEncadeadas;

import java.util.Scanner;

/**
 * @author Erick Wendel
 *	
 */

//classe responsavel pela execucao do programa
public class Execucao {


	public static void main(String[] args) {
		//valor colocado apenas para iniciar a contagem
		int opcao=10;
		//inicializa as variaveis
		String elemento = "";
		int posicao =0;
		Scanner sc = new Scanner(System.in);
		Scanner valor = new Scanner(System.in);

		//inicializa a lista.
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

		//caso a opcao for diferente de 0, ele executa as funcionalidades
		while(opcao != 0){

			System.out.println("\n....::Menu Lista Duplamente Encadeada::...\n");
			System.out.println(
					"1 - Adicionar Elemento no Fim da Lista \n"
							+ "2 - Adicionar na posicao desejada \n"
							+ "3 - Adicionar no Inicio da Lista \n"
							+ "4 - Remover do Inicio da Lista \n"
							+ "5 - Remover do Fim da Lista \n"
							+ "6 - Remover Elemento pela Posicao \n"
							+ "7 - Verificar Se existe Aquele elemento \n"
							+ "8 - Verificar o Total de Elementos na Lista \n"
							+ "9 - Exibir os Elementos da Lista \n"
							+ "0 - Sair \n");
			//recebe a opcao do usuario
			opcao = sc.nextInt();

			switch(opcao){

			//"1 - Adicionar Elemento no Fim da Lista \n"
			case 1: 
				System.out.println("Digite um valor para fim da Lista");
				elemento = valor.next();
				lista.adiciona(elemento);

				System.out.println("Adicionado Com Sucesso !");
				elemento = null;
				break;

				//"2 - Adicionar na posicao desejada \n"
			case 2: 
				System.out.println("Digite um valor ");
				elemento = valor.next();
				System.out.println("Digite uma posicao para insercao do elemento");
				posicao = valor.nextInt();

				lista.adiciona(posicao, elemento);
				posicao =0;
				elemento = null;

				System.out.println("Adicionado com sucesso !");
				break;

				//+ "3 - Adicionar no Inicio da Lista \n"
			case 3: 
				System.out.println("Digite Um Valor para Inicio da Lista");
				elemento = valor.next();
				lista.adicionaNoComeco(elemento);
				System.out.println("Adicionado com Sucesso !");
				elemento = null;

				break;

				//+ "4 - Remover do Inicio da Lista \n"
			case 4: 
				lista.removeDoComeco();
				System.out.println("Removido do Inicio da Lista com Sucesso");
				break;

				//+ "5 - Remover do Fim da Lista \n"
			case 5: 
				lista.removeDoFim();
				System.out.println("Removido do fim da Lista com Sucesso !");

				break;

				//"6 - Remover Elemento pela Posicao \n"
			case 6: 
				System.out.println("Insira a Posicao para remocao do Elemento");
				posicao = valor.nextInt();
				lista.remove(posicao);
				System.out.println("Removido com sucesso !");

				posicao = 0;

				break;
				//"7 - Verificar Se existe Aquele elemento \n"
			case 7: 
				System.out.println("Digite um Valor para Verificar se o Mesmo Existe");
				elemento = valor.next();
				int resultado = lista.contem(elemento);
				if(resultado >= 0){
					System.out.println("O Elemento Existe na posicao [" + resultado + "] da Lista");	
				}
				else{
					System.out.println("O Elemento nao Existe na Lista");
				}
				break;

				//"8 - Verificar o Total de Elementos na Lista \n"
			case 8: 
				System.out.println("A Lista possui [" + lista.tamanho() + "] Elementos");
				break;
				//"9 - Exibir os Elementos da Lista \n"
			case 9: 
				System.out.println(lista.toString());
				break;

			case 0:
				System.out.println("Sistema Encerrado com Sucesso !");
				break;

			default:
				System.out.println("Numero Inv�lido, tente novamente !");
				break;
			}



		}



	}
}
