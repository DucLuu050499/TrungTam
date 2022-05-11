package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Select_Custom extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Object arrValue[];

	public Select_Custom(String[] arrName, Object[] arrValue) {
		super();
		String[] temp = new String[arrName.length + 1];
		System.arraycopy(arrName, 0, temp, 1, arrName.length);
		temp[0] = " ";
		this.arrValue = arrValue;
		setModel(new DefaultComboBoxModel<String>(temp));
	}

	public Object[] getArrValue() {
		return arrValue;
	}

	public void setArrValue(Object[] arrValue) {
		this.arrValue = arrValue;
	}
	
	public Object getSelectedID() {
		if(getSelectedIndex() - 1 >= 0) {
			return arrValue[getSelectedIndex() - 1];
		}
		return -1;
	}
	public Object getSelectedIDBaiThi() {
		if(getSelectedIndex() >= 0) {
			return arrValue[getSelectedIndex()];
		}
		return -1;
	}
}
