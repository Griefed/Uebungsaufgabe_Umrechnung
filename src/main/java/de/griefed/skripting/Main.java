package de.griefed.skripting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice, size, result;

        String menu =
                "1 - Eingabe in Bit\n" +
                "2 - Eingabe in Byte\n" +
                "3 - Eingabe in Kibibyte\n" +
                "4 - Eingabe in Mebibyte\n" +
                "5 - Eingabe in Gibibyte\n" +
                "6 - Eingabe in Tebibyte\n" +
                "0 - Beenden\n" +
                "Bitte waehlen: ";

        List<String> type = Arrays.asList(
                "Bit",
                "Byte",
                "Kibibyte",
                "Mebibyte",
                "Gibibyte",
                "Tebibyte"
        );

        System.out.print(menu);

        do {
            do {
                choice = input.nextLine();

                if (!choice.matches("[0-9]*")) {

                    System.out.println("Sie muessen eine Zahl eingeben!");
                    System.out.print("Bitte waehlen: ");
                }
            } while (!choice.matches("[0-9]*"));


            if (Integer.parseInt(choice) == 0) {

                System.out.println("Programm wird beendet...");
                System.exit(0);
            }

            do {
                System.out.print(String.format(
                        "Bitte Anzahl %s eingeben: ",
                        type.get(Integer.parseInt(choice) - 1)));

                size = input.nextLine();

                if (!size.matches("[0-9]*")) {

                    System.out.println("Sie muessen eine Zahl eingeben!");
                    System.out.print("Bitte waehlen: ");
                }

                if (!choice.matches("[0-9]*")) {
                    System.out.println("Sie muessen eine Zahl eingeben!");
                }
            } while (!choice.matches("[0-9]*"));


            double sizeDouble = Integer.parseInt(size);


            switch (Integer.parseInt(choice)) {
                case 1:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble,
                            sizeDouble / 8,
                            sizeDouble / 8 / 1024,
                            sizeDouble / 8 / 1024 / 1024,
                            sizeDouble / 8 / 1024 / 1024 / 1024,
                            sizeDouble / 8 / 1024 / 1024 / 1024 / 1024
                    );

                    System.out.println(result);
                    break;
                case 2:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble * 8,
                            sizeDouble,
                            sizeDouble / 1024,
                            sizeDouble / 1024 / 1024,
                            sizeDouble / 1024 / 1024 / 1024,
                            sizeDouble / 1024 / 1024 / 1024 / 1024
                    );

                    System.out.println(result);
                    break;
                case 3:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble * 1024 * 8,
                            sizeDouble * 1024,
                            sizeDouble,
                            sizeDouble / 1024,
                            sizeDouble / 1024 / 1024,
                            sizeDouble / 1024 / 1024 / 1024
                    );

                    System.out.println(result);
                    break;
                case 4:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble * 1024 * 1024 * 8,
                            sizeDouble * 1024 * 1024,
                            sizeDouble * 1024,
                            sizeDouble,
                            sizeDouble / 1024,
                            sizeDouble / 1024 / 1024
                    );

                    System.out.println(result);
                    break;
                case 5:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble * 1024 * 1024 * 1024 * 8,
                            sizeDouble * 1024 * 1024 * 1024,
                            sizeDouble * 1024 * 1024,
                            sizeDouble * 1024,
                            sizeDouble,
                            sizeDouble / 1024
                    );

                    System.out.println(result);
                    break;
                case 6:

                    result = String.format(
                            "Bit:       %f\n" +
                                    "Byte:      %f\n" +
                                    "Kibibyte:  %f\n" +
                                    "Mebibyte:  %f\n" +
                                    "Gibibyte:  %f\n" +
                                    "Tebibyte:  %f\n",
                            sizeDouble * 1024 * 1024 * 1024 * 1024 * 8,
                            sizeDouble * 1024 * 1024 * 1024 * 1024,
                            sizeDouble * 1024 * 1024 * 1024,
                            sizeDouble * 1024 * 1024,
                            sizeDouble * 1024,
                            sizeDouble
                    );

                    System.out.println(result);
                    break;
            }
            System.out.println("Moechten Sie eine weitere Berechnung durchfuehren? \"N\" eingeben, um zu beenden.");
            System.out.print("Antwort: ");
            choice = input.nextLine();
        } while(!choice.matches("[Nn]"));
    }
}
