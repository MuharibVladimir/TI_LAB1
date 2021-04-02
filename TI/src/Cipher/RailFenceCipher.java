package Cipher;

public class RailFenceCipher {
    private String OrigText;
    private String CipherText;
    private int Key;
    private char [][] Matrix;

    public void setOrigText (String sOriginalText){
        OrigText = sOriginalText;
    }

    public void setCipherText (String sCipherText){
        CipherText = sCipherText;
    }

    public void reset(){
        setOrigText("");
        setCipherText("");
        setKey(0);
    }

    public void show (){
        System.out.println("Исходный текст: " + OrigText + "; Шифротекст: " + CipherText + "; Ключ: " + Key );
    }

    public void setKey(int k){
        Key = k;
    }

    private void MakeMatrix (){
        int index = 0;
        Matrix = new char[Key][OrigText.length()];
        for (int j = 0; j < OrigText.length();j++){
            for (int i = 0; (i < Key) && (index < OrigText.length()); i++){
                Matrix[i][j] = OrigText.charAt(index);
                index++;
                j++;
            }
            for (int i = Key-2; (i > 0) && (index < OrigText.length()); i--){
                Matrix[i][j] = OrigText.charAt(index);
                index++;
                j++;
            }
            j--;
        }

    }

    private void MakeCipherText () {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Key; i++){
            for (int j = 0; j < OrigText.length(); j++){
                if (Matrix[i][j] != 0){
                    s.append(Matrix[i][j]);
                }
            }
        }
        CipherText = s.toString();
    }

    private void MatrixUncoding (){
        boolean [][] MatrBol = new boolean [Key][CipherText.length()];
        Matrix = new char[Key][CipherText.length()];
        int index=0;
        for (int j = 0; j < CipherText.length();j++){
            for (int i = 0; (i < Key) && (index < CipherText.length()); i++){
                MatrBol[i][j] = true;
                index++;
                j++;
            }
            for (int i = Key-2; (i > 0) && (index < CipherText.length()); i--){
                MatrBol[i][j] = true;
                index++;
                j++;
            }
            j--;
        }
        index = 0;
        for (int i = 0; i < Key; i++){
            for (int j = 0; j < CipherText.length(); j++){
                if (MatrBol[i][j]){
                    Matrix[i][j] = CipherText.charAt(index);
                    index++;
                }
            }
        }

    }

    private void MakeOriginalText (){
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < CipherText.length(); j++){
            for (int i = 0; i < Key; i++){
                if (Matrix[i][j] != 0){
                    s.append(Matrix[i][j]);
                }
            }
        }
        OrigText = s.toString();
    }

    public void coding (){
        MakeMatrix();
        MakeCipherText();

    }

    public void uncoding (){
        MatrixUncoding();
        MakeOriginalText();
    }
}
