package Exercises.exceptions;
import java.io.*;

public class IOExceptionsExercises {
    /**
     * public static String readLineCompleteDelegation(String filename) throws IOException {
     *         try{
     *             FileReader fr=new FileReader(filename);
     *             BufferedReader br=new BufferedReader(fr);
     *             return br.readLine();
     *         }catch(IOException IOEx){}
     *     }
     *     the difference between the upper version and the lower one can be found in the declaration
     *     of the 2 forms of try statement in a version where we need the finally or catch keyword to
     *     operate correctly with the statement, otherwise we can apply the try-with-resources form
     *     which is try(){} in this form and doesn't require any other statement due to the compiler
     *     which automatically check the closing of the resources, letting the exceptions be sent
     */
    public static String readLineCompleteDelegation(String filename) throws IOException {
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            return br.readLine();
        }
    }

    /**
     * this is the version we talked before
     * @param filename - a string containing the name of a file
     * @return a read line
     */
    public static String readLineNoDelegation(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * here we check only a part of the exceptions, those unchecked one
     * @param filename- a string containing the name of a file
     * @return a read line
     */
    public static String readLinePartialDelegation(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}