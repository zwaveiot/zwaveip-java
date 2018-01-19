package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* SceneActuatorConf commands (version 1) */
public enum SceneActuatorConfCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01);

    private static final HashMap<Byte, SceneActuatorConfCommand> _map = new HashMap<Byte, SceneActuatorConfCommand>(3);
    static {
        for (SceneActuatorConfCommand value: SceneActuatorConfCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private SceneActuatorConfCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static SceneActuatorConfCommand valueOf(byte byteValue) {
        SceneActuatorConfCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SceneActuatorConfCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

