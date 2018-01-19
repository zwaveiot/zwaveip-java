package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* TariffTblMonitor commands (version 1) */
public enum TariffTblMonitorCommand implements Command {
    TARIFF_TBL_COST_GET((byte)0x05),
    TARIFF_TBL_COST_REPORT((byte)0x06),
    TARIFF_TBL_GET((byte)0x03),
    TARIFF_TBL_REPORT((byte)0x04),
    TARIFF_TBL_SUPPLIER_GET((byte)0x01),
    TARIFF_TBL_SUPPLIER_REPORT((byte)0x02);

    private static final HashMap<Byte, TariffTblMonitorCommand> _map = new HashMap<Byte, TariffTblMonitorCommand>(6);
    static {
        for (TariffTblMonitorCommand value: TariffTblMonitorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private TariffTblMonitorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static TariffTblMonitorCommand valueOf(byte byteValue) {
        TariffTblMonitorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TariffTblMonitorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

