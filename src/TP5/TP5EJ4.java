package ProgramacionIII.TP5;

import java.util.ArrayList;
import java.util.Collections;

public class TP5EJ4 {


    /*
    Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
    dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.
     */
/// solucion de este metedo: se asume que el arreglo valores no tiene elementos repetidos esto hace
/// que no tengamos que mirar los valores por indice sino por valor.
/// entonces buscamos cual es el valor de la mitad de la suma del arreglo dado valores
/// cada vez que un subconjunto de exactamente la mitad quiere decir que los valores que restan dan lo mismo
/// entonces en vez de ir y recorrer el arreglo de valores otra vez para el subconjunto b direcamente
/// formamos el arreglo b con los  valores que no tiene el arreglo a que ya es una solucion valida: esto
/// es una optimizacion grande del metodo para evitar busquedas inceserias, porque si ejecutamos otra vez
/// el metodo para el arreglo de conjuntos b, va a evaluar desde 0 el arreglo de valores y preguntando por valores
/// que ya estan en a
    public ArrayList<ArrayList<Integer>> conjuntosDeSumas(ArrayList<Integer> valores) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        Integer mitad = 0;
        for (Integer i : valores) {
            mitad += i;
        }
        buscarConjuntos(a, b, valores, resultado, mitad / 2,0);

        return resultado;
    }

    private void buscarConjuntos(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> valores, ArrayList<ArrayList<Integer>> resultado, Integer mitad,int index) {
        if (esSolucion(a, mitad)) {
            for(Integer i : valores ){
                if(!a.contains(i)){
                    b.add(i);
                }
            }
            cargarSoluciones(a,b,resultado);
            b.clear();
        }
        else {
            /// Ahora tengo que iterar sobre valores
            ///aca empiezo desde index para que cada vez que entra a un llamado recursivo
            ///empiece desde el siguiente valor del que ya agrego al arreglo a porque sino
            /// va a generar conjuntos de sumas iguales pero en distinto orden [1,2] = 3/ [2,1] = 3
            ///Esa parte de pasar el index simplifica los resultados ya no hay que ordenarlos para mirar si no son lo mismo
            ///y a su vez simplifica la poda
            for (int i = index; i< valores.size()-1;i++) {
                if (!poda(a,valores.get(i),mitad)) {
                    a.add(valores.get(i));
                    buscarConjuntos(a, b, valores, resultado, mitad,i+1);
                    a.remove(a.size() - 1);
                }
            }
        }
    }

    private boolean esSolucion(ArrayList<Integer> a,Integer mitad){
        Integer suma =0;
        if(!a.isEmpty()){
            for (Integer i :a){
                suma+=i;
            }
        }
        return suma.equals(mitad);
    }
    private void cargarSoluciones(ArrayList<Integer> a,ArrayList<Integer> b, ArrayList<ArrayList<Integer>> resultado){
        /// primero ordenar las soluciones, porque me puede dar los mismos numeros en orden diferente y las comvinaciones son muchas
        /*Collections.sort(a);
        Collections.sort(b);
        boolean esta = false;
        for (ArrayList<Integer> y:resultado){
            if(y.equals(a)){
                esta = true;
            }
        }
        if(!esta){
            resultado.add(new ArrayList<>(a));
            resultado.add(new ArrayList<>(b));
        }

         */
        resultado.add(new ArrayList<>(a));
        resultado.add(new ArrayList<>(b));

        /*
        Collections.sort(a);
        Collections.sort(b);

        boolean repetido = false;
        for (int i = 0; i < resultado.size(); i += 2) {
            ArrayList<Integer> yaA = resultado.get(i);
            ArrayList<Integer> yaB = resultado.get(i + 1);

            // comparo (A == yaA && B == yaB) o (A == yaB && B == yaA)
            if ((yaA.equals(a) && yaB.equals(b)) || (yaA.equals(b) && yaB.equals(a))) {
                repetido = true;
                break;
            }
        }

        if (!repetido) {
            resultado.add(new ArrayList<>(a));
            resultado.add(new ArrayList<>(b));
        }

         */

    }
    private boolean poda(ArrayList<Integer> a, Integer i,Integer mitad){

        Integer suma=0;
       if(!a.contains(i)) {
           for (Integer v : a) {
               suma += v;
           }
           if (suma + i > mitad) {
               return true;
           }

       }
        return false;
    }
}
