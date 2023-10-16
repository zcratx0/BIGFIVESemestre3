package funcionalidades;

import javax.naming.InitialContext;
import javax.swing.JComboBox;

import com.bigfive.beans.ITRBeanRemote;

public class DAOITR {
	private static DAOITR instance = new DAOITR();
	private ITRBeanRemote itrBean;

	public static DAOITR getInstance() {
		return instance;
	}
	
	public DAOITR() {
		try {
			setItrBean((ITRBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/ITRBean!com.bigfive.beans.ITRBeanRemote"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ITRBeanRemote getItrBean() {
		return itrBean;
	}

	public void setItrBean(ITRBeanRemote itrBean) {
		this.itrBean = itrBean;
	}
	public void cargarComboBox(JComboBox cb) {
		try {
			itrBean.listarElementos().forEach(t -> {
				cb.addItem(t);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	public void cargarComboBoxHabilitado(JComboBox cb) {
		try {
			itrBean.listarElementosHabilitados().forEach(t -> {
				cb.addItem(t);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}
