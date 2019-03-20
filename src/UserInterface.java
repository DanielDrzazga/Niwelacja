import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class UserInterface extends java.awt.Panel {
    public UserInterface() {
        JButton calculation = new JButton("Oblicz");
        calculation.setBounds(20, 80, 150, 30);


        JButton selectFile = new JButton("Wybierz plik...");
        selectFile.setBounds(210, 80, 150, 30);

        final JTextField fileadres = new JTextField();
        fileadres.setBounds(20, 30, 340, 30);
        fileadres.setEditable(false);

        JLabel autor = new JLabel("by Daniel Drzazga");
        autor.setBounds(240, 110, 130, 20);

        JLabel versia = new JLabel("  version 0.01");
        versia.setBounds(0, 0, 100, 20);

        setLayout(null);
        add(versia);
        add(fileadres);
        add(selectFile);
        add(calculation);
        add(autor);

        selectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("C-Geo Niwelacja", new String[]{"niw"});
                fc.setFileFilter(filter);
                int response = fc.showOpenDialog(fc);

                if (response == 0) {
                    fileadres.setText(fc.getSelectedFile().toString());
                } else {
                    fileadres.setText("");

                }

            }

        });

        calculation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileadres.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wybierz plik");
                }

                NiwelacjaRandom nr = new NiwelacjaRandom(fileadres.getText());

                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("C-Geo Niwelacja", new String[]{"niw"});
                fc.setFileFilter(filter);
                int response = fc.showSaveDialog(fc);
                if (response == 0) {
                    fileadres.setText(fc.getSelectedFile().toString() + ".niw");
                } else {
                    fileadres.setText("");
                }

                try {
                    FileWriter writer = new FileWriter(fileadres.getText());
                    writer.write("[Niwelacja]\nVer=2\nDrugi=0\ncb_dlug=0\novc_dlug=0\njednostki=0\n\n");


                    for (DziennikNiwelacyjny dn : nr.dziennikNiwelacyjny1) {
                        writer.write(dn.toString());
                        writer.write("\n");
                    }
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
