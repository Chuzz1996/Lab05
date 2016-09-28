/*
 * Copyright (C) 2015 hcadavid
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
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 * 
 * clases de equivalencia
 * 
 * clase1:si el comentario no tiene asociado un usuario
 * falla:si
 * nombre:registrarNuevaEntradaForoDebeFallar
 * 
 * clase2:si el comentario tiene asociado un usuario
 * falla:no
 * nombre:registrarNuevaEntradaForoDebeFuncionar
 */
public class EntradasForoTest {
    
    public EntradasForoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void registroPacienteTest(){
        
    }
    
    
        @Test
    public void ComentarioAgregadoExitoso() throws ExcepcionServiciosForos{
       Usuario persona = new Usuario("johan9106@gmail.com","Johan");
       Date date =new Date(2010,6,27);
       EntradaForo entradaForo = new EntradaForo(12,persona,"No me gusta","Opinion",date);
       ServiciosForoStub foros = new ServiciosForoStub();
       foros.registrarNuevaEntradaForo(entradaForo);
       assertEquals(foros.consultarEntradaForo(12).getTitulo(),"Opinion");
       assertEquals(foros.consultarEntradaForo(12).getAutor(),persona);
       assertEquals(foros.consultarEntradaForo(12).getComentario(),"No me gusta");
    }
    
}
