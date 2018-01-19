package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ApplicationStatus commands (version 1) */
public enum ApplicationStatusCommand implements Command {
    APPLICATION_BUSY((byte)0x01),
    APPLICATION_REJECTED_REQUEST((byte)0x02);

    private static final HashMap<Byte, ApplicationStatusCommand> _map = new HashMap<Byte, ApplicationStatusCommand>(2);
    static {
        for (ApplicationStatusCommand value: ApplicationStatusCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ApplicationStatusCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ApplicationStatusCommand valueOf(byte byteValue) {
        ApplicationStatusCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ApplicationStatusCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

