package tps.tp1.dates;

import tps.tp1.factorials.Functions;
import tps.utils.ConsoleFontFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Dates {


    // Test of CurrentTimeMillis Method
    public static void test1() {

        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("Using CurrentTimeMillis Method of the Class System to compute Execution Time ");
        long startTime = System.currentTimeMillis();
        Functions.factorialRecursive_Optimised(300);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        long startTime2 = System.currentTimeMillis();
        Functions.factorialIterative_Optimised(300);
        long endTime2 = System.currentTimeMillis();

        long executionTime2 = endTime2 - startTime2;
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                           + ConsoleFontFormat.FontFormat_BLUE);
        System.out.println("\t\t=>Execution Time of calculating 300! with recursive optimised function : " + executionTime + "ms");
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                           + ConsoleFontFormat.FontFormat_CYAN);
        System.out.println("\t\t=>Execution Time of calculating 300! with iterative optimised function : " + executionTime2 + "ms");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
    }
    // Test of Date
    public static void test2() {
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("ToDay Date using java.util Date Object");
        Date date = new Date();
        System.out.println(ConsoleFontFormat.FontFormat_BOLD
                           + ConsoleFontFormat.FontFormat_BLUE
                           + "\t\t=>ToDay is  : " + date);
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);

    }
    // Test of Calendar
    public static void test3() {

        Calendar cal = Calendar.getInstance();
        String[] mois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre", "" };
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "" };
        String[] jSem = { "", "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi" };
        String[] dWeek = { "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        String nomJour = jSem[cal.get(Calendar.DAY_OF_WEEK)];
        String nomMois = mois[cal.get(Calendar.MONTH)];
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("ToDay Date using java.util Calendar Object");
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                           + ConsoleFontFormat.FontFormat_GREEN);
        System.out.println("\t\t=>Aujourd'hui c'est le : " +
                           nomJour + " " + cal.get(Calendar.DAY_OF_MONTH) + " " + nomMois + " " + cal.get(Calendar.YEAR));


        String dayName = dWeek[cal.get(Calendar.DAY_OF_WEEK)];
        String monthName = months[cal.get(Calendar.MONTH)];
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                         + ConsoleFontFormat.FontFormat_CYAN);
        System.out.println("\t\t=>ToDay is             : " +
                           dayName + " " + cal.get(Calendar.DAY_OF_MONTH) + " " + monthName + " " + cal.get(Calendar.YEAR));

        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
    }
    // Test of Date and SimpleDateFormat
    public static void test4() {

        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("ToDay Date using java.util Date Object Formatted with SimpleDateFormat Object ");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                           + ConsoleFontFormat.FontFormat_BLUE);
        System.out.println("\t\t=>ToDay is  : " + format.format(date));
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
    }
    // Test of LocalDate
    public static void test5() {

        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("ToDay Date using java.time LocalDate Object (of java8+)");

        String[] mois   = { "", "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
        String[] jSem   = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi" };

        String[] months = { "","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        String[] dWeek  = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };


        LocalDate date  = LocalDate.now();
        String nomJour  = jSem[date.getDayOfWeek().getValue()];
        String nomMois  = mois[date.getMonthValue()];

        String day      = dWeek[date.getDayOfWeek().getValue()];
        String month    = months[date.getMonthValue()];

        int dayOfMonth = date.getDayOfMonth();

        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                         + ConsoleFontFormat.FontFormat_CYAN);
        System.out.println("\t\t=>ToDay is             : " + day + " " + dayOfMonth + " " + month + " "+ date.getYear());
        System.out.print(ConsoleFontFormat.FontFormat_BOLD
                         + ConsoleFontFormat.FontFormat_GREEN);
        System.out.println("\t\t=>Aujourd'hui c'est le : " + nomJour + " " + dayOfMonth + " " + nomMois + " "+ date.getYear());

        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
    }

}
