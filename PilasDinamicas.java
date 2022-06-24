// TODO: AL LADO DE LOS MENSAJES DEL PANEL SE ENCUENTRAN LOS BOTONES, SOLO PASE LA FLECHA DEL MOUSE PARA QUE APAREZCAN
import javax.swing.ImageIcon; //Importamos la libreia para el los icnonos
import javax.swing.JButton; //Importamos la libreria para los botones
import javax.swing.JFrame; // Importamos la libreria para el JFrame o ventana grafica
import javax.swing.JLabel; // Importamos la libreria para los JLabel
import javax.swing.JPanel; // Importamos la libreria para el panel
import javax.swing.JTextArea; // Importamos la libreria para el area de texto
import javax.swing.JScrollPane; // Importamos la libreria para poner una barra de desplazamiento dentro de el area de texto
import java.awt.Dimension; // Importamos la libreria para las dimensiones
import java.awt.Font; // Importamos la libreria para las fuentes de letras
import java.awt.Image; // Importamos la libreria para las imagenes
import java.awt.Color; // Importamos la libreria para los colores
import java.awt.event.ActionListener; //Importamos la libreria para La interfaz de escucha y para recibir eventos de acción.
import java.awt.event.ActionEvent; // Importamos la libreria para los eventos
import javax.swing.JOptionPane; // Importamos la libreria para los mensajes de dialogo

class PilasDinamicas extends JFrame{ // Creamos una clase y la instanciamos al JFrame
    private JPanel panel;
    Nodo Primero, Final;
    int pos;
    public PilasDinamicas (){ //establecemos la estancia pilas dinamicas como publica
        Primero = null; //apuntamos el primero a null
        Final = null; // establecemos el final a null
        pos=0; // inicializamos la posicion  en 0
    }
    private Boolean esVacia(){ // establecemos la funcion esVacia para verificar cuando la pila este vacia o no
        return this.Primero==null;
    }
    private  void Insertar(int dato){ // establecemos la funcion para insertar una pila al inicio
        Nodo nuevo = new Nodo (dato); // creamos un nuevo nodo
        Primero=nuevo; //apuntamos el nuevo nodo a primer lugar
        Final=nuevo; //apuntamos el nodo final a nuevo
        pos++; //aumentamos la posicion
    }

