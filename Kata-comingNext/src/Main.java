public class Main {

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{6, 9, 15, -2, 92, 11};
        int min = ar[0];
        int max = ar[0];
        double sum = 0.0;

            for(int i = 0; i < ar.length; i++){
                if(ar[i] < min){
                    min = ar[i];
                }
                if(ar[i] > max){
                    max = ar[i];
                }
                sum += ar[i];
            }

        System.out.println("Minimum value = " + min);
        System.out.println("Maximum value = " + max);
        System.out.println("Number of elements in the sequence = " + ar.length);
        System.out.println("Average value = " + (sum / ar.length));
    }

}
