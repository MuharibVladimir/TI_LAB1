import Cipher.*;
import java.util.Scanner;

public class ti {

    static String Choice (){
        Scanner input = new Scanner(System.in);
        String methchoice;
        methchoice = input.nextLine();
        return methchoice;
    }

    static void  RailFenceMenu () {
        Scanner input = new Scanner(System.in);
        String answer = "";
            System.out.println("1. Зашифровать");
            System.out.println("2. Расшифровать");
            System.out.println("3. Выход");
            switch (answer = Choice()){
                case "1": { RailFenceCipher RailFence = new RailFenceCipher();
                    RailFence.reset();
                    System.out.print("Введите текст: ");
                    RailFence.setOrigText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    RailFence.setKey(input.nextInt());
                    RailFence.coding();
                    RailFence.show();
                    break;
                }
                case "2": { RailFenceCipher RailFence = new RailFenceCipher();
                    RailFence.reset();
                    System.out.print("Введите зашифрованный текст: ");
                    RailFence.setCipherText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    RailFence.setKey(input.nextInt());
                    RailFence.uncoding();
                    RailFence.show();
                    break;
                }
            }

    }

    static void  ColumnMethodMenu () {
        Scanner input = new Scanner(System.in);
        String Answer = "0";
        String Ask = "3";
        while (!Answer.equals(Ask)){
            System.out.println("1. Зашифровать сообщение");
            System.out.println("2. Расшифровать сообщение");
            System.out.println("3. Выход");
            switch (Answer = Choice()){
                case "1": { ColumnMethodCipher ColumnMethod = new ColumnMethodCipher();
                    ColumnMethod.reset();
                    System.out.print("Введите Исходный текст: ");
                    ColumnMethod.setOrigText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    ColumnMethod.setKey(input.nextLine());
                    ColumnMethod.coding();
                    ColumnMethod.show(); break;}
                case "2": { ColumnMethodCipher ColumnMethod = new ColumnMethodCipher();
                    ColumnMethod.reset();
                    System.out.print("Введите зашифрованный текст: ");
                    ColumnMethod.setCipherText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    ColumnMethod.setKey(input.nextLine());
                    ColumnMethod.uncoding();
                    ColumnMethod.show(); break;}
            }
        }
    }

    static void VignerMenu () {
        Scanner input = new Scanner(System.in);
        String Answer = "0";
        String Ask = "3";
        while (!Answer.equals(Ask)){
            System.out.println("1. Зашифровать сообщение");
            System.out.println("2. Расшифровать сообщение");
            System.out.println("3. Выход");
            switch (Answer = Choice()){
                case "1": { VigenerCipher Vigener = new VigenerCipher();
                    Vigener.reset();
                    System.out.print("Введите Исходный текст: ");
                    Vigener.setOriginalText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    Vigener.setKey(input.nextLine());
                    Vigener.coding();
                    Vigener.show(); break;}
                case "2": { VigenerCipher Vigener = new VigenerCipher();
                    Vigener.reset();
                    System.out.print("Введите зашифрованный текст: ");
                    Vigener.setCipherText(input.nextLine());
                    System.out.print("Введите ключ: ");
                    Vigener.setKey(input.nextLine());
                    Vigener.uncoding();
                    Vigener.show(); break;}
            }
        }
    }

    static void CardanGrilleMenu () {
        Scanner input = new Scanner(System.in);
        String Answer = "0";
        String Ask = "3";
        while (!Answer.equals(Ask)){
            System.out.println("1. Зашифровать сообщение");
            System.out.println("2. Расшифровать сообщение");
            System.out.println("3. Выход");
            switch (Answer = Choice()){
                case "1": { CardanGrilleCipher CardanGrille = new CardanGrilleCipher();
                    System.out.print("Введите Исходный текст: ");
                    CardanGrille.setOrigText(input.nextLine());
                    CardanGrille.setKey();
                    CardanGrille.coding();
                    CardanGrille.show();
                    CardanGrille.reset(); break;}
                case "2": { CardanGrilleCipher CardanGrille = new CardanGrilleCipher();
                    System.out.print("Введите зашифрованный текст: ");
                    CardanGrille.setCipherText(input.nextLine());
                    CardanGrille.setKey();
                    CardanGrille.uncoding();
                    CardanGrille.show();
                    CardanGrille.reset(); break;}
            }
        }
    }

    static void MainMenu (){
        String Answer = "0";
        String Ask = "5";
        while (!Answer.equals(Ask)){
            System.out.println("1. Метод железнодорожной изгороди");
            System.out.println("2. Столбцовый метод");
            System.out.println("3. Метод поворачивающейся решётки");
            System.out.println("4. Метод Вижинера");
            System.out.println("5. Выход");
            switch (Answer = Choice()){
                case "1":  RailFenceMenu(); break;
                case "2":  ColumnMethodMenu(); break;
                case "3":  CardanGrilleMenu (); break;
                case "4":  VignerMenu (); break;
            }
        }
    }

    public static void main (String [] args){
        MainMenu();
    }
}
