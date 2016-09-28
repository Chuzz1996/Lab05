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

import edu.eci.pdsw.samples.services.*;
import edu.eci.pdsw.samples.entities.*;
import java.util.*;
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
       
    @Test
    public void registrarNuevaEntradaForoDebeFuncionar() throws ExcepcionServiciosForos{
       Usuario persona = new Usuario("johan9106@gmail.com","Johan");
       Date date =new Date(2010,6,27);
       EntradaForo entradaForo = new EntradaForo(12,persona,"No me gusta","Opinion",date);
       ServiciosForoStub foros = new ServiciosForoStub();
       foros.registrarNuevaEntradaForo(entradaForo);
       assertEquals(foros.consultarEntradaForo(0).getTitulo(),"Opinion");
       assertEquals(foros.consultarEntradaForo(0).getAutor(),persona);
       assertEquals(foros.consultarEntradaForo(0).getComentario(),"No me gusta");
    }
    
    @Test
    public void registrarNuevaEntradaForoDebeFallar() throws ExcepcionServiciosForos{
       Usuario persona = new Usuario();
       Date date =new Date(2010,6,27);
       EntradaForo entradaForo = new EntradaForo(12,persona,"No me gusta","Opinion",date);
       ServiciosForoStub foros = new ServiciosForoStub();
       foros.registrarNuevaEntradaForo(entradaForo);
       assertEquals(foros.consultarEntradaForo(0).getTitulo(),"Opinion");
       assertEquals(foros.consultarEntradaForo(0).getAutor(),persona);
       assertEquals(foros.consultarEntradaForo(0).getComentario(),"No me gusta");
    }
    
    @Test
    public void consultarEntradasForoDebeDevolverTodasLasEntradas() throws ExcepcionServiciosForos{
       Usuario persona = new Usuario();
       Date date =new Date(2010,6,27);
       EntradaForo entradaForo = new EntradaForo(12,persona,"No me gusta","Opinion",date);
       ServiciosForoStub foros = new ServiciosForoStub();
       foros.registrarNuevaEntradaForo(entradaForo);
       List<EntradaForo> temp =new ArrayList<EntradaForo>();
       List<EntradaForo> temp2 =new ArrayList<EntradaForo>();
       temp=foros.consultarEntradasForo();
       temp2.add(entradaForo);
       assertEquals(temp.size(),temp2.size());
    } 
    
      @Test
    public void agregarRespuestaForoDebeFallar() throws ExcepcionServiciosForos{
        Usuario persona = new Usuario();
       Date date =new Date(2010,6,27);
       EntradaForo entradaForo = new EntradaForo(12,persona,"No me gusta","Opinion",date);
       ServiciosForoStub foros = new ServiciosForoStub();
       foros.registrarNuevaEntradaForo(entradaForo);
       
       try{
           Comentario c = new Comentario(persona,"Esta muy chebre",new java.sql.Date(2016,9,28));
           foros.agregarRespuestaForo(0, c);
           fail("No Arroja excepcion agregando respuestas al foro sin usuario");
       }catch(ExcepcionServiciosForos ex){
           
       }
    } 
    
}
