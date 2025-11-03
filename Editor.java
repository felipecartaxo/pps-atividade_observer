package br.edu.ifpb.padroes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Editor {

    private File file;

    //A lista de observer agora está em Editor
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public Editor() {
        //Inicializa as listas para cada tipo de evento
        this.listeners.put("open", new ArrayList<>());
        this.listeners.put("save", new ArrayList<>());
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    private void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
