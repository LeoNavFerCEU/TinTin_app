package tintin;

import org.apache.commons.codec.digest.DigestUtils;

public class prueba {

	public static void main(String[] args) {
		System.out.println(DigestUtils.sha256Hex("test"));
	}

}
