package fr.doranco.cryptage.keys;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final  class GenerateKey {
	
	

	
	private GenerateKey() {
	}
	public final static SecretKey getKeyCryptage(String algorithm, Integer keysize) throws Exception {
			
			if (algorithm == null || algorithm.isEmpty()) {
				throw new IllegalArgumentException("Il faut préciser l'algorithme !");
			}
			if (keysize == null || keysize <= 0 || keysize%8 != 0) {
				throw new IllegalArgumentException("Le keysize est incorrect ! il doit être > 0 et multiple de 8.");
			}
			SecretKey key = null;
			KeyGenerator keyGen = null;

			switch (algorithm) {
				case "DES":
					if (keysize != 56) {
						throw new IllegalArgumentException("Wrong keysize: must be equal to 56");
					}
					break;
				case "AES":
					List<Integer> listeKeySize = Arrays.asList(128, 192, 256);
					if (!listeKeySize.contains(keysize)) {
						throw new IllegalArgumentException("Wrong keysize: must be equal to 128, 192 or 256");
					}
					break;
				default:
					throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
			}
			keyGen = KeyGenerator.getInstance(algorithm);
			keyGen.init(keysize);
			key = keyGen.generateKey();
			return key;
		}
		
	}
		


