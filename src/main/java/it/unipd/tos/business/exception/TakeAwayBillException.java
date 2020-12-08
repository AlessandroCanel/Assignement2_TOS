////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception{
    String err;
    
    public TakeAwayBillException (String a) {
        this.err = a;
    }
    
}
