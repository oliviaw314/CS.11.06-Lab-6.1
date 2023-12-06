import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");

        System.out.println(challengeOneAnswer);
        System.out.println(challengeTwoAnswer);
        System.out.println(challengeThreeAnswer);
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer, challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        int[] array = new int[linesInFile];

        File file = new File(fileName);
        Scanner myscanner = new Scanner(file);

        int index = 0;
        while (myscanner.hasNextLine()) {
            array[index++]=myscanner.nextInt();
        }
        int count = 0;
        for (int i=0; i<array.length-1; i++) {
            if (array[i]<array[i+1]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        int[] array = new int[linesInFile];

        File file = new File(fileName);
        Scanner myscanner = new Scanner(file);

        int index = 0;
        while (myscanner.hasNextLine()) {
            array[index++]=myscanner.nextInt();
        }
        int count = 0;

        for (int i=0; i<array.length-3; i++) {
            if (array[i]+array[i+1]+array[i+2]<array[i+1]+array[i+2]+array[i+3]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        String[] array = new String[linesInFile];

        File file = new File(fileName);
        Scanner myscanner = new Scanner(file);

        int index = 0;
        while (myscanner.hasNextLine()) {
            array[index++]=myscanner.nextLine();
        }
        int forward = 0;
        int downOrUp = 0;
        for (String command : array) {
            if (command.contains("forward")) {
                char number = command.charAt(command.length()-1);
                forward+= Character.getNumericValue(number);
            }
            else if (command.contains("down")) {
                char number = command.charAt(command.length()-1);
                downOrUp+= Character.getNumericValue(number);
            }
            else if (command.contains("up")) {
                char number = command.charAt(command.length()-1);
                downOrUp-= Character.getNumericValue(number);
            }
        }

        return forward*downOrUp;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int linesInFile = countLinesInFile(filename);
        String[] array = new String[linesInFile];

        File file = new File(filename);
        Scanner myscanner = new Scanner(file);

        int index = 0;
        while (myscanner.hasNextLine()) {
            array[index++]=myscanner.nextLine();
        }

        int aim = 0;
        int horizontal = 0;
        int depth = 0;
        for (String command : array) {
            if (command.contains("forward")) {
                char number =  command.charAt(command.length()-1);
                horizontal+= Character.getNumericValue(number);
                depth+=(aim* Character.getNumericValue(number));
            }
            else if (command.contains("down")) {
                char number =  command.charAt(command.length()-1);
                aim+= Character.getNumericValue(number);
            }
            else if (command.contains("up")) {
                char number =  command.charAt(command.length()-1);
                aim-= Character.getNumericValue(number);
            }
        }

        return horizontal*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}