import java.util.Scanner;

public class ex2 {

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    
    int x;
    double aux = 0;
    double soma;
    double menor =  Integer.MIN_VALUE;
    String nomes = "";
    double total = 0;
    System.out.print("Total de correntistas --> ");
    x = teclado.nextInt();

    double SaldoPoupanca[] = new double[x];
    double SaldoCorrente[] = new double[x];
    String[] correntista = new String[x];

    // entrada de dados para o nome do funcionario e o saldo em conta.
    for (int i = 0; i < x; i++) {
      teclado.nextLine(); // teclado ocupa a var, por isso o nexline.
      System.out.println(); // dar espaçamento
      System.out.println((i + 1) + "° correntista");
      System.out.print("Nome ---> ");
      correntista[i] = teclado.nextLine();

      do {
        System.out.print("Saldo em conta Poupanca --> R$ ");
        SaldoPoupanca[i] = teclado.nextDouble();
        if (SaldoPoupanca[i] <= 0) 
          System.out.println("O saldo tem que ser maior que zero");
      } while (SaldoPoupanca[i] <=0); //se for negativo, fica realizando um loop até colocar um valor positivo
      System.out.print("Saldo em conta Corrente --> R$ ");
      SaldoCorrente[i] = teclado.nextDouble();
    }
    System.out.println();
    // exibir os nomes dos correntistas junto aos valores respectivos
    for (int i = 0; i < x; i++) {
      System.out.println(correntista[i] + " **Saldo em conta poupanca --> R$ " + String.format("%.2f", SaldoPoupanca[i])
          + "** **Saldo em conta corrente --> R$ " + String.format("%.2f", SaldoCorrente[i]));

    }
    System.out.println();
    // IMPRESSAO DOS CORRENTISTAS NEGATIVOS
    for (int i = 0; i < x; i++) {
      if (SaldoCorrente[i] < 0) {
        System.out.println("Correntistas com saldo negativo em conta corrente --> " + correntista[i] + " ");
      }
      // está repetindo duas vezes, nao consegui colocar tudo em um loop, criei um
      // laço para cada ex ;/

    }
    System.out.println();
    // IMPRIMIR O MAIOR VALOR APLICADO NAS 2 -- nome do correntista
    for (int i = 0; i < x; i++) {
      soma = SaldoCorrente[i] + SaldoPoupanca[i];

      if (soma > menor) {
        menor = soma; //armazenando em var's para serem exibidas depois
        nomes = correntista[i];
      }
    }
    System.out.println("Maior aplicador nas duas carteiras --> " + nomes);
    System.out.println();
    aux = 0; //zerando a var aux
    //laço para ver o maior aplicador na poupanca
    for (int i = 0; i < x; i++) {
      
      if(SaldoPoupanca[i] > aux) {
        aux = SaldoPoupanca[i];
        nomes = correntista [i];
      }
    }
    System.out.println("Maior aplicador na Conta Poupanca --> " + nomes);
    System.out.println();
    for (int i = 0; i < x; i++) {
      
      soma = SaldoCorrente[i] + SaldoPoupanca[i];
      total += soma;
    }
    System.out.println("O total da soma de todos os correntista --> " + String.format("%.2f", total));
  } //Desculpa a quantidade de for's um fora do outro, mas esse foi o único jeito 

}
