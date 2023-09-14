package lk.live.easytather.keygen;

public class keygen{
	public static int genkey(CharSequence charSequence) {
		int i = 0;
		int length = charSequence.length();
		int i2 = 0;
		while (i2 < length) {
			if (i2 < 5 || i2 >= length - 5) {
				int codePointAt = Character.codePointAt(charSequence, i2) & 255;
				i = (i + (((((49635 * codePointAt) & 65535) >> 1) - codePointAt) & 65535)) & 65535;
			}
			i2++;
		}
		return i;
	}
	public static int refine(String str) {
		int length = str.length();
		Object obj = 1;
		int i = 0;
		while (length > 0) {
			int i2 = length - 1;
			int digit = Character.digit(str.charAt(i2), 10);
			length = i + digit;
			if (obj != null) {
				length += digit;
				if (digit > 4) {
					i = length - 9;
					obj = obj != null ? 1 : null;
					length = i2;
				}
			}
			i = length;
			if (obj != null) {
			}
			obj = obj != null ? 1 : null;
			length = i2;
		}
		length = i % 10;
		return length == 0 ? length : 10 - length;
	}
}
