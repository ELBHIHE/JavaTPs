package tps.tp1.arrays;

import tps.utils.ConsoleFontFormat;

import java.util.Scanner;

public class ArraysOperation {
    
    public static   int[]       createArray     (Scanner keyboardReader, String arrayName){

            System.out.println("Hello ! please enter the size of "+arrayName + " : ");
            int size = keyboardReader.nextInt();
            keyboardReader.nextLine();


        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
                System.out.print("Enter "+arrayName+"[ " + i + "] : ");
                array[i] = keyboardReader.nextInt();
            }

        return array;
    }
    public static   int[]       createArrayV2   (Scanner keyboardReader, String arrayName){



            System.out.println("=> To create "+arrayName+", please provide its values using the following  pattern :");
            System.out.print("\t\t=> enter values separated by \",\" : ");
            String input = keyboardReader.nextLine();

            String[] array = input.split(",");

            int[] result = new int[array.length];
            for (int i = 0; i < array.length; i++)
                        result[i] = Integer.parseInt(array[i]);


          return result;
    }
    public static   void        printArray      (int[] array, String arrayName){

        System.out.print(arrayName + " [ ");
        for (int i = 0; i < array.length; i++) {
            if(i<array.length-1)
                System.out.print(array[i] + " | ");
            else
                System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
    public static   void        printIndexes    (int[] array, String arrayName){

        System.out.print(arrayName + "  ");
        for (int i = 0; i < array.length; i++) {
            if(i<array.length-1)
                System.out.print(array[i] + " - ");
            else
                System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    public static   int[]       reverseArray    (int[] array) {
        
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        
        return array;
    }
    public static   int[]       concat          (int[] t1, int[] t2) {

        int[] result = new int[t1.length + t2.length];

       // System.arraycopy(t1, 0, result, 0, t1.length);
       // System.arraycopy(t2, 0, result, t1.length, t2.length);

        for (int i = 0; i < t1.length; i++) result[i] = t1[i];
        for (int i = 0; i < t2.length; i++) result[t1.length+i] = t2[i];

        return result;
    }
    public static   int         sumOfValues     (int[] t) {
        int sum = 0 ;
        for (int i = 0; i < t.length; i++) sum += t[i] ;
        return sum;
    }
    public static   int[]       sum             (int[] t1, int[] t2) {
        if (t1.length != t2.length) {
          //  throw new IllegalArgumentException("Arrays must have the same size !!!");
       return null;
        }
        int[] sum = new int[t1.length];

        for (int i = 0; i < t1.length; i++) {
            sum[i] = t1[i] + t2[i];
        }
        return sum;
    }
    public static   int         scalar          (int[] t1, int[] t2) {

        if (t1.length != t2.length)
                            throw new IllegalArgumentException("Vectors must have the same size !!!");

        int s = 0; for (int i = 0; i < t1.length; i++) s += t1[i] * t2[i];

        return s;
    }
    public static   int         count           (int[] array, int elt) {
        int compteur = 0;
        for (int valeur : array) if (valeur == elt) compteur++;
        return compteur;
    }
    public static   int[]       delete          (int[] array, int elementToDelete) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToDelete) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("L'élément " + elementToDelete + " n'a pas été trouvé dans le array.");
            return array;
        }

        // Créer un nouveau array pour stocker les éléments restants
        int[] result = new int[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                result[j] = array[i];
                j++;
            }
        }

        return result;
    }
    public static   int[]       deleteV2        (int[] array, int elementToDelete) {

        int count =  count(array, elementToDelete);
        if(count > 0){
            int[] result = new int[array.length-count];

            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if(array[i] != elementToDelete){
                    result[j] = array[i];
                    j++;
                }
            }

            return result;
        }
        else {
            return array;
        }

    }
    public static   int[]       set             (int[] array, int index, int newValue) {
        // Vérification si l'index est valide
        if (index >= 0 && index < array.length) {
            array[index] = newValue;
            return array;
        } else {
            System.out.println("Invalid Index  : " + index);
            return array; // On retourne le tableau d'origine sans modification
        }
    }

    // Methods to Test Array's Functions
    private static  int[]       createArrayOrGetExisting(Scanner keyboardReader, String arrayName,  int[] array) {
        if (array == null) {
            System.out.println(arrayName + " not found!!! Let's create one first.");
            return createArrayV2(keyboardReader, arrayName);  // Or createArrayV2(keyboardReader) based on your need
        }
        return array;
    }
    public static   void        menuApplication (Scanner keyboardReader){
        int[] array1 = null, array2 = null;

        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
            System.out.print("""
                ===================================================
                =                  Arrays Operations              =
                ===================================================
                = 1. Operations on a single array                 =
                = 2. Operations on two arrays                     =
                = 3. Exit                                         =
                ===================================================
                """);
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("=> Enter your choice : ");
            int choice = keyboardReader.nextInt();
            keyboardReader.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> {
                    // Single array operations
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                    array1 = createArrayOrGetExisting(keyboardReader, "Array1", array1);
                    System.out.print(ConsoleFontFormat.FontFormat_ITALIC+ConsoleFontFormat.FontFormat_BLUE);
                    printArray(array1, "\t\t=> Array1 : ");
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                    System.out.print("""
                                                \t\t===================================================
                                                \t\t=          Choose an operation for one array       =
                                                \t\t===================================================
                                                \t\t= 1. Print Array                                  =
                                                \t\t= 2. Reverse Array                                =
                                                \t\t= 3. Sum of Values                                =
                                                \t\t= 4. Delete Element                               =
                                                \t\t= 5. Set Element                                  =
                                                \t\t= 6. Back to Main Menu                            =
                                                \t\t===================================================
                                                """);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("\t\t=> Enter your choice : ");
                    int singleArrayChoice = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear buffer

                    switch (singleArrayChoice) {
                        case 1 -> {
                                        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                                        printArray(array1, "\t\t\t\tArray1");
                                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                                    }
                        case 2 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            printArray(array1,               "\t\t\t\tArray1         ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            array1 = reverseArray(array1); // Update the original array
                            printArray(array1, "\t\t\t\tReversed Array1");

                            System.out.println(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 3 ->   {
                                        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                                        printArray(array1,"\t\t\t\tArray1                  ");
                                        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_ITALIC +ConsoleFontFormat.FontFormat_BLUE);
                                        System.out.println(        "\t\t\t\tSum of values of Array1 : " + sumOfValues(array1));
                                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                                    }
                        case 4 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            printArray(array1,"\t\t\t\tArray1 ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                            System.out.print(          "\t\t\t\tEnter element to delete from Array 1 : ");
                            int elt = keyboardReader.nextInt();
                            array1 = deleteV2(array1, elt);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_ITALIC +ConsoleFontFormat.FontFormat_BLUE);
                            printArray(array1, "\t\t\t\tArray after deletion of the element [ "+elt + "] ");
                            System.out.println(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 5 -> {
                            var indexes = new int[array1.length];
                            for (int i = 0; i < indexes.length; i++) indexes[i] = i;
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_CYAN);
                            printIndexes(indexes, "\t\t\t\t                            ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            printArray  (array1,  "\t\t\t\tArray to Modify          : ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.print("\t\t\t\tEnter index or position to update : ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                            int index = keyboardReader.nextInt();
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                            System.out.print("\t\t\t\tEnter a new value : ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                            int newValue = keyboardReader.nextInt();
                            array1 = set(array1, index, newValue);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_ITALIC +ConsoleFontFormat.FontFormat_BLUE);
                            printArray(array1,  "\t\t\t\tArray after modification : ");
                            System.out.println(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 6 -> {
                            // Go back to main menu
                        }
                        default -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                            System.out.println("\t\t\t\tInvalid choice! Please try again.");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                    }
                }

                case 2 -> {

                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                    // Two array operations
                    array1 = createArrayOrGetExisting(keyboardReader, "Array1",  array1);
                    array2 = createArrayOrGetExisting(keyboardReader, "Array2",  array2);

                    printArray(array1, "\t\t\t\tArray1 : ");
                    printArray(array2, "\t\t\t\tArray2 : ");

                    System.out.print("""
                                                \t\t===================================================
                                                \t\t=          Choose an operation for two arrays      =
                                                \t\t===================================================
                                                \t\t= 1. Concatenate Arrays                            =
                                                \t\t= 2. Sum of Arrays                                 =
                                                \t\t= 3. Scalar Product                                =
                                                \t\t= 4. Back to Main Menu                             =
                                                \t\t===================================================
                                                """);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("\t\t=> Enter your choice : ");
                    int twoArrayChoice = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear buffer

                    switch (twoArrayChoice) {
                        case 1 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            printArray(array1,                 "\t\t\t\tArray1             : ");
                            printArray(array2,                 "\t\t\t\tArray2             : ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            printArray(concat(array1, array2), "\t\t\t\tArray1 + Array2    : ");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 2 -> {
                            int[] result = sum(array1, array2);
                            if (result != null) {
                                System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                                printArray(array1,                 "\t\t\t\tArray1                : ");
                                printArray(array2,                 "\t\t\t\tArray2                : ");
                                System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                                printArray(result,                 "\t\t\t\tSum ( Array1, Array2) : ");
                                System.out.print(ConsoleFontFormat.FontFormat_RESET);
                            }
                        }
                        case 3 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            printArray(array1,                 "\t\t\t\tArray1                : ");
                            printArray(array2,                 "\t\t\t\tArray2                : ");
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE+ConsoleFontFormat.FontFormat_ITALIC);
                            System.out.println(                         "\t\t\t\tScalar Product        :   " + scalar(array1, array2));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 4 -> {
                            // Go back to main menu
                        }
                        default -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                            System.out.println("\t\t\t\tInvalid choice! Please try again.");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                    }
                }

                case 3 -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Exiting the application...");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    return;
                }

                default -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Invalid choice! Please try again.");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                }
            }
        }
    }
    
}


