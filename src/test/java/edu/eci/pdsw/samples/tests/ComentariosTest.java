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

import edu.eci.pdsw.samples.entities.*;

import java.sql.Date;
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
    
    public ComentariosTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void ComentarioAgregadoExitoso(){
       Usuario persona = new Usuario("felipe.losada@gmail.com","Felipe");
       Date date =new Date(2010,6,27);
       Comentario comentarioAgregado = new Comentario(persona,"Esta muy chebre",date);
        assertEquals(persona, comentarioAgregado.getAutor());
        assertEquals("Esta muy chebre",comentarioAgregado.getContenido());

    }
    }

