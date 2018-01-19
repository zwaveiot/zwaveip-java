package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* BarrierOperator commands (version 1) */
public enum BarrierOperatorCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03),
    SIGNAL_SUPPORTED_GET((byte)0x04),
    SIGNAL_SUPPORTED_REPORT((byte)0x05),
    SIGNAL_SET((byte)0x06),
    SIGNAL_GET((byte)0x07),
    SIGNAL_REPORT((byte)0x08);

    private static final HashMap<Byte, BarrierOperatorCommand> _map = new HashMap<Byte, BarrierOperatorCommand>(8);
    static {
        for (BarrierOperatorCommand value: BarrierOperatorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private BarrierOperatorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static BarrierOperatorCommand valueOf(byte byteValue) {
        BarrierOperatorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BarrierOperatorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

