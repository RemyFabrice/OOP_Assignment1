// Names: Remy Fabrice Niyonsaba
// STUDENT ID: 23408
//https://github.com/RemyFabrice/OOP_Assignment1.git

import java.io.*;
import java.sql.*;

public class ExceptionHandling {

    public static void main(String[] args) {

        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        // simulateClassNotFoundException();
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }
    public static void simulateIOException() {
        try {
            FileReader file = new FileReader("file1.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: File not found or cannot be read.");
        }
    }

    public static void simulateFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missingfile.txt");
            System.out.println("File opened successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: The specified file was not found.");
        } catch (IOException e) {
            System.out.println("IOException: General I/O error occurred.");
        }
    }


    public static void simulateEOFException() {
        try {
            FileInputStream file = new FileInputStream("sample.txt");
            DataInputStream dataInput = new DataInputStream(file);

            while (true) {
                System.out.println(dataInput.readUTF());
            }
        } catch (EOFException e) {
            System.out.println("EOFException: End of file reached unexpectedly.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }


    public static void simulateSQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://invalid-url/db", "remy", "123");
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("SQLException: Unable to connect to the database.");
        }
    }


    public static void simulateClassNotFoundException() {
        try {

            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: Class not found at runtime.");
        }
    }


    public static void simulateArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero is not allowed.");
        }
    }

    public static void simulateNullPointerException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Attempted to access a null reference.");
        }
    }

    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Index out of bounds.");
        }
    }

    public static void simulateClassCastException() {
        try {
            Object obj = "This is a string";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: Invalid type casting.");
        }
    }

    public static void simulateIllegalArgumentException() {
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        System.out.println("Age set to: " + age);
    }

    public static void simulateNumberFormatException() {
        try {
            String str = "abc";
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Cannot convert string to a number.");
        }
    }
}



