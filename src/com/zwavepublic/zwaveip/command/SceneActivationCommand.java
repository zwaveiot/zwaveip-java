package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SceneActivation commands (version 1) */
public enum SceneActivationCommand implements Command {
    SET((byte)0x01);

    private static final HashMap<Byte, SceneActivationCommand> _map = new HashMap<Byte, SceneActivationCommand>(1);
    static {
        for (SceneActivationCommand value: SceneActivationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SceneActivationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SceneActivationCommand valueOf(byte byteValue) {
        SceneActivationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneActivationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

