package Q2;

import java.util.Scanner;

public class MainQ2 {
    public static void main(String[] args) {
        int larguraEstante = 40;
        int alturaEstante = 40;

        // Crie uma matriz para representar a estante
        String[][] estante = new String[alturaEstante][larguraEstante];

        Scanner scanner = new Scanner(System.in);

        // Leitura dos códigos dos produtos e armazenamento na estante
        for (int i = 1; i <= 6; i++) {
            System.out.println("Digite o código do produto " + i + ": ");
            String codigoProduto = scanner.nextLine();

            // Verifique se a posição está disponível na estante
            boolean encontrado = false;
            for (int linha = 0; linha < alturaEstante; linha++) {
                for (int coluna = 0; coluna < larguraEstante; coluna++) {
                    if (estante[linha][coluna] == null) {
                        estante[linha][coluna] = codigoProduto;
                        System.out.println("Produto " + i + " armazenado na posição (" + linha + ", " + coluna + ")");
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estante cheia. Não é possível armazenar mais produtos.");
                break;
            }
        }

        // Opção para inserir mais produtos
        while (true) {
            System.out.println("Deseja inserir mais produtos? (S para Sim, N para Não): ");
            String resposta = scanner.nextLine().toUpperCase();
            if (!resposta.equals("S")) {
                break;
            }

            System.out.println("Digite o código do novo produto: ");
            String codigoProduto = scanner.nextLine();

            // Verifique se a posição está disponível na estante
            boolean encontrado = false;
            for (int linha = 0; linha < alturaEstante; linha++) {
                for (int coluna = 0; coluna < larguraEstante; coluna++) {
                    if (estante[linha][coluna] == null) {
                        estante[linha][coluna] = codigoProduto;
                        System.out.println("Novo produto armazenado na posição (" + linha + ", " + coluna + ")");
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Estante cheia. Não é possível armazenar mais produtos.");
                break;
            }
        }

        // Exibir a estante
        System.out.println("Estante:");
        for (int linha = 0; linha < alturaEstante; linha++) {
            for (int coluna = 0; coluna < larguraEstante; coluna++) {
                String codigoProduto = estante[linha][coluna];
                if (codigoProduto != null) {
                    System.out.print(codigoProduto + "\t");
                } else {
                    System.out.print("Vazio\t");
                }
            }
            System.out.println();
        }

        // Consulta de produtos na estante
        System.out.println("Digite o código do produto a ser consultado: ");
        String codigoConsulta = scanner.nextLine();
        boolean produtoEncontrado = false;

        for (int linha = 0; linha < alturaEstante; linha++) {
            for (int coluna = 0; coluna < larguraEstante; coluna++) {
                if (codigoConsulta.equals(estante[linha][coluna])) {
                    System.out.println("Produto encontrado na posição (" + linha + ", " + coluna + ")");
                    produtoEncontrado = true;
                    break;
                }
            }
            if (produtoEncontrado) {
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado na estante.");
        }

        scanner.close();
    }
}
