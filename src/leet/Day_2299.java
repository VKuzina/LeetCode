package leet;

public class Day_2299 {
	public boolean strongPasswordCheckerII(String password) {
        char[] chars = password.toCharArray();
        boolean[] flags = new boolean[4];
        String special = "!@#$%^&*()-+";
        
        if (chars.length < 8) return false;

        for (int i = 0; i < chars.length; i++) {
        	if (i != 0 && chars[i] == chars[i-1]) return false;
        	
        	if (Character.isDigit(chars[i])) flags[0] = true;
        	else if (special.indexOf(chars[i]) != -1) flags[1] = true;
        	else if (Character.isLowerCase(chars[i])) flags[2] = true;
        	else if (Character.isUpperCase(chars[i])) flags[3] = true;        	
        }
        
        return flags[0] && flags[1] && flags[2] && flags[3];
    }
}
