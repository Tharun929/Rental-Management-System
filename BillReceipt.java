import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BillReceipt extends JFrame {
    
    private String rentalType;
    private String[] items;
    private int[] costs;
    private int itemCount;
    private int totalCost;
    private ArrayList<String> takeDates;
    private ArrayList<String> returnDates;
    
    public BillReceipt(String rentalType, String[] items, int[] costs, int itemCount, int totalCost, 
                       ArrayList<String> takeDates, ArrayList<String> returnDates) {
        this.rentalType = rentalType;
        this.items = items;
        this.costs = costs;
        this.itemCount = itemCount;
        this.totalCost = totalCost;
        this.takeDates = takeDates;
        this.returnDates = returnDates;
        
        setupFrame();
    }
    
    private void setupFrame() {
        setTitle("Bill Receipt - " + rentalType);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header
        JLabel headerLabel = new JLabel("═══ RENTAL RECEIPT ═══");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Rental Type
        JLabel typeLabel = new JLabel("Service: " + rentalType);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Receipt Generated Date
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        JLabel dateLabel = new JLabel("Receipt Generated: " + now.format(formatter));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1, 5, 5));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.add(typeLabel);
        headerPanel.add(dateLabel);
        
        // Items panel
        JPanel itemsPanel = new JPanel();
        itemsPanel.setBackground(Color.WHITE);
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
        itemsPanel.add(Box.createVerticalStrut(10));
        
        // Items header
        JLabel itemsHeader = new JLabel("RENTAL DETAILS");
        itemsHeader.setFont(new Font("Arial", Font.BOLD, 12));
        itemsPanel.add(itemsHeader);
        
        JSeparator sep1 = new JSeparator();
        itemsPanel.add(sep1);
        itemsPanel.add(Box.createVerticalStrut(5));
        
        // List items with dates
        if (itemCount > 0) {
            for (int i = 0; i < itemCount; i++) {
                JPanel itemRow = createDetailedItemRow(items[i], "Rs." + costs[i], 
                    takeDates != null && i < takeDates.size() ? takeDates.get(i) : "N/A",
                    returnDates != null && i < returnDates.size() ? returnDates.get(i) : "N/A");
                itemsPanel.add(itemRow);
                itemsPanel.add(Box.createVerticalStrut(8));
            }
        } else {
            JLabel noItems = new JLabel("No items rented");
            noItems.setFont(new Font("Arial", Font.ITALIC, 11));
            noItems.setForeground(Color.GRAY);
            itemsPanel.add(noItems);
        }
        
        itemsPanel.add(Box.createVerticalStrut(10));
        
        // Total panel
        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(new Color(240, 240, 240));
        totalPanel.setLayout(new BorderLayout());
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JLabel totalLabel = new JLabel("TOTAL: Rs." + totalCost);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setForeground(new Color(0, 102, 0));
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        totalPanel.add(totalLabel, BorderLayout.CENTER);
        
        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setLayout(new GridLayout(2, 1, 5, 5));
        JLabel thankYou = new JLabel("Thank You for Renting!");
        thankYou.setFont(new Font("Arial", Font.BOLD, 12));
        thankYou.setHorizontalAlignment(JLabel.CENTER);
        JLabel footer = new JLabel("Please return items on time");
        footer.setFont(new Font("Arial", Font.PLAIN, 10));
        footer.setHorizontalAlignment(JLabel.CENTER);
        footerPanel.add(thankYou);
        footerPanel.add(footer);
        
        // Button
        JButton closeButton = new JButton("Close Receipt");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 12));
        closeButton.addActionListener(e -> dispose());
        
        // Assemble main panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(headerPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(itemsPanel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(totalPanel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(footerPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(closeButton);
        
        panel.add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
    
    private JPanel createDetailedItemRow(String itemName, String price, String takeDate, String returnDate) {
        JPanel mainRow = new JPanel();
        mainRow.setBackground(Color.WHITE);
        mainRow.setLayout(new BoxLayout(mainRow, BoxLayout.Y_AXIS));
        
        // Item name and price
        JPanel row1 = new JPanel();
        row1.setBackground(Color.WHITE);
        row1.setLayout(new BorderLayout());
        
        JLabel nameLabel = new JLabel("• " + itemName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        row1.add(nameLabel, BorderLayout.WEST);
        row1.add(priceLabel, BorderLayout.EAST);
        
        // Dates
        JPanel row2 = new JPanel();
        row2.setBackground(Color.WHITE);
        row2.setLayout(new BorderLayout());
        
        JLabel takeLabel = new JLabel("  Taken: " + takeDate);
        takeLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        takeLabel.setForeground(new Color(50, 50, 50));
        
        JLabel returnLabel = new JLabel("Return: " + returnDate);
        returnLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        returnLabel.setForeground(new Color(50, 50, 50));
        
        row2.add(takeLabel, BorderLayout.WEST);
        row2.add(returnLabel, BorderLayout.EAST);
        
        mainRow.add(row1);
        mainRow.add(Box.createVerticalStrut(3));
        mainRow.add(row2);
        
        return mainRow;
    }
    
    public static void showBill(String rentalType, String[] items, int[] costs, int itemCount, int totalCost,
                               ArrayList<String> takeDates, ArrayList<String> returnDates) {
        SwingUtilities.invokeLater(() -> new BillReceipt(rentalType, items, costs, itemCount, totalCost, takeDates, returnDates));
    }
}
