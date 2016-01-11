package com.iteiffel.ece.b3.dwm.TPGraph.interfaces;

import javax.swing.JComboBox;

/**
 * @author Roman
 *
 */
public class ComboItem {
	
    private String value;
    private String text;

    public ComboItem(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return text;
    }
    
    
    public static void main (String [] args){
    	
    	ComboItem item = new ComboItem ("value1","text1");   	
    	JComboBox<ComboItem> cbx= new JComboBox<ComboItem> ();
    	cbx.addItem(item);
        cbx.setSelectedIndex(0);
        
        ComboItem it = (ComboItem) cbx.getSelectedItem();
        System.out.println(it.getValue() + it.getText());
    }
    
    
}
