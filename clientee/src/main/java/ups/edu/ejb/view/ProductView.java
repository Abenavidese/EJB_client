package ups.edu.ejb.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ups.edu.ejb.clientee.Main;

public class ProductView extends JFrame {
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnRegistrar;

    private Main client;

    public ProductView() {
        setTitle("Registro de Productos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Inicializar el cliente EJB
        try {
            client = new Main();
            client.initialize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inicializando el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Configurar el contenedor principal
        getContentPane().setLayout(new BorderLayout());

        // Crear el encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180));
        JLabel headerLabel = new JLabel("Registro de Productos");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Crear el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margen alrededor

        formPanel.add(createFormRow("Nombre del producto:", txtNombre = new JTextField()));
        formPanel.add(createFormRow("Descripción:", txtDescripcion = new JTextField()));
        formPanel.add(createFormRow("Precio:", txtPrecio = new JTextField()));
        formPanel.add(createFormRow("Cantidad disponible:", txtCantidad = new JTextField()));

        getContentPane().add(formPanel, BorderLayout.CENTER);

        // Crear el botón de registro
        JPanel buttonPanel = new JPanel();
        btnRegistrar = new JButton("Registrar Producto");
        btnRegistrar.setBackground(new Color(60, 179, 113));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setFocusPainted(false);
        buttonPanel.add(btnRegistrar);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Agregar eventos al botón
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
    }

    private JPanel createFormRow(String labelText, JTextField textField) {
        JPanel row = new JPanel();
        row.setLayout(new BorderLayout(10, 10));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        row.add(label, BorderLayout.WEST);
        row.add(textField, BorderLayout.CENTER);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Asegura que el tamaño sea consistente
        return row;
    }

    private void registrarProducto() {
        try {
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            Double precio = Double.parseDouble(txtPrecio.getText());
            Integer cantidad = Integer.parseInt(txtCantidad.getText());

            client.registerProducto(nombre, descripcion, precio, cantidad);

            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar campos
            txtNombre.setText("");
            txtDescripcion.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error registrando producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }
}
