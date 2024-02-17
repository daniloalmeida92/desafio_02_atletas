import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int qtdAtletas;
        String sexo;
        String nome;
        String nomeMaisAlto = null;
        double altura = 0;
        double peso;

        double pesoMedio;
        double somaPeso = 0;
        double maisAlto = 0;
        int qtdHomens = 0;
        double porcentagemHomens = 0;
        int qtdMulheres = 0;
        double somaAlturaMulheres = 0;
        double alturaMediaMulheres = 0;

        System.out.println("""
                SISTEMAS DE ATLETAS
                """);

        System.out.print("Qual a quantidade de atletas? ");
        qtdAtletas = sc.nextInt();
        System.out.println("");


        for (int i = 1; i <= qtdAtletas; i++) {

            System.out.println("Digite os dados do atleta numero " + i + ":");
            sc.nextLine();

            System.out.print("Nome: ");
            nome = sc.nextLine();

            System.out.print("Sexo: ");
            sexo = sc.nextLine();


            while (!sexo.equals("F") && !sexo.equals("M")) {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                sexo = sc.nextLine();
            }


            if (sexo.equals("M")) {
                qtdHomens++;
            }

            System.out.print("Altura: ");
            altura = sc.nextDouble();

            while (altura <= 0) {
                System.out.println("Valor invalido! Favor digitar um valor positivo:");
                altura = sc.nextDouble();
            }
            if (altura > maisAlto) {
                maisAlto = altura;
                nomeMaisAlto = nome;
            }

            if (sexo.equals("F")) {
                somaAlturaMulheres = somaAlturaMulheres + altura;
                qtdMulheres++;
            }

            System.out.println("Peso: ");
            peso = sc.nextDouble();

            while (peso <= 0) {
                System.out.println("Valor invalido! Favor digitar um valor positivo:");
                peso = sc.nextDouble();
            }

            somaPeso = somaPeso + peso;

        }

        System.out.println("""
                RELATÓRIO:
                """);

        pesoMedio = somaPeso / qtdAtletas;
        porcentagemHomens = ((double) qtdHomens / qtdAtletas) * 100;
        alturaMediaMulheres = somaAlturaMulheres / qtdMulheres;

        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
        System.out.println("Atleta mais alto: " + nomeMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);

        if (qtdMulheres != 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
        } else {
            System.out.println("Não há Mulheres Cadastradas");
        }

    }
}