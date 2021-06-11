package projetoCachorro;

import java.util.Scanner;
import java.util.ArrayList;

public class MainCachorro {

    public static void main(String[] args) {
       int opcao;
       Scanner sc = new Scanner(System.in);
       ArrayList<Cachorro> listaCachorros = new ArrayList();
       do{
           System.out.println("---MENU INICIAL---");
           System.out.println("1: Cadastrar cão");
           System.out.println("2: Listar cães");
           System.out.println("3: Sair do programa");
           System.out.println("Selecione uma opção:");
           opcao = sc.nextInt();
           
           switch(opcao){
               case 1:{
                   Scanner variavelNome = new Scanner(System.in);
                   Scanner variavelRaca = new Scanner(System.in);
                   Scanner variavelSexo = new Scanner(System.in);
                   Scanner variavelIdade = new Scanner(System.in);
                   String nome;
                   String raca;
                   char sexo;
                   int idade;
                   
                   System.out.println("Digite o nome do cachorro:");
                   nome = variavelNome.nextLine();
                   System.out.println("Digite a raça do cachorro");
                   raca = variavelRaca.nextLine();
                   System.out.println("Digite o sexo do cachorro (M: Masculino, F: Feminino)");
                   sexo = variavelSexo.next().charAt(0);
                   System.out.println("Digite a idade do cachorro:");
                   idade = variavelIdade.nextInt();
                   
                   Cachorro novoCachorro = new Cachorro(nome, raca, sexo, idade);
                   listaCachorros.add(novoCachorro);
                   break;
               }
               case 2:{
                   int i = 0;
                   int cachorroSelecionado;
                   for(Cachorro cachorro: listaCachorros){
                       System.out.print( (i+1)+ "--" + cachorro.getNome() + ", ");
                       i++;
                   }
                   System.out.println("");
                   System.out.println("Selecione um cachorro pela sua posição na lista:");
                   cachorroSelecionado = sc.nextInt();
                   manipularCachorro(listaCachorros.get(cachorroSelecionado - 1), listaCachorros);
                   break;
               }
               case 3:{
                   System.exit(0);
               }
               default:{
                   System.out.println("Entre com um valor valido");
                   break;
               }
           }
           
       }while(opcao != 3);
    }
    
    public static void manipularCachorro(Cachorro cachorroAtual, ArrayList<Cachorro> lista){
        Scanner sc = new Scanner(System.in);
        int opcoes;
        do{
            System.out.println("---MENU MANIPULAR CACHORRO---");
            System.out.println("1: Ver dados do cao");
            System.out.println("2: Alimentar o animal");
            System.out.println("3: Brincar com o animal");
            System.out.println("4: Cruzar");
            System.out.println("5: Voltar ao menu inicial");
            System.out.println("Selecione uma opção do menu: ");
            opcoes = sc.nextInt();
            
            switch(opcoes){
                case 1:{
                    cachorroAtual.obterDados();
                    break;
                }
                case 2:{
                    char comida;
                    System.out.println("Selecione uma comida para dar ao animal(R: Ração, C: Carne, L: legumes)");
                    comida = sc.next().charAt(0);
                    cachorroAtual.comer(comida);
                    break;
                }
                case 3:{
                    char brincadeira;
                    System.out.println("Selecione um tipo de brincadeira: (B: Buscar bolinha, S: Saltar, G: girar)");
                    brincadeira = sc.next().charAt(0);
                    cachorroAtual.brincar(brincadeira);
                    break;
                }
                case 4:{
                   int i = 0;
                   int parceirosDisponiveis = 0; 
                   Scanner escolheParceiro = new Scanner(System.in);
                   System.out.print("Parceiros habilitados a cruzar: ");
                   for(Cachorro parceiro: lista){
                       if((cachorroAtual.podeCruzar(parceiro)) && (parceiro != cachorroAtual)){
                           System.out.print((i+1) + "--" + parceiro.getNome() + ", ");
                           parceirosDisponiveis++;
                       }
                       i++;
                   }
                   if(parceirosDisponiveis == 0){
                       System.out.println("Sem parceiros no momento.");
                       break;
                   }
                   System.out.println("");
                   System.out.println("Selecione com quem cruzar de acordo com a numeração: ");
                   int indiceParceiro = escolheParceiro.nextInt();
                   cachorroAtual.cruzar(lista.get(indiceParceiro - 1));
                   break;
                }
                case 5:{
                    break;
                }
                default:{
                    System.out.println("Valor inválido, tente novamente.");
                    break;
                }
            }
        }while (opcoes != 5);
    }
    
}
