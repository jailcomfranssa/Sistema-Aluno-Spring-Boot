package br.edu.ifpb.pweb2.sistema.aluno.util;

import org.mindrot.jbcrypt.BCrypt;
public class PasswordUtil {
	
	public static String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public static boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
	
	//Exemplo de uso
	public static void main(String[] args) {
		System.out.println(PasswordUtil.hashPassword("Nabucodonosor"));
		System.out.println(PasswordUtil.checkPass("Nabucodonosor", "$2a$10$ERNm3h05JniqNPZhVZjQoeNvEimJffDJFHs1OVW2XqCUfzHRUxFM2"));
	}

}
