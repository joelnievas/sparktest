public class Operador{

    public static <T extends Comparable<T>> T
    minElement(T a[]) throws ArrayIndexOutOfBoundsException{


        if(a.length <= 0){
            throw new ArrayIndexOutOfBoundsException("array vacio");
        }
        T min = a[0];
        for (int i = 0; i< a.length; i++) {

            if (a[i] == null) continue;
            if(a[i].compareTo(min) <= 0){
                min = a[i];
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T
    maxElement(T[] a) throws ArrayIndexOutOfBoundsException{

        if(a.length <= 0){
            throw new ArrayIndexOutOfBoundsException("Array vacio");
        }
        T max = a[0];

        for(int i= 0; i< a.length;i++ ){
            if(a[i] == null) continue;
            if(a[i].compareTo(max) >= 0){
                max = a[i];
            }
        }

        return max;



    }


    public static void main(String[] args) {

    }





}
