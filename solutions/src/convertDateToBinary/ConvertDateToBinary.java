package convertDateToBinary;

public class ConvertDateToBinary {
    public String convertDateToBinary(String date) {
        String[] split = date.split("\\-");
        String ans = Integer.toBinaryString(Integer.parseInt(split[0])) + "-" + Integer.toBinaryString(Integer.parseInt(split[1])) + "-" + Integer.toBinaryString(Integer.parseInt(split[2]));
        return ans;
    }
}
