
package arbolBinario3;

public class Main {

    public static void main(String[] args) {
        
        ArbolBinario<Integer> arbol= ArbolBinario.generarArbolPrueba();
        arbol.print();
        System.out.println("\nAltura: "+arbol.altura()+
                "\n¿Es árbol binario? "+arbol.esArbolBinario()+
                "  \n¿Esta lleno? "+arbol.esArbolLeno());
        
       
    }
}
