package com.ram.sod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class SODUtil {

	public static String readInputStream(HttpServletRequest httpRequest) throws IOException{

		InputStream is = httpRequest.getInputStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte buf[] = new byte[32];
		for(int r = 0; r >= 0;)
		{
			r = is.read(buf);
			if(r >= 0)
				os.write(buf, 0, r);
		}

		String s = new String(os.toByteArray(), "UTF-8");
		String decoded = URLDecoder.decode(s, "UTF-8");
		return decoded;

	}
}
