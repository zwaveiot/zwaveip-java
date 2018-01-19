package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SceneControllerConf commands (version 1) */
public enum SceneControllerConfCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, SceneControllerConfCommand> _map = new HashMap<Byte, SceneControllerConfCommand>(3);
    static {
        for (SceneControllerConfCommand value: SceneControllerConfCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SceneControllerConfCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SceneControllerConfCommand valueOf(byte byteValue) {
        SceneControllerConfCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneControllerConfCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

