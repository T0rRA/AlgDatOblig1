package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
    if (a.length==0){
        throw new NoSuchElementException("Tabellen er for kort!");
    }
    else

        for(int i=0; i<a.length-1;i++){
            if (a[i]>a[i+1]){
                int midlertidig = a[i];
                a[i] =a[i+1];
                a[i+1]=midlertidig;
            }
        }
            return a[a.length-1];
    }


    public static int ombyttinger(int[] a) {
        int antall=0;

        if (a.length==0){
            throw new NoSuchElementException("Tabellen er for kort!");
        }
        else

            for(int i=0; i<a.length-1;i++){
                if (a[i]>a[i+1]){
                    int midlertidig = a[i];
                    a[i] =a[i+1];
                    a[i+1]=midlertidig;
                    antall++;
                }
            }
        return antall;
    }



    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antallForskjelligeVerdier = 1;

            for (int i = 1; i < a.length; i++){
                //Sjekker om listen er sortert
                if(a[i-1] > a[i]) {
                    throw new IllegalStateException("Listen er ikke sortert");
                }

                if(a[i-1] != a[i]){
                    antallForskjelligeVerdier++;
                }
            }

            if(a.length <= 0){
                antallForskjelligeVerdier = 0;
            }
        return antallForskjelligeVerdier;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antallForskjelligeVerdier = a.length;
        int tellerTemp = -1;

        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                if(a[i] == a[j]){
                    tellerTemp++;
                }
            }
            antallForskjelligeVerdier = antallForskjelligeVerdier - tellerTemp;
            tellerTemp = -1;
        }
        System.out.println(antallForskjelligeVerdier);

        return antallForskjelligeVerdier;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int left = 0;
        int right = a.length-1;

        while(left < right){
            while (a[left] % 2 == 1){
                left--;
            }
            while (a[right] % 2 == 0){
                right--;
            }
            int temp = left;
            left = right;
            right = temp;
        }

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

    public static void sort(int[] a, int left, int right){

        for(int i = left; i < right; i++){
            for(int j = i; j < right; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j]  = a[j+1];
                    a[j+1] = temp;
                }
            }
            right--;
        }
    }
/*int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};*/

    public static void main(String[] args){
        int [] tall = {5, 2, 8, 4, 7, 6};
        //sort(tall, 0, tall.length-1);
        maks(tall);


        for(int nummer : tall){
            System.out.print(nummer + " ");

        }

    }

}  // Oblig1


