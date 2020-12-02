package de.ituvsoft.studentenprojekte;

public class Formatter {
	public static void printf(String s, Object... Arguments) {
		System.out.println((formatter(s, Arguments)));
	}

	public static void printef(String s, Object... Arguments) {
		System.err.println(formatter(s, Arguments));
	}

	public static String formatter(String s, Object... Arguments) {
		StringBuffer sb = new StringBuffer(s);
		int i = 0;

		int posBS = 0;
		while (s.contains("%") && sb.lastIndexOf("%") != posBS - 1 && Arguments.length > i) {
			if (sb.indexOf("%")!=0 && sb.charAt(sb.indexOf("%", posBS) - 1) == '\\') {
				posBS = sb.indexOf("%") + 1;

			}

			else if (sb.charAt(sb.indexOf("%", posBS) + 1) == 'D') {
				sb.replace(sb.indexOf("%"), sb.indexOf("%") + 2, DateConvert.dateConvert(Arguments[i].toString()));

			}

			else if (sb.charAt(sb.indexOf("%", posBS) + 1) == 'f') {
				int nKStellen = Character.getNumericValue(sb.charAt(sb.indexOf("%") + 2));
				String dbl = Arguments[i].toString();
				double zahl = Double.parseDouble(dbl);
				sb.replace(sb.indexOf("%"), sb.indexOf("%") + 3, DecimalNumber.decimalNumber(zahl, nKStellen));

			}

			else if (sb.charAt(sb.indexOf("%", posBS) + 1) == 'n') {
				sb.replace(sb.indexOf("%"), sb.indexOf("%") + 2, WholeNumber.numberConvert(Arguments[i].toString()));

			} else if (sb.charAt(sb.indexOf("%", posBS) + 1) == 's') {
				sb.replace(sb.indexOf("%"), sb.indexOf("%") + 2, Arguments[i].toString());

			} else if (sb.charAt(sb.indexOf("%", posBS) + 1) == 'S') {
				sb.replace(sb.indexOf("%"), sb.indexOf("%") + 2, BigLetters.blMaker(Arguments[i].toString()));

			} else {
				return "Der von Ihnen angegebene Platzhalter ist fehlerhaft.";

			}
			i++;
			s = sb.toString();
		}
		while (sb.indexOf("%", posBS) != -1) {
			if (sb.charAt(sb.indexOf("%", posBS) - 1) == '\\') {
				posBS = sb.indexOf("%") + 1;
			} else {
				sb.replace(sb.indexOf("%", posBS), sb.indexOf("%", posBS) + 2, " ");

			}

		}
		s = sb.toString().replace('\\', ' ');

		while (s.contains("  ")) {
			s = s.replace("  ", " ");
		}
		s.trim();
		return s;

	}

	public static void main(String[] args) {
		printf("%f2",4.2345);
		
		
	}

}
