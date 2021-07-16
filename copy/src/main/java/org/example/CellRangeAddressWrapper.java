package org.example;

import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @Author sunwei@finchina.com
 * @Date 2021/7/9 10:24
 * @Description
 **/

public class CellRangeAddressWrapper implements Comparable<CellRangeAddressWrapper> {

    private CellRangeAddress range;

    public CellRangeAddressWrapper(CellRangeAddress theRange) {
        this.range = theRange;
    }

    public int compareTo(CellRangeAddressWrapper craw) {
        if (range.getFirstColumn() < craw.range.getFirstColumn()
                && range.getFirstRow() < craw.range.getFirstRow()) {
            return -1;
        } else if (range.getFirstColumn() == craw.range.getFirstColumn()
                && range.getFirstRow() == craw.range.getFirstRow()) {
            return 0;
        } else {
            return 1;
        }
    }

    public CellRangeAddress getRange() {
        return range;
    }
}
