
package PaqueteForms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Form4 extends JFrame {
    
    JPanel panel,barraNav,barraNav2,panelCalcular,panelInfo;
    JButton btnPanelCalcular,btnInfo,btnSalir;  
    JComboBox cmbColor,cmbDepartamento,cmbAntiguo;
    JLabel lbllogoImage,lblLogo2,lblCrumnl,lblCrumnl2,lblUser,lblUserImage,lblTituloInicio,lblImageInicio,lblImagPanelCalcular;
    JTextArea areaInfo,resultado; 
    JLabel TituloPanelCalcular,lblinstruccuines,lblNombre,lblApellido,lblDepto,lblAntiguo;
    JTextField txtNombre,txtApellido;
    JButton btnCalcular,btnLimpiar;
    JLabel lblLeyenda,lblLeyenda2;
    
    Color crema = new Color(255, 255, 230);  // Donde r, g, b son valores de 0 a 255   250, 205, 200
    Color celeste = new Color(200, 245, 240);  // Donde r, g, b son valores de 0 a 255  

    //Arreglo para los colores
    private String[] colorNames = {"Rosado", "Blanco","Crema"};
    private Color[] colors = {Color.pink, Color.white, crema};
    private String[] departamentos={"Atencion","Logistica","Gerente"};    
    private String[] antiguo={"1 año "," 2 a 6 años","A partir de 7 años "};

    
    Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black); //Borde de abajo
    Border borde = BorderFactory.createLineBorder(Color.black, 1); // Borde negro de 1 píxeles completo
    Border arribaAbajo = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray); //Borde de abajo
    
    public Form4(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pantalla Principal");
        setBounds(210, 120, 900, 550); //(x, y, ancho, alto)
        this.setIconImage(new ImageIcon("logo.png").getImage()); //Agregar ícono al Frame
        getContentPane().setBackground(crema);
        this.setLayout(null);  // Sin layout manager para poder posicionar los elementos manualmente
       
        agregarBarraNav();
        agregarPanelInicio();
        agregarPanelCalcular();
        eventos();
        
    }//CIERRE DEL CONSTRUCCION JFRAME
    
    
    
    public void agregarBarraNav(){
        //BARRA DE NAVEGACIÓN
        barraNav = new JPanel();
        barraNav.setLayout(null);
        barraNav.setBounds(0, 0, 890, 30);
        barraNav.setOpaque(false); //Hacer el panel transparente
        this.add(barraNav);
        
        //AGREGAR IMAGEN AL USUARIO
        ImageIcon userImage = new ImageIcon("user.png");
        lblUserImage=new JLabel();
        lblUserImage.setBounds(480,10,17,17);
        lblUserImage.setIcon(new ImageIcon(userImage.getImage().getScaledInstance(lblUserImage.getWidth(), lblUserImage.getHeight(), Image.SCALE_SMOOTH)));
        barraNav.add(lblUserImage);
        
        //ETIQUETA NOMBRE DE USUARIO
        lblUser = new JLabel("Katherine Trujillo");
        lblUser.setBounds(510,10,70,15);
        lblUser.setFont(new Font("Agency FB",1,13));
        lblUser.setBorder(bordeInferior);
        barraNav.add(lblUser);
        
        //BOTONES BARRA DE NAVEGACION  
        btnInfo = new JButton("INFO");
        btnInfo.setBounds(600,10,70,15);
        btnInfo.setFont(new Font("Agency FB",1,13));
        btnInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInfo.setOpaque(false);              // Hacer que el botón tenga fondo transparente
        btnInfo.setContentAreaFilled(false);   // Evita que se llene el área del contenido
        btnInfo.setBorder(bordeInferior);       // Quita el borde del botón
        barraNav.add(btnInfo);
        
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(680,10,70,15);
        btnSalir.setFont(new Font("Agency FB",1,13));
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setOpaque(false);              // Hacer que el botón tenga fondo transparente
        btnSalir.setContentAreaFilled(false);   // Evita que se llene el área del contenido
        btnSalir.setBorder(bordeInferior);       // Quita el borde del botón
        barraNav.add(btnSalir);
        
        cmbColor = new JComboBox(colorNames);
        cmbColor.setBounds(760,7,70,20);
        cmbColor.setFont(new Font("Agency FB",1,15));
        cmbColor.setBackground(new Color(0, 0, 0, 80));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbColor.setForeground(Color.white);  // Cambia el color de la fuente para que contrast
        cmbColor.setOpaque(false); // Hacer que el JComboBox sea transparente
        cmbColor.setFocusable(false);// Quita el borde del botón
        barraNav.add(cmbColor);
    }
    
 
    public void agregarPanelInicio(){
        //PANTALLA INICIAL
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 30, 900, 490);  // Ocupa toda la ventana
        panel.setBackground(crema);
        this.add(panel);  // Agregar el panel al JFrame
        
        //ETIQUETA IMAGEN DEL LOGO
        ImageIcon imagenLogo=new ImageIcon("Crumlogo.png");
        lbllogoImage=new JLabel();
        lbllogoImage.setBounds(5, 10, 50, 50);
        lbllogoImage.setIcon(new ImageIcon(imagenLogo.getImage().getScaledInstance(lbllogoImage.getWidth(), lbllogoImage.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panel.add(lbllogoImage);
        
        //ETIQUETA NOMBRE DEL LOGO
        lblCrumnl=new JLabel("CRUMBL");
        lblCrumnl.setBounds(62,15,100,25);
        lblCrumnl.setFont(new Font("cooper black",1,20));
        panel.add(lblCrumnl);
        
        lblCrumnl2=new JLabel("COOKIES");
        lblCrumnl2.setBounds(70,30,100,25);
        lblCrumnl2.setFont(new Font("cooper black",0,15));
        panel.add(lblCrumnl2);
        
        //ETIQUETA INICIO
        lblTituloInicio=new JLabel("CRUMBL COOKIES");
        lblTituloInicio.setBounds(90,160,500,100);
        lblTituloInicio.setFont(new Font("cooper black",0,45));
        panel.add(lblTituloInicio);
        
        areaInfo=new JTextArea("Este programa permite realizar los calculos para las "
                + "\nvacaciones de nuestros empleados asimismo, podrás \n"
                + "personalizar el color de fondo "
                + "\npara tener una mejor comodidad");
        areaInfo.setBounds(80,230,400,70);
        areaInfo.setFont(new Font("Times new Roman",0,18));
        areaInfo.setForeground(Color.black);  // Cambiar el color del texto
        areaInfo.setBackground(new Color(0, 0, 0, 0));  // Fondo transparente
        areaInfo.setOpaque(false);  // Permite que el fondo sea transparente
        areaInfo.setWrapStyleWord(true);  // Asegura que se ajusten las palabras, no los caracteres
        areaInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Borde con márgenes
        areaInfo.setEditable(false);
        panel.add(areaInfo);
        
        //IMAGEN DEL INICIO
        ImageIcon imagen2=new ImageIcon("crumbl21.png");
        lblImageInicio=new JLabel();
        lblImageInicio.setBounds(480, 40, 380, 400);
        lblImageInicio.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(lblImageInicio.getWidth(), lblImageInicio.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panel.add(lblImageInicio);
        
        //BOTON PARA CAMBIAR AL PANEL CALCULAR
        btnPanelCalcular=new JButton("Calcular Vacaciones >>");
        btnPanelCalcular.setBounds(90, 320, 150, 35);
        btnPanelCalcular.setBorder(borde);
        btnPanelCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPanelCalcular.setOpaque(false);              // Hacer que el botón tenga fondo transparente
        btnPanelCalcular.setContentAreaFilled(false);   // Evita que se llene el área del contenido
        btnPanelCalcular.setFont(new Font("Times new Roman",2,13));
        panel.add(btnPanelCalcular);
        
        //ETIQUETA LEYENDA
        lblLeyenda=new JLabel("©2020 Crumbl Cookie Company. ");
        lblLeyenda.setBounds(340,420,250,30);
        lblLeyenda.setForeground(Color.black);
        lblLeyenda.setFont(new Font("Times new Roman",1,10));
        panel.add(lblLeyenda);
    }
    
    public void agregarPanelCalcular(){
         //DISEÑO DEL PANEL DE CALCULAR
        panelCalcular = new JPanel();
        panelCalcular.setLayout(null);
        panelCalcular.setBackground(Color.white); //color de fondo
        panelCalcular.setBounds(20, 30, 845, 455);  // Mismo tamaño que el panel1
        panelCalcular.setVisible(false);  // Ocultar el panel
        this.add(panelCalcular);  // Agregar el panel3 al JFrame
        
        //AGREGAR UNA IMAGEN AL PANEL CALCULAR
        ImageIcon imgPanelCalcular=new ImageIcon("crumbl27.jpg");
        lblImagPanelCalcular=new JLabel();
        lblImagPanelCalcular.setBounds(0, 0, 290, 455);
        lblImagPanelCalcular.setIcon(new ImageIcon(imgPanelCalcular.getImage().getScaledInstance(lblImagPanelCalcular.getWidth(), lblImagPanelCalcular.getHeight(), Image.SCALE_SMOOTH)));
        panelCalcular.add(lblImagPanelCalcular);
        
        ImageIcon imgLogo2=new ImageIcon("CrumLogo.png");
        lblLogo2=new JLabel();
        lblLogo2.setBounds(390, 60, 50, 50);
        lblLogo2.setIcon(new ImageIcon(imgLogo2.getImage().getScaledInstance(lblLogo2.getWidth(), lblLogo2.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panelCalcular.add(lblLogo2);
        
        
        TituloPanelCalcular=new JLabel("CRUMBL COOKIES");
        TituloPanelCalcular.setBounds(440,60,410,50);
        TituloPanelCalcular.setFont(new Font("cooper black",0,30));
        panelCalcular.add(TituloPanelCalcular);

        lblinstruccuines = new JLabel("Ingresar los datos del trabajador para calcular las vacaciones");
        lblinstruccuines.setBounds(375,100,490,20);
        lblinstruccuines.setFont(new Font("Times new Roman",0,15));
        lblinstruccuines.setForeground(Color.gray);
        panelCalcular.add(lblinstruccuines);
        
        
        lblNombre=new JLabel("Ingrese Nombres");
        lblNombre.setBounds(330,160,100,20);
        lblNombre.setFont(new Font("Times new Roman",2,13));
        lblNombre.setForeground(Color.gray);
        panelCalcular.add(lblNombre);
        
        txtNombre=new JTextField();
        txtNombre.setBounds(330,180,200,30);
        txtNombre.setFont(new Font("Times new Roman",0,15));
        txtNombre.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        txtNombre.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        txtNombre.setOpaque(false); // Hacer que el JComboBox sea transparente
        txtNombre.setBorder(arribaAbajo);
        panelCalcular.add(txtNombre);
        
        lblApellido=new JLabel("Ingrese Apellidos");
        lblApellido.setBounds(330,230,100,20);
        lblApellido.setFont(new Font("Times new Roman",2,13));
        lblApellido.setForeground(Color.gray);
        panelCalcular.add(lblApellido);
        
        txtApellido=new JTextField();
        txtApellido.setBounds(330,250,200,30);
        txtApellido.setFont(new Font("Times new Roman",0,15));
        txtApellido.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        txtApellido.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        txtApellido.setOpaque(false); // Hacer que el JComboBox sea transparente
        txtApellido.setBorder(arribaAbajo);
        panelCalcular.add(txtApellido);
        
        lblDepto=new JLabel("Ingrese Departamento");
        lblDepto.setBounds(580,160,300,20);
        lblDepto.setFont(new Font("Times new Roman",2,13));
        lblDepto.setForeground(Color.gray);
        panelCalcular.add(lblDepto);
        
        cmbDepartamento=new JComboBox(departamentos);
        cmbDepartamento.setBounds(580,180,200,30);
        cmbDepartamento.setFont(new Font("Times new Roman",0,15));
        cmbDepartamento.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbDepartamento.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        cmbDepartamento.setOpaque(false); // Hacer que el JComboBox sea transparente
        panelCalcular.add(cmbDepartamento);
        
        lblAntiguo=new JLabel("Ingrese Antiguedad");
        lblAntiguo.setBounds(580,230,300,20);
        lblAntiguo.setFont(new Font("Times new Roman",2,13));
        lblAntiguo.setForeground(Color.gray);
        panelCalcular.add(lblAntiguo);
        
        cmbAntiguo=new JComboBox(antiguo);
        cmbAntiguo.setBounds(580,250,200,30);
        cmbAntiguo.setFont(new Font("Times new Roman",0,15));
        cmbAntiguo.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbAntiguo.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        cmbAntiguo.setOpaque(false); // Hacer que el JComboBox sea transparente
        panelCalcular.add(cmbAntiguo);
        
        btnCalcular=new JButton("Calcular");
        btnCalcular.setBounds(350,300,150,35);
        btnCalcular.setBackground(Color.black);
        btnCalcular.setForeground(Color.white);
        btnCalcular.setFont(new Font("Times new Roman",0,15));
        panelCalcular.add(btnCalcular);
        
        btnLimpiar=new JButton("Limpiar");
        btnLimpiar.setBounds(600,300,150,35);
        btnLimpiar.setBackground(Color.black);
        btnLimpiar.setForeground(Color.white);
        btnLimpiar.setFont(new Font("Times new Roman",0,15));
        panelCalcular.add(btnLimpiar);
        
        resultado=new JTextArea();
        resultado.setBounds(320,350,480,50);
        resultado.setBorder(borde);
        resultado.setEditable(false);
        resultado.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        resultado.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        resultado.setOpaque(false); // Hacer que el JComboBox sea transparente
        panelCalcular.add(resultado);
        
        
        //ETIQUETA LEYENDA
        lblLeyenda2=new JLabel("©2020 Crumbl Cookie Company. ");
        lblLeyenda2.setBounds(480,400,250,30);
        lblLeyenda2.setForeground(Color.black);
        lblLeyenda2.setFont(new Font("Times new Roman",1,10));
        panelCalcular.add(lblLeyenda2);
    }
    
    public void eventos(){
               
        //MOSTRAR INFORMACION DEL CREADOR
        ActionListener informacion;
        informacion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null,"Aplicación desarrollada por Katherine Trujilo \n            estudiante de la UMG");
            }
        };
        btnInfo.addActionListener(informacion);
        
        //CAMBIAR COLOR DEL FONDO AL PANEL CALCULAR
        cmbColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Obtenemos el índice del color seleccionado
                int indice = cmbColor.getSelectedIndex();
                // Cambiamos el color de fondo del panel
                panel.setBackground(colors[indice]);
                panelCalcular.setBackground(colors[indice]);
                
            }
        });
        
        //EVENTO PARA CAMBIAR EL PANEL
        btnPanelCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar el panel1 y mostrar el panel3
                panel.setVisible(false);
                panelCalcular.setVisible(true);              
                System.out.println("Se presionó Calcular y se cambió el panel");
            }
        });
    }
    
    
    public static void main(String[] args) {
        Form4 f=new Form4();
        f.setVisible(true);
    }
    
}
