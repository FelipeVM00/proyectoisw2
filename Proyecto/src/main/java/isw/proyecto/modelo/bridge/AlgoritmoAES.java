package isw.proyecto.modelo.bridge;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

public class AlgoritmoAES implements IAlgoritmoEncript{

	@Override
	public String encriptarInfo(String info, String pass) throws Exception {
		Key key = new SecretKeySpec(pass.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(info.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
	}
}
