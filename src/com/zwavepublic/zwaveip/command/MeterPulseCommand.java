package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MeterPulse commands (version 1) */
public enum MeterPulseCommand implements Command {
    GET((byte)0x04),
    REPORT((byte)0x05);

    private static final HashMap<Byte, MeterPulseCommand> _map = new HashMap<Byte, MeterPulseCommand>(2);
    static {
        for (MeterPulseCommand value: MeterPulseCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MeterPulseCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MeterPulseCommand valueOf(byte byteValue) {
        MeterPulseCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterPulseCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

