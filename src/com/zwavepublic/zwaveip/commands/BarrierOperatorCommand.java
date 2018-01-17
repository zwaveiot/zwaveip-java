package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* BarrierOperator commands (version 1) */
public enum BarrierOperatorCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03),
    SIGNAL_SUPPORTED_GET(0x04),
    SIGNAL_SUPPORTED_REPORT(0x05),
    SIGNAL_SET(0x06),
    SIGNAL_GET(0x07),
    SIGNAL_REPORT(0x08);

    private static final HashMap<Integer, BarrierOperatorCommand> _map = new HashMap<Integer, BarrierOperatorCommand>(8);
    static {
        for (BarrierOperatorCommand value: BarrierOperatorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private BarrierOperatorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static BarrierOperatorCommand valueOf(int intValue) {
        BarrierOperatorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BarrierOperatorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

