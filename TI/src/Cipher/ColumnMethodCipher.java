package Cipher;

import java.util.Locale;

public class ColumnMethodCipher {
    private String OrigText;
    private String CipherText;
    private String Key;
    private char [][] N;
    private int [] ArrForRead;

    public void setOrigText (String sOriginalText){
        OrigText = sOriginalText;
    }

    public void setCipherText (String sCipherText){
        CipherText = sCipherText;
    }



    public void show (){
        System.out.println("Исходный текст: " + OrigText + "; Шифротекст: " + CipherText + "; Ключ: " + Key );
    }

    public void reset(){
        setOrigText("");
        setCipherText("");
        setKey("");
    }

    public void setKey(String k){
        Key = k.toUpperCase(Locale.ROOT);
    }

    private void MakeArrForRead (){
        int CodSymbol = 0;
        int CodeOfLastLetter = 0;
        ArrForRead = new int[Key.length()];

        if ( (Key.charAt(0) >= 65) && (Key.charAt(0) <= 90) ){
            CodSymbol = 65;
            CodeOfLastLetter = 90;
        }
        if ( (Key.charAt(0) >= 1040) && (Key.charAt(0) <= 1071) ){
            CodSymbol = 1040;
            CodeOfLastLetter = 1071;
        }

        int index=1;

        while (CodSymbol <= CodeOfLastLetter){
            for (int i=0; i<Key.length(); i++){
                if ( Key.charAt(i) == CodSymbol){
                    ArrForRead[i] = index;
                    index++;
                }
            }
            CodSymbol++;
        }
    }

    private void MakeMatrix (){
        N = new char [OrigText.length()/Key.length()+1][Key.length()];
        int index = 0;
        for (int i = 0; i<OrigText.length()/Key.length()+1; i++){
            for (int j = 0; (j < Key.length())  && (index < OrigText.length()); j++){
                N[i][j] = OrigText.charAt(index);
                index++;
            }
        }
    }

    private void MakeChipherText (){
        StringBuilder s = new StringBuilder();
        for (int column = 1; column <= Key.length(); column++){
            for (int j = 0; j < Key.length(); j++){
                if (ArrForRead[j] == column){
                    for (int i =0; i < OrigText.length()/Key.length()+1; i++){
                        if (N[i][j] != 0){
                            s.append(N[i][j]);
                        }
                    }
                }
            }
        }
        CipherText = s.toString();
    }

    private void MatrixUncoding (){
        boolean [][] MatrixBol = new boolean [CipherText.length()/Key.length()+1][Key.length()];
        N = new char [CipherText.length()/Key.length()+1][Key.length()];
        int index = 0;
        for (int i = 0; i<CipherText.length()/Key.length()+1; i++){
            for (int j = 0; (j < Key.length())  && (index < CipherText.length()); j++){
                MatrixBol[i][j] = true;
                index++;
            }
        }
        index = 0;

        for (int column = 1; column <= Key.length(); column++){
            for (int j = 0; j < Key.length(); j++){
                if (ArrForRead[j] == column){
                    for (int i =0; i < CipherText.length()/Key.length()+1; i++){
                        if (MatrixBol[i][j]){
                           N[i][j] = CipherText.charAt(index);
                           index++;
                        }
                    }
                }
            }
        }

    }

    private void MakeOriginalText() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i<CipherText.length()/Key.length()+1; i++){
            for (int j = 0; j < Key.length(); j++){
                if (N[i][j] != 0){
                    s.append(N[i][j]);
                }
            }
        }
        OrigText = s.toString();
    }

    public void coding (){
        MakeArrForRead();
        MakeMatrix();
        MakeChipherText();
    }

    public void uncoding (){
        MakeArrForRead();
        MatrixUncoding();
        MakeOriginalText();
    }

}
