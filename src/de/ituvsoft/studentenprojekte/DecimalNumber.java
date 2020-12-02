package de.ituvsoft.studentenprojekte;

public class DecimalNumber {
	public static boolean usedDouble = false;

	public static String ttrennZeichen(String zahl) {

		StringBuffer zahlB = new StringBuffer(zahl);
		int j = 1;

		if (zahl.contains(",")) {
			for (int i = zahl.indexOf(","); i > 0; i--) {

				if (j % 3 == 1 && j != 1) {
					zahlB.insert(i, '.');
				}
				j++;
			}
			return zahlB.toString();

		} else {
			for (int i = zahl.length(); i >= 0; i--) {

				if (j % 3 == 1 && j != 1) {
					zahlB.insert(i, '.');
				}
				j++;
			}
			return zahlB.toString();
		}

	}

	public static String decimalNumber(String zahl, int nStellen) {
		String zahlS = zahl;
		StringBuffer zahlSB = new StringBuffer(zahlS);

		if (zahlS.contains("E")) {
			int expo = Integer.parseInt(zahlS.substring(zahlS.indexOf("E") + 1));
			int eStellen = zahlS.substring(2).length() - 1 - String.valueOf(expo).length();
			zahlSB.deleteCharAt(1);
			zahlSB.delete(zahlSB.indexOf("E"), zahlSB.length());
			zahlSB.insert(expo + 1, ".");

		}

		zahlS = zahlSB.toString();
		int nStellenReal = zahlS.substring(zahlS.indexOf('.') + 1).length();
		boolean usedConcat = false;
		if (zahlS.substring(0, zahlS.indexOf('.')).length() + nStellen > 16 && zahlS.length() > 16 && usedDouble) {
			throw new IllegalArgumentException(
					"Bei einer Zahl, welche auf 16 Stellen zu runden ist, solltest du die Zahl"
							+ " als String angeben. Sonst wird es ungenau.");
		}
		for (int i = 0; i <= nStellen - nStellenReal; ++i) {
			zahlS = zahlS.concat("0");
			usedConcat = true;

		}

		int lDigit = zahlS.indexOf('.') + nStellen + 1;
		StringBuffer zahlSGerundet = new StringBuffer(zahlS.substring(0, lDigit));

		int zahllD = Integer.parseInt(String.valueOf(zahlS.charAt(lDigit)));
		int zahlbLD = Integer.parseInt(String.valueOf(zahlS.charAt(lDigit - 1)));
		if (zahllD >= 5 && zahlbLD != 9) {
			zahlS = zahlSGerundet.replace(lDigit - 1, lDigit,
					String.valueOf(Integer.parseInt(String.valueOf(zahlS.charAt(lDigit - 1))) + 1)).toString();

		} else if (zahlbLD == 9) {
			zahlS = zahlSGerundet.replace(lDigit - 2, lDigit - 1,
					String.valueOf(Integer.parseInt(String.valueOf(zahlS.charAt(lDigit - 2))) + 1)).toString();
			zahlS = zahlSGerundet.replace(lDigit - 1, lDigit, String.valueOf(0)).toString();

		}
		else {
			zahlS = zahlS.substring(0, lDigit);
		}
		

		return ttrennZeichen(zahlS.replace('.', ','));
	}

	public static String decimalNumber(double zahl, int nStellen) {
		usedDouble = true;
		return decimalNumber(String.valueOf(zahl), nStellen);

	}

	public static void main(String[] args) {
		System.out.println(decimalNumber("1.25235345235E4", 2));
		// System.out.println(ttrennZeichen("43383954,35786"));
	}

}
