package de.morihofi.nativeagent;

import java.awt.*;

public class SysTray {

    private SystemTray tray = null;
    private TrayIcon trayIcon = null;
    public SysTray() throws AWTException {
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().createImage(SysTray.class.getResource("/icon.png"));

            trayIcon = new TrayIcon(image, "Native Agent");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
        }else {
            System.err.println("Looks like SystemTray is unsupported :-(");
        }
    }

    public void displayTray(String title, String content) throws AWTException {
        //Obtain only one instance of the SystemTray object
        if(tray == null || trayIcon == null){
            throw new UnsupportedOperationException("Feature not supported on this platform");
        }


        trayIcon.displayMessage(title, content, TrayIcon.MessageType.INFO);
    }
}
