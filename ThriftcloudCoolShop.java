import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Item {
    String title, description;
    BigDecimal price;
    String category;
    String imagePath;
    boolean available = true;

    public Item(String title, String desc, BigDecimal price, String category, String imagePath) {
        this.title = title;
        this.description = desc;
        this.price = price;
        this.category = category;
        this.imagePath = imagePath;
    }
}

public class ThriftcloudCoolShop extends JFrame {
    private final List<Item> items = new ArrayList<>();
    private final List<Item> cart = new ArrayList<>();
    private final DefaultListModel<String> cartModel = new DefaultListModel<>();
    private JList<String> cartList;
    private JPanel itemsPanel;
    private JPanel featuredPanel;
    private JTextField searchField;
    private Timer carouselTimer;
    private int carouselIndex = 0;
    private static final String PESO_SYMBOL = "₱";

    public ThriftcloudCoolShop() {
        setTitle("Thriftcloud Shop - Vintage & Streetwear (PHP)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        seedItems();

        add(createTopPanel(), BorderLayout.NORTH);
        add(createMainPanel(), BorderLayout.CENTER);
        add(createCartPanel(), BorderLayout.EAST);

        startCarousel();
        setVisible(true);
    }

    private void seedItems() {
        // Items are unchanged, including image paths
        items.add(new Item("Nirvana 'Nevermind' Tee", "Vintage look, faded black band tee with 'Nevermind' angel graphic. Oversized fit.", new BigDecimal("1800.00"), "Shirts", "imagesnirvana_tee.jpg"));
        items.add(new Item("BAPE Camo Logo Tee", "Classic white A Bathing Ape shirt with camouflage eyes graphic.", new BigDecimal("2500.00"), "Shirts", "imagesbape_tee.jpg"));
        items.add(new Item("Coogi Style Sweater", "Multi-textured, colorful knit sweater with abstract vertical patterns. Heavyweight and vintage.", new BigDecimal("3200.00"), "Shirt", "imagescoogi_sweater.jpg"));
        items.add(new Item("Chicks Dig Pale Guys Tee", "Dark grey t-shirt with white text print[cite: 6].", new BigDecimal("650.00"), "Shirts", "imagespale_guys_tee.jpg"));

        items.add(new Item("Carhartt Workwear Jacket", "Vintage dark gray utility jacket with a corduroy collar. Durable and lined for cold weather.", new BigDecimal("3500.00"), "Jackets", "imagescarhartt_jacket.jpg"));
        items.add(new Item("Polo Ralph Lauren Track Jacket", "Black full-zip jacket with Japanese flag patch  and Polo Pony logo. Size L.", new BigDecimal("2800.00"), "Jackets", "imagespolo_japan_jacket.jpg"));

        items.add(new Item("Wide-Leg Denim Jeans", "Dark wash, relaxed fit, baggy style jeans (like from page 5).", new BigDecimal("1100.00"), "Pants", "C:\\Users\\Administrator\\Downloads\\imageswide_denim.png.jpg"));
        items.add(new Item("Brown Wide Trousers", "Pleated, high-waisted wide-leg brown trousers (like from page 5).", new BigDecimal("1000.00"), "Pants", "imagesbrown_trousers.jpg"));
        items.add(new Item("Adidas Track Skirt", "Long black midi skirt with white three-stripe detail on the side (like from page 5).", new BigDecimal("900.00"), "Pants", "imagesadidas_skirt.jpg"));

        items.add(new Item("PUMA Suede Sneakers", "Classic PUMA black suede running sneakers with white stripe[cite: 14].", new BigDecimal("2000.00"), "Shoes", "imagespuma_suede.jpg"));
        items.add(new Item("VANS Old Skool Black", "Black and white VANS Old Skool low-top sneakers[cite: 18].", new BigDecimal("1400.00"), "Shoes", "imagesvans_oldskool.jpg"));
        items.add(new Item("Onitsuka Tiger White", "White low-profile sneakers with black contrasting stripes[cite: 19].", new BigDecimal("1250.00"), "Shoes", "imagesonitsuka_tiger.jpg"));
        items.add(new Item("CONVERSE High Top Red", "Red high-top Chuck Taylor sneakers in well-worn, vintage condition.", new BigDecimal("950.00"), "Shoes", "imagesconverse_red.jpg"));

        items.add(new Item("Chrome Hearts Style Necklace", "Silver-tone chain with floral and cross links, featuring a large center cross pendant.", new BigDecimal("1500.00"), "Accessories", "imagescross_necklace.jpg"));
        items.add(new Item("NY Yankees '47 Cap", "Cream and brown two-tone baseball cap with embroidered NY logo.", new BigDecimal("850.00"), "Accessories", "imagesyankees_cap.jpg"));
        items.add(new Item("Spider-Man Headphones", "Black over-ear headphones with custom Spider-Man symbol detailing.", new BigDecimal("1800.00"), "Accessories", "imagesspiderman_headphones.jpg"));
        items.add(new Item("Silver Cyclops Sunglasses", "Futuristic, mirrored silver-frame sunglasses. Y2K/Cyberpunk style.", new BigDecimal("700.00"), "Accessories", "imagessilver_shades.jpg"));
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("🌟 Thriftcloud Vintage & Streetwear Shop 🌟", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> filterItems(searchField.getText()));
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchBtn, BorderLayout.EAST);
        panel.add(searchPanel, BorderLayout.SOUTH);

        featuredPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JScrollPane scroll = new JScrollPane(featuredPanel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(0, 200));
        panel.add(scroll, BorderLayout.CENTER);

        updateFeaturedItems();
        return panel;
    }

