import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "Lista_URL.txt";
        Queue<String> fila = new LinkedList<>();
        Scanner ler = new Scanner(System.in);

        try {
            BufferedReader leitura = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = leitura.readLine()) != null) {
                fila.offer(linha);
            }
            leitura.close();

            while (!fila.isEmpty()) {
                String linhaLida = fila.poll();
                System.out.println("Link: " + linhaLida); // Exemplo: imprime cada linha lida
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }

        System.out.println("Digite o link a ser excluído: ");
        String linkDel = ler.nextLine();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            while (!fila.isEmpty()) {
                String link = fila.poll();
                if (!link.equals(linkDel)) {
                    escritor.write(link);
                    escritor.newLine();
                }
            }

            System.out.println("Link removido: " + linkDel);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }

        int quantidadeRegistrosRestantes = fila.size();
        System.out.println("Quantidade de registros restantes: " + quantidadeRegistrosRestantes);

        System.out.println("Itens restantes na fila:");
        for (String item : fila) {
            System.out.println("Link: " + item);
        }

        System.out.println("Digite um link para consulta: ");
        String linkConsulta = ler.nextLine();

        if (fila.contains(linkConsulta)) {
            System.out.println("Link encontrado: " + linkConsulta);
        } else {
            System.out.println("Link não encontrado: " + linkConsulta);
        }
        ler.close();
    }
}
