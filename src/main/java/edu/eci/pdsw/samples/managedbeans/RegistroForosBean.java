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
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe Losada
 */
@ManagedBean(name="RegistroBean")
@SessionScoped
public class RegistroForosBean implements Serializable{
    
    public static ServiciosForo sp=ServiciosForo.getInstance();
    
    private EntradaForo selectForo;
    
    public int ano;
    public int mes;
    public int idforo;

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
    public int dia;


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    public String comentario;
    public Usuario autor;
    
    
    public void setSp(ServiciosForo sp){
        this.sp = sp;
    }
    
    public List<EntradaForo> getSp(){
        try{
            return sp.consultarEntradasForo();
        }catch(ExcepcionServiciosForos ex){
            return null;
        }
    }
    
    public EntradaForo getSelectForo() {
        try{
            return sp.consultarEntradaForo(this.idforo);
        }catch(ExcepcionServiciosForos ex){
            return null;
        }
    }
    
    public void setSelectForo(EntradaForo selectedForo) {
        this.selectForo = selectedForo;
    }
    
    
}
