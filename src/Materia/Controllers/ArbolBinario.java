package Materia.Controllers;

import Materia.Models.Node;

public class ArbolBinario {
    private Node root;
    private int peso = 0;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        peso++;
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimir() {
        imprimir(root);
    }

    public void imprimir(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }
    }

    public boolean buscar(int value) {
    boolean encontrado = buscarRec(root, value);
    if (encontrado) {
        System.out.println("Valor " + value + " encontrado en el árbol.");
    } else {
        System.out.println("Valor " + value + " no encontrado en el árbol.");
    }
    return encontrado;
}


    private boolean buscarRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }


     public int getPeso() {
        return peso;
 
    }

public void inorderConAltura() {
    System.out.println();
    System.out.print("Inorden con alturas: ");
    inorderConAltura(root);
    System.out.println(); 
}

private void inorderConAltura(Node node) {
    if (node != null) {
        inorderConAltura(node.getLeft());
        int altura = getHeightRec(node);
        System.out.print(node.getValue() + "(h=" + altura + ") ");
        inorderConAltura(node.getRight());
    }
}

public void printinorder() {
    System.out.print(" Arbol Inorder : ");
    printinorder(root);
    System.out.println(); 
}

private void printinorder(Node node) {
    if (node != null) {
        printinorder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printinorder(node.getRight());
    }
}

public void inorderConFactorEquilibrio() {
    System.out.print("Arbol InOrder con Factor de equilibrio: ");
    inorderConFactorEquilibrio(root);
    System.out.println(); 
}

private void inorderConFactorEquilibrio(Node node) {
    if (node != null) {
        inorderConFactorEquilibrio(node.getLeft());
        int alturaIzq = getHeightRec(node.getLeft());
        int alturaDer = getHeightRec(node.getRight());
        int bf = alturaIzq - alturaDer;
        System.out.print(node.getValue() + "(bf=" + bf + ") ");
        inorderConFactorEquilibrio(node.getRight());
        
    }
}

public boolean estaEquilibrado() {
    return estaEquilibrado(root);
}

private boolean estaEquilibrado(Node node) {
    if (node == null) {
        return true;
    }

    int alturaIzq = getHeightRec(node.getLeft());
    int alturaDer = getHeightRec(node.getRight());
    int fe = alturaIzq - alturaDer;

    if (Math.abs(fe) > 1) {
        return false;
    }

    return estaEquilibrado(node.getLeft()) && estaEquilibrado(node.getRight());
}


public void mostrarNodosDesequilibrados() {
    System.out.print("Nodos desequilibrados: ");
    mostrarNodosDesequilibrados(root);
    System.out.println();
}

private void mostrarNodosDesequilibrados(Node node) {
    if (node != null) {
        mostrarNodosDesequilibrados(node.getLeft());

        int alturaIzq = getHeightRec(node.getLeft());
        int alturaDer = getHeightRec(node.getRight());
        int fe = alturaIzq - alturaDer;

        if (Math.abs(fe) > 1) {
            System.out.print(node.getValue() + "(fE = " + fe + ") ");
        }

        mostrarNodosDesequilibrados(node.getRight());
    }
}

}

