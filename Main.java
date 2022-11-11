import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Path;
import java.nio.file.Paths;



class Main {
  
// Metodos/Funções
  public static void apresentacaoInicio(){
    float teste;
    separador();
    System.out.print("\n");
    separador();
    System.out.print("\nBem-vindo ao CCM- Caculador de Contas Mensal, este programa disponibiliza o usuário inserir as contas que deseja calcular e no final retorna para o próprio a quantidade que restou do seu dinheiro, sendo possível gerar um extrato de todos os valores que foram inseridos podendo realizar o acompanhamento do decréscimo!\n");
    separador();
    System.out.print("\n");
    separador();
  }
  public static void separador(){
    for(int i=0;i<100;i++){
    System.out.print("-");
    }
      
  }
  public static void distanciador(){
    for(int i=0;i<25;i++){
    System.out.print("-");
    }
   }
// Inicio do Código
    
  public static void main(String[] args) {
    
    final double sal=2746.82; //Valor fixo do salário
    Scanner coleta = new Scanner(System.in); // Objeto responsável por coleta de dados
    ArrayList <Double> valor = new ArrayList<>(); // Arraylist que guardara os valores inseridos
    double resultado=sal,totalsaldo=sal;
    ArrayList <String> nomeconta = new ArrayList<>(); //Arraylist que guardará o nome das contas
    DecimalFormat df = new DecimalFormat();
    df.applyPattern("R$ #,##0.00"); //Formatação de impressão dos valores para real
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss"); //Formatação de imressão de data no extrato;
    
    
    double aux; //Variavel para auxiliar na verifiicação de condição de encerramento
    char opcao,opcao2,opcao3; //Variaveis que serão utilizadas para escolhas

    
    apresentacaoInicio();
    System.out.print("\nDigite 0 quando desejar parar a inserção de valores\n");
    separador();
    int cont=0;
    do{

      System.out.print("\nInsira o valor desejado: ");
      valor.add(aux=coleta.nextDouble()); //Coleta de dos valores que serão calculados
      
      if(aux!=0){
        
        do{
           System.out.println("Deseja inserir nome para esta conta?[S/N]");
            opcao= coleta.next().charAt(0);//Coleta de escolha se será inserido ou não um identificador para a conta
          
          
          if(opcao!='s' && opcao!='n' && opcao!='S'){
            
         System.out.println("\nCaracter inválido favor digitar apenas os citados no menu!!...");
          }
          
    }while(opcao!='s' && opcao!='S' && opcao!='n');
        
     switch(opcao){
         
      case 's':    
         System.out.print("\nQual o nome da conta: ");
          nomeconta.add(coleta.next());// Coleta do identificador da conta inserida caso o usuário digite s minúsculo
           System.out.println("Nome da conta = "+nomeconta.get(cont));
         do{ 
           System.out.println("Deseja alterar nome desta conta?[S/N]");
            opcao3 = coleta.next().charAt(0);
           switch(opcao3){
             case 's':
           System.out.print("Insira o novo nome da conta: ");
           nomeconta.set(cont,coleta.next());
           System.out.print("\nAlteração realizada com sucesso!");
           if(opcao3!='s' && opcao3!='S' && opcao3!='n'){
             System.out.print("Caracter inválido! Favor inserir os caracteres citados no menu!");
             }
             break;

             case 'S':
                System.out.print("Insira o novo nome da conta: ");
           nomeconta.set(cont,coleta.next());
           System.out.print("\nAlteração realizada com sucesso!");
           if(opcao3!='s' && opcao3!='S' && opcao3!='n'){
             System.out.print("Caracter inválido! Favor inserir os caracteres citados no menu!");
             }
               break;

             case 'n':
               System.out.println("\nOkay prosseguindo!");
               
               break;
              case 'N':
               System.out.println("\nOkay prosseguindo!");
               
               break;
           }
            }while(opcao3!='s' && opcao3!='S' && opcao3!='n');
        break;
         
      case 'S':
         do{ 
           System.out.println("Deseja alterar nome desta conta?[S/N]");
            opcao3 = coleta.next().charAt(0);
           switch(opcao3){
             case 's':
           System.out.print("Insira o novo nome da conta: ");
           nomeconta.set(cont,coleta.next());
           System.out.print("\nAlteração realizada com sucesso!");
           if(opcao3!='s' && opcao3!='S' && opcao3!='n'){
             System.out.print("Caracter inválido! Favor inserir os caracteres citados no menu!");
             }
             break;

             case 'S':
                System.out.print("Insira o novo nome da conta: ");
           nomeconta.set(cont,coleta.next());
           System.out.print("\nAlteração realizada com sucesso!");
           if(opcao3!='s' && opcao3!='S' && opcao3!='n'){
             System.out.print("Caracter inválido! Favor inserir os caracteres citados no menu!");
             }
               break;

             case 'n':
               System.out.println("\nOkay prosseguindo!");
               
               break;
              case 'N':
               System.out.println("\nOkay prosseguindo!");
               
               break;
           }
            }while(opcao3!='s' && opcao3!='S' && opcao3!='n');
      break;
         
      case 'n':
         System.out.print("Okay! Prosseguindo!");// Retorno se o usuário não desejar inserir identificador na conta
           nomeconta.add("Conta");
      break;
         
      case 'N':
         System.out.print("Okay! Prosseguindo!");// Retorno se o usuário não desejar inserir identificador na conta
           nomeconta.add("Conta");
      break;

      default:
         System.out.print("Caracter inválido!");// Retorno casa seja adentrado um caracter inexistente
        ;
       }
      }
      
      cont++;
      
    }while(aux!=0); // Laço de repetição parar continuar coletando os valores até que seja inserido o valor 0
    
    System.out.println("");
    
     for(int i=0;i<valor.size();i++){
       
      resultado -= valor.get(i); // Operação matemática para calcular o que sobrará depois do decréscimo
        
    }
    
    System.out.println("O que restará para você no final do mês é: "+df.format(resultado));// Reorno do total pós decréscimo
    separador();
    
    do{
      
      System.out.println("\nGerar extrato?[S/N]");
        opcao2= coleta.next().charAt(0); //Coleta de escolha se irá ou não gerar o extrato
      if(opcao2!='s' && opcao2!='n' && opcao2!='S'){
        
         System.out.println("\nCaracter inválido favor digitar apenas os citados no menu!!...");
      }
    }while(opcao2!='s' && opcao2!='n' && opcao2!='S');
    
    switch(opcao2){ //Dupla escolha de gerar ou não o extrato
        
      case 's': //Caso o usuário digitar s Minúsculo

        //Processo para imprimir o extrato na tela
        
        System.out.print("\nExtrato\n \nData         Horário\n"+ dtf.format(LocalDateTime.now())+"\n");
    
        separador();
        
        System.out.print("\nSaldo: "+df.format(totalsaldo));
        
        if(aux!=0){
          
          for(int i=0;i<valor.size();i++){

          System.out.print("\n\n Saldo: "+df.format(totalsaldo)+" ");
      
          distanciador();
      
          System.out.print(df.format(valor.get(i)));
          System.out.print(" -> "+nomeconta.get(i));
            totalsaldo -= valor.get(i); //
        
          }
        }else{
          
            for(int i=0;i<valor.size()-1;i++){

            System.out.print("\n\nSaldo: "+df.format(totalsaldo));
      
            distanciador();
      
            System.out.print(" "+df.format(valor.get(i)));
            System.out.print(" -> "+nomeconta.get(i));
              totalsaldo -= valor.get(i); // Reorno do total pós decréscimo
            }
          }
    
    System.out.print("");
    System.out.print("\n\nSaldo restante: "+df.format(totalsaldo)+"\n");
    
    separador();
    
    break;

    case 'S': //Caso o usuário digitar s Maiúsculo
        
      System.out.print("\nExtrato\n \nData         Horário\n"+ dtf.format(LocalDateTime.now())+"\n");
    
      separador();
        
      System.out.print("\nSaldo: "+df.format(totalsaldo));
        
      if(aux!=0){
          
        for(int i=0;i<valor.size();i++){

          System.out.print("\n\n Saldo: "+df.format(totalsaldo)+" ");
      
          distanciador();
      
          System.out.print(df.format(valor.get(i)));
          System.out.print(" -> "+nomeconta.get(i));
            totalsaldo -= valor.get(i);
        
        }
      }else{
          
            for(int i=0;i<valor.size()-1;i++){

            System.out.print("\n\nSaldo: "+df.format(totalsaldo));
      
            distanciador();
      
            System.out.print(" "+df.format(valor.get(i)));
            System.out.print(" -> "+nomeconta.get(i));
              totalsaldo -= valor.get(i);
          }
        }
    
    System.out.print("");
    System.out.print("\n\nSaldo restante: "+df.format(totalsaldo)+"\n");
    
    separador();
    break;
        
    case 'n': //Caso o usuário digitar n Minúsculo
        
        separador();
        System.out.println("\nEncerrando....");
        
    break;
        
    case 'N': //Caso o usuário digitar n Maiúsculo
        separador();
        System.out.println("\nEncerrando....");
     break;
        
    default:
        
        System.out.println("\nCaracter inválido favor digitar apenas os citados no menu!!...");
        ;    
    
    
    
    
    
    }
  }
}
