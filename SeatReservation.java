package DB_1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SeatReservation {
    JFrame jframe;
    JPanel panel;
    JButton[][] seats;
    JButton reserveButton;
    JButton exitButton;
    JButton closeButton;
    JLabel selectedSeatLabel;
    String selectedSeat;
    String userId;
    Controller controller;

    public SeatReservation(String userId) {
        this.userId = userId;
        this.controller = new Controller();
        createReservationUI();
        loadReservedSeats();
        loadUserSeat();
    }

    public void createReservationUI() {

        jframe = new JFrame("자리예매");
        panel = new JPanel(new GridLayout(5, 5, 10, 10)); // 5x5 seat grid
        seats = new JButton[5][5];
        selectedSeatLabel = new JLabel("선택한 좌석: ");
        reserveButton = new JButton("예약");
        exitButton = new JButton("퇴실");
        closeButton = new JButton("종료");

        // Initialize seat buttons
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                String seatNumber = (char) ('A' + row) + String.valueOf(col + 1);
                seats[row][col] = new JButton(seatNumber);
                seats[row][col].addActionListener(this::seatButtonAction);
                panel.add(seats[row][col]);
            }
        }

        reserveButton.addActionListener(this::reserveButtonAction);
        exitButton.addActionListener(this::exitButtonAction);
        closeButton.addActionListener(this::closeButtonAction);

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(selectedSeatLabel);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.add(reserveButton);
        southPanel.add(exitButton);
        southPanel.add(closeButton);

        jframe.setLayout(new BorderLayout());
        jframe.add(panel, BorderLayout.CENTER);
        jframe.add(northPanel, BorderLayout.NORTH);
        jframe.add(southPanel, BorderLayout.SOUTH);

        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public void seatButtonAction(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        selectedSeat = clickedButton.getText();
        selectedSeatLabel.setText("선택한 좌석: " + selectedSeat);
    }

    public void reserveButtonAction(ActionEvent e) {
        if (selectedSeat == null) {
            JOptionPane.showMessageDialog(jframe, "좌석을 선택해주세요.");
        } else {
            boolean reservationSuccess = controller.reserveSeat(selectedSeat, userId);
            if (reservationSuccess) {
                JOptionPane.showMessageDialog(jframe, "좌석 " + selectedSeat + " 예약이 되었습니다.");
                JButton reservedButton = getButtonBySeatNumber(selectedSeat);
                jframe.setVisible(false);
                new view();
                if (reservedButton != null) {
                    reservedButton.setBackground(Color.RED);
                    reservedButton.setEnabled(false);
                }
                selectedSeatLabel.setText("예약한 좌석: " + selectedSeat);
            } else {
                JOptionPane.showMessageDialog(jframe, "이미 좌석을 예약하셨습니다.");
            }
        }
    }

    public void exitButtonAction(ActionEvent e) {
        String userSeat = controller.getUserSeat(userId);
        if (userSeat != null) {
            controller.exitSeat(userId);
            JOptionPane.showMessageDialog(jframe, "좌석 " + userSeat + " 예약이 취소되었습니다.");
            JButton reservedButton = getButtonBySeatNumber(userSeat);
            if (reservedButton != null) {
                reservedButton.setBackground(null);
                reservedButton.setEnabled(true);
            }
            jframe.setVisible(false);
            new view();
        } else {
            JOptionPane.showMessageDialog(jframe, "예약된 좌석이 없습니다.");
        }
    }

    public void closeButtonAction(ActionEvent e) {
        jframe.dispose(); // 프로그램 종료
        System.exit(0);
    }

    private void loadReservedSeats() {
        ArrayList<String> reservedSeats = controller.getReservedSeats();
        for (String seat : reservedSeats) {
            JButton reservedButton = getButtonBySeatNumber(seat);
            if (reservedButton != null) {
                reservedButton.setBackground(Color.RED);
                reservedButton.setEnabled(false);
            }
        }
    }

    private void loadUserSeat() {
        String userSeat = controller.getUserSeat(userId);
        if (userSeat != null) {
            selectedSeatLabel.setText("예약한 좌석: " + userSeat);
            JButton reservedButton = getButtonBySeatNumber(userSeat);
            if (reservedButton != null) {
                reservedButton.setBackground(Color.BLUE);
                reservedButton.setEnabled(false);
            }
        }
    }

    private JButton getButtonBySeatNumber(String seatNumber) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (seats[row][col].getText().equals(seatNumber)) {
                    return seats[row][col];
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SeatReservation("user123"));
    }
}