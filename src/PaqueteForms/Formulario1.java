
package PaqueteForms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;

public class Formulario1 extends JFrame {
    JLabel fondo;
    JPanel panel;
    JLabel lblLogo2;
    JLabel lblNombreEmpresa;
    JLabel lblTitulo;
    JLabel lblSubtitulo;
    JLabel lnlNombre;
    JLabel lblLeyenda;
    JTextField txtNombre;
    JButton botonEntrar;
    
    Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY); //Borde de abajo

    public Formulario1() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BIENVENIDO");
        setBounds(300, 190, 700, 450); //(x, y, ancho, alto)
        this.setIconImage(new ImageIcon("logo.png").getImage()); //Agregar ícono al Frame
        setResizable(false); //PARA QUE NO AGRANDEN LA PANTALLA
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        agregarPanel();
        agregarEtiquetas();
        agregarBoton();
    }
    
    public void agregarPanel(){
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
       
    }
    
    public void agregarEtiquetas(){
        //ETIQUETA
        
        lblNombreEmpresa=new JLabel("Crumbl Cookies");
        lblNombreEmpresa.setBounds(10,10,100,10);
        lblNombreEmpresa.setFont(new Font("Times new Roman",2,12));
        panel.add(lblNombreEmpresa);
         
        ImageIcon imgLogo2=new ImageIcon("CrumLogo.png");
        lblLogo2=new JLabel();
        lblLogo2.setBounds(450, 35, 80, 80);
        lblLogo2.setIcon(new ImageIcon(imgLogo2.getImage().getScaledInstance(lblLogo2.getWidth(), lblLogo2.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panel.add(lblLogo2);
        
        //ETIQUETA TITULO
        lblTitulo=new JLabel("CRUMBL");
        lblTitulo.setBounds(420,100,1000,40);
        lblTitulo.setFont(new Font("cooper black",1,30));
        lblTitulo.setForeground(Color.black);
        panel.add(lblTitulo);
        
        //ETIQUETA SUBTITULO
        lblSubtitulo=new JLabel("SISTEMA DE CONTROL");
        lblSubtitulo.setBounds(365,130,1000,40);
        lblSubtitulo.setFont(new Font("cooper black",1,20));
        lblSubtitulo.setForeground(Color.black);
        panel.add(lblSubtitulo);
        
        //ETIQUETA NOMBRE
        lnlNombre=new JLabel("Ingrese Nombre");
        lnlNombre.setBounds(340,200,250,30);
        lnlNombre.setForeground(Color.gray);
        lnlNombre.setFont(new Font("Times new Roman",2,12));
        panel.add(lnlNombre);
        
        //CAJITA DE TEXTO PARA EL NOMBRE
        txtNombre=new JTextField();
        txtNombre.setBounds(340,225,280,30);
        txtNombre.setFont(new Font("Times new Roman",0,15));
        txtNombre.setBorder(bordeInferior);
        panel.add(txtNombre);
        
        //ETIQUETA LEYENDA
        lblLeyenda=new JLabel("©Crumbl Cookie Katherine Progra 2 C. ");
        lblLeyenda.setBounds(410,370,250,30);
        lblLeyenda.setForeground(Color.black);
        lblLeyenda.setFont(new Font("Times new Roman",1,10));
        panel.add(lblLeyenda);
        
       //ETIQUETA IMAGEN DEL FONDO
        ImageIcon imagen=new ImageIcon("crumbl31.jpg");
        fondo=new JLabel();
        fondo.setBounds(0, 0, 300, 450);
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        //fondo.setBorder(borde);
        panel.add(fondo);
    }

  
    //AGREGAR BOTON ENTRAR
    public void agregarBoton(){
        //BOTON ENTRAR
        botonEntrar=new JButton("Ingresar");
        botonEntrar.setBounds(360,290,250,30);
        botonEntrar.setFont(new Font("Times new Roman",1,15));
        botonEntrar.setBackground(Color.darkGray);
        botonEntrar.setForeground(Color.white);
        panel.add(botonEntrar);
        
        //ACCION DEL BOTON
        ActionListener entrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String nombre = txtNombre.getText();
                
                
                if (!nombre.isEmpty()) {// Validar si se ingresó un nombre
                    
                    Formulario2 form2 = new Formulario2(nombre);
                    form2.setVisible(true);
                    dispose(); // Cerrar el formulario actual
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre.");
                }
            }
        };
        botonEntrar.addActionListener(entrar);
    }
    
    public static void main(String[] args) {
        Formulario1 v = new Formulario1();
        v.setVisible(true);
    }
}

