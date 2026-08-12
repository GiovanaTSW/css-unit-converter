import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConversor extends JFrame {

    //Componentes de la interfaz
    private JTextField txtBase;
    private JTextField txtPx;
    private JTextField txtEm;

    private JLabel lblResultadoEm;
    private JLabel lblResultadoPx;

    public VentanaConversor() {

        //Configuración básica de la ventana (JFrame)
        setTitle("CSS Unit Converter");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Layout general
        setLayout(new GridLayout(7, 2, 10, 10));

        //1. Fila Base Px
        add(new JLabel("Tamaño Base (px):"));
        txtBase = new JTextField("16"); //Valor que asigno por defecto
        add(txtBase);

        //2. Fila entrada Px
        add(new JLabel("Valor en Pixelex (px):"));
        txtPx =new JTextField();
        add(txtPx);

        //3. Botón y resultado PX -> EM
        JButton btnPxToEm = new JButton("Convertir a EM");
        add(btnPxToEm);

        lblResultadoEm = new JLabel("Resultado: -");
        lblResultadoEm.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResultadoEm);

        //Separador Visual
        add(new JSeparator());
        add(new JSeparator());

        //4. Fila entrada EM
        add(new JLabel("Valor en EM (em): "));
        txtEm = new JTextField();
        add(txtEm);

        //5. Botón y resultado EM -> PX
        JButton btnEmToPx = new JButton("Convertir a Px");
        add(btnEmToPx);

        lblResultadoPx = new JLabel("Resultado: -");
        lblResultadoPx.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResultadoPx);

        // Eventos de los botones
        btnPxToEm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirPxAEm();
            }
        });

        btnEmToPx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirEmAPx();
            }
        });
    }

    // Acción de EM a Px
    private void convertirPxAEm() {
        try {
            double base = Double.parseDouble(txtBase.getText());
            double px = Double.parseDouble(txtPx.getText());

            double em = ConversorUnidades.pxToEm(px, base);
            lblResultadoEm.setText(String.format("Resultado: %.4f em", em));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en los campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Acción de PX a EM
    private void convertirEmAPx() {
        try {
            double base = Double.parseDouble(txtBase.getText());
            double em = Double.parseDouble(txtEm.getText());

            double px = ConversorUnidades.emToPx(em, base);
            lblResultadoPx.setText(String.format("Resultado: %.2f px", px));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en los campos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método ejecutable para probar la ventana
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaConversor ventana = new VentanaConversor();
            ventana.setVisible(true);
        });
    }
}
