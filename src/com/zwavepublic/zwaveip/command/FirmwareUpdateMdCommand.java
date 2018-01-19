package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* FirmwareUpdateMd commands (version 5) */
public enum FirmwareUpdateMdCommand implements Command {
    FIRMWARE_MD_GET((byte)0x01),
    FIRMWARE_MD_REPORT((byte)0x02),
    GET((byte)0x05),
    REPORT((byte)0x06),
    REQUEST_GET((byte)0x03),
    REQUEST_REPORT((byte)0x04),
    STATUS_REPORT((byte)0x07),
    FIRMWARE_UPDATE_ACTIVATION_SET((byte)0x08),
    FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT((byte)0x09),
    PREPARE_GET((byte)0x0a),
    PREPARE_REPORT((byte)0x0b);

    private static final HashMap<Byte, FirmwareUpdateMdCommand> _map = new HashMap<Byte, FirmwareUpdateMdCommand>(11);
    static {
        for (FirmwareUpdateMdCommand value: FirmwareUpdateMdCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private FirmwareUpdateMdCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static FirmwareUpdateMdCommand valueOf(byte byteValue) {
        FirmwareUpdateMdCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static FirmwareUpdateMdCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

