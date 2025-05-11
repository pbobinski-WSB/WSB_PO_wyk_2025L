package org.swing.examples;

import javax.swing.*;
import java.awt.*;

public class SwingExample extends JFrame {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> itemList = new JList<>(listModel);
    private JTextField inputField = new JTextField(20);

    public SwingExample() {
        setTitle("Swing GUI Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        JPanel listPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Element:"));
        topPanel.add(inputField);

        JButton addButton = new JButton("Dodaj");
        JButton removeButton = new JButton("Usuń");
        JButton editButton = new JButton("Edytuj");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        listPanel.add(topPanel, BorderLayout.NORTH);
        listPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        listPanel.add(buttonPanel, BorderLayout.SOUTH);

        tabs.add("Lista", listPanel);
        tabs.add("Info", new JLabel("Zakładka informacyjna", SwingConstants.CENTER));

        add(tabs);

        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                inputField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int index = itemList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });

        editButton.addActionListener(e -> {
            int index = itemList.getSelectedIndex();
            if (index != -1) {
                String newText = inputField.getText().trim();
                if (!newText.isEmpty()) {
                    listModel.set(index, newText);
                    inputField.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingExample().setVisible(true));
    }
}
