package generateTagForVideoCaption;

public class GenerateTagForVideoCaption {
    public String generateTag(String caption) {
        StringBuilder ans = new StringBuilder("#");
        String[] split = caption.split(" ");
        boolean ok = false;
        for (int i = 0; i < split.length && ans.length() < 100; i++) {
            if (split[i].isEmpty()) {
                continue;
            }
            if (!ok) {
                ans.append(split[i].toLowerCase());
                ok = true;
            } else {
                ans.append(Character.toUpperCase(split[i].charAt(0))).append(split[i].substring(1).toLowerCase());
            }
        }
        if (ans.length() > 100) {
            return ans.substring(0, 100);
        }
        return ans.toString();
    }
}
