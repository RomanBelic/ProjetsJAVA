package com.iteiffel.ece.b3.dwm.TPGraph.interfaces;
import javax.swing.JTextField;
import javax.swing.text.*;

/**
 * A JTextField that accepts only integers.
 *
 * @author David Buzatto
 */

public class IntegerField extends JTextField {

private static final long serialVersionUID = 1L;

private static int lim;
	    
	    public IntegerField( int lim, int cols ) {
	        super(cols);
	        IntegerField.lim = lim; 
	    }

	    @Override
	    protected Document createDefaultModel() {
	        return new UpperCaseDocument();
	    }

	    static class UpperCaseDocument extends PlainDocument {

	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public void insertString( int offs, String str, AttributeSet a ) throws BadLocationException {

	            if ( str == null ) {
	                return;
	            }

	            char[] chars = str.toCharArray();
	          
	            boolean ok = true;

	            for ( int i = 0; i < chars.length; i++ ) {
	                try {
	                    Integer.parseInt( String.valueOf( chars[i] ) );
	                } catch ( NumberFormatException exc ) {
	                    ok = false;
	                    break;
	                }


	            }
	            

	            if ( ok  && super.getLength() < IntegerField.getLim())
	                super.insertString( offs, new String( chars ), a );
	            }


	        }
	    
		public static int getLim() {
			return IntegerField.lim;
		}

		public void setLim(int lim) {
			IntegerField.lim = lim;
		}
	}

