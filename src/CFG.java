import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CFG {

    static List<Character> characters = List.of(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ',
            'Э', 'Ю', 'Я', ' ', ','
    );


    static final int N = characters.size();

    // Эта функция генерирует ключ в
// // циклическим образом до тех пор, пока его длина не станет
// равно длине оригинального текста
    static String generateKey(String str, String key) {
        int x = str.length();
        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    // Эта функция возвращает зашифрованный текст
// сгенерированный с помощью ключа
    static String cipherText(String str, String key) {
        String cipher_text = "";
        for (int i = 0; i < str.length(); i++) {
            // преобразование в диапазоне 0-23
            int index1 = characters.indexOf(str.charAt(i));
            int index2 = characters.indexOf(key.charAt(i));
            int x = (index1 + index2) % N;
            cipher_text += characters.get(x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text
// and returns the original text
    static String originalText(String str, String key) {
        String orig_text = "";
        for (int i = 0; i < str.length() &&
                i < key.length(); i++) {
            int index1 = characters.indexOf(str.charAt(i));
            int index2 = characters.indexOf(key.charAt(i));
            int x = (index1 -
                    index2 + N) % N;
            orig_text += characters.get(x);
        }
        return orig_text;
    }

    // This function will convert the lower case character to Upper case
    static String LowerToUpper(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }

    // Driver code
    public static void main(String[] args) {
        String Str = "Денис, привет,";
        String Keyword = "мопс";
        String str = LowerToUpper(Str);
        String keyword = LowerToUpper(Keyword);
        String key = generateKey(str, keyword);
        String cipher_text = cipherText(str, key);
        System.out.println("Ciphertext : "
                + cipher_text + " ");
        System.out.println("Original/Decrypted Text : "
                + originalText(cipher_text, key));
    }
}
