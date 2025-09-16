package maskingPersonalInformation;

public class MaskingPersonalInformation {
    public String maskPII(String s) {
        boolean email;
        int annotationIndex = s.indexOf('@');
        email = annotationIndex >= 0;
        if (email) {
            s = s.toLowerCase();
            char first = s.charAt(0);
            char last = s.charAt(annotationIndex - 1);
            return first + "*****" + last + s.substring(annotationIndex);
        } else {
            StringBuilder lasts = new StringBuilder();
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    c++;
                }
            }
            for (int i = s.length() - 1; i >= 0 && lasts.length() != 4; i--) {
                if (Character.isDigit(s.charAt(i))) {
                    lasts.append(s.charAt(i));
                }
            }
            lasts.reverse();
            if (c == 10) {
                return "***-***-" + lasts;
            } else if (c == 11) {
                return "+*-***-***-" + lasts;
            } else if (c == 12) {
                return "+**-***-***-" + lasts;
            } else {
                return "+***-***-***-" + lasts;
            }
        }
    }
}