    public void  Ventanagrafica(){ // Establecemos la ventana grafica donde iran todas los elementos y funciones
        this.setTitle(" PILAS DINAMICAS"); // Establecemos el nombre de la ventan grafica
        this.setIconImage(new ImageIcon(getClass().getResource("Icono.png")).getImage()); // establecemos el icono par ala ventan grafica
        this.setSize(600,400); //Establecemos el tamaño de la ventana
        this.setResizable(false); // Establecemos el parametro para que no se pueda cambiar el tammaño de la ventana
        this.setVisible(true);   // Hacemos visible la ventana
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro de la ventana
        this.setMinimumSize(new Dimension(600,400)); //Establecemos el tamaño minimo
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Establecemos el parametro setDefaultCloseOperation para que la ventana se cierre
    }
    private void iniciarComponentes(){ // Establecemos los componentes de todas las funciones y elementos
        panel();
        etiquetas();
        botones();
    }
    private void panel(){ // Establecemos el panel
        panel = new JPanel(); // Creamos el panel
        panel.setBackground(Color.GRAY); //Establecemos el color del panel
        panel.setLayout(null); //Desactivamos el diseño
        this.getContentPane().add(panel); // Agregamos el panel a la ventana
    }
    private void etiquetas(){
        JLabel etiqueta1 = new  JLabel(); //Creamos la etiqueta 1 para insertar la pila
        etiqueta1.setText("1.INSERTAR AL INICIO DE LA PILA"); //Establecemos el texto de la etiqueta
        etiqueta1.setBounds(20, 40, 230, 30); //Establecemos el tamaño y la posicion de la etiqueta de texto
        etiqueta1.setForeground(Color.BLACK); //Establecmeos el color de la letra
        etiqueta1.setFont(new Font("Bahnschrift", Font.BOLD, 13)); // Establecemos la fuente, tamaño y estilo del texto
        panel.add(etiqueta1); //Agregamos la etiqueta la panel

        JLabel etiqueta2 = new JLabel(); // creamos la etiqueta 2 de texto
        etiqueta2.setText("2.ELIMINAR FINAL DE LA PILA"); //Establecemos el texto de la etiqueta
        etiqueta2.setBounds(20, 80, 210, 60); //Establecemos el tamaño y la posicion de la etiqueta de texto
        etiqueta2.setForeground(Color.BLACK);//Establecmeos el color de la letra
        etiqueta2.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        panel.add(etiqueta2); // agregamos la etiqueta al panel

        JLabel etiqueta3 = new JLabel(); // Creamos la etiqueta 3 para listar la pila
        etiqueta3.setText("3.LISTAR PILA"); // Establecemos el texto de la etiqueta
        etiqueta3.setBounds(20, 120, 200, 90); // Establecemos el tamaño y la posicion de la etiqueta de texto
        etiqueta3.setForeground(Color.BLACK);//Establecmeos el color de la letra
        etiqueta3.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        panel.add(etiqueta3); //agregamos la etiqueta al panel

        JLabel etiqueta4 = new JLabel(); // creamos la etiqueta 4 para el tamaño de la pila
        etiqueta4.setText("4.TAMANIO DE LA PILA"); // Establecemos el texto de la etiqueta
        etiqueta4.setBounds(20, 160, 240, 120 ); //Establecemos el tamaño y la posición de la etiqueta de texto
        etiqueta4.setForeground(Color.BLACK);//Establecmeos el color de la letra
        etiqueta4.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        panel.add(etiqueta4); //agregamos la etiqueta al panel

        JLabel etiqueta5 = new JLabel(); // creamos la etiqueta 5 para salir del progrma
        etiqueta5.setText("5. SALIR "); // Establecemos el texto de la etiqueta
        etiqueta5.setBounds(20, 200, 280, 150); //Establecemos el tamaño y la posición de la etiqueta de texto
        etiqueta5.setForeground(Color.BLACK);//Establecmeos el color de la letra
        etiqueta5.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        panel.add(etiqueta5); // Agregamos la etiqueta al panel
    }
    private void botones(){
        JTextArea areaText = new JTextArea(); // Establecemos una nueva area de texto
        areaText.setLineWrap(true); // Establecemos la lineas de texto para auto acomodarse
        areaText.setForeground(Color.BLUE); // Establecemos el color de la letra
        areaText.setFont(new Font("Bahnschrift", Font.BOLD, 13)); // estbalecemos el estilo de la letra y el tamaño
        JScrollPane scroll = new JScrollPane(areaText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Establecemos el scroll de forma vertical y el texto de forma Horizontal
        scroll.setBounds(370, 40, 200, 300); // Establecemos el tamaño y el luhar del area de texto
        scroll.setForeground(Color.BLACK);;//Establecmeos el color de la letra
        panel.add(scroll); // agrefamos es scroll al area de texto dentro del panel

        JButton botonInsertar = new JButton(); // Creamos un nuevo boton
        botonInsertar.setBounds(260, 40, 50, 30); // Establecemos el tamaño del boton
        ImageIcon insertar = new ImageIcon("Insertar.png"); // Insertamos una nueva imagen como icono
        botonInsertar.setIcon(new ImageIcon(insertar.getImage().getScaledInstance(botonInsertar.getWidth(), botonInsertar.getHeight(), Image.SCALE_SMOOTH ))); // Insertamos la imagen dentro del boton, colocando la escala de la imagen
        panel.add(botonInsertar); //Agregamos el boton al panel
        botonInsertar.addActionListener(new ActionListener(){ //Establecemos la accion listener dento del boton
            public void actionPerformed(ActionEvent e){
                int dato;
                int v; // validacion
                do{ // inicio de la validacion
                    try{
                        v=0;
                            dato = Integer.parseInt(JOptionPane.showInputDialog(null,("INGRESE EL VALOR A INSERTAR"))); // Estbalecemos el dialogo para insertar los datos
                            if (esVacia()) // hacemos la comparacion, si es vacia insertamos el dato
                                Insertar(dato);
                            else{ // si no es vacia, insertamos el dato nuevo primero
                                Primero = new  Nodo (dato,Primero);
                                pos++;
                            }
                            JOptionPane.showMessageDialog(null," DATO INSERTADO "); // Establecemos un mensaje cuando los datos se hayan insertado
                    }catch (Exception a){
                        JOptionPane.showMessageDialog(null," INGRESE SOLO DATOS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);  // mensaje de error cunado el usuario ingrese variables no aceptados
                        v=1;
                        pos--;
                        return;
                    }
                }while (v !=0 ); // final de la validacion
            }
        });
        JButton botonEliminar = new JButton(); // creamos el boton de eliminar
        botonEliminar.setBounds(260, 95, 50, 30); // Establecemos el tamaño y la posicion
        ImageIcon eliminar = new ImageIcon("Eliminar.png"); //Agremos un imagen de icono al boton
        botonEliminar.setIcon(new ImageIcon(eliminar.getImage().getScaledInstance(botonEliminar.getWidth(), botonEliminar.getHeight(), Image.SCALE_SMOOTH )));// Insertamos la imagen dentro del boton, colocando la escala de la imagen
        panel.add(botonEliminar); //Agregamos el nuevo boton eliminar al panel
        botonEliminar.addActionListener(new ActionListener(){ //establecemos la accion listener para el boton de eliminar
            public void actionPerformed(ActionEvent e){
                areaText.setText(""); // creamos un area de texto sin descripcion para limpiar el area de texto
                if (esVacia()) // hacemos la comparacion, si es vacia
                    JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mostramos un mensaje de que la lista esta vacia
                else{ // si no es vacia, entonces eliminamos el primer dato de la pila
                    Primero = Primero.getEnlace();
                    pos++;
                    JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // mensaje cuando el dato se haya insertado correctamente
                }
            }
        });
        JButton botonListar = new JButton(); //Creamos el boton para listar los datos de la pila
        botonListar.setBounds(260, 150, 50, 30); // Establecemos el tamaño y la posicion
        ImageIcon listar = new ImageIcon("Listar.png"); //Agremos un imagen de icono al boton
        botonListar.setIcon(new ImageIcon(listar.getImage().getScaledInstance(botonListar.getWidth(), botonListar.getHeight(), Image.SCALE_SMOOTH)));// Insertamos la imagen dentro del boton, colocando la escala de la imagen
        panel.add(botonListar); //Agregamos el nuevo boton Listar al panel
        botonListar.addActionListener(new ActionListener(){ //establecemos la accion listener para el boton de eliminar
            public void actionPerformed(ActionEvent e){
                areaText.setText(""); // creamos un area de texto sin descripcion para limpiar el area de texto
                if (esVacia()) // hacemos la comaracion, si es vacia
                    JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE);// mostramos un mensaje de que la pila esta vacia
                else{ // si no es vacia, entonces listamos todos lo datos disponibles en la pila
                    Nodo n;
                    n=Primero;
                    int a=1; // creamos una variable para la posicion
                    while (n!=null){ // mostramos el valor del dato y la direccion de memoria en la que se encuentra
                        areaText.append("   POSICION [" + a +"],                       DATO = "+ n.getInfo() + ",                          DIRECCION : "+ n.getEnlace() + "\n");
                        areaText.append("\n");
                        n=n.getEnlace();
                        a++;
                    }
                    JOptionPane.showMessageDialog(null, "  LISTADO TERMINADO "); // mensaje cuando el listado hay terminado
                }
            }
        });
        JButton botonTamanio = new  JButton(); //creamos el botn para saber el tamaño de la pila
        botonTamanio.setBounds(260, 210, 50, 30); // Establecemos el tamaño y la posicion
        ImageIcon tamanio = new ImageIcon("Tamanio.png"); //Agremos un imagen de icono al boton
        botonTamanio.setIcon(new ImageIcon(tamanio.getImage().getScaledInstance(botonTamanio.getWidth(), botonTamanio.getHeight(), Image.SCALE_SMOOTH)));// Insertamos la imagen dentro del boton, colocando la escala de la imagen
        panel.add(botonTamanio); //Agregamos el nuevo boton Tamanio al panel
        botonTamanio.addActionListener(new ActionListener(){ //establecemos la accion listener para el boton de Tamanio
            public void actionPerformed(ActionEvent e){
                areaText.setText(""); // creamos un area de texto sin descripcion para limpiar el area de texto
                if (esVacia()) // Hacemos la comparacion de si es vacia
                    JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // si si es vacia, mostramos el mensaje de que la pila esta vacia
                else{ // si no
                    JOptionPane.showMessageDialog(null, " LA LONGITUD DE LA PILA ES DE : "+ pos); // mostramos la longitud de la pila.
                    return;
                }
            }
        });
        JButton botonSalir = new JButton(); //Creamos el boton para salir del programa
        botonSalir.setBounds(260, 265, 50, 30);  // Establecemos el tamaño y la posicion
        ImageIcon salir = new ImageIcon("Salir.png"); //Agremos un imagen de icono al boton
        botonSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_SMOOTH)));// Insertamos la imagen dentro del boton, colocando la escala de la imagen
        panel.add(botonSalir);  //Agregamos el nuevo boton salir al panel
        botonSalir.addActionListener(new ActionListener(){ //establecemos la accion listener para el boton de salir
            public void actionPerformed(ActionEvent e){
                System.exit(WIDTH); // Establecemos la accion del boton para salir del programa con .exit
            }
        });
    }
    public static void main(String[] args){
        PilasDinamicas Pd = new PilasDinamicas(); //  creamos una nueva ventana
        Pd.Ventanagrafica(); // LLamamos la estancia de Ventana grafica donde se encuentran toda nuestra estructura y funciones
    }
}