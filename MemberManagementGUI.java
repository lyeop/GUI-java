package DB_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MemberManagementGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private Controller controller;

    public MemberManagementGUI() {
        this.controller = new Controller();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("회원 관리");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());


        tableModel = new DefaultTableModel(new String[]{"ID", "Password", "Date", "Name", "Tel"}, 0);
        table = new JTable(tableModel);
        table.setCellSelectionEnabled(true); // Enable cell selection for editing
        JScrollPane scrollPane = new JScrollPane(table);

        loadMemberData();

        JButton deleteButton = new JButton("삭제");
        JButton adminPage =new JButton("관리자 GUI");
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedMember();
            }
        });

        JButton updateButton = new JButton("수정");
        updateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMemberInfo();
            }
        });
        adminPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new view(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(adminPage);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void loadMemberData() {
        ArrayList<Data> members = controller.getAllMembers();
        tableModel.setRowCount(0); // Clear existing rows
        for (Data member : members) {
            tableModel.addRow(new Object[]{member.id, member.password, member.date, member.name, member.tel});
        }
    }

    private void deleteSelectedMember() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(frame, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.deleteMember(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(frame, "회원 정보가 삭제되었습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "삭제할 회원을 선택하세요.");
        }
    }

    private void updateMemberInfo() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            String password = (String) tableModel.getValueAt(selectedRow, 1);
            String name = (String) tableModel.getValueAt(selectedRow, 3);
            String tel = (String) tableModel.getValueAt(selectedRow, 4);

            // Prompt user to confirm and update the information
            String newPassword = JOptionPane.showInputDialog(frame, "새로운 패스워드를 입력하세요:", password);
            String newName = JOptionPane.showInputDialog(frame, "새로운 이름을 입력하세요:", name);
            String newTel = JOptionPane.showInputDialog(frame, "새로운 전화번호를 입력하세요:", tel);

            if (newPassword != null && newName != null && newTel != null) {
                // Update the information in the database
                controller.updateMember(id, newPassword, newName, newTel);
                // Update the table row with new data
                tableModel.setValueAt(newPassword, selectedRow, 1);
                tableModel.setValueAt(newName, selectedRow, 3);
                tableModel.setValueAt(newTel, selectedRow, 4);
                JOptionPane.showMessageDialog(frame, "회원 정보가 수정되었습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "수정할 회원을 선택하세요.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MemberManagementGUI::new);
    }
}