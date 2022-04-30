/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abscence.org.hibernate;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

/**
 *
 * @author DABANTI
 */
public class utile {
    public static HttpSession getSession()
    {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
     public static HttpSession getRequest()
    {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
}
