package sv.edu.unab.expresioneslambda.formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demostracion {
    public JPanel pnlComponentes;
    private JLabel lblResultadoCSA;
    private JTextField txtParametroCCP;
    private JLabel lblResultadoCCP;
    private JButton btnEjecutarCCP;
    private JLabel lblResultadoFSA;
    private JTextField txtParametroFCA;
    private JButton btnejecutarProveedorButton;
    private JLabel lblResultadoFCA;
    private JTextField txtParametroPUA;
    private JButton btnEjecutarPUA;
    private JLabel lblResuladoPUA;

    public Demostracion(){
        Runnable csa = () -> {
            lblResultadoCSA.setText("Ejecucion realizada correctamente");
        };
        csa.run();
        Consumer<String> ccp = a -> lblResultadoCCP.setText(a);
        btnEjecutarCCP.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String textMostrar = null;
                if(!txtParametroCCP.getText().isEmpty()){
                    textMostrar = txtParametroCCP.getText();
                    ccp.accept(textMostrar);
                }
            }
        });
        Supplier<Integer> fsa = () -> 35 + 36;
        lblResultadoFSA.setText(fsa.get().toString());
        Function<Integer, String> fca = (Integer a) -> String.valueOf(a + 12 +36);
        btnejecutarProveedorButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer parametro = !txtParametroFCA.getText().isEmpty() ? Integer.parseInt(txtParametroFCA.getText()) : 0;
                lblResultadoFCA.setText(fca.apply(parametro));
            }
        });
        Predicate<Integer> pcua = a -> a > -1;

        btnEjecutarPUA.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer parametro = !txtParametroPUA.getText().isEmpty() ? Integer.parseInt(txtParametroPUA.getText()) : -1;
                if(pcua.test(parametro)){
                    lblResuladoPUA.setText("Numero Natural");
                } else {
                    lblResuladoPUA.setText("Numero Entero Negativo");
                }
            }
        });
    }

    public static void main(String[] args){
        JFrame frm = new JFrame("Demostracion de Expresiones Lambda");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setContentPane(new Demostracion().pnlComponentes);
        frm.pack();
        frm.setVisible(true);
    }
}
