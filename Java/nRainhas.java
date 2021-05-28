
/**
* EXERCÍCIO PARCIAL 05 - PROBLEMA NRAINHAS
* Luís Felipe Zaguini Nunes Ferreira
*/

import java.util.Arrays;

public class nRainhas {

    private static int solucoes;
    private static String[] tabuleiroCompleto = {};

    public static boolean verificaRainha(int[] R, int k) {

        for (int i = 0; i < k; i++) {
            if (R[i] == R[k]) {
                return false;
            }

            if (Math.abs(R[i] - R[k]) == (k - i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean verificaArranjo(int[] R) {

        int n = R.length;
        int k = 0;

        while ((k < n) && (verificaRainha(R, k))) {
            k = k + 1;
        }

        if (k == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void permutacao(int[] R, int[] visitado, int k) {

        int n = R.length;

        if (k == n) {
            if (verificaArranjo(R)) {
                imprimeSolucao(R);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visitado[i] == 0) {
                    visitado[i] = 1;
                    R[k] = i;
                    permutacao(R, visitado, k + 1);
                    visitado[i] = 0;
                }
            }
        }
    }

    public static String[] append(String[] arr, String element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    private static void imprimeSolucao(int[] R) {

        int n = R.length;
        String tabuleiro = "";
        solucoes++;

        tabuleiro = ("\n  Solução número " + solucoes + ":\n ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (R[j] == i) {
                    tabuleiro = tabuleiro + (" 1 ");
                } else {
                    tabuleiro = tabuleiro + (" 0 ");
                }
            }
            tabuleiro = tabuleiro + ("\n ");
        }
        tabuleiro = tabuleiro + ("\n ");

        tabuleiroCompleto = append(tabuleiroCompleto, tabuleiro);
    }

    private static void resolve(int[] qntRainhas) {

        double tempoTotalDeTeste = 0;
        long tempoAcumulado;
        long tempo;

        for (int problemaAtual = 0; problemaAtual < qntRainhas.length; problemaAtual++) {

            int n = qntRainhas[problemaAtual];
            int rainhas[] = new int[n];
            int usado[] = new int[n];

            System.out.println("-----------------------------------------------------------");
            System.out.println("\nPara " + n + " Rainhas");

            tempoAcumulado = 0;
            solucoes = 0;

            System.gc();

            tempo = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                usado[i] = 0;
            }
            permutacao(rainhas, usado, 0);

            tempo = System.currentTimeMillis() - tempo;

            tempoAcumulado = tempoAcumulado + tempo;

            System.out.println("Soluções: " + solucoes + "\n");

            tempoTotalDeTeste = tempoTotalDeTeste + tempoAcumulado;
        }

        System.out.println("====================================");
        System.out.println("Tempo de execução: " + tempoTotalDeTeste + " milisegundos");
        System.out.println("====================================");
    }

    public static void main(String args[]) {

        int[] qntRainhas = { 8 };
        resolve(qntRainhas);
        System.out.println(nRainhas.tabuleiroCompleto[0]);
        System.out.println(nRainhas.tabuleiroCompleto[tabuleiroCompleto.length - 1]);
    }
}