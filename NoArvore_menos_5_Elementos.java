import java.util.LinkedList;
import java.util.Queue;

public class NoArvore_menos_5_Elementos {
  int info;
    NoArvore_menos_5_Elementos direita = null;
    NoArvore_menos_5_Elementos esquerda = null;

    void preOrdem(NoArvore_menos_5_Elementos tree) {
        if (tree != null) {
            System.out.print(tree.info + " ");
            preOrdem(tree.esquerda);
            preOrdem(tree.direita);
        }
    }

    void emOrdem(NoArvore_menos_5_Elementos tree) {
        if (tree != null) {
            emOrdem(tree.esquerda);
            System.out.print(tree.info + " ");
            emOrdem(tree.direita);
        }
    }

    void posOrdem(NoArvore_menos_5_Elementos tree) {
        if (tree != null) {
            posOrdem(tree.esquerda);
            posOrdem(tree.direita);
            System.out.print(tree.info + " ");
        }
    }

    void porNivel(NoArvore_menos_5_Elementos tree) {
        Queue<NoArvore_menos_5_Elementos> fila = new LinkedList<>();
        fila.add(tree);

        while (!fila.isEmpty()) {
            NoArvore_menos_5_Elementos temp = fila.poll();
            System.out.print(temp.info + " ");

            if (temp.esquerda != null) {
                fila.add(temp.esquerda);
            }

            if (temp.direita != null) {
                fila.add(temp.direita);
            }
        }
    }

    NoArvore_menos_5_Elementos InsereRaiz(NoArvore_menos_5_Elementos tree, int valor) {
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;

        return tree;
    }

    NoArvore_menos_5_Elementos Insere(NoArvore_menos_5_Elementos tree, int valor) {
        if (tree == null) {
            tree = new NoArvore_menos_5_Elementos();
            tree.info = valor;
            tree.direita = null;
            tree.esquerda = null;
        } else if (valor < tree.info) {
            tree.esquerda = Insere(tree.esquerda, valor);
        } else {
            tree.direita = Insere(tree.direita, valor);
        }
        return tree;
    }

    NoArvore_menos_5_Elementos Retira(NoArvore_menos_5_Elementos tree, int valor) {
        if (tree == null) {
            System.out.println("Elemento não encontrado..: " + valor);
            return null;
        } else if (tree.info > valor) {
            tree.esquerda = Retira(tree.esquerda, valor);
        } else if (tree.info < valor) {
            tree.direita = Retira(tree.direita, valor);
        } else {
            if (tree.esquerda == null && tree.direita == null) {
                tree = null;
            } else if (tree.esquerda == null) {
                tree = tree.direita;
            } else if (tree.direita == null) {
                tree = tree.esquerda;
            } else {
                NoArvore_menos_5_Elementos novo = tree.esquerda;
                while (novo.direita != null) {
                    novo = novo.direita;
                }
                tree.info = novo.info;
                tree.esquerda = Retira(tree.esquerda, novo.info);
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        NoArvore_menos_5_Elementos tree = new NoArvore_menos_5_Elementos();
        NoArvore_menos_5_Elementos root = tree.InsereRaiz(tree, 50);

        for (int i = 0; i < 99; i++) {
            int randomNumber = (int) (Math.random() * 100);
            root = tree.Insere(root, randomNumber);
        }

        System.out.println("Pré-ordem antes da remoção:");
        tree.preOrdem(root);

        // Remover 5 elementos aleatórios
        for (int i = 0; i < 5; i++) {
            int randomNumber = (int) (Math.random() * 100);
            root = tree.Retira(root, randomNumber);
        }

        System.out.println("\n\nPré-ordem após remoção de 5 elementos:");
        tree.preOrdem(root);
        System.out.println("\n\nEm ordem após remoção:");
        tree.emOrdem(root);
        System.out.println("\n\nPós-ordem após remoção:");
        tree.posOrdem(root);
        System.out.println("\n\nPor nível após remoção:");
        tree.porNivel(root);
    }
}
