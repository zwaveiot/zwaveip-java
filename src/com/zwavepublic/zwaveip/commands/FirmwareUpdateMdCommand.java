package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* FirmwareUpdateMd commands (version 5) */
public enum FirmwareUpdateMdCommand implements com.zwavepublic.zwaveip.commands.Command {
    FIRMWARE_MD_GET(0x01),
    FIRMWARE_MD_REPORT(0x02),
    GET(0x05),
    REPORT(0x06),
    REQUEST_GET(0x03),
    REQUEST_REPORT(0x04),
    STATUS_REPORT(0x07),
    FIRMWARE_UPDATE_ACTIVATION_SET(0x08),
    FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT(0x09),
    PREPARE_GET(0x0a),
    PREPARE_REPORT(0x0b);

    private static final HashMap<Integer, FirmwareUpdateMdCommand> _map = new HashMap<Integer, FirmwareUpdateMdCommand>(11);
    static {
        for (FirmwareUpdateMdCommand value: FirmwareUpdateMdCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private FirmwareUpdateMdCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static FirmwareUpdateMdCommand valueOf(int intValue) {
        FirmwareUpdateMdCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static FirmwareUpdateMdCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

