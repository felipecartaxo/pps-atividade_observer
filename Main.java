package br.edu.ifpb.padroes;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();

        //Agora usamos os métodos do Editor ao invés de acessar events diretamente
        editor.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.subscribe("save", new EmailNotificationListener("admin@example.com"));
        editor.subscribe("save", new SmsNotificationListener("+55 83 9999-9999"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
