package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* TariffTblMonitor commands (version 1) */
public enum TariffTblMonitorCommand implements com.zwavepublic.zwaveip.commands.Command {
    TARIFF_TBL_COST_GET(0x05),
    TARIFF_TBL_COST_REPORT(0x06),
    TARIFF_TBL_GET(0x03),
    TARIFF_TBL_REPORT(0x04),
    TARIFF_TBL_SUPPLIER_GET(0x01),
    TARIFF_TBL_SUPPLIER_REPORT(0x02);

    private static final HashMap<Integer, TariffTblMonitorCommand> _map = new HashMap<Integer, TariffTblMonitorCommand>(6);
    static {
        for (TariffTblMonitorCommand value: TariffTblMonitorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private TariffTblMonitorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static TariffTblMonitorCommand valueOf(int intValue) {
        TariffTblMonitorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TariffTblMonitorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

