
package arbolBinario3;

import static java.lang.Math.abs;

public class ArbolBinario<T extends Comparable<T>> {
    private NodoAB<Integer> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public NodoAB<Integer> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAB<Integer> raiz) {
        this.raiz = raiz;
    }
   
    public static ArbolBinario<Integer> generarArbolPrueba(){
       //No olvidar que los valores contenidos en el Nodo deben estar en el rango [0,10^4]
        ArbolBinario<Integer> arbol=new ArbolBinario<>();
        
        NodoAB<Integer> nodoA=new NodoAB<>(3);
        NodoAB<Integer> nodoB=new NodoAB<>(5);
        NodoAB<Integer> nodoC=new NodoAB<>(2);
        NodoAB<Integer> nodoD=new NodoAB<>(1);
        NodoAB<Integer> nodoE=new NodoAB<>(4);
        NodoAB<Integer> nodoF=new NodoAB<>(6);
        //NodoAB<Integer> nodoG=new NodoAB<>(2);
        //NodoAB<Integer> nodoH=new NodoAB<>(8);
        //NodoAB<Integer> nodoJ=new NodoAB<>(9);
        arbol.setRaiz(nodoA);
        nodoA.setIzq(nodoB);
        nodoA.setDer(nodoC);
        nodoB.setIzq(nodoD);
        nodoB.setDer(nodoE);
        nodoC.setIzq(nodoF);
        //nodoC.setDer(nodoG);
        //nodoG.setIzq(nodoH);
        //nodoH.setIzq(nodoJ);
        return arbol;
    }
    
    public void print(){
        ArbolPrinter.printNode(this.raiz);
    }
    public int contarNodos(){
        return contarNodos(raiz);
    }
    private int contarNodos(NodoAB<Integer> n){
        if (n==null){return 0;}
        return contarNodos(n.getIzq())+contarNodos(n.getDer())+1;
    }
    
    private int altura(NodoAB<Integer> n){
        if (n==null)return 0;
        if(n.getIzq()==null && n.getDer()==null){return 1;}
        return  Math.max(altura(n.getIzq()), altura(n.getDer()))+1;
    
    }
    public int altura(){
        return altura(raiz);
    }
    
//**********************************************************************************************    
    private boolean esArbolLleno(NodoAB<Integer> n){
        
        if(n==null)return true;
        
        if((n.getIzq()==null && n.getDer()!=null) || (n.getIzq()!=null && n.getDer()==null)){
                return false;
        }
        if(altura(n.getIzq())!=altura(n.getDer())){
            return false;
        }
        return esArbolLleno(n.getDer()) && esArbolLleno(n.getIzq());
    }
    public boolean esArbolLeno(){
       return  esArbolLleno(raiz);
       
    }
    
//**********************************Es Binario*********************************************************

    public boolean esArbolBinario(){
        return esArbolBinario(raiz);
    }
    private boolean esArbolBinario(NodoAB<Integer> raiz){
        if(raiz==null){return true;}
        if(raiz.getIzq()==null && raiz.getDer()!=null){
            if(raiz.getDer().getContenido()< raiz.getContenido()){ return false;}
        }else if(raiz.getIzq()!=null && raiz.getDer()==null){
            if(raiz.getIzq().getContenido()>raiz.getContenido()){ return false;}
        }else if(raiz.getIzq()!=null && raiz.getDer()!=null){
           if(raiz.getIzq().getContenido()>=raiz.getContenido() || raiz.getDer().getContenido()<= raiz.getContenido()){ 
               return false;
           }
        }else{
            return true;
        }
        return esArbolBinario(raiz.getIzq()) && esArbolBinario(raiz.getDer());
          
    }

}
    

