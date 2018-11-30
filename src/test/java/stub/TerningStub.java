package stub;

import Model.Terning;

/**
 * terningStub
 */
public class TerningStub extends Terning {
    int testRes;

    public TerningStub(int testRes) {

    }

    @Override
    public int getResultat() {
        int testRes = this.testRes;
        return testRes;
    }
}