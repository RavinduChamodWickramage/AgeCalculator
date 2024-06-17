import javax.swing.*;
import java.awt.*;

public class AgeDisplay extends JFrame {
	private JLabel yearsText;
	private JLabel monthsText;
	private JLabel daysText;

	// Constructor with parameters for age components
	public AgeDisplay(int years, int months, int days) {
		setTitle("Age Display");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// Layout and Panels
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));

		JLabel titleLabel = new JLabel("Your Age");
		titleLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		northPanel.add(titleLabel);

		mainPanel.add(northPanel, BorderLayout.NORTH);

		// Info Panel for Age Display
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(3, 2, 10, 10));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel yearsLabel = new JLabel("Years:");
		JLabel monthsLabel = new JLabel("Months:");
		JLabel daysLabel = new JLabel("Days:");

		yearsText = new JLabel(String.valueOf(years));
		monthsText = new JLabel(String.valueOf(months));
		daysText = new JLabel(String.valueOf(days));

		infoPanel.add(yearsLabel);
		infoPanel.add(yearsText);
		infoPanel.add(monthsLabel);
		infoPanel.add(monthsText);
		infoPanel.add(daysLabel);
		infoPanel.add(daysText);

		mainPanel.add(infoPanel, BorderLayout.CENTER);

		// Add main panel to frame
		add(mainPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			AgeDisplay ageDisplay = new AgeDisplay(0, 0, 0);
			ageDisplay.setVisible(true);
		});
	}
}
