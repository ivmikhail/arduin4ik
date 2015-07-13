package ivmikhail;

import jssc.*;

/**
 * Created by ivmikhail on 06.07.15.
 */
public class Arduino {

    private static SerialPort serialPort = new SerialPort("/dev/ttyACM0");

    public static void getTemperatureFromSensorAndSend(long chatId) {
        String message = "";
        if (serialPort.isOpened()) {
            message = "Sensor is busy now, try later loh";
        } else {
            try {
                serialPort.openPort();
                //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
                serialPort.setParams(SerialPort.BAUDRATE_9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                //Writes data to port
                serialPort.addEventListener(new PortReader(chatId), SerialPort.MASK_RXCHAR);
                serialPort.writeString("1");
            } catch (SerialPortException ex) {
                ex.printStackTrace();
                message = "Sensor unavailable now, loh";
            }

        }
        if (!message.isEmpty()) {
            Main.sendMessage(chatId, message);
        }
    }

    private static class PortReader implements SerialPortEventListener {
        private long chatId;

        public PortReader(long chatId) {
            this.chatId = chatId;
        }

        @Override
        public void serialEvent(SerialPortEvent event) {
            String message = "";
            try {
                String temperature = serialPort.readString(7, 1000).replace("\n", "");
                message = "Temperature is " + temperature.toString() + "C";
            } catch (SerialPortException | SerialPortTimeoutException ex) {
                ex.printStackTrace();
                message = "Sensor unavailable now, read error";
            } finally {
                try {
                    serialPort.closePort();
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
            }
            if (!message.isEmpty()) {
                Main.sendMessage(chatId, message);
            }
        }
    }
}
