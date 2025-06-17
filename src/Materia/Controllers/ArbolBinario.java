package Materia.Controllers;

import Materia.Models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
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
}
