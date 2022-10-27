package calcularcontamesv1;

import java.util.Scanner;
import java.text.DecimalFormat;

class CalcularContaMesv1
{
  
// Metodos/Funções
  
  public static void separador(){
  for(int i=0;i<60;i++){
    System.out.print("-");
  }
      
}
  public static void distanciador(){
  for(int i=0;i<20;i++){
    System.out.print("-");
  }
 }
// Inicio do Código
    
  public static void main(String[] args) {
    
    final double sal=2746.82;
    double valor[]= new double[100],resultado,totalsaldo=sal;
    String nomeconta[] = new String[100];
    Scanner coleta = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat();
    df.applyPattern("R$ #,##0.00");
 
    int numcontas;
    
    
    separador();
    
    System.out.print("\nQuantas contas você deseja realizar:");
  numcontas = coleta.nextInt();

    for(int i=0;i<numcontas;i++){
      System.out.print("Insira o valor da "+(i+1)+"a conta: ");
      valor[i] = coleta.nextDouble();
    
     System.out.print("\nQual o nome da conta: ");
      
    nomeconta[i] = coleta.next();
    }
    
    System.out.println("");
    
    separador();
    
    System.out.println("\nExtrato");
    
    
    
    System.out.println("\nSaldo: "+df.format(totalsaldo));
    
    separador();

    for(int i=0;i<numcontas;i++){

      totalsaldo -= valor[i];

      System.out.print("\n\nSaldo: "+df.format(totalsaldo));
      
      distanciador();

        System.out.print(df.format(valor[i]));
      System.out.print(" -> "+nomeconta[i]);
      
    }
    
    System.out.println("");
    
    separador();
    
    System.out.println("\n\nSaldo: "+df.format(totalsaldo));
    
    
    
    
    
    
    
    
    
  }
}
