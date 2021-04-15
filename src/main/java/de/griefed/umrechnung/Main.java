package de.griefed.umrechnung;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result;
        Integer choice;
        Double size;

        do {
            String menu =
                    "1 - Eingabe in Bit\n" +
                            "2 - Eingabe in Byte\n" +
                            "3 - Eingabe in Kibibyte\n" +
                            "4 - Eingabe in Mebibyte\n" +
                            "5 - Eingabe in Gibibyte\n" +
                            "6 - Eingabe in Tebibyte\n" +
                            "0 - Beenden\n" +
                            "Bitte waehlen: ";

            System.out.print(menu);
            choice = getChoice();

            size = getSize(choice);

            switch (choice) {
                case 1:
                    result = convertBit(size);

                    break;
                case 2:
                    result = convertByte(size);

                    break;
                case 3:
                    result = convertKibibyte(size);

                    break;
                case 4:
                    result = convertMebibyte(size);

                    break;
                case 5:
                    result = convertGibibyte(size);

                    break;
                case 6:
                    result = convertTebibyte(size);

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

            System.out.println(result);
            System.out.println("Moechten Sie eine weitere Berechnung durchfuehren? \"N\" eingeben, um zu beenden.");
            System.out.print("Antwort: ");
        } while(!input.nextLine().matches("[Nn]"));
    }

    /**
     * Prueft den UserInput ob es eine gültige Zahl ist. Wenn die Zahl gleich 0 ist, wird das Programm beendet, ansonsten wird geprueft ob die Zahl kleiner als 7 ist.
     * Wenn die Zahl ungleich 0 und kleiner als 7 ist, wird von der Methode true zurückgegeben.
     * @return true oder false jeh nachdem welche Checks bestanden werden.
     */
    private static Integer getChoice() {
        boolean isNumber = false;
        Integer result = null;
        Scanner input = new Scanner(System.in);
        String userInput;

        do {

            userInput = input.nextLine();

            if (userInput.matches("[0-9]*")) {

                if (Integer.parseInt(userInput) == 0) {

                    System.out.println("Programm wird beendet...");
                    System.exit(0);

                } else if (Integer.parseInt(userInput) < 7 && Integer.parseInt(userInput) >= 0) {

                    isNumber = true;
                    result = Integer.parseInt(userInput);

                } else {
                    System.out.println("Die Zahl muss kleiner als 7 und nicht negativ sein.");
                }

            } else {
                System.out.print("Sie muessen eine Zahl eingeben!\nBitte waehlen: ");
            }
        } while(!isNumber);

        return result;
    }

    /**
     * Fordert den Benutzer auf die größe der zuvor gewählten Einheit zu bestimmen. Der Benutzer wird solange zur Eingabe aufgefordert, solange die Eingabe keiner Zahl entspricht.
     * Ist die Eingabe eine Zahl, wird sie in ein Double konvertiert und an main zurückgegeben.
     * @param userChoice Die zuvor ausgewählte Einhein.
     * @return Das vom Benutzer eingegebene Double, mit welchem dann die Umrechnung ausgeführt wird.
     */
    private static Double getSize(Integer userChoice) {
        boolean isNumber = false;
        Double result = null;
        Scanner input = new Scanner(System.in);
        String userInput;

        List<String> type = Arrays.asList(
                "Bit",
                "Byte",
                "Kibibyte",
                "Mebibyte",
                "Gibibyte",
                "Tebibyte"
        );

        do {

            System.out.print(String.format(
                    "Bitte Anzahl %s eingeben: ",
                    type.get(userChoice - 1)));

            userInput = input.nextLine();

            if (userInput.matches("[0-9]*")) {
                if (Integer.parseInt(userInput) > 0) {

                    result = Double.parseDouble(userInput);
                    isNumber = true;

                } else {
                    System.out.println("Sie muessen eine Zahl eingeben, die groesser als 0 ist!");
                }
            }
        } while (!isNumber);

        return result;
    }

    private static String convertBit(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size,
                size / 8,
                size / 8 / 1024,
                size / 8 / 1024 / 1024,
                size / 8 / 1024 / 1024 / 1024,
                size / 8 / 1024 / 1024 / 1024 / 1024
        );
    }
    private static String convertByte(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size * 8,
                size,
                size / 1024,
                size / 1024 / 1024,
                size / 1024 / 1024 / 1024,
                size / 1024 / 1024 / 1024 / 1024
        );
    }
    private static String convertKibibyte(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size * 1024 * 8,
                size * 1024,
                size,
                size / 1024,
                size / 1024 / 1024,
                size / 1024 / 1024 / 1024
        );
    }
    private static String convertMebibyte(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size * 1024 * 1024 * 8,
                size * 1024 * 1024,
                size * 1024,
                size,
                size / 1024,
                size / 1024 / 1024
        );
    }
    private static String convertGibibyte(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size * 1024 * 1024 * 1024 * 8,
                size * 1024 * 1024 * 1024,
                size * 1024 * 1024,
                size * 1024,
                size,
                size / 1024
        );
    }
    private static String convertTebibyte(Double size) {

        return String.format(
                "Bit:       %f\n" +
                        "Byte:      %f\n" +
                        "Kibibyte:  %f\n" +
                        "Mebibyte:  %f\n" +
                        "Gibibyte:  %f\n" +
                        "Tebibyte:  %f\n",
                size * 1024 * 1024 * 1024 * 1024 * 8,
                size * 1024 * 1024 * 1024 * 1024,
                size * 1024 * 1024 * 1024,
                size * 1024 * 1024,
                size * 1024,
                size
        );
    }
}
