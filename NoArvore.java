import java.util.LinkedList;
import java.util.Queue;

public class NoArvore {
    int info;
    NoArvore direita = null;
    NoArvore esquerda = null;

    void preOrdem(NoArvore tree) {
        if (tree != null) {
            System.out.print(tree.info + " ");
            preOrdem(tree.esquerda);
            preOrdem(tree.direita);
        }
    }

    void emOrdem(NoArvore tree) {
        if (tree != null) {
            emOrdem(tree.esquerda);
            System.out.print(tree.info + " ");
            emOrdem(tree.direita);
        }
    }

    void posOrdem(NoArvore tree) {
        if (tree != null) {
            posOrdem(tree.esquerda);
            posOrdem(tree.direita);
            System.out.print(tree.info + " ");
        }
    }

    void porNivel(NoArvore tree) {
        Queue<NoArvore> fila = new LinkedList<>();
        fila.add(tree);

        while (!fila.isEmpty()) {
            NoArvore temp = fila.poll();
            System.out.print(temp.info + " ");

            if (temp.esquerda != null) {
                fila.add(temp.esquerda);
            }

            if (temp.direita != null) {
                fila.add(temp.direita);
            }
        }
    }

    NoArvore InsereRaiz(NoArvore tree, int valor) {
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;

        return tree;
    }

    NoArvore Insere(NoArvore tree, int valor) {
        if (tree == null) {
            tree = new NoArvore();
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

    public static void main(String[] args) {
        NoArvore tree = new NoArvore();
        NoArvore root = tree.InsereRaiz(tree, 50);

        for (int i = 0; i < 99; i++) {
            int randomNumber = (int) (Math.random() * 100);
            root = tree.Insere(root, randomNumber);
        }

        System.out.println("Pré-ordem:");
        tree.preOrdem(root);
        System.out.println("\n\nEm ordem:");
        tree.emOrdem(root);
        System.out.println("\n\nPós-ordem:");
        tree.posOrdem(root);
        System.out.println("\n\nPor nível:");
        tree.porNivel(root);
    }
}
