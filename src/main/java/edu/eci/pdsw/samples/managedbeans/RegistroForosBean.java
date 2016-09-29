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
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import java.io.Serializable;
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
    
}
