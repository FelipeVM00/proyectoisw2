package isw.proyecto.modelo.bridge;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Encoder;

public class AlgoritmoDES implements IAlgoritmoEncript{

	@Override
	public String encriptarInfo(String info, String pass) throws Exception {
		DESKeySpec dks = new DESKeySpec(info.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);

        BASE64Encoder base64encoder = new BASE64Encoder();
        return base64encoder.encode(desCipher.doFinal(info.getBytes()));
	}

}
