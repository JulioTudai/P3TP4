package ProgramacionIII.TP5;


import java.util.ArrayList;
import java.util.Collections;


/*
en esta conversacion necesito que actues como un profesor de programacion 3 y que me ayudes a revisar este ejercicio
necesito que me digas si tiene errores, y que mejoras podria implementar.

comienzo Enunciado.
final 29/2/2024 ejercicio 5
Dado un numero entero positivo N y un valor objetivo V se deas encontrar todas las
posibles combinaciones de numeros entre 1 y N cuya suma de como resultado V. Los mumeros
Pueden aparecer mas de una vez dentro de una combinacion, pero no no deben apaercer combinaciones
repetidas en diferente orden.
Fin enunciado.
Esto es lo que plantie yo hasta ahora  y el posible codigo que da las soluciones correctas:
primero inicializar el arreglo de numeros a utilizar hasta llegar a N
si es solucion, preguntar si es solucion valida
es solucion : cuando la suma de los valores da v
Solucion es valida : si esa solucion ya no pertenece a ningun conjunto de solucion anterior
poda: si la suma de valores actual ya es mayor que v que no siga iterando por esa rama,
poda 2
Asumimos N= 6
OBJETIVO V = 4
 */
//comienzo de codigo:
public class FinalEjercicio5 {

    public ArrayList<ArrayList<Integer>> secIgualesAV(int N,int objetivo){

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultados = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numeros.add(i+1);
        }

        backTraking(0,0,objetivo,numeros,camino,resultados);

        return resultados;
    }

    private void backTraking(Integer j,Integer suma,Integer objetivo, ArrayList<Integer> numeros, ArrayList<Integer> camino, ArrayList<ArrayList<Integer>> resultados){


        if (esSolucion(suma,objetivo)){
            if (solucionValida(camino, resultados)) {
                resultados.add(new ArrayList<>(camino));
            }

        }
        else{
            for (int i = j; i < numeros.size(); i++) {

                 Integer valorActual = numeros.get(i);
                 suma +=valorActual;

                if(!poda(suma,objetivo)){

                    camino.add(valorActual);
                    backTraking(i,suma,objetivo,numeros,camino,resultados);
                    camino.remove(camino.size()-1);
                    suma -= valorActual;
                }

            }
        }
    }

    private boolean esSolucion(Integer suma, Integer objetivo){

        if(suma.equals(objetivo)){

            return true;
        }
        return false;
    }

    private boolean solucionValida(ArrayList<Integer> camino, ArrayList<ArrayList<Integer>> resultados){
        ArrayList<Integer> copia = new ArrayList<>(camino);
        Collections.sort(copia);

        for (ArrayList<Integer> res : resultados){
            ArrayList<Integer> copiaRes = new ArrayList<>(res);
            Collections.sort(copiaRes);
            if (copia.equals(copiaRes)) return false;
        }
        return true;
    }

    private boolean poda(Integer suma, Integer objetivo){

    return suma >objetivo;
    }

















}
