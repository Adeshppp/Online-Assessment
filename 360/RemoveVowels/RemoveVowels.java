public class RemoveVowels {
    public static void main(String[] args) {
//        String str = "christmasiscoming";
        String str = "aeiouadeshAEIOU";

        System.out.println(str.replaceAll("[aeiouAEIOU]", ""));
    }


}
