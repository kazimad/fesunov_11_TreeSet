/**
 * Created by KaZimad on 05.03.14.
 */
// PhoneNotes.java: Записная книжка

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.*;
public class PhoneNotes extends JFrame {

    JTextField fldFio = new JTextField(25);
    JTextField fldPhone = new JTextField(25);
    JTextField fldCnt = new JTextField(4);
    int count =0;


    TreeSet<Person> SetOfPerson = new TreeSet<Person>();
    public PhoneNotes() {
        super("Записная книжка");
        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 250);
        Container c = getContentPane();
// Центральная панель
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        centerPanel.setBorder(BorderFactory.createEtchedBorder());
        JLabel aLabel = new JLabel("Фамилия ");
        centerPanel.add(aLabel);
        centerPanel.add(fldFio);
        aLabel = new JLabel("Телефон ");
        centerPanel.add(aLabel);
        centerPanel.add(fldPhone);
        JButton btn = new JButton("Печатать");
        centerPanel.add(btn);
        c.add(centerPanel, BorderLayout.CENTER);
// Нижняя панель
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        aLabel = new JLabel("Количество записей ");
        statusPanel.add(aLabel);
        fldCnt.setEnabled(false);
        statusPanel.add(fldCnt);
        c.add(statusPanel, BorderLayout.SOUTH);

// Listener'ы полей и кнопок
        fldPhone.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Person person = new Person(fldFio.getText().toString(), fldPhone.getText().toString());
                SetOfPerson.add(person);

            }
        });
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Iterator iter = SetOfPerson.iterator();
                for (int i =0; iter.hasNext();i++){
                    System.out.println(iter.next().toString());
                }
                System.out.println(SetOfPerson.toString());
                count++;
                fldCnt.setText(String.valueOf(count));
                fldFio.setText("");
                fldPhone.setText("");
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PhoneNotes();
    }
}


