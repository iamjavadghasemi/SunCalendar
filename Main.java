import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        while(true) {
            try {
                System.out.println("Choose from 1359 to 1437>>>");
                int year = scanInt();
                System.out.println("Choose from 1 to 12>>>");
                int month = scanInt();
                if((1359 <= year && year <= 1437) && (1 <= month && month <= 12)) {
                    printMonth(year, month);
                    break;
                } else {
                    throw new Exception("Input is invalid.");
                }
            } catch(Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
    public static int scanInt() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                return in.nextInt();
            } catch(InputMismatchException exception) {
                System.out.println("Input is invalid.");
                in.next();
            }
        }
    }
    public static void printMonth(int year, int month) {
        printTitleOfMonth(year, month);
        printBodyOfMonth(year, month);
    }
    public static void printTitleOfMonth(int year, int month) {
        System.out.println(getNameOfMonth(month) + ", " + year + ":");
        System.out.println("--------------------------------------------------");
        System.out.println("Sat     Sun     Mon     Tue     Wed     Thu     Fri");
    }
    public static String getNameOfMonth(int month) {
        switch(month) {
            case 1: {
                return "Farvardin";
            }
            case 2: {
                return "Ordibehesht";
            }
            case 3: {
                return "Khordad";
            }
            case 4: {
                return "Tir";
            }
            case 5: {
                return "Mordad";
            }
            case 6: {
                return "Shahrivar";
            }
            case 7: {
                return "Mehr";
            }
            case 8: {
                return "Aban";
            }
            case 9: {
                return "Azar";
            }
            case 10: {
                return "Dey";
            }
            case 11: {
                return "Bahman";
            }
            case 12: {
                return "Esfand";
            }
            default: {
                return null;
            }
        }
    }
    public static void printBodyOfMonth(int year, int month) {
        for(int i = 0; i < getDaysOfWeek(year, month); i++) {
            System.out.print("        ");
        }
        for(int i = 1; i <= getDaysOfMonth(year, month); i++) {
            if(i < 10) {
                System.out.print(" " + i + "      ");
            } else {
                System.out.print(i + "      ");
            }
            if((getDaysOfWeek(year, month)+i)%7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------");
    }
    public static int getDaysOfWeek(int year, int month) {
        int firstDay = 6;
        return (firstDay+getTotalDays(year, month))%7;
    }
    public static int getTotalDays(int year, int month) {
        int counter = 0;
        for(int i = 1359; i < year; i++) {
            if(isLeapYear(i)) {
                counter+=366;
            } else {
                counter+=365;
            }
        }
        for(int i = 1; i < month; i++) {
            counter+=getDaysOfMonth(year, i);
        }
        return counter;
    }
    public static int getDaysOfMonth(int year, int month) {
        if(1 <= month && month <= 6) {
            return 31;
        } else if(7 <= month && month <= 11) {
            return 30;
        } else if(month == 12) {
            if(isLeapYear(year)) {
                return 30;
            } else {
                return 29;
            }
        }
        return 0;
    }
    public static boolean isLeapYear(int year) {
        if(year == 1375 || year == 1404 || year == 1437) {
            return true;
        } else if(year < 1374) {
            return (year-1358)%4 == 0;
        } else if (year < 1403) {
            return (year-1379)%4 == 0;
        } else {
            return (year-1408)%4 == 0;
        }
    }
}