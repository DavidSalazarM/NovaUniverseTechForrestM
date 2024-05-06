package co.edu.unbosque.view;



import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;

public class View  {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregar ventanaAgregarCancion;
	private VentanaAgregar ventanaagregarComercial;
	private VentanaAgregar ventanaAgregarLocucion;
	private VentanaEliminar ventanaEliminar;
	private VentanaEliminar ventanaEliminarComercial;
	private VentanaEliminar ventanaEliminarLocucion;
	private VentanaModificar ventanaModificar;
	private VentanaModificar ventanaModificarComercial;
	private VentanaModificar ventanaModificarLocucion;
	private VentanaTrasmitir ventanaTrasmitir;
	private VentanaAntiguaTrasmisones ventanaAntiguaTrasmisones;
	
    
	public View(Controller controller) {
		 ventanaPrincipal = new VentanaPrincipal(); 
		 // ventanas Agregar 
		 ventanaAgregarCancion = new VentanaAgregar(new PanelAMCancion());
		 ventanaagregarComercial = new VentanaAgregar(new PanelAgregarComercial());
		 ventanaAgregarLocucion = new VentanaAgregar(new PanelAgregarLocucion());
		 //ventana eliminar
		 ventanaEliminar = new VentanaEliminar(new PanelEliminar());
		 ventanaEliminarComercial = new VentanaEliminar(new PanelEliminarComercial());
		 ventanaEliminarLocucion = new VentanaEliminar(new PanelEliminarLocucion());
		 
		 
		 //ventnamodificar
		 ventanaModificar= new VentanaModificar(new PanelModificar());
		 ventanaModificarComercial= new VentanaModificar(new PanelModificarComercial());
		 ventanaModificarLocucion= new VentanaModificar(new PanelModificarLocucion());
		 
		 ventanaTrasmitir= new VentanaTrasmitir();
	


	}
	public VentanaPrincipal mostrarVentanaPrincipal(Controller controller) {
	   
	    
	    //  ActionListener a los botones  panel superior 
	    ventanaPrincipal.getPanelSuperior().getAgregarCancion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getEliminarCancion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getModificarCancion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getAgregarComercial().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getEliminarComercial().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getModificarComercial().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getAgregarLocucion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getEliminarLocucion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getModificarLocucion().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getNuevaParilla().addActionListener(controller);
	    ventanaPrincipal.getPanelSuperior().getDetener().addActionListener(controller);
	    
	    
	    //  ActionListener a los botones  panel inferior 
	    ventanaPrincipal.getPanelInferior().getButPlay().addActionListener(controller);
	    ventanaPrincipal.getPanelInferior().getButAdelante().addActionListener(controller);

	    return ventanaPrincipal;
	}
	
	public VentanaAgregar mostrarAgregarCancion(Controller controller) {
		ventanaAgregarCancion.getPanelCancion().getElegirCancion().addActionListener(controller);
		ventanaAgregarCancion.getPanelCancion().getAgregar().addActionListener(controller);
		return ventanaAgregarCancion;
	}
	
	public VentanaAgregar mostrarAgregarComercial(Controller controller) {
		ventanaagregarComercial.getPanelComercial().getElegirCancion().addActionListener(controller);
		ventanaagregarComercial.getPanelComercial().getAgregar().addActionListener(controller);
		return ventanaagregarComercial;
	}
	
	public VentanaAgregar mostrarAgregarLocucion(Controller controller) {
		ventanaAgregarLocucion.getPanelLocucion().getElegirCancion().addActionListener(controller);
		ventanaAgregarLocucion.getPanelLocucion().getAgregar().addActionListener(controller);
		return ventanaAgregarLocucion;
	}
	
	public  VentanaEliminar mostrarVentanaEliminar(Controller controller) {
		ventanaEliminar.getPanelEliminarCancion().getBotonBuscar().addActionListener(controller);
		ventanaEliminar.getPanelEliminarCancion().getBotonEliminar().addActionListener(controller);
		return ventanaEliminar;
	}
	
	public  VentanaEliminar mostrarVentanaEliminarComercial(Controller controller) {
		ventanaEliminarComercial.getPanelEliminarComercial().getBotonBuscar().addActionListener(controller);
		ventanaEliminarComercial.getPanelEliminarComercial().getBotonEliminar().addActionListener(controller);
		return ventanaEliminarComercial;
	}
	
	public  VentanaEliminar mostrarVentanaEliminarLocucion(Controller controller) {
		ventanaEliminarLocucion.getPanelEliminarLocucion().getBotonBuscar().addActionListener(controller);
		ventanaEliminarLocucion.getPanelEliminarLocucion().getBotonEliminar().addActionListener(controller);
		return ventanaEliminarLocucion;
	}
	
	
	
