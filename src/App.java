import Materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("NOMBRE: MATEO MOREJON");
        ab.imprimir();
        System.out.println();
        System.out.println("Altura es = " + ab.getHeight());
        System.out.println("Peso deL Arbol = " + ab.getPeso());
        ab.printinorder();
        ab.inorderConAltura();
        ab.inorderConFactorEquilibrio();
        System.out.println();
        System.out.println("Arbol está equilibrado = " + ab.estaEquilibrado());
        System.out.println("Agregamos Valor= 15");
        System.out.println();
        ab.insert(15);
        ab.inorderConFactorEquilibrio();
        ab.mostrarNodosDesequilibrados();

    
    }

    }

