import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NiwelacjaRandom {
    public ArrayList<DziennikNiwelacyjny> dziennikNiwelacyjny1;

    public NiwelacjaRandom(String fileAdres) {
        dziennikNiwelacyjny1 = new ArrayList();

        BufferedReader(fileAdres);

        CalculationRandom();
    }

    private void BufferedReader(String file) {
        File f = new File(file);
        Scanner reader = null;
        try {
            reader = new Scanner(f);

            int id = -99;
            String name = "";
            float distance = -99.0F;
            float measure1 = -99.0F;
            float height1 = -99.0F;
            float height2 = -99.0F;
            float heightAverage = -99.0F;
            boolean pass = false;
            boolean middle = false;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();


                if (line.matches("\\[\\d+]")) {
                    id = Integer.parseInt(line.replaceAll("\\[", "").replaceAll("]", ""));

                } else if (line.matches("1=.+")) {
                    name = line.replaceAll("1=", "");

                } else if (line.matches("3=.+")) {
                    distance = Float.parseFloat(line.replaceAll("3=", ""));

                } else if (line.matches("4=.+")) {
                    pass = true;
                    measure1 = Float.parseFloat(line.replaceAll("4=", ""));

                } else if (line.matches("6=.+")) {
                    middle = true;
                    measure1 = Float.parseFloat(line.replaceAll("6=", ""));


                } else if (line.matches("7=.+")) {
                    height1 = Float.parseFloat(line.replaceAll("7=", ""));

                    DziennikNiwelacyjny buff = new DziennikNiwelacyjny();
                    buff.setId(id);
                    buff.setName(name);
                    buff.setDistance(distance);
                    buff.setMeasure1(measure1);
                    buff.setheightAverage(height1);
                    buff.setPass(pass);
                    buff.setMiddle(middle);

                    dziennikNiwelacyjny1.add(buff);

                    id = -99;
                    name = "";
                    distance = -99.0F;
                    measure1 = -99.0F;
                    height1 = -99.0F;
                    height2 = -99.0F;
                    heightAverage = -99.0F;
                    pass = false;
                    middle = false;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Niewłaściwy format pliku");
            return;
        }
    }


    private void CalculationRandom() {
        Random random = new Random();
        int losowyOdczyt = 0;
        int losowyBlad = 0;
        int stanowisko = 0;

        for (DziennikNiwelacyjny dn : dziennikNiwelacyjny1) {
            if (dn.isPass()) {
                stanowisko++;
            }

            if (stanowisko % 2 != 0) {
                losowyOdczyt = random.nextInt(151);
                if (random.nextInt(2) == 1) {
                    losowyOdczyt *= -1;
                }
            }

            if (stanowisko % 2 == 0) {
                losowyBlad = random.nextInt(2);
                if (losowyBlad == 1) {
                    losowyBlad = 1;
                    if (random.nextInt(2) == 1) {
                        losowyBlad *= -1;
                    }
                } else {
                    losowyBlad = 0;
                }
            }

            dn.setMeasure2(dn.getMeasure1() + losowyOdczyt + losowyBlad);
        }


        for (DziennikNiwelacyjny dn : dziennikNiwelacyjny1) {
            System.out.println(dn);
        }
    }
}
