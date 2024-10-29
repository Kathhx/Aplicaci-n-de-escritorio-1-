
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Formulario3 extends JFrame implements ActionListener{
    //ATRIBUTOS
    JPanel panel,barraNav,panelCalcular,panelInfo;
    JButton btnPanelCalcular,btnInfo,btnSalir;  
    JComboBox cmbColor,cmbDepartamento,cmbAntiguo;
    JLabel lbllogoImage,lblLogo2,lblCrumnl,lblCrumnl2,lblUser,lblUserImage,lblTituloInicio,lblImageInicio,lblImagPanelCalcular;
    JTextArea areaInfo,resultado; 
    JLabel TituloPanelCalcular,lblinstruccuines,lblNombre,lblApellido,lblDepto,lblAntiguo;
    JTextField txtNombre,txtApellido;
    JButton btnCalcular,btnLimpiar;
    JLabel lblLeyenda,lblLeyenda2,lblResultado;
    
    //DECLARAR COLORES PARA EL FONDO
    Color rosa=new Color(255, 230, 237);
    Color crema = new Color(255, 255, 230);  // Donde r, g, b son valores de 0 a 255   250, 205, 200


    //Arreglo para los colores
    private String[] colorNames = {"Rosado", "Blanco","Crema"};
    private Color[] colors = {rosa, Color.white, crema};
    
    //ARREGLO PARA LOS COMBOBOX
    private String[] departamentos={"Atencion","Logistica","Gerente"};    
    private String[] antiguo={"1 año","2 a 6 años","7 años o más"};

    //BORDES DE LAS ETIQUETAS
    Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray); //Borde de abajo
    Border borde = BorderFactory.createLineBorder(Color.black, 1); // Borde negro de 1 píxeles completo
    

    //CREAR LA VENTANA Y BARRA DE NAVEGACION
    public Formulario3(String nombre) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pantalla Principal");
        setBounds(210, 120, 900, 550); 
        this.setIconImage(new ImageIcon("logo.png").getImage()); //Agregar ícono al Frame
        getContentPane().setBackground(Color.black);
        setResizable(false); //PARA QUE NO AGRANDEN LA PANTALLA
        this.setLayout(null);  // Sin layout manager para poder posicionar los elementos manualmente
       
       //CREAR BARRA DE NAVEGACIÓN
        barraNav = new JPanel();
        barraNav.setLayout(null);
        barraNav.setBounds(0, 0, 890, 30);
        barraNav.setOpaque(false); //Hacer el panel transparente
        this.add(barraNav);
        
        //AGREGAR IMAGEN AL USUARIO
        ImageIcon userImage = new ImageIcon("user.png");
        lblUserImage=new JLabel();
        lblUserImage.setBounds(460,5,25,25);
        lblUserImage.setIcon(new ImageIcon(userImage.getImage().getScaledInstance(lblUserImage.getWidth(), lblUserImage.getHeight(), Image.SCALE_SMOOTH)));
        barraNav.add(lblUserImage);
        
        //ETIQUETA NOMBRE DE USUARIO
        lblUser = new JLabel(nombre);
        lblUser.setBounds(490,7,100,17);
        lblUser.setFont(new Font("Agency FB",1,18));
        lblUser.setForeground(Color.white);
        lblUser.setBorder(bordeInferior);
        barraNav.add(lblUser);
        
        //BOTONES BARRA DE NAVEGACION 
        //BOTON INFORMACION
        btnInfo = new JButton("INFO");
        btnInfo.setBounds(600,10,70,15);
        btnInfo.setFont(new Font("Agency FB",1,13));
        btnInfo.setForeground(Color.white);
        btnInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInfo.setOpaque(false);              // Hacer que el botón tenga fondo transparente
        btnInfo.setContentAreaFilled(false);   // Evita que se llene el área del contenido
        btnInfo.setBorder(bordeInferior);       // Quita el borde del botón
        barraNav.add(btnInfo);
        
        //BOTON SALIR
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(680,10,70,15);
        btnSalir.setFont(new Font("Agency FB",1,13));
        btnSalir.setForeground(Color.white);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cambiar el diseño del cursor
        btnSalir.setOpaque(false);              // Hacer que el botón tenga fondo transparente
        btnSalir.setContentAreaFilled(false);   // Evita que se llene el área del contenido
        btnSalir.setBorder(bordeInferior);       // Quita el borde del botón
        barraNav.add(btnSalir);
        
        //COMBOBOX PARA CAMIAR DE COLOR
        cmbColor = new JComboBox(colorNames);
        cmbColor.setBounds(760,7,70,20);
        cmbColor.setFont(new Font("Agency FB",1,15));
        cmbColor.setBackground(new Color(0, 0, 0, 80));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbColor.setForeground(Color.white);  // Cambia el color de la fuente para que contrast
        cmbColor.setOpaque(false); // Hacer que el JComboBox sea transparente
        cmbColor.setFocusable(false);// Quita el borde del botón
        barraNav.add(cmbColor);
        
        agregarPanelInicio();
        agregarPanelCalcular();
        
        //AÑADIR ACCION A LOS BOTONES
        btnInfo.addActionListener(this); 
        btnSalir.addActionListener(this); 
        cmbColor.addActionListener(this); 
        btnPanelCalcular.addActionListener(this);
        btnCalcular.addActionListener(this);
        btnLimpiar.addActionListener(this);
    }
    
    //DISEÑO DEL PANEL DE INICIO
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
        
        //TEXT AREA CON LA INFORMACION DEL INICIO
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
        lblLeyenda=new JLabel("©Crumbl Cookie Katherine Progra 2 C.");
        lblLeyenda.setBounds(340,420,250,30);
        lblLeyenda.setForeground(Color.black);
        lblLeyenda.setFont(new Font("Times new Roman",1,10));
        panel.add(lblLeyenda);
    }
    
    
    //DISEÑO DEL OTRO PANEL
    public void agregarPanelCalcular(){
        //DISEÑO DEL PANEL DE CALCULAR
        panelCalcular = new JPanel();
        panelCalcular.setLayout(null);
        panelCalcular.setBackground(Color.white); //color de fondo
        panelCalcular.setBounds(0, 30, 900, 490);  
        panelCalcular.setVisible(false);  // Ocultar el panel
        this.add(panelCalcular);  // Agregar el panel3 al JFrame
        
        //AGREGAR UNA IMAGEN AL PANEL CALCULAR
        ImageIcon imgPanelCalcular=new ImageIcon("crumbl32.jpg");
        lblImagPanelCalcular=new JLabel();
        lblImagPanelCalcular.setBounds(0, 0, 320, 490);
        lblImagPanelCalcular.setIcon(new ImageIcon(imgPanelCalcular.getImage().getScaledInstance(lblImagPanelCalcular.getWidth(), lblImagPanelCalcular.getHeight(), Image.SCALE_SMOOTH)));
        panelCalcular.add(lblImagPanelCalcular);
        
        //AGREGAR EL LOGO 
        ImageIcon imgLogo2=new ImageIcon("CrumLogo.png");
        lblLogo2=new JLabel();
        lblLogo2.setBounds(560, 20, 100, 90);
        lblLogo2.setIcon(new ImageIcon(imgLogo2.getImage().getScaledInstance(lblLogo2.getWidth(), lblLogo2.getHeight(), Image.SCALE_SMOOTH))); //(Ancho,largo,escalado) Permite tener el mismo tamaño de la etiqueta
        panelCalcular.add(lblLogo2);
        
        //AGREGAR EL TITULO AL PANEL
        TituloPanelCalcular=new JLabel("CRUMBL");
        TituloPanelCalcular.setBounds(550,100,410,50);
        TituloPanelCalcular.setFont(new Font("cooper black",0,30));
        panelCalcular.add(TituloPanelCalcular);

        //INSTRUCCIONES DE LO QUE SE REALIZA
        lblinstruccuines = new JLabel("CALCULAR VACACIONES");
        lblinstruccuines.setBounds(490,140,490,20);
        lblinstruccuines.setFont(new Font("cooper black",0,20));
        lblinstruccuines.setForeground(Color.DARK_GRAY);
        panelCalcular.add(lblinstruccuines);
        
        //ETIQUETA DEL NOMBRE
        lblNombre=new JLabel("Ingrese Nombres");
        lblNombre.setBounds(415,190,100,20);
        lblNombre.setFont(new Font("Times new Roman",2,12));
        lblNombre.setForeground(Color.DARK_GRAY);
        panelCalcular.add(lblNombre);
        
        //CAJITA DE TEXTO DEL NOMBRE
        txtNombre=new JTextField();
        txtNombre.setBounds(415,210,180,30);
        txtNombre.setFont(new Font("Times new Roman",0,15));
        txtNombre.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        txtNombre.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        txtNombre.setOpaque(false); // Hacer que el JComboBox sea transparente
        txtNombre.setBorder(borde);
        panelCalcular.add(txtNombre);
        
        //ETIQUETA DEL APELLIDO
        lblApellido=new JLabel("Ingrese Apellidos");
        lblApellido.setBounds(640,190,180,20);
        lblApellido.setFont(new Font("Times new Roman",2,12));
        lblApellido.setForeground(Color.darkGray);
        panelCalcular.add(lblApellido);
        
        //CAJITA DE TEXTO PARA EL APELLIDO
        txtApellido=new JTextField();
        txtApellido.setBounds(640,210,180,30);
        txtApellido.setFont(new Font("Times new Roman",0,15));
        txtApellido.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        txtApellido.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        txtApellido.setOpaque(false); // Hacer que el JComboBox sea transparente
        txtApellido.setBorder(borde);
        panelCalcular.add(txtApellido);
        
        //ETIQUETA PARA EL DEPARTAMENTO
        lblDepto=new JLabel("Ingrese Departamento");
        lblDepto.setBounds(415,250,300,20);
        lblDepto.setFont(new Font("Times new Roman",2,12));
        lblDepto.setForeground(Color.darkGray);
        panelCalcular.add(lblDepto);
        
        //CAJITA PARA EL DEPARTAMENTO
        cmbDepartamento=new JComboBox(departamentos);
        cmbDepartamento.setBounds(415,270,180,30);
        cmbDepartamento.setFont(new Font("Times new Roman",0,15));
        cmbDepartamento.setBackground(new Color(255, 255, 255, 100));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbDepartamento.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        cmbDepartamento.setOpaque(false); // Hacer que el JComboBox sea transparente
        panelCalcular.add(cmbDepartamento);
        
        //ETIQUETA PARA LA ANTIGUEDAD
        lblAntiguo=new JLabel("Ingrese Antiguedad");
        lblAntiguo.setBounds(640,250,300,20);
        lblAntiguo.setFont(new Font("Times new Roman",2,12));
        lblAntiguo.setForeground(Color.darkGray);
        panelCalcular.add(lblAntiguo);
        
        //COMBOBOX PARA QUE SELECCIONE LA ANTIGUEDAD
        cmbAntiguo=new JComboBox(antiguo);
        cmbAntiguo.setBounds(640,270,180,30);
        cmbAntiguo.setFont(new Font("Times new Roman",0,15));
        cmbAntiguo.setBackground(new Color(255, 255, 255, 100));  // Fondo transparente (Color negro con 0 de opacidad)
        cmbAntiguo.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        cmbAntiguo.setOpaque(false); // Hacer que el JComboBox sea transparente
        panelCalcular.add(cmbAntiguo);
        
        //ETIQUETA PARA VER EL RESULTADO
        lblResultado=new JLabel("Resultado de vacaciones:");
        lblResultado.setBounds(415,360,300,20);
        lblResultado.setFont(new Font("Times new Roman",2,12));
        lblResultado.setForeground(Color.darkGray);
        panelCalcular.add(lblResultado);
        
        //TEXT AREA PARA MOSTRAR EL RESULTADO
        resultado=new JTextArea();
        resultado.setBounds(415,380,405,55);
        resultado.setFont(new Font("Times new Roman",0,12));
        resultado.setBorder(borde);
        resultado.setEditable(false);
        resultado.setBackground(new Color(255, 255, 255, 0));  // Fondo transparente (Color negro con 0 de opacidad)
        resultado.setForeground(Color.black);  // Cambia el color de la fuente para que contrast
        resultado.setOpaque(false); // Hacer que el JComboBox sea transparente
        resultado.setVisible(false);
        panelCalcular.add(resultado);
         
        //BOTON CALCULAR VACACINOES
        btnCalcular=new JButton("Calcular");
        btnCalcular.setBounds(415,320,180,35);
        btnCalcular.setBackground(Color.black);
        btnCalcular.setForeground(Color.white);
        btnCalcular.setFont(new Font("Times new Roman",0,15));
        panelCalcular.add(btnCalcular);
        
        //BOTON PARA LIMPIAR LAS ETIQUETAS
        btnLimpiar=new JButton("Limpiar");
        btnLimpiar.setBounds(640,320,180,35);
        btnLimpiar.setBackground(Color.black);
        btnLimpiar.setForeground(Color.white);
        btnLimpiar.setFont(new Font("Times new Roman",0,15));
        panelCalcular.add(btnLimpiar);
        
        //ETIQUETA LEYENDA
        lblLeyenda2=new JLabel("©Crumbl Cookie Katherine Progra 2 C.");
        lblLeyenda2.setBounds(550,450,250,30);
        lblLeyenda2.setForeground(Color.black);
        lblLeyenda2.setFont(new Font("Times new Roman",1,10));
        panelCalcular.add(lblLeyenda2);
        
    }
    

    //ACCIONES DE LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //BOTON INFORMACION
            if(e.getSource()==btnInfo){
                JOptionPane.showMessageDialog(null,"Aplicación desarrollada por Katherine Trujilo \n "
                        + "           estudiante de la UMG");
                
            //BOTON SALIR
            }else if(e.getSource()==btnSalir){
                Formulario1 form1=new Formulario1();
                form1.setVisible(true);
                dispose(); // Cerrar el formulario actual
                
             //BOTON CAMBIAR AL PANEL CALCULAR   
            }else if(e.getSource()==btnPanelCalcular){ 
                panel.setVisible(false); // Ocultar el panel1 y mostrar el panel3
                panelCalcular.setVisible(true);              
                System.out.println("Se presionó Calcular y se cambió el panel");
                
            }
            //ACCION PARA CAMBIAR EL COLOR
            else if(e.getSource()==cmbColor){
                // Obtenemos el índice del color seleccionado
                int indice = cmbColor.getSelectedIndex();
                // Cambiamos el color de fondo del panel
                panel.setBackground(colors[indice]);
                panelCalcular.setBackground(colors[indice]);
            }
            //ACCION PARA REALIZAR LOS CALCULOS
            if(e.getSource()==btnCalcular){
                int dias=0;
                String nombre=txtNombre.getText();
                String apellido=txtApellido.getText();
                
                String antiguo=cmbAntiguo.getSelectedItem().toString();
                String depto=cmbDepartamento.getSelectedItem().toString();
                
                if (!nombre.isEmpty() || !apellido.isEmpty() ) {// Validar si se ingresó un nombre
                    
                    if(depto.equalsIgnoreCase("Atencion")){
                    if(antiguo.equalsIgnoreCase("1 año")){
                        dias=6;
                    }else if(antiguo.equalsIgnoreCase("2 a 6 años")){
                        dias=14;
                    }else if(antiguo.equalsIgnoreCase("7 años o más")){
                        dias=20;
                    }
                }else if(depto.equalsIgnoreCase("Logistica")){
                     if(antiguo.equalsIgnoreCase("1 año")){
                        dias=7;
                    }else if(antiguo.equalsIgnoreCase("2 a 6 años")){
                        dias=15;
                    }else if(antiguo.equalsIgnoreCase("7 años o más")){
                        dias=22;
                    }
                }else if(depto.equalsIgnoreCase("Gerente")){
                     if(antiguo.equalsIgnoreCase("1 año")){
                        dias=10;
                    }else if(antiguo.equalsIgnoreCase("2 a 6 años")){
                        dias=20;
                    }else if(antiguo.equalsIgnoreCase("7 años o más")){
                        dias=30;
                    }
                     
                }
                
                resultado.setVisible(true);
                resultado.setText("El empleado "+nombre+" " +apellido+" quien labora de\n"+depto+""
                        + " con "+antiguo+" de servicio \nrecibe "+dias+" días de vacaciones");
                
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese datos.");
                }


            } 
            //ACCION PARA LIMPIAR LAS ETIQUETAS
            if(e.getSource()==btnLimpiar){
                txtNombre.setText("");
                txtApellido.setText("");
                cmbDepartamento.setSelectedIndex(0);
                cmbAntiguo.setSelectedIndex(0);
                resultado.setText("");
                //resultado.setVisible(false);
                      
            }
            
        }catch(NumberFormatException ex){
         resultado.setText("Por favor, ingresar datos.");   
        }
        
    }
    
    
    
}
