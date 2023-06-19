import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dictionary extends JFrame implements ActionListener {
    private DictionaryData dictionaryData;
    private JLabel label;
    private JTextField textField;
    private JTextArea textArea;
    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;

    public Dictionary() {
        dictionaryData = new DictionaryData();

        setTitle("English-Vietnamese, Vietnamese-English Dictionary");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Enter a word:");
        textField = new JTextField(20);
        textArea = new JTextArea(20, 20);
        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(searchButton);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);

        searchButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);

        add(panel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String word = textField.getText();
        String definition;
        if (e.getSource() == searchButton) {
            definition = dictionaryData.search(word);
            textArea.setText(definition);
        } else if (e.getSource() == addButton) {
            definition = JOptionPane.showInputDialog("Enter definition:");
            dictionaryData.add(word, definition);
        } else if (e.getSource() == deleteButton) {
            dictionaryData.delete(word);
        } else if (e.getSource() == editButton) {
            definition = JOptionPane.showInputDialog("Enter definition:");
            dictionaryData.edit(word, definition);
        }
    }

    public static void main(String[] args) {
        new Dictionary();
    }
}