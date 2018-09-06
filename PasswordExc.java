package Exception;
import java.util.*;
public class PasswordExc {

	public static void main(String[] args) throws Exception {
        System.out.println("Enter a password.");
        Scanner sc = new Scanner(System.in);

        String password = sc.next();
        System.out.println("Enter the age :");
        int age=sc.nextInt();
        try {
            validatePassword(password);
            validateAge(age);
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }
	static void validateAge(int age) throws PasswordException
	{
		//int count=0,r;
		
		if(age>18)
		{
			throw new PasswordException("you are not allowed to enter in this website :");
		}
	}

    static void validatePassword(String password) throws PasswordException {
        if (password.length() < 10) {
            throw new PasswordException("Password length is less than 10");
        }

        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean digitCheck = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
            {
                upperCheck = true;
            }

            if (Character.isLowerCase(c)) 
            {
                 lowerCheck = true;
            }
            if (Character.isDigit(c)) 
            {
                  digitCheck = true;  
            }
        }

        if (!upperCheck) {
            throw new PasswordException("There must be an uppercase character");
        }

        if (!lowerCheck) {
            throw new PasswordException ("There must be a lowercase character");
        }

        if (!digitCheck) {
            throw new PasswordException ("There must a be a digit");
        }

        System.out.println("Valid password.");
    }

    static class PasswordException extends Exception {

        public PasswordException() {
            super("Invalid password");
        }

        public PasswordException(String message) {
            super("Invalid password: " + message);
        }
        public PasswordException(int message) {
            super("Invalid age");
        }
    }
}