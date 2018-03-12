import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class TextEncryptor{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String origText;
	
	String fileName = JOptionPane.showInputDialog("Enter the filename (inluding extension):");
   int shiftFactor = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift factor:"));
	System.out.println("\nEncryption Result:");
        
	try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
	    while ((origText = bufferedReader.readLine()) != null) {
                System.out.println(encrypt(origText, shiftFactor));
	    }
	    bufferedReader.close();
	}
	
	/*--------\/ Add Error Prevention \/--------*/
	catch (FileNotFoundException ex) {
	    System.out.println ("Unable to find: '" + fileName + "'");
	}
	catch (IOException ex) {
	    System.out.println ("Unable to read: '" + fileName + "'");
	}
	/*--------/\ Add Error Prevention /\--------*/
   System.exit(0);
    }
    
    public static char[] encrypt(String oT, int sF) {
    char[] masterArray = new char[95];
    masterArray[0] = ' ';masterArray[1] = '!';masterArray[2] = '"';masterArray[3] = '#';masterArray[4] = '$';masterArray[5] = '%';masterArray[6] = '&';masterArray[7] = '\'';masterArray[8] = '(';masterArray[9] = ')';
    masterArray[10] = '*';masterArray[11] = '+';masterArray[12] = ',';masterArray[13] = '-';masterArray[14] = '.';masterArray[15] = '/';masterArray[16] = '0';masterArray[17] = '1';masterArray[18] = '2';
    masterArray[19] = '3';masterArray[20] = '4';masterArray[21] = '5';masterArray[22] = '6';masterArray[23] = '7';masterArray[24] = '8';masterArray[25] = '9';masterArray[26] = ':';masterArray[27] = ';';
    masterArray[28] = '<';masterArray[29] = '=';masterArray[30] = '>';masterArray[31] = '?';masterArray[32] = '@';masterArray[33] = 'A';masterArray[34] = 'B';masterArray[35] = 'C';masterArray[36] = 'D';
    masterArray[37] = 'E';masterArray[38] = 'F';masterArray[39] = 'G';masterArray[40] = 'H';masterArray[41] = 'I';masterArray[42] = 'J';masterArray[43] = 'K';masterArray[44] = 'L';masterArray[45] = 'M';
    masterArray[46] = 'N';masterArray[47] = 'O';masterArray[48] = 'P';masterArray[49] = 'Q';masterArray[50] = 'R';masterArray[51] = 'S';masterArray[52] = 'T';masterArray[53] = 'U';masterArray[54] = 'V';
    masterArray[55] = 'W';masterArray[56] = 'X';masterArray[57] = 'Y';masterArray[58] = 'Z';masterArray[59] = '[';masterArray[60] = '\\';masterArray[61] = ']';masterArray[62] = '^';masterArray[63] = '_';
    masterArray[64] = '`';masterArray[65] = 'a';masterArray[66] = 'b';masterArray[67] = 'c';masterArray[68] = 'd';masterArray[69] = 'e';masterArray[70] = 'f';masterArray[71] = 'g';masterArray[72] = 'h';
    masterArray[73] = 'i';masterArray[74] = 'j';masterArray[75] = 'k';masterArray[76] = 'l';masterArray[77] = 'm';masterArray[78] = 'n';masterArray[79] = 'o';masterArray[80] = 'p';masterArray[81] = 'q';
    masterArray[82] = 'r';masterArray[83] = 's';masterArray[84] = 't';masterArray[85] = 'u';masterArray[86] = 'v';masterArray[87] = 'w';masterArray[88] = 'x';masterArray[89] = 'y';masterArray[90] = 'z';
    masterArray[91] = '{';masterArray[92] = '|';masterArray[93] = '}';masterArray[94] = '~';
	
    char[] origTextArray = oT.toCharArray();
    char[] finalTextArray = new char[origTextArray.length];
    
    for (int i = 0; i < origTextArray.length; i++) {
        for (int x = 0; x < masterArray.length; x++) {
            if (origTextArray[i] == ' ') {
                finalTextArray[i] = ' ';
            }
            else if (origTextArray[i] == masterArray[x]) {
                if (x + sF > 94) {
                    x = 0;
                    break;
	        		 }
	         	finalTextArray[i] = masterArray[x + sF];
	    		}}}
    return finalTextArray;
    }
}//end TextEncryptor class