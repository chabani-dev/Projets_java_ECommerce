package fr.doranco.crypto.algo;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public final  class AlgorithmeCryptage {
	
	  private AlgorithmeCryptage() {
		}
	
	
 public static final byte[] encrypt(String messageToEncrypt, Key key, String algorithm) throws Exception {

			switch (algorithm) {
			case "DES":
			case "AES":
			case "BLOWFISH":
				Cipher cipher = Cipher.getInstance(algorithm);
				cipher.init(Cipher.ENCRYPT_MODE, key);
				return cipher.doFinal(messageToEncrypt.getBytes("UTF-8"));

			case "PBEWithMD5AndDES":
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");

			default:
				throw new NoSuchAlgorithmException(
						"L'algorithme '" + algorithm + "' n'est pas pris en charge ou ce n'est pas un algorithme !");
			}
		}

public static final String decrypt(byte[] messageToDecrypt, Key key, String algorithm) throws Exception {

			switch (algorithm) {
				case "DES":
				case "AES":
				case "BLOWFISH":
					Cipher cipher = Cipher.getInstance(algorithm);
					cipher.init(Cipher.DECRYPT_MODE, key);
					byte[] messageInBytes = cipher.doFinal(messageToDecrypt);
					return new String(messageInBytes);
		
				case "PBEWithMD5AndDES":
					throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
		
				default:
					throw new NoSuchAlgorithmException(
							"L'algorithme '" + algorithm + "' n'est pas pris en charge ou ce n'est pas un algorithme !");
			}
		}
}