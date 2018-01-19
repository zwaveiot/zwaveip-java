package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* TariffConfig commands (version 1) */
public enum TariffConfigCommand implements Command {
    TARIFF_TBL_REMOVE((byte)0x03),
    TARIFF_TBL_SET((byte)0x02),
    TARIFF_TBL_SUPPLIER_SET((byte)0x01);

    private static final HashMap<Byte, TariffConfigCommand> _map = new HashMap<Byte, TariffConfigCommand>(3);
    static {
        for (TariffConfigCommand value: TariffConfigCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private TariffConfigCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static TariffConfigCommand valueOf(byte byteValue) {
        TariffConfigCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static TariffConfigCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

