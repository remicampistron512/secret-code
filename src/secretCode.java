import java.util.Scanner;
import java.util.ArrayList;

public class secretCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String secretCode = "1246";
		Scanner scan = new Scanner(System.in);
		boolean play = true;
		
		while(play) {
			System.out.println("Rentrez un code de 4 chiffres et devinez le code secret : ");
			String proposedCode = fourDigitsInput(scan);
			
			char [] secretCodeArr = secretCode.toCharArray();
			char [] proposedCodeArr = proposedCode.toCharArray();
			
			ArrayList<Character> placedChars = new ArrayList<Character>();
			ArrayList<Character> unplacedChars = new ArrayList<Character>();
			
			placedOrUnplacedChar(secretCodeArr, proposedCodeArr, placedChars, unplacedChars);
			
			if(placedChars.size() == 4) {
				System.out.println("Bravo ! Vous avez trouvé le code : " + secretCode );
				play = false;
			} else {
				if(placedChars.size()>0) {
					System.out.println(placedChars.size() + " chiffre bien placé");
				}
				if (unplacedChars.size()>0) {
					System.out.println(unplacedChars.size() + " chiffre mal placé");
				}
			}
		}
		
		
		
		
	}
	
	private static String fourDigitsInput(Scanner scan) {
	    while (true) {
	        String proposedCode = scan.nextLine().trim();
	        if (proposedCode.length() == 4) {
	            boolean isValidInput = true;
	            for (int i = 0; i < 4; i++) {
	            	if (!Character.isDigit(proposedCode.charAt(i))) { 
	            		isValidInput = false; 
	            		break; 
	            	}
	            }
	            if (isValidInput) return proposedCode;
	        }
	        System.out.print("4 chiffres requis. Réessayez : ");
	    }
	}

	
	public static void placedOrUnplacedChar(char[] secretCodeArr, char[] proposedCodeArr,
			ArrayList<Character> placedChars, ArrayList<Character> unplacedChars) {
		for(int i=0;i<proposedCodeArr.length;i++) {
			for(int j=0;j<secretCodeArr.length;j++) {
				if(proposedCodeArr[i] == secretCodeArr[j] ) {
					
					if (i == j) {
						
						//le charactere est placé au bon endroit
						placedChars.add(proposedCodeArr[i]);
					} else {
						
						// le charactere existe dans la liste mais n'est pas bien placé
						unplacedChars.add(proposedCodeArr[i]);
					}
				}
			}
			
		}
	}

}
