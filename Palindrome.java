import java.lang.StringBuilder;
import java.util.Scanner;

/**
 * Palindrome Detection for Exam 2 Part 2
 * 
 * A palindrome is a word or phrase that reads the same (ignoring case, punctuation, and 
 * whitespace) forward or backward. 
 * 
 * Read in a string of letters and spaces (no punctuation or numbers) using a Scanner 
 * and print out the longest substring of the input that is a palindrome.  
 * In case of ties for longest substring, print the palindrome that would come first 
 * in lexicographic order.
 * 
 * @author Ira Goldstein
 * @version Spring 2024
 */
public class Palindrome{

    /**
     * A method to detect if a string (ignoring case and spaces) is a Palindrome
     * 
     * @param str The string that we are testing
     * @return Boolean - true if the string is a palindrome, otherwise false
     */
    public static Boolean isPalindrome(String str){
        // Two string builders.  One for the test in normal (forward) order
        // and one for the reversed string.
        StringBuilder testString = new StringBuilder();
        StringBuilder revString = new StringBuilder();

        // Strip out spaces and convert to lower case
        testString.append(str.toLowerCase().replaceAll( " ", "" ) );

        // Copy the contents of the string and reverse it
        revString = new StringBuilder(testString);
        revString.reverse();

        // Compare the content of the two strings
        // contentEquals returns a boolean
        return testString.toString().contentEquals(revString);
    }  

    /**
     * main method to get text from the keyboard and to 
     * check each substring to see if it is a palindrome
     * 
     * @param args Does not use any args
     */
    public static void main(String[] args){
        // Flag if we find a palindrome
        Boolean havePalindrome = false;

        // Current string under consideration
        String candidateString;

        // Initializing to ASCII 255, which would be the "worst" string
        String bestString = String.valueOf((char) 255); 
		
	// Create input scanner and get a line of text
	Scanner scan = new Scanner(System.in);
        String inputText = scan.nextLine();
        
        // Get the length of the text
	int inputLength = inputText.length();

        // Loop as long as we do not yet have a palindrome
        // Will terminate since a palindrome can be a single character
        // Start with the longest substring and work our way down
        for (int i = inputLength; i > 0; i--) {
            for (int j = 0; (j+i)<=inputLength; j++ ){

                // Get a candidate string
                candidateString = inputText.substring(j, (i+j));

                // Check to see if it is a palindrome
                if (isPalindrome(candidateString)) {

                    // If it is a palindrome, set the flag.  OK if it is set multiple times.
                    havePalindrome = true;

                    // Compare this string to the previous best string and
                    // make it the best string if it comes earliser lexicographicly 
                    if ( candidateString.compareTo(bestString) < 0 ) {
                        bestString = candidateString;
                    }
                }
            }

            if (havePalindrome){
                // If we have a palindrome, break out of the for (i) loop
                break;
            }
        }
        // Print out our results
        System.out.println(bestString);

        // Close the input scanner
        scan.close();
    }
}
