import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class AgeCalculator extends JFrame {
	private JTextField birthYear;
	private JTextField birthMonth;
	private JTextField birthDate;
	private JButton calculateBtn;

	AgeCalculator() {
		setTitle("Age Calculator");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Layout and Panels
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));

		JLabel titleLabel = new JLabel("Age Calculator");
		titleLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		northPanel.add(titleLabel);

		mainPanel.add(northPanel, BorderLayout.NORTH);

		// Input Fields
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel yearLabel = new JLabel("Year:");
		JLabel monthLabel = new JLabel("Month:");
		JLabel dateLabel = new JLabel("Date:");

		birthYear = new JTextField();
		birthMonth = new JTextField();
		birthDate = new JTextField();

		inputPanel.add(yearLabel);
		inputPanel.add(birthYear);
		inputPanel.add(monthLabel);
		inputPanel.add(birthMonth);
		inputPanel.add(dateLabel);
		inputPanel.add(birthDate);

		mainPanel.add(inputPanel, BorderLayout.CENTER);

		// Calculate Button
		JPanel buttonPanel = new JPanel();
		calculateBtn = new JButton("Calculate");
		buttonPanel.add(calculateBtn);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Add main panel to frame
		add(mainPanel);

		// Action Listener for Calculate Button
		calculateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateAge();
			}
		});
	}

	private void calculateAge() {
		try {
			// Parsing and validating the input
			int year = Integer.parseInt(birthYear.getText().trim());
			int month = Integer.parseInt(birthMonth.getText().trim());
			int day = Integer.parseInt(birthDate.getText().trim());

			// Create a LocalDate from input values
			LocalDate birthDate = LocalDate.of(year, month, day);
			LocalDate today = LocalDate.now();

			if (birthDate.isAfter(today)) {
				JOptionPane.showMessageDialog(this, "The birth date cannot be in the future.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Calculate the age
			Period age = Period.between(birthDate, today);
			int years = age.getYears();
			int months = age.getMonths();
			int days = age.getDays();

			// Display the result in a new window
			AgeDisplay ageDisplay = new AgeDisplay(years, months, days);
			ageDisplay.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for year, month, and date.",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (DateTimeException e) {
			JOptionPane.showMessageDialog(this, "Invalid date. Please enter a valid date.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			AgeCalculator ageCalculator = new AgeCalculator();
			ageCalculator.setVisible(true);
		});
	}
}