	public VentanaModificar  ventanaModificar(Controller controller) {
		ventanaModificar.getPanelModificar().getButBuscar().addActionListener(controller);
		ventanaModificar.getPanelModificar().getButModificar().addActionListener(controller);

		return ventanaModificar;
		
	}
	public VentanaModificar  ventanaModificarComercial(Controller controller) {
		ventanaModificarComercial.getPanelModificarComercial().getButBuscar().addActionListener(controller);
		ventanaModificarComercial.getPanelModificarComercial().getButModificar().addActionListener(controller);

		
		return ventanaModificarComercial;
		
	}
	public VentanaModificar  ventanaModificarLocucion(Controller controller) {
		ventanaModificarLocucion.getPanelModificarLocucion().getButBuscar().addActionListener(controller);
		ventanaModificarLocucion.getPanelModificarLocucion().getButModificar().addActionListener(controller);
		
		return ventanaModificarLocucion;
		
	}
	public VentanaTrasmitir mostraVentanaTrasmitir(Controller controller) {
		ventanaTrasmitir.getTrasmitir().addActionListener(controller);
		return ventanaTrasmitir;
	}
	public VentanaAntiguaTrasmisones mostraAntiguaTrasmisiones(Controller controller) {
		ventanaAntiguaTrasmisones.getElegir().addActionListener(controller);
		return ventanaAntiguaTrasmisones;
	}
	
	

	public VentanaEliminar getVentanaEliminar() {
		return ventanaEliminar;
	}
	public void setVentanaEliminar(VentanaEliminar ventanaEliminar) {
		this.ventanaEliminar = ventanaEliminar;
	}
	public void mostrarPanatalla(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public VentanaAgregar getVentanaAgregarCancion() {
		return ventanaAgregarCancion;
	}
	public void setVentanaAgregarCancion(VentanaAgregar ventanaAgregarCancion) {
		this.ventanaAgregarCancion = ventanaAgregarCancion;
	}
	public VentanaModificar getVentanaModificar() {
		return ventanaModificar;
	}
	public void setVentanaModificar(VentanaModificar ventanaModificar) {
		this.ventanaModificar = ventanaModificar;
	}
	public VentanaAgregar getVentanaagregarComercial() {
		return ventanaagregarComercial;
	}
	public void setVentanaagregarComercial(VentanaAgregar ventanaagregarComercial) {
		this.ventanaagregarComercial = ventanaagregarComercial;
	}
	public VentanaAgregar getVentanaAgregarLocucion() {
		return ventanaAgregarLocucion;
	}
	public void setVentanaAgregarLocucion(VentanaAgregar ventanaAgregarLocucion) {
		this.ventanaAgregarLocucion = ventanaAgregarLocucion;
	}
	public VentanaEliminar getVentanaEliminarComercial() {
		return ventanaEliminarComercial;
	}
	public void setVentanaEliminarComercial(VentanaEliminar ventanaEliminarComercial) {
		this.ventanaEliminarComercial = ventanaEliminarComercial;
	}
	public VentanaEliminar getVentanaEliminarLocucion() {
		return ventanaEliminarLocucion;
	}
	public void setVentanaEliminarLocucion(VentanaEliminar ventanaEliminarLocucion) {
		this.ventanaEliminarLocucion = ventanaEliminarLocucion;
	}
	public VentanaModificar getVentanaModificarComercial() {
		return ventanaModificarComercial;
	}
	public void setVentanaModificarComercial(VentanaModificar ventanaModificarComercial) {
		this.ventanaModificarComercial = ventanaModificarComercial;
	}
	public VentanaModificar getVentanaModificarLocucion() {
		return ventanaModificarLocucion;
	}
	public void setVentanaModificarLocucion(VentanaModificar ventanaModificarLocucion) {
		this.ventanaModificarLocucion = ventanaModificarLocucion;
	}
	public VentanaTrasmitir getVentanaTrasmitir() {
		return ventanaTrasmitir;
	}
	public void setVentanaTrasmitir(VentanaTrasmitir ventanaTrasmitir) {
		this.ventanaTrasmitir = ventanaTrasmitir;
	}
	public VentanaAntiguaTrasmisones getVentanaAntiguaTrasmisones() {
		return ventanaAntiguaTrasmisones;
	}
	public void setVentanaAntiguaTrasmisones(VentanaAntiguaTrasmisones ventanaAntiguaTrasmisones) {
		this.ventanaAntiguaTrasmisones = ventanaAntiguaTrasmisones;
	}

	
	
}
