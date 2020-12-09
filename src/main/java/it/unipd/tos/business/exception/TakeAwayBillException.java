////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception{
 
    private static final long serialVersionUID = 1L;
    String err;
    
    public TakeAwayBillException (String a) {
        this.err = a;
    }
    
}
