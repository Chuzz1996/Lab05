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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
/**
 * CLASE 1: El comentario tiene asociado un usuario
 * Falla: No
 * Nombre: ComentarioAgregado
 * 
 * CLASE 2: El comentario no tiene asociado un un usuario
 * Falla: Si
 * Nombre: ComentarioNoAgregado
 * 
 **/
public class ComentariosTest {
    
    public ComentariosTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void ComentarioAgregado(){
       Usuario persona = new Usuario("felipe.losada@gmail.com","Felipe");
       Comentario comentarioAgregado = new Comentario(persona,"Esta muy chebre",Date.getDate());
        assertEquals(persona, comentarioAgregado.getAutor());
        assertEquals("Esta muy chebre",cometarioAgregado.getComentario());
        assertEquals(Date.getDate(), comentarioAgregado.getFechayHora());
    }

    @Test
    public void ComentarioNoAgregado(){
        try{
            Comentario comentarioAgregado = new Comentario(null,"Esta muy chebre",Date.getDate());
        }catch(e ExcepcionServiciosForos){
            
        }
    }
    
}
