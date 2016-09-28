/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.tests;
import edu.eci.pdsw.samples.services.*;
import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Losada
 */
/**
 * CLASE 1: El comentario tiene asociado un usuario,
 * y es agregado correctamente.
 * Falla: No
 * Nombre: ComentarioAgregadoExitoso
 * 
 * CLASE 2: El comentario no tiene asociado un un usuario,
 * y no es agregado correctamente.
 * Falla: Si
 * Nombre: ComentarioNoAgregado
 * 
 * 
 * CLASE 3: El usuario que agrega el comentario tiene la
 * fecha actual
 * Frontera: No
 * Falla: No
 * Nombre: ComentarioFechaActual
 * 
 * CLASE 4: El usuario que agrega el comentario tiene una
 * fecha menor a la actual
 * Frontera: No
 * Falla: Si
 * Nombre: ComentarioFechaInvallida
 * 
 * 
 **/
public class ComentariosTest {
    
    @Test
    public void EntradaAlForo(){
       Usuario persona = new Usuario("felipe.losada@gmail.com","Felipe");
       Comentario comentarioAgregado = new Comentario(persona,"Esta muy chebre",new java.sql.Date(2016,9,28));
       try{
           EntradaForo Ef = new EntradaForo(80, persona, comentarioAgregado.getContenido(), "Experiencia", new java.sql.Date(2016,9,28));
           ServiciosForoStub sft = new ServiciosForoStub();
           sft.registrarNuevaEntradaForo(Ef);
           EntradaForo x = sft.consultarEntradaForo(80);
           assertEquals("No consulta comentario agregado correctamente",x.getIdentificador(),Ef.getIdentificador());
       }catch(ExcepcionServiciosForos ex){
           fail("Arroja excepcion agregando consultando entrada al foro");
       }
    }
}

