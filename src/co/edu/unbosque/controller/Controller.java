package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.model.PlaylistModel;
import co.edu.unbosque.model.exceptions.AudioException;
import co.edu.unbosque.model.persistencia.BinariosFile;
import co.edu.unbosque.model.persistencia.CancionDAO;
import co.edu.unbosque.model.persistencia.CancionDTO;
import co.edu.unbosque.model.persistencia.ComercialDTO;
import co.edu.unbosque.model.persistencia.LocucionDTO;
import co.edu.unbosque.model.persistencia.PlaylistDAO;
import co.edu.unbosque.model.persistencia.PlaylistDTO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private Fachada fachada;
	private View vista;
	private java.io.File archivo;
	private boolean seguir;
	private Reproductor repo;
	private PlaylistModel play;
	private  Random random;

	public Controller() {
		play = new PlaylistModel();
		repo = new Reproductor();
		vista = new View(this);
		fachada = new Fachada();
		bibliotecaCanciones();
		bibliotecaComerciales();
		bibliotecaLocucion();
		bibliotecaPlaylist();
		vista.mostrarVentanaPrincipal(this).setVisible(true);
		random = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		
		// Boton ajusted de auido- opcion Agregar Canción
		
		// si en la ventana princincipal el usario da clic en agregar canción
		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getAgregarCancion())) {
			// se muestra la ventana de agregar cancion
			vista.mostrarAgregarCancion(this).setVisible(true);
			;
			// se inabilita ventaprincipal, paar que el user no interactue con ventana
			// principal miestras ventana agregar cancion esta abierta
			vista.getVentanaPrincipal().setEnabled(false);

		} 
		
		// Opcion Agregar Canción -Boton elegir canción
		
		// si en la ventana agrgar el usario da clic en elegir canción
		if (evento.getSource().equals(vista.getVentanaAgregarCancion().getPanelCancion().getElegirCancion())) {
			// se mostrara en panatalla el string de escoger audio( que hace lo que su
			// nombre indica, escoger los archivos mp3)
			vista.mostrarPanatalla(escogerAudio());

		}
		// Opcion Agregar Canción -Boton agregar canción
		
		if (evento.getSource().equals(vista.getVentanaAgregarCancion().getPanelCancion().getAgregar())) {
			String cancion = vista.getVentanaAgregarCancion().getPanelCancion().getNombreCancion().getText();
			String artista = vista.getVentanaAgregarCancion().getPanelCancion().getTituloArtista().getText();

			// el string entre parentesis vuleve string lo del Jcombox
			String genero = (String) vista.getVentanaAgregarCancion().getPanelCancion().getGenero().getSelectedItem();

			// Si seguir es verdadero,cancion y artista no están vacíos, y genero es
			// diferente a "Elija un genero "
			if (seguir && !cancion.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String mensaje = fachada.getBinarios().guardaAudios(this.archivo, 0);
				if (mensaje.equals("ok")) {
					fachada.getCancion().agregarCancion(
							new CancionDTO(cancion, artista, genero, fachada.getBinarios().getRutaFinal()));
					fachada.crearPropiedadesCanciones();
				} else {
					vista.mostrarPanatalla(mensaje);
				}

			} else {

				vista.mostrarPanatalla("Casillas si rellenar o sin seleccionar");
			}
			
			vista.mostrarPanatalla("Se guardo la canción correctamente");
			bibliotecaCanciones();
		}
		
		
		// Boton ajuste de audios -Opcion eliminar  Canción 

		// si en la ventana princincipal el usario da clic en eliminar canción

		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getEliminarCancion())) {
			vista.mostrarVentanaEliminar(this).setVisible(true);

			// se inabilita ventaprincipal, paar que el user no interactue con ventana
			// principal miestras ventana agregar cancion esta abierta
			vista.getVentanaPrincipal().setEnabled(false);
		}
		
		// Opcion eliminar  Canción - boton buscar

		if (evento.getSource().equals(vista.getVentanaEliminar().getPanelEliminarCancion().getBotonBuscar())) {
			// se crea y leen propiedades de cancion
			fachada.crearPropiedadesCanciones();
			fachada.getPropiedades().leerPropiedades(1);
			// se obtinee la listas de canciones actuales
			String[] listaCancionActualizada = fachada.getPropiedades().getLinea();
			// se obtine el nombre de la canción a eliminar
			String nombreIngresado = vista.getVentanaEliminar().getPanelEliminarCancion().getNombreCancion().getText();
			// se envia las canciones
			vista.getVentanaEliminar().getPanelEliminarCancion().listaCanciones(listaCancionActualizada);
			// se busca el indice de la cancion y se muestra en el panel
			vista.getVentanaEliminar().getPanelEliminarCancion().buscarCancion(nombreIngresado);

		}
		
		// Opcion eliminar  Canción - boton eliminar
		
		// si da clic en el boton eliminar de la ventana Eliminar , panel eliminar
		// cancion
		if (evento.getSource().equals(vista.getVentanaEliminar().getPanelEliminarCancion().getBotonEliminar())) {
			// obtiene la cantidad de canciones que hay y se crea un array con ese tamaño
			int cantidadSeleccionada = vista.getVentanaEliminar().getPanelEliminarCancion().getjList()
					.getSelectedValuesList().size();
			String[] borrar = new String[cantidadSeleccionada];
			// se llena los espacios de borrar
			borrar = vista.getVentanaEliminar().getPanelEliminarCancion().getjList().getSelectedValuesList()
					.toArray(borrar);

			// obtenemos la lista canciones en el properties
			String[] listaCancionActualizada = fachada.getPropiedades().getLinea();

			// bucle para eliminar cancion
			String clave = "";
			for (int i = 0; i < borrar.length; i++) {
				String nombre = borrar[i];
				for (int j = 0; j < listaCancionActualizada.length; j++) {
					if (listaCancionActualizada[j].startsWith(nombre)) {
						// se busca la clave de la canción usando las propiedades
						clave = fachada.getPropiedades().buscarClaveCancion(nombre, 1);

						String ruta = fachada.getCancion().buscarRuta(Integer.parseInt(clave));
						
						
						boolean error = fachada.getBinarios().eliminarAudio(ruta);

						// dependiendo si se borro o no se envia un mesaje al user
						if (error) {
							vista.mostrarPanatalla("Se borro la canción: " + nombre);
						} else {
							vista.mostrarPanatalla("No se pudo borrar la canción: " + nombre);
						}

					}
				}

			}
			fachada.getCancion().borrarCancion(Integer.parseInt(clave));
			bibliotecaCanciones();
		}
		
		//Boton ajueste de audio- Opcion modificar Canción

		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getModificarCancion())) {
			vista.ventanaModificar(this).setVisible(true);
			;

		}
		
		// Opcion modificar  Canción - boton buscar
		if (evento.getSource().equals(vista.getVentanaModificar().getPanelModificar().getButBuscar())) {
			fachada.crearPropiedadesCanciones();
			fachada.getPropiedades().leerPropiedades(1);
			// se obtinee la listas de canciones actuales
			String[] listaCancionActualizada = fachada.getPropiedades().getLinea();
			// se obtine el nombre de la canción a eliminar
			String nombreIngresado = vista.getVentanaModificar().getPanelModificar().getNombreCancion().getText();
			// se envia las canciones
			vista.getVentanaModificar().getPanelModificar().listaCanciones(listaCancionActualizada);
			// se busca el indice de la cancion y se muestra en el panel
			vista.getVentanaModificar().getPanelModificar().buscarCancion(nombreIngresado);
		}
		
		// Opcion modificar  Canción - boton modificar
		
		if (evento.getSource().equals(vista.getVentanaModificar().getPanelModificar().getButModificar())) {

			String cancion = vista.getVentanaModificar().getPanelModificar().getNuevoNombre().getText();
			String artista = vista.getVentanaModificar().getPanelModificar().getNuevoArtista().getText();
			boolean cancionExiste = false;
			// el string entre parentesis vuleve string lo del Jcombox
			String genero = (String) vista.getVentanaModificar().getPanelModificar().getNuevoGenero().getSelectedItem();

			// Si seguir es verdadero,cancion y artista no están vacíos, y genero es
			// diferente a "Elija un genero "
			String nombre = vista.getVentanaModificar().getPanelModificar().getjList().getSelectedValue();
			if (nombre != null && !nombre.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String clave = fachada.getPropiedades().buscarClaveCancion(nombre, 1);
				String ruta = fachada.getCancion().buscarRuta(Integer.parseInt(clave));

				// verificamos si ya existe
				String[] listaCancionActualizada = fachada.getPropiedades().getLinea();

				for (String cancionActual : listaCancionActualizada) {
					String[] partes = cancionActual.split("-");
					String nombreActual = partes[0];
					String artistaActual = partes[1];
					String generoActual = partes[2];
					// si cumple las condicoies error es igual a true
					if (nombreActual.equals(cancion) && artistaActual.equals(artista) && generoActual.equals(genero)) {

						cancionExiste = true;
						break;
					}
				}
				if (!cancionExiste) {
					fachada.getCancion().modificarCancion(Integer.parseInt(clave),
							new CancionDTO(cancion, artista, genero, ruta));
					fachada.crearPropiedadesCanciones();

				} else {
					vista.mostrarPanatalla("La canción ya existe en la lista.");
				}
			} else {
				vista.mostrarPanatalla("Casillas sin rellenar o sin seleccionar.");

			}
			
			vista.mostrarPanatalla("Se actualizo la canción correctamente");
			bibliotecaCanciones();
		}

		
		// Acccion para cuando se cierre la ventana modificar canción se habilte  ventana principal 
		vista.getVentanaModificar().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// si se cierra ventana agregar cancion se habilita nuevamente la venetana
				// principal
				vista.getVentanaPrincipal().setEnabled(true);

			}

		});
		
		// Acccion para cuando se cierre la ventana eliminar canción se habilte  ventana principal 

		vista.getVentanaEliminar().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// si se cierra ventana agregar cancion se habilita nuevamente la venetana
				// principal
				vista.getVentanaPrincipal().setEnabled(true);

			}

		});
		
		// Acccion para cuando se cierre la ventana agregar canción se habilte  ventana principal 
		vista.getVentanaAgregarCancion().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// si se cierra ventana agregar cancion se habilita nuevamente la venetana
				// principal
				vista.getVentanaPrincipal().setEnabled(true);

			}
		});

		// Comercial
		
		// Boton ajusted de auido- opcion Agregar comercial

		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getAgregarComercial())) {
			vista.mostrarAgregarComercial(this).setVisible(true);

			vista.getVentanaPrincipal().setEnabled(false);

		}
		// Opcion Agregar comercial -Boton elegir comercial
		
		if (evento.getSource().equals(vista.getVentanaagregarComercial().getPanelComercial().getElegirCancion())) {
			vista.mostrarPanatalla(escogerAudio());

		}
		// Opcion Agregar comercial -Boton agregar comercial
		
		if (evento.getSource().equals(vista.getVentanaagregarComercial().getPanelComercial().getAgregar())) {
			String cancion = vista.getVentanaagregarComercial().getPanelComercial().getNombreCancion().getText();
			String artista = vista.getVentanaagregarComercial().getPanelComercial().getTituloArtista().getText();

			String genero = (String) vista.getVentanaagregarComercial().getPanelComercial().getGenero()
					.getSelectedItem();

			if (seguir && !cancion.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String mensaje = fachada.getBinarios().guardaAudios(this.archivo, 1);
				if (mensaje.equals("ok")) {
					fachada.getComercial().agregarComercial(
							new ComercialDTO(cancion, artista, genero, fachada.getBinarios().getRutaFinal()));
					fachada.crearPropiedadesComercial();
				} else {
					vista.mostrarPanatalla(mensaje);
				}

			} else {

				vista.mostrarPanatalla("Casillas si rellenar o sin seleccionar");
			}
			vista.mostrarPanatalla("Se guardo el comercial correctamente");
			bibliotecaComerciales();
		}
		
		// Boton ajuste de audios -Opcion eliminar  comercial 
		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getEliminarComercial())) {
			vista.mostrarVentanaEliminarComercial(this).setVisible(true);
			vista.getVentanaPrincipal().setEnabled(false);
		}
		// Opcion eliminar  comercial - boton buscar
		if (evento.getSource()
				.equals(vista.getVentanaEliminarComercial().getPanelEliminarComercial().getBotonBuscar())) {
			fachada.crearPropiedadesComercial();
			fachada.getPropiedades().leerPropiedades(3);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaComercial();
			String nombreIngresado = vista.getVentanaEliminarComercial().getPanelEliminarComercial().getNombreCancion()
					.getText();
			vista.getVentanaEliminar().getPanelEliminarComercial().listaCanciones(listaCancionActualizada);
			vista.getVentanaEliminar().getPanelEliminarComercial().buscarCancion(nombreIngresado);

		}

		// Opcion eliminar  comercial - boton eliminar
		if (evento.getSource()
				.equals(vista.getVentanaEliminarComercial().getPanelEliminarComercial().getBotonEliminar())) {
			int cantidadSeleccionada = vista.getVentanaEliminar().getPanelEliminarComercial().getjList()
					.getSelectedValuesList().size();
			String[] borrar = new String[cantidadSeleccionada];
			borrar = vista.getVentanaEliminarComercial().getPanelEliminarComercial().getjList().getSelectedValuesList()
					.toArray(borrar);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaComercial();
			for (int i = 0; i < borrar.length; i++) {
				String nombre = borrar[i];
				for (int j = 0; j < listaCancionActualizada.length; j++) {
					if (listaCancionActualizada[j].startsWith(nombre)) {
						String clave = fachada.getPropiedades().buscarClaveCancion(nombre, 3);
						String ruta = fachada.getComercial().buscarRuta(Integer.parseInt(clave));
						boolean error = fachada.getBinarios().eliminarAudio(ruta);

						if (error) {
							vista.mostrarPanatalla("Se borro la canción: " + nombre);
						} else {
							vista.mostrarPanatalla("No se pudo borrar la canción: " + nombre);
						}

					}
				}

			}
			bibliotecaComerciales();
		}
		//Boton ajueste de audio- Opcion modificar comercial

		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getModificarComercial())) {
			vista.ventanaModificarComercial(this).setVisible(true);
			vista.getVentanaPrincipal().setEnabled(false);
			;
		}
		// Opcion modificar  comercial - boton buscar
		if (evento.getSource()
				.equals(vista.getVentanaModificarComercial().getPanelModificarComercial().getButBuscar())) {
			fachada.crearPropiedadesCanciones();
			fachada.getPropiedades().leerPropiedades(3);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaComercial();
			String nombreIngresado = vista.getVentanaModificarComercial().getPanelModificarComercial()
					.getNombreCancion().getText();
			vista.getVentanaModificarComercial().getPanelModificarComercial().listaCanciones(listaCancionActualizada);
			vista.getVentanaModificarComercial().getPanelModificarComercial().buscarCancion(nombreIngresado);
		}
		
		// Opcion modificar  comercial - boton modificar
		if (evento.getSource().equals(vista.getVentanaModificarComercial().getPanelModificarComercial().getButModificar())) {

			String cancion = vista.getVentanaModificarComercial().getPanelModificarComercial().getNuevoNombre()
					.getText();
			String artista = vista.getVentanaModificarComercial().getPanelModificarComercial().getNuevoArtista()
					.getText();
			boolean cancionExiste = false;
			String genero = (String) vista.getVentanaModificarComercial().getPanelModificarComercial().getNuevoGenero()
					.getSelectedItem();
			String nombre = vista.getVentanaModificarComercial().getPanelModificarComercial().getjList()
					.getSelectedValue();
			if (nombre != null && !nombre.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String clave = fachada.getPropiedades().buscarClaveCancion(nombre, 3);
				String ruta = fachada.getComercial().buscarRuta(Integer.parseInt(clave));
				String[] listaCancionActualizada = fachada.getPropiedades().getLineaComercial();
				for (String cancionActual : listaCancionActualizada) {
					String[] partes = cancionActual.split(";");
					String nombreActual = partes[0];
					String artistaActual = partes[1];
					String generoActual = partes[2];
					if (nombreActual.equals(cancion) && artistaActual.equals(artista) && generoActual.equals(genero)) {
						cancionExiste = true;
						break;
					}
				}
				if (!cancionExiste) {
					fachada.getComercial().modificarCancion(Integer.parseInt(clave),
							new ComercialDTO(nombre, artista, genero, ruta));
					fachada.crearPropiedadesComercial();

				} else {
					vista.mostrarPanatalla("La canción ya existe en la lista.");
				}
			} else {
				vista.mostrarPanatalla("Casillas sin rellenar o sin seleccionar.");

			}
			vista.mostrarPanatalla("Se actualizo el comercial correctamente");
			bibliotecaComerciales();
		}
		
		// Acccion para cuando se cierre la ventana modificar comercial se habilte  ventana principal 

		vista.getVentanaModificarComercial().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);
			}
		});
		// Acccion para cuando se cierre la ventana eliminar comercial se habilte  ventana principal 

		vista.getVentanaEliminarComercial().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);
			}
		});
		// Acccion para cuando se cierre la ventana agregar comercial se habilte  ventana principal 
		vista.getVentanaagregarComercial().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);

			}
		});

		// locucion
		
		// Boton ajusted de auido- opcion Agregar locucion

		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getAgregarLocucion())) {
			vista.mostrarAgregarLocucion(this).setVisible(true);

			vista.getVentanaPrincipal().setEnabled(false);

		}
		// Opcion Agregar locucion -Boton elegir locucion
		
		if (evento.getSource().equals(vista.getVentanaAgregarLocucion().getPanelLocucion().getElegirCancion())) {
			vista.mostrarPanatalla(escogerAudio());

		}
		// Opcion Agregar locucion -Boton agregar locucion
		
		if (evento.getSource().equals(vista.getVentanaAgregarLocucion().getPanelLocucion().getAgregar())) {
			String cancion = vista.getVentanaAgregarLocucion().getPanelLocucion().getNombreCancion().getText();
			String artista = vista.getVentanaAgregarLocucion().getPanelLocucion().getTituloArtista().getText();

			String genero = (String) vista.getVentanaAgregarLocucion().getPanelLocucion().getGenero().getSelectedItem();

			if (seguir && !cancion.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String mensaje = fachada.getBinarios().guardaAudios(this.archivo, 2);
				if (mensaje.equals("ok")) {
					fachada.getPodscast().agregarPodscast(
							new LocucionDTO(cancion, artista, genero, fachada.getBinarios().getRutaFinal()));
					fachada.crearPropiedadesPodscast();
				} else {
					vista.mostrarPanatalla(mensaje);
				}

			} else {

				vista.mostrarPanatalla("Casillas si rellenar o sin seleccionar");
			}
			vista.mostrarPanatalla("Se guardo la locución correctamente");
			bibliotecaLocucion();
		}
		

		// Boton ajuste de audios -Opcion eliminar  locucion 
		
		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getEliminarLocucion())) {
			vista.mostrarVentanaEliminar(this).setVisible(true);
			vista.getVentanaPrincipal().setEnabled(false);
		}
		// Opcion eliminar  locucion - boton buscar

		if (evento.getSource().equals(vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().getBotonBuscar())) {
			fachada.crearPropiedadesPodscast();
			fachada.getPropiedades().leerPropiedades(2);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaLocucion();
			String nombreIngresado = vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().getNombreCancion()
					.getText();
			vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().listaCanciones(listaCancionActualizada);
			vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().buscarCancion(nombreIngresado);
		}
		
		// Opcion eliminar  locucion - boton eliminar
		if (evento.getSource()
				.equals(vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().getBotonEliminar())) {
			int cantidadSeleccionada = vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().getjList()
					.getSelectedValuesList().size();
			String[] borrar = new String[cantidadSeleccionada];
			borrar = vista.getVentanaEliminarLocucion().getPanelEliminarLocucion().getjList().getSelectedValuesList()
					.toArray(borrar);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaLocucion();
			for (int i = 0; i < borrar.length; i++) {
				String nombre = borrar[i];
				for (int j = 0; j < listaCancionActualizada.length; j++) {
					if (listaCancionActualizada[j].startsWith(nombre)) {
						String clave = fachada.getPropiedades().buscarClaveCancion(nombre, 2);
						String ruta = fachada.getPodscast().buscarRuta(Integer.parseInt(clave));
						boolean error = fachada.getBinarios().eliminarAudio(ruta);
						if (error) {
							vista.mostrarPanatalla("Se borro la canción: " + nombre);
						} else {
							vista.mostrarPanatalla("No se pudo borrar la canción: " + nombre);
						}

					}
				}

			}

		}

		
		//Boton ajueste de audio- Opcion modificar locucion
		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getModificarLocucion())) {
			vista.ventanaModificarLocucion(this).setVisible(true);
			;

		}
		
		// Opcion modificar  locucion - boton buscar
		if (evento.getSource().equals(vista.getVentanaModificarLocucion().getPanelModificarLocucion().getButBuscar())) {
			fachada.crearPropiedadesPodscast();
			fachada.getPropiedades().leerPropiedades(2);
			String[] listaCancionActualizada = fachada.getPropiedades().getLineaLocucion();
			String nombreIngresado = vista.getVentanaModificarLocucion().getPanelModificarLocucion().getNombreCancion()
					.getText();
			vista.getVentanaModificarLocucion().getPanelModificarLocucion().listaCanciones(listaCancionActualizada);
			vista.getVentanaModificarLocucion().getPanelModificarLocucion().buscarCancion(nombreIngresado);
		}
		
		// Opcion modificar  locucion - boton modificar
		if (evento.getSource()
				.equals(vista.getVentanaModificarLocucion().getPanelModificarLocucion().getButModificar())) {

			String cancion = vista.getVentanaModificarLocucion().getPanelModificarLocucion().getNuevoNombre().getText();
			String artista = vista.getVentanaModificarLocucion().getPanelModificarLocucion().getNuevoArtista()
					.getText();
			boolean cancionExiste = false;
			String genero = (String) vista.getVentanaModificarLocucion().getPanelModificarLocucion().getNuevoGenero()
					.getSelectedItem();
			String nombre = vista.getVentanaModificarLocucion().getPanelModificarLocucion().getjList()
					.getSelectedValue();
			if (nombre != null && !nombre.isEmpty() && !artista.isEmpty() && !genero.equals("Elija un genero ")) {
				String clave = fachada.getPropiedades().buscarClaveCancion(nombre, 2);
				String ruta = fachada.getPodscast().buscarRuta(Integer.parseInt(clave));
				String[] listaCancionActualizada = fachada.getPropiedades().getLineaLocucion();

				for (String cancionActual : listaCancionActualizada) {
					String[] partes = cancionActual.split(";");
					String nombreActual = partes[0];
					String artistaActual = partes[1];
					String generoActual = partes[2];
					if (nombreActual.equals(cancion) && artistaActual.equals(artista) && generoActual.equals(genero)) {
						cancionExiste = true;
						break;
					}
				}
				if (!cancionExiste) {
					fachada.getPodscast().modificarPodscast(Integer.parseInt(clave),
							new LocucionDTO(nombre, artista, genero, ruta));
					fachada.crearPropiedadesPodscast();

				} else {
					vista.mostrarPanatalla("La canción ya existe en la lista.");
				}
			} else {
				vista.mostrarPanatalla("Casillas sin rellenar o sin seleccionar.");

			}
			vista.mostrarPanatalla("Se actualizo la canción correctamente");
		}
		
		// Acccion para cuando se cierre la ventana modificar locución se habilte  ventana principal 

		vista.getVentanaModificarLocucion().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);

			}

		});
		// Acccion para cuando se cierre la ventana eliminar locución se habilte  ventana principal 

		vista.getVentanaEliminarLocucion().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);
			}

		});
		
		// Acccion para cuando se cierre la ventana agregar locución se habilte  ventana principal 
		
		vista.getVentanaAgregarLocucion().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);

			}
		});
		
		// Boton Iniciar trasmision  - opcion Nueva progrmación
		if (evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getNuevaParilla())) {

			vista.mostraVentanaTrasmitir(this).setVisible(true);
			;
			vista.getVentanaPrincipal().setEnabled(false);
		}
		
		// Acccion para cuando se cierre la ventana Nueva progrmación se habilte  ventana principal 
		vista.getVentanaTrasmitir().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				vista.getVentanaPrincipal().setEnabled(true);
			}

		});
		
		
		// Opcion Nueva progrmación  -Boton eTrasmitir 
		
		if (evento.getSource().equals(vista.getVentanaTrasmitir().getTrasmitir())) {
			
			
			String nombre=vista.getVentanaTrasmitir().getNombretrasmision().getText();
		
			String modoTrasmision= (String)vista.getVentanaTrasmitir().getTipoTrasmision().getSelectedItem();
			if(!modoTrasmision.equals("Elija un modo de trasmisión")&& !nombre.equals("Digite el nombre de la transmición")&&!nombre.isEmpty()) {
				
				vista.getVentanaPrincipal().getPanelSuperior().getTitulo().setText(nombre);
				vista.getVentanaPrincipal().getPanelInferior().getTipoTrasmision().setText(modoTrasmision);;
				int indextipo = vista.getVentanaTrasmitir().getTipomusica().getSelectedIndex();
				int indexAnuncio =  vista.getVentanaTrasmitir().getCantidadAnuncio().getSelectedIndex();
				int numLocuciones = vista.getVentanaTrasmitir().getCantidadLocucion().getSelectedIndex();
				
				String genero = (String) vista.getVentanaTrasmitir().getTipomusica().getSelectedItem();
				String Anuncio= vista.getVentanaTrasmitir().getCantidadAnuncio().getItemAt(indexAnuncio);
				String locucion= vista.getVentanaTrasmitir().getCantidadLocucion().getItemAt(numLocuciones);

				if (!Anuncio.equals("Digite el nombre de la transmición")&& !locucion.equals("Elija cantidad de locuciones")&& !genero.equals("Elija un genero")) {
					
				
				
				int iteradorC=0;
				int iteradorL=0;
				ArrayList<Object> list = new ArrayList<Object>();	
								
				int numAnuncio = Integer.parseInt(Anuncio);
				int numLocucion = Integer.parseInt(locucion);
				
				

				ArrayList<CancionDTO> canciones= fachada.getBinarios().leerCancion();
				ArrayList<ComercialDTO> comerciales= fachada.getBinarios().leerComercial();
				ArrayList<LocucionDTO> locuiones= fachada.getBinarios().leerPodscast();
				
				for (Object obj: canciones){
					CancionDTO cancion = (CancionDTO) obj;

					
					if(iteradorC==numAnuncio){
						 int indiceAleatorio = random.nextInt(comerciales.size());
						 list.add(comerciales.get(indiceAleatorio));
						 iteradorC=0;
					}
					if(iteradorL==numLocucion){
						 int indiceAleatorio = random.nextInt(locuiones.size());
						 list.add(locuiones.get(indiceAleatorio));
						 iteradorL=0;
					}
					
					if (cancion.getGenero().equals(genero)){
						iteradorC++;
						iteradorL++;
						list.add(cancion);
					}
				} fachada.getPlaylist().agregarPlaylist(new PlaylistDTO(list));
				fachada.crearPropiedadesPlaylist();
				bibliotecaPlaylist();
				}else {
					vista.mostrarPanatalla("Faltan elegir datos");
				}
				
			}else {
				vista.mostrarPanatalla("Debe elegir un modo de trasmisión y nombre de emisora");
			}
			
			

			
			
		}

		
				
		
		//// Boton Detener trasmision 
		
		if(evento.getSource().equals(vista.getVentanaPrincipal().getPanelSuperior().getDetener())) {
			play.detener();
		
		}
		
	//// Boton Play
	     if(evento.getSource().equals(vista.getVentanaPrincipal().getPanelInferior().getButPlay())) {
				if(play.getReproduccionThread()==null) {
	    	   	ArrayList<PlaylistDTO> playlist= fachada.getBinarios().leerPlaylist();
	    	   	//aqui iria el indice del properties
	    	   	
	    	   	PlaylistDTO pista = playlist.get(playlist.size()-1);
				String[] urls = new String[pista.getListaAudios().size()] ;
				
				for(int i=0;i<pista.getListaAudios().size();i++) {
					
					Object objeto = pista.getListaAudios().get(i);
					
					  if (objeto instanceof CancionDTO) {
					        
						  CancionDTO audio = (CancionDTO) objeto;
					        urls[i] = audio.getUrl();
					    }
					  if (objeto instanceof ComercialDTO) {
					        
						  ComercialDTO audio = (ComercialDTO)objeto;
					        urls[i] = audio.getUrl();
					    }
					  if (objeto instanceof LocucionDTO) {
					       
						  LocucionDTO audio = (LocucionDTO)objeto;
					        urls[i] = audio.getUrl();
					    }
				}
				
				play .setListaSong(urls);
				
				play.setReproductor(repo);
				
				play.reproducir();}
				}
				

  //// Boton adelante
       if(evento.getSource().equals(vista.getVentanaPrincipal().getPanelInferior().getButAdelante())) {
    	   
    	   play.siguiente();
		}
		
		
		

	}

	public String escogerAudio() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtroMP3 = new FileNameExtensionFilter("Archivos MP3", "mp3");
		chooser.setFileFilter(filtroMP3);
		int escoger = chooser.showOpenDialog(null);

		try {
			if (escoger == JFileChooser.CANCEL_OPTION) {
				seguir = false;
				return "Selección de archivo cancelada";

			} else {
				archivo = chooser.getSelectedFile();
				if (escoger == JFileChooser.APPROVE_OPTION) {
					if (!archivo.getName().toLowerCase().endsWith(".mp3")) {
						throw new AudioException();
					}
				}
			}
		} catch (AudioException e) {
			seguir = false;
			return e.getMessage();

		} catch (Exception e) {
			seguir = false;
			return e.getMessage();
		}

		seguir = true;
		return "Se guardó la selección correctamente";
	}

	
	public void bibliotecaPlaylist(){
		fachada.crearPropiedadesPlaylist();
		fachada.getPropiedades().leerPropiedadesPlaylist();
		vista.getVentanaPrincipal().getPanelCentral().getGestorTablaDos().setRowCount(0);
		String[] lineas = fachada.getPropiedades().getLineaPlaylist();
		int i=1;
		
	    for (String linea : lineas) {
	    	
	        String[] partes = linea.split("-"); 
	        
	        if (partes.length == 3) { // Asegurarse de que hay 3 partes
	            String nombre = partes[0];
	            String artista = partes[1];
	            String genero = partes[2];
	            vista.getVentanaPrincipal().getPanelCentral().getGestorTablaDos().addRow(new Object[]{i++,nombre, artista, genero});
	        } else {
	            // Manejar caso de datos incorrectos
	        	vista.mostrarPanatalla("No se pudo leer las canciones");
	        }
			
		}
	}
	
	public void bibliotecaCanciones() {
	    
	    fachada.crearPropiedadesCanciones();
	    fachada.getPropiedades().leerPropiedades(1);
	    vista.getVentanaPrincipal().getPanelEste().getGestorTabla().setRowCount(0);
	    String[] lineas = fachada.getPropiedades().getLinea();
		int i=1;
	    for (String linea : lineas) {
	    
	        String[] partes = linea.split("-"); 
	        if (partes.length == 3) { // Asegurarse de que hay 3 partes
	            String nombre = partes[0];
	            String artista = partes[1];
	            String genero = partes[2];
	            vista.getVentanaPrincipal().getPanelEste().getGestorTabla().addRow(new Object[]{i++,nombre, artista, genero});
	        } else {
	            // Manejar caso de datos incorrectos
	        	vista.mostrarPanatalla("No se pudo leer las canciones");
	        }

	    }
	}
	
	public void bibliotecaComerciales() {
	    fachada.crearPropiedadesComercial();
	    fachada.getPropiedades().leerPropiedades(3);
	    vista.getVentanaPrincipal().getPanelOeste().getPanelOesteArriba().getGestorTablaDos().setRowCount(0);
	    String[] lineas = fachada.getPropiedades().getLineaComercial();
		int i=1;
	    for (String linea : lineas) {
	    
	        String[] partes = linea.split("-"); 
	        if (partes.length == 3) { // Asegurarse de que hay 3 partes
	            String nombre = partes[0];
	            String empresa = partes[1];
	            String tipo = partes[2];
	            
	           
	            vista.getVentanaPrincipal().getPanelOeste().getPanelOesteArriba().getGestorTablaDos().addRow(new Object[] {i++,nombre,empresa,tipo});
	        } else {
	            // Manejar caso de datos incorrectos
	        	vista.mostrarPanatalla("No se pudo leer los comerciales");
	        	
	        }

	    }
	}

	
	public void bibliotecaLocucion() {
	    fachada.getPodscast().getPropiedades();
	    fachada.crearPropiedadesPodscast();
	    fachada.getPropiedades().leerPropiedades(2);
	    vista.getVentanaPrincipal().getPanelOeste().getPanelOesteAbajo().getGestorTabla().setRowCount(0);
	    String[] lineas = fachada.getPropiedades().getLineaLocucion();
		int i=1;
	    for (String linea : lineas) {
	    
	        String[] partes = linea.split("-"); 
	        if (partes.length == 3) { // Asegurarse de que hay 3 partes
	            String nombre = partes[0];
	            String empresa = partes[1];
	            String tipo = partes[2];
	            
	            
	            vista.getVentanaPrincipal().getPanelOeste().getPanelOesteAbajo().getGestorTabla().addRow(new Object[] {i++,nombre,empresa,tipo});
	        } else {
	            // Manejar caso de datos incorrectos
	        	vista.mostrarPanatalla("No se pudo leer los comerciales");
	        	
	        }

	    }
	}

}