    private void updateFeaturedItems() {
        featuredPanel.removeAll();
        List<Item> featured = items.stream().filter(i -> i.available).collect(Collectors.toList());
        if (featured.isEmpty()) return;

        for (int i = 0; i < Math.min(5, featured.size()); i++) {
            int idx = (carouselIndex + i) % featured.size();
            featuredPanel.add(createItemCard(featured.get(idx), true));
        }
        featuredPanel.revalidate();
        featuredPanel.repaint();
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        String[] categories = {"Shirts", "Jackets", "Pants", "Shoes", "Accessories"};
        for (String cat : categories) {
            JButton btn = new JButton(cat);
            btn.addActionListener(e -> {
                highlightButton(categoryPanel, btn);
                showCategory(cat);
            });
            categoryPanel.add(btn);
        }
        mainPanel.add(categoryPanel, BorderLayout.NORTH);

        itemsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JScrollPane scroll = new JScrollPane(itemsPanel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scroll, BorderLayout.CENTER);

        return mainPanel;
    }

    private void highlightButton(JPanel panel, JButton selected) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                comp.setBackground(comp == selected ? Color.YELLOW : null);
            }
        }
    }

    private void showCategory(String category) {
        itemsPanel.removeAll();
        List<Item> catItems = items.stream().filter(i -> i.available && i.category.equals(category)).collect(Collectors.toList());
        for (Item i : catItems) itemsPanel.add(createItemCard(i, false));
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    private JPanel createItemCard(Item it, boolean large) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(large ? 180 : 150, large ? 220 : 200));
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.setBackground(Color.WHITE);

        JLabel imgLabel = new JLabel("Image Placeholder: " + it.category, SwingConstants.CENTER);
        imgLabel.setPreferredSize(new Dimension(large ? 170 : 140, large ? 120 : 100));
        imgLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        try {
            ImageIcon icon = new ImageIcon(it.imagePath);
            Image img = icon.getImage().getScaledInstance(large ? 170 : 140, large ? 120 : 100, Image.SCALE_SMOOTH);
            imgLabel.setIcon(new ImageIcon(img));
            imgLabel.setText("");
            imgLabel.setBorder(null);
        } catch (Exception e) {}

        panel.add(imgLabel, BorderLayout.NORTH);

        JLabel info = new JLabel("<html><b>" + it.title + "</b><br>" + PESO_SYMBOL + it.price.toPlainString() + "</html>", SwingConstants.CENTER);
        panel.add(info, BorderLayout.CENTER);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                panel.setBackground(Color.LIGHT_GRAY);
                panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
            }
            public void mouseExited(MouseEvent evt) {
                panel.setBackground(Color.WHITE);
                panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
            }
            public void mouseClicked(MouseEvent evt) {
                showItemDetail(it);
            }
        });

        JButton btn = new JButton("Add to Cart");
        btn.addActionListener(e -> {
            String qtyStr = JOptionPane.showInputDialog(this, "Quantity:", "1");
            try {
                int qty = Integer.parseInt(qtyStr);
                if (qty > 0) {
                    for (int i = 0; i < qty; i++) cart.add(it);
                    BigDecimal itemTotal = it.price.multiply(new BigDecimal(qty));
                    cartModel.addElement(it.title + " x" + qty + " - " + PESO_SYMBOL + itemTotal.toPlainString());
                    JOptionPane.showMessageDialog(this, it.title + " x" + qty + " added to cart!");
                } else JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity format.");
            }
        });
        panel.add(btn, BorderLayout.SOUTH);

        return panel;
    }

    private void showItemDetail(Item it) {
        JLabel imgLabel = new JLabel("Image: " + it.title, SwingConstants.CENTER);
        imgLabel.setPreferredSize(new Dimension(300, 200));
        imgLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        try {
            ImageIcon icon = new ImageIcon(it.imagePath);
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imgLabel.setIcon(new ImageIcon(img));
            imgLabel.setText("");
            imgLabel.setBorder(null);
        } catch (Exception e) {}

        JTextArea desc = new JTextArea(it.description + "\n\nPrice: " + PESO_SYMBOL + it.price.toPlainString());
        desc.setEditable(false);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setBackground(null);
        desc.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imgLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(desc), BorderLayout.CENTER);

        JOptionPane.showMessageDialog(this, panel, it.title + " - Details", JOptionPane.PLAIN_MESSAGE);
    }

    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 0));
        panel.setBorder(BorderFactory.createTitledBorder("Cart"));

        cartList = new JList<>(cartModel);
        JScrollPane scroll = new JScrollPane(cartList);
        panel.add(scroll, BorderLayout.CENTER);

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(e -> checkout());
        panel.add(checkoutBtn, BorderLayout.SOUTH);

        return panel;
    }

    private void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty!");
            return;
        }
        BigDecimal total = cart.stream().map(i -> i.price).reduce(BigDecimal.ZERO, BigDecimal::add);
        JOptionPane.showMessageDialog(this, "Purchase complete! Total: " + PESO_SYMBOL + total.toPlainString() + ". Thank you for thrifting!");
        cart.forEach(i -> i.available = false);
        cart.clear();
        cartModel.clear();
        updateFeaturedItems();
        itemsPanel.removeAll();
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    private void startCarousel() {
        carouselTimer = new Timer(2000, e -> {
            carouselIndex++;
            updateFeaturedItems();
        });
        carouselTimer.start();
    }

    private void filterItems(String keyword) {
        itemsPanel.removeAll();
        List<Item> filtered = items.stream().filter(i -> i.available && i.title.toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
        for (Item i : filtered) itemsPanel.add(createItemCard(i, false));
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ThriftcloudCoolShop::new);
    }
}
