package nl.bsoft.services;

/**
 * Created by bvpelt on 4/17/17.
 */
public class FunUpdateResult {

    private int numObjectsRead;
    private int numObjectsWritten;
    private int numObjectsUpdated;
    private int status; // -1 error, 0 success

    public int getNumObjectsRead() {
        return numObjectsRead;
    }

    public void setNumObjectsRead(int numObjectsRead) {
        this.numObjectsRead = numObjectsRead;
    }

    public int getNumObjectsWritten() {
        return numObjectsWritten;
    }

    public void setNumObjectsWritten(int numObjectsWritten) {
        this.numObjectsWritten = numObjectsWritten;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumObjectsUpdated() {
        return numObjectsUpdated;
    }

    public void setNumObjectsUpdated(int numObjectsUpdated) {
        this.numObjectsUpdated = numObjectsUpdated;
    }
}
