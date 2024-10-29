
package PaqueteForms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class Formulario2 extends JFrame {
    private JPanel panel;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JTextArea area;
    private JLabel fondo;
    private JCheckBox check;
    
    private JButton botonAceptar;
    private JButton botonCancelar;
    Color rosa=new Color(252, 217, 227);
    
    public Formulario2(String nombre) {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
        setBounds(290, 190, 700, 400); //(x, y, ancho, alto)
        setResizable(false); //PARA QUE NO AGRANDEN LA PANTALLA
        this.setIconImage(new ImageIcon("logo.png").getImage()); //Agregar ícono al Frame
        
        
        //CREACION DE BORDE COMPLETO
        Border borde = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1); // Borde negro de 1 píxeles completo

        //CREANDO EL PANEL
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
        
        //IMAGEN DE DISEÑO LATERAL
        ImageIcon imagen1=new ImageIcon("crumbl6.jpg");
        fondo=new JLabel();
        fondo.setBounds(0, 0, 200, 400);
        fondo.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        //fondo.setBorder(borde);
        panel.add(fondo);
        
        //IMAGEN DE REPORTE
        ImageIcon imagen=new ImageIcon("Crumlogo.png");
        etiqueta1=new JLabel();
        etiqueta1.setBounds(270, 38, 30, 30);
        etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panel.add(etiqueta1);
        
        
        //ETIQUETA DEL TITULO TERMINOS Y CONDICIONES
        etiqueta3=new JLabel("TÉRMINOS Y CONDICIONES");
        etiqueta3.setBounds(310,30,500,50);
        etiqueta3.setFont(new Font("cooper black",0,18));
        etiqueta3.setForeground(Color.black);
        panel.add(etiqueta3);
        
        //TEXT AREA CON TODOS LOS TERMINOS
        area=new JTextArea("\n   TÉRMINOS Y CONDICIONES\n" +
                "\n" +
                "    A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DEL CREADOR.\n" +
                "    B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES.\n" +
                "    C. NO NOS HACEMOS RESPONSABLES DEL MAL USO DE ESTE SOFTWARE.\n" +
                "\n" +
                "     LOS ACUERDOS LEGALES EXPUESTOS RIGEN EL USO QUE HAGA DE ESTE SOFTWARE\n" +
                "     NO NOS HACEMOS RESPONSABLES DEL USO QUE USTED HAGA CON ESTE\n" +
                "     SERVICIO. PARA ACEPTAR LOS TERMINOS HAGA CLIC EN (ACEPTAR)\n" +
                "     SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO).\n" +
                "\n" +
                "     PARA MAYOR INFORMACIÓN SOBRE NUESTROS SERVICIOS, POR FAVOR VISITE\n" +
                "     http://www.proyectoParcial2.com");
      //AGREGAR EL TEXTAREA AL PANEL
        area.setBounds(215,85,445,185);
        area.setFont(new Font("Times new Roman",0,10));
        area.setForeground(Color.black);
        area.setEditable(false);
        area.setBorder(borde);
        panel.add(area);
        
        //ETIQUETA CHECKBOX PARA ACEPTAR LAS CONDICIONES
        check = new JCheckBox( nombre + "  ¿Aceptas las condiciones?");
        check.setBounds(215,285,700,15);
        check.setBackground(Color.white);
        check.setFont(new Font("Times new Roman",1,13));
        check.setForeground(Color.gray);
        panel.add(check);
        
        //BOTON ACEPTAR LAS CONDICIONES
        botonAceptar = new JButton("Aceptar");    
        botonAceptar.setBounds(260,320,150,30);
        botonAceptar.setFont(new Font("TImes new Roman",1,15));
        botonAceptar.setForeground(Color.black);
        botonAceptar.setBackground(rosa);
        //botonAceptar.setBorder(null);
        botonAceptar.setEnabled(false); //Iniciar en deshabilitado
        panel.add(botonAceptar);
        
        //BOTON CANCELAR LAS CONDICIONES
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(450,320,150,30);
        botonCancelar.setFont(new Font("TImes new Roman",1,15));
        botonCancelar.setForeground(Color.black);
        botonCancelar.setBackground(rosa);
        //botonCancelar.setBorder(null);
        panel.add(botonCancelar);
        
        
        
        
        //EVENTOS
        //ACCION PARA HABILITAR Y DESACTIVAR EL BOTON
        check.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(check.isSelected()==true){
                    botonAceptar.setEnabled(true);
                    botonCancelar.setEnabled(false);
                }else{
                    botonAceptar.setEnabled(false);
                    botonCancelar.setEnabled(true);
                }    
            }
            
        });
        
        //ACCION ACEPTAR 
        ActionListener accion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si acepta, pasar al Formulario3
                Formulario3 form3 = new Formulario3(nombre);
                form3.setVisible(true);
                dispose(); // Cerrar este formulario
            }
        };
        botonAceptar.addActionListener(accion);
        
        //ACCION CANCELAR
        ActionListener accion2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Formulario1 form1=new Formulario1();
                form1.setVisible(true);
                dispose();
            }
        };
        botonCancelar.addActionListener(accion2);
         
    }
 
}
