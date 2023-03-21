package org.example;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    HashMap<Integer, Double> terms = new HashMap<>();

    public Polinom(String string) {

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(string);
        Integer x = 0;
        while (matcher.find()) {
            x = x + 1;
            String stringulet = new String(matcher.group(1));

            int value = get_power(stringulet);

            if (x.equals(1)) {
                terms.put(value, get_coef(stringulet));
                if (stringulet.charAt(stringulet.length() - 1) == 'x') {

                    terms.remove(value);
                    terms.put(1, get_coef(stringulet));

                } else terms.put(value, get_coef(stringulet));
            } else {

                terms.put(value, get_coef(stringulet));

                if (stringulet.charAt(stringulet.length() - 1) == 'x') {

                    terms.remove(value);
                    terms.put(1, get_coef(stringulet));

                } else terms.put(value, get_coef(stringulet));

            }
        }

        System.out.println(terms);
    }

    public static Double get_coef(String s) {
        String u = "";
        Double i = null;
        Integer sign = 1;
        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        }
        for (int j = 0; j < s.length(); j++) {
            if (Character.isDigit(s.charAt(j))) {
                u = u + s.charAt(j);
            } else if (s.charAt(j) == 'x') break;
        }
        if (u.equals("") || u.equals("-")) u = u + "1";
        i = Double.parseDouble(u);
        i *= sign;
        return i;
    }

    public static Integer get_power(String s) {
        Integer i = null;
        int index = s.lastIndexOf("^");
        if (index >= 0) {
            String pwr = s.substring(index + 1);
            try {
                i = Integer.parseInt(pwr);
            } catch (NumberFormatException e) {}
        } else {
            if (s.equals("x")) i = 1;
            else i = 0;
        }
        return i;
    }

    public boolean containsKey(Integer key) {

        return terms.containsKey(key);
    }

    public Double get(Integer key) {
        return terms.get(key);
    }

    public void remove(Integer key) {
        terms.remove(key);
    }

    public Set<Integer> keySet() {
        return terms.keySet();
    }

    public void put(Integer key, Double i) {
        terms.put(key, i);
    }

    ///////////////////////////////////////COPY PASTE
    public String toString() {
        boolean firstTerm = true;
        StringBuilder sb = new StringBuilder();
        for (int power : this.terms.keySet()) {
            double coeff = this.terms.get(power);
            if (coeff == 0) {
                continue; // skip zero coefficient terms
            }
            if (firstTerm) {
                firstTerm = false;
            } else {
                sb.append(coeff > 0 ? " + " : " - ");
            }
            if (Math.abs(coeff) != 1 || power == 0) {
                sb.append(String.format("%.2f", Math.abs(coeff)));
            }
            if (power > 0) {
                sb.append("x");
                if (power > 1) {
                    sb.append("^" + power);
                }
            }
        }
        return sb.toString();

    }
}
