package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* TariffConfig commands (version 1) */
public enum TariffConfigCommand implements com.zwavepublic.zwaveip.commands.Command {
    TARIFF_TBL_REMOVE(0x03),
    TARIFF_TBL_SET(0x02),
    TARIFF_TBL_SUPPLIER_SET(0x01);

    private static final HashMap<Integer, TariffConfigCommand> _map = new HashMap<Integer, TariffConfigCommand>(3);
    static {
        for (TariffConfigCommand value: TariffConfigCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private TariffConfigCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static TariffConfigCommand valueOf(int intValue) {
        TariffConfigCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TariffConfigCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

