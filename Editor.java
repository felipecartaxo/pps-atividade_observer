package br.edu.ifpb.padroes;

import java.io.File;

public class Editor {

    //A classe Editor agora encapsula EventManager (private)
    private EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

    // E também oferece métodos subscribe/unsubscribe diretamente
    public void subscribe(String eventType, EventListener listener) {
        events.subscribe(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        events.unsubscribe(eventType, listener);
    }
    public void notify(String eventType, File file) {
        events.notify(eventType, file);
    }
}
