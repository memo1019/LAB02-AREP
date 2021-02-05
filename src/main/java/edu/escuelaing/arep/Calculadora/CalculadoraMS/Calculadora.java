package edu.escuelaing.arep.Calculadora.CalculadoraMS;
import edu.escuelaing.arep.Calculadora.Linkedist.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Calculadora {
    /**
     * es el contructor de la clase Calculadora, aqui se hace el proceso para ingresar
     * el archivo y encontrar la media y la desviacion estandar
     * @param args
     * */
    public static void main( String[] args ) throws IOException {

        BufferedReader Br = new BufferedReader(new FileReader("/src/site/Resources/Prueba2.txt"));
        BufferedReader Br1 = new BufferedReader(new FileReader("/src/site/Resources/Prueba1.txt"));

        String lista;
        String lista1;

        Linkedist<Double> listaEn = new Linkedist();

        Linkedist<Double> listaEn1 = new Linkedist();

        while((lista = Br.readLine()) != null){
            listaEn.addNode(Double.parseDouble(lista));
        }
        while((lista1 = Br1.readLine()) != null){
            listaEn1.addNode(Double.parseDouble(lista1));
        }
        System.out.println("Primera lista ingresada");
        System.out.printf(Locale.US,"%.2f\n",Media(listaEn1));
        System.out.printf(Locale.US,"%.2f\n",Desviacion_estandar(listaEn1));
        System.out.println("Segunda lista ingresada");
        System.out.printf("%.2f\n",Media(listaEn));
        System.out.printf(Locale.US,"%.2f\n",Desviacion_estandar(listaEn));
    }
    /**
     *se encarga de encontrar la Media de una LinkedList
     * @param listaing
     * @return double
     * */
    public static double Media(Linkedist<Double> listaing) {
        Node<Double> pos = listaing.getFirst();
        double media = 0;
        while (pos != null) {
            media+= pos.getTypeE();
            pos = pos.getNextNode();
        }

        return media/listaing.getSize();
    }


    /**
     * se encarga de encontrar la desviacion estandar de una LinkedList
     * @param lista
     * @return double
     * */
    public static double Desviacion_estandar(Linkedist<Double> lista) {
        double media =  Media(lista);
        Node<Double> pos = lista.getFirst();
        double DesviacionEst = 0;
        while (pos != null) {
            DesviacionEst+= Math.pow(pos.getTypeE() - media,2);
            pos = pos.getNextNode();
        }
        return Math.sqrt(DesviacionEst/(lista.getSize()-1));
    }
}
